package com.qz.zframe.tickets.service.impl;

import com.qz.zframe.authentication.CurrentUserService;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.common.util.UUIdUtil;
import com.qz.zframe.tickets.entity.OperateTicketType;
import com.qz.zframe.tickets.entity.OperateTicketTypeExample;
import com.qz.zframe.tickets.mapper.OperateTicketTypeMapper;
import com.qz.zframe.tickets.service.OperateTicketTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional(rollbackFor = Exception.class)
public class OperateTicketTypeServiceImpl implements OperateTicketTypeService {

    @Autowired
    private CurrentUserService currentUserService;

    @Autowired
    private OperateTicketTypeMapper operateTicketTypeMapper;

    @Override
    public ResultEntity getOperateTicketTypeList() {
        ResultEntity resultEntity = new ResultEntity();

        List<OperateTicketType> operateTicketTypeList = operateTicketTypeMapper.selectByExample(new OperateTicketTypeExample());

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("操作成功");
        resultEntity.setData(operateTicketTypeList);
        return resultEntity;
    }

    @Override
    public ResultEntity createOperateTicketType() {
        ResultEntity resultEntity = new ResultEntity();
        OperateTicketType operateTicketType = new OperateTicketType();

        try {
            String ticketTypeId = UUIdUtil.getUUID();
            String serialNumber = "1111";
            String maintainer = currentUserService.getUsername();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date maintainDate = simpleDateFormat.parse(simpleDateFormat.format(new Date()));
            operateTicketType.setTicketTypeId(ticketTypeId);
            operateTicketType.setSerialNumber(serialNumber);
            operateTicketType.setMaintainer(maintainer);
            operateTicketType.setMaintainDate(maintainDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("操作成功");
        resultEntity.setData(operateTicketType);
        return resultEntity;
    }

    @Override
    public ResultEntity addOperateTicketType(OperateTicketType operateTicketType) {
        ResultEntity resultEntity = new ResultEntity();

        operateTicketTypeMapper.insert(operateTicketType);

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("操作成功");
        return resultEntity;
    }

    @Override
    public ResultEntity deleteOperateTicketType(String ticketTypeIds) {
        ResultEntity resultEntity = new ResultEntity();

        String[] ids = ticketTypeIds.split(",");

        operateTicketTypeMapper.batchDelete(ids);

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("操作成功");
        return resultEntity;
    }

    @Override
    public ResultEntity updateOperateTicketType(OperateTicketType operateTicketType) {
        ResultEntity resultEntity = new ResultEntity();

        operateTicketTypeMapper.updateByPrimaryKey(operateTicketType);

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("操作成功");
        return resultEntity;
    }

    @Override
    public ResultEntity selectOperateTicketType(String ticketTypeId) {
        ResultEntity resultEntity = new ResultEntity();

        OperateTicketType operateTicketType = operateTicketTypeMapper.selectByPrimaryKey(ticketTypeId);
        if (operateTicketType==null) {
            resultEntity.setMsg("该操作票类型不存在");
            return resultEntity;
        }

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("操作成功");
        resultEntity.setData(operateTicketType);
        return resultEntity;
    }
}
