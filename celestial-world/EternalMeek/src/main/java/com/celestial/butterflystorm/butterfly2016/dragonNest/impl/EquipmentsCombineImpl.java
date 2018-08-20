package com.celestial.butterflystorm.butterfly2016.dragonNest.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.celestial.agniRadiance.entity.FileReader;
import com.celestial.butterflystorm.butterfly2016.dragonNest.Interface.Equipment;
import com.celestial.butterflystorm.butterfly2016.dragonNest.Interface.EquipmentsCombine;
import com.celestial.butterflystorm.butterfly2016.dragonNest.entity.NumericDouble;
import com.celestial.butterflystorm.butterfly2016.dragonNest.entity.NumericInteger;
import com.celestial.butterflystorm.butterfly2016.dragonNest.other.Config;
import com.celestial.butterflystorm.butterfly2016.dragonNest.other.PropertySpace;

public class EquipmentsCombineImpl implements EquipmentsCombine {

	private List<Equipment> equipmentsList = new ArrayList<Equipment>();
	
	protected Map<String,NumericInteger> propertyLV1Map = new LinkedHashMap<String, NumericInteger>();
	protected Map<String,NumericInteger> propertyLV2Map = new LinkedHashMap<String, NumericInteger>();
	
	protected Map<String,NumericDouble> propertyMulMap = new LinkedHashMap<String, NumericDouble>();
	protected Map<String,NumericDouble> propertyFixedPCTMap = new LinkedHashMap<String, NumericDouble>();
	
	public EquipmentsCombineImpl(String equipmentsPath) {
		//-1.初始化话装备
		initEquipments(equipmentsPath);
		gather();
		System.out.println(1);
	}

	private void initEquipments(String equipmentsPath) {
		FileReader f = new FileReader(equipmentsPath);
		List<List<String>> l = f.selectAllLineBetweenRegexList(Config.SEPARATE_REGEX_WORD, Config.SEPARATE_REGEX_WORD);
		for(List<String> li : l){
			try {
				equipmentsList.add(new EquipmentImpl(li));
			} catch (Exception e) {
			}
		}
	}

	private void gather() {
		for(Equipment ei : equipmentsList){
			//遍历一个装备的固定百分比属性
			Map<String, NumericDouble> fixedPCTMap = ei.MapPropertyFixedPCT();
			for(Entry<String, NumericDouble> i : fixedPCTMap.entrySet()){
				String key = i.getKey();
				if(PropertySpace.propertyFixedPCTMap.get(key) != null)
					NumericDouble.put(propertyFixedPCTMap, key, i.getValue());
			}
			//遍历一个装备的属性(一级属性 + 二级属性)
			Map<String,NumericInteger> map = ei.MapProperty();
			for(Entry<String, NumericInteger> i : map.entrySet()){
				String key = i.getKey();
				if(null != PropertySpace.propertyListLV1Map.get(key))
					NumericInteger.put(propertyLV1Map, key, i.getValue());
				else if(null != PropertySpace.propertyListLV2Map.get(key))
					NumericInteger.put(propertyLV2Map, key, i.getValue());
			}
			//遍历一个装备的乘积属性
			Map<String,NumericDouble> mulMap = ei.MapPropertyMul();
			for(Entry<String, NumericDouble> i : mulMap.entrySet()){
				String key = i.getKey();
				if(null != PropertySpace.propertyMap.get(key))
					NumericDouble.put(propertyMulMap, key, i.getValue());
			}
		}
	}

	public List<Equipment> getEquipmentsList() {
		return equipmentsList;
	}

	public Map<String, NumericInteger> getPropertyLV1Map() {
		return propertyLV1Map;
	}

	public Map<String, NumericInteger> getPropertyLV2Map() {
		return propertyLV2Map;
	}

	public Map<String, NumericDouble> getPropertyFixedPCTMap() {
		return propertyFixedPCTMap;
	}

	public Map<String, NumericDouble> getPropertyMulMap() {
		return propertyMulMap;
	}
	
	
}
