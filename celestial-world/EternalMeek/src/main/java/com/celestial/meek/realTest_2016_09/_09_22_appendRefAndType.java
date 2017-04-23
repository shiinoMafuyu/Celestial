package com.celestial.meek.realTest_2016_09;

import java.util.ArrayList;
import java.util.List;

import com.celestial.agniRadiance.EzUtil.Util_String;
import com.celestial.agniRadiance.entity.FileReader;

public class _09_22_appendRefAndType {

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param args 
	 */
	public static void main(String[] args) {
		smipleTagDealWith();
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 简单处理下标签.
	 * </ul>
	 */
	private static void smipleTagDealWith() {
		//可以配置个标签对应的map试试.
		FileReader f = new FileReader("E:/anotherDeskTop/parese2/fall/E现货--手机客户端与服务器通信协议(旧) - 牺牲品.txt");
		List<String> l = new ArrayList<String>();
		while(f.hasNext()){
			String s = f.readLine();
			int index = Util_String.__containCompleteSimpleTag(s);
			if(index != -1){
				StringBuffer sb = new StringBuffer(s.substring(0,index)).append(" ref=\"\" type=\"\"").append(s.substring(index));
				System.out.println(sb.toString());
			}
		}
		
	}

}
