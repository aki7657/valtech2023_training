package com.valtech.training.firstspringboot.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String item;
	private int itemCount;
	private String itemDescription;
	private LocalDate orderDate;

	public Order() {
		super();
	}

	public Order(String item, int itemCount, String itemDescription, LocalDate orderDate) {
		super();
		this.item = item;
		this.itemCount = itemCount;
		this.itemDescription = itemDescription;
		this.orderDate = orderDate;
	}

	public Order(long id, String item, int itemCount, String itemDescription, LocalDate orderDate) {
		super();
		this.id = id;
		this.item = item;
		this.itemCount = itemCount;
		this.itemDescription = itemDescription;
		this.orderDate = orderDate;
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

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

}
