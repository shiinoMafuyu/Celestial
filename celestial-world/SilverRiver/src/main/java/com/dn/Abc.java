/******************************************************************
 * Abc.java
 * Copyright 2017 by WZG. All Rights Reserved.
 * CreateDate：2017年6月5日
 * Author：wangzg
 * Version：1.0.0
 ******************************************************************/

package com.dn;

/**
 * <b>修改记录：</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2017年6月5日
 * </li>
 * </p>
 * 
 * <b>类说明：</b>
 * <p> 
 * 
 * </p>
 */
public class Abc {

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param args 
	 */
	public static void main(String[] args) {
		System.out.println(new StringBuffer("")
			.append("select t.billID stockId, ")//仓单号
			.append("       t.belonger customId, ")//所属交易商id
			.append("       t.breedId breedId, ")//所属品种分类Id
			.append("       '- -' commodityID, ")//商品编码
			
			.append("       t.warehouseId warehouseId, ")//仓库编号
			.append("       '-1' quantity, ")//商品数量
			.append("       t.quantity stockQuantity, ")//仓单数量
			.append("       t.frozenqty freezeQuantity, ")//冻结数量
			
			.append("       t.createTime createTime, ")//创建时间
			.append("       nvl(t.updatetime,t.createTime) modifyTime, ")//修改时间
			.append("       'N' chgDirection, ")//仓单变动方向
			.append("       t.belongerType customType ")//用户类型
			.append("  from bl_bill t  ")
			.append(" where trunc(t.CreateTime) = ?")
			.toString());
		
	}

}
