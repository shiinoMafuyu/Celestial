package com.celestial.butterflystorm.butterfly2016.puddingIII.tempAbstract.entity;

import java.io.File;
import java.lang.reflect.Method;

import com.celestial.agniRadiance.EzUtil.UtilFile;
import com.celestial.butterflystorm.butterfly2016.puddingIII.config.Config;

public abstract class TypeFileTemp {
	protected static Method m = null;
	static{
		try {
			m = UtilFile.class.getDeclaredMethod(Config.CopyMethod.toString(), new Class[]{File.class,File.class});
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("获取拷贝方法失败.");
		} 
	}
}
