package com.item.module.util.httpInvoke.serviceImpl;

import com.item.entities.Context;
import com.item.module.util.common.ParseContextForFunc;
import com.item.module.util.workflowcontrol.MainWorkFlowController;

import java.util.HashMap;
import java.util.Map;


public class ParseData {

    private static final String REQUEST_ID = "requestId";
    private static final String APP_ID = "appId";
    private static final String TASK_ID = "taskId";
    private static final String NODE_ID = "nodeId";
    private static final String PARAM_MAP = "paramMap";

    public Map<String,Object> parseDataControl(HashMap<String, Object> massage){
        String requestId;
        String appId;
        String taskId;
        String nodeId;
        String xmlKey;
        HashMap<String, Object> control_param = null;
        Map<String,Object> returnData = null;

        requestId = (String) massage.get(REQUEST_ID);
        appId = (String) massage.get(APP_ID);
        taskId = (String) massage.get(TASK_ID);
        nodeId = (String) massage.get(NODE_ID);
        if (massage.containsKey(PARAM_MAP)){
            control_param = (HashMap<String, Object>) massage.get(PARAM_MAP);
        }

        Context context = new Context(appId,taskId,nodeId);
        xmlKey = ParseContextForFunc.PreKey(context);
        try {
            returnData = MainWorkFlowController.JobExececute(xmlKey,requestId,control_param);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return returnData;
    }
}


