package com.item.module.util.workflowcontrol;


import com.item.entities.Context;
import com.item.entities.NodeConfig;
import com.item.entities.OutputParam;
import com.item.module.util.common.*;
import com.item.module.util.parse_xml.NodeFuncXmlLoad;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainWorkFlowController {
	public final static String CONTROL_FLAG = "CONTROL";

	public static Map<String,Object> JobExececute(String key,String requestId,HashMap<String, Object> control_param){

		NodeConfig nodeConfig;
		nodeConfig = NodeFuncXmlLoad.getNodeConfig(key);
		nodeConfig.setRequestId(requestId);
		Map<String,Object> returnData;
		HashMap<String,Object> inParamsMap = null;
		ParseInParam parseInParam = new ParseInParam();
		if (nodeConfig.getInParams() != null){
			inParamsMap = parseInParam.inParam(nodeConfig,control_param);
		}
		returnData = doJob(nodeConfig,inParamsMap);
		return returnData;
	}

	public static Map<String,Object> doJob(NodeConfig nodeConfig,HashMap<String,Object> inParamsMap){

		String execBeanName;
		IJobBeanExecutor jobBeanExecutor;
		Context context;
		List<OutputParam> outParams;
		HashMap<String, Object> returnMap = null;
		HashMap<String, Object> sendReturnMap = null;
		Map<String,Object> outPutMap = null;
		HashMap<String,Object> outMap;
		String preKey;
		String destRef;
		String send_flag;

		outParams = nodeConfig.getOutParam();
		context = nodeConfig.getContext();
		preKey = ParseContextForFunc.PreKey(context) + ParseContextForFunc.KEY_SPLIT + nodeConfig.getRequestId();
		execBeanName = nodeConfig.getFunctionRef();
		jobBeanExecutor = (IJobBeanExecutor) SpringContextUtil.getBean(execBeanName);
		try {
			outPutMap = jobBeanExecutor.ExecuteJobBean(inParamsMap);

			for (OutputParam o : outParams){
				destRef = o.getDestRef();
				if(o.getDestRef().equals(CONTROL_FLAG)){
					returnMap = ParseOutSend.parseDestRef(o,preKey, (HashMap<String, Object>) outPutMap);
				}else {
					outMap = ParseOutSend.parseDestRef(o,preKey, (HashMap<String, Object>) outPutMap);
					sendReturnMap = ParseOutSend.sendToDest(destRef,outMap);
				}
				if (!o.getDestRef().equals(CONTROL_FLAG)&&!isOk(sendReturnMap)){
					System.out.println("Data transfer failed:"+o.toString());
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		if(sendReturnMap!=null)
		{
			if(returnMap==null) {
				returnMap = new HashMap<String, Object>();
			}
			if(!isOk(sendReturnMap)) {
				returnMap.put("flag", 0);
			}
			else
			{
				returnMap.put("flag", 1);
			}
		}
		return returnMap;
	}
	private static boolean isOk(HashMap<String, Object> returnMap){
		final String FLAG = "flag";
		int i;
		boolean ret = false;
		i = (int) returnMap.get(FLAG);
		if (i == 1){
			ret = true;
		}else if (i == 0){}
		return ret;
	}


}