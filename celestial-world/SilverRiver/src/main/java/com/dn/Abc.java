/******************************************************************
 * Abc.java
 * Copyright 2017 by WZG. All Rights Reserved.
 * CreateDate��2017��6��5��
 * Author��wangzg
 * Version��1.0.0
 ******************************************************************/

package com.dn;

/**
 * <b>�޸ļ�¼��</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2017��6��5��
 * </li>
 * </p>
 * 
 * <b>��˵����</b>
 * <p> 
 * 
 * </p>
 */
public class Abc {

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param args 
	 */
	public static void main(String[] args) {
		System.out.println(new StringBuffer("")
			.append("select t.billID stockId, ")//�ֵ���
			.append("       t.belonger customId, ")//����������id
			.append("       t.breedId breedId, ")//����Ʒ�ַ���Id
			.append("       '- -' commodityID, ")//��Ʒ����
			
			.append("       t.warehouseId warehouseId, ")//�ֿ���
			.append("       '-1' quantity, ")//��Ʒ����
			.append("       t.quantity stockQuantity, ")//�ֵ�����
			.append("       t.frozenqty freezeQuantity, ")//��������
			
			.append("       t.createTime createTime, ")//����ʱ��
			.append("       nvl(t.updatetime,t.createTime) modifyTime, ")//�޸�ʱ��
			.append("       'N' chgDirection, ")//�ֵ��䶯����
			.append("       t.belongerType customType ")//�û�����
			.append("  from bl_bill t  ")
			.append(" where trunc(t.CreateTime) = ?")
			.toString());
		
	}

}
