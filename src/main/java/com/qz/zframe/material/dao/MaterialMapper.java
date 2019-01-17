package com.qz.zframe.material.dao;

import com.qz.zframe.common.util.BaseMapper;
import com.qz.zframe.material.entity.Material;
import com.qz.zframe.material.entity.MaterialExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MaterialMapper extends BaseMapper<Material, MaterialExample, Long>{

	/**
	 * 批量删除
	 * 
	 * @param @param params
	 * @param @return    参数
	 * @return int    返回类型
	 * @throws
	 */
	public int updateIsdete(Map<String, Object> params);

	public String selectMaxMaterialCode();
   
}