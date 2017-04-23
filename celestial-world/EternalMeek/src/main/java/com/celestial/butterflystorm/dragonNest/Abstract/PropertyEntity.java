package com.celestial.butterflystorm.dragonNest.Abstract;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.celestial.butterflystorm.dragonNest.entity.NumericDouble;
import com.celestial.butterflystorm.dragonNest.entity.NumericInteger;


public abstract class PropertyEntity {

	protected String name = "";
	protected Map<String,NumericInteger> propertyMap = new LinkedHashMap<String, NumericInteger>();
	protected Map<String,NumericDouble> propertyFixedPCTMap = new LinkedHashMap<String, NumericDouble>();
	protected Map<String,NumericDouble> propertyMulMap = new LinkedHashMap<String, NumericDouble>();
	
	public String getName() {
		return name;
	}

	public Map<String, NumericInteger> getPropertyMap() {
		return propertyMap;
	}

	public Map<String, NumericDouble> getPropertyFixedPCTMap() {
		return propertyFixedPCTMap;
	}

	public Map<String, NumericDouble> getPropertyMulMap() {
		return propertyMulMap;
	}

	public String showMsg() {
		StringBuffer sb = new StringBuffer(name).append(" :\n");
		for(Entry<String, NumericInteger> ei : propertyMap.entrySet()){
			sb.append(ei.getKey()).append(" : ").append(ei.getValue()).append("\n");
		}
		
		for(Entry<String, NumericDouble> ei : propertyMulMap.entrySet()){
			sb.append(ei.getKey()).append(" : ").append(ei.getValue()).append("\n");
		}
		
		for(Entry<String, NumericDouble> ei : propertyFixedPCTMap.entrySet()){
			sb.append(ei.getKey()).append(" : ").append(ei.getValue()).append("\n");
		}
		return sb.toString();
	}
	
	@Override
	public String toString() {
		return showMsg();
	}
}
