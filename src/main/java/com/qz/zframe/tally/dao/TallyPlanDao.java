package com.qz.zframe.tally.dao;

import com.qz.zframe.tally.entity.PeriodTime;
import com.qz.zframe.tally.vo.TallyPlanVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface TallyPlanDao {

    /**
     * 根据路线id查时段表
     * @param routeId
     * @return
     */
    List<PeriodTime> findPeriodTimeByPlan(String routeId);

    /**
     * 根据路线名称和开始结束日期删除时间段表
     * @param routeName
     * @param startTime
     * @param endTime
     */
    void deletePeriodTimeByRouteNames(@Param("routeName") String routeName, @Param("startTime") Date startTime, @Param("endTime") Date endTime);


    /**
     * 查巡检计划
     * @return
     */
    List<TallyPlanVO> findAllTallyPlanVO(@Param("currentUserId")String currentUserId);

    /**
     * 查计划巡检人们
     * @param routeId
     * @return
     */
    List<String> findUserNamesByRouteId(String routeId);


}
