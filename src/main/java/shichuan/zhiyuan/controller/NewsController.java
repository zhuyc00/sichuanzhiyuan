package shichuan.zhiyuan.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import shichuan.zhiyuan.entity.po.News;
import shichuan.zhiyuan.entity.po.VideoInfo;
import shichuan.zhiyuan.entity.query.NewsQuery;
import shichuan.zhiyuan.entity.query.VideoInfoQuery;
import shichuan.zhiyuan.entity.vo.PaginationResultVO;
import shichuan.zhiyuan.entity.vo.ResponseVO;
import shichuan.zhiyuan.exception.BusinessException;
import shichuan.zhiyuan.service.NewsService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Files;
import java.util.List;
import java.util.UUID;

/**
 * @Description:Controller
 * @date:2025-08-24
 * @author: liujun
 */
@RestController
@RequestMapping("/news")
public class NewsController extends ABaseController {

	@Resource
	private NewsService newsService;

	// 新增图片存储路径配置
	private static final String WINDOWS_IMAGE_PATH = "D:/news_images/";
	private static final String LINUX_IMAGE_PATH = "/var/news_images/";

	// 获取图片存储路径
	private String getImageStoragePath() {
		String os = System.getProperty("os.name").toLowerCase();
		return os.contains("win") ? WINDOWS_IMAGE_PATH : LINUX_IMAGE_PATH;
	}

	// 确保目录存在
	private void ensureImageDirExists() {
		File imageDir = new File(getImageStoragePath());
		if (!imageDir.exists()) {
			imageDir.mkdirs();
			System.out.println("创建新闻图片目录: " + imageDir.getAbsolutePath());
		}
	}

	// 新增图片上传接口
	@PostMapping("/uploadImage")
	public ResponseVO uploadImage(@RequestParam("file") MultipartFile file) throws BusinessException {
		try {
			ensureImageDirExists();

			if (file.isEmpty()) {
				return getBusinessErrorResponseVO(new BusinessException(500, "请选择要上传的图片") );
			}

			// 验证图片类型
			String contentType = file.getContentType();
			if (contentType == null || !contentType.startsWith("image/")) {
				return getBusinessErrorResponseVO(new BusinessException(500, "仅支持图片格式（JPEG/PNG/GIF等）"));
			}

			// 生成唯一文件名
			String originalFilename = file.getOriginalFilename();
			String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
			String storedFileName = UUID.randomUUID() + extension;

			// 保存文件
			File dest = new File(getImageStoragePath() + storedFileName);
			file.transferTo(dest);

			// 返回相对访问路径
			String imageUrl = storedFileName;
			return getSuccessResponseVO(imageUrl);

		} catch (IOException e) {
			throw new BusinessException(e);
		}
	}

	// 新增图片显示接口
	@GetMapping("/displayImage/{fileName}")
	public void displayImage(HttpServletResponse response,
							 @PathVariable String fileName) throws IOException {
		File imageFile = new File(getImageStoragePath() + fileName);

		if (!imageFile.exists()) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}

		// 设置响应头
		response.setContentType("image/" + getFileExtension(fileName));
		response.setContentLength((int) imageFile.length());

		// 流式输出
		try (InputStream in = Files.newInputStream(imageFile.toPath());
			 OutputStream out = response.getOutputStream()) {
			byte[] buffer = new byte[4096];
			int bytesRead;
			while ((bytesRead = in.read(buffer)) != -1) {
				out.write(buffer, 0, bytesRead);
			}
		}
	}

	private String getFileExtension(String fileName) {
		return fileName.substring(fileName.lastIndexOf(".") + 1);
	}

	@RequestMapping("loadDataList")
	public ResponseVO loadDataList(NewsQuery query) {
		return getSuccessResponseVO(newsService.findListByParam(query));
	}

	/**
	 * 新增
	 */
	@RequestMapping("add")
	public ResponseVO add(News bean) {
		this.newsService.add(bean);
		return getSuccessResponseVO(null);
	}

	/**
	 * 批量新增
	 */
	@RequestMapping("addBatch")
	public ResponseVO addBatch(@RequestBody List<News> listBean) {
		this.newsService.addBatch(listBean);
		return getSuccessResponseVO(null);
	}

	/**
	 * 批量新增或更新
	 */
	@RequestMapping("addOrUpdateBatch")
	public ResponseVO addOrUpdateBatch(@RequestBody List<News> listBean) {
		this.newsService.addOrUpdateBatch(listBean);
		return getSuccessResponseVO(null);
	}


	/**
	 * 根据Id查询
	 */
	@RequestMapping("getById")
	public ResponseVO getById(Integer id) {
		return getSuccessResponseVO(this.newsService.getById(id));
	}

	/**
	 * 根据Id更新
	 */
	@RequestMapping("updateById")
	public ResponseVO updateById(News bean, Integer id) {
		this.newsService.updateById(bean, id);
		return getSuccessResponseVO(null);
	}

	/**
	 * 根据Id删除
	 */
	@RequestMapping("deleteById")
	public ResponseVO deleteById(Integer id) {
		this.newsService.deleteById(id);
		return getSuccessResponseVO(null);
	}

	@RequestMapping("findByPage")
	public ResponseVO findByPage(NewsQuery query) {
		PaginationResultVO<News> result = newsService.findByPage(query);
		return getSuccessResponseVO(result);
	}
}