package com.qz.zframe.run.dao;

import com.qz.zframe.run.entity.Shift;
import com.qz.zframe.run.entity.ShiftExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShiftMapper {
    int countByExample(ShiftExample example);

    int deleteByExample(ShiftExample example);

    int deleteByPrimaryKey(String shiftId);

    int insert(Shift record);

    int insertSelective(Shift record);

    List<Shift> selectByExample(ShiftExample example);

    Shift selectByPrimaryKey(String shiftId);

    int updateByExampleSelective(@Param("record") Shift record, @Param("example") ShiftExample example);

    int updateByExample(@Param("record") Shift record, @Param("example") ShiftExample example);

    int updateByPrimaryKeySelective(Shift record);

    int updateByPrimaryKey(Shift record);
    
    Shift selectMaxSort();
    
    int  selectCount();
	
	Shift selectSort(int sort);
}