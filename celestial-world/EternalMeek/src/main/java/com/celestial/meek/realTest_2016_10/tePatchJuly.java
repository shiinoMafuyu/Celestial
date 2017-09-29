package com.celestial.meek.realTest_2016_10;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import com.celestial.agniRadiance.EzUtil.UtilDate;
import com.celestial.agniRadiance.EzUtil.UtilCollection;


public class tePatchJuly {

	/**
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {
//		teContain();
//		teReflect();
//		teInTime();
//		teSimpleDateFormat();
//		teZhengHeFile();
		
	}



	@SuppressWarnings("unused")
	private static void teSimpleDateFormat() throws ParseException {
		Date d = new Date();
		String d1 = "2016-7-21";
		String d2 = "2016-7-21  22:23:12";
		SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date date1 = df1.parse(d2);
		Date date2 = df2.parse(d2);
		System.out.println(date1.toString());
		System.out.println(date2.toString());
		Date dd = UtilDate.getDatePatterns(d2, new String[]{"yyyy-MM-dd","yyyy-MM-dd hh:mm:ss"});
		System.out.println("---->" + dd.toString());
		
		System.out.println(UtilDate.inTime("2016-7-21", new String[]{"2016-05-22","2016-07-21 22:00:00"}));
		
	}

	public boolean teReflectMethod1(String bool){
		System.out.println("如花美眷,似水流年~~");
		return "true".equals((String)bool);
	}

	public static void teContain() {
		String s = "xcf";
		Object[] ojbs = new Object[]{"opop",new File("xx"),new HashMap<String, String>(),"xcf"};
		System.out.println(UtilCollection.inArr(ojbs, s));;
	}

}
