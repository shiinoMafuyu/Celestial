/******************************************************************
 * ABC.java
 * Copyright 2017 by WZG. All Rights Reserved.
 * CreateDate：2017年9月22日
 * Author：wangzg
 * Version：1.0.0
 ******************************************************************/

package com.celestial.meek.realTest_2017_09;

import java.sql.Timestamp;

import org.junit.Test;

/**
 * <b>修改记录：</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2017年9月22日
 * </li>
 * </p>
 * 
 * <b>类说明：</b>
 * <p> 
 * 
 * </p>
 */
public class ABC {
	
	
	@Test
	public void testAcb(){
		
		
//		String[] conditionArr = new String[]{" and gr.status = 2 "," and gr.status = 3 "," and gr.status = 5 ",
//		" and gr.status = 1 and gl.prizeid is null and gr.isOverdue = 2 "};
//		for(String si: conditionArr){
//			func(si);
//			gameRecord(si);
//		}
		
		System.out.println(new Timestamp(1506414315514L));
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param si 
	 */
	private void gameRecord(String condition) {
		//删除的数据是已导历史的数据，所以必须有一样的连接条件
		
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param string 
	 */
	private void func(String condition) {
		String insert = new StringBuffer("")
				.append("insert into ft_pass_level_records_h (")
				.append("  id,gameid,typeid,levelno,phaseno,")
				.append("  guessresult,createtime,status,")
				.append("  importtime ")
				.append(") (")
				.append("  select ")
				.append("    pl.id,pl.gameid,pl.typeid,pl.levelno,pl.phaseno,")
				.append("    pl.guessresult,pl.createtime,pl.status,")
				.append("    sysdate")
				
				.append("  from ft_game_level gl ,ft_game_records gr,ft_pass_level_records pl ")//一致的连接条件
				.append("  where 1 = 1 ")//一致的连接条件
				.append("    and gl.typeid(+) = gr.typeid ")//一致的连接条件
				.append("    and gl.no(+) = gr.currentlevelno ")//一致的连接条件
				.append("    and gr.gameid = pl.gameid ")//一致的连接条件
				
				.append(condition)//导历史条件
				.append(")")
				
				.toString();
			

		String delete = new StringBuffer("")
				.append("delete ft_pass_level_records pl where exists(")
				.append(" select 1 ")
				
				.append(" from ft_game_level gl ,ft_game_records gr ")//一致的连接条件
				.append("  where 1 = 1 ")//一致的连接条件
				.append("    and gl.typeid(+) = gr.typeid ")//一致的连接条件
				.append("    and gl.no(+) = gr.currentlevelno ")//一致的连接条件
				.append("    and gr.gameid = pl.gameid ")//一致的连接条件
				
				.append(condition)//导历史条件
				.append(")")
				.toString();
		
		System.out.println(insert+";");
		System.out.println(delete+";");
	}
}
