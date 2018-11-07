package com.qz.zframe.tickets.service.impl;

import com.qz.zframe.authentication.CurrentUserService;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.common.util.UUIdUtil;
import com.qz.zframe.tickets.entity.*;
import com.qz.zframe.tickets.mapper.StandardWorkTicketMapper;
import com.qz.zframe.tickets.mapper.WorkTicketTypeMapper;
import com.qz.zframe.tickets.mapper.WorkTicketTypeSafeMeasureMapper;
import com.qz.zframe.tickets.mapper.WorkTicketTypeUserMapper;
import com.qz.zframe.tickets.service.StandardWorkTicketService;
import com.qz.zframe.tickets.vo.StandardWorkTicketRes;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional(rollbackFor = Exception.class)
public class SatndardWorkTicketServiceImpl implements StandardWorkTicketService {

    @Autowired
    private CurrentUserService currentUserService;

    @Autowired
    private StandardWorkTicketMapper standardWorkTicketMapper;

    @Autowired
    private WorkTicketTypeMapper workTicketTypeMapper;

    @Autowired
    private WorkTicketTypeSafeMeasureMapper workTicketTypeSafeMeasureMapper;

    @Autowired
    private WorkTicketTypeUserMapper workTicketTypeUserMapper;

    @Override
    public ResultEntity getStandardWorkTicketList() {
        ResultEntity resultEntity = new ResultEntity();
        List<StandardWorkTicketRes> standardWorkTicketReList = new ArrayList<>();

        List<StandardWorkTicket> standardWorkTicketList = standardWorkTicketMapper.selectByExample(new StandardWorkTicketExample());
        standardWorkTicketList.forEach(standardWorkTicket -> {
            StandardWorkTicketRes standardWorkTicketRes = new StandardWorkTicketRes();
            BeanUtils.copyProperties(standardWorkTicket,standardWorkTicketRes);
            WorkTicketTypeSafeMeasureExample workTicketTypeSafeMeasureExample = new WorkTicketTypeSafeMeasureExample();
            workTicketTypeSafeMeasureExample.createCriteria().andTicketTypeIdEqualTo(standardWorkTicket.getTicketTypeId());
            List<WorkTicketTypeSafeMeasure> workTicketTypeSafeMeasureList = workTicketTypeSafeMeasureMapper.selectByExample(workTicketTypeSafeMeasureExample);
            workTicketTypeSafeMeasureList.forEach(workTicketTypeSafeMeasure -> {
                standardWorkTicketRes.getSafeMeasureList().add(workTicketTypeSafeMeasure);
            });
            standardWorkTicketReList.add(standardWorkTicketRes);
        });

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("操作成功");
        resultEntity.setData(standardWorkTicketReList);
        return resultEntity;
    }

