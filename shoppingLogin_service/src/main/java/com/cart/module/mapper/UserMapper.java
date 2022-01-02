package com.cart.module.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Mapper
@Repository("UserMapper")
public interface UserMapper {

    HashMap findByPhoneAndPwd(@Param("loginName") String loginName, @Param("userPassword") String userPassword);

}
