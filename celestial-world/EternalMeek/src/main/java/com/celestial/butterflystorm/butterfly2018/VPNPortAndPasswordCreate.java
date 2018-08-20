package com.celestial.butterflystorm.butterfly2018;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.celestial.agniRadiance.EzUtil.UtilCollection;

public class VPNPortAndPasswordCreate {

	static final String[] sArr = new String[] {"Kurisu","Hitagi","Yamato","Kurusu","Takao","Musashi","Makise","Shipwreck","Megami","Chtholly","Nota","Seniori","Yukino","Yukari","Yuuki","Asuna"};
	
	public static List<String> createPortAndPassword(int port,int n){
		int len = sArr.length;
		Random r = new Random();
		List<String> res = new ArrayList<>();
		for(int i=0;i<n;i++) {
			String str = String.format("\"%s\":\"%s%s\"",port++,sArr[r.nextInt(len)],(int)(r.nextFloat()*10000));
			res.add(str);
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		
		
		for(Object oi : createPortAndPassword(8000,100)){
			System.out.println(oi+",");
		}
	}

}
