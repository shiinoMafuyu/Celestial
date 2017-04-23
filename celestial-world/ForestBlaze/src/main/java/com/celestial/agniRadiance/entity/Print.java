package com.celestial.agniRadiance.entity;

public class Print {
	private boolean isPrint ;

	public Print(boolean isPrint) {
		this.isPrint = isPrint;
	}

	public void print(String s) {
		if(isPrint)
			System.out.print(s);
	}
	
	public void println(String s) {
		if(isPrint)
			System.out.println(s);
	}

	public void setPrint(boolean isPrint) {
		this.isPrint = isPrint;
	}
	
}
