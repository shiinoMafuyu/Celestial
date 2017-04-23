package com.celestial.butterflystorm.puddingIII.tempAbstract.entity;

import java.io.File;
import java.lang.reflect.Method;

import com.celestial.agniRadiance.EzUtil.Util_File;
import com.celestial.butterflystorm.puddingIII.config.Config;

public abstract class TypeFileTemp {
	protected static Method m = null;
	static{
		try {
			m = Util_File.class.getDeclaredMethod(Config.CopyMethod.toString(), new Class[]{File.class,File.class});
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("获取拷贝方法失败.");
		} 
	}
}
