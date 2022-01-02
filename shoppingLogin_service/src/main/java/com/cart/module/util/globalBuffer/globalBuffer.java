package com.cart.module.util.globalBuffer;

import java.util.concurrent.ConcurrentHashMap;

/**
 *
 */
public class globalBuffer {
    public static ConcurrentHashMap<String,Object> paramBuffer;
    public globalBuffer(){
        paramBuffer = new ConcurrentHashMap<String,Object>();
    }

}
