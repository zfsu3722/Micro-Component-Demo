package com.cart.module.util.httpInvoke.Interface;


import java.util.HashMap;

public interface AcceptMassage {

    public HashMap<String,Object> acceptMassage(HashMap<String,Object> massage);

    public HashMap<String,Object> acceptCommand(HashMap<String,Object> massage);
}
