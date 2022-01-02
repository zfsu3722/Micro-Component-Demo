package com.maincontroller.module.util.parse_xml;

import com.common.entities.NodeBean;
import com.maincontroller.module.util.common.Interface.ParseXmlAProp;
import com.maincontroller.module.util.common.SequenceCatch;
import org.dom4j.Element;
import java.util.ArrayList;
import java.util.List;

public class ControlXmlLoad implements ParseXmlAProp {
    private static final String TASK_ID = "taskId";
    private static final String SEQUENCE = "sequence";

    @Override
    public void read_xml(Element rootElement) {
        String taskId = null;
        List<NodeBean> sequenceNs = null;
        List<Element> childElements = rootElement.elements();
        for (Element e : childElements) {
            if (TASK_ID.equals(e.getName())){
                taskId = e.getText();
            }
            if (SEQUENCE.equals(e.getName())){
                sequenceNs = readSequence(e);
            }

        }
        SequenceCatch.setSequenceMap(taskId,sequenceNs);
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

