/******************************************************************
 * JacksonMapper.java
 * Copyright 2017 by WZG. All Rights Reserved.
 * CreateDate：2017年9月7日
 * Author：wangzg
 * Version：1.0.0
 ******************************************************************/

package com.celestial.agniRadiance.EzUtil.test.jackson;

import org.codehaus.jackson.map.ObjectMapper;

/**
 * <b>修改记录：</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2017年9月7日
 * </li>
 * </p>
 * 
 * <b>类说明：</b>
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
