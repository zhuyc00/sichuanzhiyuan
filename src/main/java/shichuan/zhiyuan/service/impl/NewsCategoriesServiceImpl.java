package shichuan.zhiyuan.service.impl;

import shichuan.zhiyuan.service.NewsCategoriesService;
import shichuan.zhiyuan.entity.po.NewsCategories;
import shichuan.zhiyuan.entity.query.SimplePage;
import shichuan.zhiyuan.entity.query.NewsCategoriesQuery;
import shichuan.zhiyuan.entity.vo.PaginationResultVO;
import shichuan.zhiyuan.enums.PageSize;
import shichuan.zhiyuan.mappers.NewsCategoriesMappers;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description:Service
 * @date:2025-08-24
 * @author: liujun
 */
@Service("NewsCategoriesService")
public class NewsCategoriesServiceImpl implements NewsCategoriesService {

	@Resource
	private NewsCategoriesMappers<NewsCategories, NewsCategoriesQuery> newsCategoriesMappers;

	/**
	 * 根据条件查询列表
	 */
	public List<NewsCategories> findListByParam(NewsCategoriesQuery query) {
		return this.newsCategoriesMappers.selectList(query);
	}

	/**
	 * 根据条件查询数量
	 */
	public Integer findCountByParam(NewsCategoriesQuery query) {
		return this.newsCategoriesMappers.selectCount(query);
	}

	/**
	 * 分页查询
	 */
	public PaginationResultVO<NewsCategories> findByPage(NewsCategoriesQuery query) {
		Integer count = this.findCountByParam(query);
		Integer pageSize = query.getPageSize()==null?PageSize.SIZE15.getSize():query.getPageSize();
		SimplePage page = new SimplePage(query.getPageNo(), count, pageSize);
		query.setSimplePage(page);
		List<NewsCategories> list = this.findListByParam(query);
		PaginationResultVO<NewsCategories> result = new PaginationResultVO(count, page.getPageSize(), page.getPageNo(), page.getPageTotal(), list);
		return result;
	}

	/**
	 * 新增
	 */
	public Integer add(NewsCategories bean) {
		return this.newsCategoriesMappers.insert(bean);
	}

	/**
	 * 批量新增
	 */
	public Integer addBatch(List<NewsCategories> listBean) {
		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.newsCategoriesMappers.insertBatch(listBean);
	}

	/**
	 * 批量新增或更新
	 */
	public Integer addOrUpdateBatch(List<NewsCategories> listBean) {
		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.newsCategoriesMappers.insertOrUpdateBatch(listBean);
	}


	/**
	 * 根据Id查询
	 */
	public NewsCategories getById(Integer id) {
		return this.newsCategoriesMappers.selectById(id);
	}

	/**
	 * 根据Id更新
	 */
	public Integer updateById(NewsCategories bean, Integer id) {
		return this.newsCategoriesMappers.updateById(bean, id);
	}

	/**
	 * 根据Id删除
	 */
	public Integer deleteById(Integer id) {
		return this.newsCategoriesMappers.deleteById(id);
	}

}