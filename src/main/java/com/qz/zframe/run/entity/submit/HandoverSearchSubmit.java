package com.qz.zframe.run.entity.submit;

import java.util.List;

/**
 * <p>Title: HandoverSearchSubmit</p>
 * <p>@Description: 物品交接配置模糊查询数据提交封装类 </p>
 * @author 
 * @date 2018年11月15日 上午9:27:34
 * @version:V1.0
 */
public class HandoverSearchSubmit {
	
	private String searchKey;
	private List<String> windNames;
	private String handoverGoodsId;
	
	public String getHandoverGoodsId() {
		return handoverGoodsId;
	}

	public void setHandoverGoodsId(String handoverGoodsId) {
		this.handoverGoodsId = handoverGoodsId;
	}

	public String getSearchKey() {
		return searchKey;
	}

	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}

	public List<String> getWindNames() {
		return windNames;
	}

	public void setWindNames(List<String> windNames) {
		this.windNames = windNames;
	}
	
	
}
