package com.qz.zframe.material.dao;

import com.qz.zframe.material.entity.TallyRoute;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface TallyRouterDao {
    /**
     * 查巡检导航信息
     * @return
     */
    List<TallyRoute> findAllTallyRouter();
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


}
