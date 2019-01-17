package com.qz.zframe.maintain.service;

import com.qz.zframe.common.entity.SpFileUpload;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.file.FileException;
import com.qz.zframe.maintain.vo.CancelFileVo;
import com.qz.zframe.maintain.vo.DefectWorkorderVo;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

public interface DefectWorkorderService {

    /**
     * 添加缺陷工单
     */
    ResultEntity addDefectWorkorder(DefectWorkorderVo defectWorkorderVo);

    /**
     * 修改缺陷工单
     */
    ResultEntity updateDefectWorkorder(DefectWorkorderVo defectWorkorderVo);

    /**
     * 提交缺陷工单
     */
    ResultEntity submitDefectWorkorder(DefectWorkorderVo defectWorkorderVo) throws Exception;

    /**
     * 删除缺陷工单
     */
    ResultEntity deleteDefectWorkorder(String[] workorderIds);

    /**
     * 浏览缺陷工单
     */
    ResultEntity getDefectWorkorderDetail(String workorderId) throws Exception;

    /**
     * 缺陷工单分页+条件查询
     */
    PageResultEntity getDefectWorkorderList(Map<String,String> pageAndCondition) throws Exception;

    /**
     * 审批-同意
     */
    ResultEntity agreeDefectWorkorder(DefectWorkorderVo defectWorkorderVo);

    /**
     * 审批-退回
     */
    ResultEntity backDefectWorkorder(DefectWorkorderVo defectWorkorderVo);

    /**
     * 流程状态列表查询
     */
    ResultEntity getFlowStatusList(String workorderId);

    /**
     * 根据工单号查询缺陷工单
     */
    ResultEntity getDefectWorkorderBySerialNumber(String serialNumber);

    /**
     * 根据工单号和库存地查询物资列表
     */
    ResultEntity getWorkorderMaterialList(String serialNumber,String stockAddId);

    /**
     * 取消修改文件
     */
    ResultEntity cancelChangeDefectFile(CancelFileVo cancelFileVo);
}
