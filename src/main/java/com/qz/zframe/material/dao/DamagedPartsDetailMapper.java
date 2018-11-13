package com.qz.zframe.material.dao;

import com.qz.zframe.common.util.BaseMapper;
import com.qz.zframe.material.entity.DamagedPartsDetail;
import com.qz.zframe.material.entity.DamagedPartsDetailExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface DamagedPartsDetailMapper extends BaseMapper<DamagedPartsDetail, DamagedPartsDetailExample, Long>{

	/**
	 * 删除损坏件详情
	 * 
	 * @param @param damagedPartsId    参数
	 * @return void    返回类型
	 * @throws
	 */
	public void delDamagedPartsDetail(String damagedPartsId);

	public void delByPartsIds(List<String> damagedPartsIds);
   
}