/******************************************************************
 * UsingBuffers.java
 * Copyright 2017 by WZG. All Rights Reserved.
 * CreateDate��2017��8��16��
 * Author��wangzg
 * Version��1.0.0
 ******************************************************************/

package com.celestial.thinking.u18;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

/**
 * <b>�޸ļ�¼��</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2017��8��16��
 * </li>
 * </p>
 * 
 * <b>��˵����</b>
 * <p> 
 * 
 * </p>
 */
public class UsingBuffers {

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param args 
	 */
	public static void main(String[] args) {
		
		String s = "your Heart like a moon12";
		ByteBuffer bb = ByteBuffer.allocate(s.length() * 2);
		CharBuffer cb = bb.asCharBuffer();
		cb.put(s);
		System.out.println(cb.rewind());
		exchangeChar(cb);
		System.out.println(cb.rewind());
		exchangeChar(cb);
		System.out.println(cb.rewind());
	}
	
	private static void exchangeChar(CharBuffer cb){
		while(cb.remaining() > 1){
			cb.mark();
			char char1 = cb.get();
			char char2 = cb.get();
			cb.reset();
			cb.put(char2);
			cb.put(char1);
			
		}
		
	}
}