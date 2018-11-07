package com.qz.zframe.tally.service;

import org.apache.ibatis.annotations.Param;

import java.util.Date;

public interface PeriodTimeService {
    /**
     * 根据路线名称和开始结束日期删除时间段表
     * @param routeName
     * @param startTime
     * @param endTime
     */
    void deletePeriodTimeByRouteNames(@Param("routeName") String routeName, @Param("startTime") Date startTime, @Param("endTime") Date endTime);
}
