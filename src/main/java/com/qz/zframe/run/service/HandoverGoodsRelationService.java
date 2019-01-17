package com.qz.zframe.run.service;

import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.run.entity.HandoverGoods;
import com.qz.zframe.run.entity.HandoverGoodsRelation;
import com.qz.zframe.run.entity.submit.HandoverSearchSubmit;

/**
 * <p>Title: HandoverGoodsRelationService</p>
 * <p>@Description: 交接物品关联表 </p>
 * @author 
 * @date 2018年11月14日 下午4:53:08
 * @version:V1.0
 */
public interface HandoverGoodsRelationService {

	
	/**
	 * @Description:保存交接物品关联表
	 * @param: @param handoverGoodsRelation
	 * @param: @return   
	 * @return: ResultEntity
	 */
	ResultEntity saveHandoverGoods(HandoverGoods handoverGoods);
	
	
	/**
	 * @Description:根据查询条件查询交接物品配置首页信息
	 * @param: @param searchSubmit
	 * @param: @param pageNo
	 * @param: @param pageSize
	 * @param: @return   
	 * @return: PageResultEntity
	 */
	PageResultEntity listHandoverGoodsRelation(HandoverSearchSubmit searchSubmit,int pageNo,int pageSize);
	
	
	/**
	 * @Description:获取编辑数据
	 * @param: @param searchSubmit
	 * @param: @return   
	 * @return: ResultEntity
	 */
	ResultEntity getEditData(String handoverGoodsId);
	
	
	
	/**
	 * @Description:删除操作
	 * @param: @param handoverGoodsRelationId
	 * @param: @return   
	 * @return: ResultEntity
	 */
	ResultEntity deleteHandoverGoodsRelation(String handoverGoodsId);
	
	
	
	
}
