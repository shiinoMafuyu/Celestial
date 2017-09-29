/******************************************************************
 * Future.java
 * Copyright 2017 by WZG. All Rights Reserved.
 * CreateDate��2017��7��4��
 * Author��wangzg
 * Version��1.0.0
 ******************************************************************/

package com.celestial.meek.realTest_2017_07;

/**
 * <b>�޸ļ�¼��</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2017��7��4��
 * </li>
 * </p>
 * 
 * <b>��˵����</b>
 * <p> 
 * 
 * </p>
 */
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
 
/**
 * ���� Java �� Future �÷�
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