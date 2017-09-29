package com.celestial.butterflystorm.butterfly2017.dontstarve;

import com.celestial.agniRadiance.EzUtil.UtilFile;
import com.celestial.butterflystorm.butterfly2017.dontstarve.core.Save;

public class Sever {

	public static void main(String[] args) {
		ConfigVO configVO = new ConfigVO(UtilFile.readProperties(UtilFile.load("config.txt"),"gbk"));
		Save save = new Save(configVO);
		save.start();
		
		
	}


}
