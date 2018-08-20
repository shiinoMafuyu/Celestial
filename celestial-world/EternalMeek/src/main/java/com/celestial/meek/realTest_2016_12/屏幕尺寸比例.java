package com.celestial.meek.realTest_2016_12;

import com.celestial.agniRadiance.entity.FileReader;

public class 屏幕尺寸比例 {
	public static void main(String[] args) {
		/**
		 * 
		 */
		FileReader f = new FileReader("C:/Users/Administrator/Desktop/引用修改/d.txt");
		while(f.hasNext()){
//			System.out.println(f.readLine());
			String s = f.readLine();
			int index1 = s.indexOf("(")+1,index2 = s.indexOf(")");
			String[] s2Arr = s.substring(index1,index2).split(",");
			double d1 = Double.valueOf(s2Arr[0]),d2 = Double.valueOf(s2Arr[1]);
			System.out.println(d1/d2);
		}
	}
}
