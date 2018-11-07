package com.qz.zframe.device.dao;

import com.qz.zframe.common.util.BaseMapper;
import com.qz.zframe.device.entity.EquipmentClassification;
import com.qz.zframe.device.entity.EquipmentClassificationExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface EquipmentClassificationMapper extends BaseMapper<EquipmentClassification, EquipmentClassificationExample, Long>{
    int countByExample(EquipmentClassificationExample example);

    int deleteByExample(EquipmentClassificationExample example);

    int deleteByPrimaryKey(String equipmentId);
    
    int deleteByPrimaryKeyList(List<String> equipmentIds);//@Param("list")

    int insert(EquipmentClassification record);

    int insertSelective(EquipmentClassification record);

    List<EquipmentClassification> selectByExample(EquipmentClassificationExample example);

    EquipmentClassification selectByPrimaryKey(String equipmentId);

    int updateByExampleSelective(@Param("record") EquipmentClassification record, @Param("example") EquipmentClassificationExample example);

    int updateByExample(@Param("record") EquipmentClassification record, @Param("example") EquipmentClassificationExample example);

    int updateByPrimaryKeySelective(EquipmentClassification record);

    int updateByPrimaryKey(EquipmentClassification record);
    
    List<EquipmentClassification> selectStructure();
    
    List<EquipmentClassification> selectStructureList(String superiorEquipment);
}