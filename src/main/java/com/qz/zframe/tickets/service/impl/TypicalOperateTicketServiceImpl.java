package com.qz.zframe.tickets.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.qz.zframe.authentication.CurrentUserService;
import com.qz.zframe.common.service.CommonService;
import com.qz.zframe.common.service.RoleService;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.common.util.UUIdUtil;
import com.qz.zframe.tickets.entity.*;
import com.qz.zframe.tickets.mapper.OperateItemMapper;
import com.qz.zframe.tickets.mapper.OperateTicketMapper;
import com.qz.zframe.tickets.mapper.OperateTicketTypeMapper;
import com.qz.zframe.tickets.mapper.TypicalOperateTicketMapper;
import com.qz.zframe.tickets.service.OperateTicketTypeService;
import com.qz.zframe.tickets.service.TypicalOperateTicketService;
import com.qz.zframe.tickets.vo.TypicalOperateTicketVo;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
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
    private TypicalOperateTicketMapper typicalOperateTicketMapper;

    @Autowired
    private OperateItemMapper operateItemMapper;

    @Autowired
    private OperateTicketMapper operateTicketMapper;

    @Autowired
    private OperateTicketTypeMapper operateTicketTypeMapper;

    @Autowired
    private CurrentUserService currentUserService;

    @Autowired
    private CommonService commonService;

    @Override
    public ResultEntity addTypicalOperateTicket(TypicalOperateTicketVo typicalOperateTicketVo) {
        ResultEntity resultEntity = new ResultEntity();

        if (!StringUtils.isNoneBlank(typicalOperateTicketVo.getOperTicketTypeId())) {
            resultEntity.setMsg("操作票类型id不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(typicalOperateTicketVo.getPositionId())) {
            resultEntity.setMsg("位置id不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(typicalOperateTicketVo.getWindId())) {
            resultEntity.setMsg("风电场编码不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(typicalOperateTicketVo.getStatus())) {
            resultEntity.setMsg("状态不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(typicalOperateTicketVo.getWorkTeam())) {
            resultEntity.setMsg("工作班组id不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(typicalOperateTicketVo.getOperateContent())) {
            resultEntity.setMsg("操作内容不能为空");
            return resultEntity;
        }
        //设置id
        typicalOperateTicketVo.setTypicalTicketId(UUIdUtil.getUUID());
        //设置流水号
        String prefix = "";
        String ticketTypeName = operateTicketTypeMapper.getNameById(typicalOperateTicketVo.getOperTicketTypeId());
        if (StringUtils.isNoneBlank(ticketTypeName)) {
            if (ticketTypeName.contains("倒闸")) {
                prefix = "DXDZ";
            }else {
                prefix = "DXQT";
            }
        }
        String tail = String.valueOf(1000+typicalOperateTicketMapper.countByExample(new TypicalOperateTicketExample())+1);
        tail = tail.substring(1);
        typicalOperateTicketVo.setSerialNumber(prefix+tail);
        //添加维护人维护日期
        this.setMaintainAndMaintainDate(typicalOperateTicketVo);
        //修改时间
        typicalOperateTicketVo.setUpdateTime(new Date());
        //插入数据库
        typicalOperateTicketMapper.insertSelective(typicalOperateTicketVo);
        //添加操作项
        this.insertTab(typicalOperateTicketVo);

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("添加成功");
        return resultEntity;
    }

    @Override
    public ResultEntity updateTypicalOperateTicket(TypicalOperateTicketVo typicalOperateTicketVo) {
        ResultEntity resultEntity = new ResultEntity();

        if (!StringUtils.isNoneBlank(typicalOperateTicketVo.getTypicalTicketId())) {
            resultEntity.setMsg("典型操作票id不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(typicalOperateTicketVo.getOperTicketTypeId())) {
            resultEntity.setMsg("操作票类型不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(typicalOperateTicketVo.getStatus())) {
            resultEntity.setMsg("状态不能为空");
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
        TypicalOperateTicket typicalOperateTicket = typicalOperateTicketMapper.selectByPrimaryKey(typicalOperateTicketVo.getTypicalTicketId());
        BeanUtil.copyProperties(typicalOperateTicketVo,typicalOperateTicket,true, CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true));
        typicalOperateTicket.setUpdateTime(new Date());
        typicalOperateTicketMapper.updateByPrimaryKeySelective(typicalOperateTicket);
        //修改操作项
        this.updateTab(typicalOperateTicketVo);

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("修改成功");
        return resultEntity;
    }

    @Override
    public ResultEntity deleteTypicalOperateTicket(String[] typicalTicketIds) {
        ResultEntity resultEntity = new ResultEntity();

        if (!(typicalTicketIds!=null && typicalTicketIds.length!=0)) {
            resultEntity.setMsg("ids不能为空");
            return resultEntity;
        }
        /*for (String typicalTicketId:typicalTicketIds) {
            //如果该类型正在被使用,不能删除
            OperateTicketExample operateTicketExample = new OperateTicketExample();
            operateTicketExample.createCriteria().andTypicalTicketIdEqualTo(typicalTicketId).andStatusEqualTo("01");
            List<OperateTicket> operateTickets = operateTicketMapper.selectByExample(operateTicketExample);
            if (CollectionUtils.isNotEmpty(operateTickets)) {
                resultEntity.setMsg("选中的类型正在被使用,无法删除");
                return resultEntity;
            }
        }*/
        //删除典型操作票
        typicalOperateTicketMapper.batchDelete(typicalTicketIds);
        //删除操作项
        this.deleteTab(typicalTicketIds);

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("删除成功");
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
            typicalOperateTicketVo.setStatusName(this.getStatusName(typicalOperateTicketVo.getStatus()));
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
        if (CollectionUtils.isNotEmpty(typicalOperateTicketVoList)) {
            typicalOperateTicketVoList.forEach(typicalOperateTicketVo -> {
                typicalOperateTicketVo.setStatusName(this.getStatusName(typicalOperateTicketVo.getStatus()));
            });
        }
        int total = typicalOperateTicketMapper.getTotal(pageAndCondition);

        pageResultEntity.setCode(ErrorCode.SUCCESS);
        pageResultEntity.setMsg("操作成功");
        pageResultEntity.setRows(typicalOperateTicketVoList);
        pageResultEntity.setTotal(total);
        return pageResultEntity;
    }

    @Override
    public ResultEntity getEnableTypicalOperateTicketList() {
        ResultEntity resultEntity = new ResultEntity();

        TypicalOperateTicketExample typicalOperateTicketExample = new TypicalOperateTicketExample();
        typicalOperateTicketExample.createCriteria().andStatusEqualTo("01");
        List<TypicalOperateTicket> typicalOperateTicketList = typicalOperateTicketMapper.selectByExample(typicalOperateTicketExample);

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("查询成功");
        resultEntity.setData(typicalOperateTicketList);
        return resultEntity;
    }

    @Override
    public ResultEntity createOperateTicket(TypicalOperateTicketVo typicalOperateTicketVo) {
        ResultEntity resultEntity = new ResultEntity();

        String typicalTicketId = typicalOperateTicketVo.getTypicalTicketId();
        if (!StringUtils.isNoneBlank(typicalTicketId)) {
            resultEntity.setMsg("典型操作票id不能为空");
            return resultEntity;
        }

        //判断该典型操作票是否被停用
        TypicalOperateTicket typicalOperateTicket = typicalOperateTicketMapper.selectByPrimaryKey(typicalTicketId);
        if (typicalOperateTicket!=null) {
            if ("02".equals(typicalOperateTicket.getStatus())) {
                resultEntity.setMsg("该典型操作票已被停用,无法生成工作票");
                return resultEntity;
            }
            //创建操作票对象
            OperateTicket operateTicket = new OperateTicket();
            //设置id
            operateTicket.setTicketId(UUIdUtil.getUUID());
            //设置状态为未提交
            operateTicket.setStatus("01");
            //添加维护人
            operateTicket.setMaintainer(currentUserService.getId());
            //添加维护日期
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                operateTicket.setMaintainDate(simpleDateFormat.parse(simpleDateFormat.format(new Date())));
            }catch (ParseException e) {
                e.printStackTrace();
            }
            operateTicket.setOperTicketTypeId(typicalOperateTicket.getOperTicketTypeId());
            operateTicket.setTypicalTicketId(typicalOperateTicket.getTypicalTicketId());
            try {
                operateTicket.setMaintainer(commonService.findCommonMsg().getUserId());
                operateTicket.setMaintainDate(commonService.findCommonMsg().getTimeForDay());
            }catch (Exception e) {
                e.printStackTrace();
            }
            operateTicket.setWindId(typicalOperateTicket.getWindId());
            operateTicket.setWorkTeam(typicalOperateTicket.getWorkTeam());
            if (typicalOperateTicket.getPositionId()!=null) {
                operateTicket.setPositionId(typicalOperateTicket.getPositionId());
            }
            if (typicalOperateTicket.getEquipmentId()!=null) {
                operateTicket.setEquipmentId(typicalOperateTicket.getEquipmentId());
            }
            operateTicket.setOperateContent(typicalOperateTicket.getOperateContent());
            operateTicketMapper.insert(operateTicket);
            //设置操作项
            OperateItemExample operateItemExample = new OperateItemExample();
            operateItemExample.createCriteria().andTypicalTicketIdEqualTo(typicalTicketId);
            List<OperateItem> typicalOperateItemList = operateItemMapper.selectByExample(operateItemExample);
            if (CollectionUtils.isNotEmpty(typicalOperateItemList)) {
                typicalOperateItemList.forEach(typicalOperateItem -> {
                    OperateItem operateItem = new OperateItem();
                    operateItem.setItemId(UUIdUtil.getUUID());
                    operateItem.setTicketId(operateTicket.getTicketId());
                    operateItem.setItemNumber(typicalOperateItem.getItemNumber());
                    operateItem.setItemContent(typicalOperateItem.getItemContent());
                    operateItemMapper.insert(operateItem);
                });
            }
            resultEntity.setData(operateTicket.getTicketId());
        }

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("生成成功");
        return resultEntity;
    }

    private String getStatusName(String statsu) {
        if ("01".equals(statsu)) {
            return "启用";
        }
        if ("02".equals(statsu)) {
            return "停用";
        }
        return null;
    }

    private void setMaintainAndMaintainDate(TypicalOperateTicketVo typicalOperateTicketVo) {
        //添加维护人
        typicalOperateTicketVo.setMaintainer(currentUserService.getId());
        //添加维护日期
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            typicalOperateTicketVo.setMaintainDate(simpleDateFormat.parse(simpleDateFormat.format(new Date())));
        }catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private void insertTab(TypicalOperateTicketVo typicalOperateTicketVo) {
        List<OperateItem> operateItemList = typicalOperateTicketVo.getOperateItemList();
        if (CollectionUtils.isNotEmpty(operateItemList)) {
            int i = 1;
            for (OperateItem operateItem:operateItemList) {
                operateItem.setItemId(UUIdUtil.getUUID());
                operateItem.setItemNumber(i++);
                operateItem.setTypicalTicketId(typicalOperateTicketVo.getTypicalTicketId());
                operateItemMapper.insert(operateItem);
            }
        }
    }

    private void updateTab(TypicalOperateTicketVo typicalOperateTicketVo) {
        //删除原来的操作项
        OperateItemExample operateItemExample = new OperateItemExample();
        operateItemExample.createCriteria().andTypicalTicketIdEqualTo(typicalOperateTicketVo.getTypicalTicketId());
        operateItemMapper.deleteByExample(operateItemExample);

        this.insertTab(typicalOperateTicketVo);
    }

    private void deleteTab(String[] typicalTicketIds) {
        //删除操作项
        operateItemMapper.batchDeleteByTypicalTicketIds(typicalTicketIds);
    }
}
