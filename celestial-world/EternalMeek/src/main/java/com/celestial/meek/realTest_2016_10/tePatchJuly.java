package com.celestial.meek.realTest_2016_10;

import java.io.File;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.celestial.agniRadiance.EzUtil.Util_Collection;
import com.celestial.agniRadiance.EzUtil.Util_File;
import com.celestial.agniRadiance.EzUtil.Util_Normal;


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
	private static void teZhengHeFile() {
		FileTreeWooder f = new FileTreeWooder();
		String filePath = "C:/Users/Administrator/Desktop/补丁包/00002上海自贸需要出整理的补丁";
		String destHead = "C:/Users/Administrator/Desktop/补丁包/0000-上海自贸姬梦娜测试部分(不含在线开户)";
		f.zhengHe(filePath, destHead, new String[]{"SelfOpenAccount"});
		
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
		Date dd = Util_Normal.getDatePatterns(d2, new String[]{"yyyy-MM-dd","yyyy-MM-dd hh:mm:ss"});
		System.out.println("---->" + dd.toString());
		
		System.out.println(Util_Normal.inTime("2016-7-21", new String[]{"2016-05-22","2016-07-21 22:00:00"}));
		
	}


	@SuppressWarnings("deprecation")
	private static void teInTime() {
		tePatchJuly t = new tePatchJuly();
		Calendar c0 = Calendar.getInstance();
		c0.set(2016, 6, 1, 12, 22, 22);
		
		
		Calendar c1 = Calendar.getInstance();
		c1.set(2016, 6, 6, 12, 22, 22);
		Calendar c2 = Calendar.getInstance();
		c2.set(2016, 6, 22, 12, 22, 22);
		Calendar c3 = Calendar.getInstance();
		c3.set(2016, 6, 25, 12, 22, 22);
		List<Object> l = new ArrayList<Object>();
		l.add(new Object[]{new Util_File()});
		try {
			//DBUtil.excuteReflectObjectAll(l);
			boolean b = Util_Normal.inTime(c0.getTime(), new Date[]{c1.getTime(),c2.getTime(),c3.getTime()});
			boolean b2 = Util_Normal.inTime("2016-07-21", new String[]{"2016-07-22","2016-07-23"});
			System.out.println(b);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}


	private static void teReflect() {
		tePatchJuly t = new tePatchJuly();
		List<Object> l = new ArrayList<Object>();
		l.add(new Object[]{"teReflectMethod1","true"});
		t.teReflect("前面的朋友你们好吗~", l);
		
	}


	private void teReflect(String s) {
		System.out.println(s);
		
	}


	/**
	 * object = 方法名 (String)+ 参数...(Object) 
	 * @param s
	 * @param objects
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void teReflect(String s,List<Object> objectsList) {
		System.out.println("万恶之源~");
		try {
			Class me = this.getClass();
			Method m = me.getMethod("teReflectMethod1", new Class[]{Object.class});
			boolean b = (Boolean)m.invoke(this, new Object[]{"true"});
			System.out.println("答案全部是 :" + (b?"不":"是"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public boolean teReflectMethod1(String bool){
		System.out.println("如花美眷,似水流年~~");
		return "true".equals((String)bool);
	}

	public static void teContain() {
		String s = "xcf";
		Object[] ojbs = new Object[]{"opop",new File("xx"),new HashMap<String, String>(),"xcf"};
		System.out.println(Util_Collection.contain(ojbs, s));;
	}

}
