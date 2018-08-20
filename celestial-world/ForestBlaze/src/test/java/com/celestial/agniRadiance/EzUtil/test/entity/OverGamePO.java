/******************************************************************
 * OverGame.java
 * Copyright ${year} by WZG. All Rights Reserved.
 * CreateDate：2017-6-12
 * Author：wanzg
 * Version：1.0.0
 ******************************************************************/

package com.celestial.agniRadiance.EzUtil.test.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * <b>修改记录：</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2017-6-15
 * </li>
 * </p>
 * 
 * <b>类说明：</b>
 * <p> 
 * 已结束游戏查询PO
 * </p>
 */
public class OverGamePO implements Serializable{
	
	/**  */
	private static final long serialVersionUID = 1L;
	
	/** 用户ID */
	private String userID;
	
	/** 游戏编号 */
	private Long gameID;

	/** 类别名称 */
	private String name;
	
	/** 类别编号 */
	private Long typeID;

	/** 最后关卡序号(游戏结束时所在关卡序号) */
	private Integer currentLevelNO;

	/** 开始日期 */
	private Timestamp startTime;
	
	/** 结束日期 */
	private Timestamp finishTime;
	
	/** 是否过期(1是2否) */
	private Integer isOverdue;
	
	/** 导入时间 */
	private Timestamp importTime;
	
	/** 更新时间 */
	private Timestamp updateTime;
	
	/** 状态 1进行中2已领取3失败结束4待领取5过期未领取6等待开奖 */
	private Integer status;


	@Override
	public String toString() {
		return "OverGamePO [userID=" + userID + ", gameID=" + gameID + ", name=" + name + ", typeID=" + typeID
				+ ", currentLevelNO=" + currentLevelNO + ", startTime=" + startTime + ", finishTime=" + finishTime
				+ ", isOverdue=" + isOverdue + ", importTime=" + importTime + ", updateTime=" + updateTime + ", status="
				+ status + "]";
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 设置用户ID
	 * </ul>
	 * @param userID 用户ID
	 */
	public void setUserID(String userID) {
		this.userID = userID;
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 设置游戏编号
	 * </ul>
	 * @param gameID 游戏编号
	 */
	public void setGameID(Long gameID) {
		this.gameID = gameID;
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 设置类别名称
	 * </ul>
	 * @param name 类别名称
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 设置类别编号
	 * </ul>
	 * @param typeID 类别编号
	 */
	public void setTypeID(Long typeID) {
		this.typeID = typeID;
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 设置最后关卡序号(游戏结束时所在关卡序号)
	 * </ul>
	 * @param currentLevelNO 最后关卡序号(游戏结束时所在关卡序号)
	 */
	public void setCurrentLevelNO(Integer currentLevelNO) {
		this.currentLevelNO = currentLevelNO;
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 设置开始日期
	 * </ul>
	 * @param startTime 开始日期
	 */
	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 设置结束日期
	 * </ul>
	 * @param finishTime 结束日期
	 */
	public void setFinishTime(Timestamp finishTime) {
		this.finishTime = finishTime;
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 设置是否过期(1是2否)
	 * </ul>
	 * @param isOverdue 是否过期(1是2否)
	 */
	public void setIsOverdue(Integer isOverdue) {
		this.isOverdue = isOverdue;
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 设置导入时间
	 * </ul>
	 * @param importTime 导入时间
	 */
	public void setImportTime(Timestamp importTime) {
		this.importTime = importTime;
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取用户ID
	 * </ul>
	 * @return 用户ID
	 */
	public String getUserID(){
		return userID;
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取游戏编号
	 * </ul>
	 * @return 游戏编号
	 */
	public Long getGameID(){
		return gameID;
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取类别名称
	 * </ul>
	 * @return 类别名称
	 */
	public String getName(){
		return name;
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取类别编号
	 * </ul>
	 * @return 类别编号
	 */
	public Long getTypeID(){
		return typeID;
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取最后关卡序号(游戏结束时所在关卡序号)
	 * </ul>
	 * @return 最后关卡序号(游戏结束时所在关卡序号)
	 */
	public Integer getCurrentLevelNO(){
		return currentLevelNO;
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取开始日期
	 * </ul>
	 * @return 开始日期
	 */
	public Timestamp getStartTime(){
		return startTime;
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取结束日期
	 * </ul>
	 * @return 结束日期
	 */
	public Timestamp getFinishTime(){
		return finishTime;
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取是否过期(1是2否)
	 * </ul>
	 * @return 是否过期(1是2否)
	 */
	public Integer getIsOverdue(){
		return isOverdue;
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取导入时间
	 * </ul>
	 * @return 导入时间
	 */
	public Timestamp getImportTime(){
		return importTime;
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 设置更新时间
	 * </ul>
	 * @param updateTime 更新时间
	 */
	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取更新时间
	 * </ul>
	 * @return 更新时间
	 */
	public Timestamp getUpdateTime(){
		return updateTime;
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 设置更新时间<br/>
	 * 返回本对象
	 * </ul>
	 * @param updateTime 更新时间
	 */
	public OverGamePO setUpdateTime2(Timestamp updateTime){
		this.updateTime = updateTime;
		return this;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 设置状态1进行中2已领取3失败结束4待领取5过期未领取6等待开奖
	 * </ul>
	 * @param status 状态1进行中2已领取3失败结束4待领取5过期未领取6等待开奖
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取状态1进行中2已领取3失败结束4待领取5过期未领取6等待开奖
	 * </ul>
	 * @return 状态1进行中2已领取3失败结束4待领取5过期未领取6等待开奖
	 */
	public Integer getStatus(){
		return status;
	}


	
	
}
