package com.qz.zframe.material.service;

import com.qz.zframe.common.util.NewPageResult;
import com.qz.zframe.material.entity.Inventory;
import com.qz.zframe.material.entity.InventoryExample;

public interface StockService {

	public NewPageResult<Inventory> getNormalStock(InventoryExample example);

}
