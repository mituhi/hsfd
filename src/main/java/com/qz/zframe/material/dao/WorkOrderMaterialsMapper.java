package com.qz.zframe.material.dao;

import com.qz.zframe.common.util.BaseMapper;
import com.qz.zframe.material.entity.WorkOrderMaterials;
import com.qz.zframe.material.entity.WorkOrderMaterialsExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface WorkOrderMaterialsMapper extends BaseMapper<WorkOrderMaterials, WorkOrderMaterialsExample, Long> {
    
}