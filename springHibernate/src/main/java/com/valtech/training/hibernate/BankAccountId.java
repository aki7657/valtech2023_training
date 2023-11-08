package com.valtech.training.hibernate;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class BankAccountId implements Serializable {

	private String accountType;
	private int accountNumber;

	public BankAccountId() {
		super();
	}

	public BankAccountId(String accountType, int accountNumber) {
		super();
		this.accountType = accountType;
		this.accountNumber = accountNumber;
	}

	@Override
	public int hashCode() {
		return Objects.hash(accountNumber, accountType);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BankAccountId other = (BankAccountId) obj;
		return accountNumber == other.accountNumber && Objects.equals(accountType, other.accountType);
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

}
