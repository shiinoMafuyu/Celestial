/******************************************************************
 * FieldComparisonFailure.java
 * Copyright 2017 by WZG. All Rights Reserved.
 * CreateDate��2017��8��10��
 * Author��wangzg
 * Version��1.0.0
 ******************************************************************/

package com.celestial.meek.realTest_2017_08.junitread.entity;

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
public class FieldComparisonFailure {
	

    private final String field;
    private final Object expected;
    private final Object actual;

    public FieldComparisonFailure(String field, Object expected, Object actual) {
        this.field = field;
        this.expected = expected;
        this.actual = actual;
    }

    public String getField() {
        return field;
    }

    public Object getExpected() {
        return expected;
    }

    public Object getActual() {
        return actual;
    }


}
