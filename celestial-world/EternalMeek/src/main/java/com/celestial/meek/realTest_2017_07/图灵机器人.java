package com.celestial.meek.realTest_2017_07;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import com.celestial.agniRadiance.EzUtil.UtilFile;

public class 图灵机器人 {
	
	private static String savePath = UtilFile.getDesktopPath()+"/sb/";
	private static String however = "然而我早已看穿了一切！";
    public static void main(String[] args) throws IOException {
    	
    	String[] sArr = new String[]{"老子上来就是一套素质三连！",however,"我爱你！","约吗！","你这么屌，天安门上怎么没挂你的皂片！"};
    	executeRecycleChart(sArr);
    } 
    
	private static void executeRecycleChart(String[] sArr) throws IOException {
		String req = "";
        String res = "";
        
        for(int i = 0 ; i < sArr.length ; i++){
        	List<String> list = new ArrayList<>();
        	req = sArr[i];
        	for(int j = 0 ; j < 100 ; j++){
        		
            	list.add("雪糕：" + req);
            	System.out.println("雪糕：" + req);
            	res = machine(req);
            	
            	list.add("年糕：" + res);
            	System.out.println("年糕：" + res);
            	
            	req = getReq(req,res);
            }
        	UtilFile.printFile(list, savePath + i + ".txt");
        }
        
		
	}
	
	private static String getReq(String req,String res) throws IOException {
		if(however.equals(req))
			return req;
		else
			return machine(res);
	}

	private static String machine(String quesiton) throws IOException {
        //接入机器人，输入问题
        String APIKEY = "76d5ae7ab3954428ad765fe5a06c3021";
        String INFO = URLEncoder.encode(quesiton, "utf-8");//这里可以输入问题
        String getURL = "http://www.tuling123.com/openapi/api?key=" + APIKEY + "&info=" + INFO;
        URL getUrl = new URL(getURL);
        HttpURLConnection connection = (HttpURLConnection) getUrl.openConnection();
        connection.connect();

        // 取得输入流，并使用Reader读取
        BufferedReader reader = new BufferedReader(new InputStreamReader( connection.getInputStream(), "utf-8"));
        StringBuffer sb = new StringBuffer();
        String line = "";
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        reader.close();
        // 断开连接
        connection.disconnect();
        String[] ss = new String[10];
        String s = sb.toString();
        String answer;
        ss = s.split(":");
        answer = ss[ss.length-1];
        answer = answer.substring(1,answer.length()-2);
        return answer;
    }
	
	
}