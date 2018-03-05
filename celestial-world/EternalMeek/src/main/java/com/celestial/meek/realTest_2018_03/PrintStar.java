package com.celestial.meek.realTest_2018_03;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PrintStar{

	public static void main(String[] args) {
		PrintStar p =new PrintStar();
		p.printStars(3);
		
		List<PrintStar> list = new ArrayList<>();
		list.sort(new Comparator<PrintStar>() {

			@Override
			public int compare(PrintStar o1, PrintStar o2) {
				return 0;
			}
		});
		
//		Enumeration e = lis
//		Map<String,String> m = new HashMap<>();
	}
	
	public void printStars(int n) {
		for(int i=0;i<n*2-1;i++) {
			int space = Math.abs(i+1-n);
			printChar(" ",space);
			printChar("*",Math.abs(n-space)*2-1);
			System.out.println();
		}
	}

	private void printChar(String str, int num) {
		for(int i=0;i<num;i++) {
			System.out.print(str);
		}
	}
	
	public void abc() {
		PrintStar p =new PrintStar();
		synchronized (p) {
			Double d =3.14;
			System.out.println(d.compareTo(5.23));
		}
	}


}
