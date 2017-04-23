package com.dn.dao;

import java.util.List;

import com.dn.annotation.MyBatisRepository;
import com.dn.entity.Equipment;

@MyBatisRepository
public interface QueryEquipmentDao {

	int insert(Equipment equipment);
	List<Equipment> selectByCondition(Equipment equipment);
	List<Equipment> selectByVague(Equipment equipment);
	int update(Equipment equipment);
	int deleteById(int id);

}

