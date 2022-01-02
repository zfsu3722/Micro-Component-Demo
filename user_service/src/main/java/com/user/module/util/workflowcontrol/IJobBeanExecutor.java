package com.user.module.util.workflowcontrol;

import com.user.entities.NodeConfig;

import java.util.HashMap;
import java.util.Map;

public interface IJobBeanExecutor {
    public Map<String,Object> ExecuteJobBean(HashMap<String,Object> inParamsMap);
}
