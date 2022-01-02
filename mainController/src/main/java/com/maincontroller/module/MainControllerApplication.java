package com.maincontroller.module;

import com.maincontroller.module.util.common.CommonXmlLoad;
import com.maincontroller.module.util.common.Interface.ParseXmlAProp;
import com.maincontroller.module.util.common.SysProperties;
import com.maincontroller.module.util.parse_xml.ControlXmlLoad;
import com.maincontroller.module.util.workflowcontrol.MainWorkFlowController;
import org.dom4j.Element;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class MainControllerApplication {

    public static void main(String[] args) {
        initEnv();
        SpringApplication.run(MainControllerApplication.class, args);
    }
    public static void initEnv(){
        String path = null;
        String[] names;
        try {
            SysProperties.loadAllProperties();
            path = SysProperties.getPropertyValue(SysProperties.SEQUENCE_PATH_PROP_KEY,SysProperties.SEQUENCE_PATH_KEY);
            ParseXmlAProp parseControlXml = new ControlXmlLoad();

            names = CommonXmlLoad.readFileName(path);
            if (names.length == 0){
                System.out.println("NO files found!");
            }
            for(int i=0;i<names.length;i++){
                String filePath = path + "\\" + names[i];
                Element rootElement = CommonXmlLoad.getRootElement(filePath);
                parseControlXml.read_xml(rootElement);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
