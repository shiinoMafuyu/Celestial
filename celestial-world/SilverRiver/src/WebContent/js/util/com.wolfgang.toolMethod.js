/**
 *<p>
 *<li>
 *
 *					----wangzg 2016-12-01
 *</li>
 *</p>
 *
 *<b>类说明： 工具类,日期转换 数字处理等 </b>
 *<p>
 *
 *</p>
 * 依赖：
 * 基础包。(jQuery,underscore,..)
 * 
 */
(function ($) {
	
	$.toolMethod = {};
	$.toolMethod.pageName = "";
	
	/**
     * 需要加载时绑定的工具方法的绑定.
     */
    $(function(){
    	//给input[date]绑定解决html不支持日期placeholder的方法.
    	//<input class="form-control input-date float-left login-content-input bill-register-date" type="date" style="height:25px;" placeVal="&nbsp;&nbsp;&nbsp;请选提货择日期" placeholder="&nbsp;&nbsp;&nbsp;请选提货择日期">
		$(".input-date").attr("onchange","$.dateUtil.usePlaceholder(this)");
		
		//当前页面名字
		$.toolMethod.pageName = $.pageUtil.getPageName();
		
	});
	
    
	/**
	 * @func 日期工具主类
	 */
	$.dateUtil = {};
	
	/**
	 * @func 获取今天时间的yyyy-MM-dd格式
	 */
	$.dateUtil.getNowFormatDate = function() {
        var date = new Date();
        var seperator1 = "-";
        var year = date.getFullYear();
        var month = date.getMonth() + 1;
        var strDate = date.getDate();
        if (month >= 1 && month <= 9) {
            month = "0" + month;
        }
        if (strDate >= 0 && strDate <= 9) {
            strDate = "0" + strDate;
        }
        var currentdate = year + seperator1 + month + seperator1 + strDate;
        return currentdate;
    };
	
    /**
	 * @func 从yyyy-MM-dd hh:mm:ss格式字符串获取一个日期类型(也可以为 yyyy-MM-dd 时分秒补0)
	 */
    $.dateUtil.getDateFromStr = function(strDate){
    	/*new Date(strDate.replace(/-/,"/"));
    	safari浏览器不支持这种写法new Date()*/
    	var date = "";
    	try{
    		var arr = strDate.split(/[- : \/]/);
    		if(arr.length >= 3 && arr.length <6){
    			for(var i = arr.length;i<=6;i++){
    				arr[i] = 0;
    			}
        	}
        	date = new Date(arr[0], arr[1]-1, arr[2], arr[3], arr[4], arr[5]);
        	if(date == "Invalid Date")
        		date = "";
    	}catch(e){
    		var date = "";
    	}
    	return  date;
    };
    
    
    /**
     * @func 日期输入框改变后,改变里面的placeholder.(现在html5不支持日期类型的replaceholder)
     * 给元素input[date]绑定值改变事件.
     * @param elem 要改绑定的日期输入框 (传入inputp[date])
     */
    $.dateUtil.usePlaceholder = function(elem){
    	var placeText = '&nbsp;&nbsp;&nbsp;请选择日期';
    	var placeVal = $(elem).attr("placeVal");
    	if(!$.isNull(placeVal))
			placeText = placeVal;
    	
    	var inputVal = $(elem).val();
    	if(parseInt(inputVal) !== 0 && $.isNull(inputVal)){//前面那段排除
    		$(elem).attr('placeholder',placeText);
    	}else{
    		$(elem).removeAttr('placeholder');
    	}
    	
    };
    
    /**
	 * @func 格式化日期.没有pattern的话,默认yyyy-MM-dd hh:mm:ss形式.
	 */
    $.dateUtil.formateDate = function(date,pattern){
    	var p = "yyyy-MM-dd hh:mm:ss";
    	if(!$.isNull(pattern))
    		p = pattern;
    	var dateStr = "";
    	try{
    		dateStr = p.replace("yyyy", date.getUTCFullYear())
    				   .replace("MM",$.numUtil.addZeroBefore(date.getMonth()+1,2))
    				   .replace("dd",$.numUtil.addZeroBefore(date.getDate(),2))
    				   .replace("hh",$.numUtil.addZeroBefore(date.getHours(),2))
    				   .replace("mm",$.numUtil.addZeroBefore(date.getMinutes(),2))
    				   .replace("ss",$.numUtil.addZeroBefore(date.getSeconds(),2));
    	}catch(e){
    		dateStr = '1970-01-01 00:00:00';
    	}
    	return dateStr;
    };
    
    /**
	 * @func 判断日期d1是否在d2之后.如 d1= 2016-12-26,d2 = 2016-12-25返回true;
	 * @param d1 日期1
	 * @param d2 日期2
	 * @param defaultVal 比较发生异常时返回的值
	 */
    $.dateUtil.late = function(d1,d2,defaultVal){
    	var res = "";
    	try{
    		if(d1.getTime() - d2.getTime() >= 0)
    			res = true;
    		else
    			res = false;
    	}catch(e){
    		if($.isNull(defaultVal))
    			res = defaultVal;
    	}
    	return res;
    };
    
    /**
	 * @func 判断日期d1是否在d2之后(d1 d2 为字符日期).如 d1= 2016-12-26,d2 = 2016-12-25返回true;
	 * @param d1 字符日期1
	 * @param d2 字符日期2
	 * @param defaultVal 比较发生异常时返回的值
	 */
    $.dateUtil.lateStr = function(d1,d2,defaultVal){
    	var date1 = $.dateUtil.getDateFromStr(d1);
    	var date2 = $.dateUtil.getDateFromStr(d2);
    	return $.dateUtil.late(date1,date2,defaultVal);
    };
    
    /**
     * @func 获取date的n天前,n天后的时间(为正表示n天后为负表示n天前),时分秒默认为date的,需要自定义用hh,mm,ss设置.
     * @param 
     * @param n天数
     * @param hh,mm,ss 时分秒设置
     */
    $.dateUtil.getNDaysAgo = function(date,n,hh,mm,ss){
    	var d = new Date(date.getTime() + n*24*60*60*1000);
    	if($.isNum(hh)){
    		d.setHours(hh);
    	}
		if($.isNum(mm)){
		    d.setMinutes(mm);
		}
		if($.isNum(ss)){
			d.setSeconds(ss);
		}
		return d;
    };
    
    /**
     * @func 传入日期,如果屏幕较小的话,把带年月日时分秒的详细时间转为显示日月-时分的简写试.
     * 
     */
    $.dateUtil.dealDetailTime = function(time){
    	var dealTime = "";
		if($.screenUtil.isSmallWidht()){
			var theTime = $.dateUtil.getDateFromStr(time);
			dealTime = $.dateUtil.formateDate(theTime,"MM-dd hh:mm");
		}
		return dealTime;
    };
    
    /**---------------------------------------------------------------------------------------------------*/
    
    /**
	 * @func 数字工具主类
	 */
    $.numUtil = {};
    
	/**
	 * @func 把数字转为格式化显示
	 */
	$.numUtil.formatNum = function(num,precision){
		var res ="0.00";
		try{
			num = $.deNull(num);
			if(""==num)
				num=0;
			num = parseFloat(num);
			if(precision>=0){
				res = num.toFixed(precision);
			}else{
				var p = Math.pow(10,-precision);
				res = parseInt(num/p)*p;
				res =res.toFixed(0);
			}
		}catch(e){}
		return res;
	};
    
	/**
	 * @func 如果数字长度不够多少位就在前面加0,变成那么多位.
	 */
	$.numUtil.addZeroBefore = function(num,length){
		var numstr = "" + num;
		try{
			var len = length -numstr.length;
			var zero = "";
			if(len >= 1){
				for(var i=0;i<len;i++)
					zero += "0";
				numstr = zero + numstr;
			}
		}catch(e){}
		return numstr;
	}
	
	/**
	 * @func 产生一个>=min && <= max的随机值.
	 */
	$.numUtil.range = function(min,max) {
		return min+Math.floor(Math.random()*(max-min+1));
	}
	
	
	
	
	/**screenUtil----------------------------------------------------------------------------------------------------*/
	/**
	 * @func 屏幕工具主类
	 */
	$.screenUtil = {};
	
	$.screenUtil.isSmallWidht = function(){
		return screen.availWidth < $.field.screenInterval['w2'];
	};
	
	/**arrayUtil----------------------------------------------------------------------------------------------------*/
	
	/**
	 * 数组工具类
	 */
	$.arrayUtil = {};
	
	/**
	 * @func 将数组arr进行随机排序
	 */
	$.arrayUtil.randomRangeArr = function(arr){
		var len = arr.length;
		var reArr = new Array(len);
		for(var i=0;i<len;i++){
			reArr[i] = arr[i];
		}
		for ( var i = 0; i < len; i++) {
			index = $.numUtil.range(i, len - 1);
			temp = reArr[i];
			reArr[i] = reArr[index];
			reArr[index] = temp;
		}
		return reArr;
	};
    
	/**toolUtil----------------------------------------------------------------------------------------------------*/
	
	/**
	 * @func 工具主类
	 */
	$.toolUtil = {};
	
	
	/**
	 * @func 判断container元素下面是不是空的(无数据)
	 * 无数据包括:
	 * 	1.空字符串 "";
	 * 	2.全为空格"  ";
	 * 	3.注意不包括为0的情况!
	 */
	$.toolUtil.noHtml = function(elem){
		var contentVal = $(elem).html();
		while(contentVal.indexOf(" ") == 0){
			contentVal = contentVal.replace(" ","");
		}
		if($.isNull(contentVal) && contentVal !== '0')
			return true;
		else
			return false;
			
	};
	
	/**
	 * @func 生成提示信息.beautiful Alert的html提示。
	 */
	$.toolUtil.createRemindInfo = function(jsonInfo){
		if($.isNull(jsonInfo))
			jsonInfo = JSON.parse($(".remindText").html());
		var info = '<table align="center"><tbody>';
		var infoEnd = '</tbody></table>';
		var aInfo = '<tr><td>re_key  :</td><td>re_val</td></tr>';
		for(var infoKey in jsonInfo){
			info += aInfo.replace("re_key",infoKey).replace("re_val",jsonInfo[infoKey]);
		}
		info += infoEnd;
		return info;
	};
	
	/**pageUtil----------------------------------------------------------------------------------------------------*/
	$.pageUtil = {};
	
	/**
	 * @func 获取返回页面，如果地址栏有from参数则返回from所指网页，否则返回默认页面。
	 * @param 默认返回页面。
	 * 
	 */
	$.pageUtil.getFromPage = function(defualtPage){
		var fromPage = defualtPage;
		var from = $.queryArgs("from");
		if(!$.isNull(from))
			fromPage = from;
		return fromPage;
	};
	
	/**
	 * @func 获取当前页面名称。
	 */
	$.pageUtil.getPageName = function pageName(){
        var strUrl=location.href;
        var arrUrl=strUrl.split("/");
        var strPage=arrUrl[arrUrl.length-1];
        return strPage;
    };
    
    
    /**htmlUtil----------------------------------------------------------------------------------------------------*/
    
    $.htmlUtil = {};
    
    /**
     * @func 传入json数组，生成option串。keyName指定用于生成显示的字段;valueName指定用于value的字段。
     * 输入：
     * ([{"name":"shiino","age":998,"favo":"琉璃仙"},{"name":"yukino","age":233,"favo":"朱诗瑶"}],name,favo);
     * 输出：
     * <option value='琉璃仙'>shiino</option>
     * <option value='朱诗瑶'>yukino</option>
     * jsonArr json数组
     * keyName option显示
     * valueName option值
     */
    $.htmlUtil.createOption = function(jsonArr,keyName,valueName){
    	var optionList = "";
    	_.each(jsonArr,function(elem){
    		optionList += "<option value='"+elem[valueName]+"'>"+elem[keyName]+"</option>";
    	});
    	return optionList;
    };
    
    /**
     * @func 用于生成select元素，
     * @param attrStr select属性
     * @param jsonArr json数组数据
     * @param keyName 指定option显示的
     * @param valueName 指定option的value
     * @param preSetOption 要预先添加到前面的<option>--请选择--</option>之类的。
     */
    $.htmlUtil.createSelect = function(attrStr,jsonArr,keyName,valueName,preSetOption){
    	var select ="<select "+attrStr+">"+preSetOption+"optionList</select></div>";
    	var optionList = $.htmlUtil.createOption(jsonArr,keyName,valueName);
    	return select.replace("optionList", optionList);
    };
    
	/**
	 * @func 查找elem的子元素中的selector所指元素，如果没有则从更上一层找，递归进行。
	 * @param elem 基准元素，从它开始一直往上查询。
	 * @param selector 选择器
	 * @param attr 要查询包含当前元素的话加上后两个属性。
	 * @param containWords
	 */
	$.htmlUtil.findContainer = function(elem,selector,attr,containWords){
		var theElem = null;
		try{
			theElem = $(elem).find(selector);
			if(!$.isNull(attr) && !$.isNull(containWords)){
				if($(elem).attr(attr).indexOf(containWords) >=0)
				theElem = elem;
			}
		}catch(e){}
		if($.isNull(theElem) || $(theElem).length ==0){
			return $.htmlUtil.findContainer($(elem).parent(),selector,attr,containWords);
		}else{
			return theElem;
		}
	};
    
    
    
    /**httpUtil----------------------------------------------------------------------------------------------------*/
    $.http = {};
    
    $.http.sendXmlReq = function(json,callback,url,errorback){
    	$.ajax({
    		url:url,
    		type:'post',
    		data: json,
    		dataType:'json',
    		success:callback,
    		contentType: "application/x-www-form-urlencoded; charset=utf-8", 
    		error:errorback
    	});
    };
    
    
    
    /**----------------------------------------------------------------------------------------------------*/
    /**
     * @func 判断是否为空;
     */
    $.isNull = function (arg){
    	if(arg != null && typeof(arg) != "undefined" && arg !== "" ){
    		return false;
    	} else {
    		return true;
    	}
    };
    
	/**
	 * @func 判断传入参数是否为数字,空字符串不算.
	 * @param number 要判断的数字
	 */
	$.isNum = function(number){
		if(typeof(number) === "undefined")
			return false;
		if(null === number)
			return false;
		if("" === number)
			return false;
		else
			return !isNaN(number);
	};
    
    /**jsonUtil----------------------------------------------------------------------------------------------------*/
    
    $.jsonUtil = {};
    
    /**
     * @func 把data放入key对应的jsonArr中的数组中，没有则创建一个。
     */
    //$.jsonUtil.addToJsonArr({"a":[{"b":"bv"}],"a1":[{"b1":"b1v"}]},{"b2":"b2v"},"a")
    $.jsonUtil.addToJsonArr = function(jsonMapArr,data,key){
    	var jsonArr = jsonMapArr[key];
    	if($.isNull(jsonArr))
    		jsonArr = [];
    	jsonArr = _.union(jsonArr,[data]);
    	jsonMapArr[key] = jsonArr;
    	return jsonMapArr;
    };
    
    
    
    /**
     * @func json串里一个key对应一个json数组。
     * 找到data的(key,value) 把data放到jsonMapArr里value对应的json数组中，没有则创建一个。
     * 主要用于根据data数据的key字段为data进行分类。
     * 
     * 这个实际上是用来：根据data的key所对value,将其进行分类的！
     * @param jsonMapArr 要放入的数组{"value":[..,..]}数组
     * @param data json数据
     * @param key data的某个key
     */
    //test: $.jsonUtil.addToJson({"qaq":[{"key":"qaq"}]},{"key":"qaq","name":"234"},"key")
    $.jsonUtil.addToJson = function(jsonMapArr,data,key){
    	var jsonArrKey = data[key];
    	var arr = jsonMapArr[jsonArrKey];
    	if($.isNull(arr))
    		arr = [];
    	var combineData = _.union(arr,[data]);
    	
    	jsonMapArr[jsonArrKey] = combineData;
    	return jsonMapArr;
    };
    
    /**
     * @func 把jsonArr里的json数据按照divideKey指定的字段分类。
     * jsonArr格式示例： ["A":[{"level":"A"},{"level":"A","name":"heitagi"},{"level":A,"from":"remote"}],"B":[{"level":"B"}]
     */
    //test: $.jsonUtil.separateData($.field.equipment.data)
    $.jsonUtil.separateData = function(jsonArr,divideKey){
    	var tempContainer = {};
    	_.each(jsonArr,function(elem){
    		$.jsonUtil.addToJson(tempContainer,elem,divideKey);
    	});
    	return tempContainer;
    };
    
    /**
     * @func 将两个jsonArr json数组合并。
     * @param representWord 一个json对象的代表字段，相同的排除掉。
     */
    //test: 
	//    var f = {"kimi":[{"name":"kimi"},{"name":"kimi","race":"human"}],"yuki":[{"name":"yuki"}]};
	//    var f1 = {"yuki":[{"name":"yuki"}],"miki":[{"name":"miki"}]};
	//    $.jsonUtil.combineJsonArr(f,f1);
    $.jsonUtil.combineJsonArr = function(jsonArr1,jsonArr2,representWord){
    	if($.isNull(jsonArr1))
    		jsonArr1={};
    	if($.isNull(jsonArr2))
    		jsonArr2={};
    	for(var i in jsonArr2){
    		if($.isNull(jsonArr1[i]))
    			jsonArr1[i] = jsonArr2[i];
    		else{
    			var tempArr = _.union(jsonArr1[i],jsonArr2[i]);
    			if(!$.isNull(representWord)){
    				jsonArr1[i] = _.uniq(tempArr,false,function(elem){
        				return elem[representWord];
        			});
    			}else{
    				jsonArr1[i] = _.uniq(tempArr);
    			}
    			
    		}
    	}
    	return jsonArr1;
    };
    
    /**
     * @func 从json里获取一个值，没有的话返回默认值。
     * 没有默认值返回空字符串。
     */
    $.jsonUtil.getFromJson = function(json,key,defaultVal){
    	var value = json[key];
    	if(typeof(value) == "undefined"){
    		if(!$.isNull(defaultVal))
    			return defaultVal;
    		else
    			return "";
    	}
    	return value;
    };
    
    /**
     * @func 深度克隆一个json对象。
     */
    $.jsonUtil.deepCopy = function(json){
    	var result = {};
    	for(var i in json){
    		result[i] = json[i];
    	}
    	return result;
    };
    
    /**
     * @func 获取json的key value。数组
     * 如
     * $.jsonUtil.getKey({"a":"av","b":"bv"})===>
     * [["a","av"],["b","bv"]]
     */
    $.jsonUtil.jsonToArr = function(json){
    	var arr = [];
    	var i =0;
    	for(var key in json){
    		arr[i] = [key,json[key]];
    		i++;
    	}
    	return arr;
    }
    
    /**
     * @func 把json转为字符串。
     * 常见的有两种。
     * toJSONString()
     * JSON.stringify()
     */
    $.jsonUtil.toJsonString = function(json){
    	return JSON.stringify(json);
    };
    
    
    /**stringutil----------------------------------------------------------------------------------------------------*/
    $.stringutil = {};
    /**
     * @func 从str中取出字符s1、s2中间的内容。
     * @param str 从中取字符串的原字符串
     * @param s1 开始字符串
     * @param s2 结束字符串 不填的话开始结束用同一个
     * 
     */
    $.stringutil.getStringBetween = function(str,s1,s2){
    	var index1 = str.index(s1);
    	if($.isNull(s2))
    		s2 = s1;
    	var index2 = str.index(s2,index1);
    	if(index1 >=0 && index2 > index1)
    		return str.substring(index1+1,index2);
    	else
    		return "";
    };
    /**
     * @func 从str中找到index前面一个的findStr字符串。
     * $.stringutil.indexOfBefore("yukinuo","u",2)
     * ==> 1
     */
    $.stringutil.indexOfBefore = function(str,findStr,index){
    	var s = str.substring(0,index);
    	return s.indexOf(findStr);
    };
    
    /**
     * @func 将str中的全部rep替换为weth。
     * $.stringutil.replaceAll(" io oi ok!"," ","+")
     * ==> "+io+oi+ok!"
     */
    $.stringutil.replaceAll = function(str,rep,weth){
    	while(str.indexOf(rep) >= 0){
    		str = str.replace(rep,weth);
    	}
    	return str;
    };
    
    /**
     * @func 获取最中间的s1,s2的坐标。
       var s = "(3+(2+3*(3-2)*2))";
       var arr = $.stringutil.getCenterIndex(s,"(",")");
       s.substring(arr[0],arr[1]+1);
     * ==> (3-2) 开始结尾的index.
     * 
     */
    $.stringutil.getCenterIndex = function(str,s1,s2){
    	var index1 = str.indexOf(s1),index2 = -1;
    	for(var i = index1+1;i<str.length;i++){
    		if(s1 === str[i])
    			index1 = i;
    		else if(s2 === str[i]){
    			index2 = i;
    			break;
    		}
    	}
    	if(index1 >=0 && index2>=0)
    		return [index1,index2];
    	else
    		throw(str+"中无法找到配对"+s1+","+s2);
    };
    
    /**
     * @func 找到配对index之后配对符号m1,m2之间的内容.
     * $.stringutil.getMatchPair("8+(3*2+(4/2))",1,"(",")");
     * ==> "3*2+(4/2)"
     */
    $.stringutil.getMatchPair = function(str,index,m1,m2){
    	var str2 = str.substring(index);
    	var index1 = -1,index2 = -1;
    	var count = 0;
    	for(var i =0;i<str2.length;i++){
    		if(str2[i] === m1){
    			if(count == 0){
    				index1 = i;
    			}
    			count++;
    		}
    		else if(str2[i] === m2){
    			count--;
    			if(count == 0){
    				index2 = i;
    				break;
    			}
    		}
    	}
    	return str2.substring(index1+1,index2);
    };
    
    /**
     * @func 找到index之后配对符号m1,m2的位置.
     * $.stringutil.getMatchPairindex("8+(3*2+(4/2))",1,"(",")");
     * ==> [2,12]
     */
    $.stringutil.getMatchPairindex = function(str,index,m1,m2){
    	var index1 = -1,index2 = -1;
    	var count = 0;
    	for(var i = index+1;i<str.length;i++){
    		if(str[i] === m1){
    			if(count == 0){
    				index1 = i;
    			}
    			count++;
    		}
    		else if(str[i] === m2){
    			count--;
    			if(count == 0){
    				index2 = i;
    				break;
    			}
    		}
    	}
    	return [index1,index2];
    };
    
	
})(jQuery);	