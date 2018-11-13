package com.qz.zframe.tally.dao;

import com.qz.zframe.tally.entity.TallyAlarm;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface TallyAlarmDao {

    /**
     *
     * @param windId
     * @param routeName
     * @param treatmentStandard
     * @param startTime
     * @param endTime
     * @return
     */
    List<TallyAlarm> findAllTallyAlarm(@Param("windId")String windId,@Param("routeName") String routeName,@Param("treatmentStandard") String treatmentStandard,
                                       @Param("startTime")Date startTime,@Param("endTime") Date endTime);
}
