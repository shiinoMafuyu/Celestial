/******************************************************************
 * TrueReadRelativePathFile.java
 * Copyright 2017 by GNNT Company. All Rights Reserved.
 * CreateDate：2017年5月23日
 * Author：wangzg
 * Version：1.0.0
 ******************************************************************/

package com.celestial.meek.realTest_2017_05;

import java.io.File;

import com.celestial.agniRadiance.entity.FileReader;

/**
 * <b>修改记录：</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2017年5月23日
 * </li>
 * </p>
 * 
 * <b>类说明：</b>
 * <p> 
 * 
 * </p>
 */
public class TrueReadRelativePathFile {

	/**
	 * <b>方法说明：</b>
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
