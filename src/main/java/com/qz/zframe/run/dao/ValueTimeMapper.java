package com.qz.zframe.run.dao;

import com.qz.zframe.run.entity.ValueTime;
import com.qz.zframe.run.entity.ValueTimeExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ValueTimeMapper {
    int countByExample(ValueTimeExample example);

    int deleteByExample(ValueTimeExample example);

    int deleteByPrimaryKey(String valueId);

    int insert(ValueTime record);

    int insertSelective(ValueTime record);

    List<ValueTime> selectByExample(ValueTimeExample example);

    ValueTime selectByPrimaryKey(String valueId);

    int updateByExampleSelective(@Param("record") ValueTime record, @Param("example") ValueTimeExample example);

    int updateByExample(@Param("record") ValueTime record, @Param("example") ValueTimeExample example);

    int updateByPrimaryKeySelective(ValueTime record);

    int updateByPrimaryKey(ValueTime record);
    
    void deleteValueTime(List<String> ids);
	
	List<ValueTime> listValueTime(ValueTime valueTime);
	
	ValueTime selectMaxSort();
	
	List<ValueTime> getValueTimeBySchedulingRuleId(String schedulingRuleId);
}