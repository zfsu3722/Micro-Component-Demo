package com.reimbursement.module.util.executor;
import com.reimbursement.entities.Context;
import com.reimbursement.entities.NodeConfig;
import com.reimbursement.entities.OutputParam;
import com.reimbursement.module.service.impl.ItemRefundServiceImpl;
import com.reimbursement.module.util.common.ParseContextForFunc;
import com.reimbursement.module.util.common.ParseOutSend;
import com.reimbursement.module.util.common.PublicConstant;
import com.reimbursement.module.util.globalBuffer.globalBuffer;
import com.reimbursement.module.util.workflowcontrol.IJobBeanExecutor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RefundListFunc implements IJobBeanExecutor {
    private static final String ITEM_ID = "itemId";
    private HashMap<String,Object> funcOut = new HashMap<>();
    @Override
    public Map<String,Object> ExecuteJobBean(HashMap<String,Object> inParamsMap) {
        String itemId;
        Map<String,Object> returnData = null;
        int flag = 0;
        itemId = (String) inParamsMap.get(ITEM_ID);

        ItemRefundServiceImpl itemRefundService = new ItemRefundServiceImpl();
        List<Map> data = null;
        try {
            data = itemRefundService.queryByItemId(itemId);
            returnData = new HashMap<String,Object>();
            returnData.put("returnParam",data);
            flag = 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(data);
        returnData.put("flag",flag);
        returnData.put(PublicConstant.SEND_FLAG,PublicConstant.NO_SEND_FLAG);
        return returnData;
    }

}
