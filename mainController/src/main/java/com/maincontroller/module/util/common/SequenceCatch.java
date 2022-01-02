package com.maincontroller.module.util.common;

import com.common.entities.NodeBean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SequenceCatch {
    private static Map<String,Object> sequenceMap = new HashMap<String,Object>();

    public static void setSequenceMap(String taskId, List<NodeBean> sequence){
        sequenceMap.put(taskId,sequence);
    }

    public static List<NodeBean> getSequence(String taskId){
        List<NodeBean> sequence;
        sequence = (List<NodeBean>) sequenceMap.get(taskId);
        return sequence;
    }

}
