package com.qz.zframe.maintain.mapper;

import com.qz.zframe.maintain.entity.BreakdownAttribute;
import com.qz.zframe.maintain.entity.BreakdownAttributeExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BreakdownAttributeMapper {
    int countByExample(BreakdownAttributeExample example);

    int deleteByExample(BreakdownAttributeExample example);

    int deleteByPrimaryKey(String attributeId);

    int insert(BreakdownAttribute record);

    int insertSelective(BreakdownAttribute record);

    List<BreakdownAttribute> selectByExample(BreakdownAttributeExample example);

    BreakdownAttribute selectByPrimaryKey(String attributeId);

    int updateByExampleSelective(@Param("record") BreakdownAttribute record, @Param("example") BreakdownAttributeExample example);

    int updateByExample(@Param("record") BreakdownAttribute record, @Param("example") BreakdownAttributeExample example);

    int updateByPrimaryKeySelective(BreakdownAttribute record);

    int updateByPrimaryKey(BreakdownAttribute record);
}