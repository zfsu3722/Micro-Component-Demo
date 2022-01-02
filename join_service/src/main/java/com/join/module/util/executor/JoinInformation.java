package com.join.module.util.executor;

import com.join.entities.Context;
import com.join.entities.NodeConfig;
import com.join.entities.OutputParam;
import com.join.module.util.common.ParseContextForFunc;
import com.join.module.util.common.ParseOutSend;
import com.join.module.util.common.PublicConstant;
import com.join.module.util.globalBuffer.globalBuffer;
import com.join.module.util.workflowcontrol.IJobBeanExecutor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service("getJoinInfoFunc")
public class JoinInformation implements IJobBeanExecutor {

    private static final String IN_ITEM_LIST = "itemList";
    private static final String IN_STAFF_MSG = "staffMsg";
    private static final String JOIN_ITEM_LIST = "joinItemList";
    private static final String EMP_NO = "empNo";

    @Override
    public Map<String, Object> ExecuteJobBean(HashMap<String,Object> inParamsMap) {
        JoinList_Map joinList_map = new JoinList_Map();
        HashMap<String,Object> funcOut;
        List<HashMap> staffMsg_list;
        List<HashMap> itemMsg_list;

        itemMsg_list = (List<HashMap>) inParamsMap.get(IN_ITEM_LIST);
        staffMsg_list = (List<HashMap>) inParamsMap.get(IN_STAFF_MSG);
        System.out.println("itemMsg_list="+itemMsg_list);
        System.out.println("staffMsg_list="+staffMsg_list);
        funcOut = new HashMap<>();
        List<HashMap> joinList = joinList_map.joinByJoinKey(itemMsg_list,staffMsg_list,EMP_NO);
        //List<HashMap> joinList = joinMsg(staffMsg_list,itemMsg_list);
        funcOut.put(JOIN_ITEM_LIST,joinList);
        funcOut.put(PublicConstant.SEND_FLAG,PublicConstant.YES_SEND_FLAG);
        return funcOut;
    }

    /*public List<HashMap> joinMsg(List<HashMap> staffMsg_list,List<HashMap> itemMsg_list){
        //empNo ---> empName
        final String EMP_NO = "empNo";
        //final String EMP_NAME = "empName";
        for (HashMap itemMap : itemMsg_list){
            String I_empNo = (String) itemMap.get(EMP_NO);
            for (HashMap staffMap : staffMsg_list){
                String S_empNo = (String) staffMap.get(EMP_NO);
                if (I_empNo.equals(S_empNo)){
                    itemMap.putAll(staffMap);
                }
            }
            itemMap.remove(EMP_NO);

        }
        System.out.println(itemMsg_list);
        return itemMsg_list;
    }*/

}
