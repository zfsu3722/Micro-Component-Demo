package com.reimbursement.module.service.impl;

import com.reimbursement.module.mapper.ItemRefundMapper;
import com.reimbursement.module.util.common.SpringContextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

public class ItemRefundServiceImpl implements ItemRefundMapper {

    ItemRefundMapper itemRefundMapper = (ItemRefundMapper) SpringContextUtil.getBean("ItemRefundMapper");
    @Override
    public List<Map> queryByItemId(String itemId) throws Exception {
        return itemRefundMapper.queryByItemId(itemId);
    }
}
