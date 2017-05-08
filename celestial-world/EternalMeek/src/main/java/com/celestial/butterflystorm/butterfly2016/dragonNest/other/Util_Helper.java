package com.celestial.butterflystorm.butterfly2016.dragonNest.other;

import com.celestial.agniRadiance.EzUtil.Util_String;

public class Util_Helper {

	public static boolean checkDouble(String s) {
		//8.00% 或者 4.31%~4.31%两种
		return match(s,Config.REGEX_DOUBLE_1,Config.REGEX_DOUBLE_2);
	}

	private static boolean match(String s, String regex1, String regex2) {
		boolean b = false;
		try {
			boolean b1 = Util_String.matchAllSameRegx(s, regex1);
			boolean b2 = Util_String.matchAllSameRegx(s,regex2 );
			b = b1 || b2;
		} catch (Exception e) {
			e.printStackTrace();
//			throw new RuntimeException("格式不匹配:"+s);
		}
		return b;
	}

	public static boolean checkInteger(String s) {
		//12 或者 11~23两种.
		return match(s,Config.REGEX_Integer_1,Config.REGEX_Integer_2);
	}
	
}
