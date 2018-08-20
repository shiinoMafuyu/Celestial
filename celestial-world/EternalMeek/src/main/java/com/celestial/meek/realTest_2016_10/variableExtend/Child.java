package com.celestial.meek.realTest_2016_10.variableExtend;

public class Child extends Father {
	protected String sArr = "月光池塘";
	
	public static void main(String[] args) {
		Child c = new Child();
		Father f = c;
		System.out.println(c.sArr);
		
		System.out.println(f.sArr[0]);
		c.show();
		f.show();
	}
}
