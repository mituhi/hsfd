package com.qz.zframe.tally.service;

import com.qz.zframe.tally.vo.TallyPlanVO;

import java.util.List;

public interface TallyPlanService {

    /**
     * 查巡检计划
     * @return
     */
    List<TallyPlanVO> findAllTallyPlanVO(String currentUserId);

    /**
     * 查计划巡检人们
     * @param routeId
     * @return
     */
    List<String> findUserNamesByRouteId(String routeId);
}
