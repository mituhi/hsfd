package com.qz.zframe.maintain.mapper;

import com.qz.zframe.maintain.entity.WorkorderDangerPoint;
import com.qz.zframe.maintain.entity.WorkorderDangerPointExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface WorkorderDangerPointMapper {
    int countByExample(WorkorderDangerPointExample example);

    int deleteByExample(WorkorderDangerPointExample example);

    int deleteByPrimaryKey(String dangerPointId);

    int insert(WorkorderDangerPoint record);

    int insertSelective(WorkorderDangerPoint record);

    List<WorkorderDangerPoint> selectByExample(WorkorderDangerPointExample example);

    WorkorderDangerPoint selectByPrimaryKey(String dangerPointId);

    int updateByExampleSelective(@Param("record") WorkorderDangerPoint record, @Param("example") WorkorderDangerPointExample example);

    int updateByExample(@Param("record") WorkorderDangerPoint record, @Param("example") WorkorderDangerPointExample example);

    int updateByPrimaryKeySelective(WorkorderDangerPoint record);

    int updateByPrimaryKey(WorkorderDangerPoint record);
}