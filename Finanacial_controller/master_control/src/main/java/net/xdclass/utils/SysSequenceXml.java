package net.xdclass.utils;

import net.xdclass.entity.NodeBean;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SysSequenceXml {
    private static final String TASK_ID = "taskId";
    private static final String SEQUENCE = "sequence";

    public  static void readXml() {
        Map<String,Object> sequenceCacheMap=new HashMap<String,Object>();

        String realPath = SysProperties.getPropertyValue(SysProperties.SEQUENCE_PATH_PROP_KEY,SysProperties.SEQUENCE_PATH_KEY);
        File file = new File(realPath);
        String[] names = file.list();
        if (names != null) {
            for (int i = 0; i < names.length; i++) {
                String filePath = realPath + "\\" + names[i];
                read_xml(sequenceCacheMap,filePath);
            }
        }
        SequenceCache.setSequenceMap(sequenceCacheMap);
    }

    public static void read_xml(Map<String,Object> sequenceCacheMap,String path){

        SAXReader saxReader = new SAXReader();
        Document document;
        String taskId=null;
        List<NodeBean> sequenceNs=null;

        try {
            document = saxReader.read(new File(path));
            Element rootElement = document.getRootElement();
            List<Element> childElements = rootElement.elements();
            for(Element e :childElements){
                if (TASK_ID.equals(e.getName())){

                    taskId=e.getText();

                }
                if (SEQUENCE.equals(e.getName())){
                    sequenceNs = readSequence(e);

                }
            }
            sequenceCacheMap.put(taskId,sequenceNs);
        }catch (Exception e){
            e.printStackTrace();
        }

    }


    public static List<NodeBean> readSequence(Element element){
        List<NodeBean> sequenceNodes = new ArrayList<>();
        List<Element> childElements = element.elements();//node
        for (Element e : childElements){
            NodeBean nodeBean = new NodeBean();
            nodeBean.setId(e.elementText("id"));
            nodeBean.setStep(e.element("step").getText());
            nodeBean.setExecRef(e.elementText("execRef"));
            nodeBean.setRefTag(e.elementText("refTag"));
            sequenceNodes.add(nodeBean);
        }
        return sequenceNodes;
    }
}
