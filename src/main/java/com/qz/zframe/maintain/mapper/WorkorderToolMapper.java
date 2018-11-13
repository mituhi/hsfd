package com.qz.zframe.maintain.mapper;

import com.qz.zframe.maintain.entity.WorkorderTool;
import com.qz.zframe.maintain.entity.WorkorderToolExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface WorkorderToolMapper {
    int countByExample(WorkorderToolExample example);

    int deleteByExample(WorkorderToolExample example);

    int deleteByPrimaryKey(String toolId);

    int insert(WorkorderTool record);

    int insertSelective(WorkorderTool record);

    List<WorkorderTool> selectByExample(WorkorderToolExample example);

    WorkorderTool selectByPrimaryKey(String toolId);

    int updateByExampleSelective(@Param("record") WorkorderTool record, @Param("example") WorkorderToolExample example);

    int updateByExample(@Param("record") WorkorderTool record, @Param("example") WorkorderToolExample example);

    int updateByPrimaryKeySelective(WorkorderTool record);

    int updateByPrimaryKey(WorkorderTool record);
}