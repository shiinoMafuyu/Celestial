package com.celestial.butterflystorm.salary.Config;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import com.celestial.agniRadiance.EzUtil.Util_DB;

public class Config {
	
	/**数据库连接配置*/
	private static String userName = "root",passWord = "123",url = "jdbc:mysql://localhost/typemoon";
	

	@SuppressWarnings("serial")
	public static Map<String,String> IMPL_MAP = new HashMap<String, String>(){{
		put("InformationGetter", "com.salary.implement.infomationGetter.InformationReadLine");
		put("ManagerEmployeeDao", "com.salary.implement.dao.ManagerEmployeeDaoImpl");
		put("ManageEmployee", "com.salary.implement.manager.ManagerEmployeeImpl");
	}};
	
	
	/**根据配置获取实例的方法.*/
	
	public static Connection getConnection() {
		return Util_DB.getConnectionMySQL(userName, passWord, url);
	}
	
	
}
