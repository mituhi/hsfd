package com.qz.zframe.run.dao;

import com.qz.zframe.run.entity.MainEquipmentInfo;
import com.qz.zframe.run.entity.MainEquipmentInfoExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MainEquipmentInfoMapper {
    int countByExample(MainEquipmentInfoExample example);

    int deleteByExample(MainEquipmentInfoExample example);

    int deleteByPrimaryKey(String mainEquipmentInfoId);

    int insert(MainEquipmentInfo record);

    int insertSelective(MainEquipmentInfo record);

    List<MainEquipmentInfo> selectByExample(MainEquipmentInfoExample example);

    MainEquipmentInfo selectByPrimaryKey(String mainEquipmentInfoId);

    int updateByExampleSelective(@Param("record") MainEquipmentInfo record, @Param("example") MainEquipmentInfoExample example);

    int updateByExample(@Param("record") MainEquipmentInfo record, @Param("example") MainEquipmentInfoExample example);

    int updateByPrimaryKeySelective(MainEquipmentInfo record);

    int updateByPrimaryKey(MainEquipmentInfo record);
}