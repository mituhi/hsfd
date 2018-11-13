package com.qz.zframe.tally.service;

import com.qz.zframe.tally.dto.TallyRecordDto;
import com.qz.zframe.tally.entity.TallyRecord;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface TallyRecordService {
    /**
     * 查询巡检记录
     * @param routeName
     * @param practitioners
     * @param windId
     * @param startTime
     * @param endTime
     * @return
     */
    List<TallyRecordDto> findAllTallyRecord(String routeName, String practitioners, String windId, Date startTime, Date endTime);
}
