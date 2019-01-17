package com.qz.zframe.common.service;

import com.qz.zframe.common.entity.Process;
import com.qz.zframe.common.entity.ProcessDetail;
import com.qz.zframe.common.util.ResultEntity;

public interface ProcessService {

    /**
     * 添加流程主表,流程详情,关联角色
     */
    ResultEntity addProcess(Process process);

    /**
     * 修改流程主表
     */
    ResultEntity updateProcess(Process process);

    /**
     * 修改流程详情
     */
    ResultEntity updateProcessDetail(ProcessDetail processDetail);

    /**
     * 根据关联id和类型查询流程
     */
    ResultEntity getProcessByOrderIdAndType(String orderId,String processType);

    /**
     * 根据流程主表id和流程步骤获取流程详情
     */
    ResultEntity getProcessDetailByProcessIdAndsort(String processId,String sort);

    /**
     * 根据流程主表id获取流程总步数
     */
    ResultEntity getTotalSort(String processId);

    /**
     * 根据id查询是否有审批权限
     */
    ResultEntity isPermissions(String id);
}
