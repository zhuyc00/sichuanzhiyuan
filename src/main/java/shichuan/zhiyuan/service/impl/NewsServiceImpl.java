package shichuan.zhiyuan.service.impl;

import shichuan.zhiyuan.service.NewsService;
import shichuan.zhiyuan.entity.po.News;
import shichuan.zhiyuan.entity.query.SimplePage;
import shichuan.zhiyuan.entity.query.NewsQuery;
import shichuan.zhiyuan.entity.vo.PaginationResultVO;
import shichuan.zhiyuan.enums.PageSize;
import shichuan.zhiyuan.mappers.NewsMappers;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.util.List;

/**
 * @Description:Service
 * @date:2025-08-24
 * @author: liujun
 */
@Service("NewsService")
public class NewsServiceImpl implements NewsService {

	@Resource
	private NewsMappers<News, NewsQuery> newsMappers;

	/**
	 * 根据条件查询列表
	 */
	public List<News> findListByParam(NewsQuery query) {
		return this.newsMappers.selectList(query);
	}

	/**
	 * 根据条件查询数量
	 */
	public Integer findCountByParam(NewsQuery query) {
		return this.newsMappers.selectCount(query);
	}

	/**
	 * 分页查询
	 */
	public PaginationResultVO<News> findByPage(NewsQuery query) {
		Integer count = this.findCountByParam(query);
		Integer pageSize = query.getPageSize()==null?PageSize.SIZE15.getSize():query.getPageSize();
		SimplePage page = new SimplePage(query.getPageNo(), count, pageSize);
		query.setSimplePage(page);
		List<News> list = this.findListByParam(query);
		PaginationResultVO<News> result = new PaginationResultVO(count, page.getPageSize(), page.getPageNo(), page.getPageTotal(), list);
		return result;
	}

	/**
	 * 新增
	 */
	@Override
	public Integer add(News bean) {
		return this.newsMappers.insert(bean);
	}

	/**
	 * 批量新增
	 */
	public Integer addBatch(List<News> listBean) {
		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.newsMappers.insertBatch(listBean);
	}

	/**
	 * 批量新增或更新
	 */
	public Integer addOrUpdateBatch(List<News> listBean) {
		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.newsMappers.insertOrUpdateBatch(listBean);
	}


	/**
	 * 根据Id查询
	 */
	public News getById(Integer id) {
		return this.newsMappers.selectById(id);
	}

	/**
	 * 根据Id更新
	 */
	public Integer updateById(News bean, Integer id) {
		return this.newsMappers.updateById(bean, id);
	}

	/**
	 * 根据Id删除（同时删除数据库记录和磁盘图片）
	 */
	@Override
	public Integer deleteById(Integer id) {
		// 1. 查询新闻信息
		News news = this.newsMappers.selectById(id);
		if (news == null) {
			return 0;
		}

		// 2. 删除数据库记录
		int deleteCount = this.newsMappers.deleteById(id);
		if (deleteCount <= 0) {
			return 0;
		}

		// 3. 处理图片删除
		String imageUrl = news.getImageUrl();
		if (imageUrl == null || imageUrl.isEmpty()) {
			System.out.println("新闻图片URL为空，无需删除文件");
			return deleteCount;
		}

		// 4. 解析URL获取文件名
		String fileName = extractFileNameFromUrl(imageUrl);
		if (fileName == null) {
			System.err.println("无法解析图片URL：" + imageUrl);
			return deleteCount;
		}

		// 5. 获取图片存储路径
		String storagePath = getImageStoragePath();

		// 6. 构建完整文件路径（支持多种图片格式）
		File imageFile = resolveImageFile(storagePath, fileName);

		// 7. 执行文件删除
		deleteImageFile(imageFile);

		return deleteCount;
	}

// 新增工具方法 --------------------------------------------------
	/**
	 * 从URL中提取文件名（如从"/news/images/xxx"中提取"xxx"）
	 */
	private String extractFileNameFromUrl(String imageUrl) {
		// 示例URL格式: /news/displayImage/abc123.jpg
		String prefix = "/news/displayImage/";

		// 检查URL是否包含前缀
		if (imageUrl.startsWith(prefix)) {
			return imageUrl.substring(prefix.length());
		}

		// 如果URL是完整路径（如http://example.com/news/displayImage/abc123.jpg）
		int lastSlashIndex = imageUrl.lastIndexOf("/");
		if (lastSlashIndex != -1 && lastSlashIndex < imageUrl.length() - 1) {
			return imageUrl.substring(lastSlashIndex + 1);
		}

		return null;
	}

	/**
	 * 获取图片存储路径
	 */
	private String getImageStoragePath() {
		String os = System.getProperty("os.name").toLowerCase();
		if (os.contains("win")) {
			return "D:/news_images/";
		} else {
			return "/var/news_images/";
		}
	}

	/**
	 * 解析图片文件对象（支持多格式）
	 */
	private File resolveImageFile(String storagePath, String fileName) {
		// 常见图片扩展名列表
		String[] extensions = {".jpg", ".jpeg", ".png", ".gif", ".bmp"};

		// 优先检查完整文件名是否包含扩展名
		if (fileName.contains(".")) {
			return new File(storagePath + fileName);
		}

		// 无扩展名时尝试匹配
		for (String ext : extensions) {
			File file = new File(storagePath + fileName + ext);
			if (file.exists()) {
				return file;
			}
		}

		// 默认使用.jpg
		return new File(storagePath + fileName + ".jpg");
	}

	/**
	 * 安全删除图片文件
	 */
	private void deleteImageFile(File imageFile) {
		if (imageFile.exists() && imageFile.isFile()) {
			boolean deleted = imageFile.delete();
			if (deleted) {
				System.out.println("图片删除成功: " + imageFile.getAbsolutePath());
			} else {
				System.err.println("图片删除失败（可能无权限）: " + imageFile.getAbsolutePath());
			}
		} else {
			System.err.println("图片文件不存在: " + imageFile.getAbsolutePath());
		}
	}

}