package com.qz.zframe.tally.service.impl;

import com.qz.zframe.tally.dao.TallyRecordDao;
import com.qz.zframe.tally.dto.TallyRecordDto;
import com.qz.zframe.tally.entity.TallyRecord;
import com.qz.zframe.tally.service.TallyRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service("tallyRecordService")
@Transactional(rollbackFor = Exception.class)
public class TallyRecordServiceImpl implements TallyRecordService{

    @Autowired
    TallyRecordDao tallyRecordDao;

    @Override
    public List<TallyRecordDto> findAllTallyRecord(String routeName, String practitioners, String windId, Date startTime, Date endTime) {
        return tallyRecordDao.findAllTallyRecord(routeName, practitioners, windId, startTime, endTime);
    }
}
