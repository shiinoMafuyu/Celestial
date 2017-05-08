package com.celestial.butterflystorm.butterfly2016.salary.implement.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

import com.celestial.agniRadiance.entity.Tag;
import com.celestial.butterflystorm.butterfly2016.salary.Interface.entity.Employee;

public class EmployeeFixed extends Employee{

	public EmployeeFixed(Tag t) {
		this.name = t.getTagByNamesReal("name").getValue();
		this.age = Integer.valueOf(t.getTagByNamesReal("age").getValue());
		this.gender = Integer.valueOf(t.getTagByNamesReal("gender").getValue());
		this.salary = Double.valueOf(t.getTagByNamesReal("salary").getValue());
		this.unions = t.getTagByNamesReal("union").getValue();
		this.unionList = Arrays.asList(this.unions.split(","));
	}

	public EmployeeFixed() {
	}

	public EmployeeFixed(ResultSet rs) throws SQLException {
		this.id = rs.getInt("id");
		this.name = rs.getString("name");
		this.age = rs.getInt("age");
		this.gender = rs.getInt("gender");
		this.salary = rs.getDouble("salary");
		this.unions = rs.getString("unions");
		this.unionList = Arrays.asList(this.unions.split(","));
	}
	
}
