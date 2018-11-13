package com.qz.zframe.maintain.mapper;

import com.qz.zframe.maintain.entity.MaintainWeekPlan;
import com.qz.zframe.maintain.entity.MaintainWeekPlanExample;
import com.qz.zframe.maintain.vo.MaintainWeekPlanVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface MaintainWeekPlanMapper {
    int countByExample(MaintainWeekPlanExample example);

    int deleteByExample(MaintainWeekPlanExample example);

    int deleteByPrimaryKey(String weekId);

    int insert(MaintainWeekPlan record);

    int insertSelective(MaintainWeekPlan record);
    //批量删除
    int batchDelete(@Param("array") String[] ids);
    //详情查询
    MaintainWeekPlanVo getMaintainWeekPlanDetail(@Param("weekId") String weekId);
    //分页+条件列表查询
    List<MaintainWeekPlanVo> getMaintainWeekPlanList(@Param("map") Map<String, String> pageAndCondition);
    //根据条件查询总记录数
    int getTotal(@Param("map") Map<String, String> pageAndCondition);

    List<MaintainWeekPlan> selectByExample(MaintainWeekPlanExample example);

    MaintainWeekPlan selectByPrimaryKey(String weekId);

    int updateByExampleSelective(@Param("record") MaintainWeekPlan record, @Param("example") MaintainWeekPlanExample example);

    int updateByExample(@Param("record") MaintainWeekPlan record, @Param("example") MaintainWeekPlanExample example);

    int updateByPrimaryKeySelective(MaintainWeekPlan record);

    int updateByPrimaryKey(MaintainWeekPlan record);
}