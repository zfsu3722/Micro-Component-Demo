package com.common.entities;

public class OutputParam {

    private String destinationId;
    private String funcParamId;
    // key of output parameter
    private String DestParamId;
    private String paramType;
    private String memCache;

    public OutputParam(){}

    public OutputParam(String destinationId, String funcParamId, String destParamId, String paramType, String memCache) {
        this.destinationId = destinationId;
        this.funcParamId = funcParamId;
        DestParamId = destParamId;
        this.paramType = paramType;
        this.memCache = memCache;
    }

    public String getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(String destinationId) {
        this.destinationId = destinationId;
    }

    public String getFuncParamId() {
        return funcParamId;
    }

    public void setFuncParamId(String funcParamId) {
        this.funcParamId = funcParamId;
    }

    public String getDestParamId() {
        return DestParamId;
    }

    public void setDestParamId(String destParamId) {
        DestParamId = destParamId;
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
