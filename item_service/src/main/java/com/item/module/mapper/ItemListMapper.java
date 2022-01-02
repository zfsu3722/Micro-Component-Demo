package com.item.module.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository("ItemListMapper")
public interface ItemListMapper {
    public List<Map> queryAllItem() throws Exception;
}
