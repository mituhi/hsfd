package com.qz.zframe.tally.dao;

import com.qz.zframe.tally.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TallyRouterDao {
    /**
     * 查巡检导航信息
     * @return
     */
    List<TallyRoute> findAllTallyRouter(@Param("windId") String windId, @Param("routeCode") String routeCode, @Param("routeName") String routeName);
    //没用的接口
    int sal();

    /**
     * 通过路线id查出周期名称
     * @param routeId 路线id
     * @return
     */
    String findCycleNameByRouteId(String routeId);

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
     * 通过路线id数组删除周期
     * @param routeIds
     */
    void deleteByRouteId(@Param("routeIds") String[] routeIds);

    /**
     *通过路线id数组删除路线人员关联
     * @param routeIds
     */
    void deleteRouteUserByRouteId(@Param("routeIds") String[] routeIds);

    /**
     * 通过路线id数组删除路线标准关联
     * @param routeIds
     */
    void deleteTallyRouteStandardByRouteId(@Param("routeIds") String[] routeIds);

    /**
     * 通过路线id数组删除点检路线
     * @param routeIds
     */
    void deleteTallyRouteByRouteId(@Param("routeIds") String[] routeIds);

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






}
