package com.maincontroller.module.executor;

import net.sf.json.JSONArray;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.maincontroller.module.util.workflowcontrol.MainWorkFlowController.RESPONSE_KEY;

@Service("returnClearFunc")
public class ReturnClearShoppingFunc implements LocalNodeService{
    @Override
    public HashMap executeLocal(Map<String, Object> paramMap) throws Exception {
        HttpServletResponse response;
        int flag;
        List<String> list = new ArrayList<>();
        HashMap<String,Object> returnMap = new HashMap<>();
        String msg = "Transaction Complete!";
        System.out.println("Transaction Complete!");
        response = (HttpServletResponse) paramMap.get(RESPONSE_KEY);
        list.add(msg);
        try{
            response.setHeader("Content-type", "application/json;charset=UTF-8");
            //response.setContentType("application/json: charset=utf-8");
            response.setCharacterEncoding("UTF-8");
            JSONArray jsonArray = JSONArray.fromObject(list);
            PrintWriter writer=response.getWriter();
            writer.print(jsonArray);
            writer.close();
            response.flushBuffer();
            System.out.println("Data sent to front-end");
            flag = 0;
            returnMap.put("flag",flag);
        }catch (Exception e){
            e.printStackTrace();
        }
        returnMap.put("flag",0);
        return returnMap;
    }
}
