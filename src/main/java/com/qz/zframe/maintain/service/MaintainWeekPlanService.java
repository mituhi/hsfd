package com.qz.zframe.maintain.service;

import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.maintain.vo.MaintainWeekPlanVo;

import java.util.Map;

public interface MaintainWeekPlanService {

    /**
     * 添加维护周计划
     */
    public ResultEntity addMaintainWeekPlan(MaintainWeekPlanVo maintainWeekPlanVo);

    /**
     * 批量删除
     */
    public ResultEntity deleteMaintainWeekPlan(String weekIds);

    /**
     * 修改维护周计划
     */
    public ResultEntity updateMaintainWeekPlan(MaintainWeekPlanVo maintainWeekPlanVo);

    /**
     * 浏览维护周计划
     */
    public ResultEntity getMaintainWeekPlanDetail(String weekId);

    /**
     * 列表查询
     */
    public PageResultEntity getMaintainWeekPlanList(Map<String,String> pageAndCondition);

}
