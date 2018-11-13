package com.qz.zframe.maintain.service.Impl;

import com.qz.zframe.authentication.CurrentUserService;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.common.util.UUIdUtil;
import com.qz.zframe.maintain.entity.*;
import com.qz.zframe.maintain.mapper.*;
import com.qz.zframe.maintain.service.BreakdownKnowledgeService;
import com.qz.zframe.maintain.vo.KnowledgeVo;
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
public class BreakdownKnowledgeServiceImpl implements BreakdownKnowledgeService {

    @Autowired
    private CurrentUserService currentUserService;

    @Autowired
    private BreakdownKnowledgeBaseMapper breakdownKnowledgeBaseMapper;

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
    private WorkorderDangerPointMapper workorderDangerPointMapper;

    @Override
    public ResultEntity createBreakdownKnowledge() {
        ResultEntity resultEntity = new ResultEntity();

        BreakdownKnowledgeBase breakdownKnowledgeBase = new BreakdownKnowledgeBase();
        breakdownKnowledgeBase.setKnowledgeId(UUIdUtil.getUUID());
        String serialNumber = String.valueOf(breakdownKnowledgeBaseMapper.countByExample(new BreakdownKnowledgeBaseExample())+1);
        breakdownKnowledgeBase.setSerialNumber(serialNumber);
        breakdownKnowledgeBase.setStatus("开始");
        breakdownKnowledgeBaseMapper.insert(breakdownKnowledgeBase);

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("创建成功");
        resultEntity.setData(breakdownKnowledgeBase);
        return resultEntity;
    }

