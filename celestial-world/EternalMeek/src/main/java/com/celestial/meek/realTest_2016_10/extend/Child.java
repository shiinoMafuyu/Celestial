package com.celestial.meek.realTest_2016_10.extend;

public class Child extends Super {
	public Child() {
	}
	
	public void println() {
		System.out.println(this.shiino);
	}
	
	public Child(String s){
		this.shiino = s;
	}
	public static void main(String[] args) {
		Child c = new Child("shiinobu is mine");
		c.println();
	}
}
