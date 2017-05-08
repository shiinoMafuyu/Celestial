$.operate = {};

//缓存中数据结构设计
//store.set("userDataContainer",userDataContainer) =
//				{"eq00010001":{	"representId":representId,"positionId":positonId,"id":id,
//								"search":{"name":equipmentName,"level":"90","goodslevel":"S"},
//								"extraProperties":{ "strengthen":{"strengthenKind":kind,"strengthenId",id},
//													"fumo":{"representId":representId,"id":id},
//													"dragonJade":{"representId":representId,"id":jadeId,"strengthen":{"strengthenKind":kind,"strengthenId",id}},
//													"signet":{"representId":,representId,"id":signetId}}}}

$.operate.html = 	"<input type='text' class='operate-choose-control'  value='' />" +
					"<div class='choose-show' style='display:none;'>" +
					"	<div class='showProperties'>" +
					"		<div class='showProperties-basic'>" +
					"		</div>" +
					"		<div class='showProperties-strengthen'>" +
					"		</div>" +
					"	</div>" +
					"	<div class='choose'>" +
					"		物品名称：<input  class='choose-name choose-operator' type='text' />" +
					"		限制等级：<select class='choose-level choose-operator'><option value=''>全部</option><option value='1'>1</option><option value='90'>90</option><option value='93'>93</option></select>" +
					"		物品等级：<select class='choose-goodslevel choose-operator'><option value=''>全部</option><option value='A'>A级</option><option value='S'>S级</option><option value='L'>L级</option></select>" +
					"		强化等级：<select class='choose-strengthenLevel'></select>" +
					"	</div>" +
					"	<div class='selectList'>" +
					"		--arg01--" +
					"	</div>" +
					"</div>" ;

$.operate.equipmentListHtml = "<span class='selectList-goods-name' id='arg_id'>arg_name</span>";

/**
 * 顺序。以此顺序取json里的数据，进行显示。
 */
$.operate.orderList = 
					{"li":"力量",
					"min":"敏捷",
					"zhi":"智力",
					"ti":"体质",
					
					"wg":"物理攻击",
					"yz":"硬直",
					"xy":"眩晕",
					"xyDK":"眩晕抵抗",
					"zm":"致命一击",
					"zmDK":"致命一击抵抗",
					
					"mg":"魔法攻击",
					"mf":"魔法防御力",
					"hp":"hp",
					"wf":"防御力",
					"yzDK":"硬直抵抗",
					
					"gg":"光攻",
					"hg":"火攻",
					"sg":"水攻",
					"ag":"暗攻",
					
					"zz":"最终伤害",
					"zmsh":"致命一击伤害",
					"ydsd":"移动速度",
					
					
					"li_":"力量",
					"min_":"敏捷",
					"zhi_":"智力",
					"ti_":"体质",
					
					"wg_":"物理攻击",
					"yz_":"硬直",
					"xy_":"眩晕",
					"xyDK_":"眩晕抵抗",
					"zm_":"致命一击",
					"zmDK_":"致命一击抵抗",
					
					"mg_":"魔法攻击",
					"mf_":"魔法防御力",
					"hp_":"hp",
					"wf_":"防御力",
					"yzDK_":"硬直抵抗",
					
					"zz_":"最终伤害",
					"zmsh_":"致命一击伤害",
					"ydsd_":"移动速度"};

/**当前操作面板div元素*/
$.operate.currentPanel = "";
/**当前数据，此数据保存用户操作新，会放到缓存中。*/
$.operate.currentUserData = {};

$.operate.createMatchOperate = function(equipmentList){
	//排序取出
	var htmlList = "";
	_.each(equipmentList,function(elem){
		htmlList += $.operate.equipmentListHtml.replace("arg_id", elem.id).replace("arg_name", elem.name);
	});
	return $.operate.html.replace("--arg01--",htmlList);
	
};

/**
 * 01点击左边主体输入框！
 * @func 面板的隐藏出现操作.附加representId替换。
 */