    @Override
    public ResultEntity addBreakdownKnowledge(KnowledgeVo knowledgeVo) {
        ResultEntity resultEntity = new ResultEntity();

        try {
            if (StringUtils.isNoneBlank(knowledgeVo.getKnowledgeId())
                    && breakdownKnowledgeBaseMapper.selectByPrimaryKey(knowledgeVo.getKnowledgeId()) != null) {
                return this.updateBreakdownKnowledge(knowledgeVo);
            }

            String knowledgeId = UUIdUtil.getUUID();
            String serialNumber = String.valueOf(breakdownKnowledgeBaseMapper.countByExample(new BreakdownKnowledgeBaseExample()) + 1);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date applyTime = simpleDateFormat.parse(simpleDateFormat.format(new Date()));

            if (!StringUtils.isNoneBlank(knowledgeVo.getMaintainer())) {
                resultEntity .setMsg("维护人不能为空");
                return resultEntity;
            }
            if (knowledgeVo.getMaintainDate()==null) {
                resultEntity .setMsg("维护人不能为空");
                return resultEntity;
            }
            if (!StringUtils.isNoneBlank(knowledgeVo.getBreakdownLocation())) {
                resultEntity .setMsg("故障位置id不能为空");
                return resultEntity;
            }
            if (!StringUtils.isNoneBlank(knowledgeVo.getBreakdownAttribute())) {
                resultEntity .setMsg("故障属性id不能为空");
                return resultEntity;
            }
            if (!StringUtils.isNoneBlank(knowledgeVo.getWindId())) {
                resultEntity .setMsg("风电场id");
                return resultEntity;
            }
            if (!StringUtils.isNoneBlank(knowledgeVo.getSerialNumber())) {
                resultEntity .setMsg("故障知识编码不能为空");
                return resultEntity;
            }
            if (!StringUtils.isNoneBlank(knowledgeVo.getApplicant())) {
                resultEntity .setMsg("申请人不能为空");
                return resultEntity;
            }
            if (!StringUtils.isNoneBlank(knowledgeVo.getBreakdownDesc())) {
                resultEntity .setMsg("故障现象不能为空");
                return resultEntity;
            }
            if (!StringUtils.isNoneBlank(knowledgeVo.getBreakdownCode())) {
                resultEntity .setMsg("故障代码不能为空");
                return resultEntity;
            }
            if (!StringUtils.isNoneBlank(knowledgeVo.getDefectPhenomenon())) {
                resultEntity .setMsg("缺陷现象不能为空");
                return resultEntity;
            }
            if (!StringUtils.isNoneBlank(knowledgeVo.getCauseAnalysis())) {
                resultEntity .setMsg("原因分析不能为空");
                return resultEntity;
            }
            if (!StringUtils.isNoneBlank(knowledgeVo.getRepairProcessDesc())) {
                resultEntity .setMsg("处理过程描述不能为空");
                return resultEntity;
            }
            if (!StringUtils.isNoneBlank(knowledgeVo.getSolution())) {
                resultEntity .setMsg("解决方案不能为空");
                return resultEntity;
            }

            BreakdownKnowledgeBase breakdownKnowledgeBase = new BreakdownKnowledgeBase();
            BeanUtils.copyProperties(knowledgeVo,breakdownKnowledgeBase);
            breakdownKnowledgeBase.setKnowledgeId(knowledgeId);
            breakdownKnowledgeBase.setSerialNumber(serialNumber);
            breakdownKnowledgeBase.setApplyTime(applyTime);
            breakdownKnowledgeBaseMapper.insert(breakdownKnowledgeBase);
            //若工序符合条件,存入工序表中
            List<WorkorderProcess> processList = knowledgeVo.getWorkorderProcessList();
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
                    workorderProcess.setWorkorderId(knowledgeId);
                    workorderProcessMapper.insert(workorderProcess);
                }
            }
            //保存物资
            List<WorkorderMaterial> materialList = knowledgeVo.getWorkorderMaterialList();
            if (materialList!=null && materialList.size()!=0) {
                materialList.forEach(workorderMaterial -> {
                    workorderMaterial.setWorkorderMaterialId(UUIdUtil.getUUID());
                    workorderMaterial.setWorkorderId(knowledgeId);
                    workorderMaterialMapper.insert(workorderMaterial);
                });
            }
            //保存服务
            List<WorkorderService> serviceList = knowledgeVo.getWorkorderServiceList();
            if (serviceList!=null && serviceList.size()!=0) {
                serviceList.forEach(workorderService -> {
                    workorderService.setServiceId(UUIdUtil.getUUID());
                    workorderService.setWorkorderId(knowledgeId);
                    workorderServiceMapper.insert(workorderService);
                });
            }
            //保存工单工器具
            List<WorkorderTool> toolList = knowledgeVo.getWorkorderToolList();
            if (toolList!=null && toolList.size()!=0) {
                toolList.forEach(workorderTool -> {
                    workorderTool.setToolId(UUIdUtil.getUUID());
                    workorderTool.setWorkorderId(knowledgeId);
                    workorderToolMapper.insert(workorderTool);
                });
            }
            //保存工单工种
            List<WorkorderWorktype> worktypeList = knowledgeVo.getWorkorderWorktypeList();
            if (worktypeList!=null && worktypeList.size()!=0) {
                worktypeList.forEach(workorderWorktype -> {
                    workorderWorktype.setWorktypeId(UUIdUtil.getUUID());
                    workorderWorktype.setWorkorderId(knowledgeId);
                    workorderWorktypeMapper.insert(workorderWorktype);
                });
            }
            //保存工单危险点控制
            List<WorkorderDangerPoint> dangerPointList = knowledgeVo.getWorkorderDangerPointList();
            if (dangerPointList!=null && dangerPointList.size()!=0) {
                dangerPointList.forEach(workorderDangerPoint -> {
                    workorderDangerPoint.setDangerPointId(UUIdUtil.getUUID());
                    workorderDangerPoint.setWorkorderId(knowledgeId);
                    workorderDangerPointMapper.insert(workorderDangerPoint);
                });
            }
        }catch (ParseException e) {
            e.printStackTrace();
        }

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("添加成功");
        return resultEntity;
    }

    @Override
    public ResultEntity deleteBreakdownKnowledge(String knowledgeIds) {
        ResultEntity resultEntity = new ResultEntity();

        if (!StringUtils.isNoneBlank(knowledgeIds)) {
            resultEntity.setMsg("ids不能为空");
            return resultEntity;
        }

        String[] ids = knowledgeIds.split(",");
        breakdownKnowledgeBaseMapper.batchDelete(ids);

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("删除成功");
        return resultEntity;
    }

    @Override
    public ResultEntity updateBreakdownKnowledge(KnowledgeVo knowledgeVo) {
        ResultEntity resultEntity = new ResultEntity();

        if (!StringUtils.isNoneBlank(knowledgeVo.getKnowledgeId())) {
            resultEntity .setMsg("故障知识id不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(knowledgeVo.getSerialNumber())) {
            resultEntity .setMsg("故障知识编码(流水号)不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(knowledgeVo.getMaintainer())) {
            resultEntity .setMsg("维护人不能为空");
            return resultEntity;
        }
        if (knowledgeVo.getMaintainDate()==null) {
            resultEntity .setMsg("维护人不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(knowledgeVo.getBreakdownLocation())) {
            resultEntity .setMsg("故障位置id不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(knowledgeVo.getBreakdownAttribute())) {
            resultEntity .setMsg("故障属性id不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(knowledgeVo.getWindId())) {
            resultEntity .setMsg("风电场id");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(knowledgeVo.getSerialNumber())) {
            resultEntity .setMsg("故障知识编码不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(knowledgeVo.getApplicant())) {
            resultEntity .setMsg("申请人不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(knowledgeVo.getBreakdownDesc())) {
            resultEntity .setMsg("故障现象不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(knowledgeVo.getBreakdownCode())) {
            resultEntity .setMsg("故障代码不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(knowledgeVo.getDefectPhenomenon())) {
            resultEntity .setMsg("缺陷现象不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(knowledgeVo.getCauseAnalysis())) {
            resultEntity .setMsg("原因分析不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(knowledgeVo.getRepairProcessDesc())) {
            resultEntity .setMsg("处理过程描述不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(knowledgeVo.getSolution())) {
            resultEntity .setMsg("解决方案不能为空");
            return resultEntity;
        }

        BreakdownKnowledgeBase breakdownKnowledgeBase = new BreakdownKnowledgeBase();
        BeanUtils.copyProperties(knowledgeVo,breakdownKnowledgeBase);
        breakdownKnowledgeBaseMapper.updateByPrimaryKey(breakdownKnowledgeBase);
        //若工序符合条件,存入工序表中
        WorkorderProcessExample workorderProcessExample = new WorkorderProcessExample();
        workorderProcessExample.createCriteria().andKnowledgeIdEqualTo(knowledgeVo.getKnowledgeId());
        workorderProcessMapper.deleteByExample(workorderProcessExample);
        List<WorkorderProcess> processList = knowledgeVo.getWorkorderProcessList();
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
                workorderProcess.setWorkorderId(knowledgeVo.getKnowledgeId());
                workorderProcessMapper.insert(workorderProcess);
            }
        }
        //保存物资
        WorkorderMaterialExample workorderMaterialExample = new WorkorderMaterialExample();
        workorderMaterialExample.createCriteria().andKnowledgeIdEqualTo(knowledgeVo.getKnowledgeId());
        workorderMaterialMapper.deleteByExample(workorderMaterialExample);
        List<WorkorderMaterial> materialList = knowledgeVo.getWorkorderMaterialList();
        if (materialList!=null && materialList.size()!=0) {
            materialList.forEach(workorderMaterial -> {
                workorderMaterial.setWorkorderMaterialId(UUIdUtil.getUUID());
                workorderMaterial.setWorkorderId(knowledgeVo.getKnowledgeId());
                workorderMaterialMapper.insert(workorderMaterial);
            });
        }
        //保存服务
        WorkorderServiceExample workorderServiceExample = new WorkorderServiceExample();
        workorderServiceExample.createCriteria().andKnowledgeIdEqualTo(knowledgeVo.getKnowledgeId());
        workorderServiceMapper.deleteByExample(workorderServiceExample);
        List<WorkorderService> serviceList = knowledgeVo.getWorkorderServiceList();
        if (serviceList!=null && serviceList.size()!=0) {
            serviceList.forEach(workorderService -> {
                workorderService.setServiceId(UUIdUtil.getUUID());
                workorderService.setWorkorderId(knowledgeVo.getKnowledgeId());
                workorderServiceMapper.insert(workorderService);
            });
        }
        //保存工单工器具
        WorkorderToolExample workorderToolExample = new WorkorderToolExample();
        workorderToolExample.createCriteria().andKnowledgeIdEqualTo(knowledgeVo.getKnowledgeId());
        workorderToolMapper.deleteByExample(workorderToolExample);
        List<WorkorderTool> toolList = knowledgeVo.getWorkorderToolList();
        if (toolList!=null && toolList.size()!=0) {
            toolList.forEach(workorderTool -> {
                workorderTool.setToolId(UUIdUtil.getUUID());
                workorderTool.setWorkorderId(knowledgeVo.getKnowledgeId());
                workorderToolMapper.insert(workorderTool);
            });
        }
        //保存工单工种
        WorkorderWorktypeExample workorderWorktypeExample = new WorkorderWorktypeExample();
        workorderWorktypeExample.createCriteria().andKnowledgeIdEqualTo(knowledgeVo.getKnowledgeId());
        workorderWorktypeMapper.deleteByExample(workorderWorktypeExample);
        List<WorkorderWorktype> worktypeList = knowledgeVo.getWorkorderWorktypeList();
        if (worktypeList!=null && worktypeList.size()!=0) {
            worktypeList.forEach(workorderWorktype -> {
                workorderWorktype.setWorktypeId(UUIdUtil.getUUID());
                workorderWorktype.setWorkorderId(knowledgeVo.getKnowledgeId());
                workorderWorktypeMapper.insert(workorderWorktype);
            });
        }
        //保存工单危险点控制
        WorkorderDangerPointExample workorderDangerPointExample = new WorkorderDangerPointExample();
        workorderDangerPointExample.createCriteria().andKnowledgeIdEqualTo(knowledgeVo.getKnowledgeId());
        workorderDangerPointMapper.deleteByExample(workorderDangerPointExample);
        List<WorkorderDangerPoint> dangerPointList = knowledgeVo.getWorkorderDangerPointList();
        if (dangerPointList!=null && dangerPointList.size()!=0) {
            dangerPointList.forEach(workorderDangerPoint -> {
                workorderDangerPoint.setDangerPointId(UUIdUtil.getUUID());
                workorderDangerPoint.setWorkorderId(knowledgeVo.getKnowledgeId());
                workorderDangerPointMapper.insert(workorderDangerPoint);
            });
        }

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("修改成功");
        return resultEntity;
    }

    @Override
    public ResultEntity getBreakdownKnowledgeDetail(String knowledgeId) {
        ResultEntity resultEntity = new ResultEntity();

        if (!StringUtils.isNoneBlank(knowledgeId)) {
            resultEntity.setMsg("id不能为空");
            return resultEntity;
        }
        KnowledgeVo knowledgeVo = breakdownKnowledgeBaseMapper.getBreakdownKnowledgeDetail(knowledgeId);

        //获取工序list
        WorkorderProcessExample workorderProcessExample = new WorkorderProcessExample();
        workorderProcessExample.setOrderByClause("process_number");
        List<WorkorderProcess> processeList = workorderProcessMapper.selectByExample(workorderProcessExample);
        if (processeList!=null && processeList.size()!=0) {
            knowledgeVo.setWorkorderProcessList(processeList);
        }
        //获取物资list
        WorkorderMaterialExample workorderMaterialExample = new WorkorderMaterialExample();
        workorderMaterialExample.setOrderByClause("material_number");
        List<WorkorderMaterial> materialList = workorderMaterialMapper.selectByExample(workorderMaterialExample);
        if (materialList!=null && materialList.size()!=0) {
            knowledgeVo.setWorkorderMaterialList(materialList);
        }
        //获取服务list
        WorkorderServiceExample workorderServiceExample = new WorkorderServiceExample();
        workorderServiceExample.setOrderByClause("service_number");
        List<WorkorderService> serviceList = workorderServiceMapper.selectByExample(workorderServiceExample);
        if (serviceList!=null && serviceList.size()!=0) {
            knowledgeVo.setWorkorderServiceList(serviceList);
        }
        //获取工器具list
        WorkorderToolExample workorderToolExample = new WorkorderToolExample();
        workorderToolExample.setOrderByClause("tool_number");
        List<WorkorderTool> toolList = workorderToolMapper.selectByExample(workorderToolExample);
        if (toolList!=null && toolList.size()!=0) {
            knowledgeVo.setWorkorderToolList(toolList);
        }
        //获取工种list
        WorkorderWorktypeExample workorderWorktypeExample = new WorkorderWorktypeExample();
        workorderWorktypeExample.setOrderByClause("worktype_number");
        List<WorkorderWorktype> worktypeList = workorderWorktypeMapper.selectByExample(workorderWorktypeExample);
        if (worktypeList!=null && worktypeList.size()!=0) {
            knowledgeVo.setWorkorderWorktypeList(worktypeList);
        }
        //获取危险点list
        WorkorderDangerPointExample workorderDangerPointExample = new WorkorderDangerPointExample();
        workorderDangerPointExample.setOrderByClause("danger_number");
        List<WorkorderDangerPoint> dangerPointList = workorderDangerPointMapper.selectByExample(workorderDangerPointExample);
        if (dangerPointList!=null && dangerPointList.size()!=0) {
            knowledgeVo.setWorkorderDangerPointList(dangerPointList);
        }

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("查询成功");
        resultEntity.setData(knowledgeVo);
        return resultEntity;
    }

    @Override
    public PageResultEntity getBreakdownKnowledgeList(Map<String, String> pageAndCondition) {
        PageResultEntity pageResultEntity = new PageResultEntity();
        pageResultEntity.setRows(new ArrayList());

        String start = String.valueOf((Integer.parseInt(pageAndCondition.get("pageNum"))-1)*(Integer.parseInt(pageAndCondition.get("pageSize"))));
        pageAndCondition.put("start",start);
        //获取故障知识主数据list
        List<KnowledgeVo> knowledgeVoList = breakdownKnowledgeBaseMapper.getBreakdownKnowledgeListByPageAndCondition(pageAndCondition);
        int total = breakdownKnowledgeBaseMapper.getTotal(pageAndCondition);
        knowledgeVoList.forEach(knowledgeVo -> {
            //获取工序list
            WorkorderProcessExample workorderProcessExample = new WorkorderProcessExample();
            workorderProcessExample.setOrderByClause("process_number");
            List<WorkorderProcess> processeList = workorderProcessMapper.selectByExample(workorderProcessExample);
            if (processeList!=null && processeList.size()!=0) {
                knowledgeVo.setWorkorderProcessList(processeList);
            }
            //获取物资list
            WorkorderMaterialExample workorderMaterialExample = new WorkorderMaterialExample();
            workorderMaterialExample.setOrderByClause("material_number");
            List<WorkorderMaterial> materialList = workorderMaterialMapper.selectByExample(workorderMaterialExample);
            if (materialList!=null && materialList.size()!=0) {
                knowledgeVo.setWorkorderMaterialList(materialList);
            }
            //获取服务list
            WorkorderServiceExample workorderServiceExample = new WorkorderServiceExample();
            workorderServiceExample.setOrderByClause("service_number");
            List<WorkorderService> serviceList = workorderServiceMapper.selectByExample(workorderServiceExample);
            if (serviceList!=null && serviceList.size()!=0) {
                knowledgeVo.setWorkorderServiceList(serviceList);
            }
            //获取工器具list
            WorkorderToolExample workorderToolExample = new WorkorderToolExample();
            workorderToolExample.setOrderByClause("tool_number");
            List<WorkorderTool> toolList = workorderToolMapper.selectByExample(workorderToolExample);
            if (toolList!=null && toolList.size()!=0) {
                knowledgeVo.setWorkorderToolList(toolList);
            }
            //获取工种list
            WorkorderWorktypeExample workorderWorktypeExample = new WorkorderWorktypeExample();
            workorderWorktypeExample.setOrderByClause("worktype_number");
            List<WorkorderWorktype> worktypeList = workorderWorktypeMapper.selectByExample(workorderWorktypeExample);
            if (worktypeList!=null && worktypeList.size()!=0) {
                knowledgeVo.setWorkorderWorktypeList(worktypeList);
            }
            //获取危险点list
            WorkorderDangerPointExample workorderDangerPointExample = new WorkorderDangerPointExample();
            workorderDangerPointExample.setOrderByClause("danger_number");
            List<WorkorderDangerPoint> dangerPointList = workorderDangerPointMapper.selectByExample(workorderDangerPointExample);
            if (dangerPointList!=null && dangerPointList.size()!=0) {
                knowledgeVo.setWorkorderDangerPointList(dangerPointList);
            }
        });

        pageResultEntity.setCode(ErrorCode.SUCCESS);
        pageResultEntity.setMsg("查询成功");
        pageResultEntity.setRows(knowledgeVoList);
        pageResultEntity.setTotal(total);
        return pageResultEntity;
    }
}
