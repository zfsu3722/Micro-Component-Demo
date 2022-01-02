package com.reimbursement.entities;

public class InputParam {
    private String sourceNodeId;
    private String sourceParamId;
    private String funcParamId;
    private String paramType;
    private String memCache;

    public InputParam(){}

    public InputParam(String sourceNodeId, String sourceParamId, String funcParamId, String paramType, String memCache) {
        this.sourceNodeId = sourceNodeId;
        this.sourceParamId = sourceParamId;
        this.funcParamId = funcParamId;
        this.paramType = paramType;
        this.memCache = memCache;
    }

    public String getSourceNodeId() {
        return sourceNodeId;
    }

    public void setSourceNodeId(String sourceNodeId) {
        this.sourceNodeId = sourceNodeId;
    }

    public String getSourceParamId() {
        return sourceParamId;
    }

    public void setSourceParamId(String sourceParamId) {
        this.sourceParamId = sourceParamId;
    }

    public String getFuncParamId() {
        return funcParamId;
    }

    public void setFuncParamId(String funcParamId) {
        this.funcParamId = funcParamId;
    }

    public String getParamType() {
        return paramType;
    }

    public void setParamType(String paramType) {
        this.paramType = paramType;
    }

    public String getMemCache() {
        return memCache;
    }

    public void setMemCache(String memCache) {
        this.memCache = memCache;
    }
}
