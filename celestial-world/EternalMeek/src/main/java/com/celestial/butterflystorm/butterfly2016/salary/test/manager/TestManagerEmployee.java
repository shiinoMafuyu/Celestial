package com.celestial.butterflystorm.butterfly2016.salary.test.manager;

import com.celestial.agniRadiance.EzUtil.Container;
import com.celestial.butterflystorm.butterfly2016.salary.Interface.manager.ManageEmployee;
import com.celestial.butterflystorm.butterfly2016.salary.implement.manager.ManagerEmployeeImpl;

import junit.framework.TestCase;

public class TestManagerEmployee extends TestCase{
	
	@SuppressWarnings("unused")
	public void testVariableCreate() {
		ManageEmployee me = new ManagerEmployeeImpl();//��getIMPL(newInstance)��ʽ��ʼ���ĳ�Ա��������ʼ����
		ManageEmployee me2 = (ManageEmployee)Container.getRealizationObject("ManageEmployee");//û��
	}
}
