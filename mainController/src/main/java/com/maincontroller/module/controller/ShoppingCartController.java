package com.maincontroller.module.controller;

import com.maincontroller.module.util.workflowcontrol.MainWorkFlowController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
public class ShoppingCartController {

    @RequestMapping(value = "/shoppingCart")
    @CrossOrigin()
    public void shoppingCartEntry(HttpServletRequest request, HttpServletResponse response){
        Map<String,Object> paramMap = new HashMap<>();
        String taskId = request.getParameter(MainWorkFlowController.TASK_ID);
        paramMap.put(MainWorkFlowController.TASK_ID,taskId);
        paramMap.put(MainWorkFlowController.REQUEST_KEY,request);
        paramMap.put(MainWorkFlowController.RESPONSE_KEY,response);
        try {
            MainWorkFlowController.executeSequence(paramMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
