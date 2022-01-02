package com.maincontroller.module.executor;

import java.util.HashMap;
import java.util.Map;

public interface LocalNodeService {
    public HashMap executeLocal(Map<String,Object> paramMap) throws Exception;
}
