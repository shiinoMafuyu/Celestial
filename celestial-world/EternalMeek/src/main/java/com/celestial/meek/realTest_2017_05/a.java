package com.celestial.meek.realTest_2017_05;

import com.celestial.agniRadiance.EzUtil.Util_Json;
import com.celestial.agniRadiance.EzUtil.test.entity.Equip;

public class a {
	public static void main(String[] args) {
		Equip e = new Equip().setName("тбоб");e.setGoodslevel("009300010001");e.setSuitId("qaq").setAf(12.33);
		
		String jsonstr = Util_Json.toJsonString(e);
		System.out.println(jsonstr);
	}
}
