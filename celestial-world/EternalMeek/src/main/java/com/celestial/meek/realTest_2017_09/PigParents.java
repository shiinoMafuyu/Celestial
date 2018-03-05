/******************************************************************
 * PigParents.java
 * Copyright 2017 by WZG. All Rights Reserved.
 * CreateDate：2017年10月11日
 * Author：wangzg
 * Version：1.0.0
 ******************************************************************/

package com.celestial.meek.realTest_2017_09;

import java.util.ArrayList;
import java.util.List;

/**
 * <b>修改记录：</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2017年10月11日
 * </li>
 * </p>
 * 
 * <b>类说明：</b>
 * <p> 
 * 
 * </p>
 */
public class PigParents {
	private static int num = 0;
	
	private int age;
	
	private boolean dead ;
	
	List<PigParents> childList ;
	
	/**
	 * <b>构造方法</b>
	 * <br/>
	 * @param age
	 */
	public PigParents(int age) {
		this.age = age;
		this.dead = false;
		num ++;
		this.childList = new ArrayList<>();
	}
	
	public void growth(){
		if(dead){
		}else{
			age ++;
			if(age > 4){
				num --;
				dead = true;
			}
		}
		childGrowth();
		
	}
	
	private void childGrowth() {
		for(PigParents pig : childList){
			pig.growth();
		}
		
	}

	public void born(){
		if(dead){
		}else if(age > 2 ){
			childList.add(new PigParents(0));
			childList.add(new PigParents(0));
		}
		childBorn();
		
	}
	
	private void childBorn() {
		for(PigParents pig : childList){
			pig.born();
		}
	}

	public static int getPigsNum(){
		return num * 2;
	}
	
}
