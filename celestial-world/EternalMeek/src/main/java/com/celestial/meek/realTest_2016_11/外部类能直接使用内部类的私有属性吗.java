package com.celestial.meek.realTest_2016_11;

import java.util.HashMap;
import java.util.Map;

public class �ⲿ����ֱ��ʹ���ڲ����˽�������� {

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param args 
	 */
	public static void main(String[] args) {
		
		�ⲿ����ֱ��ʹ���ڲ����˽�������� w = new �ⲿ����ֱ��ʹ���ڲ����˽��������();
		hhh h = w.new hhh();
		System.out.println(h.m.get("name"));
	}
	
	class hhh{
		private String sos ="˹������";
		
		private Map<String,String> m = new HashMap<String,String>(){{
			put("name","yukino");
		}};
	}
}
