package com.celestial.meek.realTest_2018_02;

import java.io.Serializable;

public class Serial implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name= "½þ";
	private int age = 30;
	public static void main(String[] args) {
		
		Serial se = new Serial();
		se.setName("³Á½þ");
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
