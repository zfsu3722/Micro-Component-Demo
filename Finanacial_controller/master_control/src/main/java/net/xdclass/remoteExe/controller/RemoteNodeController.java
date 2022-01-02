package net.xdclass.remoteExe.controller;


import net.xdclass.entity.NodeBean;
import net.xdclass.remoteExe.aboutHttpInvoker.Interface.AcceptMassage;

import net.xdclass.utils.SpringContextUtil;
import net.xdclass.webController.MainController;

import java.util.HashMap;


public class RemoteNodeController {
    public static String NODE_ID = null;

    public static HashMap<String, Object> executeRemote(HashMap<String,Object> remoteMap){

        NodeBean remoteNodeBean;
        String execRef;
        HashMap<String,Object> takeRemoteMap;
        HashMap<String,Object> resultMap;


        remoteNodeBean=(NodeBean)remoteMap.get(MainController.NODE_BEAN_KEY);
        execRef=remoteNodeBean.getExecRef();
        takeRemoteMap=replaceMap(remoteMap);

        AcceptMassage acceptMassage =(AcceptMassage) SpringContextUtil.getBean(execRef);
        resultMap=acceptMassage.acceptCommand(takeRemoteMap);
        System.out.println(resultMap.toString());
        return resultMap;
    }



    public static HashMap<String,Object> replaceMap(HashMap<String,Object> takeRemoteMap){
        HashMap<String,Object> dataMap;
        NodeBean remoteNodeBean;
        String remoteNodeBeanId;
        String remoteAppIdKey;
        String remoteTaskIdKey;
        String remoteRequestIdKey;

        remoteNodeBean=(NodeBean)takeRemoteMap.get(MainController.NODE_BEAN_KEY);
        remoteNodeBeanId=remoteNodeBean.getId();
        remoteAppIdKey=(String) takeRemoteMap.get(MainController.APP_ID_KEY);
        remoteTaskIdKey=(String) takeRemoteMap.get(MainController.TASK_ID_KEY);
        remoteRequestIdKey=(String) takeRemoteMap.get(MainController.REQUEST_ID_KEY);


        dataMap=new HashMap<String, Object>();
        dataMap.put(MainController.APP_ID_KEY,remoteAppIdKey);
        dataMap.put(MainController.TASK_ID_KEY,remoteTaskIdKey);
        dataMap.put(MainController.NODE_BEAN_ID_KEY,remoteNodeBeanId);
        dataMap.put(MainController.REQUEST_ID_KEY,remoteRequestIdKey);

        NODE_ID = remoteNodeBeanId;
        return dataMap;



    }


}
