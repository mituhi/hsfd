package com.qz.zframe.material.service.impl;

import com.qz.zframe.material.dao.TallyRouterDao;
import com.qz.zframe.material.entity.TallyRoute;
import com.qz.zframe.material.service.TallyRouterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("tallyRouterService")
public class TallyRouterServiceImpl implements TallyRouterService{
    @Autowired
    TallyRouterDao tallyRouterDao;

    @Override
    public List<TallyRoute> findAllTallyRouter() {
        return tallyRouterDao.findAllTallyRouter();
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
}
