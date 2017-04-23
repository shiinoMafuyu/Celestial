package com.dn.dao;

import java.util.List;

import com.dn.annotation.MyBatisRepository;
import com.dn.entity.Strengthen;

@MyBatisRepository
public interface QueryStrengthenDao {

	int insert(Strengthen strengthen);
	List<Strengthen> selectByCondition(Strengthen strengthen);
	List<Strengthen> selectByVague(Strengthen strengthen);
	int update(Strengthen strengthen);
	int deleteById(int id);

}

