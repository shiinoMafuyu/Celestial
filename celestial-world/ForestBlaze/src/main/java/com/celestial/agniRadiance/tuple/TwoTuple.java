/******************************************************************
 * TwoTuple.java
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
public class TwoTuple<T1,T2> {
	
	public final T1 t1;
	
	public final T2 t2;
	
	/**
	 * <b>���췽��</b>
	 * <br/>
	 * @param t1
	 * @param t2
	 */
	public TwoTuple(T1 t1, T2 t2){
		this.t1 = t1;
		this.t2 = t2;
	}
	
}
