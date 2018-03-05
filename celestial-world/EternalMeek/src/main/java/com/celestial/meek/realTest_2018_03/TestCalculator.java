package com.celestial.meek.realTest_2018_03;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestCalculator {
	
	@Test
	public void add() {
		
		Calculator c1 = new Calculator("20011555");
		Calculator c2 = new Calculator("20011555");
		c1.add(c2);
		int val = Integer.valueOf(c1.getValue());
		Assert.assertTrue(20011555*2 == val);
		
		Calculator c3 = new Calculator("20011555");
		Calculator c31 = new Calculator("20011555");
		Calculator c4 = new Calculator("-20011556");
		Calculator c41 = new Calculator("-20011556");
		c3.add(c4);
		Assert.assertTrue(-1 == Integer.valueOf(c3.getValue()));
		c31.sub(c41);
		Assert.assertTrue(20011555+20011556 == Integer.valueOf(c31.getValue()));
		
		
		
	}
	
	
}
