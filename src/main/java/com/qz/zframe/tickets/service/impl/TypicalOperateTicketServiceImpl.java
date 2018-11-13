package com.qz.zframe.tickets.service.impl;

import com.qz.zframe.authentication.CurrentUserService;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.common.util.UUIdUtil;
import com.qz.zframe.tickets.entity.*;
import com.qz.zframe.tickets.mapper.OperateItemMapper;
import com.qz.zframe.tickets.mapper.OperateTicketTypeMapper;
import com.qz.zframe.tickets.mapper.TypicalOperateTicketMapper;
import com.qz.zframe.tickets.service.TypicalOperateTicketService;
import com.qz.zframe.tickets.vo.TypicalOperateTicketVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
@Transactional(rollbackFor = Exception.class)
public class TypicalOperateTicketServiceImpl implements TypicalOperateTicketService {

    @Autowired
    private CurrentUserService currentUserService;

    @Autowired
    private TypicalOperateTicketMapper typicalOperateTicketMapper;

    @Autowired
    private OperateItemMapper operateItemMapper;

    @Autowired
    private OperateTicketTypeMapper operateTicketTypeMapper;

    @Override
    public ResultEntity addTypicalOperateTicket(TypicalOperateTicketVo typicalOperateTicketVo) {
        ResultEntity resultEntity = new ResultEntity();

        if (!StringUtils.isNoneBlank(typicalOperateTicketVo.getMaintainer())) {
            resultEntity.setMsg("维护人不能为空");
            return resultEntity;
        }
        if (typicalOperateTicketVo.getMaintainDate()==null) {
            resultEntity.setMsg("维护日期不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(typicalOperateTicketVo.getSerialNumber())) {
            resultEntity.setMsg("操作票号不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(typicalOperateTicketVo.getOperTicketTypeId())) {
            resultEntity.setMsg("操作票类型不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(typicalOperateTicketVo.getMaintainer())) {
            resultEntity.setMsg("维护人不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(typicalOperateTicketVo.getWindId())) {
            resultEntity.setMsg("风电成id不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(typicalOperateTicketVo.getWorkTeam())) {
            resultEntity.setMsg("工作班组不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(typicalOperateTicketVo.getOperateContent())) {
            resultEntity.setMsg("操作内容不能为空");
            return resultEntity;
        }
        //添加典型操作票主数据
        TypicalOperateTicket typicalOperateTicket = new TypicalOperateTicket();
        BeanUtils.copyProperties(typicalOperateTicketVo,typicalOperateTicket);
        typicalOperateTicket.setTypicalTicketId(UUIdUtil.getUUID());
        typicalOperateTicket.setSerialNumber(String.valueOf(typicalOperateTicketMapper.countByExample(new TypicalOperateTicketExample())+1));
        typicalOperateTicketMapper.insert(typicalOperateTicket);
        //添加操作项
        List<OperateItem> operateItemList = typicalOperateTicketVo.getOperateItemList();
        if (operateItemList!=null && operateItemList.size()!=0) {
            operateItemList.forEach(operateItem -> {
                operateItem.setItemId(UUIdUtil.getUUID());
                operateItem.setTypicalTicketId(typicalOperateTicket.getTypicalTicketId());
                operateItemMapper.insert(operateItem);
            });
        }
        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("添加成功");
        return resultEntity;
    }

    @Override
    public ResultEntity deleteTypicalOperateTicket(String typicalTicketIds) {
        ResultEntity resultEntity = new ResultEntity();

        if (!StringUtils.isNoneBlank(typicalTicketIds)) {
            resultEntity.setMsg("ids不能为空");
            return resultEntity;
        }

        String[] ids = typicalTicketIds.split(",");
        typicalOperateTicketMapper.batchDelete(ids);

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("操作成功");
        return resultEntity;
    }

    @Override
    public ResultEntity updateTypicalOperateTicket(TypicalOperateTicketVo typicalOperateTicketVo) {
        ResultEntity resultEntity = new ResultEntity();

        if (!StringUtils.isNoneBlank(typicalOperateTicketVo.getTypicalTicketId())) {
            resultEntity.setMsg("典型操作票id不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(typicalOperateTicketVo.getSerialNumber())) {
            resultEntity.setMsg("典型操作票号不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(typicalOperateTicketVo.getMaintainer())) {
            resultEntity.setMsg("维护人不能为空");
            return resultEntity;
        }
        if (typicalOperateTicketVo.getMaintainDate()==null) {
            resultEntity.setMsg("维护日期不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(typicalOperateTicketVo.getSerialNumber())) {
            resultEntity.setMsg("操作票号不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(typicalOperateTicketVo.getOperTicketTypeId())) {
            resultEntity.setMsg("操作票类型不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(typicalOperateTicketVo.getMaintainer())) {
            resultEntity.setMsg("维护人不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(typicalOperateTicketVo.getWindId())) {
            resultEntity.setMsg("风电成id不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(typicalOperateTicketVo.getWorkTeam())) {
            resultEntity.setMsg("工作班组不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(typicalOperateTicketVo.getOperateContent())) {
            resultEntity.setMsg("操作内容不能为空");
            return resultEntity;
        }
        //修改典型操作票主数据
        TypicalOperateTicket typicalOperateTicket = new TypicalOperateTicket();
        BeanUtils.copyProperties(typicalOperateTicketVo,typicalOperateTicket);
        typicalOperateTicketMapper.updateByPrimaryKey(typicalOperateTicket);
        //修改操作项
        OperateItemExample operateItemExample = new OperateItemExample();
        operateItemExample.createCriteria().andTypicalTicketIdEqualTo(typicalOperateTicketVo.getTypicalTicketId());
        operateItemMapper.deleteByExample(operateItemExample);
        List<OperateItem> operateItemList = typicalOperateTicketVo.getOperateItemList();
        if (operateItemList!=null && operateItemList.size()!=0) {
            operateItemList.forEach(operateItem -> {
                operateItem.setItemId(UUIdUtil.getUUID());
                operateItem.setTypicalTicketId(typicalOperateTicketVo.getTypicalTicketId());
                operateItemMapper.insert(operateItem);
            });
        }

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("修改成功");
        return resultEntity;
    }

    @Override
    public ResultEntity getTypicalOperateTicketDetail(String typicalTicketId) {
        ResultEntity resultEntity = new ResultEntity();

        if (!StringUtils.isNoneBlank(typicalTicketId)) {
            resultEntity.setMsg("id不能为空");
            return resultEntity;
        }

        //获取主数据
        TypicalOperateTicketVo typicalOperateTicketVo = typicalOperateTicketMapper.getTypicalOperateTicketDetail(typicalTicketId);
        if (typicalOperateTicketVo!=null) {
            //获取操作项
            OperateItemExample operateItemExample = new OperateItemExample();
            operateItemExample.setOrderByClause("item_number");
            operateItemExample.createCriteria().andTypicalTicketIdEqualTo(typicalOperateTicketVo.getTypicalTicketId());
            List<OperateItem> operateItemList = operateItemMapper.selectByExample(operateItemExample);
            if (operateItemList!=null && operateItemList.size()!=0) {
                operateItemList.forEach(operateItem -> {
                    typicalOperateTicketVo.getOperateItemList().add(operateItem);
                });
            }
        }

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("查询成功");
        resultEntity.setData(typicalOperateTicketVo);
        return resultEntity;
    }

    @Override
    public PageResultEntity getTypicalOperateTicketList(Map<String,String> pageAndCondition) {
        PageResultEntity pageResultEntity = new PageResultEntity();
        pageResultEntity.setRows(new ArrayList());

        String start = String.valueOf((Integer.parseInt(pageAndCondition.get("pageNum"))-1)*(Integer.parseInt(pageAndCondition.get("pageSize"))));
        pageAndCondition.put("start",start);
        List<TypicalOperateTicketVo> typicalOperateTicketVoList = typicalOperateTicketMapper.getTypicalOperateTicketList(pageAndCondition);
        int total = typicalOperateTicketMapper.getTotal(pageAndCondition);

        pageResultEntity.setCode(ErrorCode.SUCCESS);
        pageResultEntity.setMsg("操作成功");
        pageResultEntity.setRows(typicalOperateTicketVoList);
        pageResultEntity.setTotal(total);
        return pageResultEntity;
    }

}
