/******************************************************************
 * HelloClient.java
 * Copyright 2017 by GNNT Company. All Rights Reserved.
 * CreateDate��2017��9��13��
 * Author��wangzg
 * Version��1.0.0
 ******************************************************************/

package com.celestial.meek.realTest_2017_09.S02WebService.test2;

import com.celestial.meek.realTest_2017_09.S02WebService.test2.webservice.HelloServiceService;

/**
 * <b>�޸ļ�¼��</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2017��9��13��
 * </li>
 * </p>
 * 
 * <b>��˵����</b>
 * <p> 
 * 
 * </p>
 */
public class HelloClient {

	public static void main(String[] args) { 
        HelloServiceService helloServiceService = new HelloServiceService(); 
        com.celestial.meek.realTest_2017_09.S02WebService.test2.webservice.HelloService helloService = helloServiceService.getHelloServicePort(); 
        System.out.println(helloService.sayHello("���")); 
    } 
}
