package com.qz.zframe.maintain.service;

import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.maintain.vo.MaintainLogVo;

import java.util.Map;

public interface MaintainLogInfoService {

    /**
     * 添加维护日志
     */
    public ResultEntity addMaintainLog(MaintainLogVo maintainLogVo);

    /**
     * 批量删除维护日志
     */
    public ResultEntity deleteMaintainLog(String dayIds);

    /**
     * 修改维护日志
     */
    public ResultEntity updateMaintainLog(MaintainLogVo maintainLogVo);

    /**
     * 浏览维护日志
     */
    public ResultEntity getMaintainLogDetail(String dayId);

    /**
     * 维护日志列表分页+条件查询
     */
    public PageResultEntity getMaintainLogList(Map<String,String> pageAndCondition);
}
