package com.qz.zframe.run.dao;

import com.qz.zframe.run.entity.SchedulingAssociated;
import com.qz.zframe.run.entity.SchedulingAssociatedExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SchedulingAssociatedMapper {
    int countByExample(SchedulingAssociatedExample example);

    int deleteByExample(SchedulingAssociatedExample example);

    int deleteByPrimaryKey(String id);

    int insert(SchedulingAssociated record);

    int insertSelective(SchedulingAssociated record);

    List<SchedulingAssociated> selectByExample(SchedulingAssociatedExample example);

    SchedulingAssociated selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SchedulingAssociated record, @Param("example") SchedulingAssociatedExample example);

    int updateByExample(@Param("record") SchedulingAssociated record, @Param("example") SchedulingAssociatedExample example);

    int updateByPrimaryKeySelective(SchedulingAssociated record);

    int updateByPrimaryKey(SchedulingAssociated record);
}