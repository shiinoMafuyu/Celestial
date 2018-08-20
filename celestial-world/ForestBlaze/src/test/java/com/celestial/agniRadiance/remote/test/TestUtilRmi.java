/******************************************************************
 * TestUtilRmi.java
 * Copyright ${year} by WZG. All Rights Reserved.
 * CreateDate：2017年9月18日
 * Author：wangzg
 * Version：1.0.0
 ******************************************************************/

package com.celestial.agniRadiance.remote.test;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.Timestamp;

import org.junit.Assert;
import org.junit.Test;

import com.celestial.agniRadiance.context.ComputerEnvironment;
import com.celestial.agniRadiance.remote.UtilRmi;


/**
 * <b>修改记录：</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2017年9月18日
 * </li>
 * </p>
 * 
 * <b>类说明：</b>
 * <p> 
 * 
 * </p>
 */
public class TestUtilRmi {
	
	private static String host = ComputerEnvironment.getHostAddress();
	private static int port = 7789;
	private static String serviceName = "searchPersonService";
	private static String rmiUrl = String.format("rmi://%s:%s/%s",host,port,serviceName);
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 测试rmi发布和调用方法<br/>
	 * registerRmi()<br/>
	 * getRmiService()<br/>
	 * </ul>
	 */
	@Test
	public void _01_00_rmiPublishAndGet(){
		
		UtilRmi.registerRmi(rmiUrl, port, new ServiceRMI());
		
		IServiceRMI searchPersonService = (IServiceRMI) UtilRmi.getRmiService(rmiUrl);
		try {
			String name = "无心无影・残魂";
			Integer age = 78;
			Person theOne = searchPersonService.searchPerson(name, age);
			Assert.assertEquals(name, theOne.getName());
			Assert.assertEquals(age, theOne.getAge());
			System.out.println(theOne);
			
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
}



interface IServiceRMI extends Remote{
	
	public Person searchPerson(String name, Integer age) throws RemoteException ; 
}

class ServiceRMI implements IServiceRMI,Serializable{
	/**  */
	private static final long serialVersionUID = 1L;
	@Override
	public Person searchPerson(String name, Integer age) throws RemoteException {
		return new Person().setName(name).setAge(age);
	}
	
}


class Person implements Serializable{
	/**  */
	private static final long serialVersionUID = 8178420400113112129L;
	private String name;
	private Integer age;
	private Timestamp bornTime;
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", bornTime=" + bornTime + "]";
	}
	
	
	public String getName() {
		return name;
	}
	public Integer getAge() {
		return age;
	}
	public Timestamp getBornTime() {
		return bornTime;
	}
	public Person setName(String name) {
		this.name = name;
		return this;
	}
	public Person setAge(Integer age) {
		this.age = age;
		return this;
	}
	public Person setBornTime(Timestamp bornTime) {
		this.bornTime = bornTime;
		return this;
	}
	
	
	
	
}







