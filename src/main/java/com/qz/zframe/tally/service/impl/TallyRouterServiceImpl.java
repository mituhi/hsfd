package com.qz.zframe.tally.service.impl;


import com.qz.zframe.tally.dao.TallyPlanDao;
import com.qz.zframe.tally.dao.TallyRouterDao;
import com.qz.zframe.tally.dto.PostDto;
import com.qz.zframe.tally.dto.TallyRouterDto;
import com.qz.zframe.tally.dto.UserDto;
import com.qz.zframe.tally.entity.*;
import com.qz.zframe.tally.service.TallyRouterService;
import com.qz.zframe.tally.vo.TallyPlanVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service("tallyRouterService")
@Transactional(rollbackFor = Exception.class)
public class TallyRouterServiceImpl implements TallyRouterService {
    @Autowired
    TallyRouterDao tallyRouterDao;

    @Autowired
    TallyPlanDao tallyPlanDao;

    @Override
    public List<TallyRoute> findAllTallyRouter(String windId, String routeCode, String routeName) {
        return tallyRouterDao.findAllTallyRouter(windId,routeCode,routeName);
    }

    @Override
    public List<String> findCycleNameByRouteId(String routeId) {
        return tallyRouterDao.findCycleNameByRouteId(routeId);
    }


    @Override
    public List<String> findUserIdsByRouteId(String routeId) {
        return tallyRouterDao.findUserIdsByRouteId(routeId);
    }

    @Override
    public String findUserNameByUserId(String userId) {
        return tallyRouterDao.findUserNameByUserId(userId);
    }

    @Override
    public void deleteByRouteId(String[] routeIds) {
        tallyRouterDao.deleteByRouteId(routeIds);
    }

    @Override
    public void deleteRouteUserByRouteId(String[] routeIds) {
        tallyRouterDao.deleteRouteUserByRouteId(routeIds);
    }

    @Override
    public void deleteTallyRouteStandardByRouteId(String[] routeIds) {
        tallyRouterDao.deleteTallyRouteStandardByRouteId(routeIds);
    }

    @Override
    public void deleteTallyRouteByRouteId(String[] routeIds) {
        tallyRouterDao.deleteTallyRouteByRouteId(routeIds);
    }

    @Override
    public int findserialNum() {
        return tallyRouterDao.findserialNum();
    }

    @Override
    public void addTallyRoute(TallyRoute tallyRoute) {
        tallyRouterDao.addTallyRoute(tallyRoute);
    }

    @Override
    public void addCycle(Cycle cycle) {
        tallyRouterDao.addCycle(cycle);
    }

    @Override
    public void addPeriodTime(PeriodTime periodTime) {
        tallyRouterDao.addPeriodTime(periodTime);
    }

    @Override
    public void addCyclePeriodTime(CyclePeriodTime cyclePeriodTime) {
        tallyRouterDao.addCyclePeriodTime(cyclePeriodTime);
    }

    @Override
    public String findUserIdByUserName(String userName) {
        return tallyRouterDao.findUserIdByUserName(userName);
    }

    @Override
    public void addRouteUser(RouteUser routeUser) {
        tallyRouterDao.addRouteUser(routeUser);
    }

    @Override
    public int checkRouteId(String routeId) {
        return tallyRouterDao.checkRouteId(routeId);
    }

    @Override
    public List<String> choicePeople() {
        return tallyRouterDao.choicePeople();
    }

    @Override
    public List<TallyRouterDto> findAllTallyRouterDto(String windId, String routeCode, String routeName) {
        return tallyRouterDao.findAllTallyRouterDto(windId, routeCode, routeName);
    }

    @Override
    public List<TallyRoute> findTallyRouteByPlan(String routeName, String maintenancer, String windId, Date startTime, Date endTime) {
        return tallyRouterDao.findTallyRouteByPlan(routeName, maintenancer, windId, startTime, endTime);
    }

    @Override
    public List<PeriodTime> findPeriodTimeByPlan(String routeId) {
        return tallyPlanDao.findPeriodTimeByPlan(routeId);
    }

