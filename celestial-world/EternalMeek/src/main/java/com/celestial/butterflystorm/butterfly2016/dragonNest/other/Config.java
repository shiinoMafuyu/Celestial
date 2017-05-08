package com.celestial.butterflystorm.butterfly2016.dragonNest.other;

public class Config {
	public static final String PROPERTY_LV1_MAP_PATH = "src/com/dragonNest/other/PropertyListLV1.properties";
	public static final String PROPERTY_LV2_MAP_PATH = "src/com/dragonNest/other/PropertyListLV2.properties";
	public static final String PROPERTY_FIXEDPCTMAP_PATH = "src/com/dragonNest/other/PropertyFixedPCT.properties";
	
	public static final String SEPARATE_REGEX_WORD = ".*#.*";
	
	//匹配百分比Double的字符串
	public static final String REGEX_DOUBLE_1 = "(\\d*\\.\\d*)+%";
	public static final String REGEX_DOUBLE_2 = "(\\d*\\.\\d*)+%~(\\d*\\.\\d*)+%";
	
	public static final String REGEX_Integer_1 = "\\d+";
	public static final String REGEX_Integer_2 = "\\d+~\\d+";
}
