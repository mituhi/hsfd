package com.qz.zframe.maintain.mapper;

import com.qz.zframe.maintain.entity.WorkorderFlowRecord;
import com.qz.zframe.maintain.entity.WorkorderFlowRecordExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface WorkorderFlowRecordMapper {
    int countByExample(WorkorderFlowRecordExample example);

    int deleteByExample(WorkorderFlowRecordExample example);

    int deleteByPrimaryKey(String recordId);

    int insert(WorkorderFlowRecord record);

    int insertSelective(WorkorderFlowRecord record);

    List<WorkorderFlowRecord> selectByExample(WorkorderFlowRecordExample example);

    WorkorderFlowRecord selectByPrimaryKey(String recordId);

    int updateByExampleSelective(@Param("record") WorkorderFlowRecord record, @Param("example") WorkorderFlowRecordExample example);

    int updateByExample(@Param("record") WorkorderFlowRecord record, @Param("example") WorkorderFlowRecordExample example);

    int updateByPrimaryKeySelective(WorkorderFlowRecord record);

    int updateByPrimaryKey(WorkorderFlowRecord record);
}