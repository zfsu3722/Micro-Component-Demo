package com.user.module.util.common;


import com.user.entities.Context;

public class ParseContextForFunc {
    public static final String KEY_SPLIT = ".";

    public static String PreKey(Context context){
        String pre_key = null;
        String appId = context.getAppId();
        String taskId = context.getTaskId();
        String nodeId = context.getNodeId();
        pre_key = appId + KEY_SPLIT + taskId + KEY_SPLIT + nodeId;
        return pre_key;
    }


}
