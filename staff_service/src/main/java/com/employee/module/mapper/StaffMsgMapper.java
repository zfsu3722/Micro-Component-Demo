package com.employee.module.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
@Mapper
@Repository("StaffMsgMapper")
public interface StaffMsgMapper {
    public HashMap queryStaffMsgByItemId(String empNo) throws Exception;
}
