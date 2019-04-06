package com.celestial.butterflystorm.butterfly2018.creeper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.celestial.agniRadiance.EzUtil.UtilNetWork;

/*
 * 网络爬虫取数据
 * 
 * */
public class DownloadPageImage {
	public static String GetUrl(String inUrl) {
		StringBuilder sb = new StringBuilder();
		try {
			URL url = new URL(inUrl);
			BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));

			String temp = "";
			while ((temp = reader.readLine()) != null) {
				// System.out.println(temp);
				sb.append(temp);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	public static String GetUrl2(String inUrl) {
		URL url;
		int responsecode;
		HttpURLConnection urlConnection = null;
		BufferedReader reader = null;
		String line;
		StringBuilder sb = new StringBuilder();
		try {
			// 生成一个URL对象，要获取源代码的网页地址为：http://www.sina.com.cn
			url = new URL(inUrl);
			// 打开URL
			urlConnection = (HttpURLConnection) url.openConnection();
//			urlConnection.setRequestProperty("User-Agent", "Mozilla/31.0 (compatible; MSIE 10.0; Windows NT; DigExt)"); // 防止报403错误。
			urlConnection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 5.1; Trident/4.0; CIBA)"); 
			// 获取服务器响应代码
			responsecode = urlConnection.getResponseCode();
			if (responsecode == 200) {
				// 得到输入流，即获得了网页的内容
				reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "utf-8"));
				while ((line = reader.readLine()) != null) {
					sb.append(line);
				}

			} else {
				System.out.println("获取不到网页的源码，服务器响应代码为：" + responsecode);
			}
		} catch (Exception e) {
			System.out.println("获取不到网页的源码,出现异常：" + e);
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			urlConnection.disconnect();
		}
		
		return sb.toString();
	}

	public static List<String> GetMatcher(String str, String url, String aimUrl) {
		List<String> result = new ArrayList<String>();
		Pattern p = Pattern.compile(url);// 获取网页地址
		Matcher m = p.matcher(str);
		while (m.find()) {
			String path = m.group(1);
			if (!path.startsWith("http")) {
				path = aimUrl + "/" + path;
			}
			result.add(path);
		}
		return result;
	}

	public static void main(String args[]) {
//		String aimUrl = "http://www.66hyk.com/forum.php?mod=viewthread&tid=7065";
		String aimUrl = "http://www.tuyimm.vip/thread-366-1-1.html";
		String str = GetUrl2(aimUrl);
		List<String> ouput = GetMatcher(str, "src=\"([\\w\\s./:_-]+?\\.(jpg|gif))\"", aimUrl);

		for (String temp : ouput) {
			// System.out.println(ouput.get(0));
			System.out.println(temp);
			UtilNetWork.normalDownLoad(temp);
		}

	}
}
