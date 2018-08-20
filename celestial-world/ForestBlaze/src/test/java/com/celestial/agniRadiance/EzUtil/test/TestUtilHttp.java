/******************************************************************
 * TestUtil_Http.java
 * Copyright 2017 by WZG. All Rights Reserved.
 * CreateDate：2017年9月7日
 * Author：wangzg
 * Version：1.0.0
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
 * <b>修改记录：</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2017年9月7日
 * </li>
 * </p>
 * 
 * <b>类说明：</b>
 * <p> 
 * 
 * </p>
 */
public class TestUtilHttp {
	
	@Test
	public void _01_01_queryPhone(){
		String s = UtilHttp.doPost2("http://tcc.taobao.com/cc/json/mobile_tel_segment.htm?tel=18235146546", "");
		System.out.println("淘宝:"+s);
		
//		s = Util_Http.doPost2("https://www.baifubao.com/callback?cmd=1059&callback=phone&phone=18235146546", "");
//		System.out.println("百付宝:"+s);
		
	}
	
	@Test
	public void _01_02_JsonOperator(){
		
		JSONObject js = new JSONObject("{    mts:'1823514',    province:'山西',    catName:'中国移动',    telString:'18235146546',	areaVid:'30502',	ispVid:'3236139',	carrier:'山西移动',home:{jpHome:'广岛',cnHome:'遂宁'}}");
		JSONDynaBean obj = (JSONDynaBean)JSONObject.toBean(js);
		System.out.println(obj);
		
		JSONDynaBean home = (JSONDynaBean)obj.get("home");
		System.out.println(home.get("jpHome"));
		
		String s = "__GetZoneResult_ = {    mts:'1823514',    province:'山西',    catName:'中国移动',    telString:'18235146546',	areaVid:'30502',	ispVid:'3236139',	carrier:'山西移动',home:{jpHome:'广岛',cnHome:'遂宁'}}";
		String s2 = UtilString.getMatchIn2(s, "{", "}", 0);
		System.out.println(s2);
		
		JSONObject jo = new JSONObject(new StringBuilder(200).append("{").append(s2).append("}").toString());
		System.out.println("----->\n"+jo);
		
	}
	
	@Test
	public void _03_01_MapReference(){
		/** p1将引用传递给了Map,p1改了Map里就改了；然后p1更改了引用位置，其操作就不再对Map里的产生影响了. */
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
