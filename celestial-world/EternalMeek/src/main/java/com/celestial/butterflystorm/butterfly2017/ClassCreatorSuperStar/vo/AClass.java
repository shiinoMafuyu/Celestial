/******************************************************************
 * AClass.java
 * Copyright 2017 by WZG. All Rights Reserved.
 * CreateDate：2017年6月9日
 * Author：wangzg
 * Version：1.0.0
 ******************************************************************/

package com.celestial.butterflystorm.butterfly2017.ClassCreatorSuperStar.vo;

/**
 * <b>修改记录：</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2017年6月9日
 * </li>
 * </p>
 * 
 * <b>类说明：</b>
 * <p> 
 * 
 * </p>
 */
public class AClass {
	
	private String qualifiedName = "";
	private String superName = "";
	
	private String[] interfaces = new String[]{};
	private AClass[] innerClass = new AClass[]{};
	private String[][] variables = new String[][]{};
	
	private String classAnnotion = "一个具有功能的部件，能存数据，能运算。";
	private String author = "wangzg";

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取
	 * </ul>
	 * @return the qualifiedName
	 */
	public String getQualifiedName() {
		return qualifiedName;
	}


	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取
	 * </ul>
	 * @return the superName
	 */
	public String getSuperName() {
		return superName;
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取
	 * </ul>
	 * @return the interfaces
	 */
	public String[] getInterfaces() {
		return interfaces;
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取
	 * </ul>
	 * @return the innerClass
	 */
	public AClass[] getInnerClass() {
		return innerClass;
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取
	 * </ul>
	 * @return the variables
	 */
	public String[][] getVariables() {
		return variables;
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 设置
	 * </ul>
	 * qualifiedName
	 */
	public AClass setQualifiedName(String qualifiedName) {
		this.qualifiedName = qualifiedName;
		return this;
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 设置
	 * </ul>
	 * superName
	 */
	public AClass setSuperName(String superName) {
		this.superName = superName;
		return this;
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 设置
	 * </ul>
	 * interfaces
	 */
	public AClass setInterfaces(String[] interfaces) {
		this.interfaces = interfaces;
		return this;
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 设置
	 * </ul>
	 * innerClass
	 */
	public AClass setInnerClass(AClass[] innerClass) {
		this.innerClass = innerClass;
		return this;
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 设置
	 * </ul>
	 * variables
	 */
	public AClass setVariables(String[][] variables) {
		this.variables = variables;
		return this;
	}


	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取
	 * </ul>
	 * @return the classAnnotion
	 */
	public String getClassAnnotion() {
		return classAnnotion;
	}


	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 设置
	 * </ul>
	 * classAnnotion
	 */
	public void setClassAnnotion(String classAnnotion) {
		this.classAnnotion = classAnnotion;
	}


	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取
	 * </ul>
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}


	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 设置
	 * </ul>
	 * author
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	
	
	
	
	
	
}
