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
public class NewsCategories implements Serializable {
	/**
	 * 
	 */
	private Integer id;

	/**
	 * 
	 */
	private String name;

	/**
	 * 
	 */
	private String description;

	/**
	 * 
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createdAt;


	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Integer getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public String getDescription() {
		return this.description;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	@Override
	public String toString() {
		return ":" + (id == null ? "null" : id) + ",:" + (name == null ? "null" : name) + ",:" + (description == null ? "null" : description) + ",:" + (createdAt == null ? "null" : createdAt);
	}
}