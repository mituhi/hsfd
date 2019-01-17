package com.qz.zframe.material.dao;

import com.qz.zframe.common.util.BaseMapper;
import com.qz.zframe.material.entity.InInventoryDetail;
import com.qz.zframe.material.entity.InInventoryDetailExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface InInventoryDetailMapper extends BaseMapper<InInventoryDetail, InInventoryDetailExample, Long>{

	/**
	 * 根据单号id删除
	 *
	 * @param @param inInventoryId    参数
	 * @return void    返回类型
	 * @throws
	 */
	void delByInInventoryId(String inInventoryId);

	void deleteByIds(List<String> inInventoryIds);

	/**
	 * 批量新增
	 * 
	 * @param @param lists    参数
	 * @return void    返回类型
	 * @throws
	 */
	void insertList(List<InInventoryDetail> lists);
   
}