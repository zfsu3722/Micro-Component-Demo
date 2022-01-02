package com.user.module.executor;

import com.user.entities.Context;
import com.user.entities.NodeConfig;
import com.user.entities.OutputParam;
import com.user.module.service.impl.UserMsgServiceImpl;
import com.user.module.util.common.ParseContextForFunc;
import com.user.module.util.common.ParseOutSend;
import com.user.module.util.common.PublicConstant;
import com.user.module.util.globalBuffer.globalBuffer;
import com.user.module.util.workflowcontrol.IJobBeanExecutor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("getCouponsFunc")
public class QueryCoupons implements IJobBeanExecutor {

    private static final String LOGIN_NAME = "loginName";
    private static final String OUT_COUPONS_LIST = "coupons_list";
    private static final String RET_MSG = "retMsg";
    private static final String FLAG = "flag";

    @Override
    public Map<String, Object> ExecuteJobBean(HashMap<String,Object> inParamsMap) {
        UserMsgServiceImpl userMsgService = new UserMsgServiceImpl();
        String loginName;
        HashMap<String,Object> retMap;
        List<Map> db_list;
        int flag;

        loginName = (String) inParamsMap.get(LOGIN_NAME);
        retMap = userMsgService.getCouponsByUser(loginName);
        flag = (int) retMap.get(FLAG);
        if (flag == 0){
            return retMap;
        }else if (flag == 1){
            db_list = (List<Map>) retMap.get(RET_MSG);
            retMap.clear();
            retMap.put(OUT_COUPONS_LIST,db_list);
            retMap.put(PublicConstant.SEND_FLAG, PublicConstant.YES_SEND_FLAG);
        }
        return retMap;
    }
}
