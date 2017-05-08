package com.celestial.butterflystorm.butterfly2016.dragonNest.entity;

import java.util.Map;

import com.celestial.agniRadiance.EzUtil.Util_String;
import com.celestial.butterflystorm.butterfly2016.dragonNest.other.Config;

public class NumericDouble {
	
	private Double[] arr = new Double[2];

	public Double[] getArr() {
		return arr;
	}

	public void setArr(Double[] arr) {
		this.arr = arr;
	}
	
	public NumericDouble(String s){
		if(Util_String.matchAllSameRegx(s, Config.REGEX_DOUBLE_1)){
			//13.96%
			Double d = Double.valueOf(s.substring(0,s.indexOf("%")));
			arr[0] = d;
			arr[1] = d;
		}else{
			//4.31%~4.31%
			arr[0] = Double.valueOf(s.substring(0,s.indexOf("%")));
			arr[1] = Double.valueOf(s.substring(s.indexOf("~")+1,s.lastIndexOf("%")));
		}
	}
	
	public NumericDouble add(NumericDouble numeric) {
		arr[0] = arr[0] + numeric.getArr()[0];
		arr[1] = arr[1] + numeric.getArr()[1];
		return this;
	}
	
	@Override
	public String toString() {
		return new StringBuffer("[").append(arr[0]).append(",").append(arr[1]).append("]").toString();
	}

	public static void put(Map<String, NumericDouble> doubleMap,
			String key, String value) {
		NumericDouble nc = new NumericDouble(value);
		put(doubleMap,key,nc);
	}

	public static void put(Map<String, NumericDouble> doubleMap,
			String key, NumericDouble nc) {
		NumericDouble ncFormer = doubleMap.get(key);
		if(ncFormer != null)
			nc.add(ncFormer);
		doubleMap.put(key, nc);
	}
	
	public Double getValue(){
		return (arr[0] + arr[1])/2;
	}
}
