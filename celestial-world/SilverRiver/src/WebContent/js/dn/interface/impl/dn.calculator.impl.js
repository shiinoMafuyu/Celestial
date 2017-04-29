/**
 * 计算核心类。
 * @author wangzg
 * 这个计算过程算式普适的，有闲心的时候，可以把$.calculator.impl.cal2()改为，传入回调函数来的。
 * 
 * 这样的话，其实算起来，一切事物都能表示为过程！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
 * おまいが！碉堡了！
 * 2017年3月14日17:21:01
 * 
 * 依赖：
 * com.wolfgang.toolMethod.js
 * com.wolfgang.math.js
 * 
 */
$.calculator = {};
$.calculator.impl = {};


$.calculator.impl.calComplex = function(str,param){
	//去掉所有空格
	str = str.replace(/ /g, "");
//	var resSigma = 
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
 * 
 * 
 * $.calculator.impl.calStr("s1 + s2 * (s3 + s4)",{"s1":"1~4","s2":2,"s3":3,"s4":"2~4"})
 * ==> "11~18"
 */
$.calculator.impl.calArithmetic = function(str,param){
	//去掉所有空格
	str = str.replace(/ /g, "");
	for(var p in param){
		str = $.stringutil.replaceAll(str,p,param[p]);
	}
	var impl = {"cal2":$.calculator.impl.cal2};
	return $.math.calParenthesis(str,impl);
};


/**
 * @func 计算二元算式
 * $.math.cal2("78~90+10") 
 * ==> "88~100"
 * $.math.cal2("78~90+10~12")
 * ==> "88~102"
 * 
 * $.math.cal2("2~4*3")
 * ==> "6~12"
 * $.math.cal2("2~4*3~5")
 * ==> "6~20"
 */
$.calculator.impl.cal2 = function(str){
	if(str.indexOf("+") > 0){
		var arr = str.split("+");
		return $.calculator.impl.add(arr[0],arr[1]);
	}else if(str.indexOf("-") >0){
	}else if(str.indexOf("*") >0){
		var arr = str.split("*");
		return $.calculator.impl.mul(arr[0],arr[1]);
	}else if(str.indexOf("/") >0){
	}
	throw("二元字符串有误，或未实现"+str);
};

/**
 * @func 进行属性相加。
 * 如果是 v1=5;v2=6;则返回 11;
 * 如果v1=5~9;v2=6;则放回 11~15;
 * 若果v1=5~9;v2=3~7;则返回 8~16；
 * 
 */
$.calculator.impl.add = function(v1,v2){
	if((v1+"").indexOf("~")>=0 || (v2+"").indexOf("~")>=0){
		var arr1 = $.calculator.impl.transToArr(v1);
		var arr2 = $.calculator.impl.transToArr(v2);
		return (parseFloat(arr1[0])+parseFloat(arr2[0]))+"~"+(parseFloat(arr1[1])+parseFloat(arr2[1]));
	}else{
		return parseFloat(v1)+parseFloat(v2);
	}
};

/**
 * @func 进行相乘。
 */
$.calculator.impl.mul = function(val,mul){
	if((val+"").indexOf("~") >= 0 || (mul+"").indexOf("~") >= 0){
		var arr1 = $.calculator.impl.transToArr(val);
		var arr2 = $.calculator.impl.transToArr(mul);
		return (parseFloat(arr1[0])*parseFloat(arr2[0]))+"~"+(parseFloat(arr1[1])*parseFloat(arr2[1]));
	}else{
		var arr2 = $.calculator.impl.transToArr(mul);
		return parseFloat(val)*arr2[0];
	}
	
};
/**
 * @带"~"的字符转为数字
 * $.calculator.impl.transToArr("5~6")
 * ==>["5","6"]
 */
$.calculator.impl.transToArr = function(param){
	if((param+"").indexOf("~")>=0 )
		return param.split("~");
	else
		return [param,param];
};











