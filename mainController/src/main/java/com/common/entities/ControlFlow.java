package com.common.entities;

import java.util.HashMap;
import java.util.List;

public class ControlFlow {
    private String taskId;
    private List<NodeBean> sequenceNode;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public List<NodeBean> getSequenceNode() {
        return sequenceNode;
    }

    public void setSequenceNode(List<NodeBean> sequenceNode) {
        this.sequenceNode = sequenceNode;
    }
}
