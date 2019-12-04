package po;

import java.util.HashSet;
import java.util.Set;

/**
 * Categories entity. @author MyEclipse Persistence Tools
 */

public class Categories implements java.io.Serializable {

	// Fields

	private Integer categoryId;
	private String categoryName;
	private String description;
	private String picture;
	private Set productses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Categories() {
	}

	/** minimal constructor */
	public Categories(String categoryName) {
		this.categoryName = categoryName;
	}

	/** full constructor */
	public Categories(String categoryName, String description, String picture,
			Set productses) {
		this.categoryName = categoryName;
		this.description = description;
		this.picture = picture;
		this.productses = productses;
	}

	// Property accessors

	public Integer getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return this.categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPicture() {
		return this.picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public Set getProductses() {
		return this.productses;
	}

	public void setProductses(Set productses) {
		this.productses = productses;
	}

}