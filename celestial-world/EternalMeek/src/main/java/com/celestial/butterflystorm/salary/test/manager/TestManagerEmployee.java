package com.celestial.butterflystorm.salary.test.manager;

import junit.framework.TestCase;

import com.celestial.agniRadiance.EzUtil.Container;
import com.celestial.butterflystorm.salary.Interface.manager.ManageEmployee;
import com.celestial.butterflystorm.salary.implement.manager.ManagerEmployeeImpl;

public class TestManagerEmployee extends TestCase{
	
	@SuppressWarnings("unused")
	public void testVariableCreate() {
		ManageEmployee me = new ManagerEmployeeImpl();//��getIMPL(newInstance)��ʽ��ʼ���ĳ�Ա��������ʼ����
		ManageEmployee me2 = (ManageEmployee)Container.getRealizationObject("ManageEmployee");//û��
	}
}
