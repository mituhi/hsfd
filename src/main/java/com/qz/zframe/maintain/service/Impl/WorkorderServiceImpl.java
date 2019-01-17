package com.qz.zframe.maintain.service.Impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.qz.zframe.authentication.CurrentUserService;
import com.qz.zframe.common.dao.CommonDao;
import com.qz.zframe.common.dao.UserDao;
import com.qz.zframe.common.entity.*;
import com.qz.zframe.common.entity.Process;
import com.qz.zframe.common.service.*;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.common.util.UUIdUtil;
import com.qz.zframe.maintain.entity.*;
import com.qz.zframe.maintain.mapper.*;
import com.qz.zframe.maintain.service.WorkorderService;
import com.qz.zframe.maintain.vo.*;
import com.qz.zframe.tickets.entity.OperateTicket;
import com.qz.zframe.tickets.entity.OperateTicketExample;
import com.qz.zframe.tickets.entity.WorkTicket;
import com.qz.zframe.tickets.entity.WorkTicketExample;
import com.qz.zframe.tickets.mapper.OperateTicketMapper;
import com.qz.zframe.tickets.mapper.WorkTicketMapper;
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
import java.util.regex.Pattern;

@Service
@Transactional(rollbackFor = Exception.class)
public class WorkorderServiceImpl implements WorkorderService {

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

    @Autowired
    private WorkTicketMapper workTicketMapper;

    @Autowired
    private OperateTicketMapper operateTicketMapper;

    @Autowired
    private MaintainFileMapper maintainFileMapper;

    @Autowired
    private CommonDao commonDao;

    @Autowired
    private WorkorderTypeMapper workorderTypeMapper;

    @Autowired
    private UserDao userDao;

    @Autowired
    private DeployService deployService;

    @Autowired
    private CurrentUserService currentUserService;

    @Autowired
    private UserService userService;

    @Autowired
    private CommonService commonService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private DoListService doListService;

    @Autowired
    private ProcessService processService;

    @Autowired
    private ApproveRecordService approveRecordService;

    @Override
    public ResultEntity addWorkorder(WorkorderVo workorderVo) {
        ResultEntity resultEntity = new ResultEntity();

        if (StringUtils.isNoneBlank(workorderVo.getPlanWorkHour())) {
            if (!Pattern.matches("^\\d+(\\.\\d+)?$",workorderVo.getPlanWorkHour())) {
                resultEntity.setMsg("计划工时格式不正确");
                return resultEntity;
            }
        }
        if (StringUtils.isNoneBlank(workorderVo.getPlanMaterialFee())) {
            if (!Pattern.matches("^\\d+(\\.\\d+)?$",workorderVo.getPlanMaterialFee())) {
                resultEntity.setMsg("计划材料费格式不正确");
                return resultEntity;
            }
        }
        if (StringUtils.isNoneBlank(workorderVo.getPlanServiceFee())) {
            if (!Pattern.matches("^\\d+(\\.\\d+)?$",workorderVo.getPlanServiceFee())) {
                resultEntity.setMsg("计划服务费格式不正确");
                return resultEntity;
            }
        }

        //设置id
        workorderVo.setOrderId(UUIdUtil.getUUID());
        //设置工单状态为未提交
        workorderVo.setStatus("03");
        //添加维护人
        workorderVo.setMaintainer(currentUserService.getId());
        //添加维护日期
        workorderVo.setMaintainDate(new Date());
        //将本单位工作人员数组转成字符串
        this.setUnitMember(workorderVo);
        //上传基本信息的附件
        this.addMaintainFile(workorderVo.getAttachmentList(),workorderVo.getOrderId(),"04");

        //添加物资,服务等tab页
        resultEntity = this.insertTab(workorderVo,resultEntity);
        if (resultEntity.getMsg()!=null) {
            return resultEntity;
        }
        //插入数据库
        workorderInfoMapper.insertSelective(workorderVo);

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("信息已保存");
        return resultEntity;
    }

