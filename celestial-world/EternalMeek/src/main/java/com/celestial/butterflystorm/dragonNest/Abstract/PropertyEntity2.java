package com.celestial.butterflystorm.dragonNest.Abstract;

import java.util.LinkedHashMap;
import java.util.Map;

import com.celestial.butterflystorm.dragonNest.entity.NumericDouble;
import com.celestial.butterflystorm.dragonNest.entity.NumericInteger;

public abstract class PropertyEntity2 {
	protected Map<String,NumericInteger> propertyLV1Map = new LinkedHashMap<String, NumericInteger>();
	protected Map<String,NumericInteger> propertyLV2Map = new LinkedHashMap<String, NumericInteger>();
	protected Map<String,NumericDouble> propertyMulLV1Map = new LinkedHashMap<String, NumericDouble>();
	protected Map<String,NumericDouble> propertyMulLV2Map = new LinkedHashMap<String, NumericDouble>();
	
	protected Map<String,NumericDouble> propertyFixedPCTMap = new LinkedHashMap<String, NumericDouble>();
	
}
