package com.qz.zframe.run.dao;

import com.qz.zframe.common.util.BaseMapper;
import com.qz.zframe.run.entity.MainEquipment;
import com.qz.zframe.run.entity.MainEquipmentExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MainEquipmentMapper extends BaseMapper<MainEquipment, MainEquipmentExample, Long>{
    int countByExample(MainEquipmentExample example);

    int deleteByExample(MainEquipmentExample example);

    int deleteByPrimaryKey(List<String> mainEquipmentIds);

    int insert(MainEquipment record);

    int insertSelective(MainEquipment record);
   
    List<MainEquipment> selectByExample(MainEquipmentExample example);

    MainEquipment selectByPrimaryKey(String mainEquipmentId);

    int updateByExampleSelective(@Param("record") MainEquipment record, @Param("example") MainEquipmentExample example);

    int updateByExample(@Param("record") MainEquipment record, @Param("example") MainEquipmentExample example);

    int updateByPrimaryKeySelective(MainEquipment record);

    int updateByPrimaryKey(MainEquipment record);
}