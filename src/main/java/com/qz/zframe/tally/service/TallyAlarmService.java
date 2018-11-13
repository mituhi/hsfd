package com.qz.zframe.tally.service;

import com.qz.zframe.tally.entity.TallyAlarm;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface TallyAlarmService {
    /**
     *
     * @param windId
     * @param routeName
     * @param treatmentStandard
     * @param startTime
     * @param endTime
     * @return
     */
    List<TallyAlarm> findAllTallyAlarm(String windId, String routeName,String treatmentStandard,
                                       Date startTime, Date endTime);
}
