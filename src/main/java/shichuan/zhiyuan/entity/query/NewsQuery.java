package shichuan.zhiyuan.entity.query;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Description:查询对象
 * @date:2025-08-24
 * @author: liujun
 */
public class NewsQuery extends BaseQuery{
	/**
	 * 
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
	private String content;

	private String contentFuzzy;

	/**
	 * 
	 */
	private String summary;

	private String summaryFuzzy;

	/**
	 * 
	 */
	private String imageUrl;

	private String imageUrlFuzzy;

	/**
	 * 
	 */
	private Integer categoryId;

	/**
	 * 
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date publishTime;

	private String publishTimeStart;

	private String publishTimeEnd;

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

	private String authorFuzzy;

	/**
	 * 
	 */
	private String source;

	private String sourceFuzzy;

	/**
	 * 
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createdAt;

	private String createdAtStart;

	private String createdAtEnd;

	/**
	 * 
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date updatedAt;

	private String updatedAtStart;

	private String updatedAtEnd;

	public void setTitleFuzzy(String titleFuzzy) {
		this.titleFuzzy = titleFuzzy;
	}

	public String getTitleFuzzy() {
		return this.titleFuzzy;
	}

	public void setContentFuzzy(String contentFuzzy) {
		this.contentFuzzy = contentFuzzy;
	}

	public String getContentFuzzy() {
		return this.contentFuzzy;
	}

	public void setSummaryFuzzy(String summaryFuzzy) {
		this.summaryFuzzy = summaryFuzzy;
	}

	public String getSummaryFuzzy() {
		return this.summaryFuzzy;
	}

	public void setImageUrlFuzzy(String imageUrlFuzzy) {
		this.imageUrlFuzzy = imageUrlFuzzy;
	}

	public String getImageUrlFuzzy() {
		return this.imageUrlFuzzy;
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

	public void setAuthorFuzzy(String authorFuzzy) {
		this.authorFuzzy = authorFuzzy;
	}

	public String getAuthorFuzzy() {
		return this.authorFuzzy;
	}

	public void setSourceFuzzy(String sourceFuzzy) {
		this.sourceFuzzy = sourceFuzzy;
	}

	public String getSourceFuzzy() {
		return this.sourceFuzzy;
	}

	public void setCreatedAtStart(String createdAtStart) {
		this.createdAtStart = createdAtStart;
	}

	public String getCreatedAtStart() {
		return this.createdAtStart;
	}

	public void setCreatedAtEnd(String createdAtEnd) {
		this.createdAtEnd = createdAtEnd;
	}

	public String getCreatedAtEnd() {
		return this.createdAtEnd;
	}

	public void setUpdatedAtStart(String updatedAtStart) {
		this.updatedAtStart = updatedAtStart;
	}

	public String getUpdatedAtStart() {
		return this.updatedAtStart;
	}

	public void setUpdatedAtEnd(String updatedAtEnd) {
		this.updatedAtEnd = updatedAtEnd;
	}

	public String getUpdatedAtEnd() {
		return this.updatedAtEnd;
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

	public void setContent(String content) {
		this.content = content;
	}

	public String getContent() {
		return this.content;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getSummary() {
		return this.summary;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getImageUrl() {
		return this.imageUrl;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public Integer getCategoryId() {
		return this.categoryId;
	}

	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}

	public Date getPublishTime() {
		return this.publishTime;
	}

	public void setReadCount(Integer readCount) {
		this.readCount = readCount;
	}

	public Integer getReadCount() {
		return this.readCount;
	}

	public void setIsHot(Integer isHot) {
		this.isHot = isHot;
	}

	public Integer getIsHot() {
		return this.isHot;
	}

	public void setIsPublished(Integer isPublished) {
		this.isPublished = isPublished;
	}

	public Integer getIsPublished() {
		return this.isPublished;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getSource() {
		return this.source;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Date getUpdatedAt() {
		return this.updatedAt;
	}

}