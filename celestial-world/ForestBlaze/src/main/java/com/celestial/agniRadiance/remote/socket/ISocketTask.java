/******************************************************************
 * ASocketTask.java
 * Copyright 2017 by WZG. All Rights Reserved.
 * CreateDate：2017年9月19日
 * Author：wangzg
 * Version：1.0.0
 ******************************************************************/

package com.celestial.agniRadiance.remote.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;

import com.celestial.agniRadiance.thread.AbstractThread;
import com.celestial.agniRadiance.tuple.ThreeTuple;

/**
 * <b>修改记录：</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2017年9月19日
 * </li>
 * </p>
 * 
 * <b>类说明：</b>
 * <p> 
 * socket任务接口<br/>
 * 将为socket启动请求发送、数据读取、心跳发送(socket连接保持)3条线程
 * </p>
 */
public interface ISocketTask  {
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * socket请求发送
	 * </ul>
	 * @param out
	 */
	void send(DataOutputStream out);
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 心跳(用于socket连接保持)
	 * </ul>
	 * @param out
	 */
	void sendHeartBeat(DataOutputStream out);
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * socket请求接收
	 * </ul>
	 * @param in
	 */
	void receive(DataInputStream in);
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 心跳错误异常处理
	 * </ul>
	 */
	void heartBreak();
		
	
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 请求发送间隔
	 * </ul>
	 * @return
	 */
	long getSendPeriod();
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 心跳发送间隔
	 * </ul>
	 * @return
	 */
	long getSendHeartPeriod();
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * socket信息读取间隔
	 * </ul>
	 * @return
	 */
	long getrReceivePeriod();
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 设置socket任务执行线程
	 * </ul>
	 * @param socktThreads
	 */
	void setThreads(ThreeTuple<AbstractThread, AbstractThread, AbstractThread> socktThreads);
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取socket任务执行线程
	 * </ul>
	 * @return
	 */
	ThreeTuple<AbstractThread, AbstractThread, AbstractThread> getThreads();
	
	
	
}
