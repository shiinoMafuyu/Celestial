package com.celestial.meek.realTest_2016_11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 一个map里的list里的值变了map再取时会变吗 {

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param args 
	 */
	public static void main(String[] args) {
		Map<String,List<String>> m = new HashMap<String,List<String>>();
		List<String> l = new ArrayList<String>();
		l.add("时光");
		l.add("如花美眷");
		l.add("似水流年");
		m.put("1", l);
		List<String> l2 = m.get("1");
		l2.add("荒年");
		l2.add("香年");
		System.out.println(l);
	}

}
