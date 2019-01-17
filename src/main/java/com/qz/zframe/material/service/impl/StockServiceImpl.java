package com.qz.zframe.material.service.impl;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.NewPageResult;
import com.qz.zframe.material.dao.InventoryMapper;
import com.qz.zframe.material.entity.Inventory;
import com.qz.zframe.material.entity.InventoryExample;
import com.qz.zframe.material.enums.EnableStatusEnum;
import com.qz.zframe.material.enums.IsDeleteEnum;
import com.qz.zframe.material.enums.StockMaterialStatusEnum;
import com.qz.zframe.material.service.StockService;

import ch.qos.logback.core.joran.conditional.IfAction;


@Service
@Transactional(rollbackFor = Exception.class)
public class StockServiceImpl implements StockService{
	
	@Autowired
	private InventoryMapper inventoryMapper;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public NewPageResult getNormalStock(InventoryExample example) {
		NewPageResult pageResult = new NewPageResult<>();
		int count = inventoryMapper.countByExample(example);
		pageResult.setTotal(count);
		List<Inventory> list ;
		if(count==0){
			list=Collections.emptyList();
		}else{
			list=inventoryMapper.selectByExample(example);
			for(Inventory inventory:list){
				InventoryExample averagePriceExample = new InventoryExample();
				averagePriceExample.createCriteria().andMaterialIdEqualTo(inventory.getMaterialId()).andWindIdEqualTo(inventory.getWindId()).andStatusEqualTo(StockMaterialStatusEnum.STATUS_NORMAL.getCode()).andMaterialStatusTo(EnableStatusEnum.ENABLE_START.getCode()).andMaterialIsDeleteTo(IsDeleteEnum.DELETE_NO.getCode());;
				//获取总库存总金额平均价
				Inventory inventory2=inventoryMapper.selectAveragePriceExample(averagePriceExample);
				if(inventory2!=null){
				inventory.setTotalNum(inventory2.getTotalNum());
				inventory.setTotalAmount(inventory2.getTotalAmount());
				inventory.setAveragePrice(inventory2.getAveragePrice()==null?BigDecimal.ZERO:inventory2.getAveragePrice());
				}
				}
		}
		pageResult.setRows(list);
		pageResult.setCode(ErrorCode.SUCCESS);
		return pageResult;
	}

}
