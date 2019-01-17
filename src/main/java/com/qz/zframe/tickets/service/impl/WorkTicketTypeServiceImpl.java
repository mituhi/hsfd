package com.qz.zframe.tickets.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.qz.zframe.authentication.CurrentUserService;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.common.util.UUIdUtil;
import com.qz.zframe.tickets.entity.*;
import com.qz.zframe.tickets.mapper.UserAssoInfoMapper;
import com.qz.zframe.tickets.mapper.WorkTicketMapper;
import com.qz.zframe.tickets.mapper.WorkTicketSafeMeasureMapper;
import com.qz.zframe.tickets.mapper.WorkTicketTypeMapper;
import com.qz.zframe.tickets.service.WorkTicketTypeService;
import com.qz.zframe.tickets.vo.UserAssoVo;
import com.qz.zframe.tickets.vo.WorkTicketTypeVo;
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
public class WorkTicketTypeServiceImpl implements WorkTicketTypeService {

    @Autowired
    private WorkTicketTypeMapper workTicketTypeMapper;

    @Autowired
    private UserAssoInfoMapper userAssoInfoMapper;

    @Autowired
    private WorkTicketSafeMeasureMapper workTicketSafeMeasureMapper;

    @Autowired
    private WorkTicketMapper workTicketMapper;

    @Autowired
    private CurrentUserService currentUserService;

