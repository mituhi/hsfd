package com.qz.zframe.maintain.service;

import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.maintain.vo.MaintainLogVo;

import java.util.Map;

public interface MaintainLogInfoService {

    /**
     * 添加维护日志
     */
    ResultEntity addMaintainLog(MaintainLogVo maintainLogVo);

    /**
     * 修改维护日志
     */
    ResultEntity updateMaintainLog(MaintainLogVo maintainLogVo);

    /**
     * 批量删除维护日志
     */
    ResultEntity deleteMaintainLog(String[] dayIds);

    /**
     * 浏览维护日志
     */
    ResultEntity getMaintainLogDetail(String dayId);

    /**
     * 维护日志列表分页+条件查询
     */
    PageResultEntity getMaintainLogList(Map<String,String> pageAndCondition);
}