$.operate.panelop = function(elem){
	//获取当前操作面板div元素
	$.operate.currentPanel = $.htmlUtil.findContainer(elem,".aEquipment","class","aEquipment");
	//设置当前用户数据
	var currentUserData = store.get("userDataContainer")[$.operate.currentPanel.attr("position")];
	if($.isNull(currentUserData)){
		$.operate.currentUserData = {};
		$.operate.currentUserData.positionId = $.operate.currentPanel.attr("position");
		$.operate.currentUserData.representId = $.operate.currentPanel.attr("representId");
	}else{
		$.operate.currentUserData = currentUserData;
	}
	
	//显示展示div元素面板窗口
	var paneList = $(".operate-choose-control");
	for(var i=0; i<paneList.length;i++){
		var ipanel = $($(paneList[i]).parent()).find(".choose-show");
		$(ipanel).css("display","none");
		$(ipanel).css("width","0");
		$(ipanel).css("height","0");
	}
	var q =$($(elem).parent()).find(".choose-show");
	$(q).css("display","");
	$(ipanel).css("width","14rem");
	$(ipanel).css("height","22rem");
	
};

/**
 * 02点击装备，展示其信息
 * @func 点击名字后将属性显示在属性展示栏。
 */
$.operate.showProperties = function(elem){
	//获取装备信息
	var theEquipments = store.get("equipment")[$.operate.currentUserData.representId];
	var id = $(elem).attr("id");
	var equipment = _.find(theEquipments,function(ei){
		return ei["id"] == id;
	});
	//填充展示数据
	var shower = $.htmlUtil.findContainer(elem,".showProperties-basic");
	var info = $.operate.showProperties.getInfo(equipment);
	$(shower).html(info);
	
	//设置当前选中装备的id
	$.operate.currentUserData.id = id;
	$.operate.save();
	
	//生成强化选择列表 ╮(╯▽╰)╭，没有完整数据，只能有哪些强化数值产出哪些信息了啊。
	$.operate.showProperties.createStrenthenSelect();
};

/**
 * @func 生成强化选择列表.
 */
$.operate.showProperties.createStrenthenSelect = function(){
	$.field.strengthen.data
};

/**
 * @func 生成展示信息。
 */
$.operate.showProperties.getInfo = function(equipment){
	var info = "";
	//排序取出
	for(var i in $.operate.orderList){
		var idata = equipment[i];
		if($.isNull(idata))
			continue;
		
		if(i.indexOf("_") > 1)
			info += $.operate.orderList[i]+" : "+idata * 100+" %<br/>";
		else
			info += $.operate.orderList[i]+" : "+idata+"<br/>";
	}
	return info;
};

/**
 * 03 物品筛选
 * @func 当物品名称、限制等级、物品等级发生改变时进行物品筛选。
 */
$.operate.chooseOperator = function(elem){
	var id = $.operate.currentUserData.id;
	var theEquipments = store.get("equipment")[$.operate.currentUserData.representId];
	
	var name = $($($.operate.currentPanel).find(".choose-name")).val();
	var level = $($($.operate.currentPanel).find(".choose-level")).val();
	var goodslevel = $($($.operate.currentPanel).find(".choose-goodslevel")).val();
	
	var filteEquipments = _.filter(theEquipments,function(elem){
		if(!$.isNull(name) && elem['name'].indexOf(name) <0)
			return false;
		if(!$.isNull(level) && elem['level'] != level)
			return false;
		if(!$.isNull(goodslevel) && elem['goodslevel'] != goodslevel)
			return false;
		return true;
	});
	
	//装备列表生成。
	var htmlList = "";
	_.each(filteEquipments,function(elem){
		htmlList += $.operate.equipmentListHtml.replace("arg_id", elem.id).replace("arg_name", elem.name);
	});
	
	$(".selectList").html(htmlList);
	$(".selectList-goods-name").attr("onclick","$.operate.showProperties(this)");//绑定：将装备填充到显示栏方法
	//将搜索信息存入缓存。
	$.operate.currentUserData.search = {"name":name,"level":level,"goodslevel":goodslevel};
	$.operate.save();
};

/**
 * @func 将当前用户数据$.operate.currentUserData存入store
 */
$.operate.save = function(){
	var userDataContainer = store.get("userDataContainer");
	userDataContainer[$.operate.currentUserData.positionId] = $.operate.currentUserData;
	store.set("userDataContainer",userDataContainer);
};


































