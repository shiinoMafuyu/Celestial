package com.celestial.butterflystorm.butterfly2017.mybatisHelper.depender;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.celestial.agniRadiance.EzUtil.Util_String;

public class XMLdepender {
	/**
	���� ȫ���ֶ� ����
	���� ȫ���ֶ� ����

	������������Ӧ�ֶ�
	
	����  + ����   StrengthKind=StrengthKind,level=level|strengthen
	*/
	
	private String fullDaoName ="";
	private String fullClassName ="";
	private String tableName ="";
	private String className ="";
	
	/**����һ����Ĺ����ֶ�*/
	private List<String[]> joinOnList = new ArrayList<String[]>();//"level=level,strengthenKind=strengthenKind|strengthen|strengthenList|com.dn.entity.Strengthen|many"
	
	private List<String[]> columnList = new ArrayList<String[]>();
	
	private Map<String,XMLdepender> xMLdependerMap = new HashMap<String,XMLdepender>();

	public XMLdepender(String fullDaoName, String fullClassName,
			String tableName, List<String[]> columnList) {
		super();
		this.fullDaoName = fullDaoName;
		this.fullClassName = fullClassName;
		this.tableName = tableName;
		this.columnList = columnList;
		onFullClassNameChange();
	}
	
	public XMLdepender(String fullClassName, String tableName,
			List<String[]> columnList) {
		super();
		this.fullClassName = fullClassName;
		this.tableName = tableName;
		this.columnList = columnList;
		onFullClassNameChange();
	}

	private void onFullClassNameChange() {
		this.className = Util_String.__getStrAfterLast(this.fullClassName, ".");
	}

	public XMLdepender(String path) {
		
	}

	public XMLdepender() {
		
	}

	public String getFullDaoName() {
		return fullDaoName;
	}

	public XMLdepender setFullDaoName(String fullDaoName) {
		this.fullDaoName = fullDaoName;
		return this;
		
	}

	public String getFullClassName() {
		return fullClassName;
	}

	public XMLdepender setFullClassName(String fullClassName) {
		this.fullClassName = fullClassName;
		onFullClassNameChange();
		return this;
	}

	public String getTableName() {
		return tableName;
	}

	public XMLdepender setTableName(String tableName) {
		this.tableName = tableName;
		return this;
	}

	public List<String[]> getJoinOnList() {
		return joinOnList;
	}

	public XMLdepender setJoinOnArr(List<String[]>  joinOnList) {
		this.joinOnList = joinOnList;
		return this;
	}

	public List<String[]> getColumnList() {
		return columnList;
	}

	public XMLdepender setColumnList(List<String[]> columnList) {
		this.columnList = columnList;
		return this;
	}

	public Map<String,XMLdepender> getxMLdependerMap() {
		return xMLdependerMap;
	}

	public XMLdepender setxMLdependerMap(Map<String,XMLdepender> xMLdependerMap) {
		this.xMLdependerMap = xMLdependerMap;
		return this;
	}

	public String getClassName() {
		return className;
	}

	
	//��ô������ȡ? ����ͨ��DependerContainer��ȡ�ġ��ȴ��̣�
	//�����ֶη��Ķ�? ok!
	
	
	
}
