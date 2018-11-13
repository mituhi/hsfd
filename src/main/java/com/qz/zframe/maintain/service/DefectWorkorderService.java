package com.qz.zframe.maintain.service;

import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.maintain.vo.DefectWorkorderVo;

import java.util.Map;

public interface DefectWorkorderService {

    /**
     * 添加缺陷工单
     */
    public ResultEntity addDefectWorkorder(DefectWorkorderVo defectWorkorderVo);

    /**
     * 删除缺陷工单
     */
    public ResultEntity deleteDefectWorkorder(String workorderIds);

    /**
     * 修改缺陷工单
     */
    public ResultEntity updateDefectWorkorder(DefectWorkorderVo defectWorkorderVo);

    /**
     * 删除缺陷工单
     */
    public ResultEntity getDefectWorkorderDetail(String workorderId);

    /**
     * 缺陷工单分页+条件查询
     */
    public PageResultEntity getDefectWorkorderList(Map<String,String> pageAndCondition);
}
