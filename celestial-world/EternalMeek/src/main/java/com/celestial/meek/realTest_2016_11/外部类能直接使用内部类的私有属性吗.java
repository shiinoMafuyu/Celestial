package com.celestial.meek.realTest_2016_11;

import java.util.HashMap;
import java.util.Map;

public class 外部类能直接使用内部类的私有属性吗 {

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param args 
	 */
	public static void main(String[] args) {
		
		外部类能直接使用内部类的私有属性吗 w = new 外部类能直接使用内部类的私有属性吗();
		hhh h = w.new hhh();
		System.out.println(h.m.get("name"));
	}
	
	class hhh{
		private String sos ="斯巴拉西";
		
		private Map<String,String> m = new HashMap<String,String>(){{
			put("name","yukino");
		}};
	}
}
