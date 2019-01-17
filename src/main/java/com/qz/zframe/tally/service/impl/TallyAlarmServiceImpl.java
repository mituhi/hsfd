package com.qz.zframe.tally.service.impl;

import com.qz.zframe.authentication.CurrentUserService;
import com.qz.zframe.common.entity.DataDict;
import com.qz.zframe.common.service.DataDictService;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.maintain.entity.DefectWorkorder;
import com.qz.zframe.maintain.service.DefectWorkorderService;
import com.qz.zframe.maintain.vo.DefectWorkorderVo;
import com.qz.zframe.tally.dao.TallyAlarmDao;
import com.qz.zframe.tally.entity.TallyAlarm;
import com.qz.zframe.tally.service.TallyAlarmService;
import com.qz.zframe.tally.vo.TallyAlarmVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service("tallyAlarmService")
@Transactional(rollbackFor = Exception.class)
public class TallyAlarmServiceImpl implements TallyAlarmService{
    @Autowired
    TallyAlarmDao tallyAlarmDao;

    @Autowired
    private DataDictService dataDictService;

    @Autowired
    private CurrentUserService currentUserService;

    @Autowired
    private DefectWorkorderService defectWorkorderService;

    @Override
    public List<TallyAlarm> findAllTallyAlarm(String windId, String routeName, String treatmentStandard, Date startTime, Date endTime) {
        return tallyAlarmDao.findAllTallyAlarm(windId, routeName, treatmentStandard, startTime, endTime);
    }

    @Override
    public List<TallyAlarmVO> findAllTallyAlarmVO() {
        return tallyAlarmDao.findAllTallyAlarmVO();
    }

    @Override
    public void deleteTallyAlarmByRouteName(String[] routeName) {
        tallyAlarmDao.deleteTallyAlarmByRouteName(routeName);
    }

    @Override
    public PageResultEntity alarmPage(String companyId, String startArchitectureCode, String endArchitectureCode,
                                      String startTime, String endTime, String processingStatus, int pageNum, int pageSize) throws Exception {
        PageResultEntity pageResultEntity = new PageResultEntity();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date start = null;
        Date end = null;
        if (StringUtils.isNotBlank(startTime)){
            start = format.parse(startTime);
        }
        if (StringUtils.isNotBlank(endTime)){
            end = format.parse(endTime);
        }
        //从第几条数据开始
        int firstIndex  = (pageNum - 1) * pageSize;
        //到第几条数据结束
        int lastIndex = pageNum * pageSize;
        List<TallyAlarm> tallyAlarms = tallyAlarmDao.findTallyAlarm(companyId, startArchitectureCode, endArchitectureCode, start, end,
                processingStatus, firstIndex, lastIndex);
        if (tallyAlarms == null && tallyAlarms.isEmpty()){
            pageResultEntity.setCode(ErrorCode.SUCCESS);
            pageResultEntity.setTotal(0);
            pageResultEntity.setRows(null);
        }else {
            int total = tallyAlarmDao.findTallyAlarmCount(companyId, startArchitectureCode, endArchitectureCode, start, end,
                    processingStatus);
            tallyAlarms = makeCodeType(tallyAlarms);
            pageResultEntity.setCode(ErrorCode.SUCCESS);
            pageResultEntity.setTotal(total);
            pageResultEntity.setRows(tallyAlarms);
        }
        return pageResultEntity;
    }

    private List<TallyAlarm> makeCodeType(List<TallyAlarm> list) throws Exception {
        List<String> codeTypes = new ArrayList<String>();
        codeTypes.add("STANDARD_TYPE");
        codeTypes.add("PROCESSING_STATUS");
        List<DataDict> dataDicts = dataDictService.findDataDictsByCodeType(codeTypes);
        if (dataDicts != null && !dataDicts.isEmpty()) {
            for(TallyAlarm ta : list) {
                for(DataDict d : dataDicts) {
                    if ("STANDARD_TYPE".equals(d.getCodeTypeName()) && ta.getStandardType().equals(d.getName())) {
                        ta.setStandardTypeName(d.getTitle());
                    }
                    if ("PROCESSING_STATUS".equals(d.getCodeTypeName()) && ta.getProcessingStatus().equals(d.getName())) {
                        ta.setProcessingStatusName(d.getTitle());
                    }
                }
            }
        }
        return list;
    }

