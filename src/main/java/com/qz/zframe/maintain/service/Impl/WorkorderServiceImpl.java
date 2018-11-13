package com.qz.zframe.maintain.service.Impl;

import com.qz.zframe.authentication.CurrentUserService;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.common.util.UUIdUtil;
import com.qz.zframe.maintain.entity.*;
import com.qz.zframe.maintain.mapper.*;
import com.qz.zframe.maintain.service.WorkorderService;
import com.qz.zframe.maintain.vo.WorkorderVo;
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
public class WorkorderServiceImpl implements WorkorderService {

    @Autowired
    private CurrentUserService currentUserService;

    @Autowired
    private WorkorderInfoMapper workorderInfoMapper;

    @Autowired
    private WorkorderProcessMapper workorderProcessMapper;

    @Autowired
    private WorkorderMaterialMapper workorderMaterialMapper;

    @Autowired
    private WorkorderServiceMapper workorderServiceMapper;

    @Autowired
    private WorkorderToolMapper workorderToolMapper;

    @Autowired
    private WorkorderWorktypeMapper workorderWorktypeMapper;

    @Autowired
    private WorkorderQualityAcceptanceMapper workorderQualityAcceptanceMapper;

    @Autowired
    private WorkorderDangerPointMapper workorderDangerPointMapper;

    @Autowired
    private WorkorderSummaryMapper workorderSummaryMapper;

