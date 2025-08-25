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
	 * 根据Id删除
	 */
	public Integer deleteById(Integer id) {
		return this.newsMappers.deleteById(id);
	}

}