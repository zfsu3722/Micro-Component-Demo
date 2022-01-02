package com.maincontroller.module.executor;

import com.maincontroller.module.controller.DealRequestBodyMsg;
import com.maincontroller.module.util.aboutHttpInvoke.Interface.AcceptMassage;
import com.maincontroller.module.util.common.SpringContextUtil;
import net.sf.json.JSONArray;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import static com.maincontroller.module.util.workflowcontrol.MainWorkFlowController.*;

@Service("shop_service")
public class ShopLoginLocalNode implements LocalNodeService {

    public static final String USER_NAME_KEY="IdForUserName";
    public static final String PASS_WORD_KEY="IdForPassWord";

    @Override
    public HashMap executeLocal(Map<String, Object> paramMap) throws Exception {
        HttpServletRequest request;
        HttpServletResponse response;
        DealRequestBodyMsg dealRequestBodyMsg = new DealRequestBodyMsg();
        HashMap<String,Object> resultMap;
        AcceptMassage acceptMassage;
        HashMap<String,Object> bodyMsg_map;
        HashMap<String,Object> sendMap = new HashMap<>();
        String requestId;
        String appId;
        String taskId;
        String nodeId;
        String key;
        String userNameKey;
        String passwordKey;
        String userName;
        String passWord;
        int flag;

        requestId = (String) paramMap.get(REQUEST_ID);
        appId = (String) paramMap.get(APP_ID);
        taskId = (String) paramMap.get(TASK_ID);
        nodeId = (String) paramMap.get(NODE_ID);
        key = appId+SPLIT+taskId+SPLIT+nodeId+SPLIT+requestId+SPLIT;
        userNameKey = key + USER_NAME_KEY;
        passwordKey = key + PASS_WORD_KEY;

        request = (HttpServletRequest) paramMap.get(REQUEST_KEY);
        bodyMsg_map = dealRequestBodyMsg.requestBodyToMap(request);
        userName=(String) bodyMsg_map.get(USER_NAME_KEY);
        passWord=(String) bodyMsg_map.get(PASS_WORD_KEY);
        bodyMsg_map.clear();
        bodyMsg_map.put(userNameKey,userName);
        bodyMsg_map.put(passwordKey,passWord);
        sendMap.put(APP_ID,appId);
        sendMap.put(TASK_ID,taskId);
        sendMap.put(NODE_ID,nodeId);
        sendMap.put(REQUEST_ID,requestId);
        sendMap.put("paramMap",bodyMsg_map);

        acceptMassage =(AcceptMassage) SpringContextUtil.getBean("login_service");
        resultMap=acceptMassage.acceptCommand(sendMap);
        HashMap<String,Object> responseMap = new HashMap<>();
        responseMap.put("userName",resultMap.get("loginName"));
        responseMap.put("responseMsg",resultMap.get("responseMsg"));
        response = (HttpServletResponse) paramMap.get(RESPONSE_KEY);
        try{
            response.setHeader("Content-type", "application/json;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            JSONArray jsonArray = JSONArray.fromObject(responseMap);
            PrintWriter writer=response.getWriter();
            writer.print(jsonArray);
            writer.close();
            response.flushBuffer();

        }catch (Exception e){
            e.printStackTrace();
        }
        return resultMap;
    }
}
