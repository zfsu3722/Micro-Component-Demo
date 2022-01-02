package com.reimbursement.module.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository("ItemRefundMapper")
public interface ItemRefundMapper {

    public List<Map> queryByItemId(String itemId) throws Exception;
}
