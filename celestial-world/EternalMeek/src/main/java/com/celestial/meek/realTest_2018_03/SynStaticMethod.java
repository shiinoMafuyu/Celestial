package com.celestial.meek.realTest_2018_03;

import java.util.concurrent.atomic.AtomicInteger;

public class SynStaticMethod {

	public int j = 0;

	public static void main(String[] args) throws InterruptedException {
//		show();
//		twoAddTwoSub();
//		twoAddTwoSub2();
//		recreaseNum(3);
		int a = recrese2(10,2,8);
		System.out.println(a);
	}

	public static int recrese2(int nAge, int stepAge, int nth) {
		nth--;
		if(nth>0) {
			return recrese2(nAge+stepAge,stepAge,nth);
		}else
			return nAge;
	}

	public static void recreaseNum(int n) {
		if(n>5000)
			System.out.println(n);
		if(n>805306368-1)
			return;
		recreaseNum(n<<1);
	}

	public static void twoAddTwoSub2() throws InterruptedException {
		AtomicInteger j = new AtomicInteger(0);
		Runnable r1 = new Runnable() {
			
			@Override
			public void run() {
				for(int i=0;i<25000;i++) {
					j.incrementAndGet();
				}
				
			}
		};
		
		Thread t1 =new Thread(r1);
		Thread t2 =new Thread(r1);
		Thread t3 =new Thread(r1);
		Thread t4 =new Thread(r1);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		Thread.sleep(1000);
		System.out.println(j.get());
		
	}

	public static void twoAddTwoSub() {
		SynStaticMethod so = new SynStaticMethod();

		Runnable r1 = new Runnable() {
			@Override
			public void run() {
				while (true) {
					synchronized (so) {
						so.j++;
						System.out.println("add j >>  " + so.j);
					}
					Thread.yield();
				}
			}
		};

		Runnable r2 = new Runnable() {
			@Override
			public void run() {
				while (true) {
					synchronized (so) {
						so.j--;
						System.out.println("sub j >>  " + so.j);
					}
					Thread.yield();
				}
			}
		};
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r1);
		t1.start();
		t2.start();

		Thread t3 = new Thread(r2);
		Thread t4 = new Thread(r2);
		t3.start();
		t4.start();
	}

	public synchronized static void show() {

	}
}
