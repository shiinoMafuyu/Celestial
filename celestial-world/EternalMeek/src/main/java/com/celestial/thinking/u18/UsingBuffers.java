/******************************************************************
 * UsingBuffers.java
 * Copyright 2017 by WZG. All Rights Reserved.
 * CreateDate：2017年8月16日
 * Author：wangzg
 * Version：1.0.0
 ******************************************************************/

package com.celestial.thinking.u18;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

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
public class UsingBuffers {

	/**
	 * <b>方法说明：</b>
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