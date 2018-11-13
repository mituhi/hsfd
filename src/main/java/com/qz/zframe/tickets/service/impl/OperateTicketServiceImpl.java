package com.qz.zframe.tickets.service.impl;

import com.qz.zframe.authentication.CurrentUserService;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.common.util.UUIdUtil;
import com.qz.zframe.tickets.entity.*;
import com.qz.zframe.tickets.mapper.OperateItemMapper;
import com.qz.zframe.tickets.mapper.OperateTicketMapper;
import com.qz.zframe.tickets.service.OperateTicketService;
import com.qz.zframe.tickets.vo.OperateTicketVo;
import com.qz.zframe.tickets.vo.TicketStatisticsRes;
import org.apache.commons.lang3.StringUtils;
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
    private OperateItemMapper operateItemMapper;

    @Override
    public ResultEntity addOperateTicket(OperateTicketVo operateTicketVo) {
        ResultEntity resultEntity = new ResultEntity();

        if (!StringUtils.isNoneBlank(operateTicketVo.getMaintainer())) {
            resultEntity.setMsg("维护人不能为空");
            return resultEntity;
        }
        if (operateTicketVo.getMaintainDate()==null) {
            resultEntity.setMsg("维护日期不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(operateTicketVo.getOperTicketTypeId())) {
            resultEntity.setMsg("操作票类型id不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(operateTicketVo.getSerialNumber())) {
            resultEntity.setMsg("操作票号不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(operateTicketVo.getCrewId())) {
            resultEntity.setMsg("风电场id不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(operateTicketVo.getCrewId())) {
            resultEntity.setMsg("机组id不能为空");
            return resultEntity;
        }
        if (operateTicketVo.getApplyTime()==null) {
            resultEntity.setMsg("申请时间不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(operateTicketVo.getSender())) {
            resultEntity.setMsg("发令人不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(operateTicketVo.getReceiver())) {
            resultEntity.setMsg("受令人不能为空");
            return resultEntity;
        }
        if (operateTicketVo.getSendTime()==null) {
            resultEntity.setMsg("发令时间不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(operateTicketVo.getWorkTeam())) {
            resultEntity.setMsg("工作班组不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(operateTicketVo.getExecuter())) {
            resultEntity.setMsg("操作人不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(operateTicketVo.getSupervisior())) {
            resultEntity.setMsg("监护人不能为空");
            return resultEntity;
        }
        if (operateTicketVo.getOperStartTime()==null) {
            resultEntity.setMsg("操作开始时间不能为空");
            return resultEntity;
        }
        if (operateTicketVo.getOperEndTime()==null) {
            resultEntity.setMsg("操作结束时间不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(operateTicketVo.getOperateContent())) {
            resultEntity.setMsg("操作内容不能为空");
            return resultEntity;
        }
        //添加操作票主数据
        OperateTicket operateTicket = new OperateTicket();
        BeanUtils.copyProperties(operateTicketVo,operateTicket);
        operateTicket.setTicketId(UUIdUtil.getUUID());
        operateTicket.setSerialNumber(String.valueOf(operateTicketMapper.countByExample(new OperateTicketExample())+1));
        operateTicketMapper.insert(operateTicket);
        //添加操作项
        List<OperateItem> operateItemList = operateTicketVo.getOperateItemsList();
        if (operateItemList!=null &&operateItemList.size()!=0) {
            operateItemList.forEach(operateItem -> {
                operateItem.setItemId(UUID.randomUUID().toString().replace("-",""));
                operateItem.setTicketId(operateTicket.getTicketId());
                operateItemMapper.insert(operateItem);
            } );
        }

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("添加成功");
        return  resultEntity;
    }

    @Override
    public ResultEntity deleteOperateTicket(String ticketIds) {
        ResultEntity resultEntity = new ResultEntity();

        if (!StringUtils.isNoneBlank(ticketIds)) {
            resultEntity.setMsg("ids不能为空");
            return  resultEntity;
        }

        String[] ids = ticketIds.split(",");
        operateTicketMapper.batchDelete(ids);

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("操作成功");
        return resultEntity;
    }

    @Override
    public ResultEntity updateOperateTicket(OperateTicketVo operateTicketVo) {
        ResultEntity resultEntity = new ResultEntity();

        if (!StringUtils.isNoneBlank(operateTicketVo.getTicketId())) {
            resultEntity.setMsg("操作票id不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(operateTicketVo.getSerialNumber())) {
            resultEntity.setMsg("操作票号不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(operateTicketVo.getMaintainer())) {
            resultEntity.setMsg("维护人不能为空");
            return resultEntity;
        }
        if (operateTicketVo.getMaintainDate()==null) {
            resultEntity.setMsg("维护日期不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(operateTicketVo.getOperTicketTypeId())) {
            resultEntity.setMsg("操作票类型id不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(operateTicketVo.getSerialNumber())) {
            resultEntity.setMsg("操作票号不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(operateTicketVo.getCrewId())) {
            resultEntity.setMsg("风电场id不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(operateTicketVo.getCrewId())) {
            resultEntity.setMsg("机组id不能为空");
            return resultEntity;
        }
        if (operateTicketVo.getApplyTime()==null) {
            resultEntity.setMsg("申请时间不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(operateTicketVo.getSender())) {
            resultEntity.setMsg("发令人不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(operateTicketVo.getReceiver())) {
            resultEntity.setMsg("受令人不能为空");
            return resultEntity;
        }
        if (operateTicketVo.getSendTime()==null) {
            resultEntity.setMsg("发令时间不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(operateTicketVo.getWorkTeam())) {
            resultEntity.setMsg("工作班组不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(operateTicketVo.getExecuter())) {
            resultEntity.setMsg("操作人不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(operateTicketVo.getSupervisior())) {
            resultEntity.setMsg("监护人不能为空");
            return resultEntity;
        }
        if (operateTicketVo.getOperStartTime()==null) {
            resultEntity.setMsg("操作开始时间不能为空");
            return resultEntity;
        }
        if (operateTicketVo.getOperEndTime()==null) {
            resultEntity.setMsg("操作结束时间不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(operateTicketVo.getOperateContent())) {
            resultEntity.setMsg("操作内容不能为空");
            return resultEntity;
        }
        //修改操作票主数据
        OperateTicket operateTicket = new OperateTicket();
        BeanUtils.copyProperties(operateTicketVo,operateTicket);
        operateTicketMapper.updateByPrimaryKey(operateTicket);
        //修改操作项
        OperateItemExample operateItemExample = new OperateItemExample();
        operateItemExample.createCriteria().andTicketIdEqualTo(operateTicketVo.getTicketId());
        operateItemMapper.deleteByExample(operateItemExample);
        List<OperateItem> operateItemList = operateTicketVo.getOperateItemsList();
        if (operateItemList!=null &&operateItemList.size()!=0) {
            operateItemList.forEach(operateItem -> {
                operateItem.setItemId(UUID.randomUUID().toString().replace("-",""));
                operateItem.setTicketId(operateTicketVo.getTicketId());
                operateItemMapper.insert(operateItem);
            } );
        }

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("修改成功");
        return resultEntity;
    }

    @Override
    public ResultEntity getOperateTicketDetail(String ticketId) {
        ResultEntity resultEntity = new ResultEntity();

       if (!StringUtils.isNoneBlank(ticketId)) {
           resultEntity.setMsg("id不能为空");
           return resultEntity;
       }

        //查询操作主数据
        OperateTicketVo operateTicketVo = operateTicketMapper.getOperateTicketDetail(ticketId);
        if (operateTicketVo!=null) {
            //查询操作项
            OperateItemExample operateItemExample = new OperateItemExample();
            operateItemExample.createCriteria().andTicketIdEqualTo(operateTicketVo.getTicketId());
            List<OperateItem> operateItemList = operateItemMapper.selectByExample(operateItemExample);
            if (operateItemList!=null && operateItemList.size()!=0) {
                operateItemList.forEach(operateItem -> {
                    operateTicketVo.getOperateItemsList().add(operateItem);
                } );
            }
        }

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("查询成功");
        resultEntity.setData(operateTicketVo);
        return resultEntity;
    }

    @Override
    public PageResultEntity getOperateTicketList(Map<String,String> pageAndCondition) {
        PageResultEntity pageResultEntity = new PageResultEntity();
        pageResultEntity.setRows(new ArrayList());

        String start = String.valueOf((Integer.parseInt(pageAndCondition.get("pageNum"))-1)*(Integer.parseInt(pageAndCondition.get("pageSize"))));
        pageAndCondition.put("start",start);
        List<OperateTicketVo> operateTicketVoList = operateTicketMapper.getOperateTicketList(pageAndCondition);
        int total = operateTicketMapper.getTotal(pageAndCondition);

        pageResultEntity.setCode(ErrorCode.SUCCESS);
        pageResultEntity.setMsg("操作成功");
        pageResultEntity.setRows(operateTicketVoList);
        pageResultEntity.setTotal(total);
        return pageResultEntity;
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
