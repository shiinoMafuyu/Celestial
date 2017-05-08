/**
 *<p>
 *<li>
 *
 *					----wangzg 2016-12-01
 *</li>
 *</p>
 *
 *<b>类说明： 工具类,日期转换 数字处理等的测试 </b>
 *<p>
 *
 *</p>
 */

QUnit.test( "test01 -->> $.jsonUtil.toJsonString", function( assert ) {
	var json = {"name":"yuki","age":17};
	var expected = '{"name":"yuki","age":17}';
	var ret = $.jsonUtil.toJsonString(json);
	var res = expected == ret;
	
	assert.ok( res, "Passed!" );
});

QUnit.test( "test02 -->>  $.jsonUtil.equal", function( assert ) {
	var json1 = {"c":"kurise","d":"miki"};
	var json2 = {"a":"","b":null,"c":"kurise","d":"miki","e":0};
	assert.ok( $.jsonUtil.equal(json1,json2), "Passed!" );
});


QUnit.test( "test03 -->>  $.jsonUtil.removeEmpty", function( assert ) {
	var json = {"a":"","b":null,"c":"kurise","d":"miki","e":0};
	var res = $.jsonUtil.removeEmpty(json);
	var expect = {"c":"kurise","d":"miki"}
	assert.ok( $.jsonUtil.equal(res,expect) , "Passed!" );
});











