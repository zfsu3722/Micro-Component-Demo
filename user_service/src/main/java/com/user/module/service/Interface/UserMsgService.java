package com.user.module.service.Interface;

import java.util.Map;

public interface UserMsgService {
    public Map getCouponsByUser(String loginName) throws Exception;
    public Map deleteCouponByMsg(String loginName,String couponId) throws Exception;
}
