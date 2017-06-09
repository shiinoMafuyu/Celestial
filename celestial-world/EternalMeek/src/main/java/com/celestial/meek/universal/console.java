package com.celestial.meek.universal;

import com.celestial.agniRadiance.EzUtil.Util_String;

public class console {

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param args 
	 */
	public static void main(String[] args) {
		
		//																	  001  - 1    . 1     .  0    .  19 -  001
//		System.out.println(Util_String.matchAllSameRegx("001-1.1.0.19-001", "\\d{3}-\\d+\\.+\\d+\\.+\\d+\\.+\\d+-\\d{3}"));
		String[] sArr = new String[]{"001-1.1.0.19-001",
				"100-1.1.0.19-001",
				"106-1.0.0.18-001",
				"201-1.1.0.18-002",
				"202-1.1.0.18-001",
				"205-1.0.0.18-001"};
		
		System.out.println(sArr[0].replaceAll("\\.", "-"));
		
		
		
		
	}

}
