package com.user.module.util.workflowcontrol;

import com.user.entities.Context;
import com.user.entities.NodeConfig;
import com.user.entities.OutputParam;
import com.user.module.util.common.*;
import com.user.module.util.parse_xml.NodeFuncXmlLoad;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainWorkFlowController {

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
		Map<String,Object> outPutMap = null;
		String preKey;
		String send_flag;

		outParams = nodeConfig.getOutParam();
		context = nodeConfig.getContext();
		preKey = ParseContextForFunc.PreKey(context) + ParseContextForFunc.KEY_SPLIT + nodeConfig.getRequestId();
		execBeanName = nodeConfig.getFunctionRef();
		jobBeanExecutor = (IJobBeanExecutor) SpringContextUtil.getBean(execBeanName);
		try {
			outPutMap = jobBeanExecutor.ExecuteJobBean(inParamsMap);
			send_flag = (String) outPutMap.get(PublicConstant.SEND_FLAG);
			if (send_flag.equals(PublicConstant.YES_SEND_FLAG)){
				outPutMap.remove(PublicConstant.SEND_FLAG);
				for (OutputParam o : outParams){
					returnMap = ParseOutSend.parseDestRef(o,preKey, (HashMap<String, Object>) outPutMap);
					if (!isOk(returnMap)){
						System.out.println("Data transfer failed:"+o.toString());
						break;
					}
				}
			}else if (send_flag.equals(PublicConstant.NO_SEND_FLAG)){
				return outPutMap;
			}
		} catch (Exception e) {
			e.printStackTrace();
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
