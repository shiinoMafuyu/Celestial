/**
 * 对内将内存中的数据转为calculator可以接受的类型。
 * 让calculator只接受一个json数组，进行计算。
 * 屏蔽其他差异。
 */
$.memory_calculator = {};

/**
 * @func 获取装备数据.
 */
$.memory_calculator.getOrinalData = function(){
	var orinalDataArr = [];
	var positionMemory = store.get("positionMemory");
	
	_.each(positionMemory,function(elem){
		var tempArr = [];
		_.each(elem["objs"],function(e){
			tempArr = _.union(tempArr,[e["obj"]]);
		});
		orinalDataArr = _.union(orinalDataArr,tempArr);
	});
	
	return orinalDataArr;
	
};

/**
 * @func 获取buff数据。
 */
$.memory_calculator.getBuffData = function(){
	
};

/**
 * @func 生成初级属性到二级属性的转换对应数据。
 */
$.memory_calculator.getTransMap = function(){
	//遍历数据结构
	//{"wg":[{"li":0.25},{"min":0.75}],.....}
	var d1 = $.field.charactor[0];
	var res = {};
	for(var i in d1){
		if(i.indexOf("_") >0){
			//"li_wg":0.25
			var arr =  i.split("_");
			var keyIn = arr[0];
			var aJson = {};
			aJson[arr[0]] = d1[i];
//									 (res,{"li":0.25},wg)
			$.jsonUtil.addToJsonArr(res,aJson,arr[1]);
			
		}
	}
	return res;
}

















