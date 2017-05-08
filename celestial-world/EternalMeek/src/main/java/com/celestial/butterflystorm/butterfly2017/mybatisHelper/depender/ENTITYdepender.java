package com.celestial.butterflystorm.butterfly2017.mybatisHelper.depender;

import java.util.ArrayList;
import java.util.List;

import com.celestial.agniRadiance.EzUtil.Util_String;

public class ENTITYdepender {
	
	/**
	 * String[] = [成员变量名，类型，注释]
	 */
	private List<String[]> classList = new ArrayList<String[]>();
	
	private String qualifiedName;
	
	private String className;

	public List<String[]> getClassList() {
		return classList;
	}
	
	public ENTITYdepender(List<String[]> classList, String qualifiedName) {
		super();
		this.classList = classList;
		this.qualifiedName = qualifiedName;
		changeClassName();
	}

	private void changeClassName() {
		className = Util_String.__getStrAfterLast(this.qualifiedName,".");
	}
	
	

	public void setClassList(List<String[]> classList) {
		this.classList = classList;
	}

	public String getQualifiedName() {
		return qualifiedName;
	}

	public void setQualifiedName(String qualifiedName) {
		this.qualifiedName = qualifiedName;
		changeClassName();
	}

	public String getClassName() {
		return className;
	}
	
}