    @Override
    public ResultEntity addWorkorder(WorkorderVo workorderVo) {
        ResultEntity resultEntity = new ResultEntity();

        try {

            if (!StringUtils.isNoneBlank(workorderVo.getMaintainer())) {
                resultEntity.setMsg("维护人不能为空");
                return resultEntity;
            }
            if (workorderVo.getMaintainDate()==null) {
                resultEntity.setMsg("维护日期不能为空");
                return resultEntity;
            }
            if (!StringUtils.isNoneBlank(workorderVo.getWorkorderDesc())) {
                resultEntity.setMsg("工单描述不能为空");
                return resultEntity;
            }
            if (!StringUtils.isNoneBlank(workorderVo.getWorkorderTypeId())) {
                resultEntity.setMsg("工单类型不能为空");
                return resultEntity;
            }
            if (!StringUtils.isNoneBlank(workorderVo.getWindId())) {
                resultEntity.setMsg("风电场id不能为空");
                return resultEntity;
            }
            if (!StringUtils.isNoneBlank(workorderVo.getCompany())) {
                resultEntity.setMsg("公司不能为空");
                return resultEntity;
            }
            if (!StringUtils.isNoneBlank(workorderVo.getFillPerson())) {
                resultEntity.setMsg("填报人不能为空");
                return resultEntity;
            }
            if (!StringUtils.isNoneBlank(workorderVo.getDutyHead())) {
                resultEntity.setMsg("负责人不能为空");
                return resultEntity;
            }
            if (!StringUtils.isNoneBlank(workorderVo.getDutyTeam())) {
                resultEntity.setMsg("负责班组不能为空");
                return resultEntity;
            }
            //保存工单
            WorkorderInfo workorderInfo = new WorkorderInfo();
            BeanUtils.copyProperties(workorderVo, workorderInfo);
            workorderInfo.setOrderId(UUIdUtil.getUUID());
            workorderInfo.setSerialNumber(String.valueOf(workorderInfoMapper.countByExample(new WorkorderInfoExample())+1));
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date schemeTime = simpleDateFormat.parse(simpleDateFormat.format(new Date()));
            workorderInfo.setSchemeTime(schemeTime);
            workorderInfoMapper.insert(workorderInfo);
            //保存工序列表
            List<WorkorderProcess> processList = workorderVo.getWorkorderProcessList();
            if (processList==null || processList.size()==0) {
                resultEntity.setMsg("工序不能为空");
                return resultEntity;
            }else {
                for (WorkorderProcess workorderProcess:processList) {
                    if (!(StringUtils.isNoneBlank(workorderProcess.getProcessNumber())&&StringUtils.isNoneBlank(workorderProcess.getProcessDesc()))) {
                        resultEntity.setMsg("工序序号或工序描述不能为空");
                        return resultEntity;
                    }
                    workorderProcess.setProcessId(UUIdUtil.getUUID());
                    workorderProcess.setWorkorderId(workorderInfo.getOrderId());
                    workorderProcessMapper.insert(workorderProcess);
                }
            }

            //保存工单物资
            List<WorkorderMaterial> materialList = workorderVo.getWorkorderMaterialList();
            if (materialList!=null && materialList.size()!=0) {
                materialList.forEach(workorderMaterial -> {
                    workorderMaterial.setWorkorderMaterialId(UUIdUtil.getUUID());
                    workorderMaterial.setWorkorderId(workorderInfo.getOrderId());
                    workorderMaterialMapper.insert(workorderMaterial);
                });
            }
            //保存工单服务
            List<com.qz.zframe.maintain.entity.WorkorderService> serviceList = workorderVo.getWorkorderServiceList();
            if (serviceList!=null && serviceList.size()!=0) {
                serviceList.forEach(workorderService -> {
                    workorderService.setServiceId(UUIdUtil.getUUID());
                    workorderService.setWorkorderId(workorderInfo.getOrderId());
                    workorderServiceMapper.insert(workorderService);
                });
            }
            //保存工单工器具
            List<WorkorderTool> toolList = workorderVo.getWorkorderToolList();
            if (toolList!=null && toolList.size()!=0) {
                toolList.forEach(workorderTool -> {
                    workorderTool.setToolId(UUIdUtil.getUUID());
                    workorderTool.setWorkorderId(workorderInfo.getOrderId());
                    workorderToolMapper.insert(workorderTool);
                });
            }
            //保存工单工种
            List<WorkorderWorktype> worktypeList = workorderVo.getWorkorderWorktypeList();
            if (worktypeList!=null && worktypeList.size()!=0) {
                worktypeList.forEach(workorderWorktype -> {
                    workorderWorktype.setWorktypeId(UUIdUtil.getUUID());
                    workorderWorktype.setWorkorderId(workorderInfo.getOrderId());
                    workorderWorktypeMapper.insert(workorderWorktype);
                });
            }
            //保存工单质量验收
            WorkorderQualityAcceptance workorderQualityAcceptance = workorderVo.getWorkorderQualityAcceptance();
            if (workorderQualityAcceptance != null) {
                workorderQualityAcceptance.setQualityAcceptanceId(UUIdUtil.getUUID());
                workorderQualityAcceptance.setWorkorderId(workorderInfo.getOrderId());
                workorderQualityAcceptanceMapper.insert(workorderQualityAcceptance);
            }
            //保存工单危险点控制
            List<WorkorderDangerPoint> dangerPointList = workorderVo.getWorkorderDangerPointList();
            if (dangerPointList!=null && dangerPointList.size()!=0) {
                dangerPointList.forEach(workorderDangerPoint -> {
                    workorderDangerPoint.setDangerPointId(UUIdUtil.getUUID());
                    workorderDangerPoint.setWorkorderId(workorderInfo.getOrderId());
                    workorderDangerPointMapper.insert(workorderDangerPoint);
                });
            }
            //保存工单总结
            WorkorderSummary workorderSummary = workorderVo.getWorkorderSummary();
            if (workorderSummary!=null) {
                workorderSummary.setSummaryId(UUIdUtil.getUUID());
                workorderSummary.setWorkorderId(workorderInfo.getOrderId());
                workorderSummaryMapper.insert(workorderSummary);
            }
        }catch (ParseException e) {
            e.printStackTrace();
        }

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("添加成功");
        return resultEntity;
    }

    @Override
    public ResultEntity deleteWorkorder(String workorderIds) {
        ResultEntity resultEntity = new ResultEntity();

        if (!StringUtils.isNoneBlank(workorderIds)) {
            resultEntity.setMsg("ids不能为空");
            return resultEntity;
        }

        String[] ids = workorderIds.split(",");
        workorderInfoMapper.batchDelete(ids);

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("删除成功");
        return resultEntity;
    }

    @Override
    public ResultEntity updateWorkorder(WorkorderVo workorderVo) {
        ResultEntity resultEntity = new ResultEntity();

        if (!StringUtils.isNoneBlank(workorderVo.getOrderId())) {
            resultEntity.setMsg("工单id不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(workorderVo.getSerialNumber())) {
            resultEntity.setMsg("工单号不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(workorderVo.getMaintainer())) {
            resultEntity.setMsg("维护人不能为空");
            return resultEntity;
        }
        if (workorderVo.getMaintainDate()==null) {
            resultEntity.setMsg("维护日期不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(workorderVo.getWorkorderDesc())) {
            resultEntity.setMsg("工单描述不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(workorderVo.getWorkorderTypeId())) {
            resultEntity.setMsg("工单类型不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(workorderVo.getWindId())) {
            resultEntity.setMsg("风电场id不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(workorderVo.getCompany())) {
            resultEntity.setMsg("公司不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(workorderVo.getFillPerson())) {
            resultEntity.setMsg("填报人不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(workorderVo.getDutyHead())) {
            resultEntity.setMsg("负责人不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(workorderVo.getDutyTeam())) {
            resultEntity.setMsg("负责班组不能为空");
            return resultEntity;
        }

        //修改工单
        WorkorderInfo workorderInfo = new WorkorderInfo();
        BeanUtils.copyProperties(workorderVo,workorderInfo);
        workorderInfoMapper.updateByPrimaryKey(workorderInfo);
        //保存工序列表
        WorkorderProcessExample workorderProcessExample = new WorkorderProcessExample();
        workorderProcessExample.createCriteria().andOrderIdEqualTo(workorderVo.getOrderId());
        workorderProcessMapper.deleteByExample(workorderProcessExample);
        List<WorkorderProcess> processList = workorderVo.getWorkorderProcessList();
        if (processList==null || processList.size()==0) {
            resultEntity.setMsg("工序不能为空");
            return resultEntity;
        }else {
            for (WorkorderProcess workorderProcess:processList) {
                if (!(StringUtils.isNoneBlank(workorderProcess.getProcessNumber())&&StringUtils.isNoneBlank(workorderProcess.getProcessDesc()))) {
                    resultEntity.setMsg("工序序号或工序描述不能为空");
                    return resultEntity;
                }
                workorderProcess.setProcessId(UUIdUtil.getUUID());
                workorderProcess.setOrderId(workorderVo.getOrderId());
                workorderProcessMapper.insert(workorderProcess);
            }
        }

        //保存工单物资
        List<WorkorderMaterial> materialList = workorderVo.getWorkorderMaterialList();
        if (materialList!=null && materialList.size()!=0) {
            materialList.forEach(workorderMaterial -> {
                workorderMaterial.setWorkorderMaterialId(UUIdUtil.getUUID());
                workorderMaterial.setOrderId(workorderVo.getOrderId());
                workorderMaterialMapper.insert(workorderMaterial);
            });
        }
        //保存工单服务
        List<com.qz.zframe.maintain.entity.WorkorderService> serviceList = workorderVo.getWorkorderServiceList();
        if (serviceList!=null && serviceList.size()!=0) {
            serviceList.forEach(workorderService -> {
                workorderService.setServiceId(UUIdUtil.getUUID());
                workorderService.setWorkorderId(workorderVo.getOrderId());
                workorderServiceMapper.insert(workorderService);
            });
        }
        //保存工单工器具
        List<WorkorderTool> toolList = workorderVo.getWorkorderToolList();
        if (toolList!=null && toolList.size()!=0) {
            toolList.forEach(workorderTool -> {
                workorderTool.setToolId(UUIdUtil.getUUID());
                workorderTool.setWorkorderId(workorderVo.getOrderId());
                workorderToolMapper.insert(workorderTool);
            });
        }
        //保存工单工种
        List<WorkorderWorktype> worktypeList = workorderVo.getWorkorderWorktypeList();
        if (worktypeList!=null && worktypeList.size()!=0) {
            worktypeList.forEach(workorderWorktype -> {
                workorderWorktype.setWorktypeId(UUIdUtil.getUUID());
                workorderWorktype.setWorkorderId(workorderVo.getOrderId());
                workorderWorktypeMapper.insert(workorderWorktype);
            });
        }
        //保存工单质量验收
        WorkorderQualityAcceptance workorderQualityAcceptance = workorderVo.getWorkorderQualityAcceptance();
        if (workorderQualityAcceptance != null) {
            workorderQualityAcceptance.setQualityAcceptanceId(UUIdUtil.getUUID());
            workorderQualityAcceptance.setWorkorderId(workorderVo.getOrderId());
            workorderQualityAcceptanceMapper.insert(workorderQualityAcceptance);
        }
        //保存工单危险点控制
        List<WorkorderDangerPoint> dangerPointList = workorderVo.getWorkorderDangerPointList();
        if (dangerPointList!=null && dangerPointList.size()!=0) {
            dangerPointList.forEach(workorderDangerPoint -> {
                workorderDangerPoint.setDangerPointId(UUIdUtil.getUUID());
                workorderDangerPoint.setWorkorderId(workorderVo.getOrderId());
                workorderDangerPointMapper.insert(workorderDangerPoint);
            });
        }
        //保存工单总结
        WorkorderSummary workorderSummary = workorderVo.getWorkorderSummary();
        if (workorderSummary!=null) {
            workorderSummary.setSummaryId(UUIdUtil.getUUID());
            workorderSummary.setWorkorderId(workorderSummary.getOrderId());
            workorderSummaryMapper.insert(workorderSummary);
        }

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("修改成功");
        return resultEntity;
    }

    @Override
    public ResultEntity getWorkorderDetail(String orderId) {
        ResultEntity resultEntity = new ResultEntity();

        if (!StringUtils.isNoneBlank(orderId)) {
            resultEntity.setMsg("id不能为空");
            return resultEntity;
        }

        //获取工单主数据list
        WorkorderVo workorderVo = workorderInfoMapper.getWorkorderDetail(orderId);
        if (workorderVo!=null) {
            //获取工序list
            WorkorderProcessExample workorderProcessExample = new WorkorderProcessExample();
            workorderProcessExample.setOrderByClause("process_number");
            List<WorkorderProcess> processeList = workorderProcessMapper.selectByExample(workorderProcessExample);
            if (processeList!=null && processeList.size()!=0) {
                workorderVo.setWorkorderProcessList(processeList);
            }
            //获取物资list
            WorkorderMaterialExample workorderMaterialExample = new WorkorderMaterialExample();
            workorderMaterialExample.setOrderByClause("material_number");
            List<WorkorderMaterial> materialList = workorderMaterialMapper.selectByExample(workorderMaterialExample);
            if (materialList!=null && materialList.size()!=0) {
                workorderVo.setWorkorderMaterialList(materialList);
            }
            //获取服务list
            WorkorderServiceExample workorderServiceExample = new WorkorderServiceExample();
            workorderServiceExample.setOrderByClause("service_number");
            List<com.qz.zframe.maintain.entity.WorkorderService> serviceList = workorderServiceMapper.selectByExample(workorderServiceExample);
            if (serviceList!=null && serviceList.size()!=0) {
                workorderVo.setWorkorderServiceList(serviceList);
            }
            //获取工器具list
            WorkorderToolExample workorderToolExample = new WorkorderToolExample();
            workorderToolExample.setOrderByClause("tool_number");
            List<WorkorderTool> toolList = workorderToolMapper.selectByExample(workorderToolExample);
            if (toolList!=null && toolList.size()!=0) {
                workorderVo.setWorkorderToolList(toolList);
            }
            //获取工种list
            WorkorderWorktypeExample workorderWorktypeExample = new WorkorderWorktypeExample();
            workorderWorktypeExample.setOrderByClause("worktype_number");
            List<WorkorderWorktype> worktypeList = workorderWorktypeMapper.selectByExample(workorderWorktypeExample);
            if (worktypeList!=null && worktypeList.size()!=0) {
                workorderVo.setWorkorderWorktypeList(worktypeList);
            }
            //获取危险点list
            WorkorderDangerPointExample workorderDangerPointExample = new WorkorderDangerPointExample();
            workorderDangerPointExample.setOrderByClause("danger_number");
            List<WorkorderDangerPoint> dangerPointList = workorderDangerPointMapper.selectByExample(workorderDangerPointExample);
            if (dangerPointList!=null && dangerPointList.size()!=0) {
                workorderVo.setWorkorderDangerPointList(dangerPointList);
            }
        }

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("查询成功");
        resultEntity.setData(workorderVo);
        return resultEntity;
    }

    @Override
    public PageResultEntity getWorkorderList(Map<String, String> pageAndCondition) {
        PageResultEntity pageResultEntity = new PageResultEntity();
        pageResultEntity.setRows(new ArrayList());

        String start = String.valueOf((Integer.parseInt(pageAndCondition.get("pageNum"))-1)*(Integer.parseInt(pageAndCondition.get("pageSize"))));
        pageAndCondition.put("start",start);
        //获取工单主数据list
        List<WorkorderVo> workorderVoList = workorderInfoMapper.getWorkorderList(pageAndCondition);
        int total = workorderInfoMapper.getTotal(pageAndCondition);

        pageResultEntity.setCode(ErrorCode.SUCCESS);
        pageResultEntity.setMsg("查询成功");
        pageResultEntity.setRows(workorderVoList);
        pageResultEntity.setTotal(total);
        return pageResultEntity;
    }
}
