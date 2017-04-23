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
import com.dn.entity.Strengthen;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestQueryStrengthenDao {
	
	static ApplicationContext ac =null;
	static QueryStrengthenDao theDao = null;
	
	static Strengthen entity =null;
	
	static Print p = new Print(true);
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try {
			ac = new FileSystemXmlApplicationContext("src/main/resources/applicationContext.xml");
			theDao = ac.getBean(QueryStrengthenDao.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	@Test
	public void _01_insert(){
		entity = new Strengthen();
		entity.setRepresentId("009300010001");entity.setStrengthenKind("90S-冰龙-头盔");entity.setStrengthenLevel(14);entity.setLevel(90);entity.setAf(2.33);entity.setAg(8.43);entity.setMg("16000~16000");
		int re = theDao.insert(entity);
		Assert.assertTrue(re >=0);
	}
	
	@Test
	public void _02_select(){
		List<Strengthen> entityList = theDao.selectByCondition(entity);
		System.out.println("条件查询：");
		for(Strengthen i:entityList){
			System.out.println(i);
		}
		Assert.assertTrue(null != entityList && entityList.size() > 0);
	}
	
	@Test
	public void _02_select02_vague(){
		List<Strengthen> entityList = theDao.selectByVague(entity);
		System.out.println("模糊查询：");
		for(Strengthen i:entityList){
			System.out.println(i);
		}
		Assert.assertTrue(null != entityList && entityList.size() > 0);
	}
	
	@Test
	public void _03_update(){
		try {
			entity.setWg("15000~30000");
			theDao.update(entity);
			
			List<Strengthen> entityList = theDao.selectByCondition(new Strengthen(entity.getId()));
			Assert.assertTrue(entity.equals(entityList.get(0)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void _04_delete(){
		theDao.deleteById(entity.getId());
		List<Strengthen> entityList = theDao.selectByCondition(new Strengthen(entity.getId()));
		Assert.assertTrue(entityList.size() == 0);
	}
	
	
}
