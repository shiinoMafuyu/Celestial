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
QUnit.test( "test01 -->>  $.calculator_depend.getOrinalData_impl", function( assert ) {
	var j1 = {"li":2,"wg":'3~4',"li_":1};
	var j2 = {"li":3,"mg":3,"li_":2,'wg':'3~4'};
	//等待那边弄完取测试数据
	var positionMemory = {
	    "eq00050001": {
	        "positionId": "eq00050001", 
	        "objs": {
	            "0": {
	                "equipmentArea": "equipment", 
	                "id": "40", 
	                "obj": {
	                    "id": 40, 
	                    "representId": "009300050001", 
	                    "name": "高级智慧的强化护符", 
	                    "level": 93, 
	                    "zhi": 1130
	                }
	            }
	        }
	    }, 
	    "eq00050002": {
	        "positionId": "eq00050002", 
	        "objs": {
	            "0": {
	                "equipmentArea": "equipment", 
	                "id": "42", 
	                "obj": {
	                    "id": 42, 
	                    "representId": "009300050001", 
	                    "name": "健康的强化护符", 
	                    "level": 93, 
	                    "ti": 353
	                }
	            }
	        }
	    }
	};
	var res = $.calculator_depend.getOrinalData_impl(positionMemory);
	var expect = [{"id":40,"representId":"009300050001","name":"高级智慧的强化护符","level":93,"zhi":1130},{"id":42,"representId":"009300050001","name":"健康的强化护符","level":93,"ti":353}];
//	console.log($.jsonUtil.toJsonString(res));
	assert.ok( $.jsonUtil.toJsonString(expect) == $.jsonUtil.toJsonString(res), "Passed!" );
});


QUnit.test( "test02 -->>  $.calculator_depend.getTransMap_impl", function( assert ) {
	var character = {
		    "id": 1, 
		    "name": "魔羽", 
		    "level": 93, 
		    "li_yz": 3, 
		    "li_yzDK": 3, 
		    "li_xy": 2.5, 
		    "li_wg": 0.25, 
		    "li_zmsh": 3, 
		    "min_zm": 4, 
		    "min_zmDK": 10.5, 
		    "min_wg": 0.25, 
		    "zhi_mg": 1, 
		    "zhi_mf": 0.8, 
		    "zhi_zmsh": 3, 
		    "ti_hp": 30, 
		    "ti_wf": 0.6, 
		    "ti_xyDK": 2.5, 
		    "li": 2100, 
		    "min": 3160, 
		    "zhi": 2948, 
		    "ti": 2312
		};
	var ans = $.calculator_depend.getTransMap_impl(character);
	var expect = {"yz":[{"li":3}],"yzDK":[{"li":3}],"xy":[{"li":2.5}],"wg":[{"li":0.25},{"min":0.25}],"zmsh":[{"li":3},{"zhi":3}],"zm":[{"min":4}],"zmDK":[{"min":10.5}],"mg":[{"zhi":1}],"mf":[{"zhi":0.8}],"hp":[{"ti":30}],"wf":[{"ti":0.6}],"xyDK":[{"ti":2.5}]}; 
//	console.log($.jsonUtil.toJsonString(ans));
	assert.ok( $.jsonUtil.toJsonString(expect) == $.jsonUtil.toJsonString(ans), "Passed!" );
});


