package com.celestial.meek.realTest_2016_08.jvmTest;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Testloader {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) throws ClassNotFoundException ,Exception{
		//---1---装载classLoader
		MyLoader1 ml1=new MyLoader1("D:/tat");
		Class mc=ml1.loadClass("JvmTest.MyLoader");
		Constructor cst=mc.getConstructor(String.class);
		Method md=mc.getMethod("loadClass", new Class[]{String.class,boolean.class});
		Object loader=cst.newInstance("D:/tat");
		//---1---装载classLoader
		
		//---2---装载实例
		Class c=(Class)md.invoke(loader, new Object[]{"te2",false});
		Object oc=c.newInstance();
		Method m=oc.getClass().getMethod("main", new Class[]{String[].class});
		m.invoke(oc, new Object[]{new String[]{"xx"}});
		//---2---装载实例
		
		
		/*MyLoader ml=new MyLoader("D:/tat");
		Class c= ml.loadClass("te2",false); 
		Object oc= c.newInstance();
		Method m=oc.getClass().getMethod("main", new Class[]{String[].class});
		m.invoke(oc, new Object[]{new String[]{"xx"}});
		System.out.println(c);*/
	}

}
