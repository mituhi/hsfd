package com.qz.zframe.tickets.service.impl;

import com.qz.zframe.authentication.CurrentUserService;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.common.util.UUIdUtil;
import com.qz.zframe.tickets.entity.*;
import com.qz.zframe.tickets.mapper.UserAssoInfoMapper;
import com.qz.zframe.tickets.mapper.WorkTicketSafeMeasureMapper;
import com.qz.zframe.tickets.mapper.WorkTicketTypeMapper;
import com.qz.zframe.tickets.service.WorkTicketTypeService;
import com.qz.zframe.tickets.vo.WorkTicketTypeVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Transactional(rollbackFor = Exception.class)
public class WorkTicketTypeServiceImpl implements WorkTicketTypeService {

    @Autowired
    private CurrentUserService currentUserService;

    @Autowired
    private WorkTicketTypeMapper workTicketTypeMapper;

    @Autowired
    private UserAssoInfoMapper userAssoInfoMapper;

    @Autowired
    private WorkTicketSafeMeasureMapper workTicketSafeMeasureMapper;

    @Override
    public ResultEntity addWorkTicketType(WorkTicketTypeVo workTicketTypeVo) {
        ResultEntity resultEntity = new ResultEntity();

        if (!StringUtils.isNoneBlank(workTicketTypeVo.getMaintainer())) {
            resultEntity.setMsg("维护人不能为空");
            return resultEntity;
        }
        if (workTicketTypeVo.getMaintainDate()==null) {
            resultEntity.setMsg("维护日期不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(workTicketTypeVo.getTicketTypeNumber())) {
            resultEntity.setMsg("工作票类型编码不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(workTicketTypeVo.getWindId())) {
            resultEntity.setMsg("风电场不能为空");
            return resultEntity;
        }
        WorkTicketTypeExample workTicketTypeExample = new WorkTicketTypeExample();
        workTicketTypeExample.createCriteria().andTicketTypeNumberEqualTo(workTicketTypeVo.getTicketTypeNumber());
        List<WorkTicketType> workTicketTypeList = workTicketTypeMapper.selectByExample(workTicketTypeExample);
        if (workTicketTypeList!=null && workTicketTypeList.size()!=0) {
            resultEntity.setMsg("工作票类型编码已存在,请重新编写");
            return resultEntity;
        }
        //添加工作票类型主数据
        WorkTicketType workTicketType = new WorkTicketType();
        BeanUtils.copyProperties(workTicketTypeVo,workTicketType);
        workTicketType.setWorkTicketTypeId(UUIdUtil.getUUID());
        workTicketTypeMapper.insert(workTicketType);
        //添加安全措施
        List<WorkTicketSafeMeasure> safeMeasureList = workTicketTypeVo.getSafeMeasureList();
        if (safeMeasureList!=null && safeMeasureList.size()!=0) {
            safeMeasureList.forEach(WorkTicketSafeMeasure -> {
                WorkTicketSafeMeasure.setSafeId(UUIdUtil.getUUID());
                WorkTicketSafeMeasure.setTicketTypeId(workTicketType.getWorkTicketTypeId());
                workTicketSafeMeasureMapper.insert(WorkTicketSafeMeasure);
            });
        }
        //添加工作负责人
        List<UserAssoInfo> workHeadList = workTicketTypeVo.getWorkHeadList();
        if (workHeadList!=null && workHeadList.size()!=0) {
            workHeadList.forEach(userAssoInfo -> {
                userAssoInfo.setAssoId(UUIdUtil.getUUID());
                userAssoInfo.setWorkTicketTypeId(workTicketType.getWorkTicketTypeId());
                userAssoInfo.setUserType("01");
                userAssoInfoMapper.insert(userAssoInfo);
            });
        }
        //添加签发人
        List<UserAssoInfo> signerList = workTicketTypeVo.getSignerList();
        if (signerList!=null && signerList.size()!=0) {
            signerList.forEach(userAssoInfo -> {
                userAssoInfo.setAssoId(UUIdUtil.getUUID());
                userAssoInfo.setWorkTicketTypeId(workTicketType.getWorkTicketTypeId());
                userAssoInfo.setUserType("02");
                userAssoInfoMapper.insert(userAssoInfo);
            });
        }
        //添加许可人
        List<UserAssoInfo> licensorList = workTicketTypeVo.getLicensorList();
        if (licensorList!=null && licensorList.size()!=0) {
            licensorList.forEach(userAssoInfo -> {
                userAssoInfo.setAssoId(UUIdUtil.getUUID());
                userAssoInfo.setWorkTicketTypeId(workTicketType.getWorkTicketTypeId());
                userAssoInfo.setUserType("03");
                userAssoInfoMapper.insert(userAssoInfo);
            });
        }

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("操作成功");
        return resultEntity;
    }

    @Override
    public ResultEntity deleteWorkTicketType(String workTicketTypeIds) {
        ResultEntity resultEntity = new ResultEntity();

        if (!StringUtils.isNoneBlank(workTicketTypeIds)) {
            resultEntity.setMsg("ids不能为空");
            return resultEntity;
        }

        String[] ids = workTicketTypeIds.split(",");
        workTicketTypeMapper.batchDelete(ids);

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("操作成功");
        return resultEntity;
    }

    @Override
    public ResultEntity updateWorkTicketType(WorkTicketTypeVo workTicketTypeVo) {
        ResultEntity resultEntity = new ResultEntity();

        if (!StringUtils.isNoneBlank(workTicketTypeVo.getWorkTicketTypeId())) {
            resultEntity.setMsg("维护人不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(workTicketTypeVo.getMaintainer())) {
            resultEntity.setMsg("维护人不能为空");
            return resultEntity;
        }
        if (workTicketTypeVo.getMaintainDate()==null) {
            resultEntity.setMsg("维护日期不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(workTicketTypeVo.getTicketTypeNumber())) {
            resultEntity.setMsg("工作票类型编码不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(workTicketTypeVo.getWindId())) {
            resultEntity.setMsg("风电场不能为空");
            return resultEntity;
        }
        //修改工作票类型主数据
        WorkTicketType workTicketType = new WorkTicketType();
        BeanUtils.copyProperties(workTicketTypeVo,workTicketType);
        workTicketTypeMapper.updateByPrimaryKey(workTicketType);
        //修改安全措施
        WorkTicketSafeMeasureExample workTicketSafeMeasureExample = new WorkTicketSafeMeasureExample();
        workTicketSafeMeasureExample.createCriteria().andTicketTypeIdEqualTo(workTicketTypeVo.getWorkTicketTypeId());
        workTicketSafeMeasureMapper.deleteByExample(workTicketSafeMeasureExample);
        List<WorkTicketSafeMeasure> safeMeasureList = workTicketTypeVo.getSafeMeasureList();
        if (safeMeasureList!=null && safeMeasureList.size()!=0) {
            safeMeasureList.forEach(WorkTicketSafeMeasure -> {
                WorkTicketSafeMeasure.setSafeId(UUIdUtil.getUUID());
                WorkTicketSafeMeasure.setTicketTypeId(workTicketTypeVo.getWorkTicketTypeId());
                workTicketSafeMeasureMapper.insert(WorkTicketSafeMeasure);
            });
        }
        //删除工作类型关联负责人,签收人,许可人
        UserAssoInfoExample userAssoInfoExample = new UserAssoInfoExample();
        userAssoInfoExample.createCriteria().andWorkTicketTypeIdEqualTo(workTicketTypeVo.getWorkTicketTypeId());
        userAssoInfoMapper.deleteByExample(userAssoInfoExample);
        //添加工作负责人
        List<UserAssoInfo> workHeadList = workTicketTypeVo.getWorkHeadList();
        if (workHeadList!=null && workHeadList.size()!=0) {
            workHeadList.forEach(userAssoInfo -> {
                userAssoInfo.setAssoId(UUIdUtil.getUUID());
                userAssoInfo.setWorkTicketTypeId(workTicketTypeVo.getWorkTicketTypeId());
                userAssoInfo.setUserType("01");
                userAssoInfoMapper.insert(userAssoInfo);
            });
        }
        //添加签发人
        List<UserAssoInfo> signerList = workTicketTypeVo.getSignerList();
        if (signerList!=null && signerList.size()!=0) {
            signerList.forEach(userAssoInfo -> {
                userAssoInfo.setAssoId(UUIdUtil.getUUID());
                userAssoInfo.setWorkTicketTypeId(workTicketTypeVo.getWorkTicketTypeId());
                userAssoInfo.setUserType("02");
                userAssoInfoMapper.insert(userAssoInfo);
            });
        }
        //添加许可人
        List<UserAssoInfo> licensorList = workTicketTypeVo.getLicensorList();
        if (licensorList!=null && licensorList.size()!=0) {
            licensorList.forEach(userAssoInfo -> {
                userAssoInfo.setAssoId(UUIdUtil.getUUID());
                userAssoInfo.setWorkTicketTypeId(workTicketTypeVo.getWorkTicketTypeId());
                userAssoInfo.setUserType("03");
                userAssoInfoMapper.insert(userAssoInfo);
            });
        }

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("修改成功");
        return resultEntity;
    }

    @Override
    public ResultEntity getWorkTicketTypeDetail(String workTicketTypeId) {
        ResultEntity resultEntity = new ResultEntity();

        if (!StringUtils.isNoneBlank(workTicketTypeId)) {
            resultEntity.setMsg("id不能为空");
            return resultEntity;
        }

        WorkTicketTypeVo workTicketTypeVo = workTicketTypeMapper.getWorkTicketTypeDetail(workTicketTypeId);
        if (workTicketTypeVo!=null) {
            //获取安全措施
            WorkTicketSafeMeasureExample workTicketSafeMeasureExample = new WorkTicketSafeMeasureExample();
            workTicketSafeMeasureExample.setOrderByClause("safe_number");
            workTicketSafeMeasureExample.createCriteria().andTicketTypeIdEqualTo(workTicketTypeVo.getWorkTicketTypeId());
            List<WorkTicketSafeMeasure> safeMeasureList = workTicketSafeMeasureMapper.selectByExample(workTicketSafeMeasureExample);
            if (safeMeasureList!=null && safeMeasureList.size()!=0) {
                safeMeasureList.forEach(safeMeasure -> {
                    workTicketTypeVo.getSafeMeasureList().add(safeMeasure);
                });
            }
            //获取工作负责人
            UserAssoInfoExample userAssoInfoExample = new UserAssoInfoExample();
            userAssoInfoExample.setOrderByClause("user_numbet");
            UserAssoInfoExample.Criteria workHeadCriteria = userAssoInfoExample.createCriteria();
            workHeadCriteria.andWorkTicketTypeIdEqualTo(workTicketTypeVo.getWorkTicketTypeId());
            workHeadCriteria.andUserTypeEqualTo("01");
            List<UserAssoInfo> workHeadList = userAssoInfoMapper.selectByExample(userAssoInfoExample);
            if (workHeadList!=null && workHeadList.size()!=0) {
                workHeadList.forEach(userAssoInfo -> {
                    workTicketTypeVo.getWorkHeadList().add(userAssoInfo);
                });
            }
            //获取签收人
            UserAssoInfoExample.Criteria signerCriteria = userAssoInfoExample.createCriteria();
            userAssoInfoExample.setOrderByClause("user_numbet");
            signerCriteria.andWorkTicketTypeIdEqualTo(workTicketTypeVo.getWorkTicketTypeId());
            signerCriteria.andUserTypeEqualTo("02");
            List<UserAssoInfo> signerList = userAssoInfoMapper.selectByExample(userAssoInfoExample);
            if (signerList!=null && signerList.size()!=0) {
                signerList.forEach(userAssoInfo -> {
                    workTicketTypeVo.getWorkHeadList().add(userAssoInfo);
                });
            }
            //获取许可人
            UserAssoInfoExample.Criteria licensorCriteria = userAssoInfoExample.createCriteria();
            userAssoInfoExample.setOrderByClause("user_numbet");
            licensorCriteria.andWorkTicketTypeIdEqualTo(workTicketTypeVo.getWorkTicketTypeId());
            licensorCriteria.andUserTypeEqualTo("03");
            List<UserAssoInfo> licensorList = userAssoInfoMapper.selectByExample(userAssoInfoExample);
            if (licensorList!=null && licensorList.size()!=0) {
                licensorList.forEach(userAssoInfo -> {
                    workTicketTypeVo.getWorkHeadList().add(userAssoInfo);
                });
            }
        }

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("操作成功");
        resultEntity.setData(workTicketTypeVo);
        return resultEntity;
    }

    @Override
    public PageResultEntity getWorkTicketTypeList(Map<String,String> pageAndCondition) {
        PageResultEntity pageResultEntity = new PageResultEntity();
        pageResultEntity.setRows(new ArrayList());

        String start = String.valueOf((Integer.parseInt(pageAndCondition.get("pageNum"))-1)*(Integer.parseInt(pageAndCondition.get("pageSize"))));
        pageAndCondition.put("start",start);
        List<WorkTicketTypeVo> workTicketTypeVoList = workTicketTypeMapper.getWorkTicketTypeList(pageAndCondition);
        int total = workTicketTypeMapper.getTotal();

        pageResultEntity.setCode(ErrorCode.SUCCESS);
        pageResultEntity.setMsg("操作成功");
        pageResultEntity.setRows(workTicketTypeVoList);
        pageResultEntity.setTotal(total);
        return pageResultEntity;
    }

}
