package com.celestial.meek.realTest_2018_02;

import java.io.Serializable;

public class Serial implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name= "浸";
	private int age = 30;
	public static void main(String[] args) {
		
		Serial se = new Serial();
		se.setName("沉浸");
		se.setAge(18);
		
		
		
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}

	
}
