package shichuan.zhiyuan.service;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import shichuan.zhiyuan.entity.po.NewsCategories;
import shichuan.zhiyuan.entity.query.NewsCategoriesQuery;
import shichuan.zhiyuan.entity.vo.PaginationResultVO;

import java.util.List;
/**
 * @Description:Service
 * @date:2025-08-24
 * @author: liujun
 */
public interface NewsCategoriesService { 

	/**
	 * 根据条件查询列表
	 */
	List<NewsCategories> findListByParam(NewsCategoriesQuery query);

	/**
	 * 根据条件查询数量
	 */
	Integer findCountByParam(NewsCategoriesQuery query);

	/**
	 * 分页查询
	 */
	PaginationResultVO<NewsCategories> findByPage(NewsCategoriesQuery query);

	/**
	 * 新增
	 */
	Integer add(NewsCategories bean);

	/**
	 * 批量新增
	 */
	Integer addBatch(List<NewsCategories> listBean);

	/**
	 * 批量新增或更新
	 */
	Integer addOrUpdateBatch(List<NewsCategories> listBean);


	/**
	 * 根据Id查询
	 */
	NewsCategories getById(Integer id);

	/**
	 * 根据Id更新
	 */
	Integer updateById(NewsCategories bean, Integer id);

	/**
	 * 根据Id删除
	 */
	Integer deleteById(Integer id);

}