/******************************************************************
 * UtilReflect.java
 * Copyright ${year} by WZG. All Rights Reserved.
 * CreateDate：2017年9月14日
 * Author：wangzg
 * Version：1.0.0
 ******************************************************************/

package com.celestial.agniRadiance.EzUtil;

import java.lang.reflect.Method;

/**
 * <b>修改记录：</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2017年9月14日
 * </li>
 * </p>
 * 
 * <b>类说明：</b>
 * <p> 
 * 
 * </p>
 */
public class UtilReflect {
	

	/**==============================================反射核心 wangzg 2016年7月21日14:34:48  ↓==========================================================*/
	

	/**
	 * 执行反射方法 <br/>
	 * @param obj 要执行的方法和其参数 ; 约定格式 : [对象,方法名,param0,param1,param2..]
	 * @param me  实例自身
	 * @return 方法调用结果
	 */
	@SuppressWarnings("rawtypes")
	public static Object excuteReflectObject(Object obj) throws Exception{
		//就算是Class也可以现成添加 !
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
	 * <b>方法说明：</b>
	 * <ul>
	 * **究极的方法**<br/>
	 * 使用自定义类的话,获取方法的时候不能向上造型.(就算是以子类来getClass()也获取不到父类型为参数的方法.)<br/>
	 * 所以写了,这个方法.把参数的类对象传入.<br/>
	 * 
	 * </ul>
	 * @param obj 约定格式[对象,方法名,Class[],params[]]
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
	/**==============================================反射核心 wangzg 2016年7月21日14:34:48 ↑==========================================================*/

	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 加载类qualifiedName,获取一个实例.<br/>
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
			throw new RuntimeException("反射获取实例失败:"+qualifiedName);
		} 
		return obj;
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 加载类qualifiedName,获取一个实例.<br/>
	 * 想比getReflectObject,此方法在能使用默认构造函数实例化时,就使用默认构造函数(new)<br/>
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
	 * <b>方法说明：</b>
	 * <ul>
	 * 加载类.
	 * </ul>
	 * @param qualifiedName
	 */
	@SuppressWarnings("rawtypes")
	public static Class ClassFor(String qualifiedName) {
		try {
			return Class.forName(qualifiedName);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("类加载失败:"+qualifiedName);
		}
	}
	

	
	
	
}
