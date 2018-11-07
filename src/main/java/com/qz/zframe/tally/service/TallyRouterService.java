package com.qz.zframe.tally.service;

import com.qz.zframe.tally.dto.PostDto;
import com.qz.zframe.tally.dto.TallyRouterDto;
import com.qz.zframe.tally.entity.*;
import com.qz.zframe.tally.vo.TallyPlanVO;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface TallyRouterService {
    List<TallyRoute> findAllTallyRouter(String windId, String routeCode, String routeName);

    /**
     * 通过路线id查出周期名称
     * @param routeId 路线id
     * @return
     */
    List<String> findCycleNameByRouteId(String routeId);

    /**
     * 通过路线id查出用户id
     * @param routeId 路线id
     * @return
     */
    List<String> findUserIdsByRouteId(String routeId);

    /**
     * 通过用户id查名称
     * @param userId 用户id
     * @return
     */
    String findUserNameByUserId(String userId);

    /**
     * 通过路线ids删除周期
     * @param routeIds
     */
    void deleteByRouteId(String[] routeIds);

    /**
     *通过路线id数组删除路线人员关联
     * @param routeIds
     */
    void deleteRouteUserByRouteId(String[] routeIds);

    /**
     * 通过路线id数组删除路线标准关联
     * @param routeIds
     */
    void deleteTallyRouteStandardByRouteId(String[] routeIds);

    /**
     * 通过路线id数组删除点检路线
     * @param routeIds
     */
    void deleteTallyRouteByRouteId(String[] routeIds);

    /**
     * 查找目前最大流水号
     * @return 目前最大流水号
     */
    int findserialNum();

    /**
     * 新增巡检路线
     * @param tallyRoute
     */
    void addTallyRoute(TallyRoute tallyRoute);

    /**
     * 新增周期
     * @param cycle
     */
    void addCycle(Cycle cycle);

    /**
     * 新增时段
     * @param periodTime
     */
    void addPeriodTime(PeriodTime periodTime);

    /**
     * 新增周期时间关联表
     * @param cyclePeriodTime
     */
    void addCyclePeriodTime(CyclePeriodTime cyclePeriodTime);

    /**
     * 根据userName获取userID
     * @param userName
     * @return
     */
    String findUserIdByUserName(String userName);

    /**
     * \新增路线人员关联
     * @param routeUser
     */
    void addRouteUser(RouteUser routeUser);

    /**
     * 判断路线id是否已经存在
     * @param routeId
     * @return
     */
    int checkRouteId(String routeId);

    /**
     * 查询所有用户名称
     * @return
     */
    List<String> choicePeople();

    /**
     * 查Dto
     * @param windId
     * @param routeCode
     * @param routeName
     * @return
     */
    List<TallyRouterDto> findAllTallyRouterDto(String windId,String routeCode, String routeName);


    //********************************************************************************

    /**
     * 点检计划的条件查询
     * @param routeName
     * @param maintenancer
     * @param windId
     * @return
     */
    List<TallyRoute> findTallyRouteByPlan(String routeName, String maintenancer,
                                          String windId, Date startTime,Date endTime);


    /**
     * 根据路线id查时段表
     * @param routeId
     * @return
     */
    List<PeriodTime> findPeriodTimeByPlan(String routeId);

    /**
     * 查显示的东西 巡检计划的
     * @param routeName
     * @param maintenancer
     * @param windId
     * @param startTime
     * @param endTime
     * @return
     */
    List<TallyPlanVO> findTallyPlanVOByPlan(String routeName,String maintenancer,
                                             String windId,Date startTime,Date endTime);


    /**
     * 查出所有路线编码
     * @return
     */
    List<String> findAllRouteCode();

    /**
     * 根据路线编码查所属风场
     * @param routeCode
     * @return
     */
    String findWindIdByRouteCode(String routeCode);

    /**
     * 查分页用总数
     * @param windId
     * @param routeCode
     * @param routeName
     * @return
     */
    int countTallyRoute(String windId, String routeCode, String routeName);

    /**
     * 根据用户名查相关职务
     * @param userName
     * @return
     */
    PostDto findPostByUserName(String userName);

    /**
     * 查询路线编码相关
     * @param routeCode
     * @return
     */
    TallyRoute findRouteCodeRelevant(String routeCode);

    /**
     * 查询周期相关信息
     * @param routeId
     * @param cycleName
     * @return
     */
    Cycle findCycleByCycleNameAndRouteId(String routeId,String cycleName);

    /**
     * 查时间段相关
     * @param cycleId
     * @return
     */
    List<PeriodTime> findPeriodTimeByCycleId(String cycleId);



}
