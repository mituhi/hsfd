package com.qz.zframe.maintain.mapper;

import com.qz.zframe.maintain.entity.DefectDealMode;
import com.qz.zframe.maintain.entity.DefectDealModeExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DefectDealModeMapper {
    int countByExample(DefectDealModeExample example);

    int deleteByExample(DefectDealModeExample example);

    int deleteByPrimaryKey(String modeId);

    int insert(DefectDealMode record);

    int insertSelective(DefectDealMode record);

    List<DefectDealMode> selectByExample(DefectDealModeExample example);

    DefectDealMode selectByPrimaryKey(String modeId);

    int updateByExampleSelective(@Param("record") DefectDealMode record, @Param("example") DefectDealModeExample example);

    int updateByExample(@Param("record") DefectDealMode record, @Param("example") DefectDealModeExample example);

    int updateByPrimaryKeySelective(DefectDealMode record);

    int updateByPrimaryKey(DefectDealMode record);
}