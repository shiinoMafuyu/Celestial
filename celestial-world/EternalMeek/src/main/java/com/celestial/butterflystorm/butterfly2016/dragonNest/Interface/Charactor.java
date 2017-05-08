package com.celestial.butterflystorm.butterfly2016.dragonNest.Interface;

import java.util.Map;

import com.celestial.butterflystorm.butterfly2016.dragonNest.entity.NumericDouble;
import com.celestial.butterflystorm.butterfly2016.dragonNest.entity.NumericInteger;


public interface Charactor {
	Map<String,NumericDouble> getTypeAttack();
	Map<String,NumericInteger> getMsgOther();
	Map<String,NumericInteger> getProperty();
	Map<String,NumericInteger> getNormal();
}
