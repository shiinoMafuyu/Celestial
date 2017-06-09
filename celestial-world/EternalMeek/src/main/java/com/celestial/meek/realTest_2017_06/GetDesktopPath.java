/******************************************************************
 * GetDesktopPath.java
 * Copyright 2017 by GNNT Company. All Rights Reserved.
 * CreateDate：2017年6月7日
 * Author：wangzg
 * Version：1.0.0
 ******************************************************************/

package com.celestial.meek.realTest_2017_06;

import java.io.File;

import javax.swing.filechooser.FileSystemView;

/**
 * <b>修改记录：</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2017年6月7日
 * </li>
 * </p>
 * 
 * <b>类说明：</b>
 * <p> 
 * 
 * </p>
 */
public class GetDesktopPath {

	/**
	 * <b>方法说明：</b>
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
