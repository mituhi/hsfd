package com.qz.zframe.maintain.mapper;

import com.qz.zframe.maintain.entity.BreakdownLocation;
import com.qz.zframe.maintain.entity.BreakdownLocationExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BreakdownLocationMapper {
    int countByExample(BreakdownLocationExample example);

    int deleteByExample(BreakdownLocationExample example);

    int deleteByPrimaryKey(String locationId);

    int insert(BreakdownLocation record);

    int insertSelective(BreakdownLocation record);

    List<BreakdownLocation> selectByExample(BreakdownLocationExample example);

    BreakdownLocation selectByPrimaryKey(String locationId);

    int updateByExampleSelective(@Param("record") BreakdownLocation record, @Param("example") BreakdownLocationExample example);

    int updateByExample(@Param("record") BreakdownLocation record, @Param("example") BreakdownLocationExample example);

    int updateByPrimaryKeySelective(BreakdownLocation record);

    int updateByPrimaryKey(BreakdownLocation record);
}