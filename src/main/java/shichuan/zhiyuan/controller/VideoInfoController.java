package shichuan.zhiyuan.controller;

import shichuan.zhiyuan.entity.po.VideoInfo;
import shichuan.zhiyuan.entity.query.VideoInfoQuery;
import shichuan.zhiyuan.entity.vo.ResponseVO;
import shichuan.zhiyuan.service.VideoInfoService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

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
	@RequestMapping("getById")
	public ResponseVO getById(Integer id) {
		return getSuccessResponseVO(this.videoInfoService.getById(id));
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

}