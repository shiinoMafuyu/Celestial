/******************************************************************
 * SocketVO.java
 * Copyright ${year} by WZG. All Rights Reserved.
 * CreateDate：2017年9月18日
 * Author：wangzg
 * Version：1.0.0
 ******************************************************************/

package com.celestial.agniRadiance.remote.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

import com.celestial.agniRadiance.remote.UtilSocket;

/**
 * <b>修改记录：</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2017年9月18日
 * </li>
 * </p>
 * 
 * <b>类说明：</b>
 * <p> 
 * socket信息封装类
 * </p>
 */
public class SocketVO {
	
	/** socket */
	public final Socket socket;
	/** 输出流 */
	public final DataOutputStream out;
	/** 输入流 */
	public final DataInputStream in;
	
	/**
	 * <b>构造方法</b>
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
			throw new RuntimeException("无效的socket");
		}
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 停止一切在socket上的输入输出流操作<br/>
	 * 另:可用shutdown方法只关闭输入输出一方<br/>
	 * </ul>
	 */
	public void close(){
		UtilSocket.closeSocket(socket);
	}
}
