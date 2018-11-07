package com.qz.zframe.material.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.qz.zframe.common.util.BaseMapper;
import com.qz.zframe.material.entity.MaterialClassify;
import com.qz.zframe.material.entity.MaterialClassifyExample;

@Mapper
public interface MaterialClassifyMapper extends BaseMapper<MaterialClassify, MaterialClassifyExample, Long>{

	/**
	 * 批量更改删除状态
	 * 
	 * @param @param params
	 * @param @return    参数
	 * @return int    返回类型
	 * @throws
	 */
	public int updateIsdete(Map<String, Object> params);

	/**
	 * 找到子类
	 * 
	 * @param @param params1
	 * @param @return    参数
	 * @return List<String>    返回类型
	 * @throws
	 */
	public List<String> selectSon(Map<String, Object> params1);
    
}