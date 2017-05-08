package com.celestial.butterflystorm.butterfly2017.mybatisHelper.depender;

import java.util.List;

public class SQLdepender {
	
	private String tableName;
	private String tableCondition;
	private List<String[]> sqlList;
	
	public SQLdepender(String tableName, String tableCondition,
			List<String[]> sqlList) {
		super();
		this.tableName = tableName;
		this.tableCondition = tableCondition;
		this.sqlList = sqlList;
	}

	public String getTableName() {
		return tableName;
	}
	
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	
	public String getTableCondition() {
		return tableCondition;
	}
	
	public void setTableCondition(String tableCondition) {
		this.tableCondition = tableCondition;
	}
	
	public List<String[]> getSqlList() {
		return sqlList;
	}
	
	public void setSqlList(List<String[]> sqlList) {
		this.sqlList = sqlList;
	}
	
	
}
