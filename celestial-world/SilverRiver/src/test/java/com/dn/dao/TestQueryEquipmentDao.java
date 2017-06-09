package com.dn.dao;


import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.celestial.agniRadiance.entity.Print;
import com.dn.entity.Equipment;



@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestQueryEquipmentDao{
	
	static ApplicationContext ac =null;
	static QueryEquipmentDao theDao = null;
	
	static Equipment entity =null;
	
	static Print p = new Print(true);
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ac = new FileSystemXmlApplicationContext("src/main/resources/applicationContext.xml");
		theDao = ac.getBean(QueryEquipmentDao.class);
		
	}
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	@Test
	public void _01_insert(){
		entity = new Equipment().setRepresentId("009300010001").setLevel(90).setGoodslevel("S").setName("冰龙头盔").setAg(12.5).setHg(22.33);
		int re = theDao.insert(entity);
		Assert.assertTrue(re >=0);
	}
	
	@Test
	public void _02_select01(){
		List<Equipment> entityList = theDao.selectByCondition(entity);
		System.out.println("条件查询：");
		for(Equipment i:entityList){
			System.out.println(i);
		}
		Assert.assertTrue(null != entityList && entityList.size() > 0);
		entity = entityList.get(0);
	}
	
	@Test
	public void _02_select02_vague(){
		List<Equipment> entityList = theDao.selectByVague(entity);
		System.out.println("模糊查询：");
		for(Equipment i:entityList){
			System.out.println(i);
		}
		Assert.assertTrue(null != entityList && entityList.size() > 0);
	}
	
	
	@Test
	public void _03_update(){
		try {
			entity.setWg("15000~30000");
			theDao.update(entity);
			
			List<Equipment> entityList = theDao.selectByCondition(new Equipment(entity.getId()));
			Assert.assertTrue(entity.equals(entityList.get(0)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void _04_delete(){
		theDao.deleteById(entity.getId());
		List<Equipment> entityList = theDao.selectByCondition(new Equipment(entity.getId()));
		Assert.assertTrue(entityList.size() == 0);
	}
	
	/*@Test
	public void _05_select_join(){
		List<Equipment>  l=  theDao.selectByCondition(new Equipment(1));
		System.out.println(l.get(0).getStrengthenList());
		Assert.assertTrue(l.get(0).getStrengthenList().size() > 0);
	}*/
	
	
}
