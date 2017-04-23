/**
 *<p>
 *<li>
 *
 *					----wangzg 2017年3月14日22:48:40
 *</li>
 *</p>
 *
 *<b>类说明： 数学处理类。数学抽象层 </b>
 * 目前$.math.calParenthesis()，可直接调用计算字符串。
 *<p>
 *
 *</p>
 */
$.math = {};

/**
 * @func 计算str的全部∑算式。
 * 
 * 
 */
$.math.calAllSigma = function(str,param){
	while(str.indexOf("∑") >=0){
		var index = str.indexOf("∑");
		var arr = $.stringutil.getMatchPairindex(str,index,"(",")");
		var arith = str.substring(index,arr[1]+1);
		
		var realParam = $.math.getRealParam(arith,param);
		
		var resSima = $.math.calSigma(arith,realParam);
		str =str.substring(0,index) + resSima + str.substring(arr[1]+1);
	}
	return str;
};
//js替换多个空格为一个
//var str ="yu  ki   no ye!";
//str = str.replace(/\s{2,}/g, " ");

$.math.getRealParam = function(arith,param){
	var paramNameArr = $.math.getParamNameArr(arith);
	var realParam = {};
	_.each(paramNameArr,function(e){
		realParam[e] = param[e];
	});
	return realParam;
};

$.math.mathSymbol = ['+','-','*','/','∑'];
/**
 * @func 获取参数。
 */
$.math.getParamNameArr = function(str){
	//把所有符号替换为空格
	_.each($.math.mathSymbol,function(e){
		str = $.stringutil.replaceAll(str,e," ");
	});
	//把所有多空格替换为一个
	str = str.replace(/\s{2,}/g, " ");
	return str.split(" ");
};

/**
 * @func 计算形如 ∑(lv1s * transs)的算式。
 * 
 * 里面参数必须为数组长度需一致。
 *  $.math.calSigma("∑(arg0 * arg1 + argx)",{"arg0":[1,2,3],"arg1":[2,3,4],"argx":[3,4,5]})
 *  ==> "32"
 */
$.math.calSigma = function(str,jsonArr){
	var res = 0;
	var length =0;
	for(var key in jsonArr){
		length = jsonArr[key].length;
		break;
	}
	var arit = str.substring(str.indexOf("(")+1,str.lastIndexOf(")"));
	for(var index =0;index < length;index++){
		var applyArit = arit.concat();
		for(var key in jsonArr){
			applyArit = $.stringutil.replaceAll(applyArit,key,jsonArr[key][index]);
		}
		res = $.math.calParenthesis(res+"+" + applyArit);
	}
	return res;
};

/**
 * @func 计算形如 ∑(lv1s * transs)的算式。
 * 
 * 里面参数必须为arg0 arg1 arg2 ...形式且和数组对应。
 *  $.math.calSigma2("∑(arg0 * arg1)",[[1,2],[3,4],[5,6]])
 *  ==> "44"
 */
$.math.calSigma2 = function(str,dataArr){
	var res = 0;
	var arit = str.substring(str.indexOf("(")+1,str.lastIndexOf(")"));
	_.each(dataArr,function(elem){
		var applyArit = arit.concat();
		_.each(elem,function(e,i){
			applyArit = $.stringutil.replaceAll(applyArit,"arg"+i,e);
		});
		res = $.math.calParenthesis(res+"+" + applyArit);
	});
	return res;
};

/**
 * @func 计算带括号的
 * 
 * $.math.calParenthesis("(3+4)*2+3*((2+4/2)+5)")
 * ==> 异常
 * 
 * $.math.calParenthesis("(3+4)*2+3*((2+4*2)+5)")
 * ==> "59"
 * 
 * $.math.calParenthesis("(3~4+4)*2+3*((2+4*2)+5)")
 * ==> "59~61";
 * 
 * 抽象出来了。调用此$.math.calParenthesis方法需要自己实现impl.cal2()方法。
 * 
 * 另，计算前虚去掉算式中的空格。
 * 
 * @param str 需要计算的字符串
 * @param impl 2元计算实现包，实现方法impl.cal2(str) 没有的话调用默认实现(目前是区间加、乘法 不能计算减除)。
 */
$.math.calParenthesis = function(str,impl){
	if($.isNull(impl))
		impl = $.impliment;
	if(str.indexOf("(") >= 0){
		var indexArr = $.stringutil.getCenterIndex(str,"(",")");
		//把最里面不带括号的1个算式拿出来计算，用结果替换掉()和算式。
		var res = $.math.calN(str.substring(indexArr[0]+1,indexArr[1]),impl) ;
		var calNext = str.substring(0,indexArr[0]) + res + str.substring(indexArr[1]+1,str.length);
		return $.math.calParenthesis(calNext , impl);
	}else{
		return $.math.calN(str,impl);
	}
};

/**
 * @func 计算N元 无括号。
 * 
 * $.math.calN("5+6*3/1.5")
 * ==> "41"
 * 
 * $.math.calN("5+6*3")
 * ==> "23"
 * 
 * $.math.calN("5+6*3~4")
 * ==> "23~29"
 * 
 * $.math.calN("3~4+1~2*3~3")
 * ==> "6~10"
 * 
 * 注意：四则运算规则中优先级： 除 > 乘 > 加 = 减
 * 
 * 然后，以后你喜欢可以自定义运算符和顺序。写入配置文件即可。
 */
$.math.calN = function(str,impl){
	if($.isNull)
		impl = {"cal2":$.impliment.cal2};
	str = str + "";
	var indexLighter = str.replace(/-/g, "+").replace(/\*/g, "+").replace(/\//g, "+");
	if(indexLighter.indexOf("+") > 0){
		
		var len =indexLighter.length;
		var index = -1,index1 =-1,index2=-1;
		if(str.indexOf("/") > 0){
			index = str.indexOf("/");
		}
		else if(str.indexOf("*") > 0){
			index = str.indexOf("*");
		}
		else if(str.indexOf("+") > 0){
			index = str.indexOf("+");
		}
		else if(str.indexOf("-") > 0){
			index = str.indexOf("-");
		}
		
		index1 = $.stringutil.indexOfBefore(indexLighter,"+",index);
		index1 = index1 < 0 ? 0:index1+1;
		
		index2 = indexLighter.indexOf("+",index+1);
		index2 = index2 < 0 ? len:index2;
		
		return $.math.calN(str.substring(0,index1) + impl.cal2(str.substring(index1,index2)) + str.substring(index2,len),
				impl);
	}else
		return str;
};

$.impliment = {};

/**
 * @func 计算二元算式
 * 一个普通实现。
 */
$.impliment.cal2 = function(str){
	var paramArr = str.replace(/-/g, "+").replace(/\*/g, "+").replace(/\//g, "+").split("+");
	if(str.indexOf("+") > 0){
		return parseFloat(paramArr[0]) + parseFloat(paramArr[1]);
	}else if(str.indexOf("-") >0){
		return parseFloat(paramArr[0]) - parseFloat(paramArr[1]);
	}else if(str.indexOf("*") >0){
		return parseFloat(paramArr[0]) * parseFloat(paramArr[1]);
	}else if(str.indexOf("/") >0){
		return parseFloat(paramArr[0]) / parseFloat(paramArr[1]);
	}
	throw("二元字符串有误"+str);
};






















