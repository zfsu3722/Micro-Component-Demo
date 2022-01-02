package com.reimbursement.module.util.workflowcontrol;

import com.reimbursement.entities.NodeConfig;

import java.util.HashMap;
import java.util.Map;

public interface IJobBeanExecutor {
    public Map<String,Object> ExecuteJobBean(HashMap<String,Object> inParamsMap);
}
