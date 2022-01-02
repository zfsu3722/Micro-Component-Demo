package com.reimbursement.module.service.interfaces;

import java.util.List;
import java.util.Map;

public interface ItemRefundService {

    public List<Map> queryByItemId(String itemId) throws Exception;
}
