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
public class News implements Serializable {
	/**
	 * 
	 */
	private Integer id;

	/**
	 * 
	 */
	private String title;

	/**
	 * 
	 */
	private String content;

	/**
	 * 
	 */
	private String summary;

	/**
	 * 
	 */
	private String imageUrl;

	/**
	 * 
	 */
	private Integer categoryId;

	/**
	 * 
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date publishTime;

	/**
	 * 
	 */
	private Integer readCount;

	/**
	 * 
	 */
	private Integer isHot;

	/**
	 * 
	 */
	private Integer isPublished;

	/**
	 * 
	 */
	private String author;

	/**
	 * 
	 */
	private String source;

	/**
	 * 
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createdAt;

	/**
	 * 
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date updatedAt;


	public void setId(Integer id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}

	public void setReadCount(Integer readCount) {
		this.readCount = readCount;
	}

	public void setIsHot(Integer isHot) {
		this.isHot = isHot;
	}

	public void setIsPublished(Integer isPublished) {
		this.isPublished = isPublished;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Integer getId() {
		return this.id;
	}

	public String getTitle() {
		return this.title;
	}

	public String getContent() {
		return this.content;
	}

	public String getSummary() {
		return this.summary;
	}

	public String getImageUrl() {
		return this.imageUrl;
	}

	public Integer getCategoryId() {
		return this.categoryId;
	}

	public Date getPublishTime() {
		return this.publishTime;
	}

	public Integer getReadCount() {
		return this.readCount;
	}

	public Integer getIsHot() {
		return this.isHot;
	}

	public Integer getIsPublished() {
		return this.isPublished;
	}

	public String getAuthor() {
		return this.author;
	}

	public String getSource() {
		return this.source;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public Date getUpdatedAt() {
		return this.updatedAt;
	}

	@Override
	public String toString() {
		return ":" + (id == null ? "null" : id) + ",:" + (title == null ? "null" : title) + ",:" + (content == null ? "null" : content) + ",:" + (summary == null ? "null" : summary) + ",:" + (imageUrl == null ? "null" : imageUrl) + ",:" + (categoryId == null ? "null" : categoryId) + ",:" + (publishTime == null ? "null" : publishTime) + ",:" + (readCount == null ? "null" : readCount) + ",:" + (isHot == null ? "null" : isHot) + ",:" + (isPublished == null ? "null" : isPublished) + ",:" + (author == null ? "null" : author) + ",:" + (source == null ? "null" : source) + ",:" + (createdAt == null ? "null" : createdAt) + ",:" + (updatedAt == null ? "null" : updatedAt);
	}
}