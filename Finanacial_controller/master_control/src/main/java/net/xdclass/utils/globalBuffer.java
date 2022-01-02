package net.xdclass.utils;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class globalBuffer {
    public static ConcurrentHashMap<String,Object> globalBufferMap;

    public globalBuffer(){
        globalBufferMap = new ConcurrentHashMap<>();
    }

}
