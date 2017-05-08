package com.celestial.butterflystorm.butterfly2016.salary.Interface.manager;

import java.util.List;

import com.celestial.butterflystorm.butterfly2016.salary.Interface.entity.Employee;
/**
 * <b>�޸ļ�¼��</b> 
 * <p>
 * <li>
 * 
 *                        ---- Administrator 2016-10-17
 * </li>
 * </p>
 * 
 * <b>��˵����</b>
 * <p> 
 * ����ӿڵ�ʵ�����������������֮���.�൱��service,��ManagerEmployeeDao����Ϊdao��.<br/>
 * </p>
 */
public interface ManageEmployee {
	
	public void addEmployee(Employee employee);
	public void deleteEmployee(Employee employee);
	
	public Employee findEmployee(String id);
	public Employee findEmployee(Employee employee);
	public List<Employee> findAllEmployees(String name);
	
}
