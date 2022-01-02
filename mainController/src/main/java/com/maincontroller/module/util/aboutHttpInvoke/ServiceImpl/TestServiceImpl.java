package com.maincontroller.module.util.aboutHttpInvoke.ServiceImpl;

import com.maincontroller.module.util.aboutHttpInvoke.Interface.RpcMainController;
import com.maincontroller.module.util.globalbuffer.globalBuffer;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Iterator;

@Service
public class TestServiceImpl implements RpcMainController {
    /*Implementation of state dataRecv(paramMap)*/
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

}
