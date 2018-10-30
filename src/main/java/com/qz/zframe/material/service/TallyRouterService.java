package com.qz.zframe.material.service;

import com.qz.zframe.material.entity.TallyRoute;

import java.util.List;

public interface TallyRouterService {
    List<TallyRoute> findAllTallyRouter();

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
