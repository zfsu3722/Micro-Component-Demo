package com.maincontroller.module.controller;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

public class DealRequestBodyMsg {

    public HashMap requestBodyToMap(HttpServletRequest request){
        HashMap<String,Object> bodyMsg_map = null;
        BufferedReader br = null;
        StringBuilder sb = new StringBuilder("");
        try {
            br = request.getReader();
            String str;
            while ((str = br.readLine()) != null) {
                sb.append(str);
            }
            br.close();
        } catch (IOException e){
            e.printStackTrace();
        } finally{
            if (null != br) {
                try {
                    br.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        String htmlData = sb.toString();
        System.out.println("htmlData = "+htmlData);
        if (!htmlData.equals("{}")){
            String[] dataList = htmlData.split(",");
            bodyMsg_map = getRequestBodyMsg(dataList);
            System.out.println(bodyMsg_map.toString());
        }
        System.out.println(bodyMsg_map);
        return bodyMsg_map;
    }

    public HashMap getRequestBodyMsg(String[] dataList){
        int iSize;
        HashMap<String,Object> bodyMsg_map = new HashMap<>();
        for (int i = 0;i < dataList.length;i++){
            char[] stringToArray = dataList[i].toCharArray();
            iSize = stringToArray.length;
            int j = 0;
            while (j < iSize){
                if (stringToArray[j] == '{' || stringToArray[j] == '"' || stringToArray[j] == '}'){
                    for (int k = j;k < iSize - 1;k++){
                        stringToArray[k] = stringToArray[k+1];
                    }
                    iSize=iSize-1;
                    j = 0;
                }else {
                    j++;
                }
            }
            char[] array = Arrays.copyOf(stringToArray,iSize);
            String s = String.valueOf(array);
            String[] splitData = s.split(":");
            bodyMsg_map.put(splitData[0],splitData[1]);
        }
        return bodyMsg_map;
    }
}






