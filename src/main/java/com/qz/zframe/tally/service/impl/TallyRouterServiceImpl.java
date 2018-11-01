package com.qz.zframe.tally.service.impl;


import com.qz.zframe.tally.dao.TallyRouterDao;
import com.qz.zframe.tally.entity.*;
import com.qz.zframe.tally.service.TallyRouterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("tallyRouterService")
@Transactional(rollbackFor = Exception.class)
public class TallyRouterServiceImpl implements TallyRouterService {
    @Autowired
    TallyRouterDao tallyRouterDao;

    @Override
    public List<TallyRoute> findAllTallyRouter(String windId, String routeCode, String routeName) {
        return tallyRouterDao.findAllTallyRouter(windId,routeCode,routeName);
    }

    @Override
    public String findCycleNameByRouteId(String routeId) {
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
}
