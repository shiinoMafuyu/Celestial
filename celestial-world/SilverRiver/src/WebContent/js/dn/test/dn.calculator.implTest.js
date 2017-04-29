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
QUnit.test( "test01 -->>  $.calculator.impl.transToArr", function( assert ) {
	var arr = $.calculator.impl.transToArr("5~6");
//	console.log(arr);
	assert.ok( arr[0] == "5", "Passed!" );
	assert.ok( arr[1] == "6", "Passed!" );
});


QUnit.test( "test02 -->>  $.calculator.impl.mul", function( assert ) {
	var val = "3~4", mul1 = "2" , mul2 = "2~3";
	var re1 = $.calculator.impl.mul(val,mul1);
	var re2 = $.calculator.impl.mul(val,mul2);
	assert.ok( "6~8" == re1, "Passed!" );
	assert.ok( "6~12" == re2, "Passed!" );
});


QUnit.test( "test03 -->>  $.calculator.impl.add", function( assert ) {
	var v1 = "2" , v2 = "3~4", v3 = "5";
	var re1 = $.calculator.impl.add(v1,v2);
	var re2 = $.calculator.impl.add(v1,v3);
	
	assert.ok( "5~6" == re1, "Passed!" );
	assert.ok( "7" == re2, "Passed!" );
});


QUnit.test( "test04 -->>  $.calculator.impl.cal2", function( assert ) {
	//MDZZ 抛出异常居然要用function形式
	assert.throws(
		    function() {
		    	$.calculator.impl.cal2("12~102-5~6");
		    },"Passed!"
		  );
	assert.throws(
		    function() {
		    	$.calculator.impl.cal2("12~102/5~6");
		    },"Passed!"
		  );
	assert.ok( $.calculator.impl.cal2("3~15+4~4") == "7~19", "Passed!" );
	assert.ok( $.calculator.impl.cal2("3~15*4~5") == "12~75", "Passed!" );
	
});


QUnit.test( "test05 -->>  $.calculator.impl.calArithmetic", function( assert ) {
	var ret = $.calculator.impl.calArithmetic("s1 + s2 * (s3 + s4)",{"s1":"1~4","s2":2,"s3":3,"s4":"2~4"});
	console.log(ret);
	assert.ok( "11~18" == ret , "Passed!" );
	assert.ok( 1 == "1", "Passed!" );
});


QUnit.test( "test01 -->>  test2", function( assert ) {
	
	assert.ok( 1 == "1", "Passed!" );
});


QUnit.test( "test01 -->>  test2", function( assert ) {
	
	assert.ok( 1 == "1", "Passed!" );
});


