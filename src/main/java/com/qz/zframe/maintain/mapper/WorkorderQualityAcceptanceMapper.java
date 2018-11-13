package com.qz.zframe.maintain.mapper;

import com.qz.zframe.maintain.entity.WorkorderQualityAcceptance;
import com.qz.zframe.maintain.entity.WorkorderQualityAcceptanceExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface WorkorderQualityAcceptanceMapper {
    int countByExample(WorkorderQualityAcceptanceExample example);

    int deleteByExample(WorkorderQualityAcceptanceExample example);

    int deleteByPrimaryKey(String qualityAcceptanceId);

    int insert(WorkorderQualityAcceptance record);

    int insertSelective(WorkorderQualityAcceptance record);

    List<WorkorderQualityAcceptance> selectByExample(WorkorderQualityAcceptanceExample example);

    WorkorderQualityAcceptance selectByPrimaryKey(String qualityAcceptanceId);

    int updateByExampleSelective(@Param("record") WorkorderQualityAcceptance record, @Param("example") WorkorderQualityAcceptanceExample example);

    int updateByExample(@Param("record") WorkorderQualityAcceptance record, @Param("example") WorkorderQualityAcceptanceExample example);

    int updateByPrimaryKeySelective(WorkorderQualityAcceptance record);

    int updateByPrimaryKey(WorkorderQualityAcceptance record);
}