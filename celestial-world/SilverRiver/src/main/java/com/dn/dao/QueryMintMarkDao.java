package com.dn.dao;

import java.util.List;

import com.dn.annotation.MyBatisRepository;
import com.dn.entity.MintMark;

@MyBatisRepository
public interface QueryMintMarkDao {

	int insert(MintMark mintMark);
	List<MintMark> selectByCondition(MintMark mintMark);
	List<MintMark> selectByVague(MintMark mintMark);
	int update(MintMark mintMark);
	int deleteById(int id);

}

