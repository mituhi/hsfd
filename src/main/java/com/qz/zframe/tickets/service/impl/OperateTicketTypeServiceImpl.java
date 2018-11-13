package com.qz.zframe.tickets.service.impl;

import com.qz.zframe.authentication.CurrentUserService;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.common.util.UUIdUtil;
import com.qz.zframe.tickets.entity.OperateTicketType;
import com.qz.zframe.tickets.entity.UserAssoInfo;
import com.qz.zframe.tickets.entity.UserAssoInfoExample;
import com.qz.zframe.tickets.mapper.OperateTicketTypeMapper;
import com.qz.zframe.tickets.mapper.UserAssoInfoMapper;
import com.qz.zframe.tickets.service.OperateTicketTypeService;
import com.qz.zframe.tickets.vo.OperateTicketTypeVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional(rollbackFor = Exception.class)
public class OperateTicketTypeServiceImpl implements OperateTicketTypeService {

    @Autowired
    private CurrentUserService currentUserService;

    @Autowired
    private OperateTicketTypeMapper operateTicketTypeMapper;

    @Autowired
    private UserAssoInfoMapper userAssoInfoMapper;

    @Override
    public ResultEntity addOperateTicketType(OperateTicketTypeVo operateTicketTypeVo) {
        ResultEntity resultEntity = new ResultEntity();

        if (!StringUtils.isNoneBlank(operateTicketTypeVo.getMaintainer())) {
            resultEntity.setMsg("维护人不能为空");
            return resultEntity;
        }
        if (operateTicketTypeVo.getMaintainDate()==null) {
            resultEntity.setMsg("维护日期不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(operateTicketTypeVo.getTicketTypeNumber())) {
            resultEntity.setMsg("操作票类型编码不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(operateTicketTypeVo.getWindId())) {
            resultEntity.setMsg("风电场id能为空");
            return resultEntity;
        }

        //添加主数据
        OperateTicketType operateTicketType = new OperateTicketType();
        BeanUtils.copyProperties(operateTicketTypeVo,operateTicketType);
        operateTicketType.setOperTicketTypeId(UUIdUtil.getUUID());
        operateTicketTypeMapper.insert(operateTicketType);
        //添加操作人
        List<UserAssoInfo> executerList = operateTicketTypeVo.getExecuterList();
        if (executerList!=null && executerList.size()!=0) {
            executerList.forEach(userAssoInfo -> {
                userAssoInfo.setAssoId(UUIdUtil.getUUID());
                userAssoInfo.setOperTicketTypeId(operateTicketType.getOperTicketTypeId());
                userAssoInfo.setUserType("01");
                userAssoInfoMapper.insert(userAssoInfo);
            });
        }
        //添加监护人
        List<UserAssoInfo> supervisiorList = operateTicketTypeVo.getSupervisiorList();
        if (supervisiorList!=null && supervisiorList.size()!=0) {
            supervisiorList.forEach(userAssoInfo -> {
                userAssoInfo.setAssoId(UUIdUtil.getUUID());
                userAssoInfo.setOperTicketTypeId(operateTicketType.getOperTicketTypeId());
                userAssoInfo.setUserType("02");
                userAssoInfoMapper.insert(userAssoInfo);
            });
        }

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("操作成功");
        return resultEntity;
    }

    @Override
    public ResultEntity deleteOperateTicketType(String ticketTypeIds) {
        ResultEntity resultEntity = new ResultEntity();

        if (!StringUtils.isNoneBlank(ticketTypeIds)) {
            resultEntity.setMsg("ids不能为空");
        }
        String[] ids = ticketTypeIds.split(",");

        operateTicketTypeMapper.batchDelete(ids);

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
        if (!StringUtils.isNoneBlank(operateTicketTypeVo.getMaintainer())) {
            resultEntity.setMsg("维护人不能为空");
            return resultEntity;
        }
        if (operateTicketTypeVo.getMaintainDate()==null) {
            resultEntity.setMsg("维护日期不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(operateTicketTypeVo.getTicketTypeNumber())) {
            resultEntity.setMsg("操作票类型编码不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(operateTicketTypeVo.getWindId())) {
            resultEntity.setMsg("风电场id能为空");
            return resultEntity;
        }

        //修改主数据
        OperateTicketType operateTicketType = new OperateTicketType();
        BeanUtils.copyProperties(operateTicketTypeVo,operateTicketType);
        operateTicketTypeMapper.updateByPrimaryKey(operateTicketType);
        //删除工作类型关联负责人,签收人,许可人
        UserAssoInfoExample userAssoInfoExample = new UserAssoInfoExample();
        userAssoInfoExample.createCriteria().andWorkTicketTypeIdEqualTo(operateTicketTypeVo.getOperTicketTypeId());
        userAssoInfoMapper.deleteByExample(userAssoInfoExample);
        //添加操作人
        List<UserAssoInfo> executerList = operateTicketTypeVo.getExecuterList();
        if (executerList!=null && executerList.size()!=0) {
            executerList.forEach(userAssoInfo -> {
                userAssoInfo.setAssoId(UUIdUtil.getUUID());
                userAssoInfo.setOperTicketTypeId(operateTicketTypeVo.getOperTicketTypeId());
                userAssoInfo.setUserType("01");
                userAssoInfoMapper.insert(userAssoInfo);
            });
        }
        //添加监护人
        List<UserAssoInfo> supervisiorList = operateTicketTypeVo.getSupervisiorList();
        if (supervisiorList!=null && supervisiorList.size()!=0) {
            supervisiorList.forEach(userAssoInfo -> {
                userAssoInfo.setAssoId(UUIdUtil.getUUID());
                userAssoInfo.setOperTicketTypeId(operateTicketTypeVo.getOperTicketTypeId());
                userAssoInfo.setUserType("02");
                userAssoInfoMapper.insert(userAssoInfo);
            });
        }

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("修改成功");
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
            UserAssoInfoExample userAssoInfoExample = new UserAssoInfoExample();
            userAssoInfoExample.setOrderByClause("user_numbet");
            UserAssoInfoExample.Criteria executerCriteria = userAssoInfoExample.createCriteria();
            executerCriteria.andOperTicketTypeIdEqualTo(operateTicketTypeVo.getOperTicketTypeId());
            executerCriteria.andUserTypeEqualTo("01");
            List<UserAssoInfo> executerList = userAssoInfoMapper.selectByExample(userAssoInfoExample);
            if (executerList!=null && executerList.size()!=0) {
                executerList.forEach(userAssoInfo -> {
                    operateTicketTypeVo.getExecuterList().add(userAssoInfo);
                });
            }
            //获取签收人
            UserAssoInfoExample.Criteria supervisiorCriteria = userAssoInfoExample.createCriteria();
            userAssoInfoExample.setOrderByClause("user_numbet");
            supervisiorCriteria.andOperTicketTypeIdEqualTo(operateTicketTypeVo.getOperTicketTypeId());
            supervisiorCriteria.andUserTypeEqualTo("02");
            List<UserAssoInfo> signerList = userAssoInfoMapper.selectByExample(userAssoInfoExample);
            if (signerList!=null && signerList.size()!=0) {
                signerList.forEach(userAssoInfo -> {
                    operateTicketTypeVo.getSupervisiorList().add(userAssoInfo);
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
        int total = operateTicketTypeMapper.getTotal();

        pageResultEntity.setCode(ErrorCode.SUCCESS);
        pageResultEntity.setMsg("操作成功");
        pageResultEntity.setRows(operateTicketTypeVoList);
        pageResultEntity.setTotal(total);
        return pageResultEntity;
    }
}
