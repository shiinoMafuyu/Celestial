package com.celestial.agniRadiance.EzUtil.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.celestial.agniRadiance.EzUtil.UtilCollection;
import com.celestial.agniRadiance.EzUtil.UtilJson;
import com.celestial.agniRadiance.EzUtil.test.entity.Equip;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestUtilJson {
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	
	@Test
	public void _01_toJsonString(){
		Equip e = new Equip().setName("����");e.setGoodslevel("009300010001");e.setSuitId("qaq").setAf(12.33);
		
		String jsonstr = UtilJson.toJsonString(e);
		Assert.assertEquals("{\"suitId\":\"qaq\",\"name\":\"����\",\"goodslevel\":\"009300010001\",\"af\":\"12.33\"}", jsonstr);
	}
	
	@Test
	public void _02_stringToObject(){
		String jsonstr = "{\"suitId\":\"qaq\",\"name\":\"����\",\"goodslevel\":\"009300010001\",\"af\":\"12.33\"}";
		Equip e  = UtilJson.stringToObject(jsonstr, Equip.class);
		Assert.assertEquals("����" , e.getName());
		
		jsonstr = "{\"suitId\":\"qaq\",\"name\":\"����\",\"goodslevel\":\"009300010001\",\"af\":\"12.33\",id:12,gt:666}";
		e  = UtilJson.stringToObject(jsonstr, Equip.class);
		Assert.assertEquals(new Integer(12) , e.getId());
		Assert.assertEquals(new Double(12.33) , e.getAf());
	}
	
	@Test
	public void _03_toJsonStringArr(){
		Equip e = new Equip();e.setName("����");e.setGoodslevel("009300010001");e.setSuitId("qaq").setAf(12.33);
		Equip e2 = new Equip().setAg(2.33).setGf(2.54).setName("ѩ֮��").setRepresentId("�����绰110");
		List<Equip> l = Arrays.asList(new Equip[]{e,e2});
		String s = UtilJson.toJsonStringArr(l);
		
		Assert.assertEquals("[{\"suitId\":\"qaq\",\"name\":\"����\",\"goodslevel\":\"009300010001\",\"af\":\"12.33\"},{\"gf\":\"2.54\",\"representId\":\"�����绰110\",\"name\":\"ѩ֮��\",\"ag\":\"2.33\"}]"
				,s);
	}
	
	@Test
	public void _04_toJsonStringMap(){
		//��ȡһ������map �����˵�
		Equip e = new Equip().setRepresentId("01").setName("���");
		Equip[] eArr = new Equip[]{e,new Equip().setRepresentId("02").setName("�涬"),
									new Equip().setRepresentId("01").setName("����"),
									new Equip().setRepresentId("02").setName("��˪")};
		List<Equip> l = new ArrayList<Equip>();for(Equip ei:eArr){l.add(ei);}
		List<Equip> l2 = new ArrayList<Equip>();l2.add(e);
		
		Map<String,List<Equip>> m = new HashMap<String,List<Equip>>();
		
		
		m.put("01", l2);
		try {
			for(Equip ei : l){
				UtilCollection.put2MapList(m, ei.getRepresentId(), ei);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		//תjson
		
		String jsonArr = UtilJson.toJsonStringMap(m);
		Assert.assertEquals("{\"01\":[{\"representId\":\"01\",\"name\":\"���\"},{\"representId\":\"01\",\"name\":\"���\"},{\"representId\":\"01\",\"name\":\"����\"}],\"02\":[{\"representId\":\"02\",\"name\":\"�涬\"},{\"representId\":\"02\",\"name\":\"��˪\"}]}", 
				jsonArr);
		
		
	}
}
