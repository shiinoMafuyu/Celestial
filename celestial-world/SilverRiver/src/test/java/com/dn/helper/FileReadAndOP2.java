/******************************************************************
 * FileReadAndOP2.java
 * Copyright 2017 by WZG. All Rights Reserved.
 * CreateDate��2017��7��3��
 * Author��wangzg
 * Version��1.0.0
 ******************************************************************/

package com.dn.helper;

import com.celestial.agniRadiance.entity.FileReader;

/**
 * <b>�޸ļ�¼��</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2017��7��3��
 * </li>
 * </p>
 * 
 * <b>��˵����</b>
 * <p> 
 * 
 * </p>
 */
@SuppressWarnings("unused")
public class FileReadAndOP2 {

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param args 
	 */
	public static void main(String[] args) {
		
		
		
	}

	private static String[][] _07_readTagString() {
		String[][] sArr = null;
		FileReader f = new FileReader("src/test/resources/helper/01tempUse.txt",false,"gbk");
		String si="";
		while(f.hasNext()){
			si = f.readLine();
			String[] ssAr = new String[4];
		}
		
		return sArr;
	}
}
