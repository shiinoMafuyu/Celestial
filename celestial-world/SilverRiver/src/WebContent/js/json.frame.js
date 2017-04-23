/**
 *<p>
 *<li>
 *
 *					----zhaoziy 2016-10-06
 *</li>
 *</p>
 *
 *<b>类说明： JS框架类  </b>
 *<p>
 *		本类主要用于 1.JSON对象转化成请求XML
 *					 2.返回XML转化成JSON对象
 *		本类的 xmlToJson 和 jsonToXml 函数 主要来源于 Author : Stefan Goessner 提供的 xml和json互转源码
 *</p>
 */
(function ($) {
	
	
	/**
	 * @func 返回发送请求的URL地址
	 */
	$.urlAddress = function(){
		var req = null;
		window.URL_INFO = store.get('URL_INFO');
		if(!$.isNull(window.URL_INFO)){
			req = window.URL_INFO
		} else {
			req = {
					'@name':'url_address',
					'url':"http://182.150.46.240:16503/Issue4ariesMobileServer/communicateServlet",
					'commonUrl':"http://182.150.46.240:16503/mobile_svr_issue/communicateServlet",
					'bankUrl':"http://182.150.46.240:16503/BankInterface4ariesMobileServer/communicateServlet"
			}
		}
		if(req['url'] == '@URL'){
			req['url'] = "http://182.150.46.240:16503/mobile_svr_issue/communicateServlet";
		}
		if(req['bankUrl'] == '@BANKURL'){
			req['bankUrl'] = "http://182.150.46.240:16503/mobile_svr_issue/communicateServlet";
		}
		if(req['commonUrl'] == '@COMMONURL'){
			req['commonUrl'] = "http://182.150.46.240:16503/mobile_svr_issue/communicateServlet";
		}
		if(store.get('marketID')!= '20000'){
			req['url'] = "http://182.150.46.240:16503/mobile_svr_issue/communicateServlet";
			req['commonUrl'] = "http://182.150.46.240:16503/mobile_svr_issue/communicateServlet";
		}
		req['marketUrl'] = "http://182.150.46.240:16503/mobile_svr_issue/marketServlet";
		return req;
	}
	
	/**
	 * @func 参数信息
	 */
	$.args = {
		'FIRST_SEND_TIME':100000,	
		'COMMODITY_HOME_SEND_TIME':3000,
		'COMMODITY_DATA_SEND_TIME':3000,
		'SYSTIME_QUERY_SEND_TIME':5000,
		'SYSTIME_CHECK_TIME':1000,
		'HOLDING_QUERY_CHECK_TIME':15000,
		'HOLDING_QUERY_SEND_TIME':15000,
		'ORDER_QUERY_SEND_TIME':10000000,
		'LOGIN_STATE':false,   //true 不用检查登陆状态，不发送checkUser/systimeQuery等请求  false 检查登陆状态 定时发送checkUser/systimeQuery等请求
		'NEW_TRADE_YES':1,
		'NEW_TRADE_NO':0
	}
	
	/**
	 * @func 屏幕参数信息
	 */
	$.fullscreen = {}
	
	/**
	 * @func 屏幕参数
	 */
	$.fullscreen.args = {
		'state':false	
	}
	
	/**
	 * @func 将空字符串转化成'';
	 */
	$.deNull = function (arg){
		if(arg != null && typeof(arg) != "undefined"){
			return $.trim(arg);
		} else {
			return '';
		}
	}
	
	/**
	 * @func 判断是否为空;
	 */
	$.isNull = function (arg){
		if(arg != null && typeof(arg) != "undefined" && arg != "" ){
			return false;
		} else {
			return true;
		}
	}
	
	/**
	 * @func 将XML转换成JSON格式
	 * @param xml 待转化的XML字符串
	 */
	$.xmlToJson = function (xml, tab) {
		var X = {
			toObj: function(xml) {
				var o = {};
				if (xml.nodeType==1) {
					if (xml.attributes.length)	// element with attributes  ..
						for (var i=0; i<xml.attributes.length; i++)
							o["@"+xml.attributes[i].nodeName] = (xml.attributes[i].nodeValue||"").toString();
					if (xml.firstChild) { // element has child nodes ..
						var textChild=0, cdataChild=0, hasElementChild=false;
						for (var n=xml.firstChild; n; n=n.nextSibling) {
							if (n.nodeType==1) hasElementChild = true;
							else if (n.nodeType==3 && n.nodeValue.match(/[^ \f\n\r\t\v]/)) textChild++; // non-whitespace text
							else if (n.nodeType==4) cdataChild++; // cdata section node
						}
						if (hasElementChild) {
							if (textChild < 2 && cdataChild < 2) { // structured element with evtl. a single text or/and cdata node ..
								//X.removeWhite(xml);
								for (var n=xml.firstChild; n; n=n.nextSibling) {
									if (n.nodeType == 3)  // text node
										o["#text"] = X.escape(n.nodeValue);
									else if (n.nodeType == 4)  // cdata node
										o["#cdata"] = X.escape(n.nodeValue);
									else if (o[n.nodeName]) {  // multiple occurence of element ..
										if (o[n.nodeName] instanceof Array)
											o[n.nodeName][o[n.nodeName].length] = X.toObj(n);
										else
											o[n.nodeName] = [o[n.nodeName], X.toObj(n)];
									}
									else  // first occurence of element..
										o[n.nodeName] = X.toObj(n);
								}
							}
							else { // mixed content
								if (!xml.attributes.length)
									o = X.escape(X.innerXml(xml));
								else
									o["#text"] = X.escape(X.innerXml(xml));
							}
						}
						else if (textChild) { // pure text
							if (!xml.attributes.length)
								o = X.escape(X.innerXml(xml));
							else
								o["#text"] = X.escape(X.innerXml(xml));
						}
						else if (cdataChild) { // cdata
							if (cdataChild > 1)
								o = X.escape(X.innerXml(xml));
							else
								for (var n=xml.firstChild; n; n=n.nextSibling)
									o["#cdata"] = X.escape(n.nodeValue);
						}
					}
					if (!xml.attributes.length && !xml.firstChild) o = null;
				} else if (xml.nodeType==9) { // document.node
					o = X.toObj(xml.documentElement);
				} 
				return o;
			},
			toJson: function(o, name, ind) {
				var json = name ? ("\""+name+"\"") : "";
				if (o instanceof Array) {
					for (var i=0,n=o.length; i<n; i++)
						o[i] = X.toJson(o[i], "", ind+"\t");
					json += (name?":[":"[") + (o.length > 1 ? ("\n"+ind+"\t"+o.join(",\n"+ind+"\t")+"\n"+ind) : o.join("")) + "]";
				} else if (o == null){
					json += (name&&":") + "null";
				} else if (typeof(o) == "object") {
					var arr = [];
					for (var m in o)
						arr[arr.length] = X.toJson(o[m], m, ind+"\t");
					json += (name?":{":"{") + (arr.length > 1 ? ("\n"+ind+"\t"+arr.join(",\n"+ind+"\t")+"\n"+ind) : arr.join("")) + "}";
				} else if (typeof(o) == "string"){
					json += (name&&":") + "\"" + o.toString() + "\"";
				} else {
					json += (name&&":") + o.toString();
				}
				return json;
			},
			innerXml: function(node) {
				var s = ""
				if ("innerHTML" in node)
					s = node.innerHTML;
				else {
					var asXml = function(n) {
						var s = "";
						if (n.nodeType == 1) {
							s += "<" + n.nodeName;
							for (var i=0; i<n.attributes.length;i++)
								s += " " + n.attributes[i].nodeName + "=\"" + (n.attributes[i].nodeValue||"").toString() + "\"";
							if (n.firstChild) {
								s += ">";
								for (var c=n.firstChild; c; c=c.nextSibling)
									s += asXml(c);
								s += "</"+n.nodeName+">";
							}
							else
								s += "/>";
						}
						else if (n.nodeType == 3)
							s += n.nodeValue;
						else if (n.nodeType == 4)
							s += "<![CDATA[" + n.nodeValue + "]]>";
						return s;
					};
					for (var c=node.firstChild; c; c=c.nextSibling)
						s += asXml(c);
				}
				return s;
			},
			escape: function(txt) {
				return txt.replace(/[\\]/g, "\\\\")
							 .replace(/[\"]/g, '\\"')
							 .replace(/[\n]/g, '\\n')
							 .replace(/[\r]/g, '\\r');
			},
			removeWhite: function(e) {
				e.normalize();
				for (var n = e.firstChild; n; ) {
					if (n.nodeType == 3) {	
						if (!n.nodeValue.match(/[^ \f\n\r\t\v]/)) { 	
							var nxt = n.nextSibling;
							e.removeChild(n);
							n = nxt;
						} else {
							n = n.nextSibling;
						}
					} else if (n.nodeType == 1) {
						X.removeWhite(n);
						n = n.nextSibling;
					} else {
						n = n.nextSibling;
					}						
				}
				return e;
			}
		};
		if( Object.prototype.toString.call(xml) === "[object String]" ){
			xml = $.parseXml(xml);
		}
		if (xml.nodeType == 9){
			if(xml.documentElement!=null&&xml.documentElement.innerHTML!=null){
				xml = $.parseXml(xml.documentElement.innerHTML);
			} else {
				xml = xml.documentElement;
			}
		}
		if(tab == null){
			tab = '';
		}
		var json = X.toJson(X.toObj(xml), xml.nodeName, "\t");
		json = "{\n" + tab + (tab ? json.replace(/\t/g, tab) : json.replace(/\t|\n/g, "")) + "\n}";
		var resp = eval('json='+json);
		resp['REP']['TIMESTAMP'] = new Date().getTime();
		//检测返回码，是否是session失效
		if(!$.isNull(resp['REP']['RESULT'])&&!$.isNull(resp['REP']['RESULT']['RETCODE'])){
			var retCode = resp['REP']['RESULT']['RETCODE'];
			if( retCode == '-101' || retCode == '-102' || retCode == '-103' || retCode == '-1008'){
				var message = '登陆超时，请重新登陆！';
				if(retCode == '-103'){
					message = '检测到您的账号在其他设备上登陆，请重新登陆！';
				}
				var name = $.curHtmlName();
				if(!$.args['LOGIN_STATE']&&('#login #market #register #forgetpwd'.indexOf(name)<=0)&& confirm(message)) { //用户确认后，跳转登陆页面
					//移除用户SESSION数据
					store.remove('user-session');
					//移除登陆状态
					store.remove('currentLogin');
					//调整到登陆页面
					$.redirectUrl('login.html');
				}
			}
		}
		return resp;
	}
	
	/**
	 * @func 将Json转换成XML格式
	 * @param o 待转化的json对象
	 */
	$.jsonToXml = function (o, tab) {
		o['REQ']['MRKID#'] = store.get("marketID");
		
		var toXml = function(v, name, ind) {
			
			var xml = "";
			
			if (v instanceof Array) {
				for (var i=0, n=v.length; i<n; i++){
					xml += ind + toXml(v[i], name, ind+"\t") + "\n";
				}
			} else if (typeof(v) == "object") {
				var hasChild = false;
				xml += ind + "<" + name;
				for (var m in v) {
					if (m.charAt(0) == "@")
						xml += " " + m.substr(1) + "=\"" + v[m].toString() + "\"";
					else
						hasChild = true;
				}
				xml += hasChild ? ">" : "/>";
				if (hasChild) {
					for (var m in v) {
						if (m == "#text")
							xml += v[m];
						else if (m == "#cdata")
							xml += "<![CDATA[" + v[m] + "]]>";
						else if (m.charAt(0) != "@")
							xml += toXml(v[m], m, ind+"\t");
					}
					xml += (xml.charAt(xml.length-1)=="\n"?ind:"") + "</" + name + ">";
				}
			} else {
				xml += ind + "<" + name + ">" + v.toString() +  "</" + name + ">";
			}
			return xml;
		}, xml="";
		
		for (var m in o){
			xml += toXml(o[m], m, "");
		}
		
		if(xml != null){
			xml = '<?xml version="1.0" encoding="UTF-8" ?><MEBS_MOBILE>'+xml+'</MEBS_MOBILE>';
		}
		
		return tab ? xml.replace(/\t/g, tab) : xml.replace(/\t|\n/g, "");
	}
	
	/**
	 * @func 将Xml转化为Dom对象
	 * @param xml 待转化的XML字符串
	 */
	$.parseXml = function (xml) {
		var dom = null;
		xml = $.removeXMLNode(xml);
		if (window.DOMParser) {
			try { 
				dom = (new DOMParser()).parseFromString(xml, "application/xml"); 
			} catch (e) { 
				dom = null; 
			}
		} else if (window.ActiveXObject) {
			try {
				dom = new ActiveXObject('Microsoft.XMLDOM');
				dom.async = false;
				if (!dom.loadXML(xml)){
				}
			} catch (excep) { 
				dom = null; 
			}
		}
		if(dom!=null){
			if(dom.childNodes!=null&&dom.childNodes[0].firstChild!=null){
				if(dom.childNodes[0].firstChild.tagName == 'parsererror'){
					dom.childNodes[0].removeChild(dom.childNodes[0].firstChild); 
				}
			}
			if(dom.childNodes!=null&&dom.childNodes[0].nodeName=='REP'){
				dom = dom.childNodes[0];
			}
		}
		return dom;
	}
	
	/**
	 * @func 去掉多余标签 <br/>
	 * 	如 <?xml version="1.0" encoding="GB2312"?> <MEBS_MOBILE>
	 * @param 待处理的xml字符串
	 */
	$.removeXMLNode = function (xml){
		var xmlLab = ['MEBS_MOBILE','MEBS_MT'];
		//去掉<?xml version="1.0" encoding="GB2312"?>
		if(xml.indexOf('<?')>=0&&xml.indexOf('?>')>=0){
			xml = xml.substring(xml.indexOf('?>')+2);
		}
		//去掉MEBS_MOBILE标签
		for( var lab in xmlLab ){
			var value = xmlLab[lab];
			if(xml.indexOf(value)>=0){
				if(xml.indexOf('<'+value+'>')>=0){
					xml = xml.replace('<'+value+'>','');
				}
				if(xml.indexOf('</'+value+'>')>=0){
					xml = xml.replace('</'+value+'>','');
				}
			}
		}
		return xml;
	}
	
	/**
	 * @func 向服务器发送XML请求
	 * @param xml 请求Xml
	 * @param callback 查询成功后的回调函数
	 */
	$.sendXmlReq = function(xml,callback,url,errorback){
		url = $.isNull(url)?$.urlAddress().url:url;
		$.ajax({
			url:url,
			type:'post',
			data: xml,
			dataType:'xml',
			success:callback,
			contentType: "application/x-www-form-urlencoded; charset=utf-8", 
			error:errorback
		});
	}
	
	/**
	 * @func 动态引入JS
	 */
	$.loadJS = function (javascriptSource){
		 var headObj = document.getElementsByTagName("head")[0];
		 srciptObj = document.createElement("script");
		 srciptObj.language = "javaScript";
		 srciptObj.type = "text/JavaScript";
		 srciptObj.src = javascriptSource;
		 headObj.appendChild(srciptObj);
	}
	
	/**
	 * @func 预加载功能
	 */
	$.preLoad = function(){
		//加载外部js库
		$.loadJS('./js/accounting.min.js');
		$.loadJS('./js/iscroll.js');
		$.loadJS('./js/store.min.js');
		$.loadJS('./js/sweetalert.js');
		$.loadJS('./js/underscore-min.js');
		//加载公共信息js
		$.loadJS('./gnnt/common/gnnt.MEBS.issue.brokerinfo.js');
		$.loadJS('./gnnt/common/gnnt.MEBS.issue.changepwd.js');
		$.loadJS('./gnnt/common/gnnt.MEBS.issue.commodity.js');
		$.loadJS('./gnnt/common/gnnt.MEBS.issue.commoditybreed.js');
		$.loadJS('./gnnt/common/gnnt.MEBS.issue.commoditydataquery.js');
		$.loadJS('./gnnt/common/gnnt.MEBS.issue.firminfo.js');
		$.loadJS('./gnnt/common/gnnt.MEBS.issue.forgetpwd.js');
		$.loadJS('./gnnt/common/gnnt.MEBS.issue.login.js');
		$.loadJS('./gnnt/common/gnnt.MEBS.issue.logoff.js');
		$.loadJS('./gnnt/common/gnnt.MEBS.issue.mobilecdkey.js');
		$.loadJS('./gnnt/common/gnnt.MEBS.issue.register.js');
		//加载交易相关js
		$.loadJS('./gnnt/trade/gnnt.MEBS.issue.holdingdetailsquery.js');
		$.loadJS('./gnnt/trade/gnnt.MEBS.issue.holdingquery.js');
		$.loadJS('./gnnt/trade/gnnt.MEBS.issue.myorderquery.js');
		$.loadJS('./gnnt/trade/gnnt.MEBS.issue.ordercancel.js');
		$.loadJS('./gnnt/trade/gnnt.MEBS.issue.ordersubmit.js');
		$.loadJS('./gnnt/trade/gnnt.MEBS.issue.ordertrade.js');
		$.loadJS('./gnnt/trade/gnnt.MEBS.issue.querybsqty.js');
		//加载仓单相关js
		$.loadJS('./gnnt/bill/gnnt.MEBS.issue.firmholdcmd.js');
		$.loadJS('./gnnt/bill/gnnt.MEBS.issue.firmholdware.js');
		$.loadJS('./gnnt/bill/gnnt.MEBS.issue.billcontrolstatus.js');
		$.loadJS('./gnnt/bill/gnnt.MEBS.issue.billcostquery.js');
		$.loadJS('./gnnt/bill/gnnt.MEBS.issue.billlabelledquery.js');
		$.loadJS('./gnnt/bill/gnnt.MEBS.issue.billloadcancel.js');
		$.loadJS('./gnnt/bill/gnnt.MEBS.issue.billloadquery.js');
		$.loadJS('./gnnt/bill/gnnt.MEBS.issue.billloadregist.js');
		$.loadJS('./gnnt/bill/gnnt.MEBS.issue.canceldistrb.js');
		$.loadJS('./gnnt/bill/gnnt.MEBS.issue.changebillload.js');
		$.loadJS('./gnnt/bill/gnnt.MEBS.issue.changebillloaddetail.js');
		$.loadJS('./gnnt/bill/gnnt.MEBS.issue.changebillpassword.js');
		$.loadJS('./gnnt/bill/gnnt.MEBS.issue.deliveryonlinedetail.js');
		$.loadJS('./gnnt/bill/gnnt.MEBS.issue.getintervalnumber.js');
		$.loadJS('./gnnt/bill/gnnt.MEBS.issue.getlabelled.js');
		$.loadJS('./gnnt/bill/gnnt.MEBS.issue.makesuredistrb.js');
		$.loadJS('./gnnt/bill/gnnt.MEBS.issue.makesureoutbound.js');
		$.loadJS('./gnnt/bill/gnnt.MEBS.issue.submitdistrb.js');
		$.loadJS('./gnnt/bill/gnnt.MEBS.issue.submitlabelled.js');
		//加载插件相关JS
		$.loadJS('./gnnt/plugins/gnnt.MEBS.issue.bill.js');
		$.loadJS('./gnnt/plugins/gnnt.MEBS.issue.billfee.js');
		$.loadJS('./gnnt/plugins/gnnt.MEBS.issue.holdDetail.js');
		$.loadJS('./gnnt/plugins/gnnt.MEBS.issue.holding.js');
		$.loadJS('./gnnt/plugins/gnnt.MEBS.issue.scroll.js');
		$.loadJS('./gnnt/plugins/gnnt.MEBS.issue.trade.js');
		$.loadJS('./gnnt/plugins/gnnt.MEBS.issue.tradeorder.js');
		$.loadJS('./gnnt/plugins/gnnt.MEBS.issue.tradewithdraw.js');
	}
	
	/**
	 * @func 加载完毕，启用CheckUser线程
	 */
	$.exeCheckUser = function(){
		//获取session信息
		var session = store.get("user-session");
		//没有登录，则跳转至登录页面
		if($.isNull(session)&&!$.args['LOGIN_STATE']){ //在登陆页面、注册页面、忘记密码页面，$.args['LOGIN_STATE']会被赋值为true
			$.redirectUrl('login.html');
		}
		setTimeout(function(){
			if($.checkuser!=null&&typeof($.checkuser) != "undefined" && typeof($.checkuser.click) != 'undefined'){
				$.checkuser.click();
			} else {
				$.exeCheckUser();
			}
		},$.args['FIRST_SEND_TIME']);
	}
	
	/**
	 * @func 加载完毕，启用SysTimeQuery线程
	 */
	$.exeSysTime = {
		start:function(){
			setTimeout(function(){
				if($.systimequery!=null&&typeof($.systimequery) != "undefined" && typeof($.systimequery.check) != 'undefined'){
					try{
						eval('$.systimequery.check');
					} catch(e){
						
					}
				} else {
					$.exeSysTime.start();
				}
			},$.args['SYSTIME_CHECK_TIME']);
		},
		stop:function(){
			if($.systimequery!=null&&typeof($.systimequery) != "undefined" && typeof($.systimequery.check) != 'undefined'){
				clearInterval($.systimequery.check);
			}
		},
		fast:function(){
			$.args['SYSTIME_QUERY_SEND_TIME'] = 5000;
			stop();
			start();
		},
		slow:function(){
			$.args['SYSTIME_QUERY_SEND_TIME'] = 30000;
			stop();
			start();
		}
	};
	
	/**
	 * @func 加载完毕，启用OrderQuery线程
	 */
	$.exeOrderQuery = {
		start:function(){
			setTimeout(function(){
				if($.myorderquery!=null&&typeof($.myorderquery) != "undefined" && typeof($.myorderquery.check) != 'undefined'){
					try{
						eval('$.myorderquery.check');
					} catch(e){
						
					}
				} else {
					$.exeOrderQuery.start();
				}
			},$.args['SYSTIME_CHECK_TIME']);
		},
		stop:function(){
			if($.myorderquery!=null&&typeof($.myorderquery) != "undefined" && typeof($.myorderquery.check) != 'undefined'){
				clearInterval($.myorderquery.check);
			}
		}
	}
	
	/**
	 * @func 调转至指定URL
	 */
	$.redirectUrl = function(murl){
		try {
			if(document.getElementById("bdmark") != null){
				return;
			}
			var urlhash = window.location.hash;
			if (!urlhash.match("fromapp")){
				if (navigator.userAgent.match(/(iPhone|iPod|Android|ios|iPad)/i)) {
					//判断是否是在微信内置浏览器浏览
					if(true ||navigator.userAgent.match(/(iPhone|Android)/i) && navigator.userAgent.match(/(MicroMessenger)/i)){
						if(!$.isNull(murl)){
							window.location = murl;
						} else { //如果未发现url，直接跳转到Home页面
							window.location = 'index.html';
						}
					} else {//无权限浏览，跳转到提示页面
						window.location = 'auth.html';
					}
				}
			}
		} catch(e){}
	}
	
	/**
	 * @func 自动隐藏浏览器地址栏
	 */
	$.hideUrl = function(){
		if(document.documentElement.scrollHeight <= document.documentElement.clientHeight) {  
			bodyTag = document.getElementsByTagName('body')[0];  
			bodyTag.style.height = (document.documentElement.clientWidth / screen.width * screen.height ) + 'px';  
		}  
		setTimeout(function() {  
			window.scrollTo(0, 1)  
		}, 0);  
	}
	
	/**
	 * @func 进行全屏设置
	 */
	$.fullScreen = function(element) {
		try{
			if(element.requestFullscreen) {
				element.requestFullscreen();
			} else if(element.mozRequestFullScreen) {
				element.mozRequestFullScreen();
			} else if(element.webkitRequestFullscreen) {
				element.webkitRequestFullscreen();
			} else if(element.msRequestFullscreen) {
				element.msRequestFullscreen();
			}
		} catch(e){}
	}
	
	/**
	 * @func 退出全屏设置
	 */
	$.exitFullScreen = function() {
		if(document.exitFullscreen) {
			document.exitFullscreen();
		} else if(document.mozExitFullScreen) {
			document.mozExitFullScreen();
		} else if(document.webkitExitFullscreen) {
			document.webkitExitFullscreen();
		}
	}
	
	/**
	 * @func 获取当前全屏状态 true 是全屏  false 不是全屏
	 */
	$.fullScreenState = function(){
		var element = document.documentElement;
		if(element.requestFullscreen) {
			return document.fullscreen;
		} else if(element.mozRequestFullScreen) {
			return document.mozFullScreen;
		} else if(element.webkitRequestFullscreen) {
			return document.webkitIsFullScreen;
		} else if(element.msRequestFullscreen) {
			return document.msFullscreenElement;
		}
	}
	
	/**
	 * @func 获取当前地址参数值
	 */
	$.queryArgs = function (name){
		var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
		var r = window.location.search.substr(1).match(reg);
		if(r!=null)return  unescape(r[2]); return "";
	}
	
	/**
	 * @func 获取当前地址参数值,如果参数栏没有就从store里取.解决苹果点他系统自带的返回无参数,无法有效展示数据问题.
	 */
	$.queryArgs2 = function (name){
		var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
		var r = window.location.search.substr(1).match(reg);
		if(r!=null)
			return  unescape(r[2]);
		return $.getArgs(name);
	}
	
	/**
	 * @func 页面之间的参数传递.存入store里的方法.
	 * 		这些参数将会存入store里的一个json里.
	 * @param key	键
	 * @param value	值
	 */
	$.setArgs = function(key,value){
		var args = store.get("args");
		if($.isNull(args))
			args = {};
		args[key] = value;
		store.set("args",args);
	};
	
	/**
	 * @func 获取参数
	 */
	$.getArgs = function(key){
		var args = store.get("args");
		if($.isNull(args))
			args = {};
		var storeParam = args[key];
		return $.isNull(storeParam)?"":storeParam;
	};
	
	/**
	 * @func 加载提示方法 
	 * @notice  $.loading.alert() 弹出加载提示   
	 *           $.loading.close() 隐藏加载提示
	 */
	$.loading = {
		'alert':function(message){
			var div ;
			
			if($(".background-mask").length > 0 && $(".mask-message").length > 0){
				if(!$.isNull(message)){
					$(".mask-message").html(message);
				} else {
					$(".mask-message").html("<i class='fa fa-spinner fa-pulse fa-4x'></i>");
				}
			} else {
				if($.isNull(message)){
					div =   "<div class='background-mask'></div>"+
								"<div class='mask-message'>"+
								"<i class='fa fa-spinner fa-pulse fa-4x'></i>"+
							"</div>";
				} else {
					div = "<div class='background-mask'></div>"+
							"<div class='mask-message'>"+message+
						  "</div>";
				}
				$('body').append(div);
			}
			if($(".background-mask").length > 0 && $(".mask-message").length > 0){
				$('.background-mask').css({'display':'block'});
				$('.mask-message').css({'display':'block'});
			}
		},
		'close':function(){
			setTimeout(function(){
				if($(".background-mask").length > 0 && $(".mask-message").length > 0){
					$('.background-mask').css({'display':'none'});
					$('.mask-message').css({'display':'none'});
				}
			},300);
		}
	}
	
	/**
	 * @func 生成UUID
	 */
	$.UUID = function(len, radix) {
		//var chars = '0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz'.split('');
		var chars = '023456789ABCDEFGHJKLMNOPQRSTUVWXYZabcdefghijkmnopqrstuvwxyz'.split('');
		var uuid = [], i;
		radix = radix || chars.length;
		if (len) {
			for (i = 0; i < len; i++) uuid[i] = chars[0 | Math.random()*radix];
		} else {
			var r;
			uuid[8] = uuid[13] = uuid[18] = uuid[23] = '-';
			uuid[14] = '4';
			for (i = 0; i < 36; i++) {
				if (!uuid[i]) {
					r = 0 | Math.random()*16;
					uuid[i] = chars[(i == 19) ? (r & 0x3) | 0x8 : r];
				}
			}
		}
		return uuid.join('');
	}
	
	/**
	 * @func 格式化Money
	 * @param dollar 
	 * @param flag 默认'￥' 货币类型
	 * @param fixed 小数点保留位数
	 */
	$.formatMoney = function (dollar , flag , fixed){
		try{
			if(!$.isNull(accounting)){
				dollar = accounting.formatMoney(dollar , flag , fixed);
			}
		}catch(e){}
		return dollar;
	};
	
	/**
	 * @func 格式化数字
	 * @param number 要格式化的数字
	 * @param fixed 保留多少位小数
	 * @param divide 分隔符
	 */
	$.formatNumber = function (number , fixed , divide){
		if(!$.isNull(accounting)){
			return accounting.formatNumber(number , fixed , divide);
		}
		return number;
	};
	
	/**
	 * @func 格式化数字(满3位不会有空格之类的分隔符分开)
	 * @param number 要格式化的数字
	 * @param fixed 保留多少位小数
	 */
	$.toFixed = function(number,fixed){
		return accounting.toFixed(number,fixed);
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
	
	/**
	 * @func 获取当前Html页面名称 
	 */
	$.curHtmlName = function(){
		var str=window.location.href;
		if(!(str.endWith('mobile_svr_issue')||str.endWith('mobile_svr_issue/'))){
			return str.substring(str.lastIndexOf('/')+1,str.lastIndexOf('.'));
		} else {
			return 'welcome';
		}
	}
	
	/**
	 * @func 页面加载完毕，启用定时线程
	 */
	window.onload = function() { 
		//获取当前页面名称
		var pageName = $.curHtmlName();
		//判断是否是在微信内置浏览器浏览
		if(!(navigator.userAgent.match(/(iPhone|Android)/i) && navigator.userAgent.match(/(MicroMessenger)/i))){
			if(false && pageName!='auth'){
				window.location = 'auth.html';
			}
		}
		$.loadJS('./gnnt/common/gnnt.MEBS.issue.checkuser.js');
		$.loadJS('./gnnt/common/gnnt.MEBS.issue.systimequery.js');
		try{
			//获取session信息
			var session = store.get("user-session");
			if(!$.isNull(session)){ //如果session不为空（用户已经登陆），则启动定时查询功能
				$.exeCheckUser();//启动定时执行CheckUser功能
				$.exeSysTime.start();//启动系统时间查询功能
				//$.exeOrderQuery.start();//启动委托查询功能
			} else if($.isNull(session)&&!$.args['LOGIN_STATE']){ //在登陆页面、注册页面、忘记密码页面，$.args['LOGIN_STATE']会被赋值为true
				$.redirectUrl('login.html');
			}
			$.fullScreen(document.documentElement);//进入全屏模式
			//$.hideUrl(); //加载完毕自动隐藏地址栏
			//Dom元素绑定触摸启动事件
			$(document.documentElement).on('touchstart',function(){
				if(!$.fullscreen.args['state']){
					//$.fullScreen(document.documentElement);
					$.fullscreen.args['state'] = true;
				}
			})
			//如果在行情或者自选页面，则实时刷新行情
			if(pageName == 'community' || pageName == 'self'){
				$.commoditydataquery.exeCheckData();
			}
		} catch (e){ }
	};
	
	
	$.showTradeReply = function(){
		var info = "<div class='tradeInfoReminder' style='widht:98%;height:30px;position:fixed;right:0px;left:0px;bottom:0px;background-color:#FF7256'>你好!</div>";
		$("body").append($(info));
	}
	
})(jQuery);	