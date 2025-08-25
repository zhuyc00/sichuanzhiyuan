package shichuan.zhiyuan.entity.query;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Description:查询对象
 * @date:2025-08-24
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
	 * 创建时间（自动生成）
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;

	private String createTimeStart;

	private String createTimeEnd;

	/**
	 * 更新时间（自动更新）
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date updateTime;

	private String updateTimeStart;

	private String updateTimeEnd;

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

	public void setCreateTimeStart(String createTimeStart) {
		this.createTimeStart = createTimeStart;
	}

	public String getCreateTimeStart() {
		return this.createTimeStart;
	}

	public void setCreateTimeEnd(String createTimeEnd) {
		this.createTimeEnd = createTimeEnd;
	}

	public String getCreateTimeEnd() {
		return this.createTimeEnd;
	}

	public void setUpdateTimeStart(String updateTimeStart) {
		this.updateTimeStart = updateTimeStart;
	}

	public String getUpdateTimeStart() {
		return this.updateTimeStart;
	}

	public void setUpdateTimeEnd(String updateTimeEnd) {
		this.updateTimeEnd = updateTimeEnd;
	}

	public String getUpdateTimeEnd() {
		return this.updateTimeEnd;
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

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Date getUpdateTime() {
		return this.updateTime;
	}

}