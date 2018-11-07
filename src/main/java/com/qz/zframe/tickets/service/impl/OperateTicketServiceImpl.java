package com.qz.zframe.tickets.service.impl;

import com.qz.zframe.authentication.CurrentUserService;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.common.util.UUIdUtil;
import com.qz.zframe.tickets.entity.*;
import com.qz.zframe.tickets.mapper.OperateItemsMapper;
import com.qz.zframe.tickets.mapper.OperateTicketMapper;
import com.qz.zframe.tickets.service.OperateTicketService;
import com.qz.zframe.tickets.vo.OperateTicketVo;
import com.qz.zframe.tickets.vo.TicketStatisticsRes;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@Transactional(rollbackFor = Exception.class)
public class OperateTicketServiceImpl implements OperateTicketService {

    @Autowired
    private CurrentUserService currentUserService;

    @Autowired
    private OperateTicketMapper operateTicketMapper;

    @Autowired
    private OperateItemsMapper operateItemsMapper;

    @Override
    public PageResultEntity getOperateTicketList(Map<String,String> pageAndCondition) {
        PageResultEntity pageResultEntity = new PageResultEntity();
        pageResultEntity.setRows(new ArrayList());

        String start = String.valueOf((Integer.parseInt(pageAndCondition.get("pageNum"))-1)*(Integer.parseInt(pageAndCondition.get("pageSize"))));
        pageAndCondition.put("start",start);
        List<OperateTicket> operateTicketList = operateTicketMapper.getOperateTicketListByPageAndCondition(pageAndCondition);
        List<OperateTicketVo> operateTicketVoList = new ArrayList<>();
        operateTicketList.forEach(operateTicket -> {
            OperateTicketVo operateTicketVo = new OperateTicketVo();
            BeanUtils.copyProperties(operateTicket,operateTicketVo);
            operateTicketVoList.add(operateTicketVo);
        });
        operateTicketVoList.forEach(operateTicketVo -> {
            OperateItemsExample operateItemsExample = new OperateItemsExample();
            operateItemsExample.createCriteria().andTicketIdEqualTo(operateTicketVo.getTicketId());
            List<OperateItems> list = operateItemsMapper.selectByExample(operateItemsExample);
            if (list!=null) {
                list.forEach(workTicketRiskControl -> {
                    operateTicketVo.getOperateItemsList().add(workTicketRiskControl);
                });
                pageResultEntity.getRows().add(operateTicketVo);
            }
        });

        pageResultEntity.setTotal(operateTicketMapper.getTotalCount(pageAndCondition));
        pageResultEntity.setCode(ErrorCode.SUCCESS);
        pageResultEntity.setMsg("操作成功");
        return pageResultEntity;
    }

    @Override
    public ResultEntity createOperateTicket() {
        ResultEntity resultEntity = new ResultEntity();

        OperateTicket operateTicket = new OperateTicket();
        String ticketId = UUIdUtil.getUUID();
        String serialNumber = "1111";
        String applicatant = currentUserService.getUsername();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String ticketCode = simpleDateFormat.format(new Date())+"-"+serialNumber;
        operateTicket.setTicketId(ticketId);
        operateTicket.setApplicant(applicatant);
        operateTicket.setSerialNumber(serialNumber);
        operateTicket.setTicketId(ticketCode);

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("操作成功");
        resultEntity.setData(operateTicket);
        return resultEntity;
    }

    @Override
    public ResultEntity addOperateTicket(OperateTicketVo operateTicketVo) {
        ResultEntity resultEntity = new ResultEntity();

        OperateTicket operateTicket = operateTicketVo;
        operateTicketMapper.insert(operateTicket);

        List<OperateItems> operateItemList = operateTicketVo.getOperateItemsList();
        String ticketId = operateTicketVo.getTicketId();
        operateItemList.forEach(operateItem -> {
            operateItem.setItemId(UUID.randomUUID().toString().replace("-",""));
            operateItem.setTicketId(ticketId);
            operateItemsMapper.insert(operateItem);
        } );
        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("操作成功");
        return  resultEntity;
    }

    @Override
    public ResultEntity deleteOperateTicket(String ticketIds) {
        ResultEntity resultEntity = new ResultEntity();

        String[] ids = ticketIds.split(",");

        operateTicketMapper.batchDelete(ids);

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("操作成功");
        return resultEntity;
    }

    @Override
    public ResultEntity updateOperateTicket(OperateTicketVo operateTicketVo) {
        ResultEntity resultEntity = new ResultEntity();

        OperateTicket operateTicket = operateTicketVo;
        operateTicketMapper.updateByPrimaryKey(operateTicket);

        OperateItemsExample operateItemsExample = new OperateItemsExample();
        operateItemsExample.createCriteria().andTicketIdEqualTo(operateTicketVo.getTicketId());
        operateItemsMapper.deleteByExample(operateItemsExample);

        List<OperateItems> operateItemList = operateTicketVo.getOperateItemsList();
        String ticketId = operateTicketVo.getTicketId();
        operateItemList.forEach(operateItem -> {
            operateItem.setItemId(UUID.randomUUID().toString().replace("-",""));
            operateItem.setTicketId(ticketId);
            operateItemsMapper.insert(operateItem);
        } );

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("操作成功");
        return  resultEntity;
    }

    @Override
    public ResultEntity getOperateTicketDetail(String ticketId) {
        ResultEntity resultEntity = new ResultEntity();

        OperateTicket operateTicket = operateTicketMapper.selectByPrimaryKey(ticketId);
        if(operateTicket==null) {
            resultEntity.setMsg("该操作票不存在");
            return resultEntity;
        }
        OperateTicketVo operateTicketVo = new OperateTicketVo();
        BeanUtils.copyProperties(operateTicket,operateTicketVo);
        OperateItemsExample operateItemsExample = new OperateItemsExample();
        operateItemsExample.createCriteria().andTicketIdEqualTo(ticketId);
        List<OperateItems> operateItemList = operateItemsMapper.selectByExample(operateItemsExample);
        if (operateItemList!=null) {
            operateItemList.forEach(operateItem -> {
                operateTicketVo.getOperateItemsList().add(operateItem);
            } );
        }

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("操作成功");
        resultEntity.setData(operateTicketVo);
        return resultEntity;
    }

    @Override
    public ResultEntity getOperateTicketStatistics(String startDate, String endDate) {
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
            workTicketStatisticsList = operateTicketMapper.getOperateTicketStatisticsList(startTime, endTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("操作成功");
        resultEntity.setData(workTicketStatisticsList);
        return resultEntity;

    }
}
