/******************************************************************
 * TwoTuple.java
 * Copyright ${year} by WZG. All Rights Reserved.
 * CreateDate：2017年9月13日
 * Author：wangzg
 * Version：1.0.0
 ******************************************************************/

package com.celestial.agniRadiance.tuple;

/**
 * <b>修改记录：</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2017年9月13日
 * </li>
 * </p>
 * 
 * <b>类说明：</b>
 * <p> 
 * 
 * </p>
 */
public class TwoTuple<T1,T2> {
	
	public final T1 t1;
	
	public final T2 t2;
	
	/**
	 * <b>构造方法</b>
	 * <br/>
	 * @param t1
	 * @param t2
	 */
	public TwoTuple(T1 t1, T2 t2){
		this.t1 = t1;
		this.t2 = t2;
	}
	
}
