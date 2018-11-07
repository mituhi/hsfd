package com.qz.zframe.maintain.service;

import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.maintain.entity.BreakdownInfo;

import java.util.Map;

public interface BreakdownService {

    /**
     * 故障信息列表分页_条件查询
     */
    public PageResultEntity getBreakdownList(Map<String,String> pageAndCondition);

    /**
     * 故障处理方式列表查询
     */
    public ResultEntity getDealwithModeList();

    /**
     * 故障位置列表查询
     */
    public ResultEntity getBreakdownLocationList();

    /**
     * 故障属性列表查询
     */
    public ResultEntity getBreakdownAttributeList();

    /**
     * 新建故障信息
     */
    public ResultEntity createBreakdown();

    /**
     * 添加故障信息
     */
    public ResultEntity addBreakdown(BreakdownInfo breakdownInfo);

    /**
     * 删除故障信息
     */
    public ResultEntity deleteBreakdown(String breakdownIds);

    /**
     * 修改故障信息
     */
    public ResultEntity updateBreakdown(BreakdownInfo breakdownInfo);

    /**
     * 故障信息浏览
     */
    public ResultEntity selectBreakdownDetail(String breakdownId);
}
