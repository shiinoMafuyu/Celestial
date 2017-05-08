/**
 *<p>
 *<li>
 *
 *					----wangzg 2017-05-04
 *</li>
 *</p>
 * impl = $.math.checkCal2(impl);
 *<b>类说明：数学工具类测试 </b>
 *<p>
 *
 *</p>
 */
QUnit.test( "test01 -->> $.math.calSigma", function( assert ) {
	var res = $.math.calSigma("∑(arg0 * arg1 + argx)",{"arg0":[1,2,3],"arg1":[2,3,4],"argx":[3,4,5]});
	assert.ok( "32" == res, "Passed!" );
});


QUnit.test( "test02 -->>  $.math.calArithmetic", function( assert ) {
	var ret = $.math.calArithmetic("s1 + s2 * (s3 + s4)",{"s1":"4","s2":2,"s3":3,"s4":"2"});
	assert.ok( "14" == ret , "Passed!" );
});


QUnit.test( "test03 -->> $.math.calAllSigma", function( assert ) {
	var res = $.math.calAllSigma("∑(arg0 * arg1 + argx)",{"arg0":[1,2,3],"arg1":[2,3,4],"argx":[3,4,5]});
	assert.ok( "32" == res, "Passed!" );
	
	var res2 = $.math.calAllSigma("∑(arg0 * arg1 + argx) + ∑(arg0 + arg1)",{"arg0":[1,2,3],"arg1":[2,3,4],"argx":[3,4,5]});
	console.log(res2);
	assert.ok( "47" == res2, "Passed!" );
	
	//在∑算完之后计算其他
	var res3 = $.math.calAllSigma("∑(arg0 * arg1 + argx) * arg4 + arg3 + ∑(arg0 + arg1)",{"arg0":[1,2,3],"arg1":[2,3,4],"argx":[3,4,5],"arg3":5,"arg4":2});
	assert.ok( "84" == res3, "Passed!" );
	
});













