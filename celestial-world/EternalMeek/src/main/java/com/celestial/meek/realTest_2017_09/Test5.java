/******************************************************************
 * Test5.java
 * Copyright 2017 by WZG. All Rights Reserved.
 * CreateDate��2017��10��11��
 * Author��wangzg
 * Version��1.0.0
 ******************************************************************/

package com.celestial.meek.realTest_2017_09;

import java.util.ArrayList;
import java.util.List;

/**
 * <b>�޸ļ�¼��</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2017��10��11��
 * </li>
 * </p>
 * 
 * <b>��˵����</b>
 * <p> 
 * 
 * </p>
 */
public class Test5 {
	public static void main(String[] args) {
		for(int i=0;i< 20;i++){
			pigNUm(i);
		}
		
	}
	
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param year 
	 */
	private static void pigNUm(int year) {
		System.out.println(year + "����������Ϊ��");
		List<Integer> pigs = new ArrayList<Integer>();
		pigs.add(2);
		pigs.add(2);
		for(int i = 0 ; i < year ; i ++){
			pigs = getPigs(pigs);
		}
		System.out.println(pigs.size());
		
	}

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * �����һ���������
	 * </ul>
	 * @param pigs
	 * @return 
	 */
	public static List<Integer> getPigs(List<Integer> pigs){
		int auditPig = 0;
		for(int i = 0 ; i < pigs.size() ;){
			int pigAge = pigs.get(i);
			pigAge ++ ;
			if(pigAge == 5 ){
				pigs.remove(i);
			}else{
				i++;
				if(pigAge >= 2){
					auditPig++;
				}
			}
		}
		for(int i = 0 ; i < auditPig * 2 ; i ++){
			pigs.add(0);
		}
		return pigs;
	}
}
