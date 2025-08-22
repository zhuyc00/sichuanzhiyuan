package shichuan.zhiyuan.service;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import shichuan.zhiyuan.entity.po.VideoInfo;
import shichuan.zhiyuan.entity.query.VideoInfoQuery;
import shichuan.zhiyuan.entity.vo.PaginationResultVO;

import java.util.List;
/**
 * @Description:Service
 * @date:2025-08-22
 * @author: liujun
 */
public interface VideoInfoService { 

	/**
	 * 根据条件查询列表
	 */
	List<VideoInfo> findListByParam(VideoInfoQuery query);

	/**
	 * 根据条件查询数量
	 */
	Integer findCountByParam(VideoInfoQuery query);

	/**
	 * 分页查询
	 */
	PaginationResultVO<VideoInfo> findByPage(VideoInfoQuery query);

	/**
	 * 新增
	 */
	Integer add(VideoInfo bean);

	/**
	 * 批量新增
	 */
	Integer addBatch(List<VideoInfo> listBean);

	/**
	 * 批量新增或更新
	 */
	Integer addOrUpdateBatch(List<VideoInfo> listBean);


	/**
	 * 根据Id查询
	 */
	VideoInfo getById(Integer id);

	/**
	 * 根据Id更新
	 */
	Integer updateById(VideoInfo bean, Integer id);

	/**
	 * 根据Id删除
	 */
	Integer deleteById(Integer id);

}