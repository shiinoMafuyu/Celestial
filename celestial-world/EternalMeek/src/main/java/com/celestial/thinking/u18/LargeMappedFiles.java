/******************************************************************
 * LargeMappedFiles.java
 * Copyright 2017 by WZG. All Rights Reserved.
 * CreateDate：2017年8月16日
 * Author：wangzg
 * Version：1.0.0
 ******************************************************************/

package com.celestial.thinking.u18;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * <b>修改记录：</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2017年8月16日
 * </li>
 * </p>
 * 
 * <b>类说明：</b>
 * <p> 
 * 
 * </p>
 */
public class LargeMappedFiles {

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param args 
	 */
	public static void main(String[] args) {
		
		try {
			@SuppressWarnings("resource")
			MappedByteBuffer mappedBuffer = new RandomAccessFile("src/main/java/com/celestial/thinking/u18/UsingBuffers.java", "rw").getChannel()
			.map(FileChannel.MapMode.READ_WRITE, 0, 2*1000);
			
			while(mappedBuffer.hasRemaining()){
				System.out.print((char)mappedBuffer.get());
			}
			mappedBuffer.rewind();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
