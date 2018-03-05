package com.celestial.meek.realTest_2018_03;

public class Calculator {
	private static int LOWMAX = 100000;
//	private static int ZERO_LEN = String.valueOf(LOWMAX).length() -1;
	private String val = "";
	public int high=0;
	public int low =0;
	public String simp;
	
	
	public Calculator(String num) {
		if(num.contains("-")) {
			simp="-";
			num = num.replaceAll("-", "");
		}else {
			simp = "+";
			num.replaceAll("/+", "");
		}
		this.val = num;
		if(num.length() >5) {
			low = Integer.valueOf(num.substring(num.length()-5));
			high = Integer.valueOf(num.substring(0,num.length()-5));
			
		}else {
			low = Integer.valueOf(num);
		}
		
	}
	
	private void setVal() {
		val = String.format("%s%s%05d",simp, high,low);
	}
	
	public void add(Calculator other) {
		int highAbs = Math.abs(high),
				otherHighAbs = Math.abs(other.high),
				lowAbs = Math.abs(low),
				otherLowAbs = Math.abs(other.low);
		if(highAbs > otherHighAbs || (highAbs == otherHighAbs && lowAbs >= otherLowAbs)) {
		}else {
			int lowTemp = low;
			int highTemp = high;
			String simpTemp = simp;
			low = other.low;
			high = other.high;
			simp = other.simp;
			other.high = highTemp;
			other.low =lowTemp;
			other.simp = simpTemp;
		}
		calSpecialAdd(other);
		setVal();
	}

	
	private void calSpecialAdd(Calculator other) {
		//可能为加 可能为减去 可能进位 可能退位
		if(simp.equals(other.simp)) {
			low = low + other.low;
			high = high + other.high + low/LOWMAX;
			low = low % LOWMAX;
		}else {
			if(low < other.low) {
				low = low +LOWMAX;
				high-=1;
			}
			low = low -other.low;
			high = high - other.high;
		}
		
	}
	public void sub(Calculator other) {
		other.reverse();
		add(other);
	}
	
	public void reverse() {
		if("+".equals(simp)) {
			simp = "-";
		}else {
			simp="+";
		}
	}
	
	public String getValue() {
		return val;
	}
}
