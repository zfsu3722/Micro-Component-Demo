package com.maincontroller.module.executor;

import com.maincontroller.module.controller.DealRequestBodyMsg;
import com.maincontroller.module.util.aboutHttpInvoke.Interface.AcceptMassage;
import com.maincontroller.module.util.common.SpringContextUtil;
import com.maincontroller.module.util.common.SysProperties;
import com.maincontroller.module.util.common.imageTransfer;
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

@Service("getAllGoods")
public class GetAllGoods implements LocalNodeService{
    private static final String RET_MSG = "retMsg";
    private static final String FLAG = "flag";
    private static final String GOODS_IMG = "goodsImg";
    private static final String IMG = "img";
    @Override
    public HashMap executeLocal(Map<String, Object> paramMap) throws Exception {
        HttpServletResponse response;
        HashMap<String,Object> returnMap;
        AcceptMassage acceptMassage;
        HashMap<String,Object> sendMap = new HashMap<>();
        String requestId;
        String appId;
        String taskId;
        String nodeId;
        List<Map> list;
        String goodsImgKey;
        String imgPath;
        String base64Img;
        int flag;

        requestId = (String) paramMap.get(REQUEST_ID);
        appId = (String) paramMap.get(APP_ID);
        taskId = (String) paramMap.get(TASK_ID);
        nodeId = (String) paramMap.get(NODE_ID);
        response = (HttpServletResponse) paramMap.get(RESPONSE_KEY);
        goodsImgKey = SysProperties.getPropertyValue(SysProperties.IMAGE_PROP_KEY,SysProperties.GOODSIMG_KEY);

        sendMap.put(REQUEST_ID,requestId);
        sendMap.put(APP_ID,appId);
        sendMap.put(TASK_ID,taskId);
        sendMap.put(NODE_ID,nodeId);

        acceptMassage = (AcceptMassage) SpringContextUtil.getBean("shoppingCart_service");
        returnMap = acceptMassage.acceptCommand(sendMap);
        System.out.println(returnMap);
        flag = (int) returnMap.get(FLAG);
        if (flag == 1){
            list = (List<Map>) returnMap.get(RET_MSG);
            for (Map map : list){
                imgPath = goodsImgKey + map.get(GOODS_IMG);
                base64Img = imageTransfer.fileBase64Str(imgPath);
                map.put(IMG,base64Img);
            }

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
