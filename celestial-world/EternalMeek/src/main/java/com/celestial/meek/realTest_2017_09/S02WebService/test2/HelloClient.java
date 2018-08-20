/******************************************************************
 * HelloClient.java
 * Copyright 2017 by GNNT Company. All Rights Reserved.
 * CreateDate：2017年9月13日
 * Author：wangzg
 * Version：1.0.0
 ******************************************************************/

package com.celestial.meek.realTest_2017_09.S02WebService.test2;

import com.celestial.meek.realTest_2017_09.S02WebService.test2.webservice.HelloServiceService;

/**
 * <b>修改记录：</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2017年9月13日
 * </li>
 * </p>
 * 
 * <b>类说明：</b>
 * <p> 
 * 
 * </p>
 */
public class HelloClient {

	public static void main(String[] args) { 
        HelloServiceService helloServiceService = new HelloServiceService(); 
        com.celestial.meek.realTest_2017_09.S02WebService.test2.webservice.HelloService helloService = helloServiceService.getHelloServicePort(); 
        System.out.println(helloService.sayHello("你好")); 
    } 
}
