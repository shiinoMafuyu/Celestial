package com.celestial.meek.realTest_2016_11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class һ��map���list���ֵ����map��ȡʱ����� {

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param args 
	 */
	public static void main(String[] args) {
		Map<String,List<String>> m = new HashMap<String,List<String>>();
		List<String> l = new ArrayList<String>();
		l.add("ʱ��");
		l.add("�绨����");
		l.add("��ˮ����");
		m.put("1", l);
		List<String> l2 = m.get("1");
		l2.add("����");
		l2.add("����");
		System.out.println(l);
	}

}
