package com.dn.dao;

import java.util.List;

import com.dn.annotation.MyBatisRepository;
import com.dn.entity.DragonJade;

@MyBatisRepository
public interface QueryDragonJadeDao {

	int insert(DragonJade dragonJade);
	List<DragonJade> selectByCondition(DragonJade dragonJade);
	List<DragonJade> selectByVague(DragonJade dragonJade);
	int update(DragonJade dragonJade);
	int deleteById(int id);

}

