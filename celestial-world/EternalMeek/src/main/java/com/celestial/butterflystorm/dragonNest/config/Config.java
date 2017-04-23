package com.celestial.butterflystorm.dragonNest.config;

import java.util.HashMap;
import java.util.Map;

public class Config {

	@SuppressWarnings("serial")
	public static final Map<String, String> IMPL_MAP = new HashMap<String, String>(){{
		put("Charactor", "com.dragonNest.impl.CharactorImpl");
		put("Equipment", "com.dragonNest.impl.EquipmentImpl");
		put("EquipmentsCombine", "com.dragonNest.impl.EquipmentsCombineImpl");
	}};

}
