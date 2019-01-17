package com.qz.zframe.run.entity.submit;

import java.util.List;

import com.qz.zframe.run.entity.Goods;
import com.qz.zframe.run.entity.HandoverGoods;

import io.swagger.annotations.ApiModelProperty;

/**
 * <p>Title: HandoverGoodsSubmit</p>
 * <p>@Description: 添加交接物品提交封装类 </p>
 * @author 
 * @date 2018年11月14日 下午5:10:53
 * @version:V1.0
 */
public class HandoverGoodsSubmit {
	
	@ApiModelProperty(value="交接物品信息对象",name="handoverGoods")
	private HandoverGoods handoverGoods;
	
	@ApiModelProperty(value="物品集合",name="goodsList")
	private List<Goods> goodsList;
	
	public HandoverGoods getHandoverGoods() {
		return handoverGoods;
	}
	public void setHandoverGoods(HandoverGoods handoverGoods) {
		this.handoverGoods = handoverGoods;
	}
	public List<Goods> getGoodsList() {
		return goodsList;
	}
	public void setGoodsList(List<Goods> goodsList) {
		this.goodsList = goodsList;
	}
	
	
	
}
