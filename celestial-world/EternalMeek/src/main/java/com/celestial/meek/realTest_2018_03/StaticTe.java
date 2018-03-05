package com.celestial.meek.realTest_2018_03;

public class StaticTe extends StaticClass{

	public static void main(String[] args) {
		
//		String s = "-1";
//		int a = Integer.valueOf(s);
//		int[] arr = new int[a];
//		System.out.println(arr.length);
		
//		StaticTe.show();
//		StaticClass.show();
		
		
		testSwitch();
		
		testMul();
	}
	
	private static void testMul() {
		System.out.println(3<<3);
		
	}

	private static void testSwitch() {
		String s="23";
		switch(s) {
			case "2":System.out.println(2);
			break;
			case "3":System.out.println(3);
			break;
			case "4":System.out.println(4);
			break;
			default:System.out.println("default");
		}
		
		
	}

	public static int a =234;
	
	public static void show() {
		System.out.println("-->"+a);
	}

}
