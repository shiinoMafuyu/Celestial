/******************************************************************
 * JacksonMapper.java
 * Copyright 2017 by WZG. All Rights Reserved.
 * CreateDate��2017��9��7��
 * Author��wangzg
 * Version��1.0.0
 ******************************************************************/

package com.celestial.agniRadiance.EzUtil.test.jackson;

import org.codehaus.jackson.map.ObjectMapper;

/**
 * <b>�޸ļ�¼��</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2017��9��7��
 * </li>
 * </p>
 * 
 * <b>��˵����</b>
 * <p> 
 * 
 * </p>
 */
public class JacksonMapper {
    private static final ObjectMapper mapper = new ObjectMapper();  
    
    private JacksonMapper() {  
    }  
  
    public static ObjectMapper getInstance() {  
        return mapper;  
    } 
}
