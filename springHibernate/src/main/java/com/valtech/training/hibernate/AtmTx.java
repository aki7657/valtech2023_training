package com.valtech.training.hibernate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("atx")
public class AtmTx extends Tx {

	private int atmId;

	public AtmTx(float amount, int atmId) {
		super(amount);
		this.atmId = atmId;
	}

	public AtmTx() {

	}

	public int getAtmId() {
		return atmId;
	}

	public void setAtmId(int atmId) {
		this.atmId = atmId;
	}

}
