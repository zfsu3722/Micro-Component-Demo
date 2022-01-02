package com.common.entities;

import java.util.HashMap;
import java.util.List;

public class NodeConfig {
    private Context context;
    //The name of the method called
    private String functionRef;
    private List<InputParam> inParams;
    //<funcParamId,OutputParam>
    private HashMap<String,OutputParam> outParam;
    private String returnMsg;

    public NodeConfig(){}

    public NodeConfig(Context context, String functionRef, List<InputParam> inParams, HashMap<String, OutputParam> outParam, String returnMsg) {
        this.context = context;
        this.functionRef = functionRef;
        this.inParams = inParams;
        this.outParam = outParam;
        this.returnMsg = returnMsg;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public String getFunctionRef() {
        return functionRef;
    }

    public void setFunctionRef(String functionRef) {
        this.functionRef = functionRef;
    }

    public List<InputParam> getInParams() {
        return inParams;
    }

    public void setInParams(List<InputParam> inParams) {
        this.inParams = inParams;
    }

    public HashMap<String, OutputParam> getOutParam() {
        return outParam;
    }

    public void setOutParam(HashMap<String, OutputParam> outParam) {
        this.outParam = outParam;
    }

    public String getReturnMsg() {
        return returnMsg;
    }

    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }
}
