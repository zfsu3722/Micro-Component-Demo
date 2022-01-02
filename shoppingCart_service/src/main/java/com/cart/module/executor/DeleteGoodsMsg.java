package com.cart.module.executor;

import com.cart.entities.Context;
import com.cart.entities.NodeConfig;
import com.cart.module.service.impl.ShoppingCartServiceImpl;
import com.cart.module.util.common.ParseContextForFunc;
import com.cart.module.util.common.PublicConstant;
import com.cart.module.util.globalBuffer.globalBuffer;
import com.cart.module.util.workflowcontrol.IJobBeanExecutor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service("deleteGoodsFunc")
public class DeleteGoodsMsg implements IJobBeanExecutor {
    private final static String IN_LOGIN_NAME = "loginName";
    private final static String IN_GOODS_ID = "goodsId";
    @Override
    public Map<String, Object> ExecuteJobBean(HashMap<String,Object> inParamsMap) {
        ShoppingCartServiceImpl shoppingCartService = new ShoppingCartServiceImpl();
        String loginName;
        String goodsId;
        HashMap<String,Object> retMap;

        loginName = (String) inParamsMap.get(IN_LOGIN_NAME);
        goodsId = (String) inParamsMap.get(IN_GOODS_ID);
        retMap = shoppingCartService.deleteGoodsByMsg(loginName,goodsId);
        retMap.put(PublicConstant.SEND_FLAG,PublicConstant.NO_SEND_FLAG);
        return retMap;
    }
}
