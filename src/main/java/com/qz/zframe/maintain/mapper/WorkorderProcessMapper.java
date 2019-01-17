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

    //根据缺陷工单ids批量删除
    int batchDeleteByWorkOrderIds(@Param("list") List<String> workorderIdList);

    //根据工单ids批量删除
    int batchDeleteByOrderIds(@Param("list") List<String> orderIdList);

    //根据故障知识ids批量删除
    int batchDeleteByKnowledgeIds(@Param("list") List<String> knowledgeIdList);

    List<WorkorderProcess> selectByExample(WorkorderProcessExample example);

    WorkorderProcess selectByPrimaryKey(String processId);

    int updateByExampleSelective(@Param("record") WorkorderProcess record, @Param("example") WorkorderProcessExample example);

    int updateByExample(@Param("record") WorkorderProcess record, @Param("example") WorkorderProcessExample example);

    int updateByPrimaryKeySelective(WorkorderProcess record);

    int updateByPrimaryKey(WorkorderProcess record);
}