package com.qz.zframe.common.service;

import com.qz.zframe.common.entity.ApproveRecord;
import com.qz.zframe.common.util.ResultEntity;

public interface ApproveRecordService {

    /**
     * 新增审批记录
     */
    ResultEntity addApproveRecord(ApproveRecord approveRecord);

    /**
     * 根据关联id查询流程审批记录
     */
    ResultEntity getApproveRecordListByOrderId(String orderId);

}
