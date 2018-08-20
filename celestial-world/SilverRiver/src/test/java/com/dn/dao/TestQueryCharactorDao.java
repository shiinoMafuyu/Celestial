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
import com.dn.entity.Charactor;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestQueryCharactorDao {
	
	static ApplicationContext ac =null;
	static QueryCharactorDao theDao = null;
	
	static Charactor entity =null;
	
	static Print p = new Print(true);
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ac = new FileSystemXmlApplicationContext("src/main/resources/applicationContext.xml");
		theDao = ac.getBean(QueryCharactorDao.class);
		
	}
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	@Test
	public void _01_insert(){
		entity = new Charactor();
		entity.setName("月光");entity.setHp(152222);
		int re = theDao.insert(entity);
		Assert.assertTrue(re >=0);
	}
	
	@Test
	public void _02_select(){
		List<Charactor> entityList = theDao.selectByCondition(entity);
		for(Charactor i:entityList){
			System.out.println(i);
		}
		Assert.assertTrue(null != entityList && entityList.size() > 0);
	}
	
	@Test
	public void _02_select02_vague(){
		List<Charactor> entityList = theDao.selectByVague(entity);
		System.out.println("模糊查询：");
		for(Charactor i:entityList){
			System.out.println(i);
		}
		Assert.assertTrue(null != entityList && entityList.size() > 0);
	}
	
	@Test
	public void _03_update(){
		try {
			entity.setWg("15000~15000");
			theDao.update(entity);
			
			List<Charactor> entityList = theDao.selectByCondition(new Charactor(entity.getId()));
			Assert.assertTrue(entity.equals(entityList.get(0)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void _04_delete(){
		theDao.deleteById(entity.getId());
		List<Charactor> entityList = theDao.selectByCondition(new Charactor(entity.getId()));
		Assert.assertTrue(entityList.size() == 0);
	}
	
	
}
