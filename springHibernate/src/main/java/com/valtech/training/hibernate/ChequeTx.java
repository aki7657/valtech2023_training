package com.valtech.training.hibernate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("ctx")
public class ChequeTx extends Tx {

	private int chequeNumber;
	private int micr;

	public ChequeTx() {
	}

	public ChequeTx(float amount, int chequeNumber, int micr) {
		super(amount);
		this.chequeNumber = chequeNumber;
		this.micr = micr;
	}

	public int getChequeNumber() {
		return chequeNumber;
	}

	public void setChequeNumber(int chequeNumber) {
		this.chequeNumber = chequeNumber;
	}

	public int getMicr() {
		return micr;
	}

	public void setMicr(int micr) {
		this.micr = micr;
	}

//	public ChequeTx(float amount, int chequeNumber, int micr) {
//		super(amount);
//		this.chequeNumber = chequeNumber;
//		this.micr = micr;
//	}

}