    /**
     * 无需处理
     * @param alarmIds
     * @return
     */
    @Override
    public PageResultEntity unHandle(List<String> alarmIds) {
        PageResultEntity pageResultEntity = new PageResultEntity();
        if (alarmIds != null && !alarmIds.isEmpty()) {
            Map<String, Object> map = new HashMap<>();
            String userId = currentUserService.getId();
            map.put("userId", userId);
            map.put("msg", "无需处理");
            map.put("alarmIds", alarmIds);
            tallyAlarmDao.updateTallyAlarm(map);
            pageResultEntity.setCode(ErrorCode.SUCCESS);
            pageResultEntity.setMsg("处理成功");
            return pageResultEntity;
        }
        pageResultEntity.setCode(ErrorCode.ERROR);
        pageResultEntity.setMsg("请选择需要处理的告警信息!");
        return pageResultEntity;
    }

    /**
     * 新增巡检告警信息
     * @param tallyAlarm
     * @return
     */
    @Override
    public ResultEntity addTallyAlarm(TallyAlarm tallyAlarm) {
        ResultEntity resultEntity = new ResultEntity();
        if (tallyAlarm == null) {
            resultEntity.setCode(ErrorCode.ERROR);
            resultEntity.setMsg("告警信息不能为空!");
            return resultEntity;
        }
        tallyAlarm.setAlarmId(UUID.randomUUID().toString().replaceAll("-",""));
        tallyAlarm.setProcessingPerson(currentUserService.getId());
        tallyAlarm.setCreateTime(new Date());
        tallyAlarmDao.addTallyAlarm(tallyAlarm);
        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("新增成功!");
        return resultEntity;
    }
    /**
     * 批量新增巡检告警信息
     * @param tallyAlarms
     * @return
     */
    @Override
    public ResultEntity addTallyAlarmBatch(List<TallyAlarm> tallyAlarms) {
        ResultEntity resultEntity = new ResultEntity();
        if (tallyAlarms == null || tallyAlarms.isEmpty()) {
            resultEntity.setCode(ErrorCode.ERROR);
            resultEntity.setMsg("告警信息不能为空!");
            return resultEntity;
        }
        for (TallyAlarm t : tallyAlarms) {
            t.setAlarmId(UUID.randomUUID().toString().replaceAll("-",""));
            t.setProcessingPerson(currentUserService.getId());
            t.setCreateTime(new Date());
        }

        tallyAlarmDao.addTallyAlarmBatch(tallyAlarms);
        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("新增成功!");
        return resultEntity;
    }

    /**
     * 生成缺陷工单
     * @param alarmId
     * @return
     */
    @Override
    @Transactional
    public ResultEntity addDefectWorkorder(String alarmId) throws ParseException {
        ResultEntity resultEntity = new ResultEntity();
        if (StringUtils.isBlank(alarmId)) {
            resultEntity.setCode(ErrorCode.ERROR);
            resultEntity.setMsg("请选择要生成缺陷工单的告警信息!");
            return resultEntity;
        }
        TallyAlarm tallyAlarm = tallyAlarmDao.findTallyAlarmByAlarmId(alarmId);
        if (tallyAlarm != null) {
            String userId = currentUserService.getId();
            DefectWorkorderVo defectWorkorderVo = new DefectWorkorderVo();
            defectWorkorderVo.setEquipmentId(tallyAlarm.getEquipmentId());
            defectWorkorderVo.setWindId(tallyAlarm.getWindId());
            defectWorkorderVo.setPositionId(tallyAlarm.getPositionId());
            defectWorkorderVo.setCrewId(tallyAlarm.getCrew());
            defectWorkorderVo.setMaintainer(tallyAlarm.getTallyPerson());
            defectWorkorderVo.setDutyHead(userId);
            defectWorkorderVo.setBreakdownDesc("点检内容："+tallyAlarm.getCheckContent()+" 结果："+tallyAlarm.getResult());
            defectWorkorderService.addDefectWorkorder(defectWorkorderVo);

            List<String> alarmIds = new ArrayList<>();
            alarmIds.add(alarmId);
            Map<String, Object> map = new HashMap<>();
            map.put("userId", userId);
            map.put("msg", "生成缺陷工单");
            map.put("alarmIds", alarmIds);
            tallyAlarmDao.updateTallyAlarm(map);

            resultEntity.setCode(ErrorCode.SUCCESS);
            resultEntity.setMsg("生成缺陷工单成功!");
            return resultEntity;
        }
        resultEntity.setCode(ErrorCode.ERROR);
        resultEntity.setMsg("生成缺陷工单失败!");
        return resultEntity;
    }
}
