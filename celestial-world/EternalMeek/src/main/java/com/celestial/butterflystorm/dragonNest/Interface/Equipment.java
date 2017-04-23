package com.celestial.butterflystorm.dragonNest.Interface;

import java.util.Map;

import com.celestial.butterflystorm.dragonNest.entity.NumericDouble;
import com.celestial.butterflystorm.dragonNest.entity.NumericInteger;

public interface Equipment {
	public Map<String,NumericInteger> MapProperty();
	public Map<String,NumericDouble> MapPropertyFixedPCT();
	public Map<String,NumericDouble> MapPropertyMul();
	public String showMsg();
}
