package com.user.module.service.impl;

import com.user.module.mapper.UserMsgMapper;
import com.user.module.service.Interface.UserMsgService;
import com.user.module.util.common.SpringContextUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMsgServiceImpl implements UserMsgService {
    UserMsgMapper userMsgMapper = (UserMsgMapper) SpringContextUtil.getBean("UserMsgMapper");
    @Override
    public HashMap getCouponsByUser(String loginName){
        List<Map> dbList;
        HashMap<String,Object> retMap = new HashMap<>();
        int flag;
        try {
            dbList = userMsgMapper.getCouponsByUser(loginName);
            flag = 1;
            retMap.put("flag",flag);
            retMap.put("retMsg",dbList);
        } catch (Exception e) {
            e.printStackTrace();
            flag = 0;
            retMap.put("flag",flag);
        }
        return retMap;
    }

    @Override
    public Map deleteCouponByMsg(String loginName, String couponId) {
        HashMap<String,Object> retMap = new HashMap<>();
        int flag;
        try {
            userMsgMapper.deleteCouponByMsg(loginName,couponId);
            flag = 1;
            retMap.put("flag",flag);
        } catch (Exception e) {
            e.printStackTrace();
            flag = 0;
            retMap.put("flag",flag);
        }
        return retMap;
    }
}
