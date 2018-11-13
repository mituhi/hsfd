package com.qz.zframe.maintain.mapper;

import com.qz.zframe.maintain.entity.WorkorderProcess;
import com.qz.zframe.maintain.entity.WorkorderProcessExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface WorkorderProcessMapper {
    int countByExample(WorkorderProcessExample example);

    int deleteByExample(WorkorderProcessExample example);

    int deleteByPrimaryKey(String processId);

    int insert(WorkorderProcess record);

    int insertSelective(WorkorderProcess record);

    List<WorkorderProcess> selectByExample(WorkorderProcessExample example);

    WorkorderProcess selectByPrimaryKey(String processId);

    int updateByExampleSelective(@Param("record") WorkorderProcess record, @Param("example") WorkorderProcessExample example);

    int updateByExample(@Param("record") WorkorderProcess record, @Param("example") WorkorderProcessExample example);

    int updateByPrimaryKeySelective(WorkorderProcess record);

    int updateByPrimaryKey(WorkorderProcess record);
}