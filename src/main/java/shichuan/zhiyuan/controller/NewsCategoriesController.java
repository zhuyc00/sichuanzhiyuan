package shichuan.zhiyuan.controller;

import shichuan.zhiyuan.entity.po.NewsCategories;
import shichuan.zhiyuan.entity.query.NewsCategoriesQuery;
import shichuan.zhiyuan.entity.vo.ResponseVO;
import shichuan.zhiyuan.service.NewsCategoriesService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description:Controller
 * @date:2025-08-24
 * @author: liujun
 */
@RestController
@RequestMapping("/newsCategories")
public class NewsCategoriesController extends ABaseController {

	@Resource
	private NewsCategoriesService newsCategoriesService;

	@RequestMapping("loadDataList")
	public ResponseVO loadDataList(NewsCategoriesQuery query) {
		return getSuccessResponseVO(newsCategoriesService.findListByParam(query));
	}

	/**
	 * 新增
	 */
	@RequestMapping("add")
	public ResponseVO add(NewsCategories bean) {
		this.newsCategoriesService.add(bean);
		return getSuccessResponseVO(null);
	}

	/**
	 * 批量新增
	 */
	@RequestMapping("addBatch")
	public ResponseVO addBatch(@RequestBody List<NewsCategories> listBean) {
		this.newsCategoriesService.addBatch(listBean);
		return getSuccessResponseVO(null);
	}

	/**
	 * 批量新增或更新
	 */
	@RequestMapping("addOrUpdateBatch")
	public ResponseVO addOrUpdateBatch(@RequestBody List<NewsCategories> listBean) {
		this.newsCategoriesService.addOrUpdateBatch(listBean);
		return getSuccessResponseVO(null);
	}

	/**
	 * 根据Id查询
	 */
	@RequestMapping("getById")
	public ResponseVO getById(Integer id) {
		return getSuccessResponseVO(this.newsCategoriesService.getById(id));
	}

	/**
	 * 根据Id更新
	 */
	@RequestMapping("updateById")
	public ResponseVO updateById(NewsCategories bean, Integer id) {
		this.newsCategoriesService.updateById(bean, id);
		return getSuccessResponseVO(null);
	}

	/**
	 * 根据Id删除
	 */
	@RequestMapping("deleteById")
	public ResponseVO deleteById(Integer id) {
		this.newsCategoriesService.deleteById(id);
		return getSuccessResponseVO(null);
	}

}