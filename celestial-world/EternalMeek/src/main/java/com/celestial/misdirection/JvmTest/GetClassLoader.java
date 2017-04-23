package com.celestial.misdirection.JvmTest;

public class GetClassLoader {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GetClassLoader g =new GetClassLoader();
		Class c=g.getClass();
		ClassLoader  loader=c.getClassLoader();
		System.out.println(loader.toString());
		System.out.println(loader.getParent());
		System.out.println(loader.getParent().getParent());
		
	}

}
