package com.celestial.butterflystorm.salary.tempAbstract.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.celestial.agniRadiance.EzUtil.Util_DB;
import com.celestial.agniRadiance.EzUtil.Util_Normal;
import com.celestial.butterflystorm.salary.Config.Config;


public abstract class ManagerEmployeeDaoTemp {
	
	protected Connection conn = null;
	protected Statement st = null;
	protected ResultSet rs = null;
	protected PreparedStatement ps = null;
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * methodAndParams�ṹ[����,"methodName",[param0,param1,param2...]]
	 * </ul>
	 * @param methodAndParams
	 */
	public Object todo(Object methodAndParams){
		Object obj = new Object();
		try {
			//eg:private void addEmployee1(Employee employee)
			obj = Util_Normal.excuteReflectObject2(methodAndParams);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("���ݿ���ز���ִ��ʧ��.");
		}
		finally{
			Util_DB.close(rs);
			Util_DB.close(st);
			Util_DB.close(ps);//����ps������Ϊst,���
			Util_DB.close(conn);
		}
		return obj;
	}
	public ManagerEmployeeDaoTemp() {
		this.conn = Config.getConnection();
	}
}
