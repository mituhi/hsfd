package com.qz.zframe.material.controller;

import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.material.service.InventoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/support/inventory")
@Api(tags = "api-material-inventory", description = "物资管理-库存管理")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @RequestMapping(value = "/getInventoryList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "库存列表", notes = "")
    public PageResultEntity getInventoryList(@RequestParam(defaultValue = "1")@ApiParam(name="pageNum",value="当前页",required=false)String pageNum,
                                             @RequestParam(defaultValue = "10")@ApiParam(name="pageSize",value="一页记录数",required=false)String pageSize,
                                             @RequestParam(required = false)@ApiParam(name="materialName",value="物资名称",required=false)String materialName,
                                             @RequestParam(required = false)@ApiParam(name="windCode",value="风电场Code",required=false)String windCode,
                                             @RequestParam(required = false)@ApiParam(name="stockAddId",value="库存地id",required=false)String stockAddId,
                                             @RequestParam(required = false)@ApiParam(name="stockAddName",value="库存地名称",required=false)String stockAddName,
                                             @RequestParam(required = false)@ApiParam(name="materialDesc",value="物资描述",required=false)String materialDesc,
                                             @RequestParam(required = false)@ApiParam(name="materialCode",value="物资编码",required=false)String materialCode) {
        Map<String,String> pageAndCondition = new HashMap<>();
        pageAndCondition.put("pageNum",pageNum);
        pageAndCondition.put("pageSize",pageSize);
        pageAndCondition.put("materialName",materialName);
        pageAndCondition.put("windId",windCode);
        pageAndCondition.put("stockAddId",stockAddId);
        pageAndCondition.put("stockAddName",stockAddName);
        pageAndCondition.put("materialDesc",materialDesc);
        pageAndCondition.put("materialCode",materialCode);
        return inventoryService.getInventoryList(pageAndCondition);
    }
}
