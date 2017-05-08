/**
 * 计算核心类。
 * @author wangzg
 * 这个计算过程算式普适的，有闲心的时候，可以把$.calculator_impl.cal2()改为，传入回调函数来的。
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
$.calculator_impl = {};

$.calculator_impl.calAllSigma = function(str,param){
	return $.math.calAllSigma(str,param,$.calculator_impl.impl);
};
/**
 * @func 计算算式(无视长度括号)
 */
$.calculator_impl.calArithmetic = function(str,param){
	return $.math.calArithmetic(str,param,$.calculator_impl.impl);
}



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
$.calculator_impl.cal2 = function(str){
	if(str.indexOf("+") > 0){
		var arr = str.split("+");
		return $.calculator_impl.add(arr[0],arr[1]);
	}else if(str.indexOf("-") >0){
	}else if(str.indexOf("*") >0){
		var arr = str.split("*");
		return $.calculator_impl.mul(arr[0],arr[1]);
	}else if(str.indexOf("/") >0){
	}
	throw("二元字符串有误，或未实现"+str);
};

//注意json里的方法需要先定义后使用！！
$.calculator_impl.impl = {"cal2":$.calculator_impl.cal2};

/**
 * @func 进行属性相加。
 * 如果是 v1=5;v2=6;则返回 11;
 * 如果v1=5~9;v2=6;则放回 11~15;
 * 若果v1=5~9;v2=3~7;则返回 8~16；
 * 
 */
$.calculator_impl.add = function(v1,v2){
	if((v1+"").indexOf("~")>=0 || (v2+"").indexOf("~")>=0){
		var arr1 = $.calculator_impl.transToArr(v1);
		var arr2 = $.calculator_impl.transToArr(v2);
		return (parseFloat(arr1[0])+parseFloat(arr2[0]))+"~"+(parseFloat(arr1[1])+parseFloat(arr2[1]));
	}else{
		return parseFloat(v1)+parseFloat(v2);
	}
};

/**
 * @func 进行相乘。
 */
$.calculator_impl.mul = function(val,mul){
	if((val+"").indexOf("~") >= 0 || (mul+"").indexOf("~") >= 0){
		var arr1 = $.calculator_impl.transToArr(val);
		var arr2 = $.calculator_impl.transToArr(mul);
		return (parseFloat(arr1[0])*parseFloat(arr2[0]))+"~"+(parseFloat(arr1[1])*parseFloat(arr2[1]));
	}else{
		var arr2 = $.calculator_impl.transToArr(mul);
		return parseFloat(val)*arr2[0];
	}
	
};

/**
 * @带"~"的字符转为数字
 * $.calculator_impl.transToArr("5~6")
 * ==>["5","6"]
 */
$.calculator_impl.transToArr = function(param){
	if((param+"").indexOf("~")>=0 )
		return param.split("~");
	else
		return [param,param];
};










