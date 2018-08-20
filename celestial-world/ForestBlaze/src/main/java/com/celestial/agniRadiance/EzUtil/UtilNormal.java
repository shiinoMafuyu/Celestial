package com.celestial.agniRadiance.EzUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UtilNormal {
	/**
	 * 
	 * <b>方法说明：</b>
	 * <ul>
	 * 进行n此table退格
	 * </ul>
	 * @param createAllVariables
	 * @param i
	 * @return
	 */
	public static Collection<? extends String> table(Collection<? extends String> stringList, int n) {
		List<String> l = new ArrayList<String>();
		String s = UtilString.nstr("\t",n);
		for(String si : stringList){
			l.add(s+si);
		}
		return l;
	}

	public static Collection<? extends String> table(Collection<? extends String> stringList) {
		return table(stringList,1);
	}
	

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取当前层次里的下一个数。<br/>
	 * 用一个静态变量保存序列，初始化请调用方法initGradationTree<br/>
	 * 
	 * 这个是用来对遍历树进行编号用的。<br/>
	 * 每对一行获取一次，当前行数值就增大1.<br/>
	 * 如:getGradationTreeNum(1) = 0;getGradationTreeNum(1) =1;getGradationTreeNum(1) =2 ...<br/>
	 * </ul>
	 * @param talbelLevel
	 * @return
	 */
	public static int getGradationTreeNumNext(int talbelLevel) {
		List<Integer> currentLevelList = gradationTree.get(talbelLevel);
		if(null == currentLevelList){
			currentLevelList = new ArrayList<Integer>();
		}
		int range = currentLevelList.size();
		currentLevelList.add(range);
		gradationTree.put(talbelLevel, currentLevelList);
		
		return range;
	}
	
	private static Map<Integer,List<Integer>> gradationTree = new HashMap<Integer, List<Integer>>();
	
	public static void initGradationTree() {
		gradationTree = new HashMap<Integer, List<Integer>>();
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 将partList从倒数第n行插入list中
	 * </ul>
	 * @param list
	 * @param partList
	 * @param n
	 * @return 
	 */
	public static List<String> addAllList(List<String> list, List<String> partList, int n) {
		list.addAll(list.size() - 1 - n, partList);
		return list;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 线程休眠
	 * </ul>
	 * @param sleepPeriod
	 */
	public static void threadSleep(long sleepPeriod){
		try {
			Thread.sleep(sleepPeriod);
		} catch (Exception e) {
		}
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 解析返回的xml<br/>
	 * 解析为Map,一种非常粗糙的方式<br/>
	 * 有可取之处
	 * </ul>
	 * @param resStr
	 * @return 
	 */
	public static Map<String, String> pareseXml(String xml) {
		StringBuilder labelStr = new StringBuilder();
        StringBuilder valueStr = new StringBuilder();
        char lastLable = '\0';
        Map<String,String> map = new HashMap<>();
        for(int i = 0; i < xml.length(); i++)
        {
            char c = xml.charAt(i);
            if(c != '<' && c != '>' && lastLable != '>' && valueStr.length() == 0)
                labelStr.append(c);
            if(lastLable == '>' && valueStr.length() == 0 && c != '<' || valueStr.length() > 0 && c != '<')
                valueStr.append(c);
            if(labelStr.length() > 0 && valueStr.length() > 0 && c == '<')
                map.put(labelStr.toString(), valueStr.toString());
            if(lastLable == '>' && c == '<')
                labelStr.delete(0, labelStr.length());
            if(valueStr.length() > 0 && c == '<')
                valueStr.delete(0, valueStr.length());
            lastLable = c;
        }
        return map;
	}
	
}
