/******************************************************************
 * UtilSocket.java
 * Copyright ${year} by WZG. All Rights Reserved.
 * CreateDate：2017年9月14日
 * Author：wangzg
 * Version：1.0.0
 ******************************************************************/

package com.celestial.agniRadiance.remote;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import com.celestial.agniRadiance.remote.socket.ISocketTask;
import com.celestial.agniRadiance.remote.socket.SocketVO;
import com.celestial.agniRadiance.thread.AbstractThread;
import com.celestial.agniRadiance.tuple.ThreeTuple;

/**
 * <b>修改记录：</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2017年9月14日
 * </li>
 * </p>
 * 
 * <b>类说明：</b>
 * <p> 
 * 
 * </p>
 */
public class UtilSocket {
	
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取一个socket连接
	 * </ul>
	 * @param ip 地址
	 * @param port 端口
	 * @param timeout 超时时间
	 * @return 
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public static Socket getSocket(String ip, int port,int timeout) {
		Socket socket = null;
		try {
			socket = new Socket(ip, port);
			// 当socket关闭时强行关闭底层socket连接
			socket.setSoLinger(true, 0);
			// tcp监视该连接是否有效，无效断开连接
			socket.setKeepAlive(true);
			// 不采用Negale算法，立即发送数据
			socket.setTcpNoDelay(true);
			//设置超时时间
			socket.setSoTimeout(timeout);
		} catch (Exception e) {
			e.printStackTrace();
			socket = null;
		}
		return socket;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 关闭socket
	 * </ul>
	 * @param socket
	 */
	public static void closeSocket(Socket socket){
		if(socket != null){
			try {
				socket.close();
			} catch (Exception e) {
			}
		}
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param task 
	 * @param socket 
	 * @return
	 */
	public ThreeTuple<AbstractThread,AbstractThread,AbstractThread> socketExchange(ISocketTask task,Socket socket){
		
		SocketVO socketvo = new SocketVO(socket);
		AbstractThread sendThread = new AbstractThread() {

			@Override
			protected void doBeforWork() {
				setTimeSpace(task.getSendHeartPeriod());
			}

			@Override
			protected void doWork() {
				synchronized (socketvo) {
					task.send(socketvo.out);
				}
			}
		};

		AbstractThread heartThread = new AbstractThread() {

			@Override
			protected void doBeforWork() {
				setTimeSpace(task.getSendHeartPeriod());
			}

			@Override
			protected void doWork() {
				synchronized (socketvo) {
					task.sendHeartBeat(socketvo.out);
				}
			}
		};

		AbstractThread receiveThread = new AbstractThread() {

			@Override
			protected void doBeforWork() {
				setTimeSpace(task.getrReceivePeriod());
			}

			@Override
			protected void doWork() {
				synchronized (socketvo) {
					task.receive(socketvo.in);
				}
			}
			
			@Override
			protected void doExceptionWork(Exception e) {
				task.heartBreak();
			}
		};
		ThreeTuple<AbstractThread, AbstractThread, AbstractThread> threads = new ThreeTuple<>(sendThread, heartThread, receiveThread);
		task.setThreads(threads);
		
		return threads;
	}
	
}