    @Override
    public ResultEntity addWorkTicketType(WorkTicketTypeVo workTicketTypeVo) {
        ResultEntity resultEntity = new ResultEntity();

        if (!StringUtils.isNoneBlank(workTicketTypeVo.getTicketTypeNumber())) {
            resultEntity.setMsg("工作票类型编码不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(workTicketTypeVo.getWindId())) {
            resultEntity.setMsg("风电场编码不能为空");
            return resultEntity;
        }
        WorkTicketTypeExample workTicketTypeExample = new WorkTicketTypeExample();
        workTicketTypeExample.createCriteria().andTicketTypeNumberEqualTo(workTicketTypeVo.getTicketTypeNumber());
        List<WorkTicketType> workTicketTypeList = workTicketTypeMapper.selectByExample(workTicketTypeExample);
        if (CollectionUtils.isNotEmpty(workTicketTypeList)) {
            resultEntity.setMsg("工作票类型编码已存在,请重新编写");
            return resultEntity;
        }
        //设置id
        workTicketTypeVo.setWorkTicketTypeId(UUIdUtil.getUUID());
        //设置创建时间
        workTicketTypeVo.setCreateTime(new Date());
        //添加维护人维护日期
        this.setMaintainAndMaintainDate(workTicketTypeVo);
        //插入数据库
        workTicketTypeMapper.insertSelective(workTicketTypeVo);
        //添加安全措施tab页
        this.insertTab(workTicketTypeVo);

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("操作成功");
        return resultEntity;
    }

    @Override
    public ResultEntity updateWorkTicketType(WorkTicketTypeVo workTicketTypeVo) {
        ResultEntity resultEntity = new ResultEntity();

        if (!StringUtils.isNoneBlank(workTicketTypeVo.getWorkTicketTypeId())) {
            resultEntity.setMsg("工作票类型id不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(workTicketTypeVo.getTicketTypeNumber())) {
            resultEntity.setMsg("工作票类型编码不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(workTicketTypeVo.getMaintainer())) {
            resultEntity.setMsg("维护人id不能为空");
            return resultEntity;
        }
        if (workTicketTypeVo.getMaintainDate()==null) {
            resultEntity.setMsg("维护日期不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(workTicketTypeVo.getWindId())) {
            resultEntity.setMsg("风电场编码不能为空");
            return resultEntity;
        }

        WorkTicketTypeExample workTicketTypeExample = new WorkTicketTypeExample();
        workTicketTypeExample.createCriteria().andTicketTypeNumberEqualTo(workTicketTypeVo.getTicketTypeNumber()).andWorkTicketTypeIdNotEqualTo(workTicketTypeVo.getWorkTicketTypeId());
        List<WorkTicketType> workTicketTypeList = workTicketTypeMapper.selectByExample(workTicketTypeExample);
        if (CollectionUtils.isNotEmpty(workTicketTypeList)) {
            resultEntity.setMsg("工作票类型编码已存在,请重新编写");
            return resultEntity;
        }
        //修改工作票类型主数据
        WorkTicketType workTicketType = workTicketTypeMapper.selectByPrimaryKey(workTicketTypeVo.getWorkTicketTypeId());
        BeanUtil.copyProperties(workTicketTypeVo,workTicketType,true, CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true));
        workTicketTypeMapper.updateByPrimaryKeySelective(workTicketType);

        //修改安全措施tab页
        this.updateTab(workTicketTypeVo);

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("修改成功");
        return resultEntity;
    }

    private void deleteChildMsg(WorkTicketType workTicketType) {
        workTicketTypeMapper.deleteWorkSafeByWorkTicketTypeId(workTicketType.getWorkTicketTypeId());
        workTicketTypeMapper.deleteChildMsgByWorkTicketTypeId(workTicketType.getWorkTicketTypeId());
    }

    @Override
    public ResultEntity deleteWorkTicketType(String[] workTicketTypeIds) {
        ResultEntity resultEntity = new ResultEntity();

        if (!(workTicketTypeIds!=null && workTicketTypeIds.length!=0)) {
            resultEntity.setMsg("ids不能为空");
            return resultEntity;
        }
        for (String workTicketTypeId:workTicketTypeIds) {
            //如果该类型正在被使用,不能删除
            WorkTicketExample workTicketExample = new WorkTicketExample();
            workTicketExample.createCriteria().andWorkTicketTypeIdEqualTo(workTicketTypeId).andStatusEqualTo("01");
            List<WorkTicket> workTickets = workTicketMapper.selectByExample(workTicketExample);
            if (CollectionUtils.isNotEmpty(workTickets)) {
                resultEntity.setMsg("选中的类型正在被使用,无法删除");
                return resultEntity;
            }
        }
        //删除工作票类型
        workTicketTypeMapper.batchDelete(workTicketTypeIds);
        //删除安全措施和关联人员
        this.deleteTab(workTicketTypeIds);

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("删除成功");
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
            List<UserAssoVo> workHeadList = userAssoInfoMapper.
                    getUserAssoVoListByWorkTicketType(workTicketTypeVo.getWorkTicketTypeId(), "01");
            if (workHeadList!=null && workHeadList.size()!=0) {
                workHeadList.forEach(userAssoInfo -> {
                    workTicketTypeVo.getWorkHeadList().add(userAssoInfo);
                });
            }
            //获取签收人
            List<UserAssoVo> signerList = userAssoInfoMapper.
                    getUserAssoVoListByWorkTicketType(workTicketTypeVo.getWorkTicketTypeId(), "02");
            if (CollectionUtils.isNotEmpty(signerList)) {
                signerList.forEach(userAssoInfo -> {
                    workTicketTypeVo.getSignerList().add(userAssoInfo);
                });
            }
            //获取许可人
            List<UserAssoVo> licensorList = userAssoInfoMapper.
                    getUserAssoVoListByWorkTicketType(workTicketTypeVo.getWorkTicketTypeId(), "03");
            if (CollectionUtils.isNotEmpty(licensorList)) {
                licensorList.forEach(userAssoInfo -> {
                    workTicketTypeVo.getLicensorList().add(userAssoInfo);
                });
            }
        }

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("操作成功");
        resultEntity.setData(workTicketTypeVo);
        return resultEntity;
    }

    @Override
    public PageResultEntity getWorkTicketTypeList(Map<String,String> pageAndCondition, String startArchitectureCode , String endArchitectureCode) {
        PageResultEntity pageResultEntity = new PageResultEntity();
        pageResultEntity.setRows(new ArrayList());

        String start = String.valueOf((Integer.parseInt(pageAndCondition.get("pageNum"))-1)*(Integer.parseInt(pageAndCondition.get("pageSize"))));
        pageAndCondition.put("start",start);
        List<WorkTicketTypeVo> workTicketTypeVoList = workTicketTypeMapper.getWorkTicketTypeList(pageAndCondition);
        int total = workTicketTypeMapper.getTotal(pageAndCondition);

        pageResultEntity.setCode(ErrorCode.SUCCESS);
        pageResultEntity.setMsg("操作成功");
        pageResultEntity.setRows(workTicketTypeVoList);
        pageResultEntity.setTotal(total);
        return pageResultEntity;
    }

    @Override
    public ResultEntity getAllWorkTicketType() {
        ResultEntity resultEntity = new ResultEntity();

        List<WorkTicketType> workTicketTypeList = workTicketTypeMapper.selectByExample(new WorkTicketTypeExample());


        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("查询成功");
        resultEntity.setData(workTicketTypeList);
        return resultEntity;
    }

    @Override
    public ResultEntity getWorkHeadList(String workTicketTypeId) {
        ResultEntity resultEntity = new ResultEntity();

        UserAssoInfoExample userAssoInfoExample = new UserAssoInfoExample();
        userAssoInfoExample.setOrderByClause("user_numbet");
        UserAssoInfoExample.Criteria workHeadCriteria = userAssoInfoExample.createCriteria();
        workHeadCriteria.andWorkTicketTypeIdEqualTo(workTicketTypeId);
        workHeadCriteria.andUserTypeEqualTo("01");
        List<UserAssoInfo> workHeadList = userAssoInfoMapper.selectByExample(userAssoInfoExample);

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("查询成功");
        resultEntity.setData(workHeadList);
        return resultEntity;
    }

    @Override
    public ResultEntity getSignerList(String workTicketTypeId) {
        ResultEntity resultEntity = new ResultEntity();

        UserAssoInfoExample userAssoInfoExample = new UserAssoInfoExample();
        userAssoInfoExample.setOrderByClause("user_numbet");
        UserAssoInfoExample.Criteria signerCriteria = userAssoInfoExample.createCriteria();
        signerCriteria.andWorkTicketTypeIdEqualTo(workTicketTypeId);
        signerCriteria.andUserTypeEqualTo("02");
        List<UserAssoInfo> signerList = userAssoInfoMapper.selectByExample(userAssoInfoExample);

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("查询成功");
        resultEntity.setData(signerList);
        return resultEntity;
    }

    @Override
    public ResultEntity getLicensorList(String workTicketTypeId) {
        ResultEntity resultEntity = new ResultEntity();

        UserAssoInfoExample userAssoInfoExample = new UserAssoInfoExample();
        userAssoInfoExample.setOrderByClause("user_numbet");
        UserAssoInfoExample.Criteria licensorCriteria = userAssoInfoExample.createCriteria();
        licensorCriteria.andWorkTicketTypeIdEqualTo(workTicketTypeId);
        licensorCriteria.andUserTypeEqualTo("03");
        List<UserAssoInfo> licensorList = userAssoInfoMapper.selectByExample(userAssoInfoExample);

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("查询成功");
        resultEntity.setData(licensorList);
        return resultEntity;
    }

    private void insertTab(WorkTicketTypeVo workTicketTypeVo) {
        //添加安全措施
        List<WorkTicketSafeMeasure> safeMeasureList = workTicketTypeVo.getSafeMeasureList();
        if (CollectionUtils.isNotEmpty(safeMeasureList)) {
            int i = 1;
            for (WorkTicketSafeMeasure workTicketSafeMeasure:safeMeasureList) {
                workTicketSafeMeasure.setSafeId(UUIdUtil.getUUID());
                workTicketSafeMeasure.setSafeNumber(String.valueOf(i++));
                workTicketSafeMeasure.setTicketTypeId(workTicketTypeVo.getWorkTicketTypeId());
                workTicketSafeMeasureMapper.insert(workTicketSafeMeasure);
            }
        }
        //添加工作负责人
        List<UserAssoVo> workHeadList = workTicketTypeVo.getWorkHeadList();
        if (CollectionUtils.isNotEmpty(workHeadList)) {
            int i = 1;
            for (UserAssoInfo userAssoInfo:workHeadList) {
                userAssoInfo.setAssoId(UUIdUtil.getUUID());
                userAssoInfo.setUserNumbet(String.valueOf(i++));
                userAssoInfo.setWorkTicketTypeId(workTicketTypeVo.getWorkTicketTypeId());
                userAssoInfo.setUserType("01");
                userAssoInfoMapper.insert(userAssoInfo);
            }
        }
        //添加签发人
        List<UserAssoVo> signerList = workTicketTypeVo.getSignerList();
        if (CollectionUtils.isNotEmpty(signerList)) {
            int i = 1;
            for (UserAssoInfo userAssoInfo:signerList) {
                userAssoInfo.setAssoId(UUIdUtil.getUUID());
                userAssoInfo.setUserNumbet(String.valueOf(i++));
                userAssoInfo.setWorkTicketTypeId(workTicketTypeVo.getWorkTicketTypeId());
                userAssoInfo.setUserType("02");
                userAssoInfoMapper.insert(userAssoInfo);
            }
        }
        //添加许可人
        List<UserAssoVo> licensorList = workTicketTypeVo.getLicensorList();
        if (CollectionUtils.isNotEmpty(licensorList)) {
            int i = 1;
            for (UserAssoInfo userAssoInfo:licensorList) {
                userAssoInfo.setAssoId(UUIdUtil.getUUID());
                userAssoInfo.setUserNumbet(String.valueOf(i++));
                userAssoInfo.setWorkTicketTypeId(workTicketTypeVo.getWorkTicketTypeId());
                userAssoInfo.setUserType("03");
                userAssoInfoMapper.insert(userAssoInfo);
            }
        }
    }

    private void updateTab(WorkTicketTypeVo workTicketTypeVo) {
        //删除原来的安全措施
        WorkTicketSafeMeasureExample workTicketSafeMeasureExample = new WorkTicketSafeMeasureExample();
        workTicketSafeMeasureExample.createCriteria().andTicketTypeIdEqualTo(workTicketTypeVo.getWorkTicketTypeId());
        workTicketSafeMeasureMapper.deleteByExample(workTicketSafeMeasureExample);
        //删除工作类型关联的负责人,签收人,许可人
        UserAssoInfoExample userAssoInfoExample = new UserAssoInfoExample();
        userAssoInfoExample.createCriteria().andWorkTicketTypeIdEqualTo(workTicketTypeVo.getWorkTicketTypeId());
        userAssoInfoMapper.deleteByExample(userAssoInfoExample);

        //重新插入
        this.insertTab(workTicketTypeVo);
    }

    private void deleteTab(String[] workTicketTypeIds) {
        //删除安全措施
        workTicketSafeMeasureMapper.batchDeleteByWorkTicketTypeIds(workTicketTypeIds);
        //删除关联人员
        userAssoInfoMapper.batchDelete1(workTicketTypeIds);
    }

    private void setMaintainAndMaintainDate(WorkTicketTypeVo workTicketTypeVo) {
        //添加维护人
        if (!StringUtils.isNoneBlank(workTicketTypeVo.getMaintainer())) {
            workTicketTypeVo.setMaintainer(currentUserService.getId());
        }
        //添加维护日期
        if (workTicketTypeVo.getMaintainDate()==null) {
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                workTicketTypeVo.setMaintainDate(simpleDateFormat.parse(simpleDateFormat.format(new Date())));
            }catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }
}
