package com.qz.zframe.maintain.service.Impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.qz.zframe.authentication.CurrentUserService;
import com.qz.zframe.common.entity.*;
import com.qz.zframe.common.entity.Process;
import com.qz.zframe.common.service.*;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.common.util.UUIdUtil;
import com.qz.zframe.maintain.entity.*;
import com.qz.zframe.maintain.mapper.*;
import com.qz.zframe.maintain.service.BreakdownKnowledgeService;
import com.qz.zframe.maintain.vo.KnowledgeVo;
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
public class BreakdownKnowledgeServiceImpl implements BreakdownKnowledgeService {

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

    @Autowired
    private CurrentUserService currentUserService;

    @Autowired
    private DeployService deployService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private DoListService doListService;

    @Autowired
    private ProcessService processService;

    @Autowired
    private ApproveRecordService approveRecordService;

    @Override
    public ResultEntity addBreakdownKnowledge(KnowledgeVo knowledgeVo) throws ParseException {
        ResultEntity resultEntity = new ResultEntity();

        //设置id
        knowledgeVo.setKnowledgeId(UUIdUtil.getUUID());
        //设置故障知识状态为未提交
        knowledgeVo.setStatus("03");
        //添加维护人
        knowledgeVo.setMaintainer(currentUserService.getId());
        //添加维护日期
        knowledgeVo.setMaintainDate(new Date());

        //添加物资,工种等tab页信息
        resultEntity = this.insertTab(knowledgeVo,resultEntity);
        if (resultEntity.getMsg()!=null) {
            return resultEntity;
        }
        //插入数据库
        breakdownKnowledgeBaseMapper.insert(knowledgeVo);


        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("信息已保存");
        return resultEntity;
    }

