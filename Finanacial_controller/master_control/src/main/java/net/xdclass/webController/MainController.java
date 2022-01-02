package net.xdclass.webController;

import net.xdclass.entity.NodeBean;
import net.xdclass.localExe.LocalExe;
import net.xdclass.remoteExe.controller.RemoteNodeController;
import net.xdclass.utils.SequenceCache;
import net.xdclass.utils.SpringContextUtil;
import net.xdclass.utils.SysProperties;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("api/v1")
public class MainController {
    public static final String HTTP_REQUEST_KEY="httpRequestKey";
    public static final String HTTP_RESPONSE_KEY="httpResponseKey";
    public static final String REQUEST_ID_KEY="requestId";
    public static final String TASK_ID_KEY="taskId";
    public static final String APP_ID_KEY="appId";
    public static final String NODE_BEAN_KEY="nodeBeanKey";
    private static final String WEB_TASK_ID="webTaskId";

    private static final String LOCAL_NODE="localNode";
    private static final String REMOTE_NODE="remoteNode";
    public static final String NODE_BEAN_ID_KEY="nodeId";



    @RequestMapping("start")
    @CrossOrigin
    public void loginController(HttpServletRequest httpRequest, HttpServletResponse httpResponse){
        String taskId;
        Long requestIDL;
        String requestId;
        String appId;
        NodeBean nodeBean;
        Thread currentThread;
        List<NodeBean> sequence;
        HashMap<String,Object> func_params;
        int i;
        int sequenceLen;


        taskId=httpRequest.getParameter(WEB_TASK_ID);
        currentThread=Thread.currentThread();
        requestIDL=currentThread.getId();
        requestId=requestIDL.toString();
        System.out.println(requestId);
        appId= SysProperties.getPropertyValue(SysProperties.APPID_PROP_KEY,SysProperties.APPID_KEY);

        sequence=(List<NodeBean>) SequenceCache.getSequence(taskId);

        func_params=new HashMap<String,Object>();
        func_params.put(HTTP_REQUEST_KEY,httpRequest);
        func_params.put(HTTP_RESPONSE_KEY,httpResponse);
        func_params.put(REQUEST_ID_KEY,requestId);
        func_params.put(TASK_ID_KEY,taskId);
        func_params.put(APP_ID_KEY,appId);
        sequenceLen=sequence.size();
        i=0;
        while (i<sequenceLen){
            HashMap<String,Object> flagMap;
            nodeBean=sequence.get(i);
            func_params.put(NODE_BEAN_KEY,nodeBean);
            flagMap=checkTag(func_params);

            int flag=(int)flagMap.get("flag");
            if (flag==1){
             i++;
            }
        }
    }

    public HashMap<String, Object> checkTag(HashMap<String,Object> map){
        NodeBean currentNodeBean;
        String refTag;
        HashMap<String,Object> hashMap=null;

        currentNodeBean=(NodeBean)map.get(NODE_BEAN_KEY);
        refTag=currentNodeBean.getRefTag();
        if (refTag.equals(LOCAL_NODE)){
            hashMap=ExecLocalNode(map);
        }else if (refTag.equals(REMOTE_NODE)){
            hashMap=ExecRemoteNode(map);
        }
        return hashMap;
    }


    public HashMap<String,Object> ExecRemoteNode(HashMap<String,Object> map){
        HashMap<String,Object> receiveMap;

        receiveMap=RemoteNodeController.executeRemote(map);
        return receiveMap;
    }


    public HashMap<String,Object> ExecLocalNode(HashMap<String,Object> map) {
        String execRef;
        NodeBean localNodeBean;
        HashMap<String,Object> receiveMap;

        localNodeBean=(NodeBean) map.get(MainController.NODE_BEAN_KEY);
        execRef=localNodeBean.getExecRef();
        LocalExe localExe = (LocalExe)SpringContextUtil.getBean(execRef);
        receiveMap=localExe.exeLocalNode(map);
        return receiveMap;
    }
}
