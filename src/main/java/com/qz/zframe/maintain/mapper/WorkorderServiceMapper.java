package com.qz.zframe.maintain.mapper;

import com.qz.zframe.maintain.entity.WorkorderService;
import com.qz.zframe.maintain.entity.WorkorderServiceExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface WorkorderServiceMapper {
    int countByExample(WorkorderServiceExample example);

    int deleteByExample(WorkorderServiceExample example);

    int deleteByPrimaryKey(String serviceId);

    int insert(WorkorderService record);

    int insertSelective(WorkorderService record);

    //根据缺陷工单ids批量删除
    int batchDeleteByWorkOrderIds(@Param("list") List<String> workorderIdList);

    //根据工单ids批量删除
    int batchDeleteByOrderIds(@Param("list") List<String> orderIdList);

    //根据故障知识ids批量删除
    int batchDeleteByKnowledgeIds(@Param("list") List<String> knowledgeIdList);

    List<WorkorderService> selectByExample(WorkorderServiceExample example);

    WorkorderService selectByPrimaryKey(String serviceId);

    int updateByExampleSelective(@Param("record") WorkorderService record, @Param("example") WorkorderServiceExample example);

    int updateByExample(@Param("record") WorkorderService record, @Param("example") WorkorderServiceExample example);

    int updateByPrimaryKeySelective(WorkorderService record);

    int updateByPrimaryKey(WorkorderService record);
}