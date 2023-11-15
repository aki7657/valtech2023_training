package com.valtech.training.firstspringboot.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.valtech.training.firstspringboot.entities.Order;

public class OrderModel {

	private static final DateTimeFormatter ORDER_DATE_FORMAT = DateTimeFormatter.ofPattern("dd-MM-yyyy");

	private long id;
	private String item;
	private int itemCount;
	private String itemDescription;
	private String orderDate;

	public OrderModel() {
		super();
	}

	public OrderModel(Order order) {
		this.id = order.getId();
		this.item = order.getItem();
		this.itemCount = order.getItemCount();
		this.itemDescription = order.getItemDescription();
		this.orderDate = order.getOrderDate()== null ? "" : order.getOrderDate().format(ORDER_DATE_FORMAT);
	}

	public Order getOrder() {
		return new Order(id, item, itemCount, itemDescription, LocalDate.parse(orderDate, ORDER_DATE_FORMAT));
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public int getItemCount() {
		return itemCount;
	}

	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

}
