package com.example.waiterside.Bean;


public class CategoryBean {

	private Integer categoryId;
	private String categoryName;

	@Override
	public String toString() {
		return "CategoryBean{" +
				"categoryId=" + categoryId +
				", categoryName='" + categoryName + '\'' +
				'}';
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

}