    @Override
    public ResultEntity updateWorkorder(WorkorderVo workorderVo) {
        ResultEntity resultEntity = new ResultEntity();

        if (!StringUtils.isNoneBlank(workorderVo.getOrderId())) {
            resultEntity.setMsg("id不能为空");
            return resultEntity;
        }

        if (StringUtils.isNoneBlank(workorderVo.getPlanWorkHour())) {
            if (!Pattern.matches("^\\d+(\\.\\d+)?$",workorderVo.getPlanWorkHour())) {
                resultEntity.setMsg("计划工时格式不正确");
                return resultEntity;
            }
        }
        if (StringUtils.isNoneBlank(workorderVo.getPlanMaterialFee())) {
            if (!Pattern.matches("^\\d+(\\.\\d+)?$",workorderVo.getPlanMaterialFee())) {
                resultEntity.setMsg("计划材料费格式不正确");
                return resultEntity;
            }
        }
        if (StringUtils.isNoneBlank(workorderVo.getPlanServiceFee())) {
            if (!Pattern.matches("^\\d+(\\.\\d+)?$",workorderVo.getPlanServiceFee())) {
                resultEntity.setMsg("计划服务费格式不正确");
                return resultEntity;
            }
        }
        //将本单位工作人员数组转成字符串
        this.setUnitMember(workorderVo);
        //修改维护日期
        workorderVo.setMaintainDate(new Date());
        //修改关联文件列表并删除服务器上用户已删除的图片
        this.updateMaintainFileAndRemoveFile(workorderVo.getAttachmentList(),workorderVo.getOrderId(),"04");




        //修改物资服务等tab页
        resultEntity = this.updateTab(workorderVo,resultEntity);
        if (resultEntity.getMsg()!=null) {
            return resultEntity;
        }
        //修改工单主数据
        WorkorderInfo workorderInfo = workorderInfoMapper.selectByPrimaryKey(workorderVo.getOrderId());
        if ("03".equals(workorderInfo.getStatus())) {
            BeanUtil.copyProperties(workorderVo,workorderInfo,true, CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true));
            workorderInfoMapper.updateByPrimaryKeySelective(workorderInfo);
        }else {
            resultEntity.setMsg("此工单已提交");
            return resultEntity;
        }

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("修改成功");
        return resultEntity;
    }

    @Override
    public ResultEntity submitWorkorder(WorkorderVo workorderVo) throws Exception {
        ResultEntity resultEntity = new ResultEntity();

        if (!StringUtils.isNoneBlank(workorderVo.getWorkorderDesc())) {
            resultEntity.setMsg("工单描述不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(workorderVo.getWorkorderTypeId())) {
            resultEntity.setMsg("工单类型不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(workorderVo.getWindId())) {
            resultEntity.setMsg("风电场不能为空");
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
        if (StringUtils.isNoneBlank(workorderVo.getPlanWorkHour())) {
            if (!Pattern.matches("^\\d+(\\.\\d+)?$",workorderVo.getPlanWorkHour())) {
                resultEntity.setMsg("计划工时格式不正确");
                return resultEntity;
            }
        }
        if (StringUtils.isNoneBlank(workorderVo.getPlanMaterialFee())) {
            if (!Pattern.matches("^\\d+(\\.\\d+)?$",workorderVo.getPlanMaterialFee())) {
                resultEntity.setMsg("计划材料费格式不正确");
                return resultEntity;
            }
        }
        if (StringUtils.isNoneBlank(workorderVo.getPlanServiceFee())) {
            if (!Pattern.matches("^\\d+(\\.\\d+)?$",workorderVo.getPlanServiceFee())) {
                resultEntity.setMsg("计划服务费格式不正确");
                return resultEntity;
            }
        }

        if (!StringUtils.isNoneBlank(workorderVo.getOrderId())) {
            //设置id
            workorderVo.setOrderId(UUIdUtil.getUUID());
            //生成流水号
            WorkorderInfoExample workorderInfoExample = new WorkorderInfoExample();
            workorderInfoExample.createCriteria().andSerialNumberIsNotNull();
            String prefix = "GD";
            String tail = String.valueOf(1000000+workorderInfoMapper.countByExample(new WorkorderInfoExample())+1).substring(1);
            workorderVo.setSerialNumber(prefix+tail);
            //设置策划时间
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            workorderVo.setSchemeTime(simpleDateFormat.parse(simpleDateFormat.format(new Date())));
            //设置工单状态为处理中
            workorderVo.setStatus("01");
            //
            //将本单位工作人员数组转成字符串
            this.setUnitMember(workorderVo);
            //添加维护人
            workorderVo.setMaintainer(currentUserService.getId());
            //添加维护日期
            workorderVo.setMaintainDate(new Date());
            //上传基本信息的附件
            this.addMaintainFile(workorderVo.getAttachmentList(),workorderVo.getOrderId(),"04");
            //添加物资服务等tab页
            resultEntity = this.insertTab(workorderVo,resultEntity);
            if (resultEntity.getMsg()!=null) {
                return resultEntity;
            }
            //插入数据库
            workorderInfoMapper.insertSelective(workorderVo);
        } else {
            WorkorderInfo workorderInfo = workorderInfoMapper.selectByPrimaryKey(workorderVo.getOrderId());
            if (!"03".equals(workorderInfo.getStatus())) {
                resultEntity.setMsg("此工单已提交");
                return resultEntity;
            }

            if (!StringUtils.isNoneBlank(workorderVo.getSerialNumber())) {
                //生成流水号
                WorkorderInfoExample workorderInfoExample1 = new WorkorderInfoExample();
                workorderInfoExample1.createCriteria().andSerialNumberIsNotNull();
                String prefix = "GD";
                String tail = String.valueOf(1000000+workorderInfoMapper.countByExample(new WorkorderInfoExample())+1).substring(1);
                workorderVo.setSerialNumber(prefix+tail);
            }
            //设置策划时间
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            workorderVo.setSchemeTime(simpleDateFormat.parse(simpleDateFormat.format(new Date())));
            //将本单位工作人员数组转成字符串
            this.setUnitMember(workorderVo);
            //修改维护日期
            workorderVo.setMaintainDate(new Date());
            //设置状态为处理中
            workorderVo.setStatus("01");
            //修改关联文件列表并删除服务器上用户已删除的图片
            this.updateMaintainFileAndRemoveFile(workorderVo.getAttachmentList(),workorderVo.getOrderId(),"04");

            //修改物资,工种等tab页信息
            resultEntity = this.updateTab(workorderVo,resultEntity);
            if (resultEntity.getMsg()!=null) {
                return resultEntity;
            }
            //修改数据库中数据
            BeanUtil.copyProperties(workorderVo,workorderInfo,true, CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true));
            workorderInfoMapper.updateByPrimaryKeySelective(workorderInfo);
        }

        //获取流程主表
        ResultEntity processResultEntity = processService.getProcessByOrderIdAndType(workorderVo.getOrderId(), "10");
        Process process = (Process)processResultEntity.getData();
        if (process!=null) {
            resultEntity = this.agreeWorkorder(workorderVo);
            if (resultEntity.getMsg()!=null) {
                return resultEntity;
            }
        }else {
            //获取流程配置
            DeployMain deployMain = deployService.queryDeployMainById("9");
            if (deployMain!=null) {
                //生成流程主表,流程详情,流程角色配置
                process = new Process();
                process.setProcessId(UUIdUtil.getUUID());
                process.setOrderId(workorderVo.getOrderId());
                process.setProcessSort(1);
                process.setProcessType("10");
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
                    approveRecord.setOrderId(workorderVo.getOrderId());
                    approveRecord.setProcessDetailId(processDetail.getProcessDetailId());
                    approveRecord.setApproveResult("提交成功");
                    approveRecord.setApproveUser(currentUserService.getId());
                    approveRecord.setApproveTime(new Date());
                    approveRecord.setApproveOpinion(workorderVo.getExamAndApprOpinion());
                    //将流程审批记录插入数据库
                    approveRecordService.addApproveRecord(approveRecord);
                }

                //获取流程第二步
                processDetailResultEntity= processService.getProcessDetailByProcessIdAndsort(process.getProcessId(), String.valueOf(process.getProcessSort()+1));
                processDetail = (ProcessDetail)processDetailResultEntity.getData();
                if (processDetail!=null) {
                    //生成代办信息,代办关联的角色列表
                    DoList doList = new DoList();
                    doList.setDoId(UUIdUtil.getUUID());
                    doList.setTaskId(workorderVo.getOrderId());
                    doList.setTaskCode(workorderVo.getSerialNumber());
                    doList.setTaskDescribe(workorderTypeMapper.getNameById(workorderVo.getWorkorderTypeId()));
                    doList.setTaskType("10");
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

                    //修改工单中的流程状态
                    WorkorderInfo workorderInfo = workorderInfoMapper.selectByPrimaryKey(workorderVo.getOrderId());
                    workorderInfo.setFlowStatus(process.getProcessStatus());
                    workorderInfoMapper.updateByPrimaryKeySelective(workorderInfo);
                }
            }
        }

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("提交成功");
        return resultEntity;
    }

    @Override
    public ResultEntity deleteWorkorder(String[] orderIds) {
        ResultEntity resultEntity = new ResultEntity();

        if (!(orderIds!=null && orderIds.length!=0)) {
            resultEntity.setMsg("ids不能为空");
            return resultEntity;
        }
        List<String> orderIdList1 = new ArrayList<>();
        List<String> orderIdList2 = new ArrayList<>();
        for (String orderId:orderIds) {
            WorkorderInfo workorderInfo = workorderInfoMapper.selectByPrimaryKey(orderId);
            if (workorderInfo!=null) {
                if ("03".equals(workorderInfo.getStatus())) {
                    if (workorderInfo.getSerialNumber()==null) {
                        orderIdList1.add(orderId);
                    }else {
                        orderIdList2.add(orderId);
                    }
                }else {
                    resultEntity.setMsg("此工单已提交");
                    return resultEntity;
                }
            }
        }
        if (CollectionUtils.isNotEmpty(orderIdList1)) {
            //删除操作票
            workorderInfoMapper.batchDeleteTrue(orderIdList1);
            //删除操作项
            this.deleteTab(orderIdList1);
        }
        if (CollectionUtils.isNotEmpty(orderIdList2)) {
            //删除操作票
            workorderInfoMapper.batchDeleteFalse(orderIdList2);
        }

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("删除成功");
        return resultEntity;
    }

    @Override
    public ResultEntity getWorkorderDetail(String orderId) throws Exception {
        ResultEntity resultEntity = new ResultEntity();

        if (!StringUtils.isNoneBlank(orderId)) {
            resultEntity.setMsg("id不能为空");
            return resultEntity;
        }

        //获取工单主数据list
        WorkorderVo workorderVo = workorderInfoMapper.getWorkorderDetail(orderId);
        if (workorderVo!=null) {
            //设置状态名称
            workorderVo.setStatusName(this.getStatusName(workorderVo.getStatus()));
            //获取本单位工作人员姓名  并给人员id数组赋值
            this.setUnitMemberNamesAndUnitMemberArray(workorderVo);
            //查询附件
            workorderVo.setAttachmentList(this.getFile(workorderVo.getOrderId(), "04"));

            //获取工序list
            WorkorderProcessExample workorderProcessExample = new WorkorderProcessExample();
            workorderProcessExample.setOrderByClause("process_number");
            workorderProcessExample.createCriteria().andOrderIdEqualTo(workorderVo.getOrderId());
            List<WorkorderProcess> processeList = workorderProcessMapper.selectByExample(workorderProcessExample);
            if (CollectionUtils.isNotEmpty(processeList)) {
                workorderVo.setWorkorderProcessList(processeList);
            }
            //获取物资list
            List<WorkorderMaterialVo> materialList = workorderMaterialMapper.
                    getWorkorderMaterialVoByorderId(workorderVo.getOrderId(), null);
            if (CollectionUtils.isNotEmpty(materialList)) {
                for (WorkorderMaterialVo workorderMaterialVo:materialList) {
                    workorderVo.getWorkorderMaterialList().add(workorderMaterialVo);
                }
            }
            //获取服务list
            WorkorderServiceExample workorderServiceExample = new WorkorderServiceExample();
            workorderServiceExample.setOrderByClause("service_number");
            workorderServiceExample.createCriteria().andOrderIdEqualTo(workorderVo.getOrderId());
            List<com.qz.zframe.maintain.entity.WorkorderService> serviceList = workorderServiceMapper.selectByExample(workorderServiceExample);
            if (CollectionUtils.isNotEmpty(serviceList)) {
                workorderVo.setWorkorderServiceList(serviceList);
            }
            //获取工器具list
            WorkorderToolExample workorderToolExample = new WorkorderToolExample();
            workorderToolExample.setOrderByClause("tool_number");
            workorderToolExample.createCriteria().andOrderIdEqualTo(workorderVo.getOrderId());
            List<WorkorderTool> toolList = workorderToolMapper.selectByExample(workorderToolExample);
            if (CollectionUtils.isNotEmpty(toolList)) {
                workorderVo.setWorkorderToolList(toolList);
            }
            //获取工种list
            WorkorderWorktypeExample workorderWorktypeExample = new WorkorderWorktypeExample();
            workorderWorktypeExample.setOrderByClause("worktype_number");
            workorderWorktypeExample.createCriteria().andOrderIdEqualTo(workorderVo.getOrderId());
            List<WorkorderWorktype> worktypeList = workorderWorktypeMapper.selectByExample(workorderWorktypeExample);
            if (CollectionUtils.isNotEmpty(worktypeList)) {
                workorderVo.setWorkorderWorktypeList(worktypeList);
            }
            //获取危险点list
            WorkorderDangerPointExample workorderDangerPointExample = new WorkorderDangerPointExample();
            workorderDangerPointExample.setOrderByClause("danger_number");
            workorderDangerPointExample.createCriteria().andOrderIdEqualTo(workorderVo.getOrderId());
            List<WorkorderDangerPoint> dangerPointList = workorderDangerPointMapper.selectByExample(workorderDangerPointExample);
            if (CollectionUtils.isNotEmpty(dangerPointList)) {
                workorderVo.setWorkorderDangerPointList(dangerPointList);
            }
            //获取关联工作票
            List<WorkTicketForWorkorederVo> workTicketForWorkorederVoList = workTicketMapper.
                    getOrderWorkTicketList(workorderVo.getOrderId());
            if (CollectionUtils.isNotEmpty(workTicketForWorkorederVoList)) {
                workTicketForWorkorederVoList.forEach(workTicketForWorkorederVo -> {
                    workTicketForWorkorederVo.setStatusName(this.getStatusName(workTicketForWorkorederVo.getStatus()));
                    workorderVo.getWorkTicketForWorkorederVoList().add(workTicketForWorkorederVo);
                });
            }
            //获取关联工单
            List<OperateTicketForWorkorderVo> operateTicketForWorkorderVoList = operateTicketMapper.
                    getOrderOperTicketList(workorderVo.getOrderId());
            if (CollectionUtils.isNotEmpty(operateTicketForWorkorderVoList)) {
                operateTicketForWorkorderVoList.forEach(operateTicketForWorkorderVo -> {
                    operateTicketForWorkorderVo.setStatusName(this.getStatusName(operateTicketForWorkorderVo.getStatus()));
                    workorderVo.getOperateTicketForWorkorderVoList().add(operateTicketForWorkorderVo);
                });
            }

            //获取工单质量验收
            WorkorderQualityAcceptanceExample workorderQualityAcceptanceExample = new WorkorderQualityAcceptanceExample();
            workorderDangerPointExample.createCriteria().andOrderIdEqualTo(workorderVo.getOrderId());
            List<WorkorderQualityAcceptance> workorderQualityAcceptances = workorderQualityAcceptanceMapper.selectByExample(workorderQualityAcceptanceExample);
            if (CollectionUtils.isNotEmpty(workorderQualityAcceptances)) {
                workorderVo.setWorkorderQualityAcceptance(workorderQualityAcceptances.get(0));
            }

            //获取工单总结
            WorkorderSummaryExample workorderSummaryExample = new WorkorderSummaryExample();
            workorderDangerPointExample.createCriteria().andOrderIdEqualTo(workorderVo.getOrderId());
            List<WorkorderSummary> workorderSummaries = workorderSummaryMapper.selectByExample(workorderSummaryExample);
            if (CollectionUtils.isNotEmpty(workorderSummaries)) {
                workorderVo.setWorkorderSummary(workorderSummaries.get(0));
            }

            //查询工单总结附件
            if (workorderVo.getWorkorderSummary()!=null) {
                workorderVo.getWorkorderSummary().setSummaryAttachmentList(this.getFile(workorderVo.getOrderId(),"05"));
            }

        }

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("查询成功");
        resultEntity.setData(workorderVo);
        return resultEntity;
    }

    @Override
    public PageResultEntity getWorkorderList(Map<String, String> pageAndCondition) throws Exception {
        PageResultEntity pageResultEntity = new PageResultEntity();
        pageResultEntity.setRows(new ArrayList());

        String start = String.valueOf((Integer.parseInt(pageAndCondition.get("pageNum"))-1)*(Integer.parseInt(pageAndCondition.get("pageSize"))));
        pageAndCondition.put("start",start);
        UserDto userDto = new UserDto();
        userDto.setUserName(pageAndCondition.get("approveUser"));
        List<UserDto> userList = userDao.findUserList(userDto);
        List<Role> userRoleList = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(userList)) {
            for (UserDto user:userList) {
                userRoleList.addAll(roleService.findUserRoleList(user.getUserId()));
            }
        }
        String userId = currentUserService.getId();
        if (CollectionUtils.isEmpty(userRoleList)) {
            pageResultEntity.setMsg("该审批人未配置权限");
            return pageResultEntity;
        }
        //获取工单主数据list
        List<WorkorderVo> workorderVoList = workorderInfoMapper.getWorkorderList(pageAndCondition,userId,userRoleList);
        if (CollectionUtils.isNotEmpty(workorderVoList)) {
            for (WorkorderVo workorderVo:workorderVoList) {
                //设置状态名称
                workorderVo.setStatusName(this.getStatusName(workorderVo.getStatus()));
                //获取本单位人员姓名
                this.setUnitMemberNamesAndUnitMemberArray(workorderVo);
            }
        }
        int total = workorderInfoMapper.getTotal(pageAndCondition,userId,userRoleList);

        pageResultEntity.setCode(ErrorCode.SUCCESS);
        pageResultEntity.setMsg("查询成功");
        pageResultEntity.setRows(workorderVoList);
        pageResultEntity.setTotal(total);
        return pageResultEntity;
    }

    @Override
    public ResultEntity agreeWorkorder(WorkorderVo workorderVo) {
        ResultEntity resultEntity = new ResultEntity();

        if (!StringUtils.isNoneBlank(workorderVo.getSerialNumber())) {
            resultEntity.setMsg("此工单未提交");
            return resultEntity;
        }
        //获取流程主表
        ResultEntity processResultEntity = processService.getProcessByOrderIdAndType(workorderVo.getOrderId(), "10");
        Process process = (Process)processResultEntity.getData();

        //获取流程步数
        ResultEntity totalSortResultEntity = processService.getTotalSort(process.getProcessId());
        int totalSort = (Integer) totalSortResultEntity.getData();

        if (process!=null && totalSort!=0) {
            //判断流程是否已经结束
            if (process.getProcessSort()==totalSort) {
                resultEntity.setMsg("此工单审核已结束");
                return resultEntity;
            }
            //若审核未通过,无法再操作
            if ("03".equals(process.getProcessStatus())) {
                resultEntity.setMsg("此工单审核已结束");
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

                if ("3".equals(String.valueOf(process.getProcessSort()))) {
                    resultEntity = this.insertTab(workorderVo, resultEntity);
                    if (resultEntity.getMsg()!=null) {
                        return resultEntity;
                    }
                    workorderInfoMapper.updateByPrimaryKeySelective(workorderVo);
                }
                if ("4".equals(String.valueOf(process.getProcessSort()))) {
                    //保存工单质量验收
                    WorkorderQualityAcceptance workorderQualityAcceptance = workorderVo.getWorkorderQualityAcceptance();
                    if (workorderQualityAcceptance!=null) {
                        workorderQualityAcceptance.setQualityAcceptanceId(UUIdUtil.getUUID());
                        workorderQualityAcceptance.setWorkorderId(workorderVo.getOrderId());
                        workorderQualityAcceptanceMapper.insert(workorderQualityAcceptance);
                    }
                }
                if ("5".equals(String.valueOf(process.getProcessSort()))) {
                    //保存工单总结
                    WorkorderSummary workorderSummary = workorderVo.getWorkorderSummary();
                    if (workorderSummary!=null) {
                        workorderSummary.setSummaryId(UUIdUtil.getUUID());
                        workorderSummary.setWorkorderId(workorderVo.getOrderId());
                        workorderSummaryMapper.insert(workorderSummary);
                        this.addMaintainFile(workorderSummary.getSummaryAttachmentList(),workorderVo.getOrderId(),"05");
                    }
                }

                //生成流程审批记录
                ApproveRecord approveRecord = new ApproveRecord();
                approveRecord.setApproveId(UUIdUtil.getUUID());
                approveRecord.setOrderId(workorderVo.getOrderId());
                approveRecord.setProcessDetailId(processDetail.getProcessDetailId());
                if (process.getProcessSort()==0 &&approveRecordService.getApproveRecordListByOrderId(workorderVo.getOrderId()).getData()!= null) {
                    approveRecord.setApproveResult("再次提交");
                }else {
                    approveRecord.setApproveResult("通过");
                }
                approveRecord.setApproveUser(currentUserService.getId());
                approveRecord.setApproveTime(new Date());
                approveRecord.setApproveOpinion(workorderVo.getExamAndApprOpinion());
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
                        ResultEntity doListResultEntity = doListService.findDoListByTaskId(workorderVo.getOrderId());
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
                            doListService.updateDoList(workorderVo.getOrderId(), doRoleRelas);
                        }
                    }
                }
            }

            //如果当前是最后一步修改流程主表,流程结束
            if (totalSort-process.getProcessSort()==1) {
                //获取代办信息
                ResultEntity doListResultEntity = doListService.findDoListByTaskId(workorderVo.getOrderId());
                DoList doList = (DoList) doListResultEntity.getData();
                if (doList != null) {
                    //修改代办角色关联列表
                    List<DoRoleRela> doRoleRelas = new ArrayList<>();
                    doListService.updateDoList(workorderVo.getOrderId(), doRoleRelas);
                }

                //修改流程主表中的状态为完成
                process.setProcessStatus("02");
                WorkorderInfo workorderInfo = workorderInfoMapper.selectByPrimaryKey(workorderVo.getOrderId());
                //设置工单流程状态跟流程主表同步
                workorderInfo.setFlowStatus(process.getProcessStatus());
                //设置工单状态为完成
                workorderInfo.setStatus("02");
                workorderInfoMapper.updateByPrimaryKeySelective(workorderInfo);
            }
            process.setProcessSort(process.getProcessSort()+1);
            processService.updateProcess(process);
        }

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("审批通过");
        return resultEntity;
    }

    @Override
    public ResultEntity backWorkorder(WorkorderVo workorderVo) {
        ResultEntity resultEntity = new ResultEntity();

        if (!StringUtils.isNoneBlank(workorderVo.getSerialNumber())) {
            resultEntity.setMsg("此工单未提交");
            return resultEntity;
        }

        //获取流程主表
        ResultEntity processResultEntity = processService.getProcessByOrderIdAndType(workorderVo.getOrderId(), "10");
        Process process = (Process)processResultEntity.getData();

        //获取流程步数
        ResultEntity totalSortResultEntity = processService.getTotalSort(process.getProcessId());
        int totalSort = (Integer) totalSortResultEntity.getData();

        if (process!=null && totalSort!=0) {
            //若审核未通过,无法再操作
            if ("03".equals(process.getProcessStatus())) {
                resultEntity.setMsg("此工单审核已结束");
                return resultEntity;
            }
            //若流程步骤为0,则无法退回
            if (process.getProcessSort()==0) {
                resultEntity.setMsg("当前步骤无法退回");
                return resultEntity;
            }
            //判断流程是否已经结束
            if (process.getProcessSort()==totalSort) {
                resultEntity.setMsg("此工单审核已结束");
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
                approveRecord.setOrderId(workorderVo.getOrderId());
                approveRecord.setProcessDetailId(processDetail.getProcessDetailId());
                approveRecord.setApproveResult("退回");
                approveRecord.setApproveUser(currentUserService.getId());
                approveRecord.setApproveTime(new Date());
                approveRecord.setApproveOpinion(workorderVo.getExamAndApprOpinion());
                //将流程审批记录插入数据库
                approveRecordService.addApproveRecord(approveRecord);
            }

            //获取上一步流程详情
            processDetailResultEntity = processService.getProcessDetailByProcessIdAndsort(process.getProcessId(), String.valueOf(process.getProcessSort()));
            processDetail = (ProcessDetail) processDetailResultEntity.getData();
            if (processDetail!=null) {
                //流程主表状态往后退一步
                process.setProcessSort(process.getProcessSort()-1);
                WorkorderInfo workorderInfo = workorderInfoMapper.selectByPrimaryKey(workorderVo.getOrderId());
                if (process.getProcessSort()==0) {
                    //设置工单状态为未提交
                    workorderVo.setStatus("03");

                }
                //修改流程主表中的状态未审核未通过
                //process.setProcessStatus("03");
                processService.updateProcess(process);

                //设置工单流程状态跟流程主表同步
                workorderInfo.setFlowStatus(process.getProcessStatus());
                //设置工单状态为审核未通过
                //workorderInfo.setStatus("04");
                workorderInfoMapper.updateByPrimaryKeySelective(workorderInfo);

                //修改上一步流程详情为待办
                processDetail.setStatus("01");
                processService.updateProcessDetail(processDetail);

                List<ProcessDetailRoleRela> processDetailRoleRelas = processDetail.getProcessDetailRoleRelas();
                if (CollectionUtils.isNotEmpty(processDetailRoleRelas)) {
                    //获取代办信息
                    ResultEntity doListResultEntity = doListService.findDoListByTaskId(workorderInfo.getOrderId());
                    DoList doList = (DoList)doListResultEntity.getData();
                    if (doList!=null) {
                        //修改代办角色关联列表
                        List<DoRoleRela> doRoleRelas = new ArrayList<>();
                            for (ProcessDetailRoleRela processDetailRoleRela:processDetailRoleRelas) {
                                DoRoleRela doRoleRela = new DoRoleRela();
                                doRoleRela.setRelaId(UUIdUtil.getUUID());
                                doRoleRela.setDoId(doList.getDoId());
                                doRoleRela.setRoleId(processDetailRoleRela.getRoleId());
                                doRoleRelas.add(doRoleRela);
                            }
                        doListService.updateDoList(workorderInfo.getOrderId(),doRoleRelas);
                    }
                }
            }
        }

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("退回成功");
        return resultEntity;
    }

    @Override
    public ResultEntity getFlowStatusList(String orderId) {
        ResultEntity resultEntity = new ResultEntity();

        if (StringUtils.isBlank(orderId)) {
            resultEntity.setMsg("id不能为空");
            return resultEntity;
        }

        resultEntity = approveRecordService.getApproveRecordListByOrderId(orderId);

        return resultEntity;
    }

    private ResultEntity insertTab(WorkorderVo workorderVo,ResultEntity resultEntity) {
        //保存工序列表
        List<WorkorderProcess> processList = workorderVo.getWorkorderProcessList();
        if ("01".equals(workorderVo.getStatus())) {
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
                if (!StringUtils.isNoneBlank(workorderProcess.getProcessExternal())) {
                    resultEntity.setMsg("工序外部不能为空");
                    return resultEntity;
                }
                workorderProcess.setProcessId(UUIdUtil.getUUID());
                workorderProcess.setProcessNumber(String.valueOf(i++));
                workorderProcess.setOrderId(workorderVo.getOrderId());
                workorderProcessMapper.insert(workorderProcess);
            }
        }
        //保存工单物资
        List<WorkorderMaterial> materialList = workorderVo.getWorkorderMaterialList();
        if (CollectionUtils.isNotEmpty(materialList)) {
            materialList.forEach(workorderMaterial -> {
                workorderMaterial.setWorkorderMaterialId(UUIdUtil.getUUID());
                workorderMaterial.setOrderId(workorderVo.getOrderId());
                workorderMaterialMapper.insert(workorderMaterial);
            });
        }
        //保存工单服务
        List<com.qz.zframe.maintain.entity.WorkorderService> serviceList = workorderVo.getWorkorderServiceList();
        if (CollectionUtils.isNotEmpty(serviceList)) {
            int i = 1;
            for (com.qz.zframe.maintain.entity.WorkorderService workorderService:serviceList) {
                if (!StringUtils.isNoneBlank(workorderService.getServiceDesc())) {
                    resultEntity.setMsg("服务描述不能为空");
                    return resultEntity;
                }
                workorderService.setServiceId(UUIdUtil.getUUID());
                workorderService.setServiceNumber(String.valueOf(i++));
                workorderService.setOrderId(workorderVo.getOrderId());
                workorderServiceMapper.insert(workorderService);
            }
        }
        //保存工单工器具
        List<WorkorderTool> toolList = workorderVo.getWorkorderToolList();
        if (CollectionUtils.isNotEmpty(toolList)) {
            int i = 1;
            for (WorkorderTool workorderTool:toolList) {
                if (!StringUtils.isNoneBlank(workorderTool.getToolDesc())) {
                    resultEntity.setMsg("工器具描述不能为空");
                    return resultEntity;
                }
                workorderTool.setToolId(UUIdUtil.getUUID());
                workorderTool.setToolNumber(String.valueOf(i++));
                workorderTool.setOrderId(workorderVo.getOrderId());
                workorderToolMapper.insert(workorderTool);
            }
        }
        //保存工单工种
        List<WorkorderWorktype> worktypeList = workorderVo.getWorkorderWorktypeList();
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
                workorderWorktype.setOrderId(workorderVo.getOrderId());
                workorderWorktypeMapper.insert(workorderWorktype);
            };
        }
        //保存工单危险点控制
        List<WorkorderDangerPoint> dangerPointList = workorderVo.getWorkorderDangerPointList();
        if (CollectionUtils.isNotEmpty(dangerPointList)) {
            int i = 1;
            for (WorkorderDangerPoint workorderDangerPoint:dangerPointList) {
                if (!StringUtils.isNoneBlank(workorderDangerPoint.getDangerDangerSource())) {
                    resultEntity.setMsg("危险源不能为空");
                    return resultEntity;
                }
                workorderDangerPoint.setDangerPointId(UUIdUtil.getUUID());
                workorderDangerPoint.setDangerNumber(String.valueOf(i++));
                workorderDangerPoint.setOrderId(workorderVo.getOrderId());
                workorderDangerPointMapper.insert(workorderDangerPoint);
            }
        }

        //关联工作票
        List<WorkTicketForWorkorederVo> workTicketForWorkorederVoList = workorderVo.getWorkTicketForWorkorederVoList();
        if (CollectionUtils.isNotEmpty(workTicketForWorkorederVoList)) {
            workTicketForWorkorederVoList.forEach(workTicketForWorkorederVo -> {
                WorkTicket workTicket = workTicketMapper.selectByPrimaryKey(workTicketForWorkorederVo.getTicketId());
                if (workTicket!=null) {
                    workTicket.setOrderId(workorderVo.getOrderId());
                    workTicketMapper.updateByPrimaryKey(workTicket);
                }
            });
        }
        //关联工单
        List<OperateTicketForWorkorderVo> operateTicketForWorkorderVoList = workorderVo.getOperateTicketForWorkorderVoList();
        if (CollectionUtils.isNotEmpty(operateTicketForWorkorderVoList)) {
            operateTicketForWorkorderVoList.forEach(operateTicketForWorkorderVo -> {
                OperateTicket operateTicket = operateTicketMapper.selectByPrimaryKey(operateTicketForWorkorderVo.getTicketId());
                if (operateTicket!=null) {
                    operateTicket.setOrderId(workorderVo.getOrderId());
                    operateTicketMapper.updateByPrimaryKey(operateTicket);
                }
            });
        }
        return resultEntity;
    }

    private ResultEntity updateTab(WorkorderVo workorderVo,ResultEntity resultEntity) {
        //删除原来的工序
        WorkorderProcessExample workorderProcessExample = new WorkorderProcessExample();
        workorderProcessExample.createCriteria().andOrderIdEqualTo(workorderVo.getOrderId());
        workorderProcessMapper.deleteByExample(workorderProcessExample);
        //删除原来的物资
        WorkorderMaterialExample workorderMaterialExample = new WorkorderMaterialExample();
        workorderMaterialExample.createCriteria().andOrderIdEqualTo(workorderVo.getOrderId());
        workorderMaterialMapper.deleteByExample(workorderMaterialExample);
        //删除原来的服务
        WorkorderServiceExample workorderServiceExample = new WorkorderServiceExample();
        workorderServiceExample.createCriteria().andOrderIdEqualTo(workorderVo.getOrderId());
        workorderServiceMapper.deleteByExample(workorderServiceExample);
        //删除原来的工器具
        WorkorderToolExample workorderToolExample = new WorkorderToolExample();
        workorderToolExample.createCriteria().andOrderIdEqualTo(workorderVo.getOrderId());
        workorderToolMapper.deleteByExample(workorderToolExample);
        //删除原来的工种
        WorkorderWorktypeExample workorderWorktypeExample = new WorkorderWorktypeExample();
        workorderWorktypeExample.createCriteria().andOrderIdEqualTo(workorderVo.getOrderId());
        workorderWorktypeMapper.deleteByExample(workorderWorktypeExample);
        //删除原来的危险点
        WorkorderDangerPointExample workorderDangerPointExample = new WorkorderDangerPointExample();
        workorderDangerPointExample.createCriteria().andOrderIdEqualTo(workorderVo.getOrderId());
        workorderDangerPointMapper.deleteByExample(workorderDangerPointExample);

        List<String> orderIdList = new ArrayList<>();
        orderIdList.add(workorderVo.getOrderId());
        //解除工单与工作票的关联
        workTicketMapper.batchDeleteFalseByOrderIds(orderIdList);
        //解除工单与操作票的关联
        operateTicketMapper.batchDeleteFalseByOrderIds(orderIdList);

        //重新添加
        resultEntity = this.insertTab(workorderVo,resultEntity);
        return resultEntity;
    }

    private void deleteTab(List<String> orderIdList) {
        //根据工单ids删除工序
        workorderProcessMapper.batchDeleteByOrderIds(orderIdList);
        //根据工单ids删除物资
        workorderMaterialMapper.batchDeleteByOrderIds(orderIdList);
        //根据工单ids删除服务
        workorderServiceMapper.batchDeleteByOrderIds(orderIdList);
        //根据工单ids删除工器具
        workorderToolMapper.batchDeleteByOrderIds(orderIdList);
        //根据工单ids删除工种
        workorderWorktypeMapper.batchDeleteByOrderIds(orderIdList);
        //根据工单ids删除危险点
        workorderDangerPointMapper.batchDeleteByOrderIds(orderIdList);
        //批量解除工单与工作票的关联
        workTicketMapper.batchDeleteFalseByOrderIds(orderIdList);
        //批量解除工单与操作票的关联
        operateTicketMapper.batchDeleteFalseByOrderIds(orderIdList);
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

    //将人员id字符串转成姓名字符串,给unitMemberNames和setUnitMemberArray赋值  select
    private void setUnitMemberNamesAndUnitMemberArray(WorkorderVo workorderVo) throws Exception {
        String unitMember = workorderVo.getUnitMember();
        if (unitMember!=null) {
            String[] ids = unitMember.split(",");
            if (ArrayUtils.isNotEmpty(ids)) {
                //
                workorderVo.setUnitMemberArray(ids);
                //
                StringBuffer sb = new StringBuffer();
                for (String id : ids) {
                    try {
                        UserDto userDto = userService.queryUserInfo(id, null);
                        if (userDto != null) {
                            sb.append(userDto.getUserName()).append(",");
                        }
                    }catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (sb.length()>1) {
                    workorderVo.setUnitMemberNames(sb.deleteCharAt(sb.length() - 1).toString());
                }
            }
        }
    }

    //设置本单位工作人员字符串,逗号隔开  save
    private void setUnitMember(WorkorderVo workorderVo) {
        String[] unitMemberArray = workorderVo.getUnitMemberArray();
        if (ArrayUtils.isNotEmpty(unitMemberArray)) {
            StringBuffer sb = new StringBuffer();
            for (String id:unitMemberArray) {
                sb.append(id).append(",");
            }
            if (sb.length()>1) {
                workorderVo.setUnitMember(sb.deleteCharAt(sb.length()-1).toString());
            }
        }
    }

    private void addMaintainFile(List<FileInfo> attachmentList,String orderId,String type) {
        List<MaintainFile> maintainFiles = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(attachmentList)) {
            for (FileInfo fileInfo:attachmentList) {
                MaintainFile maintainFile = new MaintainFile();
                maintainFile.setId(UUIdUtil.getUUID());
                maintainFile.setAssoId(orderId);
                maintainFile.setFileId(fileInfo.getFileId());
                maintainFile.setType(type);
                maintainFiles.add(maintainFile);
            }
            maintainFileMapper.insertList(maintainFiles);
        }
    }

    private void updateMaintainFileAndRemoveFile(List<FileInfo> attachmentList,String orderId,String type) {
        List<String> attachmentFileIds = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(attachmentList)) {
            for (FileInfo fileInfo:attachmentList) {
                attachmentFileIds.add(fileInfo.getFileId());
            }

            List<String> fileIdList = maintainFileMapper.getMaintainFileList(orderId,type);
            if (CollectionUtils.isNotEmpty(fileIdList)) {
                for (String fileId:fileIdList) {
                    if (!attachmentFileIds.contains(fileId)) {
                        try {
                            commonService.removeFile(fileId);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        //删除中间表的文件
                        maintainFileMapper.deleteByFileId(fileId);
                    }
                }
                List<MaintainFile> maintainFiles = new ArrayList<>();
                for (String fileId:attachmentFileIds) {
                    if (!fileIdList.contains(fileId)) {
                        MaintainFile maintainFile = new MaintainFile();
                        maintainFile.setId(UUIdUtil.getUUID());
                        maintainFile.setAssoId(orderId);
                        maintainFile.setFileId(fileId);
                        maintainFile.setType(type);
                        maintainFiles.add(maintainFile);
                    }
                }
                maintainFileMapper.insertList(maintainFiles);
            }else {
                this.addMaintainFile(attachmentList,orderId,type);
            }
        }else {
            maintainFileMapper.batchDeleteByAssoId(orderId,type);
        }
    }

    @Override
    public ResultEntity cancelChangeFile(String orderId, List<FileInfo> attachmentList) {
        ResultEntity resultEntity = new ResultEntity();

        if (StringUtils.isNoneBlank(orderId) && CollectionUtils.isNotEmpty(attachmentList) ) {
            List<String> fileIdList = maintainFileMapper.getMaintainFileList(orderId,"04");
            for (FileInfo fileInfo:attachmentList) {
                String fileId = fileInfo.getFileId();
                if (StringUtils.isNoneBlank(fileId)) {
                    if (StringUtils.isNoneBlank(fileId)) {
                        if(!fileIdList.contains(fileId)) {
                            try {
                                commonService.removeFile(fileId);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("操作成功");
        return resultEntity;
    }

    private List<FileInfo> getFile(String orderId,String type) {

        List<FileInfo> fileInfos = new ArrayList<>();
        List<String> fileIdList = maintainFileMapper.getMaintainFileList(orderId, type);
        if (CollectionUtils.isNotEmpty(fileIdList)) {
            for (String fileId:fileIdList) {
                FileInfo fileInfo = new FileInfo();
                SpFileUpload spFileUpload = new SpFileUpload();
                spFileUpload.setFileId(fileId);
                List<SpFileUpload> spFileUploads = commonDao.findfileUploadList(spFileUpload);
                if (CollectionUtils.isNotEmpty(spFileUploads)) {
                    fileInfo.setFileId(spFileUploads.get(0).getFileId());
                    fileInfo.setFileName(spFileUploads.get(0).getOriginalName());
                    fileInfo.setName(spFileUploads.get(0).getOriginalName());
                    fileInfos.add(fileInfo);
                }
            }
        }
        return fileInfos;
    }
}
