package com.qz.zframe.maintain.service;

import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.maintain.vo.CancelFileVo;
import com.qz.zframe.maintain.vo.FileInfo;
import com.qz.zframe.maintain.vo.WorkorderVo;

import java.util.List;
import java.util.Map;

public interface WorkorderService {

    /**
     * 工单策划
     */
    ResultEntity addWorkorder(WorkorderVo workorderVo);

    /**
     * 修改工单
     */
    ResultEntity updateWorkorder(WorkorderVo workorderVo);

    /**
     * 提交工单
     */
    ResultEntity submitWorkorder(WorkorderVo workorderVo) throws Exception;

    /**
     * 批量删除工单
     */
    ResultEntity deleteWorkorder(String[] orderIds);

    /**
     * 工单详情查询
     */
    ResultEntity getWorkorderDetail(String orderId) throws Exception;

    /**
     * 工单列表分页+条件查询
     */
    PageResultEntity getWorkorderList(Map<String,String> pageAndCondition) throws Exception;

    /**
     * 进入下一流程节点
     */
    ResultEntity agreeWorkorder(WorkorderVo workorderVo);

    /**
     * 退回上一流程节点
     */
    ResultEntity backWorkorder(WorkorderVo workorderVo);

    /**
     * 流程状态列表查询
     */
    ResultEntity getFlowStatusList(String orderId);

    /**
     * 取消修改文件
     */
    ResultEntity cancelChangeFile(String orderId, List<FileInfo> fileIds);

}
