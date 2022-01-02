package com.cart.module.util.common;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import java.io.File;


public class CommonXmlLoad {

    public static String[] readFileName(String path){
        File file = new File(path);
        String[] names = file.list();
        return names;
    }

    public static Element getRootElement(String path){

        SAXReader saxReader = new SAXReader();
        Document document;
        Element rootElement = null;
        try {
            document = saxReader.read(new File(path));
            rootElement = document.getRootElement();

        }catch (Exception e){
            e.printStackTrace();
        }
        return rootElement;
    }


}


