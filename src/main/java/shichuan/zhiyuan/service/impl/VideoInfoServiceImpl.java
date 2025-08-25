package shichuan.zhiyuan.service.impl;

import org.springframework.stereotype.Service;
import shichuan.zhiyuan.entity.po.VideoInfo;
import shichuan.zhiyuan.entity.query.SimplePage;
import shichuan.zhiyuan.entity.query.VideoInfoQuery;
import shichuan.zhiyuan.entity.vo.PaginationResultVO;
import shichuan.zhiyuan.enums.PageSize;
import shichuan.zhiyuan.mappers.VideoInfoMappers;
import shichuan.zhiyuan.service.VideoInfoService;

import javax.annotation.Resource;
import java.io.File;
import java.util.List;

/**
 * @Description:Service
 * @date:2025-08-24
 * @author: liujun
 */
@Service("VideoInfoService")
public class VideoInfoServiceImpl implements VideoInfoService {

	@Resource
	private VideoInfoMappers<VideoInfo, VideoInfoQuery> videoInfoMappers;

	/**
	 * 根据条件查询列表
	 */
	@Override
	public List<VideoInfo> findListByParam(VideoInfoQuery query) {
		List list = this.videoInfoMappers.selectList(query);
		return list;
	}

	/**
	 * 根据条件查询数量
	 */
	public Integer findCountByParam(VideoInfoQuery query) {
		return this.videoInfoMappers.selectCount(query);
	}

	/**
	 * 分页查询
	 */
	@Override
	public PaginationResultVO<VideoInfo> findByPage(VideoInfoQuery query) {
		Integer count = this.findCountByParam(query);
		Integer pageSize = query.getPageSize()==null?PageSize.SIZE15.getSize():query.getPageSize();
		SimplePage page = new SimplePage(query.getPageNo(), count, pageSize);
		query.setSimplePage(page);
		List<VideoInfo> list = this.findListByParam(query);
		PaginationResultVO<VideoInfo> result = new PaginationResultVO(count, page.getPageSize(), page.getPageNo(), page.getPageTotal(), list);
		return result;
	}

	/**
	 * 新增
	 */
	public Integer add(VideoInfo bean) {
		return this.videoInfoMappers.insert(bean);
	}

	/**
	 * 批量新增
	 */
	public Integer addBatch(List<VideoInfo> listBean) {
		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.videoInfoMappers.insertBatch(listBean);
	}

	/**
	 * 批量新增或更新
	 */
	public Integer addOrUpdateBatch(List<VideoInfo> listBean) {
		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.videoInfoMappers.insertOrUpdateBatch(listBean);
	}


	/**
	 * 根据Id查询
	 */
	@Override
	public VideoInfo getById(Integer id) {
		VideoInfo videoInfo = this.videoInfoMappers.selectById(id);
		return videoInfo;
	}

	/**
	 * 根据Id更新
	 */
	public Integer updateById(VideoInfo bean, Integer id) {
		return this.videoInfoMappers.updateById(bean, id);
	}

	/**
	 * 根据Id删除（同时删除数据库记录和磁盘文件）
	 */
	@Override
	public Integer deleteById(Integer id) {
		// 1. 查询视频信息
		VideoInfo videoInfo = this.videoInfoMappers.selectById(id);
		if (videoInfo == null) {
			return 0; // 没有对应记录，返回0
		}

		// 2. 删除数据库记录
		int deleteCount = this.videoInfoMappers.deleteById(id);
		if (deleteCount <= 0) {
			return 0; // 数据库删除失败
		}

		// 3. 处理文件删除
		String videoUrl = videoInfo.getVideoUrl(); // 从数据库获取存储的URL（如"/videoInfo/display1/1df9584a..."）
		if (videoUrl == null || videoUrl.isEmpty()) {
			System.out.println("视频URL为空，无需删除文件");
			return deleteCount;
		}

		// 4. 解析URL获取文件名（提取display1后的部分）
		String fileName = extractFileNameFromUrl(videoUrl);
		if (fileName == null) {
			System.err.println("无法解析视频URL：" + videoUrl);
			return deleteCount;
		}

		// 5. 获取文件存储路径（与Controller保持一致）
		String storagePath = getStoragePath();

		// 6. 构建完整文件路径（参考display1接口：路径 + 文件名 + .mp4）
		File videoFile = new File(storagePath + fileName + ".mp4");

		// 7. 执行文件删除
		if (videoFile.exists() && videoFile.isFile()) {
			boolean deleted = videoFile.delete();
			if (deleted) {
				System.out.println("磁盘文件删除成功：" + videoFile.getAbsolutePath());
			} else {
				System.err.println("磁盘文件删除失败（可能无权限）：" + videoFile.getAbsolutePath());
			}
		} else {
			System.err.println("磁盘文件不存在：" + videoFile.getAbsolutePath());
		}

		return deleteCount;
	}

	/**
	 * 从URL中提取文件名（如从"/videoInfo/display1/xxx"中提取"xxx"）
	 */
	private String extractFileNameFromUrl(String videoUrl) {
		String[] parts = videoUrl.split("/display1/");
		if (parts.length == 2) {
			return parts[1]; // 取分割后的第二部分，即文件名
		}
		return null;
	}

	/**
	 * 获取文件存储路径
	 */
	private String getStoragePath() {
		String os = System.getProperty("os.name").toLowerCase();
		if (os.contains("win")) {
			return "D:/Download/";
		} else {
			return "/var/videos/";
		}
	}

	@Override
	public Integer getCount() {
		return this.videoInfoMappers.getCount();
	}

}