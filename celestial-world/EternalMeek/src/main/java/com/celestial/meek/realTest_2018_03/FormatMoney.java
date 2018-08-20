package com.celestial.meek.realTest_2018_03;

import java.util.HashMap;
import java.util.Map;

public class FormatMoney {
	
	private static Map<Integer,String> m = new HashMap<>();
	private static Map<Integer,String> mstage = new HashMap<>();
	static {
		m.put(0,"零");m.put(1,"壹");m.put(2,"贰");m.put(3,"叁");m.put(4,"肆");
		m.put(5,"伍");m.put(6,"陆");m.put(7,"柒");m.put(8,"捌");m.put(9,"玖");
		mstage.put(0, "元整");
		mstage.put(1, "万");
		mstage.put(2, "亿");
		mstage.put(3, "兆");
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
		return re.replaceAll("零[拾佰仟]","零").replaceAll("零+", "零").
				replaceAll("零亿", "亿").replaceAll("零万", "万").replaceAll("零元", "元").replaceAll("^零", "").replaceAll("亿万", "亿").replaceAll("兆亿", "兆");
	}

	private static String formate4(String str, int stage) {
		str = String.format("%04d", Integer.valueOf(str));
		StringBuilder sb = new StringBuilder(10);
		
		sb.append(m.get(Integer.valueOf(str.substring(0,1)))).append("仟")
		.append(m.get(Integer.valueOf(str.substring(1,2)))).append("佰")
		.append(m.get(Integer.valueOf(str.substring(2,3)))).append("拾")
		.append(m.get(Integer.valueOf(str.substring(3,4)))).append(mstage.get(stage));
		return sb.toString();
	}
}
