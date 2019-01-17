package com.qz.zframe.maintain.service;

import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.maintain.vo.BreakdownVo;
import com.qz.zframe.maintain.vo.ChooseDealModeVo;

import java.util.List;
import java.util.Map;

public interface BreakdownService {

    /**
     * 添加故障信息
     */
    ResultEntity addBreakdown(BreakdownVo breakdownVo);

    /**
     * 批量添加故障信息
     */
    ResultEntity addBreakdownList(List<BreakdownVo> breakdownVoList);

    /**
     * 修改故障信息
     */
    ResultEntity updateBreakdown(BreakdownVo breakdownVo);

    /**
     * 选择故障处理方式
     */
    ResultEntity chooseDealMode(ChooseDealModeVo chooseDealModeVo);

    /**
     * 删除故障信息
     */
    ResultEntity deleteBreakdown(String[] breakdownIds);

    /**
     * 故障信息浏览
     */
    ResultEntity getBreakdownDetail(String breakdownId);

    /**
     * 故障信息列表分页+条件查询
     */
    PageResultEntity getBreakdownList(Map<String,String> pageAndCondition);
}
