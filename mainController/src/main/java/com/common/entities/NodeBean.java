package com.common.entities;

public class NodeBean {
    private String id;
    private String step;
    private String execRef;
    private String refTag;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;
    }

    public String getExecRef() {
        return execRef;
    }

    public void setExecRef(String execRef) {
        this.execRef = execRef;
    }

    public String getRefTag() {
        return refTag;
    }

    public void setRefTag(String refTag) {
        this.refTag = refTag;
    }
}
