/******************************************************************
 * Test.java
 * Copyright 2017 by WZG. All Rights Reserved.
 * CreateDate：2017年9月4日
 * Author：wangzg
 * Version：1.0.0
 ******************************************************************/

package com.celestial.meek.realTest_2017_09;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import com.celestial.meek.realTest_2017_07.SerialTest.Person;

/**
 * <b>修改记录：</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2017年9月4日
 * </li>
 * </p>
 * 
 * <b>类说明：</b>
 * <p> 
 * 
 * </p>
 */
public class TestNormal {
	
	public static void main(String[] args) {
//		for(String si :"typeID no name prizeID receiveIndate status".split(" ")){
//			System.out.println("/**  */\nprivate String " + si + ";\n");
//		}
//		String s = "{4:3,5:6}";
//		String[] sArr = s.replaceAll(" ", "").replaceAll("\\{","").replaceAll("\\}", "").split(",");
//		System.out.println(sArr);
//		System.out.println(Test.class.getTypeName());
		
		
		String insert = new StringBuffer("")
				.append("insert into ft_game_records_h(")
				.append("  gameid,userid,typeid,currentlevelno,orderid,")
				.append("  orderbean,levelprize,starttime,endtime,finishtime,")
				.append("  lotterytime,status,isoverdue,isprizeoverdue,updatetime,")
				.append("  importtime")
				.append(") (")
				
				.append("  select ")
				.append("     t.gameid,t.userid,t.typeid,t.currentlevelno,t.orderid,")
				.append("      t.orderbean,t.levelprize,t.starttime,t.endtime,t.finishtime,")
				.append("      t.lotterytime,t.status,t.isoverdue,t.isprizeoverdue,t.updatetime,")
				.append("      sysdate")
				.append("	from ft_game_records t,ft_game_level gl ")
				.append("	where 1 = 1 ")
				.append("    and t.gameid in " + SELECT_OVER_GAMEID + " ")
				.append(")")
				
				.toString();
		
		System.out.println(insert);
		
	}
	static final String SELECT_OVER_GAMEID = new StringBuffer("")
			.append("(select t.gameID gameID ")
			.append("  from ft_game_records t, ft_game_level gl ")
			.append(" where 1 = 1 ")
			.append("   and gl.typeid(+) = t.typeid ")
			.append("   and gl.no(+) = t.currentlevelno ")
			.append("   and (t.status in (2, 3, 5) or (t.status = 1 and gl.prizeid is null and t.isOverdue = 2)) )")
			.toString();
	
	@Test
	public void _02_abc(){
		
	}
	
	@Test
	public void _01_reference(){
		Person p = new Person().setAge(1);
		Person p2 = new Person().setAge(1);
		System.out.println(p == p2);
		System.out.println(p.equals(p2));
		
		Map<Person,String> m = new HashMap<>();
		String val = "我缠住条子，你们快跑！";
		m.put(p, val);
		
		Assert.assertEquals(val,m.get(p));
		Assert.assertTrue(null == m.get(p2));
		
		p.setName("shiro");
		
		Assert.assertEquals(val, m.get(p));
		
	}
	
}
