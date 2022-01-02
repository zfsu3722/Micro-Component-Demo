package com.user.module;

import com.user.module.util.common.CommonXmlLoad;
import com.user.module.util.common.Interface.ParseXmlAProp;
import com.user.module.util.common.SysProperties;
import com.user.module.util.globalBuffer.globalBuffer;
import com.user.module.util.parse_xml.NodeFuncXmlLoad;
import com.user.module.util.workflowcontrol.MainWorkFlowController;
import org.dom4j.Element;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.IOException;
import java.util.Map;

@SpringBootApplication
public class UserServiceApplication {

    public static void main(String[] args) {
        initEnv();
        SpringApplication.run(UserServiceApplication.class, args);
        System.out.println("*************user_service start!*************");
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
            }
            for(int i=0;i<names.length;i++){
                String filePath = path + "\\" + names[i];
                Element rootElement = CommonXmlLoad.getRootElement(filePath);
                parseControlXml.read_xml(rootElement);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
