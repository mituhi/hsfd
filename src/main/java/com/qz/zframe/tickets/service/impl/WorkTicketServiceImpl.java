package com.qz.zframe.tickets.service.impl;

import com.qz.zframe.authentication.CurrentUserService;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.common.util.UUIdUtil;
import com.qz.zframe.tickets.entity.*;
import com.qz.zframe.tickets.mapper.WorkTicketMapper;
import com.qz.zframe.tickets.mapper.WorkTicketRiskControlMapper;
import com.qz.zframe.tickets.mapper.WorkTicketSafeMeasureMapper;
import com.qz.zframe.tickets.mapper.WorkTicketWorkTimeMapper;
import com.qz.zframe.tickets.vo.TicketStatisticsRes;
import com.qz.zframe.tickets.vo.WorkTicketVo;
import com.qz.zframe.tickets.service.WorkTicketService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@Transactional(rollbackFor = Exception.class)
public class WorkTicketServiceImpl implements WorkTicketService {

    @Autowired
    private CurrentUserService currentUserService;

    @Autowired
    private WorkTicketMapper workTicketMapper;

    @Autowired
    private WorkTicketSafeMeasureMapper workTicketSafeMeasureMapper;

    @Autowired
    private WorkTicketRiskControlMapper workTicketRiskControlMapper;

    @Autowired
    private WorkTicketWorkTimeMapper workTicketWorkTimeMapper;

