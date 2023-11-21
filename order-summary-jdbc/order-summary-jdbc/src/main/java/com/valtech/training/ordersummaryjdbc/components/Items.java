package com.valtech.training.ordersummaryjdbc.components;

public class Items {

	private int itemId;
	private String itemDescription;
	private float unitPrice;
	private int companyId;

	public Items() {
		super();
	}

	public Items(int itemId, String itemDescription, float unitPrice, int companyId) {
		super();
		this.itemId = itemId;
		this.itemDescription = itemDescription;
		this.unitPrice = unitPrice;
		this.companyId = companyId;
	}

	public Items(String itemDescription, float unitPrice, int companyId) {
		super();
		this.itemDescription = itemDescription;
		this.unitPrice = unitPrice;
		this.companyId = companyId;
	}

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

	public float getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	@Override
	public String toString() {
		return "Items [itemId=" + itemId + ", itemDescription=" + itemDescription + ", unitPrice=" + unitPrice
				+ ", companyId=" + companyId + "]";
	}

}
