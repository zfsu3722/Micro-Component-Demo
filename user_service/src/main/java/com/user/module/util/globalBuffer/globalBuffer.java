package com.user.module.util.globalBuffer;

import java.util.concurrent.ConcurrentHashMap;

public class globalBuffer {
    public static ConcurrentHashMap<String,Object> paramBuffer;
    public globalBuffer(){
        paramBuffer = new ConcurrentHashMap<String,Object>();
    }

}
