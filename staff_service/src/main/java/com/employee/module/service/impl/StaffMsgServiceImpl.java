package com.employee.module.service.impl;

import com.employee.module.mapper.StaffMsgMapper;
import com.employee.module.service.interfaces.StaffMsgService;
import com.employee.module.util.common.SpringContextUtil;

import java.util.HashMap;
import java.util.List;

public class StaffMsgServiceImpl implements StaffMsgService {

    StaffMsgMapper staffMsgMapper = (StaffMsgMapper) SpringContextUtil.getBean("StaffMsgMapper");
    @Override
    public HashMap queryStaffMsgByItemId(String empNo) throws Exception {
        HashMap<String,Object> dbMap;
        dbMap = staffMsgMapper.queryStaffMsgByItemId(empNo);
        return dbMap;
    }
}
