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
QUnit.test( "test01 -->>  $.calculator_impl.transToArr", function( assert ) {
	var arr = $.calculator_impl.transToArr("5~6");
	assert.ok( arr[0] == "5", "Passed!" );
	assert.ok( arr[1] == "6", "Passed!" );
});


QUnit.test( "test02 -->>  $.calculator_impl.mul", function( assert ) {
	var val = "3~4", mul1 = "2" , mul2 = "2~3";
	var re1 = $.calculator_impl.mul(val,mul1);
	var re2 = $.calculator_impl.mul(val,mul2);
	assert.ok( "6~8" == re1, "Passed!" );
	assert.ok( "6~12" == re2, "Passed!" );
});


QUnit.test( "test03 -->>  $.calculator_impl.add", function( assert ) {
	var v1 = "2" , v2 = "3~4", v3 = "5";
	var re1 = $.calculator_impl.add(v1,v2);
	var re2 = $.calculator_impl.add(v1,v3);
	
	assert.ok( "5~6" == re1, "Passed!" );
	assert.ok( "7" == re2, "Passed!" );
});


QUnit.test( "test04 -->>  $.calculator_impl.cal2", function( assert ) {
	//MDZZ 抛出异常居然要用function形式
	assert.throws(
		    function() {
		    	$.calculator_impl.cal2("12~102-5~6");
		    },"Passed!"
		  );
	assert.throws(
		    function() {
		    	$.calculator_impl.cal2("12~102/5~6");
		    },"Passed!"
		  );
	assert.ok( $.calculator_impl.cal2("3~15+4~4") == "7~19", "Passed!" );
	assert.ok( $.calculator_impl.cal2("3~15*4~5") == "12~75", "Passed!" );
	
});


QUnit.test( "test05 -->>  $.calculator_impl.calArithmetic", function( assert ) {
	var ret = $.calculator_impl.calArithmetic("s1 + s2 * (s3 + s4)",{"s1":"1~4","s2":2,"s3":3,"s4":"2~4"});
	assert.ok( "11~18" == ret , "Passed!" );
});


QUnit.test( "test06 -->>  $.calculator_impl.calAllSigma", function( assert ) {
	var lv2_Arit = "((∑(lv1s * transs) + selfLv2) * (1 + self_Lv2_) + buffLv2) * (1 + buff_Lv2_)";
	var param = {
			"lv1s" : [1,2],
			"transs" : [3,4],
			"selfLv2"  : 3,
			"self_Lv2_" : 4,
			"buffLv2"  : 2,
			"buff_Lv2_" : 3
		};
	var ret = $.calculator_impl.calAllSigma(lv2_Arit,param);
	
	console.log("$.calculator_impl.calAllSigma --> " + ret);
	assert.ok( "288" == ret , "Passed!" );
});







