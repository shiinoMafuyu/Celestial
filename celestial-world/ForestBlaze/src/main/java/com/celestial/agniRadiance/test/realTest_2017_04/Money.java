package com.celestial.agniRadiance.test.realTest_2017_04;

public class Money {
	String currenceType;
	Double amount;
	
	public Money add(Double amout){
		this.amount += amout;
		return this;
	}
	
	public Money sub(Double amout){
		this.amount -= amout;
		return this;
	}

	public String getCurrenceType() {
		return currenceType;
	}

	public Money setCurrenceType(String currenceType) {
		this.currenceType = currenceType;
		return this;
	}

	public Double getAmount() {
		return amount;
	}

	public Money setAmount(Double amount) {
		this.amount = amount;
		return this;
	}
	
	
}
