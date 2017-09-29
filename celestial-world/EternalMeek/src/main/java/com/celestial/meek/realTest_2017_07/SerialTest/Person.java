/******************************************************************
 * Person.java
 * Copyright 2017 by WZG. All Rights Reserved.
 * CreateDate��2017��7��23��
 * Author��wangzg
 * Version��1.0.0
 ******************************************************************/

package com.celestial.meek.realTest_2017_07.SerialTest;

import java.io.Serializable;

/**
 * <b>�޸ļ�¼��</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2017��7��23��
 * </li>
 * </p>
 * 
 * <b>��˵����</b>
 * <p> 
 * 
 * </p>
 */
public class Person implements Serializable {

	/**  */
	private static final long serialVersionUID = 1516766358834382649L;
	
	/**
     * ����
     */
    private String name;
    /**
     * ����
     */
    private int age;

    public Person() {
    }
    
    

    @Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}



	public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Person setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Person setAge(int age) {
        this.age = age;
        return this;
    }
}
