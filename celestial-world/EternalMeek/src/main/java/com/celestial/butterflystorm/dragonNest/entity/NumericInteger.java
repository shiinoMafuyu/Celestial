package com.celestial.butterflystorm.dragonNest.entity;

import java.util.Map;

import com.celestial.agniRadiance.EzUtil.Util_String;
import com.celestial.butterflystorm.dragonNest.other.Config;

public class NumericInteger {

	private Integer[] arr = new Integer[2];
	
	public Integer[] getArr(){
		return arr;
	}
	
	public void setArr(Integer[] arr){
		this.arr = arr;
	}
	
	public NumericInteger(String s) {
		if(Util_String.matchAllSameRegx(s, Config.REGEX_Integer_1)){
			//1300
			Integer i = Integer.valueOf(s);
			arr[0] = i;
			arr[1] = i;
		}else{
			//21~45
			arr[0] = Integer.valueOf(s.substring(0, s.indexOf("~")));
			arr[1] = Integer.valueOf(s.substring(s.indexOf("~")+1));
		}
	}
	
	public NumericInteger add(NumericInteger numeric) {
		arr[0] = arr[0] + numeric.getArr()[0];
		arr[1] = arr[1] + numeric.getArr()[1];
		return this;
	}
	
	@Override
	public String toString() {
		return new StringBuffer("[").append(arr[0]).append(",").append(arr[1]).append("]").toString();
	}

	public static void put(Map<String, NumericInteger> numericMap, String key,
			String value) {
		NumericInteger nc = new NumericInteger(value);
		put(numericMap,key,nc);
	}

	public static void put(Map<String, NumericInteger> numericMap, String key,
			NumericInteger nc) {
		NumericInteger ncFormer = numericMap.get(key);
		if(ncFormer != null)
			nc.add(ncFormer);
		numericMap.put(key, nc);
	}

	public Integer getValue(){
		return (arr[0] + arr[1])/2;
	}

}
