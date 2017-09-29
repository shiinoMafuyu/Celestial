/******************************************************************
 * UtilSocket.java
 * Copyright ${year} by WZG. All Rights Reserved.
 * CreateDate��2017��9��14��
 * Author��wangzg
 * Version��1.0.0
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
 * <b>�޸ļ�¼��</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2017��9��14��
 * </li>
 * </p>
 * 
 * <b>��˵����</b>
 * <p> 
 * 
 * </p>
 */
public class UtilSocket {
	
	
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ��ȡһ��socket����
	 * </ul>
	 * @param ip ��ַ
	 * @param port �˿�
	 * @param timeout ��ʱʱ��
	 * @return 
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public static Socket getSocket(String ip, int port,int timeout) {
		Socket socket = null;
		try {
			socket = new Socket(ip, port);
			// ��socket�ر�ʱǿ�йرյײ�socket����
			socket.setSoLinger(true, 0);
			// tcp���Ӹ������Ƿ���Ч����Ч�Ͽ�����
			socket.setKeepAlive(true);
			// ������Negale�㷨��������������
			socket.setTcpNoDelay(true);
			//���ó�ʱʱ��
			socket.setSoTimeout(timeout);
		} catch (Exception e) {
			e.printStackTrace();
			socket = null;
		}
		return socket;
	}
	
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * �ر�socket
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
	 * <b>����˵����</b>
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
