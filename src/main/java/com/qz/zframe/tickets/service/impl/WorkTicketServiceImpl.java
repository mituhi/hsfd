package com.qz.zframe.tickets.service.impl;

import com.qz.zframe.authentication.CurrentUserService;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.common.util.UUIdUtil;
import com.qz.zframe.tickets.entity.WorkTicket;
import com.qz.zframe.tickets.entity.WorkTicketRiskControl;
import com.qz.zframe.tickets.entity.WorkTicketRiskControlExample;
import com.qz.zframe.tickets.mapper.WorkTicketMapper;
import com.qz.zframe.tickets.mapper.WorkTicketRiskControlMapper;
import com.qz.zframe.tickets.vo.TicketStatisticsRes;
import com.qz.zframe.tickets.vo.WorkTicketVo;
import com.qz.zframe.tickets.service.WorkTicketService;
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
    private WorkTicketRiskControlMapper workTicketRiskControlMapper;

    @Override
    public PageResultEntity getWorkTicketList(Map<String,String> pageAndCondition) {
        PageResultEntity pageResultEntity = new PageResultEntity();
        pageResultEntity.setRows(new ArrayList());

        String start = String.valueOf((Integer.parseInt(pageAndCondition.get("pageNum"))-1)*(Integer.parseInt(pageAndCondition.get("pageSize"))));
        pageAndCondition.put("start",start);
        List<WorkTicket> workTicketList = workTicketMapper.getWorkTicketListByPageAndCondition(pageAndCondition);
        List<WorkTicketVo> workTicketVoList = new ArrayList<>();
        workTicketList.forEach(workTicket -> {
            WorkTicketVo workTicketVo = new WorkTicketVo();
            BeanUtils.copyProperties(workTicket,workTicketVo);
            workTicketVoList.add(workTicketVo);
        });
        workTicketVoList.forEach(workTicketVo -> {
            WorkTicketRiskControlExample workTicketRiskControlExample = new WorkTicketRiskControlExample();
            workTicketRiskControlExample.createCriteria().andTicketIdEqualTo(workTicketVo.getTicketId());
            List<WorkTicketRiskControl> list = workTicketRiskControlMapper.selectByExample(workTicketRiskControlExample);
            if (list!=null) {
                list.forEach(workTicketRiskControl -> {
                    workTicketVo.getWorkTicketRiskControlList().add(workTicketRiskControl);
                });
                pageResultEntity.getRows().add(workTicketVo);
            }
        });

        pageResultEntity.setTotal(workTicketMapper.getTotalCount(pageAndCondition));
        pageResultEntity.setCode(ErrorCode.SUCCESS);
        pageResultEntity.setMsg("操作成功");
        return pageResultEntity;
    }

    @Override
    public ResultEntity createWorkTicket() {
        ResultEntity resultEntity = new ResultEntity();
        WorkTicket workTicket = new WorkTicket();

        String ticketId = UUIdUtil.getUUID();
        String serialNumber = "1111";
        String applicatant = currentUserService.getUsername();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String ticketCode = simpleDateFormat.format(new Date())+"-"+serialNumber;
        workTicket.setTicketId(ticketId);
        workTicket.setApplicant(applicatant);
        workTicket.setSerialNumber(serialNumber);
        workTicket.setTicketCode(ticketCode);


        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("操作成功");
        resultEntity.setData(workTicket);
        return resultEntity;
    }

    @Override
    public ResultEntity addWorkTicket(WorkTicketVo workTicketVo) {
        ResultEntity resultEntity = new ResultEntity();

        WorkTicket workTicket = workTicketVo;
        workTicketMapper.insert(workTicket);

        List<WorkTicketRiskControl> list = workTicketVo.getWorkTicketRiskControlList();
        if (list!=null) {
            list.forEach(workTicketRiskControl -> {
                workTicketRiskControl.setMeasureId(UUID.randomUUID().toString().replace("-",""));
                workTicketRiskControl.setTicketId(workTicketVo.getTicketId());
                workTicketRiskControlMapper.insert(workTicketRiskControl);
            });
        }

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("操作成功");
        return resultEntity;
    }

    @Override
    public ResultEntity deleteWorkTicket(String ticketIds) {
        ResultEntity resultEntity = new ResultEntity();

        String[] ids = ticketIds.split(",");

        workTicketMapper.batchDelete(ids);

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("操作成功");
        return resultEntity;
    }

    @Override
    public ResultEntity updateWorkTicket(@RequestBody WorkTicketVo workTicketVo) {
        ResultEntity resultEntity = new ResultEntity();

        WorkTicket workTicket = workTicketVo;
        workTicketMapper.updateByPrimaryKey(workTicket);

        List<WorkTicketRiskControl> list = workTicketVo.getWorkTicketRiskControlList();
        WorkTicketRiskControlExample workTicketRiskControlExample = new WorkTicketRiskControlExample();
        workTicketRiskControlExample.createCriteria().andTicketIdEqualTo(workTicketVo.getTicketId());
        workTicketRiskControlMapper.deleteByExample(workTicketRiskControlExample);
        if (list!=null) {
            list.forEach(workTicketRiskControl -> {
                workTicketRiskControl.setMeasureId(UUID.randomUUID().toString().replace("-",""));
                workTicketRiskControl.setTicketId(workTicketVo.getTicketId());
                workTicketRiskControlMapper.insert(workTicketRiskControl);
            });
        }

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("操作成功");
        return resultEntity;
    }

    @Override
    public ResultEntity getWorkTicketDetail(String ticketId) {
        ResultEntity resultEntity = new ResultEntity();

        WorkTicket workTicket = workTicketMapper.selectByPrimaryKey(ticketId);
        if (workTicket==null) {
            resultEntity.setMsg("该工作票不存在");
            return resultEntity;
        }
        WorkTicketVo workTicketVo = new WorkTicketVo();
        BeanUtils.copyProperties(workTicket,workTicketVo);

        WorkTicketRiskControlExample workTicketRiskControlExample = new WorkTicketRiskControlExample();
        workTicketRiskControlExample.createCriteria().andTicketIdEqualTo(ticketId);
        List<WorkTicketRiskControl> list = workTicketRiskControlMapper.selectByExample(workTicketRiskControlExample);
        if (list!=null) {
            list.forEach(workTicketRiskControl -> {
                workTicketVo.getWorkTicketRiskControlList().add(workTicketRiskControl);
            });
        }

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("查询成功");
        resultEntity.setData(workTicketVo);
        return resultEntity;
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
            workTicketStatisticsList = workTicketMapper.getWorkTicketStatisticsList(startTime, endTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("操作成功");
        resultEntity.setData(workTicketStatisticsList);
        return resultEntity;
    }
}
