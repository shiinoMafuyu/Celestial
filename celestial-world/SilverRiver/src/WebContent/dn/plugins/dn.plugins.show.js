$.show = {};


$.show.init = function(){
	
	//初始化职业
	var charactorList = $.htmlUtil.createOption($.field.charactor,"name","id");
	$(".charactor").html(charactorList);
	
	//初始装装备
	$.show.init_0();
	//1.绑定改变事件； 根据value，生成新元素， 绑定改变事件
	//2.若有改变 根当前值取递归删除
	//3.全是相邻select框。
	//4.我日啊 最主要的是找到最简单的实现方法。递归什么的能不用就不用好伐！！复杂的算法，生成队列之类的就算了，在实现复杂结构的情况下简直就是坑爹，。
	//5.所有的改变事件都要绑定search! 选择属性都设置为  option='operate-equipment' equipmentArea= 'equipment' representId='' ,前一个是全部的进行分类的，后一个是标志此装备所属的域:equipment、buff、charactor、dragonJade、enchantment、mintMark、strengthen
	$.show.on_operateEquipment_ChangeAttach();
	
	
	
};



/**
 * @func 将所有装备位置都添加上对应的装备选择select。
 */
$.show.init_0 = function(){
	var allHtmlList = $(".aEquipment");
	var allEquipment = store.get("equipment");
	
	for(var i =0;i<allHtmlList.length;i++){
		var ae = $(allHtmlList[i]);
		var representId = ae.attr("representId");
		var theEqList = allEquipment[representId];
		var selectHtml = $.htmlUtil.createSelect(" option='operate-equipment' equipmentArea= 'equipment' myId='0' ",theEqList,"name","id","<option>--请选择--</option>");
		ae.html(selectHtml);
	}
};

/**
 * @func 给全部具有option='operate-equipment'属性的元素绑定$.show.equipment_change(this)方法.
 */
$.show.on_operateEquipment_ChangeAttach = function(){
	$("[option='operate-equipment']").attr("onchange","$.show.equipment_change(this)");
};

/**
 * @func 装备改变事件；根据当前元素搜索条件找到依赖域元素；画出select框。
 */
$.show.equipment_change = function(elem){
	
	//找到内存中装备信息
	var selectedEquipmentList = $.field.totalData[$(elem).attr("equipmentArea")];
	var id= $(elem).val();
	if(!$.isNum(id))
		return;
	var selectedEquipment = _.find(selectedEquipmentList,function(elem){
		return elem["id"] == id;
	});
	
	
	$.show.equipment_change_deleteOld(elem);
	$.show.equipment_change_addNew(elem,selectedEquipment);
	$.show.equipment_change_changeMemoery(elem,selectedEquipment);
	
	
};

/**
 * @func 删除这个元素后面的。以便为重新添加做准备。
 */
$.show.equipment_change_deleteOld = function(elem){
	
};

$.show.equipment_change_addNew = function(elem,selectedEquipment){
	var myId = $(elem).attr("myId");//myId用于标记此数据在递归结构中的位置。可用于删除子序列；内存中位置标记，这样就能方便的进行替换修改内存数据了。
	
	//根据装备信息找到搜索条件
	var searchStr = selectedEquipment["search"];
	if($.isNull(searchStr))
		return;
	var search = $.parseJSON(searchStr);//{strengthen:[strengthenKind="90-S-冰龙-头盔"],dragonJadeKind:[strengthenKind="90-A-防御"]}
	
	//根据搜索条件找到并生成select框
	var index=0;
	for(var key in search){
		var originalData = $.field.totalData[key];
		var searchCondition = search[key];//[strengthenKind="90-S-冰龙-头盔"]
		//从元数据originalData中用searchCondition条件过滤出所需数据。
		var filtedData = _.filter(originalData,function(ei){
			var b = true;
			_.each(searchCondition,function(ic){
				//ic : strengthenKind="90-S-冰龙-头盔"
				var icKey = ic.split("=")[0];
				var icVal = ic.split("=")[1];
				if(ei[icKey] != icVal){
					b = false;
					return;
				}
					
			});
			return b;
		});
		//设置myId
		var selectHtml = $.htmlUtil.createSelect(" option='operate-equipment' equipmentArea= '"+key+"' myId='"+myId+"-"+index+"'",filtedData,"name","id","<option>--请选择--</option>");
		$(elem).parent().append($(selectHtml));
		index++;
	}
	
	//为生成的select框绑定事件。
	$.show.on_operateEquipment_ChangeAttach();
};

/**
 * @func 改变内存中数据。
 * 
 */
$.show.equipment_change_changeMemoery = function(elem,selectedEquipment){
	var myId = $(elem).attr("myId");
	var positionId = $(elem).parent().attr("position");
	
	var positionMemory = store.get("positionMemory");
	var positionObj = positionMemory[positionId];
	if($.isNull(positionObj)){
		positionObj = {"positionId":positionId};
		positionObj["objs"] = {};
	}
	
	var meInMemory = {};
	meInMemory["equipmentArea"] = $(elem).attr("equipmentarea");
	meInMemory["id"] = $(elem).val();
	meInMemory["obj"] = selectedEquipment;
	
	positionObj["objs"][myId] = meInMemory;
	positionMemory[positionId] = positionObj;
	
	store.set("positionMemory",positionMemory);
	
};









































