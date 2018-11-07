package com.qz.zframe.tally.service.impl;

import com.qz.zframe.tally.dao.TallyPlanDao;
import com.qz.zframe.tally.service.PeriodTimeService;
import com.qz.zframe.tally.vo.TallyPlanVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service("periodTimeService")
@Transactional(rollbackFor = Exception.class)
public class PeriodTimeServiceImpl implements PeriodTimeService{

    @Autowired
    TallyPlanDao tallyPlanDao;

    @Override
    public void deletePeriodTimeByRouteNames(String routeName, Date startTime, Date endTime) {

        tallyPlanDao.deletePeriodTimeByRouteNames(routeName, startTime, endTime);
    }
}
