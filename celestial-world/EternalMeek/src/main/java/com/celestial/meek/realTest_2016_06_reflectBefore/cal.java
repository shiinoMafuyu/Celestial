package com.celestial.meek.realTest_2016_06_reflectBefore;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.lang.reflect.Method;

public class cal {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		te3();
	}

	/**
	 * 反射方式调用方法
	 * 
	 * @throws Exception
	 */
	private static void te3() throws Exception {
		String s = "void evl(){System.out.println(\"计算结果: \"+(5+6*10+21.44/5+998));}";
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(
				new FileOutputStream("D:/workspace/test/src/test/realTest_2016_06_20_reflectBefore/EVA.java"),
				"gbk"), false);
		pw.println("package test.realTest_2016_06_20_reflectBefore;public class EVA{" + s + "}");
		pw.flush();

		Class xClass = Class.forName("test.realTest_2016_06_20_reflectBefore.EVA");
		Object eva = xClass.newInstance();
		Method m = xClass.getDeclaredMethod("evl", new Class[] {});
		m.invoke(eva, new Object[] {});
	}
}
