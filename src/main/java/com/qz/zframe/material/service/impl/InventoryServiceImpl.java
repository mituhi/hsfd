package com.qz.zframe.material.service.impl;

import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.material.dao.InventoryMapper;
import com.qz.zframe.material.entity.Inventory;
import com.qz.zframe.material.entity.InventoryExample;
import com.qz.zframe.material.enums.EnableStatusEnum;
import com.qz.zframe.material.enums.IsDeleteEnum;
import com.qz.zframe.material.enums.StockMaterialStatusEnum;
import com.qz.zframe.material.service.InventoryService;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Transactional(rollbackFor = Exception.class)
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    private InventoryMapper inventoryMapper;

    @Override
    public PageResultEntity getInventoryList(Map<String, String> pageAndCondition) {
        PageResultEntity pageResultEntity = new PageResultEntity();
        pageResultEntity.setRows(new ArrayList());

        if (StringUtils.isBlank(pageAndCondition.get("windId"))) {
            pageResultEntity.setCode(ErrorCode.SUCCESS);
            pageResultEntity.setMsg("风电场为空,未查到数据");
            return pageResultEntity;
        }

        String start = String.valueOf((Integer.parseInt(pageAndCondition.get("pageNum"))-1)*(Integer.parseInt(pageAndCondition.get("pageSize"))));
        pageAndCondition.put("start",start);
        List<Inventory> inventoryList = inventoryMapper.getInventoryList(pageAndCondition);
        if (CollectionUtils.isNotEmpty(inventoryList)) {
            inventoryList.forEach(inventory -> {
                InventoryExample averagePriceExample = new InventoryExample();
                averagePriceExample.createCriteria().andMaterialIdEqualTo(inventory.getMaterialId()).andWindIdEqualTo(inventory.getWindId()).andStatusEqualTo(StockMaterialStatusEnum.STATUS_NORMAL.getCode()).andMaterialStatusTo(EnableStatusEnum.ENABLE_START.getCode()).andMaterialIsDeleteTo(IsDeleteEnum.DELETE_NO.getCode());;
                Inventory inventory2=inventoryMapper.selectAveragePriceExample(averagePriceExample);
                if (inventory2!=null) {
                    inventory.setAveragePrice(inventory2.getAveragePrice());
                }
            });
        }
        int total = inventoryMapper.getTotal(pageAndCondition);

        pageResultEntity.setCode(ErrorCode.SUCCESS);
        pageResultEntity.setMsg("查询成功");
        pageResultEntity.setRows(inventoryList);
        pageResultEntity.setTotal(total);
        return pageResultEntity;
    }
}
