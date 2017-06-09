package com.celestial.agniRadiance.entity.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.celestial.agniRadiance.entity.FileReader;
import com.celestial.agniRadiance.entity.Tag;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestTag {
	
	public static FileReader f2 = null;
	
	public static String tagStr = new StringBuffer("")
			.append("<st>")
			.append("koni = select t.*,")
			.append("       u.Quantity,")
			.append("       s.TradeDate,")
			.append("       nvl(fe.InsuranceFee, 0) InsuranceFee,")
			.append("       nvl(fe.TrusteeFee, 0) TrusteeFee,")
			.append("       nvl(fe.StorageFee, 0) StorageFee,")
			.append("       fa.FundsAccountID,")
			.append("       faop.FundsAccountID o_FundsAccountID,")
			.append("       co.ContractFactor,")
			.append("       od.price orderPrice")
			.append("  from su_trade           t,")
			.append("       su_orders          u,")
			.append("       su_systemstatus    s,")
			.append("       su_HoldFee         fe,")
			.append("       FE_FP_FundsAccount fa,")
			.append("       FE_FP_FundsAccount faop,")
			.append("       SU_Commodity       co,")
			.append("       SU_Orders          od")
			.append(" where 1 = 1")
			.append("   and fe.TradeNo(+) = t.TradeNo")
			.append("   and t.OrderNo = u.OrderNo")
			.append("   and co.CommodityID = t.CommodityID")
			.append("   and od.OrderNo = t.OrderNo")
			.append("   and fa.Belonger = t.Belonger")
			.append("   and faop.Belonger = t.OppBelonger")
			.append("   and t.TradeTime >= ?")
			.append("   and t.TradeTime < ?;")
			.append("</st>")
			.toString();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	
	
	@Test
	public void _01_createTag(){
		Tag t = new Tag(tagStr);
		System.out.println(t.getTagName());
	}
	
	@Test
	public void _02_dom4j(){
		
	}
	
	
	
}
