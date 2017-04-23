package com.celestial.meek.realTest_2016_12;

import java.text.SimpleDateFormat;
import java.util.Date;

public class 测试js的时间戳转为date {
	
	public static void main(String[] args) {
		Date d = new Date(1481105199386l);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(d));
	}
}
