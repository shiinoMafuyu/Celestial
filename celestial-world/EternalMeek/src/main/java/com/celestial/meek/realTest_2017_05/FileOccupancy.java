/******************************************************************
 * FileOccupancy.java
 * Copyright 2017 by GNNT Company. All Rights Reserved.
 * CreateDate：2017年5月29日
 * Author：wangzg
 * Version：1.0.0
 ******************************************************************/

package com.celestial.meek.realTest_2017_05;

import java.io.File;
import java.util.Scanner;

import com.celestial.agniRadiance.EzUtil.Util_File;

/**
 * <b>修改记录：</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2017年5月29日
 * </li>
 * </p>
 * 
 * <b>类说明：</b>
 * <p> 
 * 
 * </p>
 */
public class FileOccupancy {

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param args 
	 */
	public static void main(String[] args) {
		String f1 = "E:/t/t29 工具开发/00 导出包/celestial-forestBlaze-2017-05-29.jar",
				f2 = "E:/t/t29 工具开发/00 导出包/celestial-forestBlaze-2017-05-29233.jar";
		Util_File.copyByCmdDRS(new File(f1)
				,new File(f2));
		Util_File.getModifiedTime(new File(f2));
		Scanner scanner = new Scanner(System.in);
		System.out.println(scanner.nextLine());
	}

}
