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
//	console.log(ret);
	var res = expected == ret;
	
	assert.ok( res, "Passed!" );
});




QUnit.test( "test02 -->>  test2", function( assert ) {
	
	assert.ok( 1 == "1", "Passed!" );
});