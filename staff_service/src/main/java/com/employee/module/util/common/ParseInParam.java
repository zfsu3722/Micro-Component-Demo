package com.employee.module.util.common;

import com.employee.entities.Context;
import com.employee.entities.InputParam;
import com.employee.entities.NodeConfig;
import com.employee.module.util.globalBuffer.globalBuffer;

import java.util.HashMap;
import java.util.List;

public class ParseInParam {

    private static final String KEY_SPLIT = ".";
    private static final String LOCAL_MAP = "LOCAL_MAP";
    private static final String CONTROL_MAP = "CONTROL_MAP";
    public HashMap<String,Object> inParamsMap = new HashMap<>();

    public HashMap<String,Object> inParam(NodeConfig nodeConfig, HashMap<String, Object> control_data){
        //all config msg
        Context context;
        String requestId;
        String sourceNodeId;
        String sourceParamId;
        String funcParamId;
        String paramType;
        String memCache;
        String old_preKey;
        String now_preKey;
        String old_realKey;
        String now_realKey;

        requestId = nodeConfig.getRequestId();
        context = nodeConfig.getContext();
        List<InputParam> inParams = nodeConfig.getInParams();
        for (InputParam param : inParams){
            //transferParam(context,requestId,param,control_data);
            sourceNodeId = param.getSourceNodeId();
            sourceParamId = param.getSourceParamId();
            funcParamId = param.getFuncParamId();
            paramType = param.getParamType();//This parameter is temporarily useless
            memCache = param.getMemCache();
            old_preKey = context.getAppId() + KEY_SPLIT + context.getTaskId() + KEY_SPLIT + sourceNodeId + KEY_SPLIT + requestId;
            //now_preKey = context.getAppId() + KEY_SPLIT + context.getTaskId() + KEY_SPLIT + context.getNodeId() + KEY_SPLIT + requestId;
            old_realKey = old_preKey + KEY_SPLIT + sourceParamId;
            //now_realKey = now_preKey + KEY_SPLIT + funcParamId;
            if (memCache.equals(LOCAL_MAP)){
                inParamsMap.put(funcParamId,globalBuffer.paramBuffer.get(old_realKey));

            }
            if (memCache.equals(CONTROL_MAP)){
                inParamsMap.put(funcParamId,control_data.get(old_realKey));
            }
        }
        return inParamsMap;
    }

}


