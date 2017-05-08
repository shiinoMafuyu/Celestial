/**
 * 对内将内存中的数据转为calculator可以接受的类型。
 * 让calculator只接受一个json数组，进行计算。
 * 屏蔽其他差异。
 */
$.calculator_depend = {};

//外部调用接口-------------------------------------------------------------------------------------

/**
 * @func 获取装备数据.
 */
$.calculator_depend.getOrinalData = function(){
	var positionMemory = store.get("positionMemory");
	return $.calculator_depend.getOrinalData_impl(positionMemory);
	
};

/**
 * @func 获取buff数据。
 */
$.calculator_depend.getBuffData = function(){
	
};

/**
 * @func 生成初级属性到二级属性的转换对应数据。
 * @param 角色json数据。 
 */
$.calculator_depend.getTransMap = function(character){
	var character = $.field.charactor[0];
	return $.calculator_depend.getTransMap_impl(character);
}


//内部实现，最好不从外部调用这些方法-------------------------------------------------------------------------------------

$.calculator_depend.getOrinalData_impl = function(positionMemory){
	var orinalDataArr = [];
	_.each(positionMemory,function(elem){
		var tempArr = [];
		_.each(elem["objs"],function(e){
			tempArr = _.union(tempArr,[e["obj"]]);
		});
		orinalDataArr = _.union(orinalDataArr,tempArr);
	});
	return orinalDataArr;
};


$.calculator_depend.getTransMap_impl = function(character){
	//遍历数据结构
	//{"wg":[{"li":0.25},{"min":0.75}],.....}
	var res = {};
	for(var i in character){
		if(i.indexOf("_") >0){
			//"li_wg":0.25
			var arr =  i.split("_");
			var keyIn = arr[0];
			var aJson = {};
			aJson[arr[0]] = character[i];
//									 (res,{"li":0.25},wg)
			$.jsonUtil.addToJsonArr(res,aJson,arr[1]);
			
		}
	}
	return res;
};










