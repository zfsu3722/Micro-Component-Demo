package com.user.module.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;

@Mapper
@Repository("UserMsgMapper")
public interface UserMsgMapper {
    public List<Map> getCouponsByUser(String loginName) throws Exception;
    public void deleteCouponByMsg(String loginName,String couponId) throws Exception;
}
