package com.qz.zframe.tickets.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.qz.zframe.authentication.CurrentUserService;
import com.qz.zframe.common.dao.UserDao;
import com.qz.zframe.common.entity.*;
import com.qz.zframe.common.entity.Process;
import com.qz.zframe.common.service.*;
import com.qz.zframe.common.util.*;
import com.qz.zframe.tickets.entity.*;
import com.qz.zframe.tickets.mapper.*;
import com.qz.zframe.tickets.vo.*;
import com.qz.zframe.tickets.service.WorkTicketService;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@Transactional(rollbackFor = Exception.class)
public class WorkTicketServiceImpl implements WorkTicketService {

    @Autowired
    private WorkTicketMapper workTicketMapper;

    @Autowired
    private WorkTicketSafeMeasureMapper workTicketSafeMeasureMapper;

    @Autowired
    private WorkTicketRiskControlMapper workTicketRiskControlMapper;

    @Autowired
    private WorkTicketWorkTimeMapper workTicketWorkTimeMapper;

    @Autowired
    private StandardWorkTicketMapper standardWorkTicketMapper;

    @Autowired
    private WorkTicketTypeMapper workTicketTypeMapper;

    @Autowired
    private CurrentUserService currentUserService;

    @Autowired
    private DeployService deployService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserDao userDao;

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
    public ResultEntity addWorkTicket(WorkTicketVo workTicketVo) throws ParseException {
        ResultEntity resultEntity = new ResultEntity();

        //设置id
        workTicketVo.setTicketId(UUIdUtil.getUUID());
        //设置工作票状态为未提交
        workTicketVo.setStatus("03");
        //添加维护人
        workTicketVo.setMaintainer(currentUserService.getId());
        //添加维护日期
        workTicketVo.setMaintainDate(new Date());
        //添加人员id字符串
        String[] members=workTicketVo.getWorkMemberNames2();
        if (members!=null && members.length!=0){
            StringBuilder sb=new StringBuilder();
            int len=members.length;
            for (int n=0;n<len;n++){
                    sb.append(members[n]).append(",");
            }
            workTicketVo.setWorkMember(sb.toString().substring(0,sb.toString().length()-1));
        }

        //插入数据库
        workTicketMapper.insertSelective(workTicketVo);
        //添加安全措施等tab页
        this.insertTab(workTicketVo);

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("信息已保存");
        return resultEntity;
    }

