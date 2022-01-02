package com.employee.module;

import com.employee.module.util.common.CommonXmlLoad;
import com.employee.module.util.common.Interface.ParseXmlAProp;
import com.employee.module.util.common.SysProperties;
import com.employee.module.util.globalBuffer.globalBuffer;
import com.employee.module.util.parse_xml.NodeFuncXmlLoad;
import com.employee.module.util.workflowcontrol.MainWorkFlowController;
import org.dom4j.Element;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class StaffApplication {

    public static void main(String[] args) {
        initEnv();
        SpringApplication.run(StaffApplication.class, args);
        System.out.println("*************staff_service start!*************");
    }
    public static void initEnv(){

        String path;
        ParseXmlAProp parseControlXml = new NodeFuncXmlLoad();
        try {
            SysProperties.loadAllProperties();
            path = SysProperties.getPropertyValue(SysProperties.CONFIGXML_PATH_PROP_KEY,SysProperties.CONFIGXML_PATH_KEY);
            String[] names = CommonXmlLoad.readFileName(path);
            if (names.length == 0){
                System.out.println("NO files found!");
            }else{
                for(int i=0;i<names.length;i++){
                    String filePath = path + "\\" + names[i];
                    Element rootElement = CommonXmlLoad.getRootElement(filePath);
                    parseControlXml.read_xml(rootElement);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