    @Override
    public ResultEntity addWorkTicket(WorkTicketVo workTicketVo) {
        ResultEntity resultEntity = new ResultEntity();

        if (!StringUtils.isNoneBlank(workTicketVo.getMaintainer())) {
            resultEntity.setMsg("维护人不能为空");
            return resultEntity;
        }
        if (workTicketVo.getMaintainDate()==null) {
            resultEntity.setMsg("维护日期不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(workTicketVo.getWorkTicketTypeId())) {
            resultEntity.setMsg("工作票类型id不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(workTicketVo.getWindId())) {
            resultEntity.setMsg("风电场id不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(workTicketVo.getCrewId())) {
            resultEntity.setMsg("机组id不能为空");
            return resultEntity;
        }
        if (workTicketVo.getApplyTime()==null) {
            resultEntity.setMsg("申请时间不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(workTicketVo.getMaintainer())) {
            resultEntity.setMsg("维护人不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(workTicketVo.getWorkTeam())) {
            resultEntity.setMsg("工作班组不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(workTicketVo.getWorkHead())) {
            resultEntity.setMsg("工作负责人不能为空");
            return resultEntity;
        }
        if (workTicketVo.getPlanStartTime()==null) {
            resultEntity.setMsg("计划开始时间不能为空");
            return resultEntity;
        }
        if (workTicketVo.getPlanEndTime()==null) {
            resultEntity.setMsg("计划结束时间不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(workTicketVo.getDoubleNaem())) {
            resultEntity.setMsg("工作的风电场、升压站名称及设备双重名称不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(workTicketVo.getWorkPlace())) {
            resultEntity.setMsg("工作地点或地段不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(workTicketVo.getWorkContent())) {
            resultEntity.setMsg("工作内容不能为空");
            return resultEntity;
        }

        //添加工作票主数据
        WorkTicket workTicket = new WorkTicket();
        BeanUtils.copyProperties(workTicketVo,workTicket);
        workTicket.setTicketId(UUIdUtil.getUUID());
        workTicket.setSerialNumber(String.valueOf(workTicketMapper.countByExample(new WorkTicketExample())+1));
        workTicketMapper.insert(workTicket);
        //添加安全措施
        List<WorkTicketSafeMeasure> safeMeasureList = workTicketVo.getSafeMeasureList();
        if (safeMeasureList!=null && safeMeasureList.size()!=0) {
            safeMeasureList.forEach(workTicketSafeMeasure -> {
                workTicketSafeMeasure.setSafeId(UUIdUtil.getUUID());
                workTicketSafeMeasure.setTicketId(workTicket.getTicketId());
                workTicketSafeMeasureMapper.insert(workTicketSafeMeasure);
            });
        }
        //添加危险因素控制措施
        List<WorkTicketRiskControl> riskControlList = workTicketVo.getRiskControlList();
        if (riskControlList!=null && riskControlList.size()!=0) {
            riskControlList.forEach(workTicketRiskControl -> {
                workTicketRiskControl.setMeasureId(UUID.randomUUID().toString().replace("-",""));
                workTicketRiskControl.setTicketId(workTicket.getTicketId());
                workTicketRiskControlMapper.insert(workTicketRiskControl);
            });
        }
        //添加每日开工收工使劲按
        List<WorkTicketWorkTime> workTimeList = workTicketVo.getWorkTimeList();
        if (workTimeList!=null && workTimeList.size()!=0) {
            workTimeList.forEach(workTicketWorkTime -> {
                workTicketWorkTime.setWorkTimeId(UUIdUtil.getUUID());
                workTicketWorkTime.setTicketId(workTicket.getTicketId());
                workTicketWorkTimeMapper.insert(workTicketWorkTime);
            });
        }

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("添加成功");
        return resultEntity;
    }

    @Override
    public ResultEntity deleteWorkTicket(String ticketIds) {
        ResultEntity resultEntity = new ResultEntity();

        if (!StringUtils.isNoneBlank(ticketIds)) {
            resultEntity.setMsg("ids不能为空");
            return resultEntity;
        }

        String[] ids = ticketIds.split(",");
        workTicketMapper.batchDelete(ids);

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("删除成功");
        return resultEntity;
    }

    @Override
    public ResultEntity updateWorkTicket(@RequestBody WorkTicketVo workTicketVo) {
        ResultEntity resultEntity = new ResultEntity();

        if (!StringUtils.isNoneBlank(workTicketVo.getTicketId())) {
            resultEntity.setMsg("工作票id不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(workTicketVo.getSerialNumber())) {
            resultEntity.setMsg("工作票号不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(workTicketVo.getMaintainer())) {
            resultEntity.setMsg("维护人不能为空");
            return resultEntity;
        }
        if (workTicketVo.getMaintainDate()==null) {
            resultEntity.setMsg("维护日期不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(workTicketVo.getWorkTicketTypeId())) {
            resultEntity.setMsg("工作票类型id不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(workTicketVo.getWindId())) {
            resultEntity.setMsg("风电场id不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(workTicketVo.getCrewId())) {
            resultEntity.setMsg("机组id不能为空");
            return resultEntity;
        }
        if (workTicketVo.getApplyTime()==null) {
            resultEntity.setMsg("申请时间不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(workTicketVo.getMaintainer())) {
            resultEntity.setMsg("维护人不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(workTicketVo.getWorkTeam())) {
            resultEntity.setMsg("工作班组不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(workTicketVo.getWorkHead())) {
            resultEntity.setMsg("工作负责人不能为空");
            return resultEntity;
        }
        if (workTicketVo.getPlanStartTime()==null) {
            resultEntity.setMsg("计划开始时间不能为空");
            return resultEntity;
        }
        if (workTicketVo.getPlanEndTime()==null) {
            resultEntity.setMsg("计划结束时间不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(workTicketVo.getDoubleNaem())) {
            resultEntity.setMsg("工作的风电场、升压站名称及设备双重名称不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(workTicketVo.getWorkPlace())) {
            resultEntity.setMsg("工作地点或地段不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(workTicketVo.getWorkContent())) {
            resultEntity.setMsg("工作内容不能为空");
            return resultEntity;
        }

        //修改工作票主数据
        WorkTicket workTicket = new WorkTicket();
        BeanUtils.copyProperties(workTicketVo,workTicket);
        workTicketMapper.updateByPrimaryKey(workTicket);
        //修改安全措施
        WorkTicketSafeMeasureExample workTicketSafeMeasureExample = new WorkTicketSafeMeasureExample();
        workTicketSafeMeasureExample.createCriteria().andTicketIdEqualTo(workTicketVo.getTicketId());
        workTicketSafeMeasureMapper.deleteByExample(workTicketSafeMeasureExample);
        List<WorkTicketSafeMeasure> safeMeasureList = workTicketVo.getSafeMeasureList();
        if (safeMeasureList!=null && safeMeasureList.size()!=0) {
            safeMeasureList.forEach(workTicketSafeMeasure -> {
                workTicketSafeMeasure.setSafeId(UUIdUtil.getUUID());
                workTicketSafeMeasure.setTicketId(workTicketVo.getTicketId());
                workTicketSafeMeasureMapper.insert(workTicketSafeMeasure);
            });
        }
        //添加危险因素控制措施
        WorkTicketRiskControlExample workTicketRiskControlExample = new WorkTicketRiskControlExample();
        workTicketRiskControlExample.createCriteria().andTicketIdEqualTo(workTicketVo.getTicketId());
        workTicketRiskControlMapper.deleteByExample(workTicketRiskControlExample);
        List<WorkTicketRiskControl> riskControlList = workTicketVo.getRiskControlList();
        if (riskControlList!=null && riskControlList.size()!=0) {
            riskControlList.forEach(workTicketRiskControl -> {
                workTicketRiskControl.setMeasureId(UUID.randomUUID().toString().replace("-",""));
                workTicketRiskControl.setTicketId(workTicketVo.getTicketId());
                workTicketRiskControlMapper.insert(workTicketRiskControl);
            });
        }
        //添加每日开工收工时间
        WorkTicketWorkTimeExample workTicketWorkTimeExample = new WorkTicketWorkTimeExample();
        workTicketWorkTimeExample.createCriteria().andTicketIdEqualTo(workTicketVo.getTicketId());
        workTicketWorkTimeMapper.deleteByExample(workTicketWorkTimeExample);
        List<WorkTicketWorkTime> workTimeList = workTicketVo.getWorkTimeList();
        if (workTimeList!=null && workTimeList.size()!=0) {
            workTimeList.forEach(workTicketWorkTime -> {
                workTicketWorkTime.setWorkTimeId(UUIdUtil.getUUID());
                workTicketWorkTime.setTicketId(workTicketVo.getTicketId());
                workTicketWorkTimeMapper.insert(workTicketWorkTime);
            });
        }

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("修改成功");
        return resultEntity;
    }

    @Override
    public ResultEntity getWorkTicketDetail(String ticketId) {
        ResultEntity resultEntity = new ResultEntity();

        if (!StringUtils.isNoneBlank(ticketId)) {
            resultEntity.setMsg("id不能为空");
            return resultEntity;
        }
        //获取工作票主数据
        WorkTicketVo workTicketVo = workTicketMapper.getWorkTicketDetail(ticketId);
        if (workTicketVo!=null) {
            //获取安全措施
            WorkTicketSafeMeasureExample workTicketSafeMeasureExample = new WorkTicketSafeMeasureExample();
            workTicketSafeMeasureExample.setOrderByClause("safe_number");
            workTicketSafeMeasureExample.createCriteria().andTicketIdEqualTo(workTicketVo.getTicketId());
            List<WorkTicketSafeMeasure> safeMeasureList = workTicketSafeMeasureMapper.selectByExample(workTicketSafeMeasureExample);
            if (safeMeasureList!=null && safeMeasureList.size()!=0) {
                safeMeasureList.forEach(workTicketSafeMeasure -> {
                    workTicketVo.getSafeMeasureList().add(workTicketSafeMeasure);
                });
            }
            //获取危险因素控制措施
            WorkTicketRiskControlExample workTicketRiskControlExample = new WorkTicketRiskControlExample();
            workTicketRiskControlExample.setOrderByClause("measure_id");
            workTicketRiskControlExample.createCriteria().andTicketIdEqualTo(workTicketVo.getTicketId());
            List<WorkTicketRiskControl> riskControlList = workTicketRiskControlMapper.selectByExample(workTicketRiskControlExample);
            if (riskControlList!=null && riskControlList.size()!=0) {
                riskControlList.forEach(workTicketRiskControl -> {
                    workTicketVo.getRiskControlList().add(workTicketRiskControl);
                });
            }
            //获取开工收工工作时间
            WorkTicketWorkTimeExample workTicketWorkTimeExample = new WorkTicketWorkTimeExample();
            workTicketWorkTimeExample.setOrderByClause("work_time_number");
            workTicketWorkTimeExample.createCriteria().andTicketIdEqualTo(workTicketVo.getTicketId());
            List<WorkTicketWorkTime> workTimeList = workTicketWorkTimeMapper.selectByExample(workTicketWorkTimeExample);
            if (workTimeList!=null && workTimeList.size()!=0) {
                workTimeList.forEach(workTicketWorkTime -> {
                    workTicketVo.getWorkTimeList().add(workTicketWorkTime);
                });
            }

        }

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("查询成功");
        resultEntity.setData(workTicketVo);
        return resultEntity;
    }

    @Override
    public PageResultEntity getWorkTicketList(Map<String,String> pageAndCondition) {
        PageResultEntity pageResultEntity = new PageResultEntity();
        pageResultEntity.setRows(new ArrayList());

        String start = String.valueOf((Integer.parseInt(pageAndCondition.get("pageNum"))-1)*(Integer.parseInt(pageAndCondition.get("pageSize"))));
        pageAndCondition.put("start",start);
        List<WorkTicketVo> workTicketVoList= workTicketMapper.getWorkTicketList(pageAndCondition);
        int total = workTicketMapper.getTotal(pageAndCondition);

        pageResultEntity.setCode(ErrorCode.SUCCESS);
        pageResultEntity.setMsg("查询成功");
        pageResultEntity.setRows(workTicketVoList);
        pageResultEntity.setTotal(total);
        return pageResultEntity;
    }

    @Override
    public ResultEntity getWorkTicketStatistics(String startDate, String endDate) {
        ResultEntity resultEntity = new ResultEntity();
        List<TicketStatisticsRes> workTicketStatisticsList=null;

        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String startTime=null;
            String endTime=null;
            if (startDate!=null) {
                startTime = simpleDateFormat.format(simpleDateFormat.parse(startDate));
            }
            if (endDate!=null) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(simpleDateFormat.parse(endDate));
                calendar.add(Calendar.DAY_OF_MONTH,1);
                endTime = simpleDateFormat.format(calendar.getTime());
            }
            workTicketStatisticsList =  workTicketMapper.getWorkTicketStatisticsList(startTime, endTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("操作成功");
        resultEntity.setData(workTicketStatisticsList);
        return resultEntity;
    }
}