    @Override
    public ResultEntity updateWorkTicket(WorkTicketVo workTicketVo) {
        ResultEntity resultEntity = new ResultEntity();

        if (!StringUtils.isNoneBlank(workTicketVo.getTicketId())) {
            resultEntity.setMsg("id不能为空");
            return resultEntity;
        }
        //修改维护日期
        workTicketVo.setMaintainDate(new Date());

        WorkTicket workTicket = workTicketMapper.selectByPrimaryKey(workTicketVo.getTicketId());
        if ("03".equals(workTicket.getStatus())) {
            String[] members=workTicketVo.getWorkMemberNames2();
            if (members!=null && members.length!=0){
                StringBuilder sb=new StringBuilder();
                int len=members.length;
                for (int n=0;n<len;n++){
                    sb.append(members[n]).append(",");
                }
                workTicket.setWorkMember(sb.toString().substring(0,sb.toString().length()-1));
            }

            //修改工作票主数据
            BeanUtil.copyProperties(workTicketVo,workTicket,true, CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true));
            workTicketMapper.updateByPrimaryKeySelective(workTicket);
            //修改安全措施tab页
            this.updateTab(workTicketVo);
        }else {
            resultEntity.setMsg("此工作票已提交");
            return resultEntity;
        }
        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("修改成功");
        return resultEntity;
    }

    @Override
    public ResultEntity submitWorkTicket(WorkTicketVo workTicketVo) throws Exception {
        ResultEntity resultEntity = new ResultEntity();

        if (!StringUtils.isNoneBlank(workTicketVo.getWorkTicketTypeId())) {
            resultEntity.setMsg("工作票类型不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(workTicketVo.getWindId())) {
            resultEntity.setMsg("风电场不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(workTicketVo.getCrewId())) {
            resultEntity.setMsg("机组不能为空");
            return resultEntity;
        }
        if (workTicketVo.getApplyTime()==null) {
            resultEntity.setMsg("申请时间不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(workTicketVo.getWorkTeam())) {
            resultEntity.setMsg("工作班组不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(workTicketVo.getWorkHead())) {
            resultEntity.setMsg("工作负责人不能为空");
            return resultEntity;
        }
        if (workTicketVo.getPlanStartTime()==null) {
            resultEntity.setMsg("计划开始时间不能为空");
            return resultEntity;
        }
        if (workTicketVo.getPlanEndTime()==null) {
            resultEntity.setMsg("计划结束时间不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(workTicketVo.getDoubleNaem())) {
            resultEntity.setMsg("工作的风电场、升压站名称及设备双重名称不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(workTicketVo.getWorkPlace())) {
            resultEntity.setMsg("工作地点或地段不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(workTicketVo.getWorkContent())) {
            resultEntity.setMsg("工作内容不能为空");
            return resultEntity;
        }

        if (!StringUtils.isNoneBlank(workTicketVo.getTicketId())) {
            //设置id
            workTicketVo.setTicketId(UUIdUtil.getUUID());
            //生成流水号
            WorkTicketExample workTicketExample = new WorkTicketExample();
            workTicketExample.createCriteria().andSerialNumberIsNotNull();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
            String tail = String.valueOf(1000000+workTicketMapper.countByExample(workTicketExample)+1).substring(1);
            workTicketVo.setSerialNumber(simpleDateFormat.format(new Date())+tail);
            //设置工作票状态为处理中
            workTicketVo.setStatus("01");
            //添加维护人
            workTicketVo.setMaintainer(currentUserService.getId());
            //添加维护日期
            workTicketVo.setMaintainDate(new Date());
            //插入数据库
            workTicketMapper.insert(workTicketVo);
            //添加安全措施等tab页
            this.insertTab(workTicketVo);
        }else {
            WorkTicket workTicket = workTicketMapper.selectByPrimaryKey(workTicketVo.getTicketId());
            if (!"03".equals(workTicket.getStatus())) {
                resultEntity.setMsg("此工作票已提交");
                return resultEntity;
            }

            if (!StringUtils.isNoneBlank(workTicketVo.getSerialNumber())) {
                //生成流水号
                WorkTicketExample workTicketExample1 = new WorkTicketExample();
                workTicketExample1.createCriteria().andSerialNumberIsNotNull();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
                String tail = String.valueOf(1000000+workTicketMapper.countByExample(workTicketExample1)+1).substring(1);
                workTicketVo.setSerialNumber(simpleDateFormat.format(new Date())+tail);
            }
            //设置状态为处理中
            workTicketVo.setStatus("01");
            //修改维护日期
            workTicketVo.setMaintainDate(new Date());
            //修改数据库工作票
            BeanUtil.copyProperties(workTicketVo,workTicket,true, CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true));
            workTicketMapper.updateByPrimaryKey(workTicket);
            //修改安全措施等tab页
            this.updateTab(workTicketVo);
        }

        //获取流程配置
        DeployMain deployMain = deployService.queryDeployMainById("3");
        if (deployMain!=null) {
            //生成流程主表,流程详情,流程角色配置
            Process process = new Process();
            process.setProcessId(UUIdUtil.getUUID());
            process.setOrderId(workTicketVo.getTicketId());
            process.setProcessSort(1);
            process.setProcessType("07");
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
                approveRecord.setOrderId(workTicketVo.getTicketId());
                approveRecord.setProcessDetailId(processDetail.getProcessDetailId());
                approveRecord.setApproveResult("提交成功");
                approveRecord.setApproveUser(currentUserService.getId());
                approveRecord.setApproveTime(new Date());
                approveRecord.setApproveOpinion(workTicketVo.getExamAndApprOpinion());
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
                doList.setTaskId(workTicketVo.getTicketId());
                doList.setTaskCode(workTicketVo.getSerialNumber());
                doList.setTaskDescribe(workTicketTypeMapper.getNameById(workTicketVo.getWorkTicketTypeId()));
                doList.setTaskType("07");
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

                //修改工作票中的流程状态
                WorkTicket workTicket = workTicketMapper.selectByPrimaryKey(workTicketVo.getTicketId());
                workTicket.setFlowStatus(process.getProcessStatus());
                workTicketMapper.updateByPrimaryKeySelective(workTicket);
            }
        }


        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("提交成功");
        return resultEntity;
    }

    @Override
    public ResultEntity deleteWorkTicket(String[] ticketIds) {
        ResultEntity resultEntity = new ResultEntity();

        if (!(ticketIds!=null && ticketIds.length!=0)) {
            resultEntity.setMsg("ids不能为空");
            return resultEntity;
        }
        List<String> ticketIdList1 = new ArrayList<>();
        List<String> ticketIdList2 = new ArrayList<>();
        for (String ticketId:ticketIds) {
            WorkTicket workTicket = workTicketMapper.selectByPrimaryKey(ticketId);
            if (workTicket!=null) {
                if ("03".equals(workTicket.getStatus())) {
                    if (workTicket.getSerialNumber()==null) {
                        //删除操作票
                        ticketIdList1.add(ticketId);
                    }else {
                        ticketIdList2.add(ticketId);
                    }
                }else {
                    resultEntity.setMsg("此工作票已提交");
                    return resultEntity;
                }
            }
        }
        if (CollectionUtils.isNotEmpty(ticketIdList1)) {
            //删除工作票
            workTicketMapper.batchDeleteTrue(ticketIdList1);
            //删除安全措施和危险因素控制措施
            this.deleteTab(ticketIdList1);
        }
        if (CollectionUtils.isNotEmpty(ticketIdList2)) {
            //删除工作票
            workTicketMapper.batchDeleteFalse(ticketIdList2);
        }

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("删除成功");
        return resultEntity;
    }

    @Override
    public ResultEntity getWorkTicketDetail(String ticketId) {
        ResultEntity resultEntity = new ResultEntity();

        if (!StringUtils.isNoneBlank(ticketId)) {
            resultEntity.setMsg("id不能为空");
            return resultEntity;
        }
        //获取工作票主数据
        WorkTicketVo workTicketVo = workTicketMapper.getWorkTicketDetail(ticketId);
        if (workTicketVo!=null) {
            workTicketVo.setStatusName(this.getStatusName(workTicketVo.getStatus()));
            //获取工作人员姓名  并给人员id数组赋值
            this.setWorkMemberNamesAndWorkMemberArray(workTicketVo);
            //获取安全措施
            WorkTicketSafeMeasureExample workTicketSafeMeasureExample = new WorkTicketSafeMeasureExample();
            workTicketSafeMeasureExample.setOrderByClause("safe_number");
            workTicketSafeMeasureExample.createCriteria().andTicketIdEqualTo(workTicketVo.getTicketId());
            List<WorkTicketSafeMeasure> safeMeasureList = workTicketSafeMeasureMapper.selectByExample(workTicketSafeMeasureExample);
            if (CollectionUtils.isNotEmpty(safeMeasureList)) {
                safeMeasureList.forEach(workTicketSafeMeasure -> {
                    workTicketVo.getSafeMeasureList().add(workTicketSafeMeasure);
                });
            }
            //获取危险因素控制措施
            List<WorkTicketRiskControlVo> riskControlList = workTicketRiskControlMapper.getWorkTicketRiskControlList(workTicketVo.getTicketId());
            if (CollectionUtils.isNotEmpty(riskControlList)) {
                riskControlList.forEach(workTicketRiskControl -> {
                    workTicketVo.getRiskControlList().add(workTicketRiskControl);
                });
            }
            //获取开工收工工作时间
            List<WorkTicketWorkTimeVo> workTimeList = workTicketWorkTimeMapper.getWorkTicketWorkTimeList(workTicketVo.getTicketId());
            if (CollectionUtils.isNotEmpty(workTimeList)) {
                workTimeList.forEach(workTicketWorkTime -> {
                    workTicketVo.getWorkTimeList().add(workTicketWorkTime);
                });
            }

        }

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("查询成功");
        resultEntity.setData(workTicketVo);
        return resultEntity;
    }

    @Override
    public ResultEntity printWorkTicket(String ticketId) {
        ResultEntity resultEntity = new ResultEntity();

        if (!StringUtils.isNoneBlank(ticketId)) {
            resultEntity.setMsg("id不能为空");
            return resultEntity;
        }
        //获取工作票主数据
        WorkTicketVo workTicketVo = workTicketMapper.getWorkTicketDetail(ticketId);
        if (workTicketVo!=null) {
            if ("03".equals(workTicketVo.getStatus())) {
                resultEntity.setMsg("此工作票未提交");
                return resultEntity;
            }
            workTicketVo.setStatusName(this.getStatusName(workTicketVo.getStatus()));
            //获取工作人员姓名  并给人员id数组赋值
            this.setWorkMemberNamesAndWorkMemberArray(workTicketVo);
            //获取安全措施
            WorkTicketSafeMeasureExample workTicketSafeMeasureExample = new WorkTicketSafeMeasureExample();
            workTicketSafeMeasureExample.setOrderByClause("safe_number");
            workTicketSafeMeasureExample.createCriteria().andTicketIdEqualTo(workTicketVo.getTicketId());
            List<WorkTicketSafeMeasure> safeMeasureList = workTicketSafeMeasureMapper.selectByExample(workTicketSafeMeasureExample);
            if (CollectionUtils.isNotEmpty(safeMeasureList)) {
                for (WorkTicketSafeMeasure workTicketSafeMeasure:safeMeasureList) {
                    workTicketVo.getSafeMeasureList().add(workTicketSafeMeasure);
                }
            }
            //获取危险因素控制措施
            List<WorkTicketRiskControlVo> riskControlList = workTicketRiskControlMapper.getWorkTicketRiskControlList(workTicketVo.getTicketId());
            if (CollectionUtils.isNotEmpty(riskControlList)) {
                riskControlList.forEach(workTicketRiskControl -> {
                    workTicketVo.getRiskControlList().add(workTicketRiskControl);
                });
            }
            //获取开工收工工作时间
            List<WorkTicketWorkTimeVo> workTimeList = workTicketWorkTimeMapper.getWorkTicketWorkTimeList(workTicketVo.getTicketId());
            if (CollectionUtils.isNotEmpty(workTimeList)) {
                workTimeList.forEach(workTicketWorkTime -> {
                    workTicketVo.getWorkTimeList().add(workTicketWorkTime);
                });
            }
        }

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("查询成功");
        resultEntity.setData(workTicketVo);
        return resultEntity;
    }

    @Override
    public PageResultEntity getWorkTicketList(Map<String,String> pageAndCondition) throws Exception {
        PageResultEntity pageResultEntity = new PageResultEntity();
        pageResultEntity.setRows(new ArrayList());

        String start = String.valueOf((Integer.parseInt( pageAndCondition.get("pageNum"))-1)*(Integer.parseInt( pageAndCondition.get("pageSize"))));
        pageAndCondition.put("start",start);
        pageAndCondition.put("startTime",this.converDayToTime1(pageAndCondition.get("startTime")));
        pageAndCondition.put("endTime",this.converDayToTime2(pageAndCondition.get("endTime")));
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
        List<WorkTicketVo> workTicketVoList= workTicketMapper.getWorkTicketList(pageAndCondition,userId,userRoleList);
        for (WorkTicketVo workTicketVo:workTicketVoList) {
            if (workTicketVo!=null) {
                workTicketVo.setStatusName(this.getStatusName(workTicketVo.getStatus()));
                //获取工作人员姓名  并给人员id数组赋值
                this.setWorkMemberNamesAndWorkMemberArray(workTicketVo);
            }
        }
        int total = workTicketMapper.getTotal(pageAndCondition,userId,userRoleList);

        pageResultEntity.setCode(ErrorCode.SUCCESS);
        pageResultEntity.setMsg("查询成功");
        pageResultEntity.setRows(workTicketVoList);
        pageResultEntity.setTotal(total);
        return pageResultEntity;
    }

    @Override
    public ResultEntity removeWorkTicketForWorkorder(String ticketId) {
        ResultEntity resultEntity = new ResultEntity();

        if (!StringUtils.isNoneBlank(ticketId)) {
            resultEntity.setMsg("id不能为空");
            return resultEntity;
        }

        //修改工作票主数据
        WorkTicket workTicket = workTicketMapper.selectByPrimaryKey(ticketId);
        workTicket.setWorkorderId(null);
        workTicket.setOrderId(null);
        workTicketMapper.updateByPrimaryKey(workTicket);

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("删除成功");
        return resultEntity;
    }


    @Override
    public PageResultEntity getWorkTicketListForWorkorder(Map<String,String> pageAndCondition) throws Exception {
        PageResultEntity pageResultEntity = new PageResultEntity();
        pageResultEntity.setRows(new ArrayList());

        String start = String.valueOf((Integer.parseInt( pageAndCondition.get("pageNum"))-1)*(Integer.parseInt( pageAndCondition.get("pageSize"))));
        pageAndCondition.put("start",start);
        pageAndCondition.put("startTime",this.converDayToTime1(pageAndCondition.get("startTime")));
        pageAndCondition.put("endTime",this.converDayToTime2(pageAndCondition.get("endTime")));
        List<WorkTicketVo> workTicketVoList= workTicketMapper.getWorkTicketListForWorkorder(pageAndCondition);
        for (WorkTicketVo workTicketVo:workTicketVoList) {
            if (workTicketVo!=null) {
                workTicketVo.setStatusName(this.getStatusName(workTicketVo.getStatus()));
                //获取工作人员姓名  并给人员id数组赋值
                this.setWorkMemberNamesAndWorkMemberArray(workTicketVo);
            }
        }
        int total = workTicketMapper.getTotalForWorkorder(pageAndCondition);

        pageResultEntity.setCode(ErrorCode.SUCCESS);
        pageResultEntity.setMsg("查询成功");
        pageResultEntity.setRows(workTicketVoList);
        pageResultEntity.setTotal(total);
        return pageResultEntity;
    }

    @Override
    public ResultEntity getWorkTicketStatistics(String startDate, String endDate,String startWindCode,String endWindCode) {
        ResultEntity resultEntity = new ResultEntity();
        List<TicketStatisticsRes> workTicketStatisticsList=null;

        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String startTime=null;
            String endTime=null;
            if (startDate!=null) {
                startTime = simpleDateFormat.format(simpleDateFormat.parse(startDate));
            }
            if (endDate!=null) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(simpleDateFormat.parse(endDate));
                calendar.add(Calendar.DAY_OF_MONTH,1);
                endTime = simpleDateFormat.format(calendar.getTime());
            }
            workTicketStatisticsList =  workTicketMapper.getWorkTicketStatisticsList(startTime, endTime,startWindCode,endWindCode);
            //合计
            int totalApplyCount = 0;
            int totalInProcessCount = 0;
            int totalCompleteCount = 0;
            int totalInvalidCount = 0;
            for (TicketStatisticsRes ticketStatisticsRes: workTicketStatisticsList) {
                totalApplyCount += Integer.parseInt(ticketStatisticsRes.getApplyCount());
                totalInProcessCount += Integer.parseInt(ticketStatisticsRes.getInProcessCount());
                totalCompleteCount += Integer.parseInt(ticketStatisticsRes.getCompleteCount());
                totalInvalidCount += Integer.parseInt(ticketStatisticsRes.getInvalidCount());
                ticketStatisticsRes.setCompleteRate(String.valueOf(new DecimalFormat("0.00").
                        format(Double.parseDouble(ticketStatisticsRes.getCompleteRate())*100))+"%");
            }
            TicketStatisticsRes ticketStatisticsRes = new TicketStatisticsRes();
            ticketStatisticsRes.setWindName("合计");
            ticketStatisticsRes.setApplyCount(String.valueOf(totalApplyCount));
            ticketStatisticsRes.setInProcessCount(String.valueOf(totalInProcessCount));
            ticketStatisticsRes.setCompleteCount(String.valueOf(totalCompleteCount));
            ticketStatisticsRes.setInvalidCount(String.valueOf(totalInvalidCount));
            if (totalApplyCount!=0) {
                ticketStatisticsRes.setCompleteRate(String.valueOf(new DecimalFormat("0.00").
                        format((totalCompleteCount/totalApplyCount)*100))+"%");
            }
            workTicketStatisticsList.add(ticketStatisticsRes);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("操作成功");
        resultEntity.setData(workTicketStatisticsList);
        return resultEntity;
    }

    @Override
    public void exportToExcel(String startDate, String endDate, String startWindCode,String endWindCode,HttpServletResponse response) {
        ResultEntity resultEntity = this.getWorkTicketStatistics(startDate, endDate, startWindCode,endWindCode);
        List<TicketStatisticsRes> workTicketStatisticsList = (List<TicketStatisticsRes>)resultEntity.getData();

        LinkedHashMap<String, String> testMap = new LinkedHashMap<String, String>();
        testMap.put("windName", "风电场");
        testMap.put("applyCount", "申请数");
        testMap.put("inProcessCount", "处理中");
        testMap.put("completeCount", "完成");
        testMap.put("invalidCount", "作废");
        testMap.put("completeRate", "完成率");

        try {
            ExcelUtil.listToExcel2(workTicketStatisticsList, testMap, "工作票统计", 65535, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public ResultEntity agreeWorkTicket(WorkTicketVo workTicketVo) {
        ResultEntity resultEntity = new ResultEntity();

        if (!StringUtils.isNoneBlank(workTicketVo.getSerialNumber())) {
            resultEntity.setMsg("此工作票未提交");
            return resultEntity;
        }
        //获取流程主表
        ResultEntity processResultEntity = processService.getProcessByOrderIdAndType(workTicketVo.getTicketId(), "07");
        Process process = (Process)processResultEntity.getData();

        //获取流程步数
        ResultEntity totalSortResultEntity = processService.getTotalSort(process.getProcessId());
        int totalSort = (Integer) totalSortResultEntity.getData();

        if (process!=null && totalSort!=0) {
            //判断流程是否已经结束
            if (process.getProcessSort()==totalSort) {
                resultEntity.setMsg("此工作票审核已结束");
                return resultEntity;
            }
            if ("03".equals(process.getProcessStatus())) {
                resultEntity.setMsg("此工作票审核已结束");
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
                approveRecord.setOrderId(workTicketVo.getTicketId());
                approveRecord.setProcessDetailId(processDetail.getProcessDetailId());
                approveRecord.setApproveResult("通过");
                approveRecord.setApproveUser(currentUserService.getId());
                approveRecord.setApproveTime(new Date());
                approveRecord.setApproveOpinion(workTicketVo.getExamAndApprOpinion());
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
                        ResultEntity doListResultEntity = doListService.findDoListByTaskId(workTicketVo.getTicketId());
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
                            doListService.updateDoList(workTicketVo.getTicketId(), doRoleRelas);
                        }
                    }
                }
            }

            //如果当前是最后一步修改流程主表,流程结束
            if (totalSort-process.getProcessSort()==1) {
                //获取代办信息
                ResultEntity doListResultEntity = doListService.findDoListByTaskId(workTicketVo.getTicketId());
                DoList doList = (DoList) doListResultEntity.getData();
                if (doList != null) {
                    //修改代办角色关联列表
                    List<DoRoleRela> doRoleRelas = new ArrayList<>();
                    doListService.updateDoList(workTicketVo.getTicketId(), doRoleRelas);
                }

                //设置流程主表状态未已完成
                process.setProcessStatus("02");

                WorkTicket workTicket = workTicketMapper.selectByPrimaryKey(workTicketVo.getTicketId());
                //设置工作票流程状态跟流程主表同步
                workTicket.setFlowStatus(process.getProcessStatus());
                //设置工作票状态为完成
                workTicket.setStatus("02");
                workTicketMapper.updateByPrimaryKeySelective(workTicket);
            }

            process.setProcessSort(process.getProcessSort()+1);
            processService.updateProcess(process);
        }

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("审批通过");
        return resultEntity;
    }

    @Override
    public ResultEntity backWorkTicket(WorkTicketVo workTicketVo) {
        ResultEntity resultEntity = new ResultEntity();

        if (StringUtils.isBlank(workTicketVo.getSerialNumber())) {
            resultEntity.setMsg("此工作票未提交");
            return resultEntity;
        }

        //获取流程主表
        ResultEntity processResultEntity = processService.getProcessByOrderIdAndType(workTicketVo.getTicketId(), "07");
        Process process = (Process)processResultEntity.getData();

        //获取流程步数
        ResultEntity totalSortResultEntity = processService.getTotalSort(process.getProcessId());
        int totalSort = (Integer) totalSortResultEntity.getData();

        if (process!=null && totalSort!=0) {
            //处理中的流程才能退回
            if ("03".equals(process.getProcessStatus())) {
                resultEntity.setMsg("此工作票审核已结束");
                return resultEntity;
            }
            //若流程步骤为0,则无法退回
            if (process.getProcessSort()==0) {
                resultEntity.setMsg("当前步骤无法退回");
                return resultEntity;
            }
            //判断流程是否已经结束
            if (process.getProcessSort()==totalSort) {
                resultEntity.setMsg("此工作票审核已结束");
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

                //将审核人和审核时间回写进工作票中
                WorkTicket workTicket = workTicketMapper.selectByPrimaryKey(workTicketVo.getTicketId());
                BeanUtil.copyProperties(workTicketVo,workTicket,true, CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true));
                workTicketMapper.updateByPrimaryKeySelective(workTicket);


                //生成流程审批记录
                ApproveRecord approveRecord = new ApproveRecord();
                approveRecord.setApproveId(UUIdUtil.getUUID());
                approveRecord.setOrderId(workTicketVo.getTicketId());
                approveRecord.setProcessDetailId(processDetail.getProcessDetailId());
                approveRecord.setApproveResult("拒绝");
                approveRecord.setApproveUser(currentUserService.getId());
                approveRecord.setApproveTime(new Date());
                approveRecord.setApproveOpinion(workTicketVo.getExamAndApprOpinion());
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
                    //设置工作票状态为未提交
                    operateTicket.setStatus("03");

                }*/
                //修改流程主表中的状态未审核未通过
                process.setProcessStatus("03");
                processService.updateProcess(process);
                WorkTicket workTicket = workTicketMapper.selectByPrimaryKey(workTicketVo.getTicketId());
                //设置工作票流程状态跟流程主表同步
                workTicket.setFlowStatus(process.getProcessStatus());
                //设置工作票状态为审核未通过
                workTicket.setStatus("04");
                workTicketMapper.updateByPrimaryKeySelective(workTicket);

                //修改上一步流程详情为待办
                /*processDetail.setStatus("01");
                processService.updateProcessDetail(processDetail);*/

                //List<ProcessDetailRoleRela> processDetailRoleRelas = processDetail.getProcessDetailRoleRelas();
                //if (CollectionUtils.isNotEmpty(processDetailRoleRelas)) {
                //获取代办信息
                ResultEntity doListResultEntity = doListService.findDoListByTaskId(workTicketVo.getTicketId());
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
                    doListService.updateDoList(workTicket.getTicketId(),doRoleRelas);
                }
                //}
            }
        }

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("退回成功");
        return resultEntity;
    }

    @Override
    public ResultEntity getFlowStatusList(String ticketId) {
        ResultEntity resultEntity = new ResultEntity();

        if (StringUtils.isBlank(ticketId)) {
            resultEntity.setMsg("id不能为空");
            return resultEntity;
        }

        resultEntity = approveRecordService.getApproveRecordListByOrderId(ticketId);

        return resultEntity;
    }

    @Override
    public ResultEntity createStandardWorkTicket(WorkTicketVo workTicketVo) throws ParseException {
        ResultEntity resultEntity = new ResultEntity();

        String ticketId = workTicketVo.getTicketId();
        if (!StringUtils.isNoneBlank(ticketId)) {
            resultEntity.setMsg("工作票id不能为空");
            return resultEntity;
        }

        WorkTicket workTicket = workTicketMapper.selectByPrimaryKey(ticketId);
        if (workTicket!=null) {
            //创建标准工作票对象
            StandardWorkTicket standardWorkTicket = new StandardWorkTicket();
            //设置id
            standardWorkTicket.setStandardTicketId(UUIdUtil.getUUID());
            //设置流水号
            String prefix = "";
            String ticketTypeName = workTicketTypeMapper.getNameById(workTicket.getWorkTicketTypeId());
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
            standardWorkTicket.setSerialNumber(prefix+tail);
            //设置状态为启用
            standardWorkTicket.setStatus("01");
            //添加维护人
            standardWorkTicket.setMaintainer(currentUserService.getId());
            //添加维护日期
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            standardWorkTicket.setMaintainDate(simpleDateFormat.parse(simpleDateFormat.format(new Date())));
            standardWorkTicket.setTicketTypeId(workTicket.getWorkTicketTypeId());
            standardWorkTicket.setWindId(workTicket.getWindId());
            standardWorkTicket.setCrewId(workTicket.getCrewId());
            standardWorkTicket.setWorkTeam(workTicket.getWorkTeam());
            if (workTicket.getPositionId()!=null) {
                standardWorkTicket.setPositionId(workTicket.getPositionId());
            }
            if (workTicket.getEquipmentId()!=null) {
                standardWorkTicket.setEquipmentId(workTicket.getEquipmentId());
            }
            standardWorkTicket.setDoubleName(workTicket.getDoubleNaem());
            standardWorkTicket.setWorkPlace(workTicket.getWorkPlace());
            standardWorkTicket.setWorkContent(workTicket.getWorkContent());
            standardWorkTicketMapper.insert(standardWorkTicket);
            //设置安全措施
            WorkTicketSafeMeasureExample workTicketSafeMeasureExample = new WorkTicketSafeMeasureExample();
            workTicketSafeMeasureExample.createCriteria().andTicketIdEqualTo(ticketId);
            List<WorkTicketSafeMeasure> workTicketSafeMeasureList = workTicketSafeMeasureMapper.selectByExample(workTicketSafeMeasureExample);
            if (CollectionUtils.isNotEmpty(workTicketSafeMeasureList)) {
                workTicketSafeMeasureList.forEach(workTicketSafeMeasure -> {
                    WorkTicketSafeMeasure standardWorkTicketSafeMeasure = new WorkTicketSafeMeasure();
                    standardWorkTicketSafeMeasure.setSafeId(UUIdUtil.getUUID());
                    standardWorkTicketSafeMeasure.setStandardTicketId(standardWorkTicket.getStandardTicketId());
                    standardWorkTicketSafeMeasure.setSafeNumber(workTicketSafeMeasure.getSafeNumber());
                    standardWorkTicketSafeMeasure.setSafeTitle(workTicketSafeMeasure.getSafeTitle());
                    standardWorkTicketSafeMeasure.setSafeContent(workTicketSafeMeasure.getSafeContent());
                    workTicketSafeMeasureMapper.insert(standardWorkTicketSafeMeasure);
                });
            }
            //设置危险因素控制措施
            WorkTicketRiskControlExample workTicketRiskControlExample = new WorkTicketRiskControlExample();
            workTicketRiskControlExample.createCriteria().andTicketIdEqualTo(ticketId);
            List<WorkTicketRiskControl> workTicketRiskControlList = workTicketRiskControlMapper.selectByExample(workTicketRiskControlExample);
            if (CollectionUtils.isNotEmpty(workTicketRiskControlList)) {
                workTicketRiskControlList.forEach(workTicketRiskControl -> {
                    WorkTicketRiskControl standardWorkTicketRiskControl = new WorkTicketRiskControl();
                    standardWorkTicketRiskControl.setMeasureId(UUIdUtil.getUUID());
                    standardWorkTicketRiskControl.setStandardTicketId(standardWorkTicket.getStandardTicketId());
                    standardWorkTicketRiskControl.setMeasureNumber(workTicketRiskControl.getMeasureNumber());
                    standardWorkTicketRiskControl.setDangerPoint(workTicketRiskControl.getDangerPoint());
                    standardWorkTicketRiskControl.setMeasure(workTicketRiskControl.getMeasure());
                    standardWorkTicketRiskControl.setMeasureExecutor(workTicketRiskControl.getMeasureExecutor());
                    workTicketRiskControlMapper.insert(standardWorkTicketRiskControl);
                });
            }
            resultEntity.setData(standardWorkTicket.getStandardTicketId());
        }

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("生成成功");
        return resultEntity;
    }

    @Override
    public List<String> findRoleByUserName(String userName) {
        return workTicketMapper.findRoleByUserName(userName);
    }

    @Override
    public List<String> findFlowStatusQf() {
        return workTicketMapper.findFlowStatusQf();
    }

    private void insertTab(WorkTicketVo workTicketVo) {
        //添加安全措施
        List<WorkTicketSafeMeasure> safeMeasureList = workTicketVo.getSafeMeasureList();
        if (CollectionUtils.isNotEmpty(safeMeasureList)) {
            int i = 1;
            for (WorkTicketSafeMeasure workTicketSafeMeasure:safeMeasureList) {
                workTicketSafeMeasure.setSafeId(UUIdUtil.getUUID());
                workTicketSafeMeasure.setSafeNumber(String.valueOf(i++));
                workTicketSafeMeasure.setTicketId(workTicketVo.getTicketId());
                workTicketSafeMeasure.setTicketTypeId(null);
                if (workTicketSafeMeasure.getSafeContent1()==null) {
                    workTicketSafeMeasure.setSafeContent1("/");
                }
                if (workTicketSafeMeasure.getSafeContent2()==null) {
                    workTicketSafeMeasure.setSafeContent2("/");
                }
                if (workTicketSafeMeasure.getSafeContent3()==null) {
                    workTicketSafeMeasure.setSafeContent3("/");
                }
                if (workTicketSafeMeasure.getSafeContent4()==null) {
                    workTicketSafeMeasure.setSafeContent4("/");
                }
                if (workTicketSafeMeasure.getSafeContent5()==null) {
                    workTicketSafeMeasure.setSafeContent5("/");
                }
                if (workTicketSafeMeasure.getSafeContent6()==null) {
                    workTicketSafeMeasure.setSafeContent6("/");
                }
                if (workTicketSafeMeasure.getSafeContent7()==null) {
                    workTicketSafeMeasure.setSafeContent7("/");
                }
                if (workTicketSafeMeasure.getSafeContent8()==null) {
                    workTicketSafeMeasure.setSafeContent8("/");
                }
                if (workTicketSafeMeasure.getSafeContent9()==null) {
                    workTicketSafeMeasure.setSafeContent9("/");
                }
                if (workTicketSafeMeasure.getSafeContent10()==null) {
                    workTicketSafeMeasure.setSafeContent10("/");
                }

                workTicketSafeMeasureMapper.insert(workTicketSafeMeasure);
            }
        }
        //添加危险因素控制措施
        List<WorkTicketRiskControlVo> riskControlList = workTicketVo.getRiskControlList();
        if (CollectionUtils.isNotEmpty(riskControlList)) {
            int i = 1;
            for (WorkTicketRiskControl workTicketRiskControl:riskControlList) {
                workTicketRiskControl.setMeasureId(UUIdUtil.getUUID());
                workTicketRiskControl.setMeasureNumber(String.valueOf(i++));
                workTicketRiskControl.setTicketId(workTicketVo.getTicketId());
                workTicketRiskControlMapper.insert(workTicketRiskControl);
            }
        }
        //添加每日开工收工时间
        List<WorkTicketWorkTimeVo> workTimeList = workTicketVo.getWorkTimeList();
        if (CollectionUtils.isNotEmpty(workTimeList)) {
            int i = 1;
            for (WorkTicketWorkTime workTicketWorkTime:workTimeList) {
                workTicketWorkTime.setWorkTimeId(UUIdUtil.getUUID());
                workTicketWorkTime.setWorkTimeNumber(String.valueOf(i++));
                workTicketWorkTime.setTicketId(workTicketVo.getTicketId());
                workTicketWorkTimeMapper.insert(workTicketWorkTime);
            }
        }
    }

    private void updateTab(WorkTicketVo workTicketVo) {
        //删除原来的安全措施
        WorkTicketSafeMeasureExample workTicketSafeMeasureExample = new WorkTicketSafeMeasureExample();
        workTicketSafeMeasureExample.createCriteria().andTicketIdEqualTo(workTicketVo.getTicketId());
        workTicketSafeMeasureMapper.deleteByExample(workTicketSafeMeasureExample);
        //删除原来的危险因素控制措施
        WorkTicketRiskControlExample workTicketRiskControlExample = new WorkTicketRiskControlExample();
        workTicketRiskControlExample.createCriteria().andTicketIdEqualTo(workTicketVo.getTicketId());
        workTicketRiskControlMapper.deleteByExample(workTicketRiskControlExample);
        //删除原来的每日开工收工时间
        WorkTicketWorkTimeExample workTicketWorkTimeExample = new WorkTicketWorkTimeExample();
        workTicketWorkTimeExample.createCriteria().andTicketIdEqualTo(workTicketVo.getTicketId());
        workTicketWorkTimeMapper.deleteByExample(workTicketWorkTimeExample);

        //重新添加
        insertTab(workTicketVo);
    }

    private void deleteTab(List<String> ticketIdList) {
        //删除安全措施
        workTicketSafeMeasureMapper.batchDeleteByTicketIds(ticketIdList);
        //删除危险因素控制措施
        workTicketRiskControlMapper.batchDeleteByTicketIds(ticketIdList);
        //删除开工完工时间
        workTicketWorkTimeMapper.batchDeleteByTicketIds(ticketIdList);
    }

    //将年月日转成当天0点的时分秒
    private String converDayToTime1(String startDate) throws ParseException {
        if (StringUtils.isNoneBlank(startDate)) {
            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date startTime = sdf1.parse(startDate);
            return sdf2.format(startTime);
        }
        return null;
    }

    //将年月日转成当天24点的时分秒
    private String converDayToTime2(String endDate) throws ParseException {
        if (StringUtils.isNoneBlank(endDate)) {
            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(sdf1.parse(endDate));
            calendar.add(Calendar.DAY_OF_MONTH,1);
            Date endTime = calendar.getTime();
            return sdf2.format(endTime);
        }
        return null;
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
    private void setWorkMemberNamesAndWorkMemberArray(WorkTicketVo workTicketVo) {
        String workMember = workTicketVo.getWorkMember();
        if (workMember!=null) {
            String[] ids = workMember.split(",");
            if (ArrayUtils.isNotEmpty(ids)) {
                //
                workTicketVo.setWorkMemberNames2(ids);
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
                    workTicketVo.setWorkMemberNames(sb.deleteCharAt(sb.length() - 1).toString());
                }
            }
        }
    }
}
