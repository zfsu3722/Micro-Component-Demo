package com.cart.module.executor;

import com.cart.module.service.impl.UserServiceImpl;
import com.cart.module.util.common.PublicConstant;
import com.cart.module.util.workflowcontrol.IJobBeanExecutor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service("login")
public class LoginGoods implements IJobBeanExecutor {

    private static final String EMP_USER_NAME = "empUserName";
    private static final String EMP_PASS_WORD = "empPassWord";

    @Override
    public Map<String, Object> ExecuteJobBean(HashMap<String, Object> inParamsMap) {

        UserServiceImpl userService=new UserServiceImpl();

        String userName;
        String passWord;
        HashMap<String,Object> retMap;


        userName = (String) inParamsMap.get(EMP_USER_NAME);
        passWord = (String) inParamsMap.get(EMP_PASS_WORD);
        retMap=userService.findByPhoneAndPwd(userName,passWord);

        retMap.put(PublicConstant.SEND_FLAG,PublicConstant.NO_SEND_FLAG);
        return retMap;
    }
}
