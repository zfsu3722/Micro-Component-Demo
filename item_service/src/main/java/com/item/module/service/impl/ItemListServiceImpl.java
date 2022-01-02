package com.item.module.service.impl;

import com.item.module.mapper.ItemListMapper;
import com.item.module.service.interfaces.ItemListService;
import com.item.module.util.common.SpringContextUtil;

import java.util.List;
import java.util.Map;

public class ItemListServiceImpl implements ItemListService {

    ItemListMapper itemListMapper = (ItemListMapper) SpringContextUtil.getBean("ItemListMapper");
    @Override
    public List<Map> queryAllItem() throws Exception {
        return itemListMapper.queryAllItem();
    }
}
