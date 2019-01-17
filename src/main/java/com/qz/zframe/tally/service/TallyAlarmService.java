package com.qz.zframe.tally.service;

import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.tally.entity.TallyAlarm;
import com.qz.zframe.tally.vo.TallyAlarmVO;
import org.apache.ibatis.annotations.Param;

import java.text.ParseException;
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

    /**
     * 查询所有
     * @return
     */
    List<TallyAlarmVO> findAllTallyAlarmVO();

    /**
     * 根据名称删除告警记录
     * @param routeName
     */
    void deleteTallyAlarmByRouteName(String[] routeName);

    /**
     * 巡检告警分页查询
     * @param companyId
     * @param startArchitectureCode
     * @param endArchitectureCode
     * @param startTime
     * @param endTime
     * @param processingStatus
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageResultEntity alarmPage(String companyId, String startArchitectureCode, String endArchitectureCode, String startTime, String endTime, String processingStatus, int pageNum, int pageSize) throws Exception;

    /**
     * 无需处理
     * @param alarmIds
     * @return
     */
    PageResultEntity unHandle(List<String> alarmIds);

    /**
     * 新增巡检告警信息
     * @param tallyAlarm
     * @return
     */
    ResultEntity addTallyAlarm(TallyAlarm tallyAlarm);

    /**
     * 批量新增巡检告警信息
     * @param tallyAlarms
     * @return
     */
    ResultEntity addTallyAlarmBatch(List<TallyAlarm> tallyAlarms);

    /**
     * 生成缺陷工单
     * @param alarmId
     * @return
     */
    ResultEntity addDefectWorkorder(String alarmId) throws ParseException;
}
