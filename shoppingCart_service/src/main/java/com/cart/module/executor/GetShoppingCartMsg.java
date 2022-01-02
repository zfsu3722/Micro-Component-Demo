package com.cart.module.executor;

import com.cart.entities.Context;
import com.cart.entities.NodeConfig;
import com.cart.entities.OutputParam;
import com.cart.module.service.impl.ShoppingCartServiceImpl;
import com.cart.module.util.common.ParseContextForFunc;
import com.cart.module.util.common.ParseOutSend;
import com.cart.module.util.common.PublicConstant;
import com.cart.module.util.globalBuffer.globalBuffer;
import com.cart.module.util.workflowcontrol.IJobBeanExecutor;
import com.cart.module.util.workflowcontrol.MainWorkFlowController;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service("getGoodsFunc")
public class GetShoppingCartMsg implements IJobBeanExecutor {
    private static final String LOGIN_NAME = "loginName";
    private static final String OUT_GOODS_LIST = "goods_list";
    private static final String RET_MSG = "retMsg";
    @Override
    public Map<String, Object> ExecuteJobBean(HashMap<String,Object> inParamsMap) {
        ShoppingCartServiceImpl shoppingCartService = new ShoppingCartServiceImpl();
        String loginName;
        HashMap<String,Object> retMap;
        List<Map> db_list;
        int flag;


        loginName = (String) inParamsMap.get(LOGIN_NAME);
        retMap = shoppingCartService.getGoodsByUser(loginName);
        flag = (int) retMap.get("flag");

        if (flag == 0){
            return retMap;
        }else if (flag == 1){
            db_list = (List<Map>) retMap.get(RET_MSG);
            retMap.clear();
            retMap.put(OUT_GOODS_LIST,db_list);
            retMap.put(PublicConstant.SEND_FLAG, PublicConstant.YES_SEND_FLAG);
        }
        return retMap;
    }

}
