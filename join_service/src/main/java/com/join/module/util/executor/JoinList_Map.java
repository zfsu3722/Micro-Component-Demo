package com.join.module.util.executor;

import java.util.HashMap;
import java.util.List;

public class JoinList_Map {
    public List<HashMap> joinByJoinKey(List<HashMap> outerLoop_list, List<HashMap> innerLoop_list, String joinKey) {
        //goodsType  -->
        for (HashMap outerMap : outerLoop_list){
            String O_join_key = (String) outerMap.get(joinKey);
            if (O_join_key != null){
                for (HashMap innerMap : innerLoop_list){
                    String I_join_key = (String) innerMap.get(joinKey);
                    if (I_join_key != null){
                        if (O_join_key.equals(I_join_key)){
                            outerMap.putAll(innerMap);
                        }
                    }
                }
            }
            outerMap.remove(joinKey);
        }

        return outerLoop_list;
    }
}
