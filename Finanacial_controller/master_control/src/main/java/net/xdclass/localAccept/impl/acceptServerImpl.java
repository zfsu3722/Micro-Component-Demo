package net.xdclass.localAccept.impl;

import net.xdclass.localAccept.acceptServer;
import net.xdclass.utils.globalBuffer;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Iterator;
@Service
public class acceptServerImpl implements acceptServer {
    @Override
        public HashMap<String,Object> acceptMassage(HashMap<String, Object> massage){
            int flag = 0;
            HashMap<String, Object> returnMap = new HashMap<>();
            System.out.println(massage);
            if (massage.isEmpty()) {
                returnMap.put("flag", flag);
                return returnMap;
            } else {
                Iterator<String> it = massage.keySet().iterator();
                while (it.hasNext()) {
                    String key = it.next();

                   globalBuffer.globalBufferMap.put(key, massage.get(key));
                }
                flag = 1;
                returnMap.put("flag", flag);
                return returnMap;
            }
        }

    @Override
    public HashMap<String, Object> acceptCommand(HashMap<String, Object> massage) {
        return null;
    }
}
