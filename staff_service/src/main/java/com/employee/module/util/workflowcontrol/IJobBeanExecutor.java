package com.employee.module.util.workflowcontrol;


import com.employee.entities.NodeConfig;

import java.util.HashMap;
import java.util.Map;

public interface IJobBeanExecutor {
    public Map<String,Object> ExecuteJobBean(HashMap<String,Object> inParamsMap);
}