    @Override
    public List<TallyPlanVO> findTallyPlanVOByPlan(String routeName, String maintenancer, String windId, Date startTime, Date endTime) {
        return tallyRouterDao.findTallyPlanVOByPlan(routeName, maintenancer, windId, startTime, endTime);
    }

    @Override
    public List<String> findAllRouteCode() {
        return tallyRouterDao.findAllRouteCode();
    }

    @Override
    public String findWindIdByRouteCode(String routeCode) {
        return tallyRouterDao.findWindIdByRouteCode(routeCode);
    }

    @Override
    public int countTallyRoute(String windId, String routeCode, String routeName) {
        return tallyRouterDao.countTallyRoute(windId, routeCode, routeName);
    }

    @Override
    public PostDto findPostByUserName(String userName) {
        return tallyRouterDao.findPostByUserName(userName);
    }

    @Override
    public TallyRoute findRouteCodeRelevant(String routeCode) {
        return tallyRouterDao.findRouteCodeRelevant(routeCode);
    }

    @Override
    public Cycle findCycleByCycleNameAndRouteId(String routeId, String cycleName) {
        return tallyRouterDao.findCycleByCycleNameAndRouteId(routeId, cycleName);
    }

    @Override
    public List<PeriodTime> findPeriodTimeByCycleId(String cycleId) {
        return tallyRouterDao.findPeriodTimeByCycleId(cycleId);
    }

    @Override
    public void updateTallyRoute(TallyRoute tallyRoute) {
        tallyRouterDao.updateTallyRoute(tallyRoute);
    }

    @Override
    public void updateCycle(Cycle cycle) {
        tallyRouterDao.updateCycle(cycle);
    }

    @Override
    public String findPeriodTimeIdByCycleIdStartTimeAndEndTime(String cycleId, Date startTime, Date endTime) {
        return tallyRouterDao.findPeriodTimeIdByCycleIdStartTimeAndEndTime(cycleId, startTime, endTime);
    }

    @Override
    public void updatePeriodTime(PeriodTime periodTime) {
        tallyRouterDao.updatePeriodTime(periodTime);
    }

    @Override
    public String findIdByRouteIdAndUserId(String routeId, String userId) {
        return tallyRouterDao.findIdByRouteIdAndUserId(routeId, userId);
    }

    @Override
    public void updateRouteUser(RouteUser routeUser) {
        tallyRouterDao.updateRouteUser(routeUser);
    }

    @Override
    public void deletePeriodTimeByCycleNameAndStartTimeAndEndTime(String cycleName, Date startTime, Date endTime) {
        tallyRouterDao.deletePeriodTimeByCycleNameAndStartTimeAndEndTime(cycleName, startTime, endTime);
    }

    @Override
    public int findPeriodTimeByCycleIdStartTimeAndEndTime(String cycleId, Date startTime, Date endTime) {
        return tallyRouterDao.findPeriodTimeByCycleIdStartTimeAndEndTime(cycleId, startTime, endTime);
    }

    @Override
    public List<TallyRoute> findTallyRouteByWindIdAndRouteName(String routeName, String windId) {
        return tallyRouterDao.findTallyRouteByWindIdAndRouteName(routeName, windId);
    }

    @Override
    public int countByWindIdAndRouteName(String routeName, String windId) {
        return tallyRouterDao.countByWindIdAndRouteName(routeName, windId);
    }

    @Override
    public String findRouteId() {
        if (StringUtils.isBlank(tallyRouterDao.findRouteId())){
            return "0";
        }
        return String.valueOf(new Integer(tallyRouterDao.findRouteId())+1);
    }

    @Override
    public String findCycleId() {
        if (StringUtils.isBlank(tallyRouterDao.findCycleId())){
            return "0";
        }
        return String.valueOf(new Integer(tallyRouterDao.findCycleId())+1);
    }

    @Override
    public List<UserDto> findAllUserDto() {
        return tallyRouterDao.findAllUserDto();
    }


}
