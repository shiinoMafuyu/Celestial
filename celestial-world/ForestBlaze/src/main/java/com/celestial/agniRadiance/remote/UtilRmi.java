/******************************************************************
 * UtilRmi.java
 * Copyright ${year} by WZG. All Rights Reserved.
 * CreateDate��2017��9��18��
 * Author��wangzg
 * Version��1.0.0
 ******************************************************************/

package com.celestial.agniRadiance.remote;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * <b>�޸ļ�¼��</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2017��9��18��
 * </li>
 * </p>
 * 
 * <b>��˵����</b>
 * <p> 
 * 
 * </p>
 */
public class UtilRmi {
	
	
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * rmi��������
	 * </ul>
	 * @param registerUrl
	 * @param rmiServer 
	 */
	public static void registerRmi(final String registerUrl,final int port,final Remote rmiServer) {
		try {
			System.out.println("��ʼrmiע�ᣬ����url�� "+registerUrl);
			LocateRegistry.createRegistry(port);
			Naming.bind(registerUrl, rmiServer);
	    } catch (Exception e) { 
	      e.printStackTrace(); 
	    }
	}
	
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * rmi��ȡ
	 * </ul>
	 * @param rmiUrl
	 * @return
	 */
	public static Remote getRmiService(String rmiUrl){
		Remote service = null;
		try {
			service = (Remote) Naming.lookup(rmiUrl);
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
		return service;
	}
	
}


/** ��spring��rmi���߽��з����͵��� */
//<?xml version="1.0" encoding="UTF-8"?>
//<beans xmlns="http://www.springframework.org/schema/beans"
//	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:context="http://www.springframework.org/schema/context"
//	xmlns:aop="http://www.springframework.org/schema/aop" xmlns:tx="http://www.springframework.org/schema/tx"
//	xsi:schemaLocation="http://www.springframework.org/schema/beans 
//           http://www.springframework.org/schema/beans/spring-beans-2.5.xsd
//           http://www.springframework.org/schema/context
//           http://www.springframework.org/schema/context/spring-context-2.5.xsd
//           http://www.springframework.org/schema/aop http://www.springframework.org/schema/aop/spring-aop-2.5.xsd
//           http://www.springframework.org/schema/tx http://www.springframework.org/schema/tx/spring-tx-2.5.xsd">
//
//    <!-- ��������RMI -->
//	
//	<!-- rmi���� -->
//	<bean id="forecastCoreRMI" class="gnnt.mobile.forecast.core.service.rmi.impl.ForecastCoreRMI" />
//    
//	<bean id="coreRMI" class="org.springframework.remoting.rmi.RmiServiceExporter">
//		<!-- ����ʵ���� -->
//		<property name="service">
//			<ref bean="forecastCoreRMI" />
//		</property>
//		<!-- ��������� -->
//		<property name="serviceName" value="forecastCoreRMI" />
//		<!-- ����ӿ� -->
//		<property name="serviceInterface">
//			<value>gnnt.mobile.forecast.core.interfaces.rmi.IForecastCoreRMI
//			</value>
//		</property>
//		<!-- ���Ŷ˿� -->
//		<property name="registryPort">
//			<value>${rmi.forecast.core.port}</value>
//		</property>
//		<!-- �������ݴ���˿� -->
//		<property name="servicePort">
//			<value>${rmi.forecast.core.dataPort}</value>
//		</property>
//	</bean>
//    
//	
//	
//    <!-- rmi���� -->
//	<bean id="forecastCoreRMI" class="org.springframework.remoting.rmi.RmiProxyFactoryBean"
//		lazy-init="true">
//		<property name="refreshStubOnConnectFailure" value="true" />
//		<property name="lookupStubOnStartup" value="false" />
//		<property name="serviceInterface"
//			value="gnnt.mobile.forecast.core.interfaces.rmi.IForecastCoreRMI" />
//			
//		<property name="serviceUrl"
//			value="rmi://${rmi.forecast.core.ip}:${rmi.forecast.core.port}/forecastCoreRMI" />	
//	</bean>
//	
//</beans>