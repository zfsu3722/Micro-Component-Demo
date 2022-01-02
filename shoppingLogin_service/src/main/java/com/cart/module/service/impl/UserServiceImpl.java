package com.cart.module.service.impl;



import com.cart.module.mapper.UserMapper;
import com.cart.module.service.Interface.UserService;
import com.cart.module.util.common.SpringContextUtil;

import java.util.HashMap;


public class UserServiceImpl implements UserService {

    UserMapper userMapper = (UserMapper) SpringContextUtil.getBean("UserMapper");

    @Override
    public HashMap<String, Object> findByPhoneAndPwd(String name, String pwd) {

        HashMap<String, Object> dbMap;

        dbMap =userMapper.findByPhoneAndPwd(name,pwd);
        dbMap.put("flag",1);
        dbMap.put("responseMsg","login successfully");
        dbMap.put("sendFlag","N");
        return dbMap;

    }
}
