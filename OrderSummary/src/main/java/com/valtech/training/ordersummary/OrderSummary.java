package com.valtech.training.ordersummary;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class OrderSummary {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderSummaryId;
	private int quantity;

	@ManyToMany(targetEntity = Items.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH }, fetch = FetchType.LAZY)
	@JoinTable(name = "OrderedItems", joinColumns = @JoinColumn(name = "OrderSummaryId", referencedColumnName = "orderSummaryId"), inverseJoinColumns = @JoinColumn(name = "ItemId", referencedColumnName = "itemId"))
	private Set<Items> item;

	@OneToOne(targetEntity = Orders.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH }, fetch = FetchType.LAZY)
	@JoinColumn(name = "orderId",referencedColumnName = "orderID")
	private Orders order;

	public OrderSummary() {
		super();
	}

	public void addItems(Items item) {
		if (getItem() == null) {
			setItem(new HashSet<Items>());
		}
		getItem().add(item);
		if (item.getOrderSummary() == null) {
			item.setOrderSummary(new HashSet<OrderSummary>());
		}
		item.getOrderSummary();
	}

	public OrderSummary(int quantity) {
		super();
		this.quantity = quantity;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Set<Items> getItem() {
		return item;
	}

	public void setItem(Set<Items> item) {
		this.item = item;
	}

	public int getOrderSummaryId() {
		return orderSummaryId;
	}

	public void setOrderSummaryId(int orderSummaryId) {
		this.orderSummaryId = orderSummaryId;
	}

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}

}
