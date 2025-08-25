package shichuan.zhiyuan.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import shichuan.zhiyuan.entity.po.VideoInfo;
import shichuan.zhiyuan.entity.query.VideoInfoQuery;
import shichuan.zhiyuan.entity.vo.PaginationResultVO;
import shichuan.zhiyuan.entity.vo.ResponseVO;
import shichuan.zhiyuan.service.VideoInfoService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
import java.util.UUID;

/**
 * @Description:Controller
 * @date:2025-08-22
 * @author: liujun
 */
@RestController
@RequestMapping("/videoInfo")
public class VideoInfoController extends ABaseController {

	@Resource
	private VideoInfoService videoInfoService;

	private static final String WINDOWS_STORAGE_PATH = "D:/Download/";
	private static final String LINUX_STORAGE_PATH = "/var/videos/";

	private String getStoragePath() {
		String os = System.getProperty("os.name").toLowerCase();
		if (os.contains("win")) {
			return WINDOWS_STORAGE_PATH;
		} else {
			return LINUX_STORAGE_PATH;
		}
	}

	private void ensureStorageDirectoryExists() {
		String storagePath = getStoragePath();
		File uploadDir = new File(storagePath);
		if (!uploadDir.exists()) {
			uploadDir.mkdirs();
			System.out.println("创建视频存储目录: " + storagePath);
		}
	}

	@GetMapping("/display1/{fileName}")
	public void displayMp41(HttpServletResponse response, @PathVariable("fileName") String fileName) throws IOException {
		// 获取存储路径
		String storagePath = getStoragePath();
		File file = new File(storagePath + fileName + ".mp4");

		if (!file.exists()) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			response.getOutputStream().close();
			return;
		}

		try (InputStream inStream = new FileInputStream(file);
			 OutputStream outStream = response.getOutputStream()) {

			// 设置响应头
			response.setContentType("video/mp4");
			response.setContentLength((int) file.length());

			// 流式传输视频内容
			byte[] buffer = new byte[4096];
			int bytesRead;
			while ((bytesRead = inStream.read(buffer)) != -1) {
				outStream.write(buffer, 0, bytesRead);
			}
			outStream.flush();
		}
	}

	@PostMapping("/upload")
	public ResponseEntity<String> uploadVideo(@RequestParam("file") MultipartFile file) {
		try {
			// 确保存储目录存在
			ensureStorageDirectoryExists();

			// 检查文件是否为空
			if (file.isEmpty()) {
				return ResponseEntity.badRequest().body("请选择要上传的文件");
			}

			// 检查文件类型
			String contentType = file.getContentType();
			if (contentType == null || !contentType.startsWith("video/")) {
				return ResponseEntity.badRequest().body("只能上传视频文件");
			}

			// 获取原始文件名
			String originalFilename = file.getOriginalFilename();
			if (originalFilename == null || originalFilename.isEmpty()) {
				return ResponseEntity.badRequest().body("文件名无效");
			}

			// 生成存储文件名
			String fileExtension = originalFilename.substring(originalFilename.lastIndexOf("."));
			String storedFileName = UUID.randomUUID().toString() + fileExtension;

			// 获取存储路径
			String storagePath = getStoragePath();

			// 保存文件
			File dest = new File(storagePath, storedFileName);
			file.transferTo(dest);

			// 构建访问URL
			String videoUrl = storedFileName.replace(fileExtension, "");
			return ResponseEntity.ok(videoUrl);
		} catch (IOException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("文件上传失败: " + e.getMessage());
		}
	}

	@RequestMapping("loadDataList")
	public ResponseVO loadDataList(VideoInfoQuery query) {
		return getSuccessResponseVO(videoInfoService.findListByParam(query));
	}

	/**
	 * 新增
	 */
	@RequestMapping("add")
	public ResponseVO add(VideoInfo bean) {
		this.videoInfoService.add(bean);
		return getSuccessResponseVO(null);
	}

	/**
	 * 批量新增
	 */
	@RequestMapping("addBatch")
	public ResponseVO addBatch(@RequestBody List<VideoInfo> listBean) {
		this.videoInfoService.addBatch(listBean);
		return getSuccessResponseVO(null);
	}

	/**
	 * 批量新增或更新
	 */
	@RequestMapping("addOrUpdateBatch")
	public ResponseVO addOrUpdateBatch(@RequestBody List<VideoInfo> listBean) {
		this.videoInfoService.addOrUpdateBatch(listBean);
		return getSuccessResponseVO(null);
	}


	/**
	 * 根据Id查询
	 */
	@GetMapping("getById")
	public ResponseVO getById(Integer id) {
		VideoInfo videoInfo = this.videoInfoService.getById(id);
		ResponseVO successResponseVO = getSuccessResponseVO(videoInfo);
		return successResponseVO;
	}

	/**
	 * 根据Id更新
	 */
	@RequestMapping("updateById")
	public ResponseVO updateById(VideoInfo bean, Integer id) {
		this.videoInfoService.updateById(bean, id);
		return getSuccessResponseVO(null);
	}

	/**
	 * 根据Id删除
	 */
	@RequestMapping("deleteById")
	public ResponseVO deleteById(Integer id) {
		this.videoInfoService.deleteById(id);
		return getSuccessResponseVO(null);
	}

	@RequestMapping("getCount")
	public ResponseVO getCount() {
		Integer count = this.videoInfoService.getCount();
		return getSuccessResponseVO(count);
	}

	@RequestMapping("findByPage")
	public ResponseVO findByPage(VideoInfoQuery query) {
		PaginationResultVO<VideoInfo> result = videoInfoService.findByPage(query);
		return getSuccessResponseVO(result);
	}
}