/**
 * 系统框架功能类。
 */
$.frame ={};

/**
 * @func 查询数据。
 */
$.frame.queryEQ = function(queryInfo,calllback){
	$.http.sendXmlReq(queryInfo,function(data){
		store.set("equipment",data.data);
		if(!$.isNull(calllback))
			calllback();
	},"http://localhost:8080/DN/query.action");
};

/**
 * 装备数据拆分。
 */
$.frame.separateData = function(jsonArr){
	//将装备数据按representId分类
	var tempContainer = $.jsonUtil.separateData(jsonArr,"representId");
	//缓存中数据进行整合。
	var combineData = $.jsonUtil.combineJsonArr(store.get("equipment"),tempContainer,"id");
	store.set("equipment",combineData);
};

