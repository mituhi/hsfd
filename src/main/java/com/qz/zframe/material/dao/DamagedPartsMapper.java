package com.qz.zframe.material.dao;

import com.qz.zframe.common.util.BaseMapper;
import com.qz.zframe.material.entity.DamagedParts;
import com.qz.zframe.material.entity.DamagedPartsExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface DamagedPartsMapper extends BaseMapper<DamagedParts, DamagedPartsExample, Long>{

	void delByPartsIds(List<String> damagedPartsIds);
  
}