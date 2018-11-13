package com.qz.zframe.run.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.qz.zframe.run.entity.DeviceType;
import com.qz.zframe.run.entity.DeviceTypeExample;

@Mapper
public interface DeviceTypeMapper {
    int countByExample(DeviceTypeExample example);

    int deleteByExample(DeviceTypeExample example);

    int deleteByPrimaryKey(String typeId);

    int insert(DeviceType record);

    int insertSelective(DeviceType record);

    List<DeviceType> selectByExample(DeviceTypeExample example);

    DeviceType selectByPrimaryKey(String typeId);

    int updateByExampleSelective(@Param("record") DeviceType record, @Param("example") DeviceTypeExample example);

    int updateByExample(@Param("record") DeviceType record, @Param("example") DeviceTypeExample example);

    int updateByPrimaryKeySelective(DeviceType record);

    int updateByPrimaryKey(DeviceType record);
    
    DeviceType selectMaxSort();
}