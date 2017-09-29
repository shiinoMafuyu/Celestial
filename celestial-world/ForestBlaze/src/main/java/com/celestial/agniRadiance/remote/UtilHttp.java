package com.celestial.agniRadiance.remote;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.Map.Entry;

/**
 * <b>修改记录：</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2017年9月7日
 * </li>
 * </p>
 * 
 * <b>类说明：</b>
 * <p> 
 * 
 * </p>
 */
public class UtilHttp {
	
	public static String doPost2(String servletUrl,String xml){
		String res = "";
		try {
			/* 初始化 */
			java.net.URL url = new java.net.URL(servletUrl);
			java.net.URLConnection con = url.openConnection();
			HttpURLConnection httpconn = (HttpURLConnection) con;
			httpconn.setConnectTimeout(3600);
			ByteArrayOutputStream bout = new ByteArrayOutputStream();
			bout.write(xml.getBytes());
			byte[] b = bout.toByteArray();
			httpconn.setRequestProperty("Content-Length", String
					.valueOf(b.length));
			httpconn.setRequestProperty("Content-Type",
					"text/xml; charset=gb2312");
			httpconn.setRequestMethod("POST");
			httpconn.setDoInput(true);
			httpconn.setDoOutput(true);
			OutputStream out = httpconn.getOutputStream();
			out.write(b);
			out.close();
			
			InputStreamReader isr = new InputStreamReader(httpconn.getInputStream());
			BufferedReader br = new BufferedReader(isr);
			String temp = "";
			while(null != (temp = br.readLine())){
				res += temp;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
	
	private static int CONNECT_TIMEOUT = 3000;
	private static int READ_TIMEOUT = 3000;
	/**
	 * post请求数据
	 * 
	 * @param connectURL
	 * @param param
	 * @param charset
	 * @return
	 */
	public static String doPost(String connectURL, String param, String charset) {
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
			httpPost.setConnectTimeout(CONNECT_TIMEOUT);
			httpPost.setReadTimeout(READ_TIMEOUT);
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
	
	public static String doGet(String connectURL, String charset) {
		byte[] bytes = null;
		ByteArrayOutputStream byteArrayOut = null;
		URL url = null;
		HttpURLConnection httpGet = null;
		InputStream in = null;
		try {
			url = new URL(connectURL);
			httpGet = (HttpURLConnection) url.openConnection();
			httpGet.setConnectTimeout(CONNECT_TIMEOUT);
			httpGet.setReadTimeout(READ_TIMEOUT);
			httpGet.connect();
			in = httpGet.getInputStream();
			byteArrayOut = new ByteArrayOutputStream();
			byte[] buf = new byte[512];
			int l = 0;
			while ((l = in.read(buf)) != -1) {
				byteArrayOut.write(buf, 0, l);
			}
			bytes = byteArrayOut.toByteArray();
			return bytes != null ? new String(bytes, charset) : null;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(byteArrayOut);
			close(in);
			close(httpGet);
		}
		return null;
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
	
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 发送Get请求，获取文件<br/>
	 * </ul>
	 * @param urlParam
	 * @param params
	 * @param fileSavePath
	 * @return
	 */
    public static int sendGetAndSaveFile(String urlParam, Map<String, Object> params, String fileSavePath) {
    	int re = 0;
        // 构建请求参数 
        StringBuffer sbParams = new StringBuffer();
        if (params != null && params.size() > 0) {
            for (Entry<String, Object> entry : params.entrySet()) {
                sbParams.append(entry.getKey());
                sbParams.append("=");
                sbParams.append(entry.getValue());
                sbParams.append("&");
            }
        }
        HttpURLConnection con = null;
        BufferedReader br = null;
        FileOutputStream os = null;
        try {
            URL url = null;
            if (sbParams != null && sbParams.length() > 0) {
                url = new URL(urlParam + "?" + sbParams.substring(0, sbParams.length() - 1));
            } else {
                url = new URL(urlParam);
            }
            con = (HttpURLConnection) url.openConnection();
            con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            con.connect();
            InputStream is = con.getInputStream();
            os = new FileOutputStream(fileSavePath);
            byte buf[] = new byte[1024];
            int count = 0;
            while ((count = is.read(buf)) != -1) {
                os.write(buf, 0, count);
            }
            os.flush();
        } catch (Exception e) {
        	re = -1;
        } finally {
        	close(os);
            close(br);
        }
        return re;
    }
}
