package com.celestial.meek.reaLTest_2017_01;

import java.util.ArrayList;
import java.util.List;

import com.celestial.agniRadiance.EzUtil.Util_Normal;
import com.celestial.agniRadiance.EzUtil.Util_String;
import com.celestial.agniRadiance.entity.FileReader;

public class getSeveralPicFromSD {

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param args 
	 */
	public static void main(String[] args) {
		
		
		/*String s = Util_Normal.doGet("http://static.sdg-china.com/dn/pic/dn/web10/navbg.png", "");
		System.out.println(s);*/
		
		/*Util_Normal.sendGetAndSaveFile("http://static.sdg-china.com/dn/pic/dn/web10/navbg.png", null, "C:/Users/Administrator/Desktop/1/navbg.png");*/
		
		readFileUrlAndDownLoad("D:/workspace/DN/WebRoot/css/home.css","C:/Users/Administrator/Desktop/1");
		
	}

	private static void readFileUrlAndDownLoad(String filePath,String savePath) {
		List<String> sList = getAllUrlFromFile(filePath);
		for(String url:sList){
			String name = url.substring(url.lastIndexOf("/")+1);
			String save = savePath + "/" + name;
			int re = Util_Normal.sendGetAndSaveFile(url, null, save);
			String msg = re==0?"  下载成功!":" 下载失败";
			System.out.println(name+msg);
		}
	}

	private static List<String> getAllUrlFromFile(String filePath) {
		List<String> l = new ArrayList<String>();
		FileReader f = new FileReader(filePath);
		while(f.hasNext()){
			String line = f.readLine();
//			if(line.matches(regex))
//			Util_String.matchAllRegx(line, ".*url({1})");
			while(Util_String.matchAllRegx(line, ".*url({1}.*).*")){
				line = line.substring(line.indexOf("url("));
				String url = line.substring(line.indexOf("(")+1, line.indexOf(")"));
				if(Util_String.matchAllSameRegx(url,"http{1}.*"))
					l.add(url);
				line = line.substring(line.indexOf(")")+1);
			}
		}
		return l;
	}

}
