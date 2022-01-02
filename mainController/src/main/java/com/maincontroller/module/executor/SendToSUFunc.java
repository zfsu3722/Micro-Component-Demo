package com.maincontroller.module.executor;

import com.maincontroller.module.controller.DealRequestBodyMsg;
import com.maincontroller.module.util.aboutHttpInvoke.Interface.AcceptMassage;
import com.maincontroller.module.util.common.SpringContextUtil;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.maincontroller.module.util.workflowcontrol.MainWorkFlowController.*;
import static com.maincontroller.module.util.workflowcontrol.MainWorkFlowController.NODE_ID;
@Service("sendToSUFunc")
public class SendToSUFunc implements LocalNodeService{
    private final static String OUT_RSC_LOGIN_NAME = "rsc_loginName";
    @Override
    public HashMap executeLocal(Map<String, Object> paramMap) throws Exception {
        HttpServletRequest request;
        DealRequestBodyMsg dealRequestBodyMsg = new DealRequestBodyMsg();
        HashMap<String,Object> returnMap;
        AcceptMassage acceptMassage;
        HashMap<String,Object> bodyMsg_map;
        HashMap<String,Object> sendMap = new HashMap<>();
        String requestId;
        String appId;
        String taskId;
        String nodeId;
        String key;
        int flag;

        requestId = (String) paramMap.get(REQUEST_ID);
        appId = (String) paramMap.get(APP_ID);
        taskId = (String) paramMap.get(TASK_ID);
        nodeId = (String) paramMap.get(NODE_ID);
        key = appId+SPLIT+taskId+SPLIT+nodeId+SPLIT+requestId+SPLIT+OUT_RSC_LOGIN_NAME;

        request = (HttpServletRequest) paramMap.get(REQUEST_KEY);
        bodyMsg_map = dealRequestBodyMsg.requestBodyToMap(request);
        String loginName = (String) bodyMsg_map.get("loginName");
        sendMap.put(key,loginName);

        acceptMassage = (AcceptMassage) SpringContextUtil.getBean("shoppingCart_service");
        returnMap = acceptMassage.acceptMassage(sendMap);
        flag = (int) returnMap.get("flag");
        if (flag == 1){
            acceptMassage = (AcceptMassage) SpringContextUtil.getBean("user_service");
            returnMap = acceptMassage.acceptMassage(sendMap);
        }
        return returnMap;
    }
}
