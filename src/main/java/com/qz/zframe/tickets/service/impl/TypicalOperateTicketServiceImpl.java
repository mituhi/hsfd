package com.qz.zframe.tickets.service.impl;

import com.qz.zframe.authentication.CurrentUserService;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.common.util.UUIdUtil;
import com.qz.zframe.tickets.entity.OperateTicketType;
import com.qz.zframe.tickets.entity.TypicalOperateTicket;
import com.qz.zframe.tickets.mapper.OperateTicketTypeMapper;
import com.qz.zframe.tickets.mapper.TypicalOperateTicketMapper;
import com.qz.zframe.tickets.service.TypicalOperateTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@Transactional(rollbackFor = Exception.class)
public class TypicalOperateTicketServiceImpl implements TypicalOperateTicketService {

    @Autowired
    private CurrentUserService currentUserService;

    @Autowired
    private TypicalOperateTicketMapper typicalOperateTicketMapper;

    @Autowired
    private OperateTicketTypeMapper operateTicketTypeMapper;

    @Override
    public PageResultEntity getTypicalOperateTicketList(Map<String,String> pageAndCondition) {
        PageResultEntity pageResultEntity = new PageResultEntity();

        String start = String.valueOf((Integer.parseInt(pageAndCondition.get("pageNum"))-1)*(Integer.parseInt(pageAndCondition.get("pageSize"))));
        pageAndCondition.put("start",start);
        List<TypicalOperateTicket> typicalOperateTicketList = typicalOperateTicketMapper.getTypicalOperateTicketListByPC(pageAndCondition);
        int totalCount = typicalOperateTicketMapper.getTotalCount(pageAndCondition);

        pageResultEntity.setCode(ErrorCode.SUCCESS);
        pageResultEntity.setMsg("操作成功");
        pageResultEntity.setTotal(totalCount);
        pageResultEntity.setRows(typicalOperateTicketList);
        return pageResultEntity;
    }

    @Override
    public ResultEntity createTypicalOperateTicket() {
        ResultEntity resultEntity = new ResultEntity();
        TypicalOperateTicket typicalOperateTicket = new TypicalOperateTicket();

        try {
            String typicalTicketId = UUIdUtil.getUUID();
            String serialNumber = "1111";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String typicalTickeCode = simpleDateFormat.format(new Date()) + "-" + serialNumber;
            String maintainer = currentUserService.getUsername();
            Date maintainDate = simpleDateFormat.parse(simpleDateFormat.format(new Date()));
            typicalOperateTicket.setTypicalTicketId(typicalTicketId);
            typicalOperateTicket.setSerialNumber(serialNumber);
            typicalOperateTicket.setTypicalTickeCode(typicalTickeCode);
            typicalOperateTicket.setMaintainer(maintainer);
            typicalOperateTicket.setMaintainDate(maintainDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("操作成功");
        resultEntity.setData(typicalOperateTicket);
        return resultEntity;
    }

    @Override
    public ResultEntity addTypicalOperateTicket(TypicalOperateTicket typicalOperateTicket) {
        ResultEntity resultEntity = new ResultEntity();

        typicalOperateTicketMapper.insert(typicalOperateTicket);

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("操作成功");
        return resultEntity;
    }

    @Override
    public ResultEntity deleteTypicalOperateTicket(String typicalTicketIds) {
        ResultEntity resultEntity = new ResultEntity();

        String[] ids = typicalTicketIds.split(",");

        typicalOperateTicketMapper.batchDelete(ids);

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("操作成功");
        return resultEntity;
    }

    @Override
    public ResultEntity updateTypicalOperateTicket(TypicalOperateTicket typicalOperateTicket) {
        ResultEntity resultEntity = new ResultEntity();

        typicalOperateTicketMapper.updateByPrimaryKey(typicalOperateTicket);

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("操作成功");
        return resultEntity;
    }

    @Override
    public ResultEntity selectTypicalOperateTicket(String typicalTicketId) {
        ResultEntity resultEntity = new ResultEntity();

        TypicalOperateTicket typicalOperateTicket = typicalOperateTicketMapper.selectByPrimaryKey(typicalTicketId);

        OperateTicketType operateTicketType = operateTicketTypeMapper.selectByPrimaryKey(typicalOperateTicket.getTicketTypeId());
        if ("0".equals(operateTicketType.getStatus())||"2".equals(operateTicketType.getStatus())) {
            resultEntity.setMsg("该典型操作票使用的操作票类型已被删除或停用");
            return resultEntity;
        }

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("操作成功");
        resultEntity.setData(typicalOperateTicket);
        return resultEntity;
    }
}
