package com.celestial.butterflystorm.butterfly2016.dragonNest.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.celestial.butterflystorm.butterfly2016.dragonNest.Abstract.PropertyEntity;
import com.celestial.butterflystorm.butterfly2016.dragonNest.Interface.Equipment;
import com.celestial.butterflystorm.butterfly2016.dragonNest.entity.NumericDouble;
import com.celestial.butterflystorm.butterfly2016.dragonNest.entity.NumericInteger;
import com.celestial.butterflystorm.butterfly2016.dragonNest.other.PropertySpace;
import com.celestial.butterflystorm.butterfly2016.dragonNest.other.Util_Helper;

public class EquipmentImpl extends PropertyEntity implements Equipment {
	
	private List<String> propertyMsgList = new ArrayList<String>();
	
	@Override
	public Map<String, NumericInteger> MapProperty() {
		return this.propertyMap;
	}

	@Override
	public Map<String, NumericDouble> MapPropertyFixedPCT() {
		return this.propertyFixedPCTMap;
	}

	@Override
	public Map<String, NumericDouble> MapPropertyMul() {
		return this.propertyMulMap;
	}
	
	public EquipmentImpl(List<String> ls) {
		initPropertyMsgList(ls);
		initPropertyVariable();
	}

	private void initPropertyMsgList(List<String> ls) {
		for(String si : ls){
			if(si != null && !si.contains("#")){
				this.propertyMsgList.add(si);
			}
		}
		
	}

	private void initPropertyVariable() {
		for(String si : this.propertyMsgList){
			if(!si.contains("="))
				continue;
			int index = si.indexOf("=");
			String key = si.substring(0, index);
			String value = si.substring(index+1);
			if(PropertySpace.propertyFixedPCTMap.get(key) != null){
				//是固定属性值光暗火水 + 抗
				//在固定属性值里面只可能是%
				if(!Util_Helper.checkDouble(value))
					continue;
				NumericDouble.put(propertyFixedPCTMap,key,value);
			}else if(PropertySpace.propertyMap.get(key) != null){
				//是一般属性值
				if(Util_Helper.checkInteger(value))
				{
					//是属性值的时候 物攻:50~60
					//将key,value对应的键值对里的值,叠加到map以前的key,value里(没有则新建,有则叠加)
					NumericInteger.put(propertyMap,key,value);
				}else if(Util_Helper.checkDouble(value)){
					//是属性百分比的时候 物攻:5.00%~5.00%
					//将key,value对应的键值对里的值,叠加到map以前的key,value里(没有则新建,有则叠加)
					NumericDouble.put(propertyMulMap,key,value);
				}
			}
		}
	}


	
}
