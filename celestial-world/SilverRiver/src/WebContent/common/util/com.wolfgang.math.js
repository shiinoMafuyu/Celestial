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
 * 依赖：com.wolfgang.toolMethod.js
 */
$.math = {};

/**
 * @func 计算str的全部∑算式。
 * 不支持计算嵌套∑式子。
 * @pram str 要计算的字符串。
 * @pram param 参数
 * @pram impl 没有则默认为普通数学加减乘除运算。
 * 
 */
$.math.calAllSigma = function(str,param,impl){
	while(str.indexOf("∑") >=0){
		var index = str.indexOf("∑");
		var arr = $.stringutil.getMatchPairindex(str,index,"(",")");
		var arith = str.substring(index,arr[1]+1);
		
		var realParam = $.math.getRealParam(arith,param);
		
		var resSima = $.math.calSigma(arith,realParam,impl);
		str =str.substring(0,index) + resSima + str.substring(arr[1]+1);
	}
	return $.math.calArithmetic(str,param,impl);
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

$.math.mathSymbol = ['+','-','*','/','∑','(',')'];
/**
 * @func 获取参数。
 */
$.math.getParamNameArr = function(str){
	//把所有符号替换为空格
	_.each($.math.mathSymbol,function(e){
		str = $.stringutil.replaceAll(str,e," ");
	});
	//把所有多空格替换为一个
	str = str.trim().replace(/\s{2,}/g, " ");
	return str.split(" ");
};

/**
 * @func 计算形如 ∑(lv1s * transs)的算式。
 * 
 * 里面参数必须为数组长度需一致。
 *  $.math.calSigma("∑(arg0 * arg1 + argx)",{"arg0":[1,2,3],"arg1":[2,3,4],"argx":[3,4,5]})
 *  ==> "32"
 *  @param impl 没有默认为普通数学计算
 */
$.math.calSigma = function(str,jsonArr,impl){
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
		res = $.math.calParenthesis(res+"+" + applyArit,impl);
	}
	return res;
};

/**
 * @func 递归计算字符串.
 * 
 * 也可以计算其他的，但是需要自己写cal2()的实现。
 * 
 * 这是一个通用的过程计算方法，凡事有优先级，计算结果能量化的都可以使用此过程。
 * 另：
 * 可以进一步抽象计算过程，根据事物的内含，调整计算顺序和法则。
 * 
 * 过程公式化设置！！！
 * 
 * @param str
 * @param param json参数 用于替换字符串中的。
 * @param impl 计算实现没有则默认普通4则运算
 * 
 */
$.math.calArithmetic = function(str,param,impl){
	for(var p in param){
		str = $.stringutil.replaceAll(str,p,param[p]);
	}
	return $.math.calParenthesis(str,impl);
};



/**
 * @func 计算带括号的
 * 
 * 抽象出来了。调用此$.math.calParenthesis方法需要自己实现impl.cal2()方法。
 * 
 * 另，计算前虚去掉算式中的空格。
 * 
 * @param str 需要计算的字符串
 * @param impl 2元计算实现包，实现方法impl.cal2(str) 没有的话调用默认实现(目前是区间加、乘法 不能计算减除)。
 */
$.math.calParenthesis = function(str,impl){
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
 * 注意：四则运算规则中优先级： 除 > 乘 > 加 = 减
 * 
 * 然后，以后你喜欢可以自定义运算符和顺序。写入配置文件即可。
 */
$.math.calN = function(str,impl){
	impl = $.math.checkCal2(impl);
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

/**
 * @func 检查二元实现是否为空，为空则使用默认值。
 */
$.math.checkCal2 = function(impl){
	if($.isNull(impl))
		impl = {"cal2":$.impliment.cal2};
	return impl;
};

$.impliment = {};

/**
 * @func 计算二元算式
 * 一个普通实现。
 */
$.impliment.cal2 = function(str){
	//去掉所有空格
	str = $.stringutil.replaceAll(str," ","");
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






















