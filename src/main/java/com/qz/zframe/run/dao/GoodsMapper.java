package com.qz.zframe.run.dao;

import com.qz.zframe.run.entity.Goods;
import com.qz.zframe.run.entity.GoodsExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface GoodsMapper {
    int countByExample(GoodsExample example);

    int deleteByExample(GoodsExample example);

    int deleteByPrimaryKey(String goodsId);

    int insert(Goods record);

    int insertSelective(Goods record);

    List<Goods> selectByExample(GoodsExample example);

    Goods selectByPrimaryKey(String goodsId);

    int updateByExampleSelective(@Param("record") Goods record, @Param("example") GoodsExample example);

    int updateByExample(@Param("record") Goods record, @Param("example") GoodsExample example);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);

	/**
	 * 批量新增物品
	 * 
	 * @param @param goodsList    参数
	 * @return void    返回类型
	 * @throws
	 */
	void insertList(List<Goods> goodsList);

	/**
	 * 批量删除物品信息
	 * 
	 * @param @param handoverGoodsIds    参数
	 * @return void    返回类型
	 * @throws
	 */
	void deleteGoodsList(List<String> handoverGoodsIds);

	/**
	 * 查询物品最大编码
	 * 
	 * @param @param params
	 * @param @return    参数
	 * @return String    返回类型
	 * @throws
	 */
	String selectMaxGoodsCode(@Param("params")Map<String, String> params);
}