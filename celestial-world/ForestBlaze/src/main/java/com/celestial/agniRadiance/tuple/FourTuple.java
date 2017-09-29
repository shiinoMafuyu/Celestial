/******************************************************************
 * FourTuple.java
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
public class FourTuple<T1,T2,T3,T4> extends ThreeTuple<T1, T2, T3> {

	public final T4 d;
	
	/**
	 * <b>���췽��</b>
	 * <br/>
	 * @param t1
	 * @param t2
	 * @param t3
	 * @param t4
	 */
	public FourTuple(T1 t1, T2 t2, T3 t3 , T4 t4) {
		super(t1, t2, t3);
		this.d = t4;
	}

}
