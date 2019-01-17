package com.qz.zframe.run.service.impl;

import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.run.dao.GoodsMapper;
import com.qz.zframe.run.dao.HandoverGoodsRelationMapper;
import com.qz.zframe.run.entity.Goods;
import com.qz.zframe.run.entity.GoodsExample;
import com.qz.zframe.run.entity.HandoverGoodsRelationExample;
import com.qz.zframe.run.service.GoodsService;

/**
 * <p>Title: GoodsServiceImpl</p>
 * <p>@Description:物品表信息接口实现  </p>
 * @author 
 * @date 2018年11月14日 下午3:50:04
 * @version:V1.0
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class GoodsServiceImpl implements GoodsService {

	@Autowired
	private GoodsMapper goodsMapper;
	
	@Autowired
	private HandoverGoodsRelationMapper handoverGoodsRelationMapper;
	
	/**
	 * 保存
	 */
	@Override
	public ResultEntity saveGoods(Goods goods) {

		ResultEntity resultEntity = new ResultEntity();

		// 应该是在外面设置的id
		if (StringUtils.isBlank(goods.getGoodsId())) {
			// 设置id
			goods.setGoodsId(UUID.randomUUID().toString());
		}
		
		//执行插入之前： 查看是否存在相同的物资编码
		GoodsExample example = new GoodsExample();
		example.createCriteria().andGoodsCodeEqualTo(goods.getGoodsCode());
		List<Goods> list = goodsMapper.selectByExample(example);
		
		if(list.size() > 0){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("物资编码重复-->交接物品保存成功，物品表从"+goods.getGoodsName()+"开始插入失败");
			return resultEntity;
		}
		
		// 执行插入操作
		goodsMapper.insert(goods);

		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("执行成功");
		return resultEntity;
	}


	
	/**
	 * 更新操作
	 */
	@Override
	public ResultEntity updateGoods(Goods goods) {
		ResultEntity resultEntity = new ResultEntity();
				
		
		goodsMapper.updateByPrimaryKeySelective(goods);
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("执行成功");
		return resultEntity;
	}


	/**
	 * 删除
	 */
	@Override
	public ResultEntity deleteGoods(String goodsId) {
		ResultEntity resultEntity = new ResultEntity();
				
		//删除物品表
		goodsMapper.deleteByPrimaryKey(goodsId);
		
		//删除物品关联表
		HandoverGoodsRelationExample example = new HandoverGoodsRelationExample();
		example.createCriteria().andGoodsIdEqualTo(goodsId);
		handoverGoodsRelationMapper.deleteByExample(example);
		
		
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("执行成功");
		return resultEntity;
	}

}
