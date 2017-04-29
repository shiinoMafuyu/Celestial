package com.celestial.butterflystorm.zaza.japaneseTrans.test;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.celestial.butterflystorm.zaza.japaneseTrans.Util_Japanese;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestUtil_Japnese {
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	@Test
	public void _01_wordTransToRoman() {
		
		String s = "¥³¥ó¥Ô¥å©`¥¿©`";
		String res = Util_Japanese.wordTransToRoman(s);
		//ko n pyu ©` ta ©`
		Assert.assertTrue("ko n pyu ©` ta ©` ".equals(res));
//		
		
		String re2 = Util_Japanese.wordTransToRoman("1£©¤ï¤¿¤·¡¡¤Ï¡¡¤Ó¤·¤ç¤¦¤Í¤ó¡¡¤Ç¤¹¡£");
		System.out.println(re2);
		Assert.assertEquals(re2, "1 £© wa ta shi ¡¡ ha ¡¡ bi sho u ne n ¡¡ de su ¡£ ");
		System.out.println(Util_Japanese.wordTransToRoman("¤­¤Ç¤¯¤À¤µ¤¤¤¤"));
	}
	
	
	
	
}
