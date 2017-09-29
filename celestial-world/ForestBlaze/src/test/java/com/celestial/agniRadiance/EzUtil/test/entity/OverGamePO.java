/******************************************************************
 * OverGame.java
 * Copyright ${year} by WZG. All Rights Reserved.
 * CreateDate��2017-6-12
 * Author��wanzg
 * Version��1.0.0
 ******************************************************************/

package com.celestial.agniRadiance.EzUtil.test.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * <b>�޸ļ�¼��</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2017-6-15
 * </li>
 * </p>
 * 
 * <b>��˵����</b>
 * <p> 
 * �ѽ�����Ϸ��ѯPO
 * </p>
 */
public class OverGamePO implements Serializable{
	
	/**  */
	private static final long serialVersionUID = 1L;
	
	/** �û�ID */
	private String userID;
	
	/** ��Ϸ��� */
	private Long gameID;

	/** ������� */
	private String name;
	
	/** ����� */
	private Long typeID;

	/** ���ؿ����(��Ϸ����ʱ���ڹؿ����) */
	private Integer currentLevelNO;

	/** ��ʼ���� */
	private Timestamp startTime;
	
	/** �������� */
	private Timestamp finishTime;
	
	/** �Ƿ����(1��2��) */
	private Integer isOverdue;
	
	/** ����ʱ�� */
	private Timestamp importTime;
	
	/** ����ʱ�� */
	private Timestamp updateTime;
	
	/** ״̬ 1������2����ȡ3ʧ�ܽ���4����ȡ5����δ��ȡ6�ȴ����� */
	private Integer status;


	@Override
	public String toString() {
		return "OverGamePO [userID=" + userID + ", gameID=" + gameID + ", name=" + name + ", typeID=" + typeID
				+ ", currentLevelNO=" + currentLevelNO + ", startTime=" + startTime + ", finishTime=" + finishTime
				+ ", isOverdue=" + isOverdue + ", importTime=" + importTime + ", updateTime=" + updateTime + ", status="
				+ status + "]";
	}

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * �����û�ID
	 * </ul>
	 * @param userID �û�ID
	 */
	public void setUserID(String userID) {
		this.userID = userID;
	}

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ������Ϸ���
	 * </ul>
	 * @param gameID ��Ϸ���
	 */
	public void setGameID(Long gameID) {
		this.gameID = gameID;
	}

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * �����������
	 * </ul>
	 * @param name �������
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ���������
	 * </ul>
	 * @param typeID �����
	 */
	public void setTypeID(Long typeID) {
		this.typeID = typeID;
	}

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * �������ؿ����(��Ϸ����ʱ���ڹؿ����)
	 * </ul>
	 * @param currentLevelNO ���ؿ����(��Ϸ����ʱ���ڹؿ����)
	 */
	public void setCurrentLevelNO(Integer currentLevelNO) {
		this.currentLevelNO = currentLevelNO;
	}

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ���ÿ�ʼ����
	 * </ul>
	 * @param startTime ��ʼ����
	 */
	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ���ý�������
	 * </ul>
	 * @param finishTime ��������
	 */
	public void setFinishTime(Timestamp finishTime) {
		this.finishTime = finishTime;
	}

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * �����Ƿ����(1��2��)
	 * </ul>
	 * @param isOverdue �Ƿ����(1��2��)
	 */
	public void setIsOverdue(Integer isOverdue) {
		this.isOverdue = isOverdue;
	}

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ���õ���ʱ��
	 * </ul>
	 * @param importTime ����ʱ��
	 */
	public void setImportTime(Timestamp importTime) {
		this.importTime = importTime;
	}

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ��ȡ�û�ID
	 * </ul>
	 * @return �û�ID
	 */
	public String getUserID(){
		return userID;
	}

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ��ȡ��Ϸ���
	 * </ul>
	 * @return ��Ϸ���
	 */
	public Long getGameID(){
		return gameID;
	}

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ��ȡ�������
	 * </ul>
	 * @return �������
	 */
	public String getName(){
		return name;
	}

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ��ȡ�����
	 * </ul>
	 * @return �����
	 */
	public Long getTypeID(){
		return typeID;
	}

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ��ȡ���ؿ����(��Ϸ����ʱ���ڹؿ����)
	 * </ul>
	 * @return ���ؿ����(��Ϸ����ʱ���ڹؿ����)
	 */
	public Integer getCurrentLevelNO(){
		return currentLevelNO;
	}

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ��ȡ��ʼ����
	 * </ul>
	 * @return ��ʼ����
	 */
	public Timestamp getStartTime(){
		return startTime;
	}

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ��ȡ��������
	 * </ul>
	 * @return ��������
	 */
	public Timestamp getFinishTime(){
		return finishTime;
	}

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ��ȡ�Ƿ����(1��2��)
	 * </ul>
	 * @return �Ƿ����(1��2��)
	 */
	public Integer getIsOverdue(){
		return isOverdue;
	}

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ��ȡ����ʱ��
	 * </ul>
	 * @return ����ʱ��
	 */
	public Timestamp getImportTime(){
		return importTime;
	}

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ���ø���ʱ��
	 * </ul>
	 * @param updateTime ����ʱ��
	 */
	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ��ȡ����ʱ��
	 * </ul>
	 * @return ����ʱ��
	 */
	public Timestamp getUpdateTime(){
		return updateTime;
	}

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ���ø���ʱ��<br/>
	 * ���ر�����
	 * </ul>
	 * @param updateTime ����ʱ��
	 */
	public OverGamePO setUpdateTime2(Timestamp updateTime){
		this.updateTime = updateTime;
		return this;
	}
	
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ����״̬1������2����ȡ3ʧ�ܽ���4����ȡ5����δ��ȡ6�ȴ�����
	 * </ul>
	 * @param status ״̬1������2����ȡ3ʧ�ܽ���4����ȡ5����δ��ȡ6�ȴ�����
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ��ȡ״̬1������2����ȡ3ʧ�ܽ���4����ȡ5����δ��ȡ6�ȴ�����
	 * </ul>
	 * @return ״̬1������2����ȡ3ʧ�ܽ���4����ȡ5����δ��ȡ6�ȴ�����
	 */
	public Integer getStatus(){
		return status;
	}


	
	
}
