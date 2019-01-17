package com.qz.zframe.tally.service.impl;

import com.qz.zframe.tally.dao.TallyPlanDao;
import com.qz.zframe.tally.service.TallyPlanService;
import com.qz.zframe.tally.vo.TallyPlanVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("tallyPlanService")
@Transactional(rollbackFor = Exception.class)
public class TallyPlanServiceImpl implements TallyPlanService{
    @Autowired
    TallyPlanDao tallyPlanDao;

    @Override
    public List<TallyPlanVO> findAllTallyPlanVO(String currentUserId) {
        return tallyPlanDao.findAllTallyPlanVO(currentUserId);
    }

    @Override
    public List<String> findUserNamesByRouteId(String routeId) {
        return tallyPlanDao.findUserNamesByRouteId(routeId);
    }
}
