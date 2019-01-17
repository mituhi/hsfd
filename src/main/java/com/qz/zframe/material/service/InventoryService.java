package com.qz.zframe.material.service;

import com.qz.zframe.common.util.PageResultEntity;

import java.util.Map;

public interface InventoryService {

    /**
     * 条件查询库存列表
     */
    PageResultEntity getInventoryList(Map<String,String> pageAndCondition);
}
