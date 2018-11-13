package com.qz.zframe.maintain.service;

import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.maintain.entity.WorkorderType;

public interface WorkorderTypeService {

    /**
     * 添加工单类型
     */
    public ResultEntity addWorkorderType(WorkorderType workorderType);

    /**
     * 批量删除工单类型
     */
    public ResultEntity deleteWorkorderType(String workorderTypeIds);

    /**
     * 修改工单类型
     */
    public ResultEntity updateWorkorderType(WorkorderType workorderType);

    /**
     * 浏览工单类型
     */
    public ResultEntity getWorkorderType(String workorderTypeId);

    /**
     * 工单分类列表查询
     */
    public ResultEntity getWorkorderTypeList();
}
