package com.valtech.training.hibernate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("ttx")
public class TellerTx extends Tx {

	private int tellerId;
	private int branch;

	public int getTellerId() {
		return tellerId;
	}

	public void setTellerId(int tellerId) {
		this.tellerId = tellerId;
	}

	public int getBranch() {
		return branch;
	}

	public void setBranch(int branch) {
		this.branch = branch;
	}

	public TellerTx() {
	}

	public TellerTx(float amount, int tellerId, int branch) {
		super(amount);
		this.tellerId = tellerId;
		this.branch = branch;
	}

}
