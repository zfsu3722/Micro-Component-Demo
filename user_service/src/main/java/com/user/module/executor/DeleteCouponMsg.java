package com.user.module.executor;

import com.user.entities.Context;
import com.user.entities.NodeConfig;
import com.user.module.service.impl.UserMsgServiceImpl;
import com.user.module.util.common.ParseContextForFunc;
import com.user.module.util.common.PublicConstant;
import com.user.module.util.globalBuffer.globalBuffer;
import com.user.module.util.workflowcontrol.IJobBeanExecutor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service("deleteCouponFunc")
public class DeleteCouponMsg implements IJobBeanExecutor {
    private final static String IN_LOGIN_NAME = "loginName";
    private final static String IN_COUPON_ID = "couponId";
    @Override
    public Map<String, Object> ExecuteJobBean(HashMap<String,Object> inParamsMap) {
        UserMsgServiceImpl userMsgService = new UserMsgServiceImpl();
        String loginName;
        String couponId;
        HashMap<String,Object> retMap;

        loginName = (String) inParamsMap.get(IN_LOGIN_NAME);
        couponId = (String) inParamsMap.get(IN_COUPON_ID);
        retMap = (HashMap<String, Object>) userMsgService.deleteCouponByMsg(loginName,couponId);
        retMap.put(PublicConstant.SEND_FLAG,PublicConstant.NO_SEND_FLAG);
        return retMap;
    }
}
