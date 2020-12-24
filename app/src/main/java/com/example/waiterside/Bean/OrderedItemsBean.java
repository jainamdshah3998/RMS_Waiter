package com.example.waiterside.Bean;


public class OrderedItemsBean{

	private Integer orderedItemsId;
	private String instruction;
	private int quantity;
	private int status;
	private ItemBean item;
	private OrderBean order;
	

	public OrderedItemsBean() {
	}

	public String getInstruction() {
		return this.instruction;
	}

	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	public void setItem(ItemBean item)
	{
		this.item = item;
	}
	public ItemBean getItem()
	{
		return item;
	}
	public void setOrder(OrderBean order)
	{
		this.order = order;
	}
	public Integer getOrderedItemsId() {
		return orderedItemsId;
	}

	public void setOrderedItemsId(Integer orderedItemsId) {
		this.orderedItemsId = orderedItemsId;
	}

	public OrderBean getOrder()
	{
		return order;
	}

	@Override
	public String toString() {
		return "OrderedItemsBean{" +
				"orderedItemsId=" + orderedItemsId +
				", instruction='" + instruction + '\'' +
				", quantity=" + quantity +
				", status=" + status +
				", item=" + item +
				", order=" + order +
				'}';
	}
}
