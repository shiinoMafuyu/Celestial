/******************************************************************
 * TrueReadRelativePathFile.java
 * Copyright 2017 by GNNT Company. All Rights Reserved.
 * CreateDate��2017��5��23��
 * Author��wangzg
 * Version��1.0.0
 ******************************************************************/

package com.celestial.meek.realTest_2017_05;

import java.io.File;

import com.celestial.agniRadiance.entity.FileReader;

/**
 * <b>�޸ļ�¼��</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2017��5��23��
 * </li>
 * </p>
 * 
 * <b>��˵����</b>
 * <p> 
 * 
 * </p>
 */
public class TrueReadRelativePathFile {

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param args 
	 */
	public static void main(String[] args) {
		File f = new File(TrueReadRelativePathFile.class.getResource("/aspring-config-test.xml").getFile());
		FileReader f2 = new FileReader(f.getAbsolutePath(),false,"utf-8");
		f2.printAll();
	}

}
