package com.join.module.util.httpInvoke.Interface;


import java.util.HashMap;


public interface AcceptMassage {
    //接收普通数据
    public HashMap<String,Object> acceptMassage(HashMap<String,Object> massage);
    //接收普通数据
    public HashMap<String,Object> acceptCommand(HashMap<String,Object> massage);
}
