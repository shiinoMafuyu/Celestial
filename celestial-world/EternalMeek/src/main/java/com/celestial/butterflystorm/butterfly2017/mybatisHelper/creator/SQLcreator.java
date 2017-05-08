package com.celestial.butterflystorm.butterfly2017.mybatisHelper.creator;

import java.util.ArrayList;
import java.util.List;

import com.celestial.agniRadiance.EzUtil.Util_String;
import com.celestial.butterflystorm.butterfly2017.mybatisHelper.depender.SQLdepender;

public class SQLcreator {

	
	public static final String ONE_TO_MANY = "many";
	public static final String ONE_TO_ONE = "one";
	
	private String tableName;
	private String tableCondition;
	
	private List<String> SQL = new ArrayList<String>();
	
	
	public SQLcreator(SQLdepender sQLdepender) {
		this.tableName = sQLdepender.getTableName();
		this.tableCondition = sQLdepender.getTableCondition();
		tableCreateSql(sQLdepender.getSqlList());
	}


	private void tableCreateSql(List<String[]> sqlList) {
		SQL.add("drop table "+tableName+";");
		SQL.add("create table "+tableName+"(");
		for(String[] si :sqlList){
			if(si[0].equals(""))
				SQL.add("");
			else
				SQL.add(new StringBuffer("	").append(si[0]).append(" ").append(si[1]).append(si[2]).append(",").toString());
		}
		SQL = Util_String.subStringLastChar(SQL, ",");
		SQL.add(")"+tableCondition);
		SQL.add("");
	}

	public List<String> getSQL() {
		return SQL;
	}

	public void setSQL(List<String> sQL) {
		SQL = sQL;
	}

}
