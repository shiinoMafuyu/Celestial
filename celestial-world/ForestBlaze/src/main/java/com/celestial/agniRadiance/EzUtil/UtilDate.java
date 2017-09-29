/******************************************************************
 * UtilDate.java
 * Copyright ${year} by WZG. All Rights Reserved.
 * CreateDate��2017��9��14��
 * Author��wangzg
 * Version��1.0.0
 ******************************************************************/

package com.celestial.agniRadiance.EzUtil;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * <b>�޸ļ�¼��</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2017��9��14��
 * </li>
 * </p>
 * 
 * <b>��˵����</b>
 * <p> 
 * 
 * </p>
 */
public class UtilDate {
	
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ��ȡyear��month���ж�����.<br/>
	 * </ul>
	 * @param year
	 * @param month
	 * @return
	 */
	public static int getDays(int year, int month) {
		int days = 0;
		if(month > 12 || month<0)
			throw new RuntimeException("- -�Ҳ������˵��.");
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
	 * �ж�һ��ʱ���Ƿ��ڸ�����ʱ��֮�� ;<br/>
	 * �������Ϊ˫����,�ж��ǲ���������ɵ�����֮��;<br/>
	 * ���Ϊ������Ĭ�����ʱ�䵽�����;<br/>
	 * �ж���ĳʱ��֮ǰ�����,ȡ�Ǽ���.<br/>
	 * @param date ����
	 * @param dates ʱ������
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
			throw new RuntimeException("���ڱȽ��쳣");
		}
		
		return b;
	}
	
	/**
	 * �Ƚ��ַ�����ʽ������<br/>
	 * ֧��yyyy-MM-dd �� yyyy-MM-dd hh:mm:ss ���ָ�ʽ<br/>
	 * @param date �ַ�����
	 * @param dates �ַ���������
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
			throw new RuntimeException("���ڱȽ��쳣!");
		}
		catch (Exception e) {
			throw new RuntimeException("�ַ������ڸ�ʽ����!");
		}
	}
	
	/**
	 * ͨ��������ʽ������һ�ֻ�ȡ����
	 * @param stringDate �ַ�������
	 * @param stringsDatePattern ������ʽ
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
		throw new RuntimeException("û���ʺϵ��ַ����ڸ�ʽƥ��,��ȡDate����ʧ��!");
	}
	
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ��ȡlist�ж���ĳ�Ա����variableName�����ֵ(ʱ������)��list�������򷵻�new Date(0)<br/>
	 * ֧��Timestamp��Date��������.<br/>
	 * </ul>
	 * @param list
	 * @param variableName
	 * @return 
	 */
	public static <T> Date getMaxDate(List<T> list, String variableName) {
		//DateΪTimestamp�ĸ����ͣ������������б������������ַ�ʽ�ıȽ���ʱ���С��û���໥ת�ͣ��������Լ��ľ��ȡ�����Date���ͣ����ں�����Ҫʹ��Timestamp���Լ�ǿ��ת�ͻ���ת�͡�
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
	 * <b>����˵����</b>
	 * <ul>
	 * ��ȡlongʱ��
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
	 * <b>����˵����</b>
	 * <ul>
	 * ��ȡ���ڵ�ʱ��֮�󾭹�addYear�꣬addMonth�£�addDay�պ�ĺ�������time��<br/>
	 * ���˳��������
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
			System.out.println(String.format("[UtilDate]��ȡʱ�����addYear = %s , addMonth = %s , addDay = %s , time = %s ", addYear,addMonth,addDay,time));
		}
		
		return null;
	}
	
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * �ж�obj�Ƿ�Ϊ���ڣ�null����<br/>
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
