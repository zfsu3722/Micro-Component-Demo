package com.maincontroller.module.executor;

import com.maincontroller.module.controller.DealRequestBodyMsg;
import com.maincontroller.module.util.aboutHttpInvoke.Interface.AcceptMassage;
import com.maincontroller.module.util.common.SpringContextUtil;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

import static com.maincontroller.module.util.workflowcontrol.MainWorkFlowController.*;

@Service("sendToSUForClear")
public class SendToSUForClear implements LocalNodeService{
    private final static String OUT_RSC_LOGIN_NAME = "rsc_loginName";
    private final static String OUT_RSC_GOODS_ID = "rsc_goodsId";
    private final static String OUT_RSC_COUPON_ID = "rsc_couponId";
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
        String pre_key;
        String loginName;
        String couponId;
        String goodsId;
        String loginName_key;
        String couponId_key;
        String goodsId_key;
        int flag;

        requestId = (String) paramMap.get(REQUEST_ID);
        appId = (String) paramMap.get(APP_ID);
        taskId = (String) paramMap.get(TASK_ID);
        nodeId = (String) paramMap.get(NODE_ID);
        pre_key = appId+SPLIT+taskId+SPLIT+nodeId+SPLIT+requestId; //

        request = (HttpServletRequest) paramMap.get(REQUEST_KEY);
        bodyMsg_map = dealRequestBodyMsg.requestBodyToMap(request);
        loginName = (String) bodyMsg_map.get("loginName");
        couponId = (String) bodyMsg_map.get("couponId");
        goodsId = (String) bodyMsg_map.get("goodsId");
        loginName_key = pre_key+SPLIT+OUT_RSC_LOGIN_NAME;
        couponId_key = pre_key+SPLIT+OUT_RSC_COUPON_ID;
        goodsId_key = pre_key+SPLIT+OUT_RSC_GOODS_ID;


        sendMap.put(loginName_key,loginName);
        sendMap.put(goodsId_key,goodsId);
        acceptMassage = (AcceptMassage) SpringContextUtil.getBean("shoppingCart_service");
        returnMap = acceptMassage.acceptMassage(sendMap);
        flag = (int) returnMap.get("flag");
        if (flag == 1 && couponId != null){
            sendMap.clear();
            sendMap.put(loginName_key,loginName);
            sendMap.put(couponId_key,couponId);
            acceptMassage = (AcceptMassage) SpringContextUtil.getBean("user_service");
            returnMap = acceptMassage.acceptMassage(sendMap);
        }
        return returnMap;
    }
}
