package com.qz.zframe.tally.dao;

import com.qz.zframe.tally.dto.TallyRecordDto;
import com.qz.zframe.tally.entity.TallyRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface TallyRecordDao {

    /**
     * 查询巡检记录
     * @param routeName
     * @param practitioners
     * @param windId
     * @param startTime
     * @param endTime
     * @return
     */
    List<TallyRecordDto> findAllTallyRecord(@Param("routeName")String routeName, @Param("practitioners") String practitioners,
                                            @Param("windId") String windId, @Param("startTime")Date startTime, @Param("endTime")Date endTime);
}
