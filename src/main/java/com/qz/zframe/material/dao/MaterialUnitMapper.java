package com.qz.zframe.material.dao;

import com.qz.zframe.material.entity.MaterialUnit;
import com.qz.zframe.material.entity.MaterialUnitExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MaterialUnitMapper {
    int countByExample(MaterialUnitExample example);

    int deleteByExample(MaterialUnitExample example);

    int deleteByPrimaryKey(String measuringUnitId);

    int insert(MaterialUnit record);

    int insertSelective(MaterialUnit record);

    List<MaterialUnit> selectByExample(MaterialUnitExample example);

    MaterialUnit selectByPrimaryKey(String measuringUnitId);

    int updateByExampleSelective(@Param("record") MaterialUnit record, @Param("example") MaterialUnitExample example);

    int updateByExample(@Param("record") MaterialUnit record, @Param("example") MaterialUnitExample example);

    int updateByPrimaryKeySelective(MaterialUnit record);

    int updateByPrimaryKey(MaterialUnit record);

	void deleteByIds(List<String> measuringUnitIds);
}