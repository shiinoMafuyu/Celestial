/******************************************************************
 * Console.java
 * Copyright 2017 by WZG. All Rights Reserved.
 * CreateDate：2017年8月6日
 * Author：wangzg
 * Version：1.0.0
 ******************************************************************/

package com.celestial.meek.realTest_2017_08;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;



/**
 * <b>修改记录：</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2017年8月6日
 * </li>
 * </p>
 * 
 * <b>类说明：</b>
 * <p> 
 * 
 * </p>
 */
public class Console {
	
	@Test
	public void _01_staticVariable(){
		try {
			User user = new User();
			Field field = User.class.getDeclaredField("kind");
			field.setAccessible(true);
			
			String val = (String)field.get(user);
			Assert.assertEquals("humanBeing", val);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void _01_getMemberVariable(){
		Field[] fileds = User.class.getDeclaredFields();
		for(Field fi :fileds){
			System.out.println(fi.getName() +" 是 静态变量: " + Modifier.isStatic(fi.getModifiers()));
		}
	}
	
	
	@Test
	public void testTime(){
		Timestamp time = new Timestamp(System.currentTimeMillis());
		Timestamp past = new Timestamp(System.currentTimeMillis() - 1000*60*60 * 24 * 80L);
		Timestamp past2 = new Timestamp(System.currentTimeMillis() - 1000*60*60 * 24 * 30L);
		
		SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(fm.format(time));
		System.out.println(fm.format(past));
		System.out.println(fm.format(past2));
	}
	
	@Test
	public void _02_consoleSql(){
		String sql = new StringBuffer()
				.toString();
		
		
		System.out.println(sql);
		String s = "";
		System.out.println(s.charAt(2));
		
	}
	
	@Test
	public void _02_01consoleSql(){
		
		String s = String.format("%4s", "112").replaceAll(" ", "0");
		System.out.println(s);
		
	}
	
	
	
	@Test
	public void testDateBefore(){
		Long time = System.currentTimeMillis();
		Date d1 = new Date(time);
		Date d2 = new Date(time + 200);
		
		
		
		Assert.assertTrue(d1.before(d2));
		
		Timestamp t1 = new Timestamp(time);
		Timestamp t2 = new Timestamp(time + 200);
		
		Date dt1 = (Date)t1,dt2 = (Date)t2;
		
		
		Assert.assertTrue(t1 instanceof Date);
		Assert.assertFalse(d1 instanceof Timestamp);
		
//		Assert.assertTrue(dt1.before(dt2));//无论 false true都不行 类型问题
		Assert.assertTrue(dt1.getTime() < dt2.getTime());//这样才行
		
	}
	
	@Test
	public void testTransTimestamp(){
		BigDecimal big = new BigDecimal("2222222222");
		big = big.multiply(big);
		big = new BigDecimal(111111111111111111L);
		System.out.println();
	}
	
	@Test
	public void testDateEqual(){
		System.out.println("--------------->"+"F59839D0FAB06FEDA0A9DE957220076F1033625704931850412".length());
		System.out.println("--------------->"+"3DF675F43FD5CD0C1A73D1CA119F0A5F".length());
		
		
		String s = "fusion.abc",v = ".abc";
		System.out.println(s.endsWith(v));
		
		long timeMill = System.currentTimeMillis();
		Date d = new Date(timeMill);
		
		Date d2 = new Date(timeMill );
		
		Assert.assertTrue(d.getTime() == d2.getTime());
		
		
	}
	
	@Test
	public void testTimer(){
		
		
		Object o = "2";
		String st = "22";
		Long l = 123L;
		Double d = 12.23;
		Integer i =233;
		Short s = 123;
		
		Assert.assertTrue(new Double(st) > new Double((String)o) );
		Assert.assertTrue(new Double(l) > new Double(d) );
		Assert.assertTrue(new Double(i) > new Double(s) );
		
		Assert.assertTrue(new Double(st) > new Double((String)o) );
	}
	
	
	
	
	class Person {
		private String name = "ayase";
		private Integer age = 17;
		
		private BigDecimal battleVal = new BigDecimal("5");
		
		/**
		 * <b>方法说明：</b>
		 * <ul>
		 * 获取
		 * </ul>
		 * @return the name
		 */
		public String getName() {
			return name;
		}

		/**
		 * <b>方法说明：</b>
		 * <ul>
		 * 获取
		 * </ul>
		 * @return the age
		 */
		public Integer getAge() {
			return age;
		}

		/**
		 * <b>方法说明：</b>
		 * <ul>
		 * 获取
		 * </ul>
		 * @return the battleVal
		 */
		public BigDecimal getBattleVal() {
			return battleVal;
		}

		/**
		 * <b>方法说明：</b>
		 * <ul>
		 * 设置
		 * </ul>
		 * name
		 */
		public void setName(String name) {
			this.name = name;
		}

		/**
		 * <b>方法说明：</b>
		 * <ul>
		 * 设置
		 * </ul>
		 * age
		 */
		public void setAge(Integer age) {
			this.age = age;
		}

		/**
		 * <b>方法说明：</b>
		 * <ul>
		 * 设置
		 * </ul>
		 * battleVal
		 */
		public void setBattleVal(BigDecimal battleVal) {
			this.battleVal = battleVal;
		}
		
		
	}
	
	
}
