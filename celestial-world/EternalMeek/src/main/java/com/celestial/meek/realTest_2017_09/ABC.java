/******************************************************************
 * ABC.java
 * Copyright 2017 by WZG. All Rights Reserved.
 * CreateDate��2017��9��22��
 * Author��wangzg
 * Version��1.0.0
 ******************************************************************/

package com.celestial.meek.realTest_2017_09;

import java.sql.Timestamp;

import org.junit.Test;

/**
 * <b>�޸ļ�¼��</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2017��9��22��
 * </li>
 * </p>
 * 
 * <b>��˵����</b>
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
	 * <b>����˵����</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param si 
	 */
	private void gameRecord(String condition) {
		//ɾ�����������ѵ���ʷ�����ݣ����Ա�����һ������������
		
	}

	/**
	 * <b>����˵����</b>
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
				
				.append("  from ft_game_level gl ,ft_game_records gr,ft_pass_level_records pl ")//һ�µ���������
				.append("  where 1 = 1 ")//һ�µ���������
				.append("    and gl.typeid(+) = gr.typeid ")//һ�µ���������
				.append("    and gl.no(+) = gr.currentlevelno ")//һ�µ���������
				.append("    and gr.gameid = pl.gameid ")//һ�µ���������
				
				.append(condition)//����ʷ����
				.append(")")
				
				.toString();
			

		String delete = new StringBuffer("")
				.append("delete ft_pass_level_records pl where exists(")
				.append(" select 1 ")
				
				.append(" from ft_game_level gl ,ft_game_records gr ")//һ�µ���������
				.append("  where 1 = 1 ")//һ�µ���������
				.append("    and gl.typeid(+) = gr.typeid ")//һ�µ���������
				.append("    and gl.no(+) = gr.currentlevelno ")//һ�µ���������
				.append("    and gr.gameid = pl.gameid ")//һ�µ���������
				
				.append(condition)//����ʷ����
				.append(")")
				.toString();
		
		System.out.println(insert+";");
		System.out.println(delete+";");
	}
}
