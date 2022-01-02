package net.xdclass.utils;

import java.util.Map;

public class SequenceCache {
    private  static Map<String,Object> sequenceMap=null;

    public static void setSequenceMap(Map<String,Object> sequenceMapInput)
    {
        sequenceMap=sequenceMapInput;
    }
    public static Map<String,Object> getSequenceMap(){
        return sequenceMap;
    }

    public static Object getSequence(String taskId){
        return sequenceMap.get(taskId);
    }

}

