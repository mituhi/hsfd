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

    List<WorkorderService> selectByExample(WorkorderServiceExample example);

    WorkorderService selectByPrimaryKey(String serviceId);

    int updateByExampleSelective(@Param("record") WorkorderService record, @Param("example") WorkorderServiceExample example);

    int updateByExample(@Param("record") WorkorderService record, @Param("example") WorkorderServiceExample example);

    int updateByPrimaryKeySelective(WorkorderService record);

    int updateByPrimaryKey(WorkorderService record);
}