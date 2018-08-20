package com.celestial.butterflystorm.butterfly2017.mybatisHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.celestial.agniRadiance.entity.FileReader;
import com.celestial.butterflystorm.butterfly2017.mybatisHelper.depender.DAOdepender;
import com.celestial.butterflystorm.butterfly2017.mybatisHelper.depender.ENTITYdepender;
import com.celestial.butterflystorm.butterfly2017.mybatisHelper.depender.SQLdepender;
import com.celestial.butterflystorm.butterfly2017.mybatisHelper.depender.XMLdepender;
import com.celestial.butterflystorm.butterfly2017.mybatisHelper.util.Util_ASOReader;

public class DependerContainer {
	
	private ENTITYdepender eNTITYdepender;
	private SQLdepender sQLdepender;
	private DAOdepender dAOdepender;
	private XMLdepender xMLdepender;
	
	
	private FileReader f;
	
	private List<String[]> sqlList = new ArrayList<String[]>();
	private List<String[]> classList = new ArrayList<String[]>();
	
	/**类创建信息*/
	private Map<String,String> createInfoMap = new HashMap<String, String>();
	
	public DependerContainer(String path){
		super();
		f = Util_ASOReader.readASONoAnnotion(path);
		init_classInfo();
		
		createDepender(path);
		
	}
	
	private void createDepender(String path) {
		
		eNTITYdepender = new ENTITYdepender(classList, createInfoMap.get("fullClassName"));
		sQLdepender = new SQLdepender(createInfoMap.get("tableName"), createInfoMap.get("tableCondition"), sqlList);
		dAOdepender = new DAOdepender(createInfoMap.get("className"), createInfoMap.get("daoName"));
		
		xMLdepender = Util_ASOReader.createXMLdepernder(path);
	}

	private void init_classInfo() {
		
		createInfoMap = Util_ASOReader.getInfoMap(f);
		classList = Util_ASOReader.getClassPropertiesList(f);
		sqlList = Util_ASOReader.getSQLPropertiesList(f);
		
	}

	public DAOdepender getDAOdepender() {
		return dAOdepender;
	}

	public void setDAOdepender(DAOdepender dAOdepender) {
		this.dAOdepender = dAOdepender;
	}

	public ENTITYdepender getENTITYdepender() {
		return eNTITYdepender;
	}

	public void setENTITYdepender(ENTITYdepender eNTITYdepender) {
		this.eNTITYdepender = eNTITYdepender;
	}

	public SQLdepender getSQLdepender() {
		return sQLdepender;
	}

	public void setSQLdepender(SQLdepender sQLdepender) {
		this.sQLdepender = sQLdepender;
	}

	public XMLdepender getXMLdepender() {
		return xMLdepender;
	}

	public void setXMLdepender(XMLdepender xMLdepender) {
		this.xMLdepender = xMLdepender;
	}
	
	
	
	
}