    @Override
    public ResultEntity createStandardWorkTicket() {
        ResultEntity resultEntity = new ResultEntity();
        StandardWorkTicket standardWorkTicket = new StandardWorkTicket();

        try {
            String standardTicketId = UUIdUtil.getUUID();
            String serialNumber = "1111";
            String maintainer = currentUserService.getUsername();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date maintainDate = simpleDateFormat.parse(simpleDateFormat.format(new Date()));
            standardWorkTicket.setTicketTypeId(standardTicketId);
            standardWorkTicket.setSerialNumber(serialNumber);
            standardWorkTicket.setMaintainer(maintainer);
            standardWorkTicket.setMaintainDate(maintainDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("操作成功");
        resultEntity.setData(standardWorkTicket);
        return resultEntity;
    }

    @Override
    public ResultEntity addStandardWorkTicket(StandardWorkTicket standardWorkTicket) {
        ResultEntity resultEntity = new ResultEntity();

        standardWorkTicketMapper.insert(standardWorkTicket);
        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("操作成功");
        return resultEntity;
    }

    @Override
    public ResultEntity deleteStandardWorkTicket(String standardTicketIds) {
        ResultEntity resultEntity = new ResultEntity();

        String[] ids = standardTicketIds.split(",");

        standardWorkTicketMapper.batchDelete(ids);

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("操作成功");
        return resultEntity;
    }

    @Override
    public ResultEntity updateStandardWorkTicket(StandardWorkTicket standardWorkTicket) {
        ResultEntity resultEntity = new ResultEntity();

        standardWorkTicketMapper.updateByPrimaryKey(standardWorkTicket);

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("操作成功");
        return resultEntity;
    }

    @Override
    public ResultEntity getStandardWorkTicketDetail(String standardTicketId) {
        ResultEntity resultEntity = new ResultEntity();

        StandardWorkTicket standardWorkTicket = standardWorkTicketMapper.selectByPrimaryKey(standardTicketId);

        StandardWorkTicketRes standardWorkTicketRes = new StandardWorkTicketRes();
        BeanUtils.copyProperties(standardWorkTicket,standardWorkTicketRes);

        WorkTicketType workTicketType = workTicketTypeMapper.selectByPrimaryKey(standardWorkTicket.getTicketTypeId());
        if ("0".equals(workTicketType.getStatus())||"2".equals(workTicketType.getStatus())) {
            resultEntity.setMsg("该标准工作票使用的工作票类型已被删除或停用");
            return resultEntity;
        }
        //获取安全措施
        WorkTicketTypeSafeMeasureExample workTicketTypeSafeMeasureExample = new WorkTicketTypeSafeMeasureExample();
        workTicketTypeSafeMeasureExample.createCriteria().andTicketTypeIdEqualTo(standardWorkTicket.getTicketTypeId());
        List<WorkTicketTypeSafeMeasure> safeMeasureList = workTicketTypeSafeMeasureMapper.selectByExample(workTicketTypeSafeMeasureExample);
        if (safeMeasureList!=null) {
            safeMeasureList.forEach(workTicketTypeSafeMeasure -> {
                standardWorkTicketRes.getSafeMeasureList().add(workTicketTypeSafeMeasure);
            });
        }
        //获取工作负责人
        WorkTicketTypeUserExample workTicketTypeUserExample = new WorkTicketTypeUserExample();
        WorkTicketTypeUserExample.Criteria workHeadCriteria = workTicketTypeUserExample.createCriteria();
        workHeadCriteria.andTicketTypeIdEqualTo(standardWorkTicket.getTicketTypeId());
        workHeadCriteria.andUserTypeEqualTo("01");
        List<WorkTicketTypeUser> workHeadList = workTicketTypeUserMapper.selectByExample(workTicketTypeUserExample);
        if (workHeadList!=null) {
            workHeadList.forEach(workTicketTypeUser -> {
                standardWorkTicketRes.getWorkHeadList().add(workTicketTypeUser);
            });
        }
        //获取签收人
        WorkTicketTypeUserExample.Criteria signerCriteria = workTicketTypeUserExample.createCriteria();
        signerCriteria.andTicketTypeIdEqualTo(standardWorkTicket.getTicketTypeId());
        signerCriteria.andUserTypeEqualTo("02");
        List<WorkTicketTypeUser> signerList = workTicketTypeUserMapper.selectByExample(workTicketTypeUserExample);
        if (workHeadList!=null) {
            workHeadList.forEach(workTicketTypeUser -> {
                standardWorkTicketRes.getSignerList().add(workTicketTypeUser);
            });
        }
        //获取许可人
        WorkTicketTypeUserExample.Criteria licensorCriteria = workTicketTypeUserExample.createCriteria();
        licensorCriteria.andTicketTypeIdEqualTo(standardWorkTicket.getTicketTypeId());
        licensorCriteria.andUserTypeEqualTo("03");
        List<WorkTicketTypeUser> licensorList = workTicketTypeUserMapper.selectByExample(workTicketTypeUserExample);
        if (workHeadList!=null) {
            licensorList.forEach(workTicketTypeUser -> {
                standardWorkTicketRes.getLicensorList().add(workTicketTypeUser);
            });
        }

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("操作成功");
        resultEntity.setData(standardWorkTicketRes);
        return resultEntity;
    }
}
