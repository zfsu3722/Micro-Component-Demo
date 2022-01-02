package com.user.module.util.parse_xml;

import com.user.entities.*;
import com.user.module.util.common.Interface.ParseXmlAProp;
import com.user.module.util.common.ParseContextForFunc;
import org.dom4j.Element;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NodeFuncXmlLoad implements ParseXmlAProp {

    private static final String CONTEXT = "context";
    private static final String APP_ID = "appId";
    private static final String TASK_ID = "taskId";
    private static final String NODE_ID = "nodeId";
    private static final String FUNCTION_CALL = "functionCall";
    private static final String FUNCTION_REF = "functionRef";
    private static final String INPUT = "input";
    private static final String OUTPUT = "output";
    private static final String RETURN_MSG = "returnMsg";
    private static final String SOURCE_NODE_ID = "sourceNodeId";
    private static final String SOURCE_PARAM_ID = "sourceParamId";
    private static final String FUNC_PARAM_ID = "funcParamId";
    private static final String PARAM_TYPE = "paramType";
    private static final String MEM_CACHE = "memCache";
    private static Context context;
    private static String xmlKey;

    private static HashMap<String, NodeConfig> xml_map = new HashMap<>();
    @Override
    public void read_xml(Element rootElement) {
        NodeConfig nodeConfig = new NodeConfig();

        try {
            List<Element> childElements = rootElement.elements();
            for (Element e : childElements) {
                if (CONTEXT.equals(e.getName())){
                    Context context = readContext(e);
                    nodeConfig.setContext(context);
                }
                if (FUNCTION_CALL.equals(e.getName())){
                    Element element = e.element(FUNCTION_REF);
                    nodeConfig.setFunctionRef(element.getText());
                }
                if (INPUT.equals(e.getName())){
                    List<InputParam> inParams = readInParams(e);
                    nodeConfig.setInParams(inParams);
                }
                if (OUTPUT.equals(e.getName())){
                    List<OutputParam> outParams = readOutParams(e);
                    nodeConfig.setOutParam(outParams);
                }
                if (RETURN_MSG.equals(e.getName())){
                    nodeConfig.setReturnMsg(e.getText());
                }

            }
            xmlKey = ParseContextForFunc.PreKey(context);
            xml_map.put(xmlKey,nodeConfig);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(xml_map.toString());

    }
    public static Context readContext(Element element){
        context = new Context();
        context.setAppId(element.elementText(APP_ID));
        context.setTaskId(element.elementText(TASK_ID));
        context.setNodeId(element.elementText(NODE_ID));
        return context;
    }
    public static List<InputParam> readInParams(Element element){
        List<InputParam> inParams = new ArrayList<>();
        List<Element> childElements = element.elements();//inParam
        for (Element e : childElements){
            InputParam inputParam = new InputParam();
            inputParam.setSourceNodeId(e.elementText(SOURCE_NODE_ID));
            inputParam.setSourceParamId(e.elementText(SOURCE_PARAM_ID));
            inputParam.setFuncParamId(e.elementText(FUNC_PARAM_ID));
            inputParam.setParamType(e.elementText(PARAM_TYPE));
            inputParam.setMemCache(e.elementText(MEM_CACHE));
            inParams.add(inputParam);
        }
        return inParams;
    }
    private static List<OutputParam> readOutParams(Element element) {
        List<OutputParam> outParams = new ArrayList<>();
        List<Element> childElements = element.elements();//destOutput
        for (Element e : childElements){
            OutputParam outputParam = new OutputParam();
            List<OutData> outDatas = new ArrayList<>();
            String destRef = e.element("destRef").getText();
            List<Element> out = e.elements("outParam");//outParam
            for (Element e2 : out){
                OutData outData = new OutData();
                String funcParamId = e2.element("funcParamId").getText();
                String destParamId = e2.element("destParamId").getText();
                outData.setFuncParamId(funcParamId);
                outData.setDestParamId(destParamId);
                outDatas.add(outData);
            }
            outputParam.setDestRef(destRef);
            outputParam.setOutDatas(outDatas);
            outParams.add(outputParam);
        }
        return outParams;
    }

    public static NodeConfig getNodeConfig(String key){
        NodeConfig nodeConfig;
        nodeConfig = xml_map.get(key);
        return nodeConfig;
    }

}
