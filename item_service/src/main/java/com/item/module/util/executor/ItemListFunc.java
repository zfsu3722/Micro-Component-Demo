package com.item.module.util.executor;

import com.item.entities.Context;
import com.item.entities.NodeConfig;
import com.item.entities.OutputParam;
import com.item.module.service.impl.ItemListServiceImpl;
import com.item.module.util.common.ParseContextForFunc;
import com.item.module.util.common.ParseOutSend;
import com.item.module.util.common.PublicConstant;
import com.item.module.util.workflowcontrol.IJobBeanExecutor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service("getItemListFunc")
public class ItemListFunc implements IJobBeanExecutor {
    private static final String EMP_NO = "empNo";
    private static final String ITEM_LIST = "itemList";
    @Override
    public Map<String, Object> ExecuteJobBean(HashMap<String,Object> inParamsMap) {
        ItemListServiceImpl itemListService = new ItemListServiceImpl();
        List<Map> list = null;
        List<String> empNo_list;
        HashMap<String,Object> funcOut;

        empNo_list = new ArrayList<>();
        funcOut = new HashMap<>();
        try {
            list = itemListService.queryAllItem();
            for (Map map : list){
                String s = (String) map.get(EMP_NO);
                empNo_list.add(s);
            }
            funcOut.put(EMP_NO,empNo_list);
            funcOut.put(ITEM_LIST,list);
            funcOut.put(PublicConstant.SEND_FLAG,PublicConstant.YES_SEND_FLAG);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return funcOut;
    }
}
