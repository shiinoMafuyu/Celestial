package com.dn.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.celestial.agniRadiance.EzUtil.UtilCollection;
import com.celestial.agniRadiance.EzUtil.UtilJson;
import com.dn.dao.QueryBuffDao;
import com.dn.dao.QueryCharactorDao;
import com.dn.dao.QueryDragonJadeDao;
import com.dn.dao.QueryEnchantmentDao;
import com.dn.dao.QueryEquipmentDao;
import com.dn.dao.QueryMintMarkDao;
import com.dn.dao.QueryStrengthenDao;
import com.dn.entity.Buff;
import com.dn.entity.Charactor;
import com.dn.entity.DragonJade;
import com.dn.entity.Enchantment;
import com.dn.entity.Equipment;
import com.dn.entity.MintMark;
import com.dn.entity.Strengthen;
import com.dn.process.Result;

@Controller
@RequestMapping("")
public class MainController {
	
	@Resource(name = "queryBuffDao")
	private QueryBuffDao queryBuffDao;

	@Resource(name = "queryCharactorDao")
	private QueryCharactorDao queryCharactorDao;
	
	@Resource(name = "queryDragonJadeDao")
	private QueryDragonJadeDao queryDragonJadeDao;
	
	@Resource(name = "queryEnchantmentDao")
	private QueryEnchantmentDao queryEnchantmentDao;
	
	@Resource(name = "queryEquipmentDao")
	private QueryEquipmentDao queryEquipmentDao;
	
	@Resource(name = "queryMintMarkDao")
	private QueryMintMarkDao queryMintMarkDao;
	
	@Resource(name = "queryStrengthenDao")
	private QueryStrengthenDao queryStrengthenDao;
	
	
	
	
	/*@RequestMapping("hear.action")
	public String showHear(){
		return "hear.html";
	}*/
	
	/*@RequestMapping("hear.action")
	public String showHear(@RequestParam("id") int id){
		System.out.println("id:"+id);
		return "hear.html";
	}*/
	
	/*@RequestMapping("test.action")
	@ResponseBody
	public Result queryEquipmentTest(){
		List<Equipment> data = queryEquipmentDao.selectByCondition(new Equipment());
		
		Map<String, List<Equipment>> m = new HashMap<String, List<Equipment>>();
		
		for(Equipment ei : data){
			Util_Collection.put(m,ei.getRepresentId(),ei);
		}
		Result res = new Result("获取数据成功.", 0, m);
		return res;
	}*/
	
	//127.0.0.1:8080/SilverRiver/all.action
	@RequestMapping("all.action")
	@ResponseBody
	public Result queryAll(){
		
		List<Buff> buff = queryBuffDao.selectByCondition(new Buff());
		List<Charactor> charactor = queryCharactorDao.selectByCondition(new Charactor());
		List<DragonJade> dragonJade = queryDragonJadeDao.selectByCondition(new DragonJade());
		List<Enchantment> enchantment = queryEnchantmentDao.selectByCondition(new Enchantment());
		
		List<Equipment> equipment = queryEquipmentDao.selectByCondition(new Equipment());
		List<MintMark> mintMark = queryMintMarkDao.selectByCondition(new MintMark());
		List<Strengthen> strengthen = queryStrengthenDao.selectByCondition(new Strengthen());
		
		
		
		Map<String,Object> data = new HashMap<String, Object>();
		data.put("buff", buff);
		data.put("charactor",charactor );
		data.put("dragonJade",dragonJade );
		data.put("enchantment", enchantment);
		
		data.put("equipment", equipment);
		data.put("mintMark", mintMark);
		data.put("strengthen", strengthen);
		
		
		Result res = new Result("获取数据成功.", 0, data);
		return res;
	}
	
	
	@RequestMapping("equipment.action")
	@ResponseBody
	public Result queryEquipment(){
		List<Equipment> data = queryEquipmentDao.selectByCondition(new Equipment());
		Result res = new Result("获取数据成功.", 0, data);
		return res;
	}
	
	@RequestMapping(value = "equipmentPa.action" ,produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String queryEquipmentPa(){
		List<Equipment> data = queryEquipmentDao.selectByCondition(new Equipment());
		Map<String, List<Equipment>> m = new HashMap<String, List<Equipment>>();
		
		for(Equipment ei : data){
			UtilCollection.put2MapList(m,ei.getRepresentId(),ei);
		}
		
		String res = "{\"message\":\"获取数据成功.\",\"retcode\":0,\"data\":arg_data}";
		return res.replaceAll("arg_data", UtilJson.toJsonStringMap(m));
	}
	

	@RequestMapping("buff.action")
	@ResponseBody
	public Result queryBuff(){
		List<Buff> data = queryBuffDao.selectByCondition(new Buff());
		Result res = new Result("获取数据成功.", 0, data);
		return res;
	}
	
	@RequestMapping("charactor.action")
	@ResponseBody
	public Result queryCharactor(){
		List<Charactor> data = queryCharactorDao.selectByCondition(new Charactor());
		Result res = new Result("获取数据成功.", 0, data);
		return res;
	}
	
	@RequestMapping("dragonJade.action")
	@ResponseBody
	public Result queryDragonJade(){
		List<DragonJade> data = queryDragonJadeDao.selectByCondition(new DragonJade());
		Result res = new Result("获取数据成功.", 0, data);
		return res;
	}
	
	@RequestMapping("enchantment.action")
	@ResponseBody
	public Result queryEnchantment(){
		List<Enchantment> data = queryEnchantmentDao.selectByCondition(new Enchantment());
		Result res = new Result("获取数据成功.", 0, data);
		return res;
	}
	
	@RequestMapping("mintMark.action")
	@ResponseBody
	public Result queryMintMark(){
		List<MintMark> data = queryMintMarkDao.selectByCondition(new MintMark());
		Result res = new Result("获取数据成功.", 0, data);
		return res;
	}
	
	@RequestMapping("strengthen.action")
	@ResponseBody
	public Result queryStrengthen(){
		List<Strengthen> data = queryStrengthenDao.selectByCondition(new Strengthen());
		Result res = new Result("获取数据成功.", 0, data);
		return res;
	}
	
	
	
	
	
}
