package net.xdclass.localExe.impl;

import net.sf.json.JSONArray;
import net.xdclass.entity.NodeBean;
import net.xdclass.localExe.LocalExe;
import net.xdclass.remoteExe.controller.RemoteNodeController;
import net.xdclass.utils.globalBuffer;
import net.xdclass.webController.MainController;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("accept_service")
public class AcceptLocalNode implements LocalExe {

    @Override
    public HashMap<String, Object> exeLocalNode(HashMap<String, Object> localMap) {
        HttpServletResponse localResponse;
        List<Map> viewData;
        String nodeId = RemoteNodeController.NODE_ID;
        String ret = "itemMsgRender";
        String localAppIdKey;
        String localTaskIdKey;
        String localRequestIdKey;

        HashMap<String,Object> returnMap=new HashMap<>();


        localAppIdKey=(String) localMap.get(MainController.APP_ID_KEY);
        localTaskIdKey=(String) localMap.get(MainController.TASK_ID_KEY);
        localRequestIdKey=(String) localMap.get(MainController.REQUEST_ID_KEY);

        String key=localAppIdKey+"."+localTaskIdKey+"."+nodeId+"."+localRequestIdKey+"."+ret;


        localResponse=(HttpServletResponse) localMap.get(MainController.HTTP_RESPONSE_KEY);

        viewData= (List<Map>) globalBuffer.globalBufferMap.get(key);

        try{
            localResponse.setHeader("Content-type", "application/json;charset=UTF-8");
            localResponse.setCharacterEncoding("UTF-8");
            JSONArray jsonArray = JSONArray.fromObject(viewData);
            PrintWriter writer=localResponse.getWriter();
            writer.print(jsonArray);
            writer.close();
            localResponse.flushBuffer();
            returnMap.put("flag",1);
        }catch (Exception e){
            e.printStackTrace();
        }
        return returnMap;
    }
}
