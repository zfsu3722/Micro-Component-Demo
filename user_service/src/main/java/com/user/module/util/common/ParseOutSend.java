package com.user.module.util.common;
import com.user.entities.OutData;
import com.user.entities.OutputParam;
import com.user.module.util.httpInvoke.Interface.AcceptMassage;
import com.user.module.util.workflowcontrol.MainWorkFlowController;

import java.util.HashMap;
import java.util.List;

public class ParseOutSend {
    private static final String KEY_SPLIT = ".";
    public static HashMap<String,Object> parseDestRef(OutputParam outputParam, String preKey, HashMap<String,Object> funcParam){
        HashMap<String,Object> outMap = new HashMap<>();
        String destRef = outputParam.getDestRef();
        List<OutData> outDatas = outputParam.getOutDatas();
        String keyPrefix="";
        if(!destRef.equals(MainWorkFlowController.CONTROL_FLAG))
        {
            keyPrefix=preKey + KEY_SPLIT;
        }
        for (OutData o : outDatas){
            String funcParamId = o.getFuncParamId();
            String destParamId = o.getDestParamId();
            String key = keyPrefix + destParamId;
            outMap.put(key,funcParam.get(funcParamId));
        }
        return outMap;
    }
    public static HashMap<String,Object> sendToDest(String destRef,HashMap<String,Object> outMap){
        AcceptMassage acceptMassage;
        System.out.println("Destination:"+destRef);
        System.out.println("Data:"+outMap.toString());
        acceptMassage = (AcceptMassage) SpringContextUtil.getBean(destRef);
        HashMap<String,Object> returnMap =  acceptMassage.acceptMassage(outMap);
        return returnMap;
    }
}
