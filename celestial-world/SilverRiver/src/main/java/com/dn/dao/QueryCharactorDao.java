package com.dn.dao;

import java.util.List;

import com.dn.annotation.MyBatisRepository;
import com.dn.entity.Charactor;

@MyBatisRepository
public interface QueryCharactorDao {

	int insert(Charactor charactor);
	List<Charactor> selectByCondition(Charactor charactor);
	List<Charactor> selectByVague(Charactor charactor);
	int update(Charactor charactor);
	int deleteById(int id);

}

