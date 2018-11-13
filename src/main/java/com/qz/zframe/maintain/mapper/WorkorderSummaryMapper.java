package com.qz.zframe.maintain.mapper;

import com.qz.zframe.maintain.entity.WorkorderSummary;
import com.qz.zframe.maintain.entity.WorkorderSummaryExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface WorkorderSummaryMapper {
    int countByExample(WorkorderSummaryExample example);

    int deleteByExample(WorkorderSummaryExample example);

    int deleteByPrimaryKey(String summaryId);

    int insert(WorkorderSummary record);

    int insertSelective(WorkorderSummary record);

    List<WorkorderSummary> selectByExample(WorkorderSummaryExample example);

    WorkorderSummary selectByPrimaryKey(String summaryId);

    int updateByExampleSelective(@Param("record") WorkorderSummary record, @Param("example") WorkorderSummaryExample example);

    int updateByExample(@Param("record") WorkorderSummary record, @Param("example") WorkorderSummaryExample example);

    int updateByPrimaryKeySelective(WorkorderSummary record);

    int updateByPrimaryKey(WorkorderSummary record);
}