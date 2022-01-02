package com.maincontroller.module.executor;

import com.maincontroller.module.controller.DealRequestBodyMsg;
import com.maincontroller.module.util.aboutHttpInvoke.Interface.AcceptMassage;
import com.maincontroller.module.util.common.SpringContextUtil;
import net.sf.json.JSONArray;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.maincontroller.module.util.workflowcontrol.MainWorkFlowController.*;

@Service("insertGoodsFunc")
public class InsertGoodsLocal implements LocalNodeService{
    private static final String OUT_GOODS_MAP = "goodsMap";
    private static final String PARAM_MAP = "paramMap";
    private static final String RET_MSG = "retMsg";
    private static final String FLAG = "flag";
    @Override
    public HashMap executeLocal(Map<String, Object> paramMap) throws Exception {
        HttpServletRequest request;
        HttpServletResponse response;
        DealRequestBodyMsg dealRequestBodyMsg = new DealRequestBodyMsg();
        HashMap<String,Object> returnMap = null;
        AcceptMassage acceptMassage;
        HashMap<String,Object> bodyMsg_map;
        HashMap<String,Object> sendMap = new HashMap<>();
        HashMap<String,Object> data = new HashMap<>();
        String requestId;
        String appId;
        String taskId;
        String nodeId;
        String key;
        List<String> list;
        int flag;
        //goodsMap

        requestId = (String) paramMap.get(REQUEST_ID);
        appId = (String) paramMap.get(APP_ID);
        taskId = (String) paramMap.get(TASK_ID);
        nodeId = (String) paramMap.get(NODE_ID);
        key = appId+SPLIT+taskId+SPLIT+nodeId+SPLIT+requestId+SPLIT+OUT_GOODS_MAP;
        response = (HttpServletResponse) paramMap.get(RESPONSE_KEY);
        request = (HttpServletRequest) paramMap.get(REQUEST_KEY);
        bodyMsg_map = dealRequestBodyMsg.requestBodyToMap(request);


        sendMap.put(REQUEST_ID,requestId);
        sendMap.put(APP_ID,appId);
        sendMap.put(TASK_ID,taskId);
        sendMap.put(NODE_ID,nodeId);
        data.put(key,bodyMsg_map);
        sendMap.put(PARAM_MAP,data);

        acceptMassage = (AcceptMassage) SpringContextUtil.getBean("shoppingCart_service");
        returnMap = acceptMassage.acceptCommand(sendMap);
        System.out.println(returnMap);
        flag = (int) returnMap.get(FLAG);
        if (flag == 1){
            list = new ArrayList<>();
            list.add((String) returnMap.get(RET_MSG));
            returnMap.clear();
            try{
                response.setHeader("Content-type", "application/json;charset=UTF-8");
                //response.setContentType("application/json: charset=utf-8");
                response.setCharacterEncoding("UTF-8");
                JSONArray jsonArray = JSONArray.fromObject(list);
                PrintWriter writer=response.getWriter();
                writer.print(jsonArray);
                writer.close();
                response.flushBuffer();
                System.out.println("*******************Data sent to front-end!*******************");
                flag = 0;
                returnMap.put(FLAG,flag);
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        return returnMap;
    }
}
