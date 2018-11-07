package com.qz.zframe.run.dao;

import com.qz.zframe.run.entity.SchedulingManagement;
import com.qz.zframe.run.entity.SchedulingManagementExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SchedulingManagementMapper {
    int countByExample(SchedulingManagementExample example);

    int deleteByExample(SchedulingManagementExample example);

    int deleteByPrimaryKey(String schedulingManagementId);

    int insert(SchedulingManagement record);

    int insertSelective(SchedulingManagement record);

    List<SchedulingManagement> selectByExample(SchedulingManagementExample example);

    SchedulingManagement selectByPrimaryKey(String schedulingManagementId);

    int updateByExampleSelective(@Param("record") SchedulingManagement record, @Param("example") SchedulingManagementExample example);

    int updateByExample(@Param("record") SchedulingManagement record, @Param("example") SchedulingManagementExample example);

    int updateByPrimaryKeySelective(SchedulingManagement record);

    int updateByPrimaryKey(SchedulingManagement record);
}