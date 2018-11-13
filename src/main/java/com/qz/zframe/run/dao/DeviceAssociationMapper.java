package com.qz.zframe.run.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.qz.zframe.run.entity.DeviceAssociation;
import com.qz.zframe.run.entity.DeviceAssociationExample;
import com.qz.zframe.run.entity.MainEquipment;
import com.qz.zframe.run.entity.result.DeviceAssociationResult;

@Mapper
public interface DeviceAssociationMapper {
    int countByExample(DeviceAssociationExample example);

    int deleteByExample(DeviceAssociationExample example);

    int deleteByPrimaryKey(String deviceAssociationId);

    int insert(DeviceAssociation record);

    int insertSelective(DeviceAssociation record);

    List<DeviceAssociation> selectByExample(DeviceAssociationExample example);

    DeviceAssociation selectByPrimaryKey(String deviceAssociationId);

    int updateByExampleSelective(@Param("record") DeviceAssociation record, @Param("example") DeviceAssociationExample example);

    int updateByExample(@Param("record") DeviceAssociation record, @Param("example") DeviceAssociationExample example);

    int updateByPrimaryKeySelective(DeviceAssociation record);

    int updateByPrimaryKey(DeviceAssociation record);
    
    List<DeviceAssociationResult> listDeviceAssociationResult(MainEquipment mainEquipment);
}