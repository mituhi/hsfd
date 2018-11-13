package com.qz.zframe.maintain.service.Impl;

import com.qz.zframe.authentication.CurrentUserService;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.common.util.UUIdUtil;
import com.qz.zframe.maintain.entity.*;
import com.qz.zframe.maintain.mapper.*;
import com.qz.zframe.maintain.service.DefectWorkorderService;
import com.qz.zframe.maintain.vo.DefectWorkorderVo;
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
public class DefectWorkorderServiceImpl implements DefectWorkorderService {

    @Autowired
    private CurrentUserService currentUserService;

    @Autowired
    private DefectWorkorderMapper defectWorkorderMapper;

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
    public ResultEntity addDefectWorkorder(DefectWorkorderVo defectWorkorderVo) {
        ResultEntity resultEntity = new ResultEntity();

        try{
            if (StringUtils.isNoneBlank(defectWorkorderVo.getWorkorderId())
                    && defectWorkorderMapper.selectByPrimaryKey(defectWorkorderVo.getWorkorderId()) !=null) {
                    return this.updateDefectWorkorder(defectWorkorderVo);
            }

            if (!StringUtils.isNoneBlank(defectWorkorderVo.getMaintainer())) {
                resultEntity.setMsg("维护人不能为空");
                return resultEntity;
            }
            if (defectWorkorderVo.getMaintainDate()==null) {
                resultEntity.setMsg("维护日期不能为空");
                return resultEntity;
            }
            if (!StringUtils.isNoneBlank(defectWorkorderVo.getWorkorderDesc())) {
                resultEntity.setMsg("工单描述不能为空");
                return resultEntity;
            }
            if (!StringUtils.isNoneBlank(defectWorkorderVo.getWorkorderTypeId())) {
                resultEntity.setMsg("工单类型id不能为空");
                return resultEntity;
            }
            if (!StringUtils.isNoneBlank(defectWorkorderVo.getWindId())) {
                resultEntity.setMsg("风电场id不能为空");
                return resultEntity;
            }
            if (!StringUtils.isNoneBlank(defectWorkorderVo.getCompany())) {
                resultEntity.setMsg("公司不能为空");
                return resultEntity;
            }
            if (!StringUtils.isNoneBlank(defectWorkorderVo.getDutyTeam())) {
                resultEntity.setMsg("负责班组不能为空");
                return resultEntity;
            }
            if (!StringUtils.isNoneBlank(defectWorkorderVo.getDutyHead())) {
                resultEntity.setMsg("负责人不能为空");
                return resultEntity;
            }
            if (!StringUtils.isNoneBlank(defectWorkorderVo.getFillPerson())) {
                resultEntity.setMsg("填报人不能为空");
                return resultEntity;
            }
            if (!StringUtils.isNoneBlank(defectWorkorderVo.getPositionId())) {
                resultEntity.setMsg("位置id不能为空");
                return resultEntity;
            }
            if (!StringUtils.isNoneBlank(defectWorkorderVo.getBreakdownDesc())) {
                resultEntity.setMsg("故障描述不能为空");
                return resultEntity;
            }
            if (defectWorkorderVo.getActiveTime()==null) {
                resultEntity.setMsg("故障激活时间不能为空");
                return resultEntity;
            }
            if (!StringUtils.isNoneBlank(defectWorkorderVo.getBreakdownLocation())) {
                resultEntity.setMsg("故障位置不能为空");
                return resultEntity;
            }
            if (!StringUtils.isNoneBlank(defectWorkorderVo.getBreakdownAttribute())) {
                resultEntity.setMsg("故障属性不能为空");
                return resultEntity;
            }
            if (!StringUtils.isNoneBlank(defectWorkorderVo.getPhenomenon())) {
                resultEntity.setMsg("故障现象不能为空");
                return resultEntity;
            }
            if (!StringUtils.isNoneBlank(defectWorkorderVo.getDealMode())) {
                resultEntity.setMsg("处理方式不能为空");
                return resultEntity;
            }
            if (!StringUtils.isNoneBlank(defectWorkorderVo.getDefectAnalysis())) {
                resultEntity.setMsg("缺陷分析不能为空");
                return resultEntity;
            }

            //保存缺陷工单
            DefectWorkorder defectWorkorder = new DefectWorkorder();
            BeanUtils.copyProperties(defectWorkorderVo, defectWorkorder);
            defectWorkorder.setWorkorderId(UUIdUtil.getUUID());
            defectWorkorder.setSerialNumber(String.valueOf(defectWorkorderMapper.countByExample(new DefectWorkorderExample())+1));
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date fillTime = simpleDateFormat.parse(simpleDateFormat.format(new Date()));
            defectWorkorder.setFillTime(fillTime);
            defectWorkorderMapper.insert(defectWorkorder);
            //保存工序列表
            List<WorkorderProcess> processList = defectWorkorderVo.getWorkorderProcessList();
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
                    workorderProcess.setWorkorderId(defectWorkorder.getWorkorderId());
                    workorderProcessMapper.insert(workorderProcess);
                }
            }
            //保存工单物资
            List<WorkorderMaterial> materialList = defectWorkorderVo.getWorkorderMaterialList();
            if (materialList!=null && materialList.size()!=0) {
                materialList.forEach(workorderMaterial -> {
                    workorderMaterial.setWorkorderMaterialId(UUIdUtil.getUUID());
                    workorderMaterial.setWorkorderId(defectWorkorder.getWorkorderId());
                    workorderMaterialMapper.insert(workorderMaterial);
                });
            }
            //保存工单服务
            List<WorkorderService> serviceList = defectWorkorderVo.getWorkorderServiceList();
            if (serviceList!=null && serviceList.size()!=0) {
                serviceList.forEach(workorderService -> {
                    workorderService.setServiceId(UUIdUtil.getUUID());
                    workorderService.setWorkorderId(defectWorkorder.getWorkorderId());
                    workorderServiceMapper.insert(workorderService);
                });
            }
            //保存工单工器具
            List<WorkorderTool> toolList = defectWorkorderVo.getWorkorderToolList();
            if (toolList!=null && toolList.size()!=0) {
                toolList.forEach(workorderTool -> {
                    workorderTool.setToolId(UUIdUtil.getUUID());
                    workorderTool.setWorkorderId(defectWorkorder.getWorkorderId());
                    workorderToolMapper.insert(workorderTool);
                });
            }
            //保存工单工种
            List<WorkorderWorktype> worktypeList = defectWorkorderVo.getWorkorderWorktypeList();
            if (worktypeList!=null && worktypeList.size()!=0) {
                worktypeList.forEach(workorderWorktype -> {
                    workorderWorktype.setWorktypeId(UUIdUtil.getUUID());
                    workorderWorktype.setWorkorderId(defectWorkorder.getWorkorderId());
                    workorderWorktypeMapper.insert(workorderWorktype);
                });
            }
            //保存工单质量验收
            WorkorderQualityAcceptance workorderQualityAcceptance = defectWorkorderVo.getWorkorderQualityAcceptance();
            if (workorderQualityAcceptance!=null) {
                workorderQualityAcceptance.setQualityAcceptanceId(UUIdUtil.getUUID());
                workorderQualityAcceptance.setWorkorderId(defectWorkorder.getWorkorderId());
                workorderQualityAcceptanceMapper.insert(workorderQualityAcceptance);
            }
            //保存工单危险点控制
            List<WorkorderDangerPoint> dangerPointList = defectWorkorderVo.getWorkorderDangerPointList();
            if (dangerPointList!=null && dangerPointList.size()!=0) {
                dangerPointList.forEach(workorderDangerPoint -> {
                    workorderDangerPoint.setDangerPointId(UUIdUtil.getUUID());
                    workorderDangerPoint.setWorkorderId(defectWorkorder.getWorkorderId());
                    workorderDangerPointMapper.insert(workorderDangerPoint);
                });
            }
            //保存工单总结
            WorkorderSummary workorderSummary = defectWorkorderVo.getWorkorderSummary();
            if (workorderSummary!=null) {
                workorderSummary.setSummaryId(UUIdUtil.getUUID());
                workorderSummary.setWorkorderId(defectWorkorder.getWorkorderId());
                workorderSummaryMapper.insert(workorderSummary);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("保存成功");
        return resultEntity;
    }

