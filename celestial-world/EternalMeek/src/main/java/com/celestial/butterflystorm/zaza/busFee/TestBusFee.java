package com.celestial.butterflystorm.zaza.busFee;

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
			System.out.println(year+"��:---------------------");
			for(int month = 1 ; month <= 12 ; month++){
				System.out.println(month + "�� : " + bf.getRecharge(year, month, 0) +"Ԫ");
			}
		}*/
		for(int month = 10 ; month <= 12 ; month++){
			System.out.println(month + "�� : " + bf.getRecharge(2016, month, 0) +"Ԫ");
		}
	}
}
/**
	0:
	10�� : 42Ԫ
	11�� : 44Ԫ
	12�� : 44Ԫ
	
	50:
	10�� : 52Ԫ
	11�� : 52Ԫ
	12�� : 52Ԫ
	
	60:
	10�� : 54Ԫ
	11�� : 52Ԫ
	12�� : 54Ԫ
	
	65:
	10�� : 54Ԫ
	11�� : 54Ԫ
	12�� : 54Ԫ
	
	100:
	10�� : 62Ԫ
	11�� : 60Ԫ
	12�� : 62Ԫ
	
	
 */