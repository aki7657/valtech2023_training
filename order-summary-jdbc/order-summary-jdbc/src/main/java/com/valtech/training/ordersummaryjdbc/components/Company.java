package com.valtech.training.ordersummaryjdbc.components;

public class Company {

	private int companyId;
	private String companyName;
	private String companyAddress;

	public Company() {
		super();
	}

	public Company(String companyName, String companyAddress) {
		super();
		this.companyName = companyName;
		this.companyAddress = companyAddress;
	}

	public Company(int companyId, String companyName, String companyAddress) {
		super();
		this.companyId = companyId;
		this.companyName = companyName;
		this.companyAddress = companyAddress;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	@Override
	public String toString() {
		return "Company [companyId=" + companyId + ", companyName=" + companyName + ", companyAddress=" + companyAddress
				+ "]";
	}


}
