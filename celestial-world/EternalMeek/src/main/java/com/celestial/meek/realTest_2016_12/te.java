package com.celestial.meek.realTest_2016_12;

public class te {
	
	public static void main(String[] args) {
		String sql = "select t.commodityid,t2.name,t.bs_flag,t.quantity,t.tradefee,t.close_pl,t.price,t.tradetime,t.tradeno," +
				"decode(t.oc_flag, 'O', '1', 'C', '2') oc_flag,t.tradetype,t.openprice,nvl(t.holdprice, 0) holdprice " +
				"from t_commodity_h t2,t_trade_h t where t2.commodityid = t.commodityid and t2.cleardate = t.cleardate " +
				"and trunc(t.cleardate)>=? and trunc(t.cleardate)<=? and t.firmid = ? order by t.tradeno desc";
		System.out.println(sql);
	}
	
	
}
