/**
 * 计算核心类。
 */
$.calculator = {};

/**
 * 初级属性到二级属性的转换map
 */
$.calculator.transMap = {};
$.calculator.resMap = {"li":0,"min":0,"zhi":0,"ti":0,
		"wg":0,"yz":0,"xy":0,"xyDK":0,"zm":0,"zmDK":0,
		"mg":0,"mf":0,"hp":0,"wf":0,"yzDK":0,
		"gg":0,"hg":0,"sg":0,"ag":0,
		"gf":0,"hf":0,"sf":0,"af":0,
		"zz":0,"zmsh":0,"ydsd":0,"mphf":0,
		
		"li_":0,"min_":0,"zhi_":0,"ti_":0,
		"wg_":0,"yz_":0,"xy_":0,"xyDK_":0,"zm_":0,"zmDK_":0,
		"mg_":0,"mf_":0,"hp_":0,"wf_":0,"yzDK_":0,
		"zz_":0,"zmsh_":0,"ydsd_":0,"mphf_":0};

/**
 * @func 调用接口，数据分类，然后调用计算式。
 */
/*$.calculator.adapterHandler = function(){
	var dataArrOriginal = $.calculator.depend.getOrinalData();
	
	var dataArrBuff = $.calculator.depend.getBuffData();
	
	$.calculator.transMap = $.calculator.depend.getTransMap();
	
	//同层复合
	var original = $.calculator.unified(dataArrOriginal);
	
	var buff = $.calculator.unified(dataArrBuff);
	
	//多层叠加
	var finalData = $.calculator.caculateTotal(original,original);
	
};*/

/**
 * @func 把一个json数组中的相同属性统一到一起。
 */
$.calculator.unified = function(jsonArr){
	var ans = $.jsonUtil.deepCopy($.calculator.resMap);
	
	_.each(jsonArr,function(elem){
		for(var key in ans){
			ans[key] = $.calculator.impl.add($.jsonUtil.getFromJson(elem,key,0),$.jsonUtil.getFromJson(ans,key,0));
		}
	});
	return ans;
};

/**
 * @func 计算总和
 */
$.calculator.caculateTotal = function(original,buff){
	var ans = $.jsonUtil.deepCopy($.calculator.resMap);
	
	var p1 = {"li":0,"min":0,"zhi":0,"ti":0};
	
	var p2 = {"wg":0,"yz":0,"xy":0,"xyDK":0,"zm":0,"zmDK":0,
			"mg":0,"mf":0,"hp":0,"wf":0,"yzDK":0,
			"gg":0,"hg":0,"sg":0,"ag":0,
			"gf":0,"hf":0,"sf":0,"af":0,
			"zz":0,"zmsh":0,"ydsd":0,"mphf":0,
			
			"li_":0,"min_":0,"zhi_":0,"ti_":0,
			"wg_":0,"yz_":0,"xy_":0,"xyDK_":0,"zm_":0,"zmDK_":0,
			"mg_":0,"mf_":0,"hp_":0,"wf_":0,"yzDK_":0,
			"zz_":0,"zmsh_":0,"ydsd_":0,"mphf_":0};
	
	//self
	//buff
	//lv1 lv2
	
	//lv1 = (selfLv1 * self_Lv1_ + buffLv1) * (1 + buff_Lv1_)
	for(var key in p1){
		if(key == "min"){
			console.log(p1);
		}
		//妈的 没空给你写递归 就这个地方用 又不是1有10万八千个这种算式 就免了
		var lv1_Arit = "(selfLv1 * (1 + self_Lv1_) + buffLv1) * (1 + buff_Lv1_)";
		var param = {	
						"selfLv1"  : $.jsonUtil.getFromJson(original,key,0),
						"self_Lv1_" : $.jsonUtil.getFromJson(original,key+"_",0),
						"buffLv1"  : $.jsonUtil.getFromJson(buff,key,0),
						"buff_Lv1_" : $.jsonUtil.getFromJson(buff,key+"_",0)
					};
		var total = $.calculator.impl.calArithmetic(lv1_Arit,param);
		ans[key] = total;
	}
	
	//lv2 = ((∑(lv1s * transs) + selfLv2) * self_Lv2_ + buffLv2) * (1 + buff_Lv2_)
	
	//有个问题就是不知道buff后的转换的东西会被原有的xx加成不。==>是的！
	for(var key in p2){
		var transJsonArr = $.calculator.transMap(key);
		var lv1s = [];
		var transs = [];
		_.each(transJsonArr,function(elem,index){
			var arr = $.jsonUtil.jsonToArr(tranJson);
			var key = arr[0],transVal = arr[1];
			lv1s[index] = ans[key];
			transs[index]= [transVal];
		});
		var lv1_Arit = "((∑(lv1s * transs) + selfLv2) * (1 + self_Lv2_) + buffLv2) * (1 + buff_Lv2_)";
		var param = {
				"lv1s" : lv1s,
				"transs" : transs,
				"selfLv2"  : $.jsonUtil.getFromJson(original,key,0),
				"self_Lv2_" : $.jsonUtil.getFromJson(original,key+"_",0),
				"buffLv2"  : $.jsonUtil.getFromJson(buff,key,0),
				"buff_Lv2_" : $.jsonUtil.getFromJson(buff,key+"_",0)
			};
		$.calculator.impl.calComplex(lv1_Arit,param);
	}
	
	console.log(ans);
};





















