package com.qz.zframe.device.dao;

import com.qz.zframe.common.util.BaseMapper;
import com.qz.zframe.device.entity.EquipmentAssetLedger;
import com.qz.zframe.device.entity.EquipmentAssetLedgerExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface EquipmentAssetLedgerMapper extends BaseMapper<EquipmentAssetLedger, EquipmentAssetLedgerExample, Long>{
    int countByExample(EquipmentAssetLedgerExample example);

    int countByExamples(EquipmentAssetLedgerExample example);
    
    int deleteByExample(EquipmentAssetLedgerExample example);

    int deleteByPrimaryKey(String equipmentAssetId);

    int deleteByPrimaryKeyList(List<String> equipmentAssetIds);
    
    int insert(EquipmentAssetLedger record);

    int insertSelective(EquipmentAssetLedger record);

    List<EquipmentAssetLedger> selectByExampleWithBLOBs(EquipmentAssetLedgerExample example);

    List<EquipmentAssetLedger> selectByExample(EquipmentAssetLedgerExample example);

    List<EquipmentAssetLedger> selectByExamples(EquipmentAssetLedgerExample example);
    
    EquipmentAssetLedger selectByPrimaryKey(String equipmentAssetId);
    
    EquipmentAssetLedger selectByPrimaryKeys(String equipmentAssetId);

    int updateByExampleSelective(@Param("record") EquipmentAssetLedger record, @Param("example") EquipmentAssetLedgerExample example);

    int updateByExampleWithBLOBs(@Param("record") EquipmentAssetLedger record, @Param("example") EquipmentAssetLedgerExample example);

    int updateByExample(@Param("record") EquipmentAssetLedger record, @Param("example") EquipmentAssetLedgerExample example);

    int updateByPrimaryKeySelective(EquipmentAssetLedger record);

    int updateByPrimaryKeyWithBLOBs(EquipmentAssetLedger record);

    int updateByPrimaryKey(EquipmentAssetLedger record);
}