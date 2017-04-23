package com.celestial.agniRadiance.entity.test;

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

import com.celestial.agniRadiance.EzUtil.Util_Collection;
import com.celestial.agniRadiance.EzUtil.test.entity.Equip;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SuppressWarnings("rawtypes")
public class TestUtil_Collection {
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	
	@Test
	public void _01_replaceList(){
		int start = 1,end =2;
		List<String> l = Arrays.asList(new String[]{"0","1","2","3","4","5","6","7","8","9"});
		System.out.println(l.get(start)+","+l.get(end));
		List re = Util_Collection.replaceList(l, start, end, Arrays.asList(new String[]{"love","shiino","mafuyu"}));
		System.out.println(re);
		Assert.assertEquals(re, Arrays.asList(new String[]{"0","1","love","shiino","mafuyu","2","3","4","5","6","7","8","9"}));
	}
	
	
	@Test
	public void _02_put(){
		Equip e = new Equip().setRepresentId("01").setName("真白");
		Equip[] eArr = new Equip[]{e,new Equip().setRepresentId("02").setName("真冬"),
									new Equip().setRepresentId("01").setName("真名"),
									new Equip().setRepresentId("02").setName("真霜")};
		List<Equip> l = new ArrayList<Equip>();for(Equip ei:eArr){l.add(ei);}
		List<Equip> l2 = new ArrayList<Equip>();l2.add(e);
		
		Map<String,List<Equip>> m = new HashMap<String,List<Equip>>();
		
		
		m.put("01", l2);
		try {
			for(Equip ei : l){
				Util_Collection.put(m, ei.getRepresentId(), ei);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		Assert.assertEquals(m.get("02").size(), 2);
		Assert.assertEquals(m.get("01").size(), 3);
		
	}
	
	
	
}
