package com.cart.module.util.common;

import com.cart.entities.OutData;
import com.cart.entities.OutputParam;
import com.cart.module.util.httpInvoke.Interface.AcceptMassage;

import java.util.HashMap;
import java.util.List;

public class ParseOutSend {
    private static final String KEY_SPLIT = ".";
    public static HashMap<String,Object> parseDestRef(OutputParam outputParam, String preKey, HashMap<String,Object> funcParam){
        HashMap<String,Object> outMap = new HashMap<>();
        String destRef = outputParam.getDestRef();
        List<OutData> outDatas = outputParam.getOutDatas();
        for (OutData o : outDatas){
            String funcParamId = o.getFuncParamId();
            String destParamId = o.getDestParamId();
            String key = preKey + KEY_SPLIT + destParamId;
            outMap.put(key,funcParam.get(funcParamId));
        }
        HashMap<String,Object> returnMap = sendToDest(destRef,outMap);
        return returnMap;
    }
    public static HashMap<String,Object> sendToDest(String destRef,HashMap<String,Object> outMap){
        AcceptMassage acceptMassage;
        System.out.println("destination"+destRef);
        System.out.println("destination"+outMap.toString());
        acceptMassage = (AcceptMassage) SpringContextUtil.getBean(destRef);
        HashMap<String,Object> returnMap =  acceptMassage.acceptMassage(outMap);
        return returnMap;
    }
}
