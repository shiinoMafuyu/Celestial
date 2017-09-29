/******************************************************************
 * InputBufferDemo.java
 * Copyright 2017 by WZG. All Rights Reserved.
 * CreateDate��2017��8��14��
 * Author��wangzg
 * Version��1.0.0
 ******************************************************************/

package com.celestial.meek.realTest_2017_08.iosystem;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

/**
 * <b>�޸ļ�¼��</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2017��8��14��
 * </li>
 * </p>
 * 
 * <b>��˵����</b>
 * <p> 
 * 
 * </p>
 */
public class InputBufferDemo {
	
	private static final int BSIZE = 14024;

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param args 
	 */
	public static void main(String[] args) {
		
		ByteBuffer bb = ByteBuffer.allocate(BSIZE);
		IntBuffer ib = bb.asIntBuffer();
		ib.put(new int[]{11,42,47,99,143,811,1061});
		System.out.println(ib.get(3));
		ib.put(3, 1811);
		ib.flip();
		while(ib.hasRemaining()){
			int i = ib.get();
			System.out.println(i);
		}
		System.out.println("-------");
		System.out.println(ib.get(0));
		while(ib.hasRemaining()){
			int i = ib.get();
			System.out.println(i);
		}
	}

}
