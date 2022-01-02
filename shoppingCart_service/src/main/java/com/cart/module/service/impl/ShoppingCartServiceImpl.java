package com.cart.module.service.impl;

import com.cart.module.mapper.ShoppingCartMapper;
import com.cart.module.service.Interface.ShoppingCartService;
import com.cart.module.util.common.SpringContextUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingCartServiceImpl implements ShoppingCartService {

    public final static String FLAG = "flag";
    public final static String RET_MSG = "retMsg";
    ShoppingCartMapper shoppingCartMapper = (ShoppingCartMapper) SpringContextUtil.getBean("ShoppingCartMapper");
    @Override
    public Map insertShoppingCart(Map<String,Object> goodsMsg) {
        Map<String,Object> retMap = new HashMap<>();
        int flag = 0;
        String retMsg;
        try {
            shoppingCartMapper.insertShoppingCart(goodsMsg);
            retMsg = "Added successfully.";
            flag = 1;
            retMap.put(RET_MSG,retMsg);
            retMap.put(FLAG,flag);
        } catch (Exception e) {
            e.printStackTrace();
            retMsg = "Add failed.";
            retMap.put(RET_MSG,retMsg);
            retMap.put(FLAG,flag);
        }
        return retMap;
    }

    @Override
    public HashMap getGoodsByUser(String loginName){
        List<Map> dbList;
        HashMap<String,Object> retMap = new HashMap<>();
        int flag;
        try {
            dbList = shoppingCartMapper.getGoodsByUser(loginName);
            flag = 1;
            retMap.put(FLAG,flag);
            retMap.put(RET_MSG,dbList);
        } catch (Exception e) {
            e.printStackTrace();
            flag = 0;
            retMap.put(FLAG,flag);
        }
        return retMap;
    }

    @Override
    public HashMap deleteGoodsByMsg(String loginName, String goodsId) {
        HashMap<String,Object> retMap = new HashMap<>();
        int flag;
        try {
            shoppingCartMapper.deleteGoodsByMsg(loginName,goodsId);
            flag = 1;
            retMap.put(FLAG,flag);
        } catch (Exception e) {
            e.printStackTrace();
            flag = 0;
            retMap.put(FLAG,flag);
        }
        return retMap;
    }

    @Override
    public HashMap getAllGoods() {
        List<Map> dbList;
        HashMap<String,Object> retMap = new HashMap<>();
        int flag;
        try {
            dbList = shoppingCartMapper.getAllGoods();
            flag = 1;
            retMap.put(FLAG,flag);
            retMap.put(RET_MSG,dbList);
        } catch (Exception e) {
            flag = 0;
            retMap.put(FLAG,flag);
            e.printStackTrace();
        }
        return retMap;
    }
}
