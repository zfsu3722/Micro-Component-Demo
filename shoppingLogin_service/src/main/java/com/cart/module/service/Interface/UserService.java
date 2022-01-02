package com.cart.module.service.Interface;

import java.util.HashMap;

public interface UserService {
    HashMap<String, Object> findByPhoneAndPwd(String name, String pwd);
}
