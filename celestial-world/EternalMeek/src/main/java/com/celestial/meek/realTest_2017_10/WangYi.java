/******************************************************************
 * WangYi.java
 * Copyright 2017 by WZG. All Rights Reserved.
 * CreateDate��2017��10��16��
 * Author��wangzg
 * Version��1.0.0
 ******************************************************************/

package com.celestial.meek.realTest_2017_10;

import java.util.Scanner;

/**
 * <b>�޸ļ�¼��</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2017��10��16��
 * </li>
 * </p>
 * 
 * <b>��˵����</b>
 * <p> 
 * 
 * </p>
 */
public class WangYi {
	 public static void main(String[] args){
	        Scanner sc = new Scanner(System.in);
	        int n = sc.nextInt();
	        int rv = getXiangFanShu(n);
	        System.out.println(rv);
	    }
	    
	    public static int getXiangFanShu(int n){
	        String s = new String(n+"");
	        StringBuilder sb = new StringBuilder();
	        for(int i= s.length() -1; i>=0; i--){
	            sb.append(s.charAt(i));
	        }
	        Integer dx = Integer.valueOf(sb.toString());
	        return dx +n;
	    }
}

