/******************************************************************
 * RedisJava.java
 * Copyright 2017 by WZG. All Rights Reserved.
 * CreateDate：2017年10月17日
 * Author：wangzg
 * Version：1.0.0
 ******************************************************************/

package com.celestial.meek.realTest_2017_10;

import org.junit.Test;

import redis.clients.jedis.Jedis;

/**
 * <b>修改记录：</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2017年10月17日
 * </li>
 * </p>
 * 
 * <b>类说明：</b>
 * <p> 
 * 
 * </p>
 */
public class RedisJava {
	
	@Test
	@SuppressWarnings("resource")
	public void _01_(){
		//连接本地的 Redis 服务
		Jedis jedis = new Jedis("localhost");
		System.out.println("连接成功");
		//查看服务是否运行
		System.out.println("服务正在运行: " + jedis.ping());

	}
	
	@SuppressWarnings("resource")
	@Test
	public void _02_(){
		//连接本地的 Redis 服务
		Jedis jedis = new Jedis("localhost");
		System.out.println("连接成功");
		//设置 redis 字符串数据
		jedis.set("name3", "mooncake");
		// 获取存储的数据并输出
		System.out.println("redis 存储的字符串为: " + jedis.get("name3"));
		
		
	}
	static int j =0;
	@SuppressWarnings("resource")
	public static void abc(String[] args) {
        for(int i=0;i<1000;i++){
        	
        	new Thread(new Runnable() {
				@Override
				public void run() {
					int m = j++;
					Jedis jedis = new Jedis("localhost");
					String namet = "namet"+m;
		            jedis.set(namet, "mooncake"+m);
		            System.out.println("redis 存储的字符串"+namet+"为: "+ jedis.get(namet));
				}
			}).start();;
        	
        }
	}
	
	@Test
	public void _03_(){
		Solution s = new Solution();
//		System.out.println(s.myAtoi("  -0012a42"));
		System.out.println(s.myAtoi("   +0 123"));
//		System.out.println(Integer.parseInt("+2"));
		System.out.println(Integer.valueOf("+0123"));
	}
	
	@Test
	public void _04_(){
		Solution s = new Solution();
		System.out.println(s.isPalindrome(1));
//		121
		System.out.println(Math.pow(10, (int)Math.log10(121)));
		
	}
	@Test
	public void _05_(){
		char c='*';
		char d = '.';
		
		System.out.println(".*");
		
	}
	
	class Solution {
	    public int myAtoi(String str) {
	        try{
	            String s = str.replaceAll(" ","");
	            int i=0;
	            for(;i<s.length();i++){
	                try{
	                    char c = s.charAt(i);
	                if('-' != c && '+' != c){
	                    Integer.valueOf(c+"");
	                }
	                }catch(Exception e){
	                	break;
	                }
	            }
	            return Integer.valueOf(s.substring(0,i));
	        }catch(Exception e){
	            return 0;
	        }
	        
	    }
	    
	    public boolean isPalindrome(int x) {
	        if(x <0 || (x!=0 && x%10 ==0)) return false;
	        int rv =0,x2= x;
	        while(x >0){
	            rv = rv * 10 + x % 10;
	            x = x / 10;
	        }
	        return rv == x2;
	    }
	}
	
	
}
