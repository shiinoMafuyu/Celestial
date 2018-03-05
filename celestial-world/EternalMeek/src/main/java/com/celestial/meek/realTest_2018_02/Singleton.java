package com.celestial.meek.realTest_2018_02;
public class Singleton {
	
	private static Singleton ins = null;
	
	private Singleton() {
	}
	public  static  Singleton getInstance() {
		if(ins == null) {
			synchronized(Singleton.class) {
				ins = new Singleton();
			}
		}
		return ins;
	}
	
	void show() {
		System.out.println("这是个单例~");
	}
	public static void main(String[] args) {
		Singleton.getInstance().show();
		Singleton.getInstance().increase(3L, 5);
		
		System.out.println("年龄："+Singleton.getInstance().getAge(10, 8));;
	}
	
	int getAge(int age,int n) {
		if(n>1)
			return getAge(age+2,--n);
		else
			return age;
	}
	
	
	void increase(long next,int floor) {
		if(next >8)
			System.out.println(next);
		if(floor >0)
			increase(next<<2,--floor);
	}
}
