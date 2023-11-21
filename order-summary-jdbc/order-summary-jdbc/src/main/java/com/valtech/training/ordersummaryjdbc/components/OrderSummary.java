package com.valtech.training.ordersummaryjdbc.components;

public class OrderSummary {

	private int orderSummaryId;
	private int quantity;
	private int orderId;

	public OrderSummary() {
		super();
	}

	public OrderSummary(int orderSummaryId, int quantity, int orderId) {
		super();
		this.orderSummaryId = orderSummaryId;
		this.quantity = quantity;
		this.orderId = orderId;
	}

	public OrderSummary(int quantity, int orderId) {
		super();
		this.quantity = quantity;
		this.orderId = orderId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getOrderSummaryId() {
		return orderSummaryId;
	}

	public void setOrderSummaryId(int orderSummaryId) {
		this.orderSummaryId = orderSummaryId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	@Override
	public String toString() {
		return "OrderSummary [orderSummaryId=" + orderSummaryId + ", quantity=" + quantity + ", orderId=" + orderId
				+ "]";
	}

}
