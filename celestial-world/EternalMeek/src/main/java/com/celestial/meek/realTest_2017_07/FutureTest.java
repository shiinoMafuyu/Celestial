/******************************************************************
 * Future.java
 * Copyright 2017 by WZG. All Rights Reserved.
 * CreateDate：2017年7月4日
 * Author：wangzg
 * Version：1.0.0
 ******************************************************************/

package com.celestial.meek.realTest_2017_07;

/**
 * <b>修改记录：</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2017年7月4日
 * </li>
 * </p>
 * 
 * <b>类说明：</b>
 * <p> 
 * 
 * </p>
 */
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
 
/**
 * 试验 Java 的 Future 用法
 */
public class FutureTest {
 
    public static class Task implements Callable<String> {
        @Override
        public String call() throws Exception {
            String tid = String.valueOf(Thread.currentThread().getId());
            System.out.printf("Thread#%s : in call\n", tid);
            return tid;
        }
    }
 
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        List<Future<String>> results = new ArrayList<Future<String>>();
        ExecutorService es = Executors.newCachedThreadPool();
        for(int i=0; i<100;i++)
            results.add(es.submit(new Task()));
 
        for(Future<String> res : results)
            System.out.println(res.get());
    }
 
}