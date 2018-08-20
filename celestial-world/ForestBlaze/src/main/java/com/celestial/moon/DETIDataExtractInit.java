package com.celestial.moon;

import java.io.File;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.support.ApplicationObjectSupport;

import com.celestial.agniRadiance.EzUtil.UtilFile;
import com.celestial.agniRadiance.EzUtil.UtilString;

/**
 * 
 * <b>修改记录：</b> 
 * <p>
 * <li>
 * 容器加载时完毕时，获取容器信息，解析xml为容器里元素重新赋值 示例写法<br/>
 *                        ---- wangzg 2017-5-24
 * </li>
 * </p>
 * 
 * <b>类说明：</b>
 * <p> 
 * 初始化查询sql类。
 * </p>
 */
public class DETIDataExtractInit extends ApplicationObjectSupport implements ApplicationListener<ContextRefreshedEvent> {
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		init();
	}
	
	private static ApplicationContext ac =  null;
	
	private String market = "";

	private void init() {
		
		try {
			ac = getApplicationContext();
			market = (String)ac.getBean("market");
			//根据配置加载对应sql查询配置文件
			File f = UtilFile.loadConfigSource(market+".xml");
			//根据配置文件加载对应的市场查询squall
			Document document = new SAXReader().read(f);
			//解析为Map<String,Map<String,String>> Map<dao名,Map<sql名,查询sql>>的形式
			Map<String,Map<String,String>> daoMap = parseSqlXml(document.getRootElement());
			//根据sqlMap里的dao名和sql名定位成员变量位置，使用反射进行动态赋值。用定制内容，覆盖对应的标准sql。
			inspiritVariable(daoMap);
			System.out.println(String.format("加载配置文件【%s】，注入成功！",market+".xml"));
		} catch (Exception e) {
			String msg = String.format("未成功加载定制配置信息，使用标准版sql！\n配置市场：%1$s\n%2$s ", market,e.getStackTrace());
			System.out.println(msg);
		}
	}
	
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 根据sqlMap里的dao名和sql名定位成员变量位置，使用反射进行动态赋值。用定制内容，覆盖对应的标准sql。<br/>
	 * </ul>
	 * @param daoMap
	 */
	 private static void inspiritVariable(Map<String, Map<String, String>> daoMap) {
		 for(Entry<String, Map<String, String>> daoEi :daoMap.entrySet()){
			 String daoName = daoEi.getKey();
			 Object dao = ac.getBean(UtilString.transHeadToLowerCase(daoName));
			 if(null == dao){
				 continue;
			 }
			 Map<String,String> sqlMap = daoEi.getValue();
			 inspiritADao(dao,sqlMap);
			 
		 }
		
	}

	 /**
	  * <b>方法说明：</b>
	  * <ul>
	  * 对一个dao赋上多有map里的键值对，对应的成员变量值。
	  * </ul>
	  * @param dao
	  * @param sqlMap
	  */
	private static void inspiritADao(Object dao, Map<String, String> sqlMap) {
		for(Entry<String,String> ei : sqlMap.entrySet()){
			try {
				Field field = dao.getClass().getDeclaredField(ei.getKey());
				field.setAccessible(true);
				field.set(dao, ei.getValue());
			} catch (Exception e) {
			}
		}
		
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param node
	 * @return 
	 */
	@SuppressWarnings("unchecked")
	private static Map<String, Map<String, String>> parseSqlXml(Element node) {
		
		Map<String, Map<String, String>> m = new HashMap<String, Map<String, String>> ();
		Iterator<Element> it = node.elementIterator();
		while(it.hasNext()){
			Element ei = it.next();
			Map<String, String> daoMap = parseDaoNode(ei);
			m.put(ei.getName(), daoMap);
		}
		return m;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param ei
	 * @return 
	 */
	@SuppressWarnings("unchecked")
	private static Map<String, String> parseDaoNode(Element ei) {
		Map<String, String> m = new HashMap<String, String>();
		Iterator<Element> it = ei.elementIterator();
		while(it.hasNext()){
			Element sqlNode = it.next();
			Element ekey = sqlNode.element("key");
			Element evalue = sqlNode.element("value");
			m.put(ekey.getTextTrim(), evalue.getTextTrim());
		}
		
		return m;
	}

	
}
