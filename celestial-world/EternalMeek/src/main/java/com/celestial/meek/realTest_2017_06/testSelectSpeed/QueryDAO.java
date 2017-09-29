/******************************************************************
 * QueryDAO.java
 * Copyright 2017 by WZG. All Rights Reserved.
 * CreateDate：2017年6月27日
 * Author：wangzg
 * Version：1.0.0
 ******************************************************************/

package com.celestial.meek.realTest_2017_06.testSelectSpeed;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 * <b>修改记录：</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2017年6月27日
 * </li>
 * </p>
 * 
 * <b>类说明：</b>
 * <p> 
 * 
 * </p>
 */
public class QueryDAO extends JdbcTemplate{
	
	public List<Entity> getQuotation(Long[] range){
		String sql = "select * from (select rownum rw,t.* from rc_quotation_detail_h t) tx where tx.rw > ? and tx.rw <= ?";
		List<Entity> list = this.query(sql, new Object[]{range[0],range[1]}, new RowMapper<Entity>() {

			@Override
			public Entity mapRow(ResultSet rs, int arg1) throws SQLException {
				Entity et = new Entity();
				et.setImporttradedate(rs.getString("importtradedate"));
				et.setId(rs.getString("id"));
				et.setCommodityid(rs.getString("commodityid"));
				et.setOutprice(rs.getString("outprice"));

				et.setExchangerate(rs.getString("exchangerate"));
				et.setPrice(rs.getString("price"));
				et.setPriceno(rs.getString("priceno"));
				et.setQuotationqty(rs.getString("quotationqty"));

				et.setTradefundstotal(rs.getString("tradefundstotal"));
				et.setCorereceivetime(rs.getString("corereceivetime"));
				return et;
			}
		});
		
		return list;
	}
	
	
	/**
	 * <b>构造方法</b>
	 * <br/>
	 */
	public QueryDAO(DataSource ds) {
		this.setDataSource(ds);
	}


}
