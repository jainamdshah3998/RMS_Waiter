package com.example.waiterside.Bean;

public class ItemBean {
	private int itemId;
	private String itemName;
	private String itemDescription;
	private String itemPrice;

	@Override
	public String toString() {
		return "ItemBean{" +
				"itemId=" + itemId +
				", itemName='" + itemName + '\'' +
				", itemDescription='" + itemDescription + '\'' +
				", itemPrice='" + itemPrice + '\'' +
				", category=" + category +
				'}';
	}

	private CategoryBean category;
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemDescription() {
		return itemDescription;
	}
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
	public CategoryBean getCategory() {
		return category;
	}
	public void setCategory(CategoryBean category) {
		this.category = category;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(String itemPrice) {
		this.itemPrice = itemPrice;
	}

}
