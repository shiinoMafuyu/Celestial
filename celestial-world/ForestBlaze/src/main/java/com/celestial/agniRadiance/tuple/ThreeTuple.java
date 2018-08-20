/******************************************************************
 * ThreeTuple.java
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
public class ThreeTuple<T1,T2,T3> extends TwoTuple<T1, T2> {
	
	public final T3 t3;
	
	/**
	 * <b>构造方法</b>
	 * <br/>
	 * @param t1
	 * @param t2
	 * @param t3
	 */
	public ThreeTuple(T1 t1,T2 t2,T3 t3){
		super(t1,t2);
		this.t3 = t3;
	}
}