    @Override
    public ResultEntity updateBreakdownKnowledge(KnowledgeVo knowledgeVo) {
        ResultEntity resultEntity = new ResultEntity();

        if (!StringUtils.isNoneBlank(knowledgeVo.getKnowledgeId())) {
            resultEntity.setMsg("id不能为空");
            return resultEntity;
        }
        //修改维护日期
        knowledgeVo.setMaintainDate(new Date());

        //修改物资,工种等tab页信息
        resultEntity = this.updateTab(knowledgeVo,resultEntity);
        if (resultEntity.getMsg()!=null) {
            return resultEntity;
        }

        //修改数据库中数据
        BreakdownKnowledgeBase breakdownKnowledgeBase = breakdownKnowledgeBaseMapper.selectByPrimaryKey(knowledgeVo.getKnowledgeId());
        if (breakdownKnowledgeBase!=null) {
            if ("03".equals(breakdownKnowledgeBase.getStatus())) {
                BeanUtil.copyProperties(knowledgeVo, breakdownKnowledgeBase, true, CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true));
                breakdownKnowledgeBaseMapper.updateByPrimaryKey(breakdownKnowledgeBase);
            } else {
                resultEntity.setMsg("此故障知识已提交");
                return resultEntity;
            }
        }else {
            resultEntity.setMsg("此故障知识不存在");
            return resultEntity;
        }


        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("修改成功");
        return resultEntity;
    }

    @Override
    public ResultEntity submitBreakdownKnowledge(KnowledgeVo knowledgeVo) throws Exception {
        ResultEntity resultEntity = new ResultEntity();

        if (!StringUtils.isNoneBlank(knowledgeVo.getBreakdownLocation())) {
            resultEntity .setMsg("故障位置不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(knowledgeVo.getBreakdownAttribute())) {
            resultEntity .setMsg("故障属性不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(knowledgeVo.getWindId())) {
            resultEntity .setMsg("风电场不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(knowledgeVo.getApplicant())) {
            resultEntity .setMsg("申请人不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(knowledgeVo.getBreakdownDesc())) {
            resultEntity .setMsg("故障描述不能为空");
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
        if (!StringUtils.isNoneBlank(knowledgeVo.getKnowledgeId())) {
            //设置id
            knowledgeVo.setKnowledgeId(UUIdUtil.getUUID());
            //设置流水号
            BreakdownKnowledgeBaseExample breakdownKnowledgeBaseExample = new BreakdownKnowledgeBaseExample();
            breakdownKnowledgeBaseExample.createCriteria().andSerialNumberIsNotNull();
            String prefix = "GZZS";
            String tail = String.valueOf(1000000+breakdownKnowledgeBaseMapper.countByExample(new BreakdownKnowledgeBaseExample()) + 1).substring(1);
            knowledgeVo.setSerialNumber(prefix+tail);
            //设置故障知识状态为处理中
            knowledgeVo.setStatus("01");
            //设置申请时间
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            knowledgeVo.setApplyTime(simpleDateFormat.parse(simpleDateFormat.format(new Date())));
            //添加维护人
            knowledgeVo.setMaintainer(currentUserService.getId());
            //添加维护日期
            knowledgeVo.setMaintainDate(new Date());

            //添加物资,工种等tab页信息
            resultEntity = this.insertTab(knowledgeVo,resultEntity);
            if (resultEntity.getMsg()!=null) {
                return resultEntity;
            }
            //插入数据库
            breakdownKnowledgeBaseMapper.insert(knowledgeVo);
        }else {
            BreakdownKnowledgeBase breakdownKnowledgeBase = breakdownKnowledgeBaseMapper.selectByPrimaryKey(knowledgeVo.getKnowledgeId());
            if (!"03".equals(breakdownKnowledgeBase.getStatus())) {
                resultEntity.setMsg("此故障知识已提交");
                return resultEntity;
            }

            if (!StringUtils.isNoneBlank(knowledgeVo.getSerialNumber())) {
                //设置流水号
                BreakdownKnowledgeBaseExample breakdownKnowledgeBaseExample1 = new BreakdownKnowledgeBaseExample();
                breakdownKnowledgeBaseExample1.createCriteria().andSerialNumberIsNotNull();
                String prefix = "GZZS";
                String tail = String.valueOf(1000000+breakdownKnowledgeBaseMapper.countByExample(new BreakdownKnowledgeBaseExample()) + 1).substring(1);
                knowledgeVo.setSerialNumber(prefix+tail);
            }
            if (knowledgeVo.getApplyTime()==null) {
                //设置申请时间
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                knowledgeVo.setApplyTime(simpleDateFormat.parse(simpleDateFormat.format(new Date())));
            }
            //设置状态为处理中
            knowledgeVo.setStatus("01");
            //修改维护日期
            knowledgeVo.setMaintainDate(new Date());

            //修改物资,工种等tab页信息
            resultEntity = this.updateTab(knowledgeVo,resultEntity);
            if (resultEntity.getMsg()!=null) {
                return resultEntity;
            }
            //修改数据库中数据
            BeanUtil.copyProperties(knowledgeVo,breakdownKnowledgeBase,true, CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true));
            breakdownKnowledgeBaseMapper.updateByPrimaryKey(breakdownKnowledgeBase);
        }

        //获取流程配置
        DeployMain deployMain = deployService.queryDeployMainById("4");
        if (deployMain!=null) {
            //生成流程主表,流程详情,流程角色配置
            Process process = new Process();
            process.setProcessId(UUIdUtil.getUUID());
            process.setOrderId(knowledgeVo.getKnowledgeId());
            process.setProcessSort(1);
            process.setProcessType("11");
            process.setProcessStatus("01");
            process.setCreateTime(new Date());
            List<Deploy> deploys = deployMain.getDeploys();
            if (CollectionUtils.isNotEmpty(deploys)) {
                for (Deploy deploy:deploys) {
                    ProcessDetail processDetail = new ProcessDetail();
                    processDetail.setProcessDetailId(UUIdUtil.getUUID());
                    processDetail.setProcessId(process.getProcessId());
                    processDetail.setSort(deploy.getDeploySort());
                    processDetail.setName(deploy.getDeployName());
                    processDetail.setStatus("01");
                    process.getProcessDetails().add(processDetail);
                    List<Role> roles = deploy.getRoles();
                    if (CollectionUtils.isNotEmpty(roles)) {
                        for (Role role:roles) {
                            ProcessDetailRoleRela processDetailRoleRela = new ProcessDetailRoleRela();
                            processDetailRoleRela.setRelaId(UUIdUtil.getUUID());
                            processDetailRoleRela.setProcessDetailId(processDetail.getProcessDetailId());
                            processDetailRoleRela.setRoleId(role.getRoleId());
                            processDetail.getProcessDetailRoleRelas().add(processDetailRoleRela);
                        }
                    }
                }
            }
            //将流程主表,流程详情,流程角色配置插入数据库
            processService.addProcess(process);

            //修改流程详情第一步为已完成
            ResultEntity processDetailResultEntity= processService.getProcessDetailByProcessIdAndsort(process.getProcessId(), String.valueOf(process.getProcessSort()));
            ProcessDetail processDetail = (ProcessDetail)processDetailResultEntity.getData();
            if (processDetail!=null) {
                //更新数据库中的流程详情第一步为完成
                processDetail.setStatus("02");
                processService.updateProcessDetail(processDetail);

                //生成流程审批记录
                ApproveRecord approveRecord = new ApproveRecord();
                approveRecord.setApproveId(UUIdUtil.getUUID());
                approveRecord.setOrderId(knowledgeVo.getKnowledgeId());
                approveRecord.setProcessDetailId(processDetail.getProcessDetailId());
                approveRecord.setApproveResult("提交成功");
                approveRecord.setApproveUser(currentUserService.getId());
                approveRecord.setApproveTime(new Date());
                approveRecord.setApproveOpinion(knowledgeVo.getExamAndApprOpinion());
                //将流程审批记录插入数据库
                approveRecordService.addApproveRecord(approveRecord);
            }

            //获取流程第二步,生成代办信息
            processDetailResultEntity= processService.getProcessDetailByProcessIdAndsort(process.getProcessId(), String.valueOf(process.getProcessSort()+1));
            processDetail = (ProcessDetail)processDetailResultEntity.getData();
            if (processDetail!=null) {
                //生成代办信息,代办关联的角色列表
                DoList doList = new DoList();
                doList.setDoId(UUIdUtil.getUUID());
                doList.setTaskId(knowledgeVo.getKnowledgeId());
                doList.setTaskCode(knowledgeVo.getSerialNumber());
                doList.setTaskDescribe("故障知识");
                doList.setTaskType("11");
                doList.setCreateTime(new Date());
                List<DoRoleRela> doRoleRelas = new ArrayList<>();
                List<ProcessDetailRoleRela> processDetailRoleRelas = processDetail.getProcessDetailRoleRelas();
                for (ProcessDetailRoleRela processDetailRoleRela:processDetailRoleRelas) {
                    DoRoleRela doRoleRela = new DoRoleRela();
                    doRoleRela.setRelaId(UUIdUtil.getUUID());
                    doRoleRela.setDoId(doList.getDoId());
                    doRoleRela.setRoleId(processDetailRoleRela.getRoleId());
                    doRoleRelas.add(doRoleRela);
                }
                doList.setDoRoleRelas(doRoleRelas);
                //将代办信息,代办关联的角色列表插入数据库
                doListService.addDoList(doList);

                //修改故障知识中的流程状态
                BreakdownKnowledgeBase breakdownKnowledgeBase = breakdownKnowledgeBaseMapper.selectByPrimaryKey(knowledgeVo.getKnowledgeId());
                breakdownKnowledgeBase.setFlowStatus(process.getProcessStatus());
                breakdownKnowledgeBaseMapper.updateByPrimaryKeySelective(breakdownKnowledgeBase);
            }
        }
        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("提交成功");
        return resultEntity;
    }

    @Override
    public ResultEntity deleteBreakdownKnowledge(String[] knowledgeIds) {
        ResultEntity resultEntity = new ResultEntity();

        if (!(knowledgeIds!=null && knowledgeIds.length!=0)) {
            resultEntity.setMsg("ids不能为空");
            return resultEntity;
        }
        List<String> knowledgeIdList1 = new ArrayList<>();
        List<String> knowledgeIdList2 = new ArrayList<>();
        for (String knowledgeId:knowledgeIds) {
            BreakdownKnowledgeBase breakdownKnowledgeBase = breakdownKnowledgeBaseMapper.selectByPrimaryKey(knowledgeId);
            if (breakdownKnowledgeBase!=null) {
                if ("03".equals(breakdownKnowledgeBase.getStatus())) {
                    if (breakdownKnowledgeBase.getSerialNumber()==null) {
                        knowledgeIdList1.add(knowledgeId);
                    }else {
                        knowledgeIdList2.add(knowledgeId);
                    }
                }else {
                    resultEntity.setMsg("此故障知识已提交");
                    return resultEntity;
                }
            }
        }
        if (CollectionUtils.isNotEmpty(knowledgeIdList1)) {
            //删除操作票
            breakdownKnowledgeBaseMapper.batchDeleteTrue(knowledgeIdList1);
            //删除操作项
            this.deleteTab(knowledgeIdList1);
        }
        if (CollectionUtils.isNotEmpty(knowledgeIdList2)) {
            //删除操作票
            breakdownKnowledgeBaseMapper.batchDeleteFalse(knowledgeIdList2);
        }


        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("删除成功");
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
        knowledgeVo.setStatusName(this.getStatusName(knowledgeVo.getStatus()));
        if (knowledgeId!=null) {
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
        String userId = currentUserService.getId();
        List<Role> userRoleList = roleService.findUserRoleList(userId);
        if (!CollectionUtils.isNotEmpty(userRoleList)) {
            pageResultEntity.setMsg("当前用户未配置权限");
            return pageResultEntity;
        }
        //获取故障知识主数据list
        List<KnowledgeVo> knowledgeVoList = breakdownKnowledgeBaseMapper.getBreakdownKnowledgeListByPageAndCondition(pageAndCondition,userId,userRoleList);
        if (CollectionUtils.isNotEmpty(knowledgeVoList)) {
            knowledgeVoList.forEach(knowledgeVo -> {
                knowledgeVo.setStatusName(this.getStatusName(knowledgeVo.getStatus()));
            });
        }
        int total = breakdownKnowledgeBaseMapper.getTotal(pageAndCondition,userId,userRoleList);

        pageResultEntity.setCode(ErrorCode.SUCCESS);
        pageResultEntity.setMsg("查询成功");
        pageResultEntity.setRows(knowledgeVoList);
        pageResultEntity.setTotal(total);
        return pageResultEntity;
    }

    @Override
    public ResultEntity agreeBreakdownKnowledge(KnowledgeVo knowledgeVo) {
        ResultEntity resultEntity = new ResultEntity();

        if (!StringUtils.isNoneBlank(knowledgeVo.getSerialNumber())) {
            resultEntity.setMsg("请先提交");
            return resultEntity;
        }

        //获取流程主表
        ResultEntity processResultEntity = processService.getProcessByOrderIdAndType(knowledgeVo.getKnowledgeId(), "11");
        Process process = (Process)processResultEntity.getData();

        //获取流程步数
        ResultEntity totalSortResultEntity = processService.getTotalSort(process.getProcessId());
        int totalSort = (Integer) totalSortResultEntity.getData();

        if (process!=null && totalSort!=0) {
            //判断流程是否已经结束
            if (process.getProcessSort()==totalSort) {
                resultEntity.setMsg("此故障知识审核已结束");
                return resultEntity;
            }
            if ("03".equals(process.getProcessStatus())) {
                resultEntity.setMsg("此故障知识未提交");
                return resultEntity;
            }
            //获取流程详情
            ResultEntity processDetailResultEntity = processService.getProcessDetailByProcessIdAndsort(process.getProcessId(), String.valueOf(process.getProcessSort()+1));
            ProcessDetail processDetail = (ProcessDetail) processDetailResultEntity.getData();
            if (processDetail!=null) {
                //判断权限
                boolean flag = true;
                List<ProcessDetailRoleRela> processDetailRoleRelas = processDetail.getProcessDetailRoleRelas();
                if (CollectionUtils.isNotEmpty(processDetailRoleRelas)) {
                    for (ProcessDetailRoleRela processDetailRoleRela:processDetailRoleRelas) {
                        List<Role> userRoleList = roleService.findUserRoleList(currentUserService.getId());
                        for (Role role:userRoleList) {
                            if (processDetailRoleRela.getRoleId().equals(role.getRoleId())) {
                                flag = false;
                            }
                        }
                    }
                    if (flag) {
                        resultEntity.setMsg("您无此权限");
                        return resultEntity;
                    }
                }

                //生成流程审批记录
                ApproveRecord approveRecord = new ApproveRecord();
                approveRecord.setApproveId(UUIdUtil.getUUID());
                approveRecord.setOrderId(knowledgeVo.getKnowledgeId());
                approveRecord.setProcessDetailId(processDetail.getProcessDetailId());
                approveRecord.setApproveResult("通过");
                approveRecord.setApproveUser(currentUserService.getId());
                approveRecord.setApproveTime(new Date());
                approveRecord.setApproveOpinion(knowledgeVo.getExamAndApprOpinion());
                //将流程审批记录插入数据库
                approveRecordService.addApproveRecord(approveRecord);
            }

            //修改流程详情
            processDetail.setStatus("02");
            processService.updateProcessDetail(processDetail);

            if (totalSort-process.getProcessSort()>1) {
                processDetailResultEntity = processService.getProcessDetailByProcessIdAndsort(process.getProcessId(), String.valueOf(process.getProcessSort() + 2));
                processDetail = (ProcessDetail) processDetailResultEntity.getData();
                if (processDetail != null) {
                    List<ProcessDetailRoleRela> processDetailRoleRelas = processDetail.getProcessDetailRoleRelas();
                    if (CollectionUtils.isNotEmpty(processDetailRoleRelas)) {
                        //获取代办信息
                        ResultEntity doListResultEntity = doListService.findDoListByTaskId(knowledgeVo.getKnowledgeId());
                        DoList doList = (DoList) doListResultEntity.getData();
                        if (doList != null) {
                            //修改代办角色关联列表
                            List<DoRoleRela> doRoleRelas = new ArrayList<>();
                            for (ProcessDetailRoleRela processDetailRoleRela : processDetailRoleRelas) {
                                DoRoleRela doRoleRela = new DoRoleRela();
                                doRoleRela.setRelaId(UUIdUtil.getUUID());
                                doRoleRela.setDoId(doList.getDoId());
                                doRoleRela.setRoleId(processDetailRoleRela.getRoleId());
                                doRoleRelas.add(doRoleRela);
                            }
                            doListService.updateDoList(knowledgeVo.getKnowledgeId(), doRoleRelas);
                        }
                    }
                }
            }

            //如果当前是最后一步修改流程主表,流程结束
            if (totalSort-process.getProcessSort()==1) {
                //获取代办信息
                ResultEntity doListResultEntity = doListService.findDoListByTaskId(knowledgeVo.getKnowledgeId());
                DoList doList = (DoList) doListResultEntity.getData();
                if (doList != null) {
                    //修改代办角色关联列表
                    List<DoRoleRela> doRoleRelas = new ArrayList<>();
                    doListService.updateDoList(knowledgeVo.getKnowledgeId(), doRoleRelas);
                }


                process.setProcessStatus("02");
                BreakdownKnowledgeBase breakdownKnowledgeBase = breakdownKnowledgeBaseMapper.selectByPrimaryKey(knowledgeVo.getKnowledgeId());
                //设置故障知识流程状态跟流程主表同步
                breakdownKnowledgeBase.setFlowStatus(process.getProcessStatus());
                //设置故障知识状态为完成
                breakdownKnowledgeBase.setStatus("02");
                breakdownKnowledgeBaseMapper.updateByPrimaryKeySelective(breakdownKnowledgeBase);
            }
            process.setProcessSort(process.getProcessSort()+1);
            processService.updateProcess(process);
        }

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("审批通过");
        return resultEntity;
    }

    @Override
    public ResultEntity backBreakdownKnowledge(KnowledgeVo knowledgeVo) {
        ResultEntity resultEntity = new ResultEntity();

        if (!StringUtils.isNoneBlank(knowledgeVo.getSerialNumber())) {
            resultEntity.setMsg("此故障知识未提交");
            return resultEntity;
        }

        //获取流程主表
        ResultEntity processResultEntity = processService.getProcessByOrderIdAndType(knowledgeVo.getKnowledgeId(), "11");
        Process process = (Process)processResultEntity.getData();

        //获取流程步数
        ResultEntity totalSortResultEntity = processService.getTotalSort(process.getProcessId());
        int totalSort = (Integer) totalSortResultEntity.getData();

        if (process!=null && totalSort!=0) {
            //处理中的流程才能退回
            if ("03".equals(process.getProcessStatus())) {
                resultEntity.setMsg("此故障知识审核已结束");
                return resultEntity;
            }
            //若流程步骤为0,则无法退回
            if (process.getProcessSort()==0) {
                resultEntity.setMsg("当前步骤无法退回");
                return resultEntity;
            }
            //判断流程是否已经结束
            if (process.getProcessSort()==totalSort) {
                resultEntity.setMsg("此故障知识审核已结束");
                return resultEntity;
            }
            //获取流程详情
            ResultEntity processDetailResultEntity = processService.getProcessDetailByProcessIdAndsort(process.getProcessId(), String.valueOf(process.getProcessSort() + 1));
            ProcessDetail processDetail = (ProcessDetail) processDetailResultEntity.getData();
            if (processDetail!=null) {
                //判断权限
                boolean flag = true;
                List<ProcessDetailRoleRela> processDetailRoleRelas = processDetail.getProcessDetailRoleRelas();
                if (CollectionUtils.isNotEmpty(processDetailRoleRelas)) {
                    for (ProcessDetailRoleRela processDetailRoleRela:processDetailRoleRelas) {
                        List<Role> userRoleList = roleService.findUserRoleList(currentUserService.getId());
                        for (Role role:userRoleList) {
                            if (processDetailRoleRela.getRoleId().equals(role.getRoleId())) {
                                flag = false;
                            }
                        }
                    }
                    if (flag) {
                        resultEntity.setMsg("您无此权限");
                        return resultEntity;
                    }
                }
                //生成流程审批记录
                ApproveRecord approveRecord = new ApproveRecord();
                approveRecord.setApproveId(UUIdUtil.getUUID());
                approveRecord.setOrderId(knowledgeVo.getKnowledgeId());
                approveRecord.setProcessDetailId(processDetail.getProcessDetailId());
                approveRecord.setApproveResult("退回");
                approveRecord.setApproveUser(currentUserService.getId());
                approveRecord.setApproveTime(new Date());
                approveRecord.setApproveOpinion(knowledgeVo.getExamAndApprOpinion());
                //将流程审批记录插入数据库
                approveRecordService.addApproveRecord(approveRecord);
            }

            //获取上一步流程详情
            processDetailResultEntity = processService.getProcessDetailByProcessIdAndsort(process.getProcessId(), String.valueOf(process.getProcessSort()));
            processDetail = (ProcessDetail) processDetailResultEntity.getData();
            if (processDetail!=null) {
                //流程主表状态往后退一步
                //process.setProcessSort(process.getProcessSort()-1);
                /*if (process.getProcessSort()==0) {
                    process.setProcessStatus("");
                    //设置故障知识状态为未提交
                    operateTicket.setStatus("03");

                }*/
                //修改流程主表中的状态未审核未通过
                process.setProcessStatus("03");
                processService.updateProcess(process);
                BreakdownKnowledgeBase breakdownKnowledgeBase = breakdownKnowledgeBaseMapper.selectByPrimaryKey(knowledgeVo.getKnowledgeId());
                //设置故障知识流程状态跟流程主表同步
                breakdownKnowledgeBase.setFlowStatus(process.getProcessStatus());
                //设置故障知识状态为审核未通过
                breakdownKnowledgeBase.setStatus("04");
                breakdownKnowledgeBaseMapper.updateByPrimaryKeySelective(breakdownKnowledgeBase);

                //修改上一步流程详情为待办
                /*processDetail.setStatus("01");
                processService.updateProcessDetail(processDetail);*/

                //List<ProcessDetailRoleRela> processDetailRoleRelas = processDetail.getProcessDetailRoleRelas();
                //if (CollectionUtils.isNotEmpty(processDetailRoleRelas)) {
                //获取代办信息
                ResultEntity doListResultEntity = doListService.findDoListByTaskId(knowledgeVo.getKnowledgeId());
                DoList doList = (DoList)doListResultEntity.getData();
                if (doList!=null) {
                    //修改代办角色关联列表
                    List<DoRoleRela> doRoleRelas = new ArrayList<>();
                        /*for (ProcessDetailRoleRela processDetailRoleRela:processDetailRoleRelas) {
                            DoRoleRela doRoleRela = new DoRoleRela();
                            doRoleRela.setRelaId(UUIdUtil.getUUID());
                            doRoleRela.setDoId(doList.getDoId());
                            doRoleRela.setRoleId(processDetailRoleRela.getRoleId());
                            doRoleRelas.add(doRoleRela);
                        }*/
                    doListService.updateDoList(knowledgeVo.getKnowledgeId(),doRoleRelas);
                }
                //}
            }
        }

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("退回成功");
        return resultEntity;
    }

    @Override
    public ResultEntity getFlowStatusList(String knowledgeId) {
        ResultEntity resultEntity = new ResultEntity();

        if (StringUtils.isBlank(knowledgeId)) {
            resultEntity.setMsg("id不能为空");
            return resultEntity;
        }

        resultEntity = approveRecordService.getApproveRecordListByOrderId(knowledgeId);

        return resultEntity;
    }


    private ResultEntity insertTab(KnowledgeVo knowledgeVo,ResultEntity resultEntity) {
        //保存工序列表
        List<WorkorderProcess> processList = knowledgeVo.getWorkorderProcessList();
        if ("01".equals(knowledgeVo.getStatus())) {
            if (!CollectionUtils.isNotEmpty(processList)) {
                resultEntity.setMsg("至少需要填写一道工序");
                return resultEntity;
            }
        }
        if (CollectionUtils.isNotEmpty(processList)) {
            int i = 1;
            for (WorkorderProcess workorderProcess:processList) {
                if (!StringUtils.isNoneBlank(workorderProcess.getProcessDesc())) {
                    resultEntity.setMsg("工序描述不能为空");
                    return resultEntity;
                }
                workorderProcess.setProcessId(UUIdUtil.getUUID());
                workorderProcess.setProcessNumber(String.valueOf(i++));
                workorderProcess.setKnowledgeId(knowledgeVo.getKnowledgeId());
                workorderProcessMapper.insert(workorderProcess);
            }
        }
        //保存物资
        List<WorkorderMaterial> materialList = knowledgeVo.getWorkorderMaterialList();
        if (CollectionUtils.isNotEmpty(materialList)) {
            for (WorkorderMaterial workorderMaterial:materialList) {
                workorderMaterial.setWorkorderMaterialId(UUIdUtil.getUUID());
                workorderMaterial.setKnowledgeId(knowledgeVo.getKnowledgeId());
                workorderMaterialMapper.insert(workorderMaterial);
            }
        }
        //保存服务
        List<WorkorderService> serviceList = knowledgeVo.getWorkorderServiceList();
        if (CollectionUtils.isNotEmpty(serviceList)) {
            int i = 1;
            for (WorkorderService workorderService:serviceList) {
                if (!StringUtils.isNoneBlank(workorderService.getServiceDesc())) {
                    resultEntity.setMsg("服务描述不能为空");
                    return resultEntity;
                }
                workorderService.setServiceId(UUIdUtil.getUUID());
                workorderService.setServiceNumber(String.valueOf(i++));
                workorderService.setKnowledgeId(knowledgeVo.getKnowledgeId());
                workorderServiceMapper.insert(workorderService);
            }
        }
        //保存工单工器具
        List<WorkorderTool> toolList = knowledgeVo.getWorkorderToolList();
        if (CollectionUtils.isNotEmpty(toolList)) {
            int i = 1;
            for (WorkorderTool workorderTool:toolList) {
                if (!StringUtils.isNoneBlank(workorderTool.getToolDesc())) {
                    resultEntity.setMsg("工器具描述不能为空");
                    return resultEntity;
                }
                workorderTool.setToolId(UUIdUtil.getUUID());
                workorderTool.setToolNumber(String.valueOf(i++));
                workorderTool.setKnowledgeId(knowledgeVo.getKnowledgeId());
                workorderToolMapper.insert(workorderTool);
            }
        }
        //保存工单工种
        List<WorkorderWorktype> worktypeList = knowledgeVo.getWorkorderWorktypeList();
        if (CollectionUtils.isNotEmpty(worktypeList)) {
            int i = 1;
            for (WorkorderWorktype workorderWorktype:worktypeList) {
                if (!StringUtils.isNoneBlank(workorderWorktype.getWorktypeName())) {
                    resultEntity.setMsg("工种名称不能为空");
                    return resultEntity;
                }
                if (workorderWorktype.getWorktypePlanStartTime()!=null && workorderWorktype.getWorktypePlanEndTime()!=null) {
                    if (workorderWorktype.getWorktypePlanStartTime().after(workorderWorktype.getWorktypePlanEndTime())) {
                        resultEntity.setMsg("工种计划开始日期不能早于计划结束日期");
                        return resultEntity;
                    }
                }
                workorderWorktype.setWorktypeId(UUIdUtil.getUUID());
                workorderWorktype.setWorktypeNumber(String.valueOf(i++));
                workorderWorktype.setKnowledgeId(knowledgeVo.getKnowledgeId());
                workorderWorktypeMapper.insert(workorderWorktype);
            }
        }
        //保存工单危险点控制
        List<WorkorderDangerPoint> dangerPointList = knowledgeVo.getWorkorderDangerPointList();
        if (CollectionUtils.isNotEmpty(dangerPointList)) {
            int i = 1;
            for (WorkorderDangerPoint workorderDangerPoint:dangerPointList) {
                if (!StringUtils.isNoneBlank(workorderDangerPoint.getDangerDangerSource())) {
                    resultEntity.setMsg("危险源不能为空");
                    return resultEntity;
                }
                workorderDangerPoint.setDangerPointId(UUIdUtil.getUUID());
                workorderDangerPoint.setDangerNumber(String.valueOf(i++));
                workorderDangerPoint.setKnowledgeId(knowledgeVo.getKnowledgeId());
                workorderDangerPointMapper.insert(workorderDangerPoint);
            }
        }
        return resultEntity;
    }

    private ResultEntity updateTab(KnowledgeVo knowledgeVo,ResultEntity resultEntity) {
        //删除原来的工序
        WorkorderProcessExample workorderProcessExample = new WorkorderProcessExample();
        workorderProcessExample.createCriteria().andKnowledgeIdEqualTo(knowledgeVo.getKnowledgeId());
        workorderProcessMapper.deleteByExample(workorderProcessExample);
        //删除原来的物资
        WorkorderMaterialExample workorderMaterialExample = new WorkorderMaterialExample();
        workorderMaterialExample.createCriteria().andKnowledgeIdEqualTo(knowledgeVo.getKnowledgeId());
        workorderMaterialMapper.deleteByExample(workorderMaterialExample);
        //删除原来的服务
        WorkorderServiceExample workorderServiceExample = new WorkorderServiceExample();
        workorderServiceExample.createCriteria().andKnowledgeIdEqualTo(knowledgeVo.getKnowledgeId());
        workorderServiceMapper.deleteByExample(workorderServiceExample);
        //删除原来的工器具
        WorkorderToolExample workorderToolExample = new WorkorderToolExample();
        workorderToolExample.createCriteria().andKnowledgeIdEqualTo(knowledgeVo.getKnowledgeId());
        workorderToolMapper.deleteByExample(workorderToolExample);
        //删除原来的工种
        WorkorderWorktypeExample workorderWorktypeExample = new WorkorderWorktypeExample();
        workorderWorktypeExample.createCriteria().andKnowledgeIdEqualTo(knowledgeVo.getKnowledgeId());
        workorderWorktypeMapper.deleteByExample(workorderWorktypeExample);
        //删除原来的危险点
        WorkorderDangerPointExample workorderDangerPointExample = new WorkorderDangerPointExample();
        workorderDangerPointExample.createCriteria().andKnowledgeIdEqualTo(knowledgeVo.getKnowledgeId());
        workorderDangerPointMapper.deleteByExample(workorderDangerPointExample);

        //重新添加
        resultEntity = this.insertTab(knowledgeVo,resultEntity);
        return resultEntity;
    }

    private void deleteTab(List<String> knowledgeList) {
        //根据缺陷工单ids批量删除工序
        workorderProcessMapper.batchDeleteByKnowledgeIds(knowledgeList);
        //根据缺陷工单ids批量删除物资
        workorderMaterialMapper.batchDeleteByKnowledgeIds(knowledgeList);
        //根据缺陷工单ids删除服务
        workorderServiceMapper.batchDeleteByKnowledgeIds(knowledgeList);
        //根据缺陷工单ids删除工器具
        workorderToolMapper.batchDeleteByKnowledgeIds(knowledgeList);
        //根据缺陷工单ids删除工种
        workorderWorktypeMapper.batchDeleteByKnowledgeIds(knowledgeList);
        //根据缺陷工单ids删除危险点控制
        workorderDangerPointMapper.batchDeleteByKnowledgeIds(knowledgeList);
    }

    private String getStatusName(String statsu) {
        if ("01".equals(statsu)) {
            return "处理中";
        }
        if ("02".equals(statsu)) {
            return "完成";
        }
        if ("03".equals(statsu)) {
            return  "未提交";
        }
        if ("04".equals(statsu)) {
            return "审核未通过";
        }
        return null;
    }
}
