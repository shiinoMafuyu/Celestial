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
 * <b>�޸ļ�¼��</b> 
 * <p>
 * <li>
 * ��������ʱ���ʱ����ȡ������Ϣ������xmlΪ������Ԫ�����¸�ֵ ʾ��д��<br/>
 *                        ---- wangzg 2017-5-24
 * </li>
 * </p>
 * 
 * <b>��˵����</b>
 * <p> 
 * ��ʼ����ѯsql�ࡣ
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
			//�������ü��ض�Ӧsql��ѯ�����ļ�
			File f = UtilFile.loadConfigSource(market+".xml");
			//���������ļ����ض�Ӧ���г���ѯsquall
			Document document = new SAXReader().read(f);
			//����ΪMap<String,Map<String,String>> Map<dao��,Map<sql��,��ѯsql>>����ʽ
			Map<String,Map<String,String>> daoMap = parseSqlXml(document.getRootElement());
			//����sqlMap���dao����sql����λ��Ա����λ�ã�ʹ�÷�����ж�̬��ֵ���ö������ݣ����Ƕ�Ӧ�ı�׼sql��
			inspiritVariable(daoMap);
			System.out.println(String.format("���������ļ���%s����ע��ɹ���",market+".xml"));
		} catch (Exception e) {
			String msg = String.format("δ�ɹ����ض���������Ϣ��ʹ�ñ�׼��sql��\n�����г���%1$s\n%2$s ", market,e.getStackTrace());
			System.out.println(msg);
		}
	}
	
	
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ����sqlMap���dao����sql����λ��Ա����λ�ã�ʹ�÷�����ж�̬��ֵ���ö������ݣ����Ƕ�Ӧ�ı�׼sql��<br/>
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
	  * <b>����˵����</b>
	  * <ul>
	  * ��һ��dao���϶���map��ļ�ֵ�ԣ���Ӧ�ĳ�Ա����ֵ��
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
	 * <b>����˵����</b>
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
	 * <b>����˵����</b>
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
