package com.celestial.meek.realTest_2016_11;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Calendar��һ�� {

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param args 
	 */
	public static void main(String[] args) {
//		teNextDay();
//		t����getCalendar�Ƿ���һ������();
//		dayofYear����();
		day_of_year����();
	}

	private static void day_of_year����() {
		Calendar c = Calendar.getInstance();
		SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		System.out.println(sm.format(c.getTime()));
		System.out.println(c.get(Calendar.DAY_OF_YEAR));
		
		c.set(Calendar.DAY_OF_YEAR,-1);
		System.out.println(sm.format(c.getTime()));
		
	}

	public static void dayofYear����() {
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		c1.set(Calendar.YEAR, c1.get(Calendar.YEAR)+1);
		c1.set(Calendar.DAY_OF_YEAR, 1);
		c2.set(Calendar.DAY_OF_YEAR,365);
		
		System.out.println();
	}

	public static void t����getCalendar�Ƿ���һ������() {
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		
		System.out.println(c1.equals(c2));
		System.out.println(c1);
		System.out.println(c2);
		
	}

	public static void teNextDay() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_YEAR, c.get(Calendar.DAY_OF_YEAR)+6);
		Calendar c2 =Calendar.getInstance();
		System.out.println(c2.get(Calendar.MONTH));
		c2.set(Calendar.DAY_OF_YEAR, c2.get(Calendar.DAY_OF_YEAR)+7);
		System.out.println(c2.get(Calendar.MONTH));
		System.out.println(c2.get(Calendar.DAY_OF_MONTH));
		/**DAY_OF_YEAR + 1��DAY_OF_MONTH + 1һ����Ч��~*/
		/*�жϼ���һ��֮��*/
		System.out.println("----------->");
		System.out.println((c2.getTimeInMillis()-c.getTimeInMillis())/(1*60.0*60*1000));
	}

}
