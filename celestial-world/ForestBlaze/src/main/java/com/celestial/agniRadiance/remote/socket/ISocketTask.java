/******************************************************************
 * ASocketTask.java
 * Copyright 2017 by WZG. All Rights Reserved.
 * CreateDate��2017��9��19��
 * Author��wangzg
 * Version��1.0.0
 ******************************************************************/

package com.celestial.agniRadiance.remote.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;

import com.celestial.agniRadiance.thread.AbstractThread;
import com.celestial.agniRadiance.tuple.ThreeTuple;

/**
 * <b>�޸ļ�¼��</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2017��9��19��
 * </li>
 * </p>
 * 
 * <b>��˵����</b>
 * <p> 
 * socket����ӿ�<br/>
 * ��Ϊsocket���������͡����ݶ�ȡ����������(socket���ӱ���)3���߳�
 * </p>
 */
public interface ISocketTask  {
	
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * socket������
	 * </ul>
	 * @param out
	 */
	void send(DataOutputStream out);
	
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ����(����socket���ӱ���)
	 * </ul>
	 * @param out
	 */
	void sendHeartBeat(DataOutputStream out);
	
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * socket�������
	 * </ul>
	 * @param in
	 */
	void receive(DataInputStream in);
	
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ���������쳣����
	 * </ul>
	 */
	void heartBreak();
		
	
	
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * �����ͼ��
	 * </ul>
	 * @return
	 */
	long getSendPeriod();
	
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * �������ͼ��
	 * </ul>
	 * @return
	 */
	long getSendHeartPeriod();
	
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * socket��Ϣ��ȡ���
	 * </ul>
	 * @return
	 */
	long getrReceivePeriod();
	
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ����socket����ִ���߳�
	 * </ul>
	 * @param socktThreads
	 */
	void setThreads(ThreeTuple<AbstractThread, AbstractThread, AbstractThread> socktThreads);
	
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ��ȡsocket����ִ���߳�
	 * </ul>
	 * @return
	 */
	ThreeTuple<AbstractThread, AbstractThread, AbstractThread> getThreads();
	
	
	
}
