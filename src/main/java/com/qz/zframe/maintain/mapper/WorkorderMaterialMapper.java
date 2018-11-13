package com.qz.zframe.maintain.mapper;

import com.qz.zframe.maintain.entity.WorkorderMaterial;
import com.qz.zframe.maintain.entity.WorkorderMaterialExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface WorkorderMaterialMapper {
    int countByExample(WorkorderMaterialExample example);

    int deleteByExample(WorkorderMaterialExample example);

    int deleteByPrimaryKey(String workorderMaterialId);

    int insert(WorkorderMaterial record);

    int insertSelective(WorkorderMaterial record);

    List<WorkorderMaterial> selectByExample(WorkorderMaterialExample example);

    WorkorderMaterial selectByPrimaryKey(String workorderMaterialId);

    int updateByExampleSelective(@Param("record") WorkorderMaterial record, @Param("example") WorkorderMaterialExample example);

    int updateByExample(@Param("record") WorkorderMaterial record, @Param("example") WorkorderMaterialExample example);

    int updateByPrimaryKeySelective(WorkorderMaterial record);

    int updateByPrimaryKey(WorkorderMaterial record);
}