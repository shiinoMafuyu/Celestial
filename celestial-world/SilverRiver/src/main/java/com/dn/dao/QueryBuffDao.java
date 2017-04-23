package com.dn.dao;

import java.util.List;

import com.dn.annotation.MyBatisRepository;
import com.dn.entity.Buff;

@MyBatisRepository
public interface QueryBuffDao {

	int insert(Buff buff);
	List<Buff> selectByCondition(Buff buff);
	List<Buff> selectByVague(Buff buff);
	int update(Buff buff);
	int deleteById(int id);

}

