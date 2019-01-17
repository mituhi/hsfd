package com.qz.zframe.run.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.qz.zframe.run.entity.HandoverGoods;
import com.qz.zframe.run.entity.HandoverGoodsExample;

@Mapper
public interface HandoverGoodsMapper {
    int countByExample(HandoverGoodsExample example);

    int deleteByExample(HandoverGoodsExample example);

    int deleteByPrimaryKey(String handoverGoodsId);

    int insert(HandoverGoods record);

    int insertSelective(HandoverGoods record);

    List<HandoverGoods> selectByExample(HandoverGoodsExample example);

    HandoverGoods selectByPrimaryKey(String handoverGoodsId);

    int updateByExampleSelective(@Param("record") HandoverGoods record, @Param("example") HandoverGoodsExample example);

    int updateByExample(@Param("record") HandoverGoods record, @Param("example") HandoverGoodsExample example);

    int updateByPrimaryKeySelective(HandoverGoods record);

    int updateByPrimaryKey(HandoverGoods record);

	/**
	 * 查询出最大序号
	 * 
	 * @param @return    参数
	 * @return String    返回类型
	 * @throws
	 */
	String selectMaxSeroalNum();

	/**
	 * 批量删除物品交接表
	 * 
	 * @param @param handoverGoodsIds    参数
	 * @return void    返回类型
	 * @throws
	 */
	void deleteHandoverGoodsList(List<String> handoverGoodsIds);
    

    
}