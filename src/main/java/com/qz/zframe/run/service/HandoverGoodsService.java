package com.qz.zframe.run.service;

import java.util.List;

import com.qz.zframe.common.util.NewPageResult;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.run.entity.HandoverGoods;
import com.qz.zframe.run.entity.HandoverGoodsExample;

/**
 * <p>Title: HandoverGoodsService</p>
 * <p>@Description: 交接物品表接口声明 </p>
 * @author 
 * @date 2018年11月14日 下午3:53:25
 * @version:V1.0
 */
public interface HandoverGoodsService {

	/**
	 * @Description:交接物品表保存操作
	 * @param: @param handoverGoods
	 * @param: @return   
	 * @return: ResultEntity
	 */
	ResultEntity saveHandoverGoods(HandoverGoods handoverGoods);
	
	
	/**
	 * @Description:根据主键修改
	 * @param: @param handoverGoods
	 * @param: @return   
	 * @return: ResultEntity
	 */
	ResultEntity updateHandoverGoods(HandoverGoods handoverGoods);


	/**
	 * 查询物品配置列表
	 * 
	 * @param @param example
	 * @param @return    参数
	 * @return NewPageResult<HandoverGoods>    返回类型
	 * @throws
	 */
	NewPageResult<HandoverGoods> listHandoverGoods(HandoverGoodsExample example);


	/**
	 * 查询物品交接表详情信息
	 * 
	 * @param @param handoverGoodsId
	 * @param @return    参数
	 * @return NewPageResult<HandoverGoods>    返回类型
	 * @throws
	 */
	NewPageResult<HandoverGoods> detailHandoverGoods(String handoverGoodsId);


	/**
	 * 批量删除
	 * 
	 * @param @param handoverGoodsIds
	 * @param @return    参数
	 * @return ResultEntity    返回类型
	 * @throws
	 */
	ResultEntity delHandoverGoods(List<String> handoverGoodsIds);
	
	
}
