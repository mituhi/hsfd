package com.qz.zframe.run.service;

import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.run.entity.Goods;

/**
 * <p>Title: GoodsService</p>
 * <p>@Description: 物品表接口声明 </p>
 * @author 
 * @date 2018年11月14日 下午3:49:10
 * @version:V1.0
 */
public interface GoodsService {
	
	
	/**
	 * @Description:对物品表信息的保存
	 * @param: @param goods
	 * @param: @return   
	 * @return: ResultEntity
	 */
	ResultEntity saveGoods(Goods goods);
	

	/**
	 * @Description:修改操作
	 * @param: @param goods
	 * @param: @return   
	 * @return: ResultEntity
	 */
	ResultEntity updateGoods(Goods goods);
	
	
	/**
	 * @Description:通过id删除
	 * @param: @param goodsId
	 * @param: @return   
	 * @return: ResultEntity
	 */
	ResultEntity deleteGoods(String goodsId);
	
	
}
