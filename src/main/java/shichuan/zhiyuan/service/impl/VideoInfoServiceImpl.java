package shichuan.zhiyuan.service.impl;


import shichuan.zhiyuan.service.VideoInfoService;
import shichuan.zhiyuan.entity.po.VideoInfo;
import shichuan.zhiyuan.entity.query.SimplePage;
import shichuan.zhiyuan.entity.query.VideoInfoQuery;
import shichuan.zhiyuan.entity.vo.PaginationResultVO;
import shichuan.zhiyuan.enums.PageSize;
import shichuan.zhiyuan.mappers.VideoInfoMappers;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description:Service
 * @date:2025-08-22
 * @author: liujun
 */
@Service("VideoInfoService")
public class VideoInfoServiceImpl implements VideoInfoService {

	@Resource
	private VideoInfoMappers<VideoInfo, VideoInfoQuery> videoInfoMappers;

	/**
	 * 根据条件查询列表
	 */
	public List<VideoInfo> findListByParam(VideoInfoQuery query) {
		return this.videoInfoMappers.selectList(query);
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
	public VideoInfo getById(Integer id) {
		return this.videoInfoMappers.selectById(id);
	}

	/**
	 * 根据Id更新
	 */
	public Integer updateById(VideoInfo bean, Integer id) {
		return this.videoInfoMappers.updateById(bean, id);
	}

	/**
	 * 根据Id删除
	 */
	public Integer deleteById(Integer id) {
		return this.videoInfoMappers.deleteById(id);
	}

}