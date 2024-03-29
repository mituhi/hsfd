package com.qz.zframe.maintain.service;

import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.maintain.vo.MaintainWeekPlanVo;

import java.util.Map;

public interface MaintainWeekPlanService {

    /**
     * 添加维护周计划
     */
    ResultEntity addMaintainWeekPlan(MaintainWeekPlanVo maintainWeekPlanVo);

    /**
     * 修改维护周计划
     */
    ResultEntity updateMaintainWeekPlan(MaintainWeekPlanVo maintainWeekPlanVo);

    /**
     * 批量删除
     */
    ResultEntity deleteMaintainWeekPlan(String[] weekIds);

    /**
     * 浏览维护周计划
     */
    ResultEntity getMaintainWeekPlanDetail(String weekId);

    /**
     * 列表查询
     */
    PageResultEntity getMaintainWeekPlanList(Map<String,String> pageAndCondition);

}
