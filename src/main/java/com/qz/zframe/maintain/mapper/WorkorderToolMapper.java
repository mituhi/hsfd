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

    //根据缺陷工单ids批量删除
    int batchDeleteByWorkOrderIds(@Param("list") List<String> workorderIdList);

    //根据工单ids批量删除
    int batchDeleteByOrderIds(@Param("list") List<String> orderIdList);

    //根据故障知识ids批量删除
    int batchDeleteByKnowledgeIds(@Param("list") List<String> knowledgeIdList);

    List<WorkorderTool> selectByExample(WorkorderToolExample example);

    WorkorderTool selectByPrimaryKey(String toolId);

    int updateByExampleSelective(@Param("record") WorkorderTool record, @Param("example") WorkorderToolExample example);

    int updateByExample(@Param("record") WorkorderTool record, @Param("example") WorkorderToolExample example);

    int updateByPrimaryKeySelective(WorkorderTool record);

    int updateByPrimaryKey(WorkorderTool record);
}