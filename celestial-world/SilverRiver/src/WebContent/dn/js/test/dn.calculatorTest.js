/**
 *<p>
 *<li>
 *
 *					----wangzg 2017-04-29
 *</li>
 *</p>
 *
 *<b>类说明：测试 </b>
 *<p>
 *
 *</p>
 */
//设置转换map
$.calculator.transMap = {"yz":[{"li":3}],"yzDK":[{"li":3}],"xy":[{"li":2.5}],"wg":[{"li":0.25},{"min":0.25}],"zmsh":[{"li":3},{"zhi":3}],
		"zm":[{"min":4}],"zmDK":[{"min":10.5}],"mg":[{"zhi":1}],"mf":[{"zhi":0.8}],"hp":[{"ti":30}],"wf":[{"ti":0.6}],"xyDK":[{"ti":2.5}]};

var ans = {"li":0,"min":0,"zhi":0,"ti":0,
		"wg":0,"yz":0,"xy":0,"xyDK":0,"zm":0,"zmDK":0,
		"mg":0,"mf":0,"hp":0,"wf":0,"yzDK":0,
		"gg":0,"hg":0,"sg":0,"ag":0,
		"gf":0,"hf":0,"sf":0,"af":0,
		"zz":0,"zmsh":0,"ydsd":0,"mphf":0,
		
		"li_":0,"min_":0,"zhi_":0,"ti_":0,
		"wg_":0,"yz_":0,"xy_":0,"xyDK_":0,"zm_":0,"zmDK_":0,
		"mg_":0,"mf_":0,"hp_":0,"wf_":0,"yzDK_":0,
		"zz_":0,"zmsh_":0,"ydsd_":0,"mphf_":0};


QUnit.test( "test01 -->>  $.calculator.unified", function( assert ) {
	
	var equipments = [{"li":2,"wg":'3~4',"li_":1},{"li":3,"mg":3,"li_":2,'wg':'3~4'}];
	var res = $.calculator.unified(equipments);
	var expect = {"li":5,"wg":'6~8',"li_":3,"mg":3}

	for(var i in expect){
		assert.ok(expect[i] == res[i]);
	}
});

var original = {"li":5,"wg":'5~10',"li_":0.5,"mg":5};
var buff = {"li":5,"wg":'5~10',"li_":0.5,"mg":5};

QUnit.test( "test02 -->>  $.calculator.caculateTotal_lv1", function( assert ) {
	var res = $.calculator.caculateTotal_lv1(ans,original,buff);
	
	assert.ok( 1 == "1", "Passed!" );
	assert.ok( 0 == res.wg, "Passed!" );
	assert.ok( 0 == res.li_, "Passed!" );
});

QUnit.test( "test03 -->>  $.calculator.caculateTotal_lv2", function( assert ) {
	var myAns = {"li":10,"min":4};
	var myOr = {"wg":"2~4","wg_":"1","xy":"3~5","yz":2},myBu = {"wg":3,"wg_":"2"};
	var res = $.calculator.caculateTotal_lv2(myAns,myOr,myBu);
//	console.log("$.calculator.caculateTotal_lv2  -->> " + res);
	
	assert.ok( 10 == res.li, "Passed!" );
	assert.ok( 4 == res.min, "Passed!" );
	
	assert.ok( "42~54" == res.wg, "Passed!" );
	assert.ok( "28~30" == res.xy, "Passed!" );
	assert.ok( "32" == res.yz, "Passed!" );
	assert.ok( "30" == res.yzDK, "Passed!" );
	
});

QUnit.test( "test04 -->>  $.calculator.caculateTotal", function( assert ) {
	var myOr = {'li':10,'min':4,'wg':'2~4','wg_':'1','xy':'3~5','yz':2},myBu = {'wg':3,'wg_':'2'};
	
	var res = $.calculator.caculateTotal(myOr,myBu);
	var expect = {"li":"10","min":"4","wg":"42~54","yz":"32","xy":"28~30","zm":"16","zmDK":"42","yzDK":"30","zmsh":"30"}
//	console.log("--->" + $.jsonUtil.toJsonString($.jsonUtil.removeEmpty(res)));
	
	for(var key in expect){
		assert.ok( expect[key] == res[key], "Passed!" );
	}
	
});






















