/******************************************************************
 * ParseXML.java
 * Copyright 2017 by GNNT Company. All Rights Reserved.
 * CreateDate��2017��5��24��
 * Author��wangzg
 * Version��1.0.0
 ******************************************************************/

package com.celestial.meek.realTest_2017_05;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * <b>�޸ļ�¼��</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2017��5��24��
 * </li>
 * </p>
 * 
 * <b>��˵����</b>
 * <p> 
 * 
 * </p>
 */
public class ParseXML {

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param args 
	 * @throws DocumentException 
	 */
	public static void main(String[] args) throws DocumentException {
		String path = "src/main/java/com/celestial/meek/realTest_2017_05/file/GUO_SHANG.xml";
		
		SAXReader rd = new SAXReader();
		Document d = rd.read(new File(path));
		Element root = d.getRootElement();
//		List<Attribute> list = re.attributes();
//		System.out.println(1);
//		listNodes(root);
		
//		Map<String,Map<String,String>> sm = parseSqlXml(root);
		
	}





	public static void listNodes(Element node){  
	        System.out.println("��ǰ�ڵ�����ƣ�" + node.getName());  
	        //���Ȼ�ȡ��ǰ�ڵ���������Խڵ�  
	        List<Attribute> list = node.attributes();  
	        //�������Խڵ�  
	        for(Attribute attribute : list){  
	            System.out.println("����"+attribute.getName() +":" + attribute.getValue());  
	        }  
	        //�����ǰ�ڵ����ݲ�Ϊ�գ������  
	        if(!(node.getTextTrim().equals(""))){  
	             System.out.println( node.getName() + "��" + node.getText());    
	        }  
	        //ͬʱ������ǰ�ڵ�����������ӽڵ�  
	        //ʹ�õݹ�  
	        Iterator<Element> iterator = node.elementIterator();
	        while(iterator.hasNext()){
	            Element e = iterator.next();
	            listNodes(e);
	        }  
	    }  
}
