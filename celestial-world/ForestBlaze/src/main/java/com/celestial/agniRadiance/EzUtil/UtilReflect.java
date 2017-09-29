/******************************************************************
 * UtilReflect.java
 * Copyright ${year} by WZG. All Rights Reserved.
 * CreateDate��2017��9��14��
 * Author��wangzg
 * Version��1.0.0
 ******************************************************************/

package com.celestial.agniRadiance.EzUtil;

import java.lang.reflect.Method;

/**
 * <b>�޸ļ�¼��</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2017��9��14��
 * </li>
 * </p>
 * 
 * <b>��˵����</b>
 * <p> 
 * 
 * </p>
 */
public class UtilReflect {
	

	/**==============================================������� wangzg 2016��7��21��14:34:48  ��==========================================================*/
	

	/**
	 * ִ�з��䷽�� <br/>
	 * @param obj Ҫִ�еķ���������� ; Լ����ʽ : [����,������,param0,param1,param2..]
	 * @param me  ʵ������
	 * @return �������ý��
	 */
	@SuppressWarnings("rawtypes")
	public static Object excuteReflectObject(Object obj) throws Exception{
		//������ClassҲ�����ֳ���� !
		Object[] objs =(Object[])obj;
		Class[] cArr = new Class[objs.length -2];
		for(int i =0; i < objs.length -2 ; i++){
			cArr[i] = objs[i+2].getClass();
		}
		Method m = objs[0].getClass().getDeclaredMethod((String)objs[1], cArr);
		m.setAccessible(true);
		Object[] params = new Object[cArr.length];
		for(int i = 0; i < objs.length -2 ; i++){
			params[i] = objs[i+2];
		}
		return m.invoke(objs[0], params);
		
	}
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * **�����ķ���**<br/>
	 * ʹ���Զ�����Ļ�,��ȡ������ʱ������������.(��������������getClass()Ҳ��ȡ����������Ϊ�����ķ���.)<br/>
	 * ����д��,�������.�Ѳ������������.<br/>
	 * 
	 * </ul>
	 * @param obj Լ����ʽ[����,������,Class[],params[]]
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public static Object excuteReflectObject2(Object obj) throws Exception{
		Object[] objs =(Object[])obj;
		
		Object girlFriend = objs[0];
		String name =  (String)objs[1];
		Class[] cArr = (Class[])objs[2];
		Object[] params = (Object[])objs[3];
		
		Method m = girlFriend.getClass().getDeclaredMethod(name, cArr);
		return m.invoke(objs[0], params);
	}
	/**==============================================������� wangzg 2016��7��21��14:34:48 ��==========================================================*/

	
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ������qualifiedName,��ȡһ��ʵ��.<br/>
	 * </ul>
	 * @param qualifiedName
	 * @return
	 */
	public static Object getReflectObject(String qualifiedName) {
		Object obj = null;
		try {
			obj = ClassFor(qualifiedName).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("�����ȡʵ��ʧ��:"+qualifiedName);
		} 
		return obj;
	}

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ������qualifiedName,��ȡһ��ʵ��.<br/>
	 * ���getReflectObject,�˷�������ʹ��Ĭ�Ϲ��캯��ʵ����ʱ,��ʹ��Ĭ�Ϲ��캯��(new)<br/>
	 * </ul>
	 * @param qualifiedName
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Object getReflectObjectPretty(String qualifiedName) {
		Object obj = null;
		try {
			Class c = ClassFor(qualifiedName);
			try {
				obj = c.getConstructor().newInstance();
			} catch (Exception e) {
			}
			if(obj == null)
				obj = c.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return obj;
	}
	
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ������.
	 * </ul>
	 * @param qualifiedName
	 */
	@SuppressWarnings("rawtypes")
	public static Class ClassFor(String qualifiedName) {
		try {
			return Class.forName(qualifiedName);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("�����ʧ��:"+qualifiedName);
		}
	}
	

	
	
	
}
