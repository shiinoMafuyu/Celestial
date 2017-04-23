package com.celestial.butterflystorm.salary.Interface.entity;

import java.util.List;

public abstract class Employee {
	protected Integer id;
	
	protected String name;
	protected Integer age;
	protected Integer gender;
	
	protected Double salary;
	protected String unions;
	
	protected List<String> unionList;
	
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public List<String> getUnionList() {
		return unionList;
	}
	public void setUnionList(List<String> unionList) {
		this.unionList = unionList;
	}
	public String getUnions() {
		return unions;
	}
	public void setUnions(String unions) {
		this.unions = unions;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age
				+ ", gender=" + gender + ", salary=" + salary + ", unions="
				+ unions + "]";
	}
	
	
}
