/******************************************************************
 * UtilDate.java
 * Copyright ${year} by WZG. All Rights Reserved.
 * CreateDate：2017年9月14日
 * Author：wangzg
 * Version：1.0.0
 ******************************************************************/

package com.celestial.agniRadiance.EzUtil;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * <b>修改记录：</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2017年9月14日
 * </li>
 * </p>
 * 
 * <b>类说明：</b>
 * <p> 
 * 
 * </p>
 */
public class UtilDate {
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取year年month月有多少天.<br/>
	 * </ul>
	 * @param year
	 * @param month
	 * @return
	 */
	public static int getDays(int year, int month) {
		int days = 0;
		if(month > 12 || month<0)
			throw new RuntimeException("- -我不想和你说话.");
		if(UtilCollection.inArr(new Integer[]{1,3,5,7,8,10,12}, month))
			days = 31;
		else if(UtilCollection.inArr(new Integer[]{4,6,9,11},month))
				days = 30;
		else{
			if(days % 100 ==0){
				if(days % 400 == 0)
					days =29;
				else
					days = 28;
			}else if(days % 4 ==0)
				days = 29;
			else
				days = 28;
		}
		return days;
	}
	
	/**
	 * 判断一个时间是否在给定的时间之内 ;<br/>
	 * 如果数组为双数则,判断是不是两两组成的区间之内;<br/>
	 * 如果为单数则默认最后时间到无穷大;<br/>
	 * 判断是某时间之前无穷大,取非即可.<br/>
	 * @param date 日期
	 * @param dates 时间区间
	 * @throws Exception 
	 */
	public static boolean inTime(Date date, Date[] dates) throws Exception {
		boolean b = false ;
		try {
			int n = dates.length;
			if(n%2 == 0){
			}else{
				n = n - 1;
			}
			for(int i = 0 ; i < n ; i += 2){
				if(date.after(dates[i]) && date.before(dates[i+1])){
					b = true;
				}
			}
			if(n == dates.length - 1){
				if(date.after(dates[n])){
					b = true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("日期比较异常");
		}
		
		return b;
	}
	
	/**
	 * 比较字符串格式的日期<br/>
	 * 支持yyyy-MM-dd 和 yyyy-MM-dd hh:mm:ss 两种格式<br/>
	 * @param date 字符日期
	 * @param dates 字符日期数组
	 * @return 
	 */
	public static boolean inTime(String date, String[] dates) {
		String[] partern = new String[]{"yyyy-MM-dd","yyyy-MM-dd hh:mm:ss"};
		Date dt = null;
		Date[] dts = new Date[dates.length];
		try {
			dt = getDatePatterns(date,partern);
			for(int i = 0 ; i < dates.length ; i++){
				dts[i] = getDatePatterns(dates[i],partern);
			}
			return inTime(dt,dts);
		}catch(RuntimeException e1){
			throw new RuntimeException("日期比较异常!");
		}
		catch (Exception e) {
			throw new RuntimeException("字符串日期格式不对!");
		}
	}
	
	/**
	 * 通过几种样式的任意一种获取日期
	 * @param stringDate 字符串日期
	 * @param stringsDatePattern 日期样式
	 * @return
	 */
	public static Date getDatePatterns(String stringDate, String[] stringsDatePattern) {
		SimpleDateFormat df = null;
		Date date = null;
		for(String pattern : stringsDatePattern){
			try {
				df = new SimpleDateFormat(pattern);
				date = df.parse(stringDate);
				
				if(date != null && df.format(date).contains(" ") == stringDate.contains(" ")){
					return date;
				}
			} catch (Exception e) {
				continue;
			}
		}
		throw new RuntimeException("没有适合的字符日期格式匹配,获取Date对象失败!");
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取list中对象的成员变量variableName的最大值(时间类型)，list不存在则返回new Date(0)<br/>
	 * 支持Timestamp和Date两种类型.<br/>
	 * </ul>
	 * @param list
	 * @param variableName
	 * @return 
	 */
	public static <T> Date getMaxDate(List<T> list, String variableName) {
		//Date为Timestamp的父类型，在下面运算中保留。兼容两种方式的比较了时间大小，没有相互转型，保留了自己的精度。返回Date类型，若在后续中要使用Timestamp可自己强制转型或者转型。
		if(!UtilCollection.notNullEmpty(list))
			return null;
		Date date = new Date(0);
		try {
			Field field = list.get(0).getClass().getDeclaredField(variableName);
			field.setAccessible(true);
			Date tempDate = null;
			
			for(int i=0;i<list.size();i++){
				Object dateVal = field.get(list.get(i));
				if(null == dateVal){
					continue;
				}
				tempDate = (Date)dateVal;
				if(date.getTime() < tempDate.getTime()){
					date = tempDate;
				}
			}
			
		} catch (Exception e) {
		}
		
		if(date.getTime() <= new Date(0).getTime())
			date = null;
		return date;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取long时间
	 * </ul>
	 * @param date
	 * @return 
	 */
	public static Long getLongTime(Date date) {
		if(null == date)
			return 0L;
		else
			return date.getTime();
	}
	
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取现在的时间之后经过addYear年，addMonth月，addDay日后的后的那天的time。<br/>
	 * 添加顺序年月日
	 * </ul>
	 * @param addYear
	 * @param addMonth
	 * @param addDay
	 * @param time HH:mm:ss
	 * @return 
	 */
	public static Date getTime(int addYear, int addMonth, int addDay, String time) {
		Date d = new Date(System.currentTimeMillis());
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		c.add(Calendar.YEAR, addYear);
		c.add(Calendar.MONTH, addMonth);
		c.add(Calendar.DAY_OF_MONTH, addDay);
		String strDate = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime())+" "+time;
		try {
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(strDate);
		} catch (Exception e) {
			System.out.println(String.format("[UtilDate]获取时间出错。addYear = %s , addMonth = %s , addDay = %s , time = %s ", addYear,addMonth,addDay,time));
		}
		
		return null;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 判断obj是否为日期，null不算<br/>
	 * </ul>
	 * @param obj
	 * @return 
	 */
	public static boolean isDate(Object obj) {
		if(obj == null)
			return false;
		return obj instanceof java.sql.Date || obj instanceof java.util.Date;
	}

	public static String fmtDate(Date date) {
		return fmtTime(date, "yyyy-MM-dd");
	}

	public static String fmtTime(Date time) {
		return fmtTime(time, "yyyy-MM-dd HH:mm:ss");
	}

	public static String fmtTime(Date time, String pattern) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(pattern);
			return sdf.format(time);
		} catch (Exception localException) {
		}
		return "";
	}
	
}