    @Override
    public ResultEntity deleteDefectWorkorder(String workorderIds) {
        ResultEntity resultEntity = new ResultEntity();

        if (!StringUtils.isNoneBlank(workorderIds)) {
            resultEntity.setMsg("ids不能为空");
            return resultEntity;
        }

        String[] ids = workorderIds.split(",");
        defectWorkorderMapper.batchDelete(ids);

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("删除成功");
        return resultEntity;
    }

    @Override
    public ResultEntity updateDefectWorkorder(DefectWorkorderVo defectWorkorderVo) {
        ResultEntity resultEntity = new ResultEntity();

        if (!StringUtils.isNoneBlank(defectWorkorderVo.getWorkorderId())) {
            resultEntity.setMsg("工单id不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(defectWorkorderVo.getSerialNumber())) {
            resultEntity.setMsg("工单号不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(defectWorkorderVo.getMaintainer())) {
            resultEntity.setMsg("维护人不能为空");
            return resultEntity;
        }
        if (defectWorkorderVo.getMaintainDate()==null) {
            resultEntity.setMsg("维护日期不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(defectWorkorderVo.getWorkorderDesc())) {
            resultEntity.setMsg("工单描述不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(defectWorkorderVo.getWorkorderTypeId())) {
            resultEntity.setMsg("工单类型id不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(defectWorkorderVo.getWindId())) {
            resultEntity.setMsg("风电场id不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(defectWorkorderVo.getCompany())) {
            resultEntity.setMsg("公司不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(defectWorkorderVo.getDutyTeam())) {
            resultEntity.setMsg("负责班组不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(defectWorkorderVo.getDutyHead())) {
            resultEntity.setMsg("负责人不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(defectWorkorderVo.getFillPerson())) {
            resultEntity.setMsg("填报人不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(defectWorkorderVo.getPositionId())) {
            resultEntity.setMsg("位置id不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(defectWorkorderVo.getBreakdownDesc())) {
            resultEntity.setMsg("故障描述不能为空");
            return resultEntity;
        }
        if (defectWorkorderVo.getActiveTime()==null) {
            resultEntity.setMsg("故障激活时间不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(defectWorkorderVo.getBreakdownLocation())) {
            resultEntity.setMsg("故障位置不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(defectWorkorderVo.getBreakdownAttribute())) {
            resultEntity.setMsg("故障属性不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(defectWorkorderVo.getPhenomenon())) {
            resultEntity.setMsg("故障现象不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(defectWorkorderVo.getDealMode())) {
            resultEntity.setMsg("处理方式不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(defectWorkorderVo.getDefectAnalysis())) {
            resultEntity.setMsg("缺陷分析不能为空");
            return resultEntity;
        }
        //修改缺陷工单
        DefectWorkorder defectWorkorder = new DefectWorkorderVo();
        BeanUtils.copyProperties(defectWorkorderVo, defectWorkorder);
        defectWorkorderMapper.updateByPrimaryKey(defectWorkorder);
        //删除表中原有记录,保存工序
        WorkorderProcessExample workorderProcessExample = new WorkorderProcessExample();
        workorderProcessExample.createCriteria().andWorkorderIdEqualTo(defectWorkorderVo.getWorkorderId());
        workorderProcessMapper.deleteByExample(workorderProcessExample);
        List<WorkorderProcess> processList = defectWorkorderVo.getWorkorderProcessList();
        if (processList==null ||processList.size()==0) {
            resultEntity.setMsg("工序不能为空");
            return resultEntity;
        }else {
            for (WorkorderProcess workorderProcess:processList) {
                if (!(StringUtils.isNoneBlank(workorderProcess.getProcessNumber())&&StringUtils.isNoneBlank(workorderProcess.getProcessDesc()))) {
                    resultEntity.setMsg("工序序号或工序描述不能为空");
                    return resultEntity;
                }
                workorderProcess.setProcessId(UUIdUtil.getUUID());
                workorderProcess.setWorkorderId(defectWorkorderVo.getWorkorderId());
                workorderProcessMapper.insert(workorderProcess);
            }
        }
        //删除表中原有记录,保存工单物资
        WorkorderMaterialExample workorderMaterialExample = new WorkorderMaterialExample();
        workorderMaterialExample.createCriteria().andWorkorderIdEqualTo(defectWorkorderVo.getWorkorderId());
        workorderMaterialMapper.deleteByExample(workorderMaterialExample);
        List<WorkorderMaterial> materialList = defectWorkorderVo.getWorkorderMaterialList();
        if (materialList!=null && materialList.size()!=0) {
            materialList.forEach(workorderMaterial -> {
                workorderMaterial.setWorkorderMaterialId(UUIdUtil.getUUID());
                workorderMaterial.setWorkorderId(defectWorkorderVo.getWorkorderId());
                workorderMaterialMapper.insert(workorderMaterial);
            });
        }
        //删除表中原有记录,保存工单服务
        WorkorderServiceExample workorderServiceExample = new WorkorderServiceExample();
        workorderServiceExample.createCriteria().andWorkorderIdEqualTo(defectWorkorderVo.getWorkorderId());
        workorderServiceMapper.deleteByExample(workorderServiceExample);
        List<WorkorderService> serviceList = defectWorkorderVo.getWorkorderServiceList();
        if (serviceList!=null && serviceList.size()!=0) {
            serviceList.forEach(workorderService -> {
                workorderService.setServiceId(UUIdUtil.getUUID());
                workorderService.setWorkorderId(defectWorkorderVo.getWorkorderId());
                workorderServiceMapper.insert(workorderService);
            });
        }
        //删除表中原有记录,保存工单工器具
        WorkorderToolExample workorderToolExample = new WorkorderToolExample();
        workorderToolExample.createCriteria().andWorkorderIdEqualTo(defectWorkorderVo.getWorkorderId());
        workorderToolMapper.deleteByExample(workorderToolExample);
        List<WorkorderTool> toolList = defectWorkorderVo.getWorkorderToolList();
        if (toolList!=null && toolList.size()!=0) {
            toolList.forEach(workorderTool -> {
                workorderTool.setToolId(UUIdUtil.getUUID());
                workorderTool.setWorkorderId(defectWorkorderVo.getWorkorderId());
                workorderToolMapper.insert(workorderTool);
            });
        }
        //删除表中原有记录,保存工单工种
        WorkorderWorktypeExample workorderWorktypeExample = new WorkorderWorktypeExample();
        workorderWorktypeExample.createCriteria().andWorkorderIdEqualTo(defectWorkorderVo.getWorkorderId());
        workorderWorktypeMapper.deleteByExample(workorderWorktypeExample);
        List<WorkorderWorktype> worktypeList = defectWorkorderVo.getWorkorderWorktypeList();
        if (worktypeList!=null && worktypeList.size()!=0) {
            worktypeList.forEach(workorderWorktype -> {
                workorderWorktype.setWorktypeId(UUIdUtil.getUUID());
                workorderWorktype.setWorkorderId(defectWorkorderVo.getWorkorderId());
                workorderWorktypeMapper.insert(workorderWorktype);
            });
        }
        //修改工单质量验收
        WorkorderQualityAcceptance workorderQualityAcceptance = new WorkorderQualityAcceptance();
        if (!StringUtils.isNoneBlank(defectWorkorderVo.getWorkorderQualityAcceptance().getQualityAcceptanceId())) {
            workorderQualityAcceptance.setQualityAcceptanceId(UUIdUtil.getUUID());
            workorderQualityAcceptance.setWorkorderId(defectWorkorder.getWorkorderId());
            workorderQualityAcceptanceMapper.insert(workorderQualityAcceptance);
        }else {
            BeanUtils.copyProperties(defectWorkorderVo.getWorkorderQualityAcceptance(),workorderQualityAcceptance);
            workorderQualityAcceptanceMapper.updateByPrimaryKey(workorderQualityAcceptance);
        }
        //删除表中原有记录,保存工单危险点控制
        WorkorderDangerPointExample workorderDangerPointExample = new WorkorderDangerPointExample();
        workorderDangerPointExample.createCriteria().andWorkorderIdEqualTo(defectWorkorderVo.getWorkorderId());
        workorderDangerPointMapper.deleteByExample(workorderDangerPointExample);
        List<WorkorderDangerPoint> dangerPointList = defectWorkorderVo.getWorkorderDangerPointList();
        if (dangerPointList!=null && dangerPointList.size()!=0) {
            dangerPointList.forEach(workorderDangerPoint -> {
                workorderDangerPoint.setDangerPointId(UUIdUtil.getUUID());
                workorderDangerPoint.setWorkorderId(defectWorkorderVo.getWorkorderId());
                workorderDangerPointMapper.insert(workorderDangerPoint);
            });
        }
        //修改工单总结
        WorkorderSummary workorderSummary = new WorkorderSummary();
        if (!StringUtils.isNoneBlank(defectWorkorderVo.getWorkorderSummary().getWorkorderId())) {
            workorderSummary.setSummaryId(UUIdUtil.getUUID());
            workorderSummary.setWorkorderId(defectWorkorder.getWorkorderId());
            workorderSummaryMapper.insert(workorderSummary);
        }else {
            BeanUtils.copyProperties(defectWorkorderVo.getWorkorderSummary(),workorderSummary);
            workorderSummaryMapper.updateByPrimaryKey(workorderSummary);
        }

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("保存成功");
        return resultEntity;
    }

    @Override
    public ResultEntity getDefectWorkorderDetail(String workorderId) {
        ResultEntity resultEntity = new ResultEntity();

        if (!StringUtils.isNoneBlank(workorderId)) {
            resultEntity.setMsg("id不能为空");
            return resultEntity;
        }

        //获取缺陷工单主数据
        DefectWorkorderVo defectWorkorderVo = defectWorkorderMapper.getDefectWorkorderDetail(workorderId);
        if (defectWorkorderVo!=null) {
            //获取工序list
            WorkorderProcessExample workorderProcessExample = new WorkorderProcessExample();
            workorderProcessExample.setOrderByClause("process_number");
            List<WorkorderProcess> processeList = workorderProcessMapper.selectByExample(workorderProcessExample);
            System.out.println(processeList);
            if (processeList!=null && processeList.size()!=0) {
                processeList.forEach(workorderProcess -> {
                    defectWorkorderVo.getWorkorderProcessList().add(workorderProcess);
                });
            }
            //获取物资list
            WorkorderMaterialExample workorderMaterialExample = new WorkorderMaterialExample();
            workorderMaterialExample.setOrderByClause("material_number");
            List<WorkorderMaterial> materialList = workorderMaterialMapper.selectByExample(workorderMaterialExample);
            if (materialList!=null && materialList.size()!=0) {
                materialList.forEach(workorderMaterial -> {
                    defectWorkorderVo.getWorkorderMaterialList().add(workorderMaterial);
                });
            }
            //获取服务list
            WorkorderServiceExample workorderServiceExample = new WorkorderServiceExample();
            workorderServiceExample.setOrderByClause("service_number");
            List<WorkorderService> serviceList = workorderServiceMapper.selectByExample(workorderServiceExample);
            if (serviceList!=null && serviceList.size()!=0) {
                serviceList.forEach(workorderService -> {
                    defectWorkorderVo.getWorkorderServiceList().add(workorderService);
                });
            }
            //获取工器具list
            WorkorderToolExample workorderToolExample = new WorkorderToolExample();
            workorderToolExample.setOrderByClause("tool_number");
            List<WorkorderTool> toolList = workorderToolMapper.selectByExample(workorderToolExample);
            if (toolList!=null && toolList.size()!=0) {
                toolList.forEach(workorderTool -> {
                    defectWorkorderVo.getWorkorderToolList().add(workorderTool);
                });
            }
            //获取工种list
            WorkorderWorktypeExample workorderWorktypeExample = new WorkorderWorktypeExample();
            workorderWorktypeExample.setOrderByClause("worktype_number");
            List<WorkorderWorktype> worktypeList = workorderWorktypeMapper.selectByExample(workorderWorktypeExample);
            if (worktypeList!=null && worktypeList.size()!=0) {
                worktypeList.forEach(workorderWorktype -> {
                    defectWorkorderVo.getWorkorderWorktypeList().add(workorderWorktype);
                });
            }
            //获取危险点list
            WorkorderDangerPointExample workorderDangerPointExample = new WorkorderDangerPointExample();
            workorderDangerPointExample.setOrderByClause("danger_number");
            List<WorkorderDangerPoint> dangerPointList = workorderDangerPointMapper.selectByExample(workorderDangerPointExample);
            if (dangerPointList!=null && dangerPointList.size()!=0) {
                dangerPointList.forEach(workorderDangerPoint -> {
                    defectWorkorderVo.getWorkorderDangerPointList().add(workorderDangerPoint);
                });
            }
        }

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("查询成功");
        resultEntity.setData(defectWorkorderVo);
        return resultEntity;
    }

    @Override
    public PageResultEntity getDefectWorkorderList(Map<String, String> pageAndCondition) {
        PageResultEntity pageResultEntity = new PageResultEntity();
        pageResultEntity.setRows(new ArrayList());

        String start = String.valueOf((Integer.parseInt(pageAndCondition.get("pageNum"))-1)*(Integer.parseInt(pageAndCondition.get("pageSize"))));
        pageAndCondition.put("start",start);
        //获取缺陷工单主数据列表
        List<DefectWorkorderVo> defectWorkorderVoList = defectWorkorderMapper.getDefectWorkorderListByPageAndCondition(pageAndCondition);
        int total = defectWorkorderMapper.getTotal(pageAndCondition);

        pageResultEntity.setCode(ErrorCode.SUCCESS);
        pageResultEntity.setMsg("查询成功");
        pageResultEntity.setRows(defectWorkorderVoList);
        pageResultEntity.setTotal(total);
        return pageResultEntity;
    }
}
