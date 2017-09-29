/******************************************************************
 * SocketVO.java
 * Copyright ${year} by WZG. All Rights Reserved.
 * CreateDate��2017��9��18��
 * Author��wangzg
 * Version��1.0.0
 ******************************************************************/

package com.celestial.agniRadiance.remote.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

import com.celestial.agniRadiance.remote.UtilSocket;

/**
 * <b>�޸ļ�¼��</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2017��9��18��
 * </li>
 * </p>
 * 
 * <b>��˵����</b>
 * <p> 
 * socket��Ϣ��װ��
 * </p>
 */
public class SocketVO {
	
	/** socket */
	public final Socket socket;
	/** ����� */
	public final DataOutputStream out;
	/** ������ */
	public final DataInputStream in;
	
	/**
	 * <b>���췽��</b>
	 * <br/>
	 * @param socket
	 */
	public SocketVO(Socket socket){
		try {
			this.socket = socket;
			this.out = new DataOutputStream(socket.getOutputStream());
			this.in = new DataInputStream(socket.getInputStream());
		} catch (Exception e) {
			close();
			throw new RuntimeException("��Ч��socket");
		}
	}
	
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ֹͣһ����socket�ϵ��������������<br/>
	 * ��:����shutdown����ֻ�ر��������һ��<br/>
	 * </ul>
	 */
	public void close(){
		UtilSocket.closeSocket(socket);
	}
}
