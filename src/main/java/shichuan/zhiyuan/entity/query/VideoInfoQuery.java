package shichuan.zhiyuan.entity.query;

import java.util.Date;

/**
 * @Description:查询对象
 * @date:2025-08-22
 * @author: liujun
 */
public class VideoInfoQuery extends BaseQuery{
	/**
	 * ID
	 */
	private Integer id;

	/**
	 * 
	 */
	private String title;

	private String titleFuzzy;

	/**
	 * 
	 */
	private String description;

	private String descriptionFuzzy;

	/**
	 * 
	 */
	private String category;

	private String categoryFuzzy;

	/**
	 * URL
	 */
	private String videoUrl;

	private String videoUrlFuzzy;

	/**
	 * 
	 */
	private Integer duration;

	/**
	 * 
	 */
	private Date publishTime;

	private String publishTimeStart;

	private String publishTimeEnd;

	public void setTitleFuzzy(String titleFuzzy) {
		this.titleFuzzy = titleFuzzy;
	}

	public String getTitleFuzzy() {
		return this.titleFuzzy;
	}

	public void setDescriptionFuzzy(String descriptionFuzzy) {
		this.descriptionFuzzy = descriptionFuzzy;
	}

	public String getDescriptionFuzzy() {
		return this.descriptionFuzzy;
	}

	public void setCategoryFuzzy(String categoryFuzzy) {
		this.categoryFuzzy = categoryFuzzy;
	}

	public String getCategoryFuzzy() {
		return this.categoryFuzzy;
	}

	public void setVideoUrlFuzzy(String videoUrlFuzzy) {
		this.videoUrlFuzzy = videoUrlFuzzy;
	}

	public String getVideoUrlFuzzy() {
		return this.videoUrlFuzzy;
	}

	public void setPublishTimeStart(String publishTimeStart) {
		this.publishTimeStart = publishTimeStart;
	}

	public String getPublishTimeStart() {
		return this.publishTimeStart;
	}

	public void setPublishTimeEnd(String publishTimeEnd) {
		this.publishTimeEnd = publishTimeEnd;
	}

	public String getPublishTimeEnd() {
		return this.publishTimeEnd;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return this.id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return this.title;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return this.description;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCategory() {
		return this.category;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	public String getVideoUrl() {
		return this.videoUrl;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public Integer getDuration() {
		return this.duration;
	}

	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}

	public Date getPublishTime() {
		return this.publishTime;
	}

}