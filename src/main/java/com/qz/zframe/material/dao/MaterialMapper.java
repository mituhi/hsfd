package com.qz.zframe.material.dao;

import com.qz.zframe.common.util.BaseMapper;
import com.qz.zframe.material.entity.Material;
import com.qz.zframe.material.entity.MaterialExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MaterialMapper extends BaseMapper<Material, MaterialExample, Long>{
	
	/**
	 * 删除物资（将状态设为删除）
	 * 
	 * @param @param materialIds    参数
	 * @return void    返回类型
	 * @throws
	 */
	public void delMaterial(List<String> materialIds);

	/**
	 * 查询同一名称的物资条数
	 * 
	 * @param @param materialExample
	 * @param @return    参数
	 * @return int    返回类型
	 * @throws
	 */
	public int countMaterialName(MaterialExample materialExample);
   
}