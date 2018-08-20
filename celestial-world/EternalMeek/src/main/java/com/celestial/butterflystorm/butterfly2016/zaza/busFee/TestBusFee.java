package com.celestial.butterflystorm.butterfly2016.zaza.busFee;

import junit.framework.TestCase;

public class TestBusFee extends TestCase {
	BusFee bf;
	
	protected void setUp() throws Exception {
		bf = new BusFee();
	}

	public void testGetDayScattered(){
		int[] yayScattered;
		yayScattered = bf.getDayScattered(2016,10);
		assertEquals(21, yayScattered[0]);
		assertEquals(10, yayScattered[1]);
		
		yayScattered = bf.getDayScattered(2004,2);
		assertEquals(20, yayScattered[0]);
		assertEquals(9, yayScattered[1]);
		
		yayScattered = bf.getDayScattered(2017,2);
		assertEquals(20, yayScattered[0]);
		assertEquals(8, yayScattered[1]);
	}
	
	public void testGetRecharge(){
		double fee ;
		fee = bf.getRecharge(2017,2);
		assertEquals(20.0*2, fee);
		
		fee = bf.getRecharge(2016,10);
		assertEquals(21.0*2, fee);
		
		fee = bf.getRecharge(2016,11);
		assertEquals(22.0*2, fee);
		
		fee = bf.getRecharge(2016,11,50);
		assertEquals((22+4)*2.0, fee);
		
		fee = bf.getRecharge(2004,2);
		assertEquals((20)*2.0, fee);
		
		fee = bf.getRecharge(2016,2);
		assertEquals((21)*2.0, fee);
	};
	
	public void testResult(){
		/*for(int year = 2016; year <= 2016 +50 ; year++){
			System.out.println(year+"年:---------------------");
			for(int month = 1 ; month <= 12 ; month++){
				System.out.println(month + "月 : " + bf.getRecharge(year, month, 0) +"元");
			}
		}*/
		for(int month = 10 ; month <= 12 ; month++){
			System.out.println(month + "月 : " + bf.getRecharge(2016, month, 0) +"元");
		}
	}
}
/**
	0:
	10月 : 42元
	11月 : 44元
	12月 : 44元
	
	50:
	10月 : 52元
	11月 : 52元
	12月 : 52元
	
	60:
	10月 : 54元
	11月 : 52元
	12月 : 54元
	
	65:
	10月 : 54元
	11月 : 54元
	12月 : 54元
	
	100:
	10月 : 62元
	11月 : 60元
	12月 : 62元
	
	
 */
