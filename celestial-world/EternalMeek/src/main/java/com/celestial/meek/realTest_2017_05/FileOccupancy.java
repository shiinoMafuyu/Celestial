/******************************************************************
 * FileOccupancy.java
 * Copyright 2017 by GNNT Company. All Rights Reserved.
 * CreateDate��2017��5��29��
 * Author��wangzg
 * Version��1.0.0
 ******************************************************************/

package com.celestial.meek.realTest_2017_05;

import java.io.File;
import java.util.Scanner;

import com.celestial.agniRadiance.EzUtil.Util_File;

/**
 * <b>�޸ļ�¼��</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2017��5��29��
 * </li>
 * </p>
 * 
 * <b>��˵����</b>
 * <p> 
 * 
 * </p>
 */
public class FileOccupancy {

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param args 
	 */
	public static void main(String[] args) {
		String f1 = "E:/t/t29 ���߿���/00 ������/celestial-forestBlaze-2017-05-29.jar",
				f2 = "E:/t/t29 ���߿���/00 ������/celestial-forestBlaze-2017-05-29233.jar";
		Util_File.copyByCmdDRS(new File(f1)
				,new File(f2));
		Util_File.getModifiedTime(new File(f2));
		Scanner scanner = new Scanner(System.in);
		System.out.println(scanner.nextLine());
	}

}
