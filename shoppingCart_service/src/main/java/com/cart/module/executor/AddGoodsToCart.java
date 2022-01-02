package com.cart.module.executor;

import com.cart.entities.Context;
import com.cart.entities.NodeConfig;
import com.cart.entities.OutputParam;
import com.cart.module.service.impl.ShoppingCartServiceImpl;
import com.cart.module.util.common.ParseContextForFunc;
import com.cart.module.util.common.PublicConstant;
import com.cart.module.util.globalBuffer.globalBuffer;
import com.cart.module.util.workflowcontrol.IJobBeanExecutor;
import com.cart.module.util.workflowcontrol.MainWorkFlowController;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service("addShoppingCartFunc")
public class AddGoodsToCart implements IJobBeanExecutor {
    private final static String IN_GOODS_MSG = "goodsMsg";
    @Override
    public Map<String, Object> ExecuteJobBean(HashMap<String,Object> inParamsMap) {
        ShoppingCartServiceImpl shoppingCartService = new ShoppingCartServiceImpl();
        HashMap<String,Object> goodsMsg;
        HashMap<String,Object> retMap;

        goodsMsg = (HashMap<String, Object>) inParamsMap.get(IN_GOODS_MSG);
        retMap = (HashMap<String, Object>) shoppingCartService.insertShoppingCart(goodsMsg);
        //retMap.put(PublicConstant.SEND_FLAG,PublicConstant.NO_SEND_FLAG);
        return retMap;
    }
}
