package com.celestial.agniRadiance.map;

import java.util.HashMap;
import java.util.Map;

public class JavaToRS {
	public static Map<String, String> MAP = new HashMap<String, String>();
	static{
		MAP.put("int", "rs.getInt(\"ARG\")");
		MAP.put("Integer", "rs.getInt(\"ARG\")");
		MAP.put("String", "rs.getString(\"ARG\")");
		MAP.put("double", "rs.getDouble(\"ARG\")");
		MAP.put("Double", "rs.getDouble(\"ARG\")");
		
		MAP.put("Date", "new Date(rs.getTimestamp(\"ARG\").getTime())");
	}
}
