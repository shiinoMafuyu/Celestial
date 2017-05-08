$.showFrame = {};


$.showFrame.init = function(){
	
	//初始化职业
	var charactorList = $.htmlUtil.createOption($.field.charactor,"name","id");
	$(".charactor").html(charactorList);
	
	//初始化操作面板。
	$.showFrame.init_operate();
	$(".operate-choose-control").attr("onclick","$.operate.panelop(this)");//点击输入框；绑定：控制面板的显示与隐藏方法
	$(".selectList-goods-name").attr("onclick","$.operate.showProperties(this)");//面板区装备名字；绑定：将装备填充到显示栏方法
	$(".choose-operator").attr("onchange","$.operate.chooseOperator(this)");//面板区装备筛选；绑定：过滤装备。
	
	//填充强化框。。由于没有全面的数据所以就不能1~15随便选啦~~
	//$(".choose-strengthenLevel").attr("onclick","$.operate.strengthenLevel(this)");//绑定：强化显示方法。
	
	
};

/**
 * 给每个对应的装备，生成其选择框、操作框。
 */
$.showFrame.init_operate = function(){
	var data = store.get("equipment");
	var locationList = $(".aEquipment");
	for(var i=0;i<locationList.length;i++){
		var representId = $(locationList[i]).attr("representId");
		var innerHtml = $.operate.createMatchOperate(data[representId]);
		$(locationList[i]).html(innerHtml);
	}
	
};













































