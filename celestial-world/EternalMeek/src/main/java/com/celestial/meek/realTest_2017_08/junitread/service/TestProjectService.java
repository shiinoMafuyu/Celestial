/******************************************************************
 * TestProjectService.java
 * Copyright 2017 by WZG. All Rights Reserved.
 * CreateDate��2017��8��10��
 * Author��wangzg
 * Version��1.0.0
 ******************************************************************/

package com.celestial.meek.realTest_2017_08.junitread.service;

import java.util.List;

import com.celestial.meek.realTest_2017_08.junitread.entity.FieldComparisonFailure;

/**
 * <b>�޸ļ�¼��</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2017��8��10��
 * </li>
 * </p>
 * 
 * <b>��˵����</b>
 * <p> 
 * 
 * </p>
 */
public interface TestProjectService {
	public List<FieldComparisonFailure> compare(String expect, String actual);
}
