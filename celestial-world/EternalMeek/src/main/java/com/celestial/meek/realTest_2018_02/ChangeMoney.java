package com.celestial.meek.realTest_2018_02;

import java.util.HashMap;
import java.util.Map;

public class ChangeMoney {
	static Map<Long,String> numMap = new HashMap<>();
	static Map<Integer,String> rankMap = new HashMap<>();
	//1.4λ����4λ���ֵ�ƥ�䣬ÿ��4λ����ǧ��ʮ��λ�Ķ�ȡ��
	//2.һ��4λ���ж�����Ϊ1����ĩβ����ȥ��������450�� �������İ���ʮ�������ȫ����Ļ�����1���㣬�ҵ�λ��Ҫ�ˣ�������1��0�����İ���ʮ��
	//3.���ϳɵ����ֶ����ƥ���һ�����ͷ����ȥ����
	static {
		numMap.put(1L, "һ");
		numMap.put(2L, "��");
		numMap.put(3L, "��");
		numMap.put(4L, "��");
		numMap.put(5L, "��");
		
		numMap.put(6L, "��");
		numMap.put(7L, "��");
		numMap.put(8L, "��");
		numMap.put(9L, "��");
		numMap.put(0L, "��");
		
		rankMap.put(0,"");
		rankMap.put(1,"��");
		rankMap.put(2,"��");
		rankMap.put(3,"����");
		rankMap.put(4,"����");
		
	}
	public static void main(String[] args) {
		//1011
		//1004 2314
		//23 1004 2314
		//"��" "��" "Ԫ"
		//1.�ֳ�4��һ���ʾ ���"��"ȫ���滻Ϊ1��
		
		ChangeMoney c = new ChangeMoney();
		
//		String s = c.formatMoney(1222330003400023L);
		String s = c.formatMoney(135689123L);
		
		System.out.println(s);
		
		
	}
	
	public String formatMoney(Long money) {
		return new StringBuilder(formatMoneyRe(money,0)).append("Ԫ").toString().replaceAll("��+", "��").replaceAll("^��", "");
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

//1.�м�������� 2.��ͷ���㲻��ȥ���������ϲ�Ϊ1����ĩβ����ȥ�������ֻ��һ�����˵Ļ�����λҲ��Ҫ��

	private String format4(Long money,int rank) {
		//3201
		StringBuilder sb = new StringBuilder();
		
		sb.append(fomate1(money/1000,"ǧ"))
		.append(fomate1(money%1000/100,"��"))
		.append(fomate1(money%1000%100/10,"ʮ"))
		.append(fomate1(money%1000%100%10,""));
		
		String res = sb.toString().replaceAll("��+", "��");
		if("��".equals(res))
			return res;
		else
			return res.replaceAll("��$", "")+rankMap.get(rank);
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
