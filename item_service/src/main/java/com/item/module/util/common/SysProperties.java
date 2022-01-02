package com.item.module.util.common;

import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class SysProperties {
    private static final String PROPERTIES_LIST="propertiesList.properties";
    private static Map<String,Object> propertiesMap=new HashMap<String, Object>();

    public static final String CONFIGXML_PATH_PROP_KEY="CONFIGXMLPATH";
    public static final String CONFIGXML_PATH_KEY="path";


    public static void loadAllProperties() throws IOException {
        Properties propsList;
        Properties propsItem=null;
        Enumeration keyEnum;
        String paramKey;
        String decodedParamValue;

        propsList= PropertiesLoaderUtils.loadAllProperties(PROPERTIES_LIST);
        keyEnum=propsList.keys();
        while(keyEnum.hasMoreElements()){
            paramKey=(String)keyEnum.nextElement();
            decodedParamValue=propsList.getProperty(paramKey);
            propsItem=PropertiesLoaderUtils.loadAllProperties(decodedParamValue);
            propertiesMap.put(paramKey,propsItem);
        }
    }

    public static  String getPropertyValue(String propertyItemKey,String propertyValueKey){
        Properties propertyItem;
        String propertyValue;

        propertyItem=(Properties)propertiesMap.get(propertyItemKey);
        propertyValue=propertyItem.getProperty(propertyValueKey);
        return propertyValue;

    }

}
