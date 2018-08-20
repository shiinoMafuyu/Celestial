/******************************************************************
 * DemoController.java
 * Copyright 2017 by WZG. All Rights Reserved.
 * CreateDate：2017年8月10日
 * Author：wangzg
 * Version：1.0.0
 ******************************************************************/

package com.celestial.meek.realTest_2017_08.junitread;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.celestial.meek.realTest_2017_08.junitread.entity.FieldComparisonFailure;
import com.celestial.meek.realTest_2017_08.junitread.service.TestProjectService;

/**
 * <b>修改记录：</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2017年8月10日
 * </li>
 * </p>
 * 
 * <b>类说明：</b>
 * <p> 
 * 
 * </p>
 */
public class DemoController {
	@Autowired
    private TestProjectService testProjectService;

    @RequestMapping(value = "jsonCompare", method = RequestMethod.POST)
    @ResponseBody
    public List<FieldComparisonFailure> jsonCompare(@RequestParam("expect") String expect, @RequestParam("actual") String actual, ModelMap model,
            HttpSession session) {

        List<FieldComparisonFailure> list = testProjectService.compare(expect, actual);

        return list;
        
    }
}
