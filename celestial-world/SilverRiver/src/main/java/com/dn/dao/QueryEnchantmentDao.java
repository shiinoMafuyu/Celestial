package com.dn.dao;

import java.util.List;

import com.dn.annotation.MyBatisRepository;
import com.dn.entity.Enchantment;

@MyBatisRepository
public interface QueryEnchantmentDao {

	int insert(Enchantment enchantment);
	List<Enchantment> selectByCondition(Enchantment enchantment);
	List<Enchantment> selectByVague(Enchantment enchantment);
	int update(Enchantment enchantment);
	int deleteById(int id);

}

