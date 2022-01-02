package com.employee.module.util.executor;

import com.employee.entities.Context;
import com.employee.entities.NodeConfig;
import com.employee.entities.OutputParam;
import com.employee.module.service.impl.StaffMsgServiceImpl;
import com.employee.module.util.common.ParseContextForFunc;
import com.employee.module.util.common.ParseOutSend;
import com.employee.module.util.common.PublicConstant;
import com.employee.module.util.globalBuffer.globalBuffer;
import com.employee.module.util.workflowcontrol.IJobBeanExecutor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service("getStaffMsgFunc")
public class StaffMsgFunc implements IJobBeanExecutor {
    private static final String EMP_NO_LIST = "empNoList";
    private static final String OUT_STAFF_MSG = "staffMsg";
    @Override
    public Map<String, Object> ExecuteJobBean(HashMap<String,Object> inParamsMap) {
        StaffMsgServiceImpl staffMsgService = new StaffMsgServiceImpl();
        List<String> empNo_list;
        HashMap<String,Object> returnMap = null;
        HashMap<String,Object> dbMap;
        List<HashMap> sendList;
        HashMap<String,Object> funcOut;

        empNo_list = (List<String>) inParamsMap.get(EMP_NO_LIST);
        sendList = new ArrayList<>();
        funcOut = new HashMap<>();
        try {
            for (String empNo : empNo_list){
                dbMap = staffMsgService.queryStaffMsgByItemId(empNo);
                sendList.add(dbMap);
            }
            funcOut.put(OUT_STAFF_MSG,sendList);
            funcOut.put(PublicConstant.SEND_FLAG,PublicConstant.YES_SEND_FLAG);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return funcOut;
    }
}
