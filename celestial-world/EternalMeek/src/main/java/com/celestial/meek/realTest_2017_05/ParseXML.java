/******************************************************************
 * ParseXML.java
 * Copyright 2017 by GNNT Company. All Rights Reserved.
 * CreateDate：2017年5月24日
 * Author：wangzg
 * Version：1.0.0
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
 * <b>修改记录：</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2017年5月24日
 * </li>
 * </p>
 * 
 * <b>类说明：</b>
 * <p> 
 * 
 * </p>
 */
public class ParseXML {

	/**
	 * <b>方法说明：</b>
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
	        System.out.println("当前节点的名称：" + node.getName());  
	        //首先获取当前节点的所有属性节点  
	        List<Attribute> list = node.attributes();  
	        //遍历属性节点  
	        for(Attribute attribute : list){  
	            System.out.println("属性"+attribute.getName() +":" + attribute.getValue());  
	        }  
	        //如果当前节点内容不为空，则输出  
	        if(!(node.getTextTrim().equals(""))){  
	             System.out.println( node.getName() + "：" + node.getText());    
	        }  
	        //同时迭代当前节点下面的所有子节点  
	        //使用递归  
	        Iterator<Element> iterator = node.elementIterator();
	        while(iterator.hasNext()){
	            Element e = iterator.next();
	            listNodes(e);
	        }  
	    }  
}
