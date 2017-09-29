/******************************************************************
 * ThreeTuple.java
 * Copyright ${year} by WZG. All Rights Reserved.
 * CreateDate��2017��9��13��
 * Author��wangzg
 * Version��1.0.0
 ******************************************************************/

package com.celestial.agniRadiance.tuple;

/**
 * <b>�޸ļ�¼��</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2017��9��13��
 * </li>
 * </p>
 * 
 * <b>��˵����</b>
 * <p> 
 * 
 * </p>
 */
public class ThreeTuple<T1,T2,T3> extends TwoTuple<T1, T2> {
	
	public final T3 t3;
	
	/**
	 * <b>���췽��</b>
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
