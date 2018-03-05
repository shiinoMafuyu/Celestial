package com.celestial.meek.realTest_2018_02;

import java.util.HashMap;
import java.util.Map;

public class ChangeMoney {
	static Map<Long,String> numMap = new HashMap<>();
	static Map<Integer,String> rankMap = new HashMap<>();
	//1.4位数字4位数字的匹配，每个4位进行千百十零位的读取。
	//2.一个4位数中多个零改为1个，末尾的零去掉，例如450万 而不是四百五十零万。如果全是零的话保留1个零，且单位不要了，不能是1亿0万零四百五十六
	//3.最后合成的数字多个零匹配成一个，最开头的零去掉。
	static {
		numMap.put(1L, "一");
		numMap.put(2L, "二");
		numMap.put(3L, "三");
		numMap.put(4L, "四");
		numMap.put(5L, "五");
		
		numMap.put(6L, "六");
		numMap.put(7L, "七");
		numMap.put(8L, "八");
		numMap.put(9L, "九");
		numMap.put(0L, "零");
		
		rankMap.put(0,"");
		rankMap.put(1,"万");
		rankMap.put(2,"亿");
		rankMap.put(3,"万亿");
		rankMap.put(4,"亿亿");
		
	}
	public static void main(String[] args) {
		//1011
		//1004 2314
		//23 1004 2314
		//"亿" "万" "元"
		//1.分成4个一组表示 多个"零"全部替换为1个
		
		ChangeMoney c = new ChangeMoney();
		
//		String s = c.formatMoney(1222330003400023L);
		String s = c.formatMoney(135689123L);
		
		System.out.println(s);
		
		
	}
	
	public String formatMoney(Long money) {
		return new StringBuilder(formatMoneyRe(money,0)).append("元").toString().replaceAll("零+", "零").replaceAll("^零", "");
	}

	private String formatMoneyRe(Long money,Integer rank) {
		if(rank ==null)
			rank = new Integer(0);
		Long res = money/10000;
		String str4 = format4(money%10000,rank);
		if(res!=0)
			return new StringBuilder(formatMoneyRe(res,++rank)).append(str4)
					.toString();
		else
			return str4;
	}

//1.中间多零的情况 2.开头的零不用去掉，多个零合并为1个，末尾的零去掉，如果只有一个零了的话，单位也不要了

	private String format4(Long money,int rank) {
		//3201
		StringBuilder sb = new StringBuilder();
		
		sb.append(fomate1(money/1000,"千"))
		.append(fomate1(money%1000/100,"百"))
		.append(fomate1(money%1000%100/10,"十"))
		.append(fomate1(money%1000%100%10,""));
		
		String res = sb.toString().replaceAll("零+", "零");
		if("零".equals(res))
			return res;
		else
			return res.replaceAll("零$", "")+rankMap.get(rank);
	}

	private String fomate1(Long num, String unit) {
		StringBuilder sb= new StringBuilder();
		if(num!=0)
			sb.append(numMap.get(num)).append(unit);
		else
			sb.append(numMap.get(num));
		return sb.toString();
	}
	
	

}
