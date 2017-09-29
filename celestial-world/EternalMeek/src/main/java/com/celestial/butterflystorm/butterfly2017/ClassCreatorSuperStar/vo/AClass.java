/******************************************************************
 * AClass.java
 * Copyright 2017 by WZG. All Rights Reserved.
 * CreateDate��2017��6��9��
 * Author��wangzg
 * Version��1.0.0
 ******************************************************************/

package com.celestial.butterflystorm.butterfly2017.ClassCreatorSuperStar.vo;

/**
 * <b>�޸ļ�¼��</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2017��6��9��
 * </li>
 * </p>
 * 
 * <b>��˵����</b>
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
	
	private String classAnnotion = "һ�����й��ܵĲ������ܴ����ݣ������㡣";
	private String author = "wangzg";

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ��ȡ
	 * </ul>
	 * @return the qualifiedName
	 */
	public String getQualifiedName() {
		return qualifiedName;
	}


	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ��ȡ
	 * </ul>
	 * @return the superName
	 */
	public String getSuperName() {
		return superName;
	}

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ��ȡ
	 * </ul>
	 * @return the interfaces
	 */
	public String[] getInterfaces() {
		return interfaces;
	}

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ��ȡ
	 * </ul>
	 * @return the innerClass
	 */
	public AClass[] getInnerClass() {
		return innerClass;
	}

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ��ȡ
	 * </ul>
	 * @return the variables
	 */
	public String[][] getVariables() {
		return variables;
	}

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ����
	 * </ul>
	 * qualifiedName
	 */
	public AClass setQualifiedName(String qualifiedName) {
		this.qualifiedName = qualifiedName;
		return this;
	}

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ����
	 * </ul>
	 * superName
	 */
	public AClass setSuperName(String superName) {
		this.superName = superName;
		return this;
	}

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ����
	 * </ul>
	 * interfaces
	 */
	public AClass setInterfaces(String[] interfaces) {
		this.interfaces = interfaces;
		return this;
	}

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ����
	 * </ul>
	 * innerClass
	 */
	public AClass setInnerClass(AClass[] innerClass) {
		this.innerClass = innerClass;
		return this;
	}

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ����
	 * </ul>
	 * variables
	 */
	public AClass setVariables(String[][] variables) {
		this.variables = variables;
		return this;
	}


	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ��ȡ
	 * </ul>
	 * @return the classAnnotion
	 */
	public String getClassAnnotion() {
		return classAnnotion;
	}


	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ����
	 * </ul>
	 * classAnnotion
	 */
	public void setClassAnnotion(String classAnnotion) {
		this.classAnnotion = classAnnotion;
	}


	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ��ȡ
	 * </ul>
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}


	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ����
	 * </ul>
	 * author
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	
	
	
	
	
	
}
