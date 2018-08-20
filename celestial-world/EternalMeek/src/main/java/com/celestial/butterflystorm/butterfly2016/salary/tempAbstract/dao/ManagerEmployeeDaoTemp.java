package com.celestial.butterflystorm.butterfly2016.salary.tempAbstract.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.celestial.agniRadiance.EzUtil.UtilDB;
import com.celestial.agniRadiance.EzUtil.UtilReflect;
import com.celestial.butterflystorm.butterfly2016.salary.Config.Config;


public abstract class ManagerEmployeeDaoTemp {
	
	protected Connection conn = null;
	protected Statement st = null;
	protected ResultSet rs = null;
	protected PreparedStatement ps = null;
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * methodAndParams结构[对象,"methodName",[param0,param1,param2...]]
	 * </ul>
	 * @param methodAndParams
	 */
	public Object todo(Object methodAndParams){
		Object obj = new Object();
		try {
			//eg:private void addEmployee1(Employee employee)
			obj = UtilReflect.excuteReflectObject2(methodAndParams);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("数据库相关操作执行失败.");
		}
		finally{	
			UtilDB.close(rs);
			UtilDB.close(st);
			UtilDB.close(ps);//看来ps能造型为st,大概
			UtilDB.close(conn);
		}
		return obj;
	}
	public ManagerEmployeeDaoTemp() {
		this.conn = Config.getConnection();
	}
}
