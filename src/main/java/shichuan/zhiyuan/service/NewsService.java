package shichuan.zhiyuan.service;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import shichuan.zhiyuan.entity.po.News;
import shichuan.zhiyuan.entity.query.NewsQuery;
import shichuan.zhiyuan.entity.vo.PaginationResultVO;

import java.util.List;
/**
 * @Description:Service
 * @date:2025-08-24
 * @author: liujun
 */
public interface NewsService { 

	/**
	 * 根据条件查询列表
	 */
	List<News> findListByParam(NewsQuery query);

	/**
	 * 根据条件查询数量
	 */
	Integer findCountByParam(NewsQuery query);

	/**
	 * 分页查询
	 */
	PaginationResultVO<News> findByPage(NewsQuery query);

	/**
	 * 新增
	 */
	Integer add(News bean);

	/**
	 * 批量新增
	 */
	Integer addBatch(List<News> listBean);

	/**
	 * 批量新增或更新
	 */
	Integer addOrUpdateBatch(List<News> listBean);


	/**
	 * 根据Id查询
	 */
	News getById(Integer id);

	/**
	 * 根据Id更新
	 */
	Integer updateById(News bean, Integer id);

	/**
	 * 根据Id删除
	 */
	Integer deleteById(Integer id);

}