package com.celestial.butterflystorm.strange.httpRequest;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;

public class MyHttpRequest {

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param args 
	 */
	public static void main(String[] args) {
//		String s = doPost("https://www.baidu.com","a=b","GBK");
		String s = doPost2("https://www.baidu.com","","gbk");
		System.out.println(s);
	}
//	setRequestProperty主要是设置HttpURLConnection请求头里面的属性 比如Cookie、User-Agent（浏览器类型）等等,不设置自然有默认的，一般的请求倒不需要去设置
//	connection.setRequestProperty("Connection", "Keep-Alive");
//	connection.setRequestProperty("Content-Type", "multipart/form-data;boundary="+boundary);
//	Connection.setRequestProperty("Content-Type", "text/plain; charset=utf-8");
	
	public static String doPost(String url,String param,String charest){
		
		HttpURLConnection hp = null;
		InputStream in = null;
		OutputStream out = null;
		ByteArrayOutputStream byteArrayOut = null;
		
		try {
			hp = (HttpURLConnection)new URL(url).openConnection();
			
			hp.setDoInput(true);
			hp.setDoOutput(true);
			hp.setUseCaches(false);
			hp.setConnectTimeout(3000);
			hp.setReadTimeout(3000);

			hp.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			
			hp.connect();
			out = hp.getOutputStream();
			out.write(param.getBytes(charest));
			out.flush();
			
			in = hp.getInputStream();
			byteArrayOut = new ByteArrayOutputStream();
			byte[] by = new byte[512];
			int n = 0;
			while((n = in.read(by)) != -1){
				byteArrayOut.write(by, 0, n);
			}
			return new String(byteArrayOut.toByteArray(), charest);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("连接网络获取请求失败.");
		}
		finally{
			close(byteArrayOut);
			close(out);
			close(in);
			close(hp);
		}
		
	}
	
	private static void close(Closeable stream) {
		if (stream != null) {
			try {
				stream.close();
				stream = null;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static void close(HttpURLConnection httpConn) {
		if (httpConn != null) {
			httpConn.disconnect();
		}
	}
	
	
	public static String doPost2(String connectURL, String param, String charset) {
		byte[] bytes = null;
		ByteArrayOutputStream byteArrayOut = null;
		URL url = null;
		HttpURLConnection httpPost = null;
		OutputStream out = null;
		InputStream in = null;
		try {
			url = new URL(connectURL);
			httpPost = (HttpURLConnection) url.openConnection();
			httpPost.setRequestMethod("POST");
			httpPost.setDoInput(true);
			httpPost.setDoOutput(true);
			httpPost.setUseCaches(false);
			httpPost.setConnectTimeout(3000);
			httpPost.setReadTimeout(3000);
			httpPost.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded");
			httpPost.connect();
			out = httpPost.getOutputStream();
			out.write(param.getBytes(charset));
			out.flush();
			in = httpPost.getInputStream();
			byteArrayOut = new ByteArrayOutputStream();
			byte[] buf = new byte[512];
			int l = 0;
			while ((l = in.read(buf)) != -1) {
				byteArrayOut.write(buf, 0, l);
			}
			bytes = byteArrayOut.toByteArray();
			return new String(bytes, charset);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(byteArrayOut);
			close(out);
			close(in);
			close(httpPost);
		}
		return null;
	}

}
