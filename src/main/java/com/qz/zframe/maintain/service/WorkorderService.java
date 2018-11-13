package com.qz.zframe.maintain.service;

import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.maintain.vo.WorkorderVo;

import java.util.Map;

public interface WorkorderService {

    /**
     * 工单策划
     */
    public ResultEntity addWorkorder(WorkorderVo workorderVo);

    /**
     * 批量删除工单
     */
    public ResultEntity deleteWorkorder(String orderIds);

    /**
     * 修改工单
     */
    public ResultEntity updateWorkorder(WorkorderVo workorderVo);

    /**
     * 工单详情查询
     */
    public ResultEntity getWorkorderDetail(String orderId);

    /**
     * 工单列表分页+条件查询
     */
    public PageResultEntity getWorkorderList(Map<String,String> pageAndCondition);
}
