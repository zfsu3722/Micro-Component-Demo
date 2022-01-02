package com.cart.module.service.Interface;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ShoppingCartService {
    public Map insertShoppingCart(Map<String,Object> goodsMsg) throws Exception;
    public HashMap getGoodsByUser(String loginName) throws Exception;
    public HashMap deleteGoodsByMsg(String loginName,String goodsId) throws Exception;
    public HashMap getAllGoods() throws Exception;
}
