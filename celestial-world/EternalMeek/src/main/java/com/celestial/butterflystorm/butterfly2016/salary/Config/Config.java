package com.celestial.butterflystorm.butterfly2016.salary.Config;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import com.celestial.agniRadiance.EzUtil.UtilDB;

public class Config {
	
	/**���ݿ���������*/
	private static String userName = "root",passWord = "123",url = "jdbc:mysql://localhost/typemoon";
	

	@SuppressWarnings("serial")
	public static Map<String,String> IMPL_MAP = new HashMap<String, String>(){{
		put("InformationGetter", "com.salary.implement.infomationGetter.InformationReadLine");
		put("ManagerEmployeeDao", "com.salary.implement.dao.ManagerEmployeeDaoImpl");
		put("ManageEmployee", "com.salary.implement.manager.ManagerEmployeeImpl");
	}};
	
	
	/**�������û�ȡʵ���ķ���.*/
	
	public static Connection getConnection() {
		return UtilDB.getConnectionMySQL(userName, passWord, url);
	}
	
	
}