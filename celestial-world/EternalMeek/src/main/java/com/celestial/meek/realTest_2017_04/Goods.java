package com.celestial.meek.realTest_2017_04;

public class Goods {
	String id;
	String name;
	String quantity;
	Integer num =0;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public Goods sub(Integer num2) {
		this.num += num2;
		return this;
	}
	public Goods add(Integer num2) {
		this.num -= num2;
		return this;
	}
	
}
