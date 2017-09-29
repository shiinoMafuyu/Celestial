/******************************************************************
 * MainServer.java
 * Copyright 2017 by WZG. All Rights Reserved.
 * CreateDate：2017年6月27日
 * Author：wangzg
 * Version：1.0.0
 ******************************************************************/

package com.celestial.meek.realTest_2017_06.testSelectSpeed;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.sql.DataSource;

import com.celestial.agniRadiance.EzUtil.UtilDB;

/**
 * <b>修改记录：</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2017年6月27日
 * </li>
 * </p>
 * 
 * <b>类说明：</b>
 * <p> 
 * 
 * </p>
 */
public class MainServer {

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param args 
	 */
	public static void main(String[] args) {
		
		MainServer ms = new MainServer();
		ms.start();
		
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 
	 * </ul> 
	 */
	public void start() {
		
		DataSource ds = UtilDB.getDataSource("fundspoold_gnnt_test", "password", "jdbc:oracle:thin:@172.18.3.36:1521/pdb_38 ");
		QueryDAO dao = new QueryDAO(ds);
		Long[] range = seaparte(10L,2);//new Long[]{0L,10000L,200000L,300000L,400000L,500000L,600000L};//565836
		
		Date d = new Date();
		
		QueryThread[] threads = new QueryThread[range.length -1];
		threads = startThread(threads,dao,range);
		
		Map<Integer,List<Entity>> map = new HashMap<Integer,List<Entity>> ();
		map = waitResult(map,threads);
		
		
		List<Entity> all = new ArrayList<Entity>();
		all = addAll(all,map);
		
		System.out.println("用时： "+(new Date().getTime() - d.getTime())/1000 + " 秒");
		System.out.println(all.size());
		
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param i
	 * @param j
	 * @return 
	 */
	private static Long[] seaparte(Long range, Integer amout) {
		Long[] rangs = new Long[amout];
		Long step = range/amout;
		for(int i = 0;i<amout -1;i++){
			rangs[i] = step * i;
		}
		rangs[amout -1] = range;
		return rangs;
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param all
	 * @param map
	 * @return 
	 */
	private static List<Entity> addAll(List<Entity> all, Map<Integer, List<Entity>> map) {
		List<Entity> resList = new ArrayList<Entity>();
		for(Entry<Integer, List<Entity>> ei : map.entrySet()){
			resList.addAll(ei.getValue());
		}
		return resList;
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param map 
	 * @param threads 
	 */
	private static Map<Integer, List<Entity>> waitResult(Map<Integer, List<Entity>> map, QueryThread[] threads) {
		
		
		while(true){
			for(int i = 0 ; i < threads.length;i++){
				map.put(i, threads[i].getList());
			}
			if(check(map))
				break;
			try {
				System.out.print("--->");
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		return map;
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param threads 
	 */
	private static QueryThread[] startThread(QueryThread[] threads,QueryDAO dao,Long[] range) {
		int amout = range.length -1;
		for(int i=0;i<amout;i++){
			threads[i] = new QueryThread(dao, new Long[]{range[i],range[i+1]});
			threads[i].start();
		}
		return threads;
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param map
	 * @return 
	 */
	private static <T,V> boolean check(Map<T, List<V>> map) {
		for(Entry<T, List<V>> ei : map.entrySet()){
			if(null == ei.getValue())
				return false;
		}
		return true;
	}

}
