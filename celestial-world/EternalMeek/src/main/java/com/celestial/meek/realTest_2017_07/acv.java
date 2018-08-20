/******************************************************************
 * acv.java
 * Copyright 2017 by WZG. All Rights Reserved.
 * CreateDate：2017年7月3日
 * Author：wangzg
 * Version：1.0.0
 ******************************************************************/

package com.celestial.meek.realTest_2017_07;

import com.celestial.agniRadiance.EzUtil.UtilString;

/**
 * <b>修改记录：</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2017年7月3日
 * </li>
 * </p>
 * 
 * <b>类说明：</b>
 * <p> 
 * 
 * </p>
 */
public class acv {
	
	public static void main(String[] args) {
		String s0 = "typeID no name prizeID receiveIndate status".replaceAll(",", " ");
		str2Variable(s0);
//		String sss= "gameID , typeID , levelNO , userID , prizeID , name , telephone , address , abortTime , applyTime , status";
//		str2GetObject(sss);
		
//		String ss = "ID gameID typeID levelNO userID prizeID name telephone address abortTime applyTime status";
//		str2Variable(ss);
		
		
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param sss 
	 */
	 static void str2GetObject(String sss) {
		String[] sssArr = sss.replaceAll(" ", "").split(",");
		for(String si : sssArr){
			System.out.print("po.get"+UtilString.transHeadToUpperCase(si)+"(), ");
		}
		System.out.println();
	}

	 static void str2Variable(String ss){
		String[] sArr =ss.split(" ");
		for(String si: sArr){
			si = UtilString.transHeadToLowerCase(si);
			System.out.println("/**  */");
			System.out.println("private String " + si + ";\n");
		}
	}
	
}
