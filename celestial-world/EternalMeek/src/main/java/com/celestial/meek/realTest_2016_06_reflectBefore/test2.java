package com.celestial.meek.realTest_2016_06_reflectBefore;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class test2 {
	public static void main(String[] args) throws Exception {
		//te();
		//te2();
		te3();
//		te4();
//		te5();
//		te6();
//		te7();
	}

	private static void te7() {
		List l=new ArrayList();
		outOfMemory(l,1);
	}
	
	

	private static void outOfMemory(List l,int i) {
		List l2=new ArrayList();
		l2.add(l);
		System.out.println("第 "+i+" 次~");
		outOfMemory(l2,++i);
	}

	private static void te5() throws Exception{
		Class x=Class.forName("kino.x");
		Fly f=(Fly)x.newInstance();
		f.superFly();
		
	}

	/**
	 * 反射方式调用方法

	 * @throws Exception
	 */
	private static void te3() throws Exception {
		String s="void evl(){System.out.println(5+6*10+21.44/5+998);}";
		File f=new File("D:/workspace/test/src/test/EVA.java");
		/*BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(f)));
		String so=null;
		while((so=br.readLine())!=null){
			System.out.println(so);
		}*/
		
		PrintWriter pw=new PrintWriter(new OutputStreamWriter(new FileOutputStream("D:/workspace/test/src/test/EVA.java"),"utf-8"),false);
		pw.println("package test;public class EVA{");
		pw.println(s);
		pw.println("}");
		pw.flush();
		
		Class xClass=Class.forName("test.EVA");
		Object eva= xClass.newInstance();
		@SuppressWarnings("unchecked")
		Method m= xClass.getDeclaredMethod("evl",new Class[]{});
		m.invoke(eva, new Object[]{});
	}

	/**
	 * 用反射机制调用对象方法
	 */
	private static void te2() throws Exception {
		Class Xclass=Class.forName("test.JOJO");
		Object jo=Xclass.newInstance();
		Method m=Xclass.getMethod("ouLaN", new Class[]{int.class});
		m.invoke(jo, new Object[]{10});
	}

	private static void te() throws Exception {
		Class<?> XClass =Class.forName("test.JOJO");
		
		Object ox=XClass.getConstructor(new Class[]{}).newInstance(new Object[]{});
		System.out.println(XClass.getName()+"  :  "+XClass.getClassLoader());
		Field[] fds=XClass.getDeclaredFields();
		for(Field i: fds ){
			System.out.println(i.getName());
		}
	}
}
