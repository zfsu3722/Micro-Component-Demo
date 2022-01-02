package com.cart.module.util.httpInvoke.serviceImpl;

import com.cart.module.util.globalBuffer.globalBuffer;
import com.cart.module.util.httpInvoke.Interface.RpcMainController;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Service
public class TestServiceImpl implements RpcMainController {

    @Override
    public HashMap<String,Object> acceptMassage(HashMap<String, Object> massage) {
        int flag = 0;
        HashMap<String,Object> returnMap = new HashMap<>();
        System.out.println(massage);
        if (massage.isEmpty()){
            returnMap.put("flag",flag);
            return returnMap;
        }else {
            Iterator<String> it = massage.keySet().iterator();
            while (it.hasNext()){
                String key = it.next();

                globalBuffer.paramBuffer.put(key,massage.get(key));
            }
            flag = 1;
            returnMap.put("flag",flag);
            return returnMap;
        }
    }

    @Override
    public HashMap<String,Object> acceptCommand(HashMap<String, Object> massage) {
        Map<String,Object> returnData = null;
        System.out.println(massage);

        if (massage != null){
            ParseData parseData = new ParseData();
            returnData = parseData.parseDataControl(massage);
        }

        return (HashMap<String, Object>) returnData;
    }

}
