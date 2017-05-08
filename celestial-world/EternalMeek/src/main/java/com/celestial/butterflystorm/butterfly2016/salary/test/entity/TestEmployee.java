package com.celestial.butterflystorm.butterfly2016.salary.test.entity;

import com.celestial.agniRadiance.entity.Tag;
import com.celestial.butterflystorm.butterfly2016.salary.Interface.entity.Employee;
import com.celestial.butterflystorm.butterfly2016.salary.implement.entity.EmployeeFixed;

import junit.framework.TestCase;

public class TestEmployee extends TestCase {
	
	
	
	@Override
	protected void setUp() throws Exception {
		
	}
	
	public void testStructor() {
		String name = "微沙",age = "998",gender = "0",salary = "24000",union = "皇家党,扣费党,民进党";
//		Tag t = new Tag("<Employee><name></name><age>998</age><gender>0</gender><salary>24000</salary><union>皇家党,扣费党,民进党</union></Employee>");
		Tag t = new Tag("<Employee><name>"+name+"</name><age>"+age+"</age><gender>"+gender+"</gender><salary>"+salary+"</salary><union>"+union+"</union></Employee>");
		Employee e = new EmployeeFixed(t);
		assertEquals(name, e.getName());
		assertEquals(age, e.getAge().toString());
		assertEquals(gender, e.getGender().toString());
		assertEquals(Double.valueOf(salary), e.getSalary());
		assertEquals(union, e.getUnions());
		
	}
}
