package com.qz.zframe.tally.dao;

import com.qz.zframe.tally.entity.TallyAlarm;
import com.qz.zframe.tally.vo.TallyAlarmVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

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

    /**
     * 查询所有
     * @return
     */
    List<TallyAlarmVO> findAllTallyAlarmVO();

    //删除告警记录

    /**
     * 根据名称删除告警记录
     * @param routeName
     */
    void deleteTallyAlarmByRouteName(@Param("routeName") String[] routeName);

    /**
     * 根据条件查询巡检告警记录
     * @param companyId
     * @param startArchitectureCode
     * @param endArchitectureCode
     * @param start
     * @param end
     * @param processingStatus
     * @param firstIndex
     * @param lastIndex
     * @return
     */
    List<TallyAlarm> findTallyAlarm(@Param("companyId") String companyId, @Param("startArchitectureCode") String startArchitectureCode,
                                    @Param("endArchitectureCode") String endArchitectureCode, @Param("start") Date start,
                                    @Param("end") Date end, @Param("processingStatus") String processingStatus,
                                    @Param("firstIndex") int firstIndex, @Param("lastIndex") int lastIndex);

    /**
     * 根据条件查询巡检告警记录数量
     * @param companyId
     * @param startArchitectureCode
     * @param endArchitectureCode
     * @param start
     * @param end
     * @param processingStatus
     * @return
     */
    int findTallyAlarmCount(@Param("companyId") String companyId, @Param("startArchitectureCode") String startArchitectureCode,
                            @Param("endArchitectureCode") String endArchitectureCode, @Param("start") Date start,
                            @Param("end") Date end, @Param("processingStatus") String processingStatus);

    /**
     * 处理告警
     *
     * @param map
     * @return
     */
    int updateTallyAlarm(@Param("map") Map<String, Object> map);

    /**
     * 新增巡检告警信息
     * @param tallyAlarm
     * @return
     */
    int addTallyAlarm(TallyAlarm tallyAlarm);

    /**
     * 批量新增巡检告警信息
     * @param tallyAlarms
     * @return
     */
    int addTallyAlarmBatch(List<TallyAlarm> tallyAlarms);

    /**
     * findTallyAlarmByAlarmId
     * @param alarmId
     * @return
     */
    TallyAlarm findTallyAlarmByAlarmId(@Param("alarmId") String alarmId);
}
