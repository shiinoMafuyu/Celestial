package com.celestial.butterflystorm.butterfly2016.dragonNest.Interface;

import java.util.Map;

import com.celestial.butterflystorm.butterfly2016.dragonNest.entity.NumericDouble;
import com.celestial.butterflystorm.butterfly2016.dragonNest.entity.NumericInteger;

public interface Equipment {
	public Map<String,NumericInteger> MapProperty();
	public Map<String,NumericDouble> MapPropertyFixedPCT();
	public Map<String,NumericDouble> MapPropertyMul();
	public String showMsg();
}
