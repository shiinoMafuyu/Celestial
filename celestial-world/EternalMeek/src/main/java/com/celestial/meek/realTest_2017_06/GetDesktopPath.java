/******************************************************************
 * GetDesktopPath.java
 * Copyright 2017 by GNNT Company. All Rights Reserved.
 * CreateDate��2017��6��7��
 * Author��wangzg
 * Version��1.0.0
 ******************************************************************/

package com.celestial.meek.realTest_2017_06;

import java.io.File;

import javax.swing.filechooser.FileSystemView;

/**
 * <b>�޸ļ�¼��</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2017��6��7��
 * </li>
 * </p>
 * 
 * <b>��˵����</b>
 * <p> 
 * 
 * </p>
 */
public class GetDesktopPath {

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param args 
	 */
	public static void main(String[] args) {
		FileSystemView fsv = FileSystemView.getFileSystemView();
		File com=fsv.getHomeDirectory(); 
		System.out.println(com.getPath());
		
	}

}
