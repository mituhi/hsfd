package com.qz.zframe.maintain.mapper;

import com.qz.zframe.maintain.entity.BreakdownDealwithMode;
import com.qz.zframe.maintain.entity.BreakdownDealwithModeExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BreakdownDealwithModeMapper {
    int countByExample(BreakdownDealwithModeExample example);

    int deleteByExample(BreakdownDealwithModeExample example);

    int deleteByPrimaryKey(String modeId);

    int insert(BreakdownDealwithMode record);

    int insertSelective(BreakdownDealwithMode record);

    List<BreakdownDealwithMode> selectByExample(BreakdownDealwithModeExample example);

    BreakdownDealwithMode selectByPrimaryKey(String modeId);

    int updateByExampleSelective(@Param("record") BreakdownDealwithMode record, @Param("example") BreakdownDealwithModeExample example);

    int updateByExample(@Param("record") BreakdownDealwithMode record, @Param("example") BreakdownDealwithModeExample example);

    int updateByPrimaryKeySelective(BreakdownDealwithMode record);

    int updateByPrimaryKey(BreakdownDealwithMode record);
}