package com.cart.module;

import com.cart.module.service.impl.ShoppingCartServiceImpl;
import com.cart.module.util.common.CommonXmlLoad;
import com.cart.module.util.common.Interface.ParseXmlAProp;
import com.cart.module.util.common.SysProperties;
import com.cart.module.util.globalBuffer.globalBuffer;
import com.cart.module.util.parse_xml.NodeFuncXmlLoad;
import com.cart.module.util.workflowcontrol.MainWorkFlowController;
import org.dom4j.Element;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class ShoppingCartApplication {

    public static void main(String[] args) {
        initEnv();
        SpringApplication.run(ShoppingCartApplication.class, args);
        System.out.println("*************shoppingCart_service start!*************");
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
