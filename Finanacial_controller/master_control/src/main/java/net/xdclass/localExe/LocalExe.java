package net.xdclass.localExe;

import org.springframework.stereotype.Service;


import java.util.HashMap;


public interface LocalExe {
    HashMap<String,Object> exeLocalNode(HashMap<String,Object> localMap);
}
