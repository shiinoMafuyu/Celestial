package com.celestial.meek.realTest_2018_03;

import java.util.HashMap;
import java.util.Map;

public class FormatMoney {
	
	private static Map<Integer,String> m = new HashMap<>();
	private static Map<Integer,String> mstage = new HashMap<>();
	static {
		m.put(0,"Áã");m.put(1,"Ò¼");m.put(2,"·¡");m.put(3,"Èþ");m.put(4,"ËÁ");
		m.put(5,"Îé");m.put(6,"Â½");m.put(7,"Æâ");m.put(8,"°Æ");m.put(9,"¾Á");
		mstage.put(0, "ÔªÕû");
		mstage.put(1, "Íò");
		mstage.put(2, "ÒÚ");
		mstage.put(3, "Õ×");
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
		return re.replaceAll("Áã[Ê°°ÛÇª]","Áã").replaceAll("Áã+", "Áã").
				replaceAll("ÁãÒÚ", "ÒÚ").replaceAll("ÁãÍò", "Íò").replaceAll("ÁãÔª", "Ôª").replaceAll("^Áã", "").replaceAll("ÒÚÍò", "ÒÚ").replaceAll("Õ×ÒÚ", "Õ×");
	}

	private static String formate4(String str, int stage) {
		str = String.format("%04d", Integer.valueOf(str));
		StringBuilder sb = new StringBuilder(10);
		
		sb.append(m.get(Integer.valueOf(str.substring(0,1)))).append("Çª")
		.append(m.get(Integer.valueOf(str.substring(1,2)))).append("°Û")
		.append(m.get(Integer.valueOf(str.substring(2,3)))).append("Ê°")
		.append(m.get(Integer.valueOf(str.substring(3,4)))).append(mstage.get(stage));
		return sb.toString();
	}
}
