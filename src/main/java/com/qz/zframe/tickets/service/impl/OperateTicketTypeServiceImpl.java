package com.qz.zframe.tickets.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.qz.zframe.authentication.CurrentUserService;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.common.util.UUIdUtil;
import com.qz.zframe.tickets.entity.*;
import com.qz.zframe.tickets.mapper.OperateTicketMapper;
import com.qz.zframe.tickets.mapper.OperateTicketTypeMapper;
import com.qz.zframe.tickets.mapper.UserAssoInfoMapper;
import com.qz.zframe.tickets.service.OperateTicketTypeService;
import com.qz.zframe.tickets.vo.OperateTicketTypeVo;
import com.qz.zframe.tickets.vo.UserAssoVo;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
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
public class OperateTicketTypeServiceImpl implements OperateTicketTypeService {

    @Autowired
    private OperateTicketTypeMapper operateTicketTypeMapper;

    @Autowired
    private UserAssoInfoMapper userAssoInfoMapper;

    @Autowired
    private OperateTicketMapper operateTicketMapper;

    @Autowired
    private CurrentUserService currentUserService;

    @Override
    public ResultEntity addOperateTicketType(OperateTicketTypeVo operateTicketTypeVo) {
        ResultEntity resultEntity = new ResultEntity();

        if (!StringUtils.isNotBlank(operateTicketTypeVo.getTicketTypeNumber())) {
            resultEntity.setMsg("操作票类型编码不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNotBlank(operateTicketTypeVo.getWindId())) {
            resultEntity.setMsg("风电场不能为空");
            return resultEntity;
        }

        OperateTicketTypeExample operateTicketTypeExample = new OperateTicketTypeExample();
        operateTicketTypeExample.createCriteria().andTicketTypeNumberEqualTo(operateTicketTypeVo.getTicketTypeNumber());
        List<OperateTicketType> operateTicketTypeList = operateTicketTypeMapper.selectByExample(operateTicketTypeExample);
        if (CollectionUtils.isNotEmpty(operateTicketTypeList)) {
            resultEntity.setMsg("操作票类型编码已存在,请重新编写");
            return resultEntity;
        }
        //设置id
        operateTicketTypeVo.setOperTicketTypeId(UUIdUtil.getUUID());
        //设置创建时间
        operateTicketTypeVo.setCreateTime(new Date());
        //添加维护人维护日期
        this.setMaintainAndMaintainDate(operateTicketTypeVo);
        //插入数据库
        operateTicketTypeMapper.insertSelective(operateTicketTypeVo);
        //添加操作人等tab页
        this.insertTab(operateTicketTypeVo);

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("操作成功");
        return resultEntity;
    }

    @Override
    public ResultEntity updateOperateTicketType(OperateTicketTypeVo operateTicketTypeVo) {
        ResultEntity resultEntity = new ResultEntity();

        if (!StringUtils.isNoneBlank(operateTicketTypeVo.getOperTicketTypeId())) {
            resultEntity.setMsg("操作票类型id不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(operateTicketTypeVo.getTicketTypeNumber())) {
            resultEntity.setMsg("操作票类型编码不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(operateTicketTypeVo.getMaintainer())) {
            resultEntity.setMsg("维护人不能为空");
            return resultEntity;
        }
        if (operateTicketTypeVo.getMaintainDate()==null) {
            resultEntity.setMsg("维护日期不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(operateTicketTypeVo.getWindId())) {
            resultEntity.setMsg("风电场编码能为空");
            return resultEntity;
        }

        OperateTicketTypeExample operateTicketTypeExample = new OperateTicketTypeExample();
        operateTicketTypeExample.createCriteria().andTicketTypeNumberEqualTo(operateTicketTypeVo.getTicketTypeNumber()).andOperTicketTypeIdNotEqualTo(operateTicketTypeVo.getOperTicketTypeId());
        List<OperateTicketType> operateTicketTypeList = operateTicketTypeMapper.selectByExample(operateTicketTypeExample);
        if (CollectionUtils.isNotEmpty(operateTicketTypeList)) {
            resultEntity.setMsg("操作票类型编码已存在,请重新编写");
            return resultEntity;
        }

        //修改主数据
        OperateTicketType operateTicketType = operateTicketTypeMapper.selectByPrimaryKey(operateTicketTypeVo.getOperTicketTypeId());
        BeanUtil.copyProperties(operateTicketTypeVo,operateTicketType,true, CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true));
        operateTicketTypeMapper.updateByPrimaryKeySelective(operateTicketType);

        //添加操纵人等tab页
        this.updateTab(operateTicketTypeVo);

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("修改成功");
        return resultEntity;
    }

    @Override
    public ResultEntity deleteOperateTicketType(String[] operTicketTypeIds) {
        ResultEntity resultEntity = new ResultEntity();

        if (!ArrayUtils.isNotEmpty(operTicketTypeIds)) {
            resultEntity.setMsg("ids不能为空");
            return resultEntity;
        }
        for (String operTicketTypeId:operTicketTypeIds) {
            //如果该类型正在被使用,不能删除
            OperateTicketExample operateTicketExample = new OperateTicketExample();
            operateTicketExample.createCriteria().andOperTicketTypeIdEqualTo(operTicketTypeId).andStatusEqualTo("01");
            List<OperateTicket> operateTickets = operateTicketMapper.selectByExample(operateTicketExample);
            if (CollectionUtils.isNotEmpty(operateTickets)) {
                resultEntity.setMsg("选中的类型正在被使用,无法删除");
                return resultEntity;
            }
        }
        //删除操作票类型
        operateTicketTypeMapper.batchDelete(operTicketTypeIds);
        //删除关联人员
        this.deleteTab(operTicketTypeIds);


        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("删除成功");
        return resultEntity;
    }

    @Override
    public ResultEntity getOperateTicketTypeDetail(String ticketTypeId) {
        ResultEntity resultEntity = new ResultEntity();

        if (!StringUtils.isNoneBlank(ticketTypeId)) {
            resultEntity.setMsg("id不能为空");
            return resultEntity;
        }

        OperateTicketTypeVo operateTicketTypeVo = operateTicketTypeMapper.getOperateTicketTypeDetail(ticketTypeId);
        if (operateTicketTypeVo!=null) {
            //获取操作人
            List<UserAssoVo> executerList = userAssoInfoMapper.
                    getUserAssoVoListByOperTicketType(operateTicketTypeVo.getOperTicketTypeId(), "01");
            if (CollectionUtils.isNotEmpty(executerList)) {
                executerList.forEach(userAssoVo -> {
                    operateTicketTypeVo.getExecuterList().add(userAssoVo);
                });
            }
            //获取签收人
            List<UserAssoVo> supervisiorList = userAssoInfoMapper.
                    getUserAssoVoListByOperTicketType(operateTicketTypeVo.getOperTicketTypeId(), "02");
            if (CollectionUtils.isNotEmpty(supervisiorList)) {
                supervisiorList.forEach(userAssoVo -> {
                    operateTicketTypeVo.getSupervisiorList().add(userAssoVo);
                });
            }
        }

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("查询成功");
        resultEntity.setData(operateTicketTypeVo);
        return resultEntity;
    }

    @Override
    public PageResultEntity getOperateTicketTypeList(Map<String,String> pageAndCondition) {
        PageResultEntity pageResultEntity = new PageResultEntity();
        pageResultEntity.setRows(new ArrayList());

        String start = String.valueOf((Integer.parseInt(pageAndCondition.get("pageNum"))-1)*(Integer.parseInt(pageAndCondition.get("pageSize"))));
        pageAndCondition.put("start",start);
        List<OperateTicketTypeVo> operateTicketTypeVoList = operateTicketTypeMapper.getOperateTicketTypeList(pageAndCondition);
        int total = operateTicketTypeMapper.getTotal(pageAndCondition);

        pageResultEntity.setCode(ErrorCode.SUCCESS);
        pageResultEntity.setMsg("操作成功");
        pageResultEntity.setRows(operateTicketTypeVoList);
        pageResultEntity.setTotal(total);
        return pageResultEntity;
    }

    @Override
    public ResultEntity getAllperateTicketType() {
        ResultEntity resultEntity = new ResultEntity();

        List<OperateTicketType> operateTicketTypeList = operateTicketTypeMapper.selectByExample(new OperateTicketTypeExample());

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("查询成功");
        resultEntity.setData(operateTicketTypeList);
        return resultEntity;
    }

    @Override
    public ResultEntity getExecuterList(String ticketTypeId) {
        ResultEntity resultEntity = new ResultEntity();
        //获取操作人
        UserAssoInfoExample userAssoInfoExample = new UserAssoInfoExample();
        userAssoInfoExample.setOrderByClause("user_numbet");
        UserAssoInfoExample.Criteria executerCriteria = userAssoInfoExample.createCriteria();
        executerCriteria.andOperTicketTypeIdEqualTo(ticketTypeId);
        executerCriteria.andUserTypeEqualTo("01");
        List<UserAssoInfo> executerList = userAssoInfoMapper.selectByExample(userAssoInfoExample);

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("查询成功");
        resultEntity.setData(executerList);
        return resultEntity;
    }

    @Override
    public ResultEntity getSupervisiorList(String ticketTypeId) {
        ResultEntity resultEntity = new ResultEntity();

        //获取签收人
        UserAssoInfoExample userAssoInfoExample = new UserAssoInfoExample();
        UserAssoInfoExample.Criteria supervisiorCriteria = userAssoInfoExample.createCriteria();
        userAssoInfoExample.setOrderByClause("user_numbet");
        supervisiorCriteria.andOperTicketTypeIdEqualTo(ticketTypeId);
        supervisiorCriteria.andUserTypeEqualTo("02");
        List<UserAssoInfo> signerList = userAssoInfoMapper.selectByExample(userAssoInfoExample);

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("查询成功");
        resultEntity.setData(signerList);
        return resultEntity;
    }

    private void insertTab(OperateTicketTypeVo operateTicketTypeVo) {
        //添加操作人
        List<UserAssoVo> executerList = operateTicketTypeVo.getExecuterList();
        if (executerList!=null && executerList.size()!=0) {
            int i = 1;
            for (UserAssoVo userAssoInfo:executerList) {
                userAssoInfo.setUserNumbet(String.valueOf(i++));
                userAssoInfo.setAssoId(UUIdUtil.getUUID());
                userAssoInfo.setOperTicketTypeId(operateTicketTypeVo.getOperTicketTypeId());
                userAssoInfo.setUserType("01");
                userAssoInfoMapper.insert(userAssoInfo);
            }
        }
        //添加监护人
        List<UserAssoVo> supervisiorList = operateTicketTypeVo.getSupervisiorList();
        if (supervisiorList!=null && supervisiorList.size()!=0) {
            int i = 1;
            for (UserAssoInfo userAssoInfo:supervisiorList) {
                userAssoInfo.setUserNumbet(String.valueOf(i++));
                userAssoInfo.setAssoId(UUIdUtil.getUUID());
                userAssoInfo.setOperTicketTypeId(operateTicketTypeVo.getOperTicketTypeId());
                userAssoInfo.setUserType("02");
                userAssoInfoMapper.insert(userAssoInfo);
            }
        }
    }

    private void updateTab(OperateTicketTypeVo operateTicketTypeVo) {
        //删除工作类型关联负责人,签收人,许可人
        UserAssoInfoExample userAssoInfoExample = new UserAssoInfoExample();
        userAssoInfoExample.createCriteria().andWorkTicketTypeIdEqualTo(operateTicketTypeVo.getOperTicketTypeId());
        userAssoInfoMapper.deleteByExample(userAssoInfoExample);

        //重新添加
        this.insertTab(operateTicketTypeVo);
    }

    private void deleteTab(String[] operTicketTypeIds) {
        userAssoInfoMapper.batchDelete2(operTicketTypeIds);
    }

    private void setMaintainAndMaintainDate(OperateTicketTypeVo operateTicketTypeVo) {
        //添加维护人
        if (!StringUtils.isNoneBlank(operateTicketTypeVo.getMaintainer())) {
            operateTicketTypeVo.setMaintainer(currentUserService.getId());
        }
        //添加维护日期
        if (operateTicketTypeVo.getMaintainDate()==null) {
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                operateTicketTypeVo.setMaintainDate(simpleDateFormat.parse(simpleDateFormat.format(new Date())));
            }catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }
}
