/******************************************************************
 * HelloService.java
 * Copyright 2017 by GNNT Company. All Rights Reserved.
 * CreateDate：2017年9月13日
 * Author：wangzg
 * Version：1.0.0
 ******************************************************************/

package com.celestial.meek.realTest_2017_09.S02WebService.test2;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

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
@WebService
public class HelloService {
	
	@WebMethod
	@WebResult(name="myReturn")
    public String sayHello(@WebParam(name="name")String message){
		System.out.println("--------------> 百年后的世界");
        return "Hello ," + message;    
    }
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {    
        //create and publish an endPoint    
      HelloService hello = new HelloService();    
      Endpoint endPoint = Endpoint.publish("http://localhost:8080/helloService", hello);    
  } 
}
