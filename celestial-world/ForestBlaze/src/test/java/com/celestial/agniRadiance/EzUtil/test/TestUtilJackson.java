/******************************************************************
 * TestUtil_Jackson.java
 * Copyright 2017 by WZG. All Rights Reserved.
 * CreateDate：2017年9月7日
 * Author：wangzg
 * Version：1.0.0
 ******************************************************************/

package com.celestial.agniRadiance.EzUtil.test;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.junit.Test;

import com.celestial.agniRadiance.EzUtil.test.jackson.JacksonMapper;

/**
 * <b>修改记录：</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2017年9月7日
 * </li>
 * </p>
 * 
 * <b>类说明：</b>
 * <p> 
 * 
 * </p>
 */
public class TestUtilJackson {
	
	@Test
	public void _01_01_jacksonte() throws JsonGenerationException, JsonMappingException, IOException{
		Person p = new Person().setName("kurise").setAge(17);
		p.setHome(new Home().setAddress("半人马座阿尔法星").setArea(3432432342.365));
		String s = JacksonMapper.getInstance().writeValueAsString(p);
		
		System.out.println(s);
		
	}
	
	
	class Person{
		private int age;
		private Double hight;
		private String name;
		private Date birthday;
		private Timestamp endTime;
		private short IQ;
		
		private Home home;
		
		
		public Integer getAge() {
			return age;
		}
		public Double getHight() {
			return hight;
		}
		public String getName() {
			return name;
		}
		public Date getBirthday() {
			return birthday;
		}
		public short getIQ() {
			return IQ;
		}
		public Person setAge(Integer age) {
			this.age = age;
			return this;
		}
		public Person setHight(Double hight) {
			this.hight = hight;
			return this;
		}
		public Person setName(String name) {
			this.name = name;
			return this;
		}
		public Person setBirthday(Date birthday) {
			this.birthday = birthday;
			return this;
		}
		public Person setIQ(short iQ) {
			IQ = iQ;
			return this;
		}
		
		public Timestamp getEndTime() {
			return endTime;
		}
		public Person setEndTime(Timestamp endTime) {
			this.endTime = endTime;
			return this;
		}
		public Person setAge(int age) {
			this.age = age;
			return this;
		}
		@Override
		public String toString() {
			return "Person [age=" + age + ", hight=" + hight + ", name=" + name
					+ ", birthday=" + birthday + ", endTime=" + endTime + ", IQ="
					+ IQ + "]";
		}
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + IQ;
			result = prime * result + age;
			result = prime * result
					+ ((birthday == null) ? 0 : birthday.hashCode());
			result = prime * result + ((endTime == null) ? 0 : endTime.hashCode());
			result = prime * result + ((hight == null) ? 0 : hight.hashCode());
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Person other = (Person) obj;
			if (IQ != other.IQ)
				return false;
			if (age != other.age)
				return false;
			if (birthday == null) {
				if (other.birthday != null)
					return false;
			} else if (!birthday.equals(other.birthday))
				return false;
			if (endTime == null) {
				if (other.endTime != null)
					return false;
			} else if (!endTime.equals(other.endTime))
				return false;
			if (hight == null) {
				if (other.hight != null)
					return false;
			} else if (!hight.equals(other.hight))
				return false;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			return true;
		}
		
		public Home getHome() {
			return home;
		}
		public Person setHome(Home home) {
			this.home = home;
			return this;
		}
		
		
		
		
	}

	class Home{
		private String address;
		private Double area;
		
		@Override
		public String toString() {
			return "Home [address=" + address + ", area=" + area + "]";
		}

		public String getAddress() {
			return address;
		}

		public Double getArea() {
			return area;
		}

		public Home setAddress(String address) {
			this.address = address;
			return this;
		}

		public Home setArea(Double area) {
			this.area = area;
			return this;
		}
		
		
	}
	
}
