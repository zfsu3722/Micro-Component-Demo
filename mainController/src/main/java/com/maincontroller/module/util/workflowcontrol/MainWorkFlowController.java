package com.maincontroller.module.util.workflowcontrol;


import com.common.entities.NodeBean;
import com.maincontroller.module.executor.LocalNodeService;
import com.maincontroller.module.util.aboutHttpInvoke.Interface.AcceptMassage;
import com.maincontroller.module.util.common.SequenceCatch;
import com.maincontroller.module.util.common.SpringContextUtil;
import com.maincontroller.module.util.common.SysProperties;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainWorkFlowController
{

	public static final String LOCAL_REF = "LOCAL_REF";
	public static final String REMOTE_REF = "REMOTE_REF";
	public static final String TASK_ID = "taskId";
	public static final String NODE_BEAN = "nodeBean";
	public static final String NODE_ID = "nodeId";
	public static final String EXEC_REF = "execRef";
	public static final String APP_ID = "appId";
	public static final String REQUEST_ID = "requestId";
	public static final String JUMP_FLAG = "flag";
	public static final String RESPONSE_KEY = "response";
	public static final String REQUEST_KEY = "request";
	public static final String SPLIT = ".";
	public static String LAST_REMOTE_NODE_ID;

	public static void executeSequence(Map<String,Object> paramMap) throws Exception {

		HashMap<String,Object> returnMap = null;
		List<NodeBean> sequence;
		Thread currentT;
		long requestIdL;
		String requestId;
		String appId;
		String taskId;
		NodeBean nodeBean;
		int jumpFlag;
		int nodeSeqLen;
		int i;

		try {

			appId = SysProperties.getPropertyValue(SysProperties.APPID_PROP_KEY,SysProperties.APPID_KEY);
			taskId = (String) paramMap.get(TASK_ID);
			currentT = Thread.currentThread();
			requestIdL = currentT.getId();
			requestId = String.valueOf(requestIdL);
			paramMap.put(REQUEST_ID,requestId);
			paramMap.put(APP_ID,appId);
			sequence = SequenceCatch.getSequence(taskId);
			System.out.println("**********Control center started successfully**********");
			nodeSeqLen = sequence.size();
			i=0;

			while(i<nodeSeqLen) {
				nodeBean = sequence.get(i);
				paramMap.put(NODE_BEAN,nodeBean);
				returnMap = executeNode(paramMap);
				jumpFlag = (int) returnMap.get(JUMP_FLAG);
				if (jumpFlag == 1){
					i = i + 1;
				}else if (jumpFlag == 0){
					System.out.println("The program ends, please see the log information...");
					break;
				}
			}
		}
		catch(Exception e) {
    		throw e;
		}

	}
	
	private static HashMap<String,Object> executeNode(Map<String,Object> paramMap)
	{
		HashMap<String,Object> returnMap = null;
		NodeBean nodeBean;
		String execRef;
		String refTag;
		String nodeId;

		try {
			nodeBean = (NodeBean) paramMap.get(NODE_BEAN);
			execRef = nodeBean.getExecRef();
			refTag = nodeBean.getRefTag();
			nodeId = nodeBean.getId();
			paramMap.put(NODE_ID,nodeId);
			paramMap.put(EXEC_REF,execRef);

			if (refTag.equals(LOCAL_REF)){
				returnMap = localCall(paramMap);
			}
			if (refTag.equals(REMOTE_REF)){
				paramMap.remove(NODE_BEAN);
				returnMap = remoteCall(paramMap);
			}
		}
		catch(Exception e) {
    		throw e;
		}
		return returnMap;
		
	}

	public static HashMap<String,Object> remoteCall(Map<String,Object> paramMap){
		HashMap<String,Object> returnMap = null;
		AcceptMassage acceptMassage;
		String execRef;

		execRef = (String) paramMap.get(EXEC_REF);
		HashMap<String,Object> data = new HashMap<>();
		LAST_REMOTE_NODE_ID = (String) paramMap.get(NODE_ID);
		data.put(REQUEST_ID,paramMap.get(REQUEST_ID));
		data.put(APP_ID,paramMap.get(APP_ID));
		data.put(TASK_ID,paramMap.get(TASK_ID));
		data.put(NODE_ID,paramMap.get(NODE_ID));

		acceptMassage = (AcceptMassage) SpringContextUtil.getBean(execRef);
		returnMap = acceptMassage.acceptCommand(data);
		System.out.println(returnMap);
		return returnMap;
	}

	public static HashMap<String,Object> localCall(Map<String,Object> paramMap){
		HashMap<String,Object> returnMap = null;
		String execRef;

		execRef = (String) paramMap.get(EXEC_REF);
		System.out.println(execRef);
		LocalNodeService localNodeService = (LocalNodeService) SpringContextUtil.getBean(execRef);
		try {
			returnMap = localNodeService.executeLocal(paramMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnMap;
	}


}
