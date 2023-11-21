package com.valtech.training.ordersummaryjdbc.components;

import java.util.Date;

public class Orders {

	private int orderID;
	private Date orderDate;
	private int customerId;

	public Orders() {
		super();
	}

	public Orders(int orderID, Date orderDate, int customerId) {
		super();
		this.orderID = orderID;
		this.orderDate = orderDate;
		this.customerId = customerId;
	}

	public Orders(Date orderDate, int customerId) {
		super();
		this.orderDate = orderDate;
		this.customerId = customerId;
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return "Orders [orderID=" + orderID + ", orderDate=" + orderDate + ", customerId=" + customerId + "]";
	}

}
