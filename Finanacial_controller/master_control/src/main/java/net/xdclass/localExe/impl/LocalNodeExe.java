package net.xdclass.localExe.impl;


import com.fasterxml.jackson.databind.ObjectMapper;
import net.sf.json.JSONArray;
import net.xdclass.entity.NodeBean;

import net.xdclass.localExe.LocalExe;
import net.xdclass.remoteExe.aboutHttpInvoker.Interface.AcceptMassage;
import net.xdclass.utils.SpringContextUtil;
import net.xdclass.webController.MainController;
import org.springframework.stereotype.Service;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service("user_service")
public class LocalNodeExe implements LocalExe {

    public static final String IRL_ITEM_ID_KEY="IRL_itemId";

    @Override
    public  HashMap<String,Object> exeLocalNode(HashMap<String, Object> localMap) {
        HashMap<String,Object> resultMap;
        HashMap<String,Object> takeLocalMap;
        NodeBean localNodeBean;
        String execRef;
        HttpServletResponse localResponse;

        localNodeBean=(NodeBean) localMap.get(MainController.NODE_BEAN_KEY);
        execRef=localNodeBean.getExecRef();

        takeLocalMap=replaceMap(localMap);

        AcceptMassage acceptMassage =(AcceptMassage) SpringContextUtil.getBean("refund_service");
        resultMap=acceptMassage.acceptCommand(takeLocalMap);



        List<Map> receiveList=(List<Map>) resultMap.get("returnParam");   //new

        localResponse=(HttpServletResponse) localMap.get(MainController.HTTP_RESPONSE_KEY);
        try{
            localResponse.setHeader("Content-type", "application/json;charset=UTF-8");
            localResponse.setCharacterEncoding("UTF-8");
            JSONArray jsonArray = JSONArray.fromObject(receiveList);
            PrintWriter writer=localResponse.getWriter();
            writer.print(jsonArray);
            writer.close();
            localResponse.flushBuffer();
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println(resultMap.toString());
        return resultMap;
    }

        public static HashMap<String,Object> replaceMap(HashMap<String,Object> takeLocalMap){

            HashMap<String,Object> dataMap;
            NodeBean localNodeBean;
            String remoteNodeBeanId;
            String localAppIdKey;
            String localTaskIdKey;
            String localRequestIdKey;
            String itemId;
            HashMap<String,Object> sendMap = new HashMap<>();
            HttpServletRequest httpRequest;  //new1

            localNodeBean=(NodeBean)takeLocalMap.get(MainController.NODE_BEAN_KEY);
            remoteNodeBeanId=localNodeBean.getId();
            localAppIdKey=(String) takeLocalMap.get(MainController.APP_ID_KEY);
            localTaskIdKey=(String) takeLocalMap.get(MainController.TASK_ID_KEY);
            localRequestIdKey=(String) takeLocalMap.get(MainController.REQUEST_ID_KEY);
          //  itemId=(String) takeLocalMap.get(MainController.IRL_ITEM_ID_KEY);
            httpRequest=(HttpServletRequest)takeLocalMap.get(MainController.HTTP_REQUEST_KEY);
            itemId=httpRequest.getParameter(IRL_ITEM_ID_KEY);


            /**
             * new
             */
            String paramKey=localAppIdKey+"."+localTaskIdKey+"."+remoteNodeBeanId+"."+localRequestIdKey+"."+IRL_ITEM_ID_KEY;

            dataMap=new HashMap<String, Object>();
            sendMap.put(paramKey,itemId);
            dataMap.put(MainController.APP_ID_KEY,localAppIdKey);
            dataMap.put(MainController.REQUEST_ID_KEY,localRequestIdKey);
            dataMap.put(MainController.TASK_ID_KEY,localTaskIdKey);
            dataMap.put(MainController.NODE_BEAN_ID_KEY,remoteNodeBeanId);
            dataMap.put("paramMap",sendMap);
            return dataMap;




    }


}
