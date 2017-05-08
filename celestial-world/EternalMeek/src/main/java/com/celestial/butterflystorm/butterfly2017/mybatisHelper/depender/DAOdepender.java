package com.celestial.butterflystorm.butterfly2017.mybatisHelper.depender;

public class DAOdepender {
	
	private String className = "";
	private String daoName ="";
	
	public DAOdepender(String className, String daoName) {
		super();
		this.className = className;
		this.daoName = daoName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getDaoName() {
		return daoName;
	}

	public void setDaoName(String daoName) {
		this.daoName = daoName;
	}
	
	
	
}
