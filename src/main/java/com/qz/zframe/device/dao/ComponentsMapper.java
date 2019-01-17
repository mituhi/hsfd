package com.qz.zframe.device.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.qz.zframe.common.util.BaseMapper;
import com.qz.zframe.device.entity.Components;
import com.qz.zframe.device.entity.ComponentsExample;
@Mapper
public interface ComponentsMapper extends BaseMapper<Components, ComponentsExample, Long>{
    int countByExample(ComponentsExample example);

    int deleteByExample(ComponentsExample example);

    int deleteByPrimaryKey(String componentId);

    int deleteByPrimaryKeyList(List<String> componentIds);
    
    int insert(Components record);

    int insertSelective(Components record);

    List<Components> selectByExample(ComponentsExample example);

    Components selectByPrimaryKey(String componentId);
    
    List<Components>  selectById(String equipmentAssetId);

    int updateByExampleSelective(@Param("record") Components record, @Param("example") ComponentsExample example);

    int updateByExample(@Param("record") Components record, @Param("example") ComponentsExample example);

    int updateByPrimaryKeySelective(Components record);

    int updateByPrimaryKey(Components record);
}