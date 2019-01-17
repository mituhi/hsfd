package com.qz.zframe.tickets.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.qz.zframe.authentication.CurrentUserService;
import com.qz.zframe.common.entity.Role;
import com.qz.zframe.common.service.RoleService;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.common.util.UUIdUtil;
import com.qz.zframe.tickets.entity.*;
import com.qz.zframe.tickets.mapper.*;
import com.qz.zframe.tickets.service.StandardWorkTicketService;
import com.qz.zframe.tickets.service.WorkTicketTypeService;
import com.qz.zframe.tickets.vo.StandardWorkTicketVo;
import com.qz.zframe.tickets.vo.WorkTicketRiskControlVo;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
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
public class SatndardWorkTicketServiceImpl implements StandardWorkTicketService {

    @Autowired
    private StandardWorkTicketMapper standardWorkTicketMapper;

    @Autowired
    private WorkTicketSafeMeasureMapper workTicketSafeMeasureMapper;

    @Autowired
    private WorkTicketRiskControlMapper workTicketRiskControlMapper;

    @Autowired
    private WorkTicketMapper workTicketMapper;

    @Autowired
    private WorkTicketTypeMapper workTicketTypeMapper;

    @Autowired
    private CurrentUserService currentUserService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private WorkTicketTypeService workTicketTypeService;

    @Override
    public ResultEntity addStandardWorkTicket(StandardWorkTicketVo standardWorkTicketVo) {
        ResultEntity resultEntity = new ResultEntity();

        if (!StringUtils.isNoneBlank(standardWorkTicketVo.getTicketTypeId())) {
            resultEntity.setMsg("工作票类型id不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(standardWorkTicketVo.getWindId())) {
            resultEntity.setMsg("风电场编码不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(standardWorkTicketVo.getStatus())) {
            resultEntity.setMsg("状态不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(standardWorkTicketVo.getCrewId())) {
            resultEntity.setMsg("机组id不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(standardWorkTicketVo.getWorkTeam())) {
            resultEntity.setMsg("工作班组id不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(standardWorkTicketVo.getDoubleName())) {
            resultEntity.setMsg("工作的风电场、升压站名称及设备双重名称不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(standardWorkTicketVo.getWorkPlace())) {
            resultEntity.setMsg("工作地点或地段不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(standardWorkTicketVo.getWorkContent())) {
            resultEntity.setMsg("工作内容不能为空");
            return resultEntity;
        }

        //设置id
        standardWorkTicketVo.setStandardTicketId(UUIdUtil.getUUID());
        //设置流水号
        String prefix = "";
        String ticketTypeName = workTicketTypeMapper.getNameById(standardWorkTicketVo.getTicketTypeId());
        StandardWorkTicketExample standardWorkTicketExample = new StandardWorkTicketExample();
        if (StringUtils.isNoneBlank(ticketTypeName)) {
            if (ticketTypeName.contains("第一")) {
                prefix = "BZDY";
                standardWorkTicketExample.createCriteria().andSerialNumberLike("BZDY%");
            }else if (ticketTypeName.contains("第二")) {
                prefix = "BZDE";
                standardWorkTicketExample.createCriteria().andSerialNumberLike("BZDE%");
            }else {
                prefix = "BZQT";
                standardWorkTicketExample.createCriteria().andSerialNumberLike("BZQT%");
            }
        }

        String tail = String.valueOf(1000+standardWorkTicketMapper.countByExample(standardWorkTicketExample)+1);
        tail = tail.substring(1);
        standardWorkTicketVo.setSerialNumber(prefix+tail);
        //添加维护人
        this.setMaintainAndMaintainDate(standardWorkTicketVo);
        //插入数据库
        standardWorkTicketMapper.insertSelective(standardWorkTicketVo);
        //添加安全措施等tab页
        this.insertTab(standardWorkTicketVo );

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("添加成功");
        return resultEntity;
    }

    @Override
    public ResultEntity updateStandardWorkTicket(StandardWorkTicketVo standardWorkTicketVo) {
        ResultEntity resultEntity = new ResultEntity();

        if (!StringUtils.isNoneBlank(standardWorkTicketVo.getStandardTicketId())) {
            resultEntity.setMsg("id不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(standardWorkTicketVo.getTicketTypeId())) {
            resultEntity.setMsg("工作票类型id不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(standardWorkTicketVo.getWindId())) {
            resultEntity.setMsg("风电场编码不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(standardWorkTicketVo.getStatus())) {
            resultEntity.setMsg("状态不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(standardWorkTicketVo.getCrewId())) {
            resultEntity.setMsg("机组id不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(standardWorkTicketVo.getWorkTeam())) {
            resultEntity.setMsg("工作班组id不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(standardWorkTicketVo.getDoubleName())) {
            resultEntity.setMsg("工作的风电场、升压站名称及设备双重名称不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(standardWorkTicketVo.getWorkPlace())) {
            resultEntity.setMsg("工作地点或地段不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(standardWorkTicketVo.getWorkContent())) {
            resultEntity.setMsg("工作内容不能为空");
            return resultEntity;
        }

        //修改主表数据
        StandardWorkTicket standardWorkTicket = standardWorkTicketMapper.selectByPrimaryKey(standardWorkTicketVo.getStandardTicketId());
        BeanUtil.copyProperties(standardWorkTicketVo,standardWorkTicket,true, CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true));
        standardWorkTicketMapper.updateByPrimaryKeySelective(standardWorkTicket);
        //修改安全措施tab页
        this.updateTab(standardWorkTicketVo);

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("修改成功");
        return resultEntity;
    }

    @Override
    public ResultEntity deleteStandardWorkTicket(String[] standardTicketIds) {
        ResultEntity resultEntity = new ResultEntity();

        if (!(standardTicketIds!=null && standardTicketIds.length!=0)) {
            resultEntity.setMsg("ids不能为空");
            return resultEntity;
        }
        /*for (String standardTicketId:standardTicketIds) {
            //如果该类型正在被使用,不能删除
            WorkTicketExample workTicketExample = new WorkTicketExample();
            workTicketExample.createCriteria().andStandardTicketIdEqualTo(standardTicketId).andStatusEqualTo("01");
            List<WorkTicket> workTickets = workTicketMapper.selectByExample(workTicketExample);
            if (CollectionUtils.isNotEmpty(workTickets)) {
                resultEntity.setMsg("选中的类型正在被使用,无法删除");
                return resultEntity;
            }
        }*/
        //删除标准工作票
        standardWorkTicketMapper.batchDelete(standardTicketIds);
        //删除安全措施和危险因素控制措施
        this.deleteTab(standardTicketIds);

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("删除成功");
        return resultEntity;
    }

    @Override
    public ResultEntity getStandardWorkTicketDetail(String standardTicketId) {
        ResultEntity resultEntity = new ResultEntity();

        if (!StringUtils.isNoneBlank(standardTicketId)) {
            resultEntity.setMsg("id不能为空");
            return resultEntity;
        }

        //查询标准工作票主数据
        StandardWorkTicketVo standardWorkTicketVo = standardWorkTicketMapper.getStandardWorkTicketDetail(standardTicketId);
        if (standardWorkTicketVo!=null) {
            standardWorkTicketVo.setStatus(this.getStatusName(standardWorkTicketVo.getStatus()));
            //获取安全措施
            WorkTicketSafeMeasureExample workTicketSafeMeasureExample = new WorkTicketSafeMeasureExample();
            workTicketSafeMeasureExample.setOrderByClause("safe_number");
            workTicketSafeMeasureExample.createCriteria().andTicketTypeIdEqualTo(standardWorkTicketVo.getStandardTicketId());
            List<WorkTicketSafeMeasure> safeMeasureList = workTicketSafeMeasureMapper.selectByExample(workTicketSafeMeasureExample);
            if (safeMeasureList!=null && safeMeasureList.size()!=0) {
                safeMeasureList.forEach(safeMeasure -> {
                    standardWorkTicketVo.getSafeMeasureList().add(safeMeasure);
                });
            }
            //获取危险因素控制措施
            List<WorkTicketRiskControlVo> riskControlList = workTicketRiskControlMapper.getStandardWorkTicketRiskControlList(standardWorkTicketVo.getStandardTicketId());
            if(riskControlList!=null && riskControlList.size()!=0) {
                riskControlList.forEach(workTicketRiskControlVo -> {
                    standardWorkTicketVo.getRiskControlList().add(workTicketRiskControlVo);
                });
            }
        }

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("查询成功");
        resultEntity.setData(standardWorkTicketVo);
        return resultEntity;
    }

    @Override
    public PageResultEntity getStandardWorkTicketList(Map<String,String> pageAndCondition) {
        PageResultEntity pageResultEntity = new PageResultEntity();
        pageResultEntity.setRows(new ArrayList());

        String start = String.valueOf((Integer.parseInt(pageAndCondition.get("pageNum"))-1)*(Integer.parseInt(pageAndCondition.get("pageSize"))));
        pageAndCondition.put("start",start);
        String userId = currentUserService.getId();
        List<StandardWorkTicketVo> standardWorkTicketVoList = standardWorkTicketMapper.getStandardWorkTicketList(pageAndCondition,userId);
        if (CollectionUtils.isNotEmpty(standardWorkTicketVoList)) {
            standardWorkTicketVoList.forEach(standardWorkTicketVo -> {
                standardWorkTicketVo.setStatus(this.getStatusName(standardWorkTicketVo.getStatus()));
            });
        }
        int total = standardWorkTicketMapper.getTotal(pageAndCondition,userId);

        pageResultEntity.setCode(ErrorCode.SUCCESS);
        pageResultEntity.setMsg("操作成功");
        pageResultEntity.setRows(standardWorkTicketVoList);
        pageResultEntity.setTotal(total);
        return pageResultEntity;
    }

    @Override
    public ResultEntity getEnableStandardWorkTicketList() {
        ResultEntity resultEntity = new ResultEntity();

        StandardWorkTicketExample standardWorkTicketExample = new StandardWorkTicketExample();
        standardWorkTicketExample.createCriteria().andStatusEqualTo("01");
        List<StandardWorkTicket> standardWorkTicketList = standardWorkTicketMapper.selectByExample(standardWorkTicketExample);

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("查询成功");
        resultEntity.setData(standardWorkTicketList);
        return resultEntity;
    }

    @Override
    public ResultEntity createWorkTicket(StandardWorkTicketVo standardWorkTicketVo) {
        ResultEntity resultEntity = new ResultEntity();

        String standardTicketId = standardWorkTicketVo.getStandardTicketId();
        if (!StringUtils.isNoneBlank(standardTicketId)) {
            resultEntity.setCode(ErrorCode.ERROR);
            resultEntity.setMsg("标准工作票id不能为空");
            return resultEntity;
        }
        StandardWorkTicket standardWorkTicket = standardWorkTicketMapper.selectByPrimaryKey(standardTicketId);

        if (standardWorkTicket!=null) {
            //判断权限-工作负责人
            boolean flag = true;
            List<UserAssoInfo> workHeadList = (List<UserAssoInfo>)workTicketTypeService.getWorkHeadList(standardWorkTicket.getTicketTypeId()).getData();
            List<Role> userRoleList = roleService.findUserRoleList(currentUserService.getId());
            if (CollectionUtils.isNotEmpty(userRoleList)) {
                for (Role role:userRoleList) {
                    if ("系统管理员".equals(role.getRoleName())) {
                        flag =false;
                    }
                }
            }
            if (CollectionUtils.isNotEmpty(workHeadList)) {
                for (UserAssoInfo userAssoInfo:workHeadList) {
                    if (currentUserService.getId().equals(userAssoInfo.getUserId())) {
                        flag =false;
                    }
                }
            }
            if (flag) {
                resultEntity.setMsg("权限不足");
                return resultEntity;
            }


            //判断该标准工作票是否被停用
            if ("02".equals(standardWorkTicket.getStatus())) {
                resultEntity.setMsg("该标准工作票已被停用,无法生成工作票");
                return resultEntity;
            }
            //创建工作票对象
            WorkTicket workTicket = new WorkTicket();
            //设置id
            workTicket.setTicketId(UUIdUtil.getUUID());
            //设置状态为未提交
            workTicket.setStatus("03");
            //添加维护人
            workTicket.setMaintainer(currentUserService.getId());
            //添加维护日期
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                workTicket.setMaintainDate(simpleDateFormat.parse(simpleDateFormat.format(new Date())));
            }catch (ParseException e) {
                e.printStackTrace();
            }
            workTicket.setWorkTicketTypeId(standardWorkTicket.getTicketTypeId());
            workTicket.setStandardTicketId(standardTicketId);
            workTicket.setWindId(standardWorkTicket.getWindId());
            workTicket.setCrewId(standardWorkTicket.getCrewId());
            workTicket.setWorkTeam(standardWorkTicket.getWorkTeam());
            if (standardWorkTicket.getPositionId()!=null) {
                workTicket.setPositionId(standardWorkTicket.getPositionId());
            }
            if (standardWorkTicket.getEquipmentId()!=null) {
                workTicket.setEquipmentId(standardWorkTicket.getEquipmentId());
            }
            workTicket.setDoubleNaem(standardWorkTicket.getDoubleName());
            workTicket.setWorkPlace(standardWorkTicket.getWorkPlace());
            workTicket.setWorkContent(standardWorkTicket.getWorkContent());
            workTicketMapper.insert(workTicket);
            //设置安全措施
            WorkTicketSafeMeasureExample workTicketSafeMeasureExample = new WorkTicketSafeMeasureExample();
            workTicketSafeMeasureExample.createCriteria().andTicketIdEqualTo(standardTicketId);
            List<WorkTicketSafeMeasure> standardWorkTicketSafeMeasureList = workTicketSafeMeasureMapper.selectByExample(workTicketSafeMeasureExample);
            if (CollectionUtils.isNotEmpty(standardWorkTicketSafeMeasureList)) {
                standardWorkTicketSafeMeasureList.forEach(standardWorkTicketSafeMeasure -> {
                    WorkTicketSafeMeasure workTicketSafeMeasure = new WorkTicketSafeMeasure();
                    workTicketSafeMeasure.setSafeId(UUIdUtil.getUUID());
                    workTicketSafeMeasure.setTicketId(workTicket.getTicketId());
                    workTicketSafeMeasure.setSafeNumber(standardWorkTicketSafeMeasure.getSafeNumber());
                    workTicketSafeMeasure.setSafeTitle(standardWorkTicketSafeMeasure.getSafeTitle());
                    workTicketSafeMeasure.setSafeContent(standardWorkTicketSafeMeasure.getSafeContent());
                    workTicketSafeMeasureMapper.insert(workTicketSafeMeasure);
                });
            }
            //设置危险因素控制措施
            WorkTicketRiskControlExample workTicketRiskControlExample = new WorkTicketRiskControlExample();
            workTicketRiskControlExample.createCriteria().andTicketIdEqualTo(standardTicketId);
            List<WorkTicketRiskControl> standardWorkTicketRiskControlList = workTicketRiskControlMapper.selectByExample(workTicketRiskControlExample);
            if (CollectionUtils.isNotEmpty(standardWorkTicketRiskControlList)) {
                standardWorkTicketRiskControlList.forEach(standardWorkTicketRiskControl -> {
                    WorkTicketRiskControl workTicketRiskControl = new WorkTicketRiskControl();
                    workTicketRiskControl.setMeasureId(UUIdUtil.getUUID());
                    workTicketRiskControl.setTicketId(workTicket.getTicketId());
                    workTicketRiskControl.setMeasureNumber(standardWorkTicketRiskControl.getMeasureNumber());
                    workTicketRiskControl.setDangerPoint(standardWorkTicketRiskControl.getDangerPoint());
                    workTicketRiskControl.setMeasure(standardWorkTicketRiskControl.getMeasure());
                    workTicketRiskControl.setMeasureExecutor(standardWorkTicketRiskControl.getMeasureExecutor());
                    workTicketRiskControlMapper.insert(workTicketRiskControl);
                });
            }
            resultEntity.setMsg("生成成功");
            resultEntity.setData(workTicket.getTicketId());
        }else {
            resultEntity.setMsg("该工作票不存在");
        }

        resultEntity.setCode(ErrorCode.SUCCESS);
        return resultEntity;
    }

    private void insertTab(StandardWorkTicketVo standardWorkTicketVo) {
        //添加安全措施
        List<WorkTicketSafeMeasure> safeMeasureList = standardWorkTicketVo.getSafeMeasureList();
        if (safeMeasureList!=null && safeMeasureList.size()!=0) {
            int i = 1;
            for (WorkTicketSafeMeasure workTicketSafeMeasure:safeMeasureList) {
                workTicketSafeMeasure.setSafeId(UUIdUtil.getUUID());
                workTicketSafeMeasure.setSafeNumber(String.valueOf(i++));
                workTicketSafeMeasure.setStandardTicketId(standardWorkTicketVo.getStandardTicketId());
                workTicketSafeMeasureMapper.insert(workTicketSafeMeasure);
            }
        }
        //添加危险因素控制措施
        List<WorkTicketRiskControlVo> riskControlList = standardWorkTicketVo.getRiskControlList();
        if (riskControlList!=null && riskControlList.size()!=0) {
            int i = 1;
            for (WorkTicketRiskControl workTicketRiskControl:riskControlList) {
                workTicketRiskControl.setMeasureNumber(String.valueOf(i++));
                workTicketRiskControl.setMeasureId(UUIdUtil.getUUID());
                workTicketRiskControl.setStandardTicketId(standardWorkTicketVo.getStandardTicketId());
                workTicketRiskControlMapper.insert(workTicketRiskControl);
            }
        }
    }

    private void updateTab(StandardWorkTicketVo standardWorkTicketVo) {
        //删除原来的安措
        WorkTicketSafeMeasureExample workTicketSafeMeasureExample = new WorkTicketSafeMeasureExample();
        workTicketSafeMeasureExample.createCriteria().andStandardTicketIdEqualTo(standardWorkTicketVo.getStandardTicketId());
        workTicketSafeMeasureMapper.deleteByExample(workTicketSafeMeasureExample);
        //删除原来的危险因素控制措施
        WorkTicketRiskControlExample workTicketRiskControlExample = new WorkTicketRiskControlExample();
        workTicketRiskControlExample.createCriteria().andStandardTicketIdEqualTo(standardWorkTicketVo.getStandardTicketId());
        workTicketRiskControlMapper.deleteByExample(workTicketRiskControlExample);

        //重新添加
        this.insertTab(standardWorkTicketVo);
    }

    private void deleteTab(String[] standardTicketIds) {
        //删除安全措施
        workTicketSafeMeasureMapper.batchDeleteByStandardTicketIds(standardTicketIds);
        //删除危险因素控制措施
        workTicketRiskControlMapper.batchDeleteByStandardTicketIds(standardTicketIds);
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

    private void setMaintainAndMaintainDate(StandardWorkTicketVo standardWorkTicketVo) {
        //添加维护人
        if (!StringUtils.isNoneBlank(standardWorkTicketVo.getMaintainer())) {
            standardWorkTicketVo.setMaintainer(currentUserService.getId());
        }
        //添加维护日期
        if (standardWorkTicketVo.getMaintainDate()==null) {
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                standardWorkTicketVo.setMaintainDate(simpleDateFormat.parse(simpleDateFormat.format(new Date())));
            }catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }
}
