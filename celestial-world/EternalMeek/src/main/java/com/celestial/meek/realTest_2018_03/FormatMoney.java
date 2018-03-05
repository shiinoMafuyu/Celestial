package com.celestial.meek.realTest_2018_03;

import java.util.HashMap;
import java.util.Map;

public class FormatMoney {
	
	private static Map<Integer,String> m = new HashMap<>();
	private static Map<Integer,String> mstage = new HashMap<>();
	static {
		m.put(0,"��");m.put(1,"Ҽ");m.put(2,"��");m.put(3,"��");m.put(4,"��");
		m.put(5,"��");m.put(6,"½");m.put(7,"��");m.put(8,"��");m.put(9,"��");
		mstage.put(0, "Ԫ��");
		mstage.put(1, "��");
		mstage.put(2, "��");
		mstage.put(3, "��");
	}
	
	public static void main(String[] args) {
		
		String ss = formateMoney("9000000022225");
		System.out.println(ss);
	}

	private static String formateMoney(String str) {
		String mon = str;
		int count =0;
		String re="";
		while(mon.length() > 0) {
			int head = mon.length()-4;
			head = head<0?0:head;
			re = formate4(mon.substring(head),count)+re;
			
			mon= mon.substring(0, head);
			count++;
			
		}
		return re.replaceAll("��[ʰ��Ǫ]","��").replaceAll("��+", "��").
				replaceAll("����", "��").replaceAll("����", "��").replaceAll("��Ԫ", "Ԫ").replaceAll("^��", "").replaceAll("����", "��").replaceAll("����", "��");
	}

	private static String formate4(String str, int stage) {
		str = String.format("%04d", Integer.valueOf(str));
		StringBuilder sb = new StringBuilder(10);
		
		sb.append(m.get(Integer.valueOf(str.substring(0,1)))).append("Ǫ")
		.append(m.get(Integer.valueOf(str.substring(1,2)))).append("��")
		.append(m.get(Integer.valueOf(str.substring(2,3)))).append("ʰ")
		.append(m.get(Integer.valueOf(str.substring(3,4)))).append(mstage.get(stage));
		return sb.toString();
	}
}
