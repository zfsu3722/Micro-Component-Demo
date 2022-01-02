package com.item.module.util.httpInvoke.Interface;

import java.util.HashMap;

public interface RpcMainController {
    public HashMap<String,Object> acceptMassage(HashMap<String,Object> massage);
    public HashMap<String,Object> acceptCommand(HashMap<String, Object> massage);
}
