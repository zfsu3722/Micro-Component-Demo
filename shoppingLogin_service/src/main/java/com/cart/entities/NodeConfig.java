package com.cart.entities;

import java.util.List;

public class NodeConfig {
    private Context context;

    private String functionRef;
    private List<InputParam> inParams;

    private List<OutputParam> outParam;
    private String returnMsg;
    private String requestId;

    public NodeConfig(){}

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
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

    public List<OutputParam> getOutParam() {
        return outParam;
    }

    public void setOutParam(List<OutputParam> outParam) {
        this.outParam = outParam;
    }

    public String getReturnMsg() {
        return returnMsg;
    }

    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }
}
