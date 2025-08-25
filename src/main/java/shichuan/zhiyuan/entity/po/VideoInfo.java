package shichuan.zhiyuan.entity.po;

import java.io.Serializable;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @Description:
 * @date:2025-08-24
 * @author: liujun
 */
public class VideoInfo implements Serializable {
	/**
	 * ID
	 */
	private Integer id;

	/**
	 * 
	 */
	private String title;

	/**
	 * 
	 */
	private String description;

	/**
	 * 
	 */
	private String category;

	/**
	 * URL
	 */
	private String videoUrl;

	/**
	 * 创建时间（自动生成）
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;

	/**
	 * 更新时间（自动更新）
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date updateTime;


	public void setId(Integer id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getId() {
		return this.id;
	}

	public String getTitle() {
		return this.title;
	}

	public String getDescription() {
		return this.description;
	}

	public String getCategory() {
		return this.category;
	}

	public String getVideoUrl() {
		return this.videoUrl;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public Date getUpdateTime() {
		return this.updateTime;
	}

	@Override
	public String toString() {
		return "ID:" + (id == null ? "null" : id) + ",:" + (title == null ? "null" : title) + ",:" + (description == null ? "null" : description) + ",:" + (category == null ? "null" : category) + ",URL:" + (videoUrl == null ? "null" : videoUrl) + ",创建时间（自动生成）:" + (createTime == null ? "null" : createTime) + ",更新时间（自动更新）:" + (updateTime == null ? "null" : updateTime);
	}
}