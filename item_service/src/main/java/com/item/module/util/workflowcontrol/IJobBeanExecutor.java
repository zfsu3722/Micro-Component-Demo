package com.item.module.util.workflowcontrol;

import com.item.entities.NodeConfig;

import java.util.HashMap;
import java.util.Map;

public interface IJobBeanExecutor {
    public Map<String,Object> ExecuteJobBean(HashMap<String,Object> inParamsMap);
}
