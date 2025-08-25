package shichuan.zhiyuan.entity.query;

import java.util.Date;

/**
 * @Description:查询对象
 * @date:2025-08-24
 * @author: liujun
 */
public class NewsCategoriesQuery extends BaseQuery{
	/**
	 * 
	 */
	private Integer id;

	/**
	 * 
	 */
	private String name;

	private String nameFuzzy;

	/**
	 * 
	 */
	private String description;

	private String descriptionFuzzy;

	/**
	 * 
	 */
	private Date createdAt;

	private String createdAtStart;

	private String createdAtEnd;

	public void setNameFuzzy(String nameFuzzy) {
		this.nameFuzzy = nameFuzzy;
	}

	public String getNameFuzzy() {
		return this.nameFuzzy;
	}

	public void setDescriptionFuzzy(String descriptionFuzzy) {
		this.descriptionFuzzy = descriptionFuzzy;
	}

	public String getDescriptionFuzzy() {
		return this.descriptionFuzzy;
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

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return this.id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return this.description;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

}