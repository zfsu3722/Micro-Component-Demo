package com.cart.module.executor;

import com.cart.module.service.impl.ShoppingCartServiceImpl;
import com.cart.module.util.common.PublicConstant;
import com.cart.module.util.workflowcontrol.IJobBeanExecutor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service("getGoodsForMailFunc")
public class GetAllGoods implements IJobBeanExecutor {
    @Override
    public Map<String, Object> ExecuteJobBean(HashMap<String, Object> inParamsMap) {
        ShoppingCartServiceImpl shoppingCartService = new ShoppingCartServiceImpl();
        HashMap<String,Object> retMap;
        retMap = shoppingCartService.getAllGoods();
        retMap.put(PublicConstant.SEND_FLAG,PublicConstant.NO_SEND_FLAG);
        return retMap;
    }
}
