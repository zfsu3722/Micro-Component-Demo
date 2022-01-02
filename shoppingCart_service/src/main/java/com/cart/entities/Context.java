package com.cart.entities;

import java.io.Serializable;

public class Context implements Serializable {

    private String appId;
    private String taskId;
    private String nodeId;

    public Context() {}
    public Context(String appId, String taskId, String nodeId) {
        this.appId = appId;
        this.taskId = taskId;
        this.nodeId = nodeId;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }
}
