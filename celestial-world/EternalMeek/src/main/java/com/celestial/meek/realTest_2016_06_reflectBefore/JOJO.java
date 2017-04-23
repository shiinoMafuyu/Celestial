package com.celestial.meek.realTest_2016_06_reflectBefore;

import java.sql.Date;
import java.util.List;
import java.util.Random;

public class JOJO {
	String name;
	Integer age;
	Date bornDate;
	List skill;
	
	public void ouLa(){
		System.out.println("ouLa!ouLa!ouLa!ouLa!!");
	}
	
	public Integer leftOrRight(){
		Random r=new Random();
		return r.nextInt(3);
	}
	
	public List showSkill(){
		if(skill!=null&&skill.size()>0){
			for(Object i:skill){
				System.out.println(i);
			}
		}
		return skill;
	}

	public void ouLaN(int n){
		for(int i=0;i<n;i++){
			System.out.println("ouLa!ouLa!ouLa!ouLa!!");
		}
	}
	@Override
	public String toString() {
		return "JOJO [name=" + name + ", age=" + age + ", bornDate=" + bornDate
				+ ", skill=" + skill + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getBornDate() {
		return bornDate;
	}

	public void setBornDate(Date bornDate) {
		this.bornDate = bornDate;
	}

	public List getSkill() {
		return skill;
	}

	public void setSkill(List skill) {
		this.skill = skill;
	}
	
	
	
	
}
