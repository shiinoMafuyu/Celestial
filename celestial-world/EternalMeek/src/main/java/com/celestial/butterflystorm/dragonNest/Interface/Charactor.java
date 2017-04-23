package com.celestial.butterflystorm.dragonNest.Interface;

import java.util.Map;

import com.celestial.butterflystorm.dragonNest.entity.NumericDouble;
import com.celestial.butterflystorm.dragonNest.entity.NumericInteger;


public interface Charactor {
	Map<String,NumericDouble> getTypeAttack();
	Map<String,NumericInteger> getMsgOther();
	Map<String,NumericInteger> getProperty();
	Map<String,NumericInteger> getNormal();
}
