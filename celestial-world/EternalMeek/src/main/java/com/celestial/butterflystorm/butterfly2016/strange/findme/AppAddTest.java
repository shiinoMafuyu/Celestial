package com.celestial.butterflystorm.butterfly2016.strange.findme;




import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;

import net.sf.json.JSONObject;
import sun.net.www.protocol.http.HttpURLConnection;

public class AppAddTest { 

    public static final String ADD_URL = "https://www.baidu.com/index.php?tn=site888_3_pg&ssl_s=1&ssl_c=ssl1_15354354afc"; 

    public static void appadd() { 

        try { 
            //创建连接 
            URL url = new URL(ADD_URL); 
            HttpURLConnection connection = (HttpURLConnection) url 
                    .openConnection(); 
            connection.setDoOutput(true); 
            connection.setDoInput(true); 
            connection.setRequestMethod("POST"); 
            connection.setUseCaches(false); 
            connection.setInstanceFollowRedirects(true); 
            connection.setRequestProperty("Content-Type", 
                    "application/x-www-form-urlencoded"); 

            connection.connect(); 

            //POST请求 
            DataOutputStream out = new DataOutputStream( 
                    connection.getOutputStream()); 
            JSONObject obj = new JSONObject(); 
//            obj.element("app_name", "asdf");  怎么要报错 2017年3月24日01:05:26 wangzg
//            obj.element("app_ip", "10.21.243.234"); 
//            obj.element("app_port", 8080); 
//            obj.element("app_type", "001"); 
//            obj.element("app_area", "asd"); 

            out.writeBytes(obj.toString()); 
            out.flush(); 
            out.close(); 

            //读取响应 
            BufferedReader reader = new BufferedReader(new InputStreamReader( 
                    connection.getInputStream())); 
            String lines; 
            StringBuffer sb = new StringBuffer(""); 
            while ((lines = reader.readLine()) != null) { 
                lines = new String(lines.getBytes(), "utf-8"); 
                sb.append(lines); 
            } 
            System.out.println(sb); 
            reader.close(); 
            // 断开连接 
            connection.disconnect(); 
        } catch (MalformedURLException e) { 
            e.printStackTrace(); 
        } catch (UnsupportedEncodingException e) { 
            e.printStackTrace(); 
        } catch (IOException e) { 
            e.printStackTrace(); 
        } 

    } 

    public static void main(String[] args) { 
        appadd(); 
    } 

} 
