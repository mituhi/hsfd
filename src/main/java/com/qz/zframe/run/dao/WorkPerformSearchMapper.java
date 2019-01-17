package com.qz.zframe.run.dao;

import com.qz.zframe.run.entity.WorkPerformSearch;
import com.qz.zframe.run.entity.WorkPerformSearchExample;
import com.qz.zframe.run.entity.submit.WorkPerformSearchSubmit;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface WorkPerformSearchMapper {
    int countByExample(WorkPerformSearchExample example);

    int deleteByExample(WorkPerformSearchExample example);

    int insert(WorkPerformSearch record);

    int insertSelective(WorkPerformSearch record);

    List<WorkPerformSearch> selectByExample(WorkPerformSearchExample example);

    int updateByExampleSelective(@Param("record") WorkPerformSearch record, @Param("example") WorkPerformSearchExample example);

    int updateByExample(@Param("record") WorkPerformSearch record, @Param("example") WorkPerformSearchExample example);
    
    List<WorkPerformSearch> ListworkPerformSearch(WorkPerformSearchSubmit submit);
    
}