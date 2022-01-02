package com.join.module.util.executor;

import com.join.entities.Context;
import com.join.entities.NodeConfig;
import com.join.entities.OutputParam;
import com.join.module.util.common.ParseContextForFunc;
import com.join.module.util.common.ParseOutSend;
import com.join.module.util.common.PublicConstant;
import com.join.module.util.globalBuffer.globalBuffer;
import com.join.module.util.workflowcontrol.IJobBeanExecutor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service("getMsgJoinFunc")
public class ShoppingCartJoin implements IJobBeanExecutor {
    private static final String IN_GOODS_LIST = "goodsList";
    private static final String IN_COUPONS_LIST = "couponsList";
    private static final String OUT_JOIN_LIST = "joinList";
    private static final String joinKey = "goodsType";
    @Override
    public Map<String, Object> ExecuteJobBean(HashMap<String,Object> inParamsMap) {
        HashMap<String,Object> funcOut;
        List<HashMap> goodsList_list;
        List<HashMap> couponsList_list;
        JoinList_Map joinList_map = new JoinList_Map();

        goodsList_list = (List<HashMap>) inParamsMap.get(IN_GOODS_LIST);
        couponsList_list = (List<HashMap>) inParamsMap.get(IN_COUPONS_LIST);
        funcOut = new HashMap<>();
        List<HashMap> joinList = joinList_map.joinByJoinKey(goodsList_list,couponsList_list,joinKey);
        funcOut.put(OUT_JOIN_LIST,joinList);
        funcOut.put(PublicConstant.SEND_FLAG,PublicConstant.YES_SEND_FLAG);

        return funcOut;
    }

}
