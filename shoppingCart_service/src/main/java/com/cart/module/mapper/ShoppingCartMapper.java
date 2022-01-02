package com.cart.module.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
@Repository("ShoppingCartMapper")
public interface ShoppingCartMapper {
    public void insertShoppingCart(Map<String,Object> goodsMsg) throws Exception;
    public List<Map> getGoodsByUser(String loginName) throws Exception;
    public void deleteGoodsByMsg(String loginName,String goodsId) throws Exception;
    public List<Map> getAllGoods() throws Exception;
}
