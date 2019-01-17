package com.qz.zframe.material.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qz.zframe.common.util.NewPageResult;
import com.qz.zframe.material.entity.Inventory;
import com.qz.zframe.material.entity.InventoryExample;
import com.qz.zframe.material.entity.InventoryExample.Criteria;
import com.qz.zframe.material.enums.EnableStatusEnum;
import com.qz.zframe.material.enums.IsDeleteEnum;
import com.qz.zframe.material.enums.StockMaterialStatusEnum;
import com.qz.zframe.material.service.StockService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api/support/stock")
@Api(tags = "api-material-stock", description = "库存物资管理")
public class StockController {
	
	@Autowired
	private StockService stockService;
	
	@RequestMapping(value = "/listNormalStock", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "获取正常库存物资列表", notes = "正常的库存物资")
	public NewPageResult<Inventory> getNormalStock(@RequestParam(required = false) Integer pageNum,
			@RequestParam(required = false) Integer pageSize, @RequestParam(required = false,defaultValue = "1") Integer isPage,
			@RequestParam(required = false) @ApiParam(name = "materialCode", value = "物资编码", required = false) String materialCode,
			@RequestParam(required = false) @ApiParam(name = "materialId", value = "物资Id", required = false) String materialId,
			@RequestParam(required = false) @ApiParam(name = "windId", value = "风电场ID", required = false) String windId,
			@RequestParam(required = false) @ApiParam(name = "stockAddId", value = "库存地Id", required = false) String stockAddId){
		InventoryExample example = new InventoryExample();
		example.setPageNo(pageNum);
		example.setPageSize(pageSize);
		example.setIsPage(isPage);
		Criteria criteria = example.createCriteria();
		if (!StringUtils.isBlank(materialCode)) {
			criteria.andMaterialCodeEqualTo(materialCode);
		}
        if (!StringUtils.isBlank(materialId)) {
			criteria.andMaterialIdEqualTo(materialId);
		}
        if(!StringUtils.isBlank(windId)){
        	criteria.andWindIdEqualTo(windId);
        }
        if(!StringUtils.isBlank(stockAddId)){
        	criteria.andStockAddIdEqualTo(stockAddId);
        }
        criteria.andMaterialStatusTo(EnableStatusEnum.ENABLE_START.getCode());
        criteria.andMaterialIsDeleteTo(IsDeleteEnum.DELETE_NO.getCode());
        criteria.andStatusEqualTo(StockMaterialStatusEnum.STATUS_NORMAL.getCode());
		return stockService.getNormalStock(example);
	}

}
