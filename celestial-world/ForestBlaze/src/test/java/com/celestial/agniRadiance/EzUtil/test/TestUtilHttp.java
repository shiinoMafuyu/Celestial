/******************************************************************
 * TestUtil_Http.java
 * Copyright 2017 by WZG. All Rights Reserved.
 * CreateDate��2017��9��7��
 * Author��wangzg
 * Version��1.0.0
 ******************************************************************/

package com.celestial.agniRadiance.EzUtil.test;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Test;

import com.celestial.agniRadiance.EzUtil.UtilString;
import com.celestial.agniRadiance.remote.UtilHttp;

import net.sf.json.JSONDynaBean;
import net.sf.json.JSONObject;

/**
 * <b>�޸ļ�¼��</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2017��9��7��
 * </li>
 * </p>
 * 
 * <b>��˵����</b>
 * <p> 
 * 
 * </p>
 */
public class TestUtilHttp {
	
	@Test
	public void _01_01_queryPhone(){
		String s = UtilHttp.doPost2("http://tcc.taobao.com/cc/json/mobile_tel_segment.htm?tel=18235146546", "");
		System.out.println("�Ա�:"+s);
		
//		s = Util_Http.doPost2("https://www.baifubao.com/callback?cmd=1059&callback=phone&phone=18235146546", "");
//		System.out.println("�ٸ���:"+s);
		
	}
	
	@Test
	public void _01_02_JsonOperator(){
		
		JSONObject js = new JSONObject("{    mts:'1823514',    province:'ɽ��',    catName:'�й��ƶ�',    telString:'18235146546',	areaVid:'30502',	ispVid:'3236139',	carrier:'ɽ���ƶ�',home:{jpHome:'�㵺',cnHome:'����'}}");
		JSONDynaBean obj = (JSONDynaBean)JSONObject.toBean(js);
		System.out.println(obj);
		
		JSONDynaBean home = (JSONDynaBean)obj.get("home");
		System.out.println(home.get("jpHome"));
		
		String s = "__GetZoneResult_ = {    mts:'1823514',    province:'ɽ��',    catName:'�й��ƶ�',    telString:'18235146546',	areaVid:'30502',	ispVid:'3236139',	carrier:'ɽ���ƶ�',home:{jpHome:'�㵺',cnHome:'����'}}";
		String s2 = UtilString.getMatchIn2(s, "{", "}", 0);
		System.out.println(s2);
		
		JSONObject jo = new JSONObject(new StringBuilder(200).append("{").append(s2).append("}").toString());
		System.out.println("----->\n"+jo);
		
	}
	
	@Test
	public void _03_01_MapReference(){
		/** p1�����ô��ݸ���Map,p1����Map��͸��ˣ�Ȼ��p1����������λ�ã�������Ͳ��ٶ�Map��Ĳ���Ӱ����. */
		Map<Person,Integer> m= new LinkedHashMap<>();
		Person p1 = new Person().setName("maya").setAge(17);
		p1.setName("maya2");
		m.put(p1, 1);
		p1 = new Person().setName("shiino").setAge(15);
		
		System.out.println(m);
	}
	
	public void _04_01_Json2Object(){
		
	}
	
	
 	class Person{
		
		private String name;
		private Integer Age;
		public String getName() {
			return name;
		}
		public Integer getAge() {
			return Age;
		}
		public Person setName(String name) {
			this.name = name;
			return this;
		}
		public Person setAge(Integer age) {
			Age = age;
			return this;
		}
		@Override
		public String toString() {
			return "Person [name=" + name + ", Age=" + Age + "]";
		}
		
	}
	
	
}
