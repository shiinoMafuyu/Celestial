package com.celestial.meek.realTest_2017_05;

import com.celestial.agniRadiance.EzUtil.Util_String;

public class a2 {
	public static void main(String[] args) {
		boolean b = Util_String.matchAllSameRegx("<classpathentry kind=\"src\" path=\"src/account-src\"/>",
				"<classpathentry\\s+kind=\"src\"\\s+path=\"src/.*\"\\s*/>");
		System.out.println(b);
	}
}
