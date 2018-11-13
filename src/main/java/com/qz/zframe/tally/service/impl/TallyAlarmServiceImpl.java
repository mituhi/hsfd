package com.qz.zframe.tally.service.impl;

import com.qz.zframe.tally.dao.TallyAlarmDao;
import com.qz.zframe.tally.entity.TallyAlarm;
import com.qz.zframe.tally.service.TallyAlarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service("tallyAlarmService")
@Transactional(rollbackFor = Exception.class)
public class TallyAlarmServiceImpl implements TallyAlarmService{
    @Autowired
    TallyAlarmDao tallyAlarmDao;

    @Override
    public List<TallyAlarm> findAllTallyAlarm(String windId, String routeName, String treatmentStandard, Date startTime, Date endTime) {
        return tallyAlarmDao.findAllTallyAlarm(windId, routeName, treatmentStandard, startTime, endTime);
    }

}
