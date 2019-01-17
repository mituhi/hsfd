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
import com.qz.zframe.tickets.mapper.OperateItemMapper;
import com.qz.zframe.tickets.mapper.OperateTicketMapper;
import com.qz.zframe.tickets.mapper.OperateTicketTypeMapper;
import com.qz.zframe.tickets.mapper.TypicalOperateTicketMapper;
import com.qz.zframe.tickets.service.OperateTicketService;
import com.qz.zframe.tickets.vo.OperateTicketVo;
import com.qz.zframe.tickets.vo.TicketStatisticsRes;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
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
public class OperateTicketServiceImpl implements OperateTicketService {

    @Autowired
    private OperateTicketMapper operateTicketMapper;

    @Autowired
    private OperateItemMapper operateItemMapper;

    @Autowired
    private TypicalOperateTicketMapper typicalOperateTicketMapper;

    @Autowired
    private OperateTicketTypeMapper operateTicketTypeMapper;

    @Autowired
    private UserDao userDao;

    @Autowired
    private CurrentUserService currentUserService;

    @Autowired
    private DeployService deployService;

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
    public ResultEntity addOperateTicket(OperateTicketVo operateTicketVo) throws ParseException {
        ResultEntity resultEntity = new ResultEntity();

        //设置id
        operateTicketVo.setTicketId(UUIdUtil.getUUID());
        //设置操作票状态为未提交
        operateTicketVo.setStatus("03");
        //添加维护人
        operateTicketVo.setMaintainer(currentUserService.getId());
        //添加维护日期
        operateTicketVo.setMaintainDate(new Date());
        //插入数据库
        operateTicketMapper.insertSelective(operateTicketVo);
        //添加操作项tab页
        this.insertTab(operateTicketVo);

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("信息已保存");
        return  resultEntity;
    }

    @Override
    public ResultEntity updateOperateTicket(OperateTicketVo operateTicketVo) {
        ResultEntity resultEntity = new ResultEntity();

        if (!StringUtils.isNoneBlank(operateTicketVo.getTicketId())) {
            resultEntity.setMsg("id不能为空");
            return resultEntity;
        }

        //修改维护日期
        operateTicketVo.setMaintainDate(new Date());

        //修改操作票主数据
        OperateTicket operateTicket = operateTicketMapper.selectByPrimaryKey(operateTicketVo.getTicketId());
        if ("03".equals(operateTicket.getStatus())) {
            BeanUtil.copyProperties(operateTicketVo,operateTicket,true, CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true));
            operateTicketMapper.updateByPrimaryKeySelective(operateTicket);
            //修改操作项
            this.updateTab(operateTicketVo);
        }else {
            resultEntity.setMsg("此操作票已提交");
            return resultEntity;
        }

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("修改成功");
        return resultEntity;
    }

    @Override
    public ResultEntity submitOperateTicket(OperateTicketVo operateTicketVo) throws Exception {
        ResultEntity resultEntity = new ResultEntity();

        if (!StringUtils.isNoneBlank(operateTicketVo.getOperTicketTypeId())) {
            resultEntity.setMsg("操作票类型不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(operateTicketVo.getWindId())) {
            resultEntity.setMsg("风电场不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(operateTicketVo.getCrewId())) {
            resultEntity.setMsg("机组不能为空");
            return resultEntity;
        }
        if (operateTicketVo.getApplyTime()==null) {
            resultEntity.setMsg("申请时间不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(operateTicketVo.getSender())) {
            resultEntity.setMsg("发令人不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(operateTicketVo.getReceiver())) {
            resultEntity.setMsg("受令人不能为空");
            return resultEntity;
        }
        if (operateTicketVo.getSendTime()==null) {
            resultEntity.setMsg("发令时间不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(operateTicketVo.getWorkTeam())) {
            resultEntity.setMsg("工作班组不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(operateTicketVo.getExecuter())) {
            resultEntity.setMsg("操作人不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(operateTicketVo.getSupervisior())) {
            resultEntity.setMsg("监护人不能为空");
            return resultEntity;
        }
        if (operateTicketVo.getOperStartTime()==null) {
            resultEntity.setMsg("操作开始时间不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(operateTicketVo.getOperateContent())) {
            resultEntity.setMsg("操作内容不能为空");
            return resultEntity;
        }

        if (!StringUtils.isNoneBlank(operateTicketVo.getTicketId())) {
            //设置id
            operateTicketVo.setTicketId(UUIdUtil.getUUID());
            //生成流水号
            OperateTicketExample operateTicketExample = new OperateTicketExample();
            operateTicketExample.createCriteria().andSerialNumberIsNotNull();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
            String tail = String.valueOf(1000000+operateTicketMapper.countByExample(operateTicketExample)+1).substring(1);
            operateTicketVo.setSerialNumber(simpleDateFormat.format(new Date())+tail);
            //设置操作票状态处理中
            operateTicketVo.setStatus("01");
            //设置申请人
            operateTicketVo.setApplicant(currentUserService.getId());
            //添加维护人
            operateTicketVo.setMaintainer(currentUserService.getId());
            //添加维护日期
            operateTicketVo.setMaintainDate(new Date());
            //插入数据库
            operateTicketMapper.insert(operateTicketVo);
            //添加操作项
            this.insertTab(operateTicketVo);
        }else {
            OperateTicket operateTicket = operateTicketMapper.selectByPrimaryKey(operateTicketVo.getTicketId());
            if (!"03".equals(operateTicket.getStatus())) {
                resultEntity.setMsg("此操作票已提交");
                return resultEntity;
            }

            if (!StringUtils.isNoneBlank(operateTicketVo.getSerialNumber())) {
                //生成流水号
                OperateTicketExample operateTicketExample2 = new OperateTicketExample();
                operateTicketExample2.createCriteria().andSerialNumberIsNotNull();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
                String tail = String.valueOf(1000000+operateTicketMapper.countByExample(operateTicketExample2)+1).substring(1);
                operateTicketVo.setSerialNumber(simpleDateFormat.format(new Date())+tail);
            }
            if (!StringUtils.isNoneBlank(operateTicketVo.getApplicant())) {
                //设置申请人
                operateTicketVo.setApplicant(currentUserService.getId());
            }
            //设置状态为处理中
            operateTicketVo.setStatus("01");
            //修改维护日期
            operateTicketVo.setMaintainDate(new Date());
            //修改数据库中操作票数据
            BeanUtil.copyProperties(operateTicketVo,operateTicket,true, CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true));
            operateTicketMapper.updateByPrimaryKey(operateTicket);
            //修改操作项
            this.updateTab(operateTicketVo);
        }

        //获取流程配置
        DeployMain deployMain = deployService.queryDeployMainById("1");
        if (deployMain!=null) {
            //生成流程主表,流程详情,流程角色配置
            Process process = new Process();
            process.setProcessId(UUIdUtil.getUUID());
            process.setOrderId(operateTicketVo.getTicketId());
            process.setProcessSort(1);
            process.setProcessType("08");
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
                approveRecord.setOrderId(operateTicketVo.getTicketId());
                approveRecord.setProcessDetailId(processDetail.getProcessDetailId());
                approveRecord.setApproveResult("提交成功");
                approveRecord.setApproveUser(currentUserService.getId());
                approveRecord.setApproveTime(new Date());
                approveRecord.setApproveOpinion(operateTicketVo.getExamAndApprOpinion());
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
                doList.setTaskId(operateTicketVo.getTicketId());
                doList.setTaskCode(operateTicketVo.getSerialNumber());
                doList.setTaskDescribe(operateTicketTypeMapper.getNameById(operateTicketVo.getOperTicketTypeId()));
                doList.setTaskType("08");
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

                //修改操作票中的流程状态
                OperateTicket operateTicket = operateTicketMapper.selectByPrimaryKey(operateTicketVo.getTicketId());
                operateTicket.setFlowStep(process.getProcessStatus());
                operateTicketMapper.updateByPrimaryKeySelective(operateTicket);
            }
        }

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("提交成功");
        return  resultEntity;
    }

    @Override
    public ResultEntity deleteOperateTicket(String[] ticketIds) {
        ResultEntity resultEntity = new ResultEntity();

        if (!ArrayUtils.isNotEmpty(ticketIds)) {
            resultEntity.setMsg("ids不能为空");
            return  resultEntity;
        }
        List<String> ticketIdList1 = new ArrayList<>();
        List<String> ticketIdList2 = new ArrayList<>();
        for (String ticketId:ticketIds) {
            OperateTicket operateTicket = operateTicketMapper.selectByPrimaryKey(ticketId);
            if (operateTicket!=null) {
                if ("03".equals(operateTicket.getStatus())) {
                    if (operateTicket.getSerialNumber()==null) {
                        //删除操作票
                        ticketIdList1.add(ticketId);
                    }else {
                        ticketIdList2.add(ticketId);
                    }
                }else {
                    resultEntity.setMsg("此操作票已提交");
                    return resultEntity;
                }
            }
        }
        if (CollectionUtils.isNotEmpty(ticketIdList1)) {
            //删除操作票
            operateTicketMapper.batchDeleteTrue(ticketIdList1);
            //删除操作项
            this.deleteTab(ticketIdList1);
        }
        if (CollectionUtils.isNotEmpty(ticketIdList2)) {
            //删除操作票
            operateTicketMapper.batchDeleteFalse(ticketIdList2);
        }

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("删除成功");
        return resultEntity;
    }

    @Override
    public ResultEntity getOperateTicketDetail(String ticketId) {
        ResultEntity resultEntity = new ResultEntity();

       if (!StringUtils.isNoneBlank(ticketId)) {
           resultEntity.setMsg("id不能为空");
           return resultEntity;
       }

        //查询操作票主数据
        OperateTicketVo operateTicketVo = operateTicketMapper.getOperateTicketDetail(ticketId);
        if (operateTicketVo!=null) {
            //设置状态名称
            operateTicketVo.setStatusName(this.getStatusName(operateTicketVo.getStatus()));
            //查询操作项
            OperateItemExample operateItemExample = new OperateItemExample();
            operateItemExample.setOrderByClause("item_number");
            operateItemExample.createCriteria().andTicketIdEqualTo(operateTicketVo.getTicketId());
            List<OperateItem> operateItemList = operateItemMapper.selectByExample(operateItemExample);
            if (CollectionUtils.isNotEmpty(operateItemList)) {
                operateItemList.forEach(operateItem -> {
                    operateTicketVo.getOperateItemList().add(operateItem);
                } );
            }
        }

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("查询成功");
        resultEntity.setData(operateTicketVo);
        return resultEntity;
    }

    @Override
    public ResultEntity pringtOperateTicket(String ticketId) {
        ResultEntity resultEntity = new ResultEntity();

        if (!StringUtils.isNoneBlank(ticketId)) {
            resultEntity.setMsg("id不能为空");
            return resultEntity;
        }

        //查询操作票主数据
        List<OperateTicketVo> operateTicketVos = new ArrayList<>();
        OperateTicketVo operateTicketVo = operateTicketMapper.getOperateTicketDetail(ticketId);
        if (operateTicketVo!=null) {
            if ("03".equals(operateTicketVo.getStatus())) {
                resultEntity.setMsg("此操作票未提交");
                return resultEntity;
            }
            //设置状态名称
            operateTicketVo.setStatusName(this.getStatusName(operateTicketVo.getStatus()));
            //查询操作项
            OperateItemExample operateItemExample = new OperateItemExample();
            operateItemExample.setOrderByClause("item_number");
            operateItemExample.createCriteria().andTicketIdEqualTo(operateTicketVo.getTicketId());
            List<OperateItem> operateItemList = operateItemMapper.selectByExample(operateItemExample);
            if (CollectionUtils.isNotEmpty(operateItemList)) {
                List<OperateItem> operateItems = new ArrayList<>();
                for(int i = 1; i <= operateItemList.size(); i++) {
                    operateItems.add(operateItemList.get(i-1));
                    //每个操作票只放20个操作项
                    if (i%20==0) {
                        OperateTicketVo operateTicketVo1 = new OperateTicketVo();
                        BeanUtils.copyProperties(operateTicketVo,operateTicketVo1);
                        operateTicketVo1.setOperateItemList(new ArrayList<>());
                        operateTicketVo1.setOperateItemList(operateItems);
                        operateTicketVos.add(operateTicketVo1);
                        operateItems = new ArrayList<>();
                    }else {
                        if (i==operateItemList.size()) {
                            OperateTicketVo operateTicketVo1 = new OperateTicketVo();
                            BeanUtils.copyProperties(operateTicketVo,operateTicketVo1);
                            operateTicketVo1.setOperateItemList(new ArrayList<>());
                            int a = operateItemList.size() % 20;
                            if (a!=0) {
                                for (int b = 0;b<20-a;b++) {
                                    operateItems.add(new OperateItem());
                                }
                            }
                            operateTicketVo1.setOperateItemList(operateItems);
                            operateTicketVos.add(operateTicketVo1);
                            operateItems = new ArrayList<>();
                        }
                    }
                }
            }
        }

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("查询成功");
        resultEntity.setData(operateTicketVos);
        return resultEntity;
    }

    @Override
    public PageResultEntity getOperateTicketList(Map<String,String> pageAndCondition) throws ParseException {
        PageResultEntity pageResultEntity = new PageResultEntity();
        pageResultEntity.setRows(new ArrayList());

        String start = String.valueOf((Integer.parseInt(pageAndCondition.get("pageNum"))-1)*(Integer.parseInt(pageAndCondition.get("pageSize"))));
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
        if (CollectionUtils.isEmpty(userRoleList)) {
            pageResultEntity.setMsg("该审批人未配置权限");
            return pageResultEntity;
        }
        String userId = currentUserService.getId();
        List<OperateTicketVo> operateTicketVoList = operateTicketMapper.getOperateTicketList(pageAndCondition,userId,userRoleList);
        if (CollectionUtils.isNotEmpty(operateTicketVoList)) {
            operateTicketVoList.forEach(operateTicketVo -> {
                operateTicketVo.setStatusName(this.getStatusName(operateTicketVo.getStatus()));
            });
        }
        int total = operateTicketMapper.getTotal(pageAndCondition,userId,userRoleList);

        pageResultEntity.setCode(ErrorCode.SUCCESS);
        pageResultEntity.setMsg("操作成功");
        pageResultEntity.setRows(operateTicketVoList);
        pageResultEntity.setTotal(total);
        return pageResultEntity;
    }

    @Override
    public PageResultEntity getOperateTicketListForWorkorder(Map<String,String> pageAndCondition) throws ParseException {
        PageResultEntity pageResultEntity = new PageResultEntity();
        pageResultEntity.setRows(new ArrayList());

        String start = String.valueOf((Integer.parseInt(pageAndCondition.get("pageNum"))-1)*(Integer.parseInt(pageAndCondition.get("pageSize"))));
        pageAndCondition.put("start",start);
        pageAndCondition.put("startTime",this.converDayToTime1(pageAndCondition.get("startTime")));
        pageAndCondition.put("endTime",this.converDayToTime2(pageAndCondition.get("endTime")));
        List<OperateTicketVo> operateTicketVoList = operateTicketMapper.getOperateTicketListForWorkorder(pageAndCondition);
        if (CollectionUtils.isNotEmpty(operateTicketVoList)) {
            operateTicketVoList.forEach(operateTicketVo -> {
                //设置状态名称
                operateTicketVo.setStatusName(this.getStatusName(operateTicketVo.getStatus()));
            });
        }
        int total = operateTicketMapper.getTotalForWorkorder(pageAndCondition);

        pageResultEntity.setCode(ErrorCode.SUCCESS);
        pageResultEntity.setMsg("操作成功");
        pageResultEntity.setRows(operateTicketVoList);
        pageResultEntity.setTotal(total);
        return pageResultEntity;
    }

    @Override
    public ResultEntity removeOperateTicketForWorkorder(String ticketId) {
        ResultEntity resultEntity = new ResultEntity();

        if (!StringUtils.isNoneBlank(ticketId)) {
            resultEntity.setMsg("id不能为空");
            return resultEntity;
        }

        //修改操作票主数据
        OperateTicket operateTicket = operateTicketMapper.selectByPrimaryKey(ticketId);
        operateTicket.setWorkorderId(null);
        operateTicket.setOrderId(null);
        operateTicketMapper.updateByPrimaryKey(operateTicket);

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("删除成功");
        return resultEntity;
    }


    @Override
    public ResultEntity getOperateTicketStatistics(String startDate, String endDate,String startWindCode,String endWindCode) throws ParseException {
        ResultEntity resultEntity = new ResultEntity();
        List<TicketStatisticsRes> operateTicketStatisticsList=null;

        String startTime = this.converDayToTime1(startDate);
        String endTime = this.converDayToTime2(endDate);

        operateTicketStatisticsList = operateTicketMapper.getOperateTicketStatisticsList(startTime, endTime,startWindCode,endWindCode);
        //合计
        int totalApplyCount = 0;
        int totalInProcessCount = 0;
        int totalCompleteCount = 0;
        int totalInvalidCount = 0;
        for (TicketStatisticsRes ticketStatisticsRes: operateTicketStatisticsList) {
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
        operateTicketStatisticsList.add(ticketStatisticsRes);

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("操作成功");
        resultEntity.setData(operateTicketStatisticsList);
        return resultEntity;
    }

    @Override
    public void exportToExcel(String startDate, String endDate, String startWindCode,String endWindCode, HttpServletResponse response) throws ParseException {
        ResultEntity resultEntity = this.getOperateTicketStatistics(startDate, endDate, startWindCode,endWindCode);
        List<TicketStatisticsRes> operTicketStatisticsResList = (List<TicketStatisticsRes>)resultEntity.getData();

        LinkedHashMap<String, String> testMap = new LinkedHashMap<String, String>();
        testMap.put("windName", "风电场");
        testMap.put("applyCount", "申请数");
        testMap.put("inProcessCount", "处理中");
        testMap.put("completeCount", "完成");
        testMap.put("invalidCount", "作废");
        testMap.put("completeRate", "完成率");

        try {
            ExcelUtil.listToExcel2(operTicketStatisticsResList, testMap, "操作票统计", 65535, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public ResultEntity agreeOperateticket(OperateTicketVo operateTicketVo) {
        ResultEntity resultEntity = new ResultEntity();

        if (!StringUtils.isNoneBlank(operateTicketVo.getSerialNumber())) {
            resultEntity.setMsg("此操作票未提交");
            return resultEntity;
        }
        //获取流程主表
        ResultEntity processResultEntity = processService.getProcessByOrderIdAndType(operateTicketVo.getTicketId(), "08");
        Process process = (Process)processResultEntity.getData();

        //获取流程步数
        ResultEntity totalSortResultEntity = processService.getTotalSort(process.getProcessId());
        int totalSort = (Integer) totalSortResultEntity.getData();

        if (process!=null && totalSort!=0) {
            //判断流程是否已经结束
            if (process.getProcessSort()==totalSort) {
                resultEntity.setMsg("此操作票审核已结束");
                return resultEntity;
            }
            if ("03".equals(process.getProcessStatus())) {
                resultEntity.setMsg("此操作票审核已结束");
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
                approveRecord.setOrderId(operateTicketVo.getTicketId());
                approveRecord.setProcessDetailId(processDetail.getProcessDetailId());
                approveRecord.setApproveResult("通过");
                approveRecord.setApproveUser(currentUserService.getId());
                approveRecord.setApproveTime(new Date());
                approveRecord.setApproveOpinion(operateTicketVo.getExamAndApprOpinion());
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
                        ResultEntity doListResultEntity = doListService.findDoListByTaskId(operateTicketVo.getTicketId());
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
                            doListService.updateDoList(operateTicketVo.getTicketId(), doRoleRelas);
                        }
                    }
                }
            }

            //如果当前是最后一步修改流程主表,流程结束
            if (totalSort-process.getProcessSort()==1) {
                //获取代办信息
                ResultEntity doListResultEntity = doListService.findDoListByTaskId(operateTicketVo.getTicketId());
                DoList doList = (DoList) doListResultEntity.getData();
                if (doList != null) {
                    //修改代办角色关联列表
                    List<DoRoleRela> doRoleRelas = new ArrayList<>();
                    doListService.updateDoList(operateTicketVo.getTicketId(), doRoleRelas);
                }

                //修改流程主表中的状态为完成
                process.setProcessStatus("02");
                OperateTicket operateTicket = operateTicketMapper.selectByPrimaryKey(operateTicketVo.getTicketId());
                //设置操作票流程状态跟流程主表同步
                operateTicket.setFlowStep(process.getProcessStatus());
                //设置操作票状态为完成
                operateTicket.setStatus("02");
                operateTicketMapper.updateByPrimaryKeySelective(operateTicket);
            }
            process.setProcessSort(process.getProcessSort()+1);
            processService.updateProcess(process);
        }

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("审批通过");
        return resultEntity;
    }

    @Override
    public ResultEntity backOperateTicket(OperateTicketVo operateTicketVo) {
        ResultEntity resultEntity = new ResultEntity();

        if (!StringUtils.isNoneBlank(operateTicketVo.getSerialNumber())) {
            resultEntity.setMsg("此操作票未提交");
            return resultEntity;
        }

        //获取流程主表
        ResultEntity processResultEntity = processService.getProcessByOrderIdAndType(operateTicketVo.getTicketId(), "08");
        Process process = (Process)processResultEntity.getData();

        //获取流程步数
        ResultEntity totalSortResultEntity = processService.getTotalSort(process.getProcessId());
        int totalSort = (Integer) totalSortResultEntity.getData();

        if (process!=null && totalSort!=0) {
            //处理中的流程才能退回
            if ("03".equals(process.getProcessStatus())) {
                resultEntity.setMsg("此操作票审核已结束");
                return resultEntity;
            }
            //若流程步骤为0,则无法退回
            if (process.getProcessSort()==0) {
                resultEntity.setMsg("当前步骤无法退回");
                return resultEntity;
            }
            //判断流程是否已经结束
            if (process.getProcessSort()==totalSort) {
                resultEntity.setMsg("此操作票审核已结束");
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
                approveRecord.setOrderId(operateTicketVo.getTicketId());
                approveRecord.setProcessDetailId(processDetail.getProcessDetailId());
                approveRecord.setApproveResult("拒绝");
                approveRecord.setApproveUser(currentUserService.getId());
                approveRecord.setApproveTime(new Date());
                approveRecord.setApproveOpinion(operateTicketVo.getExamAndApprOpinion());
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
                    //设置操作票状态为未提交
                    operateTicket.setStatus("03");

                }*/
                //修改流程主表中的状态未审核未通过
                process.setProcessStatus("03");
                processService.updateProcess(process);
                OperateTicket operateTicket = operateTicketMapper.selectByPrimaryKey(operateTicketVo.getTicketId());
                //设置操作票流程状态跟流程主表同步
                operateTicket.setFlowStep(process.getProcessStatus());
                //设置操作票状态为审核未通过
                operateTicket.setStatus("04");
                operateTicketMapper.updateByPrimaryKeySelective(operateTicket);

                //修改上一步流程详情为待办
                /*processDetail.setStatus("01");
                processService.updateProcessDetail(processDetail);*/

                //List<ProcessDetailRoleRela> processDetailRoleRelas = processDetail.getProcessDetailRoleRelas();
                //if (CollectionUtils.isNotEmpty(processDetailRoleRelas)) {
                    //获取代办信息
                    ResultEntity doListResultEntity = doListService.findDoListByTaskId(operateTicketVo.getTicketId());
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
                        doListService.updateDoList(operateTicketVo.getTicketId(),doRoleRelas);
                    }
                //}
            }
        }

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("退回成功");
        return resultEntity;
    }

    @Override
    public ResultEntity createTypicalOperateTicket(OperateTicketVo operateTicketVo) throws ParseException {
        ResultEntity resultEntity = new ResultEntity();

        String ticketId = operateTicketVo.getTicketId();
        if (!StringUtils.isNoneBlank(ticketId)) {
            resultEntity.setMsg("操作票id不能为空");
            return resultEntity;
        }
        OperateTicket operateTicket = operateTicketMapper.selectByPrimaryKey(ticketId);
        if (operateTicket!=null) {
            //创建典型操作票对象
            TypicalOperateTicket typicalOperateTicket = new TypicalOperateTicket();
            //设置id
            typicalOperateTicket.setTypicalTicketId(UUIdUtil.getUUID());
            //设置流水号
            String prefix = "";
            String ticketTypeName = operateTicketTypeMapper.getNameById(operateTicket.getOperTicketTypeId());
            if (StringUtils.isNoneBlank(ticketTypeName)) {
                if (ticketTypeName.contains("倒闸")) {
                    prefix = "DXDZ";
                }else {
                    prefix = "DXQT";
                }
            }
            String tail = String.valueOf(1000+typicalOperateTicketMapper.countByExample(new TypicalOperateTicketExample())+1);
            tail = tail.substring(1);
            typicalOperateTicket.setSerialNumber(prefix+tail);
            //设置状态为正常
            typicalOperateTicket.setStatus("01");
            //添加维护人
            typicalOperateTicket.setMaintainer(currentUserService.getId());
            //添加维护日期
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            typicalOperateTicket.setMaintainDate(simpleDateFormat.parse(simpleDateFormat.format(new Date())));
            typicalOperateTicket.setOperTicketTypeId(operateTicket.getOperTicketTypeId());
            typicalOperateTicket.setWindId(operateTicket.getWindId());
            typicalOperateTicket.setWorkTeam(operateTicket.getWorkTeam());
            if (operateTicket.getPositionId()!=null) {
                typicalOperateTicket.setPositionId(operateTicket.getPositionId());
            }
            if (operateTicket.getEquipmentId()!=null) {
                typicalOperateTicket.setEquipmentId(operateTicket.getEquipmentId());
            }
            typicalOperateTicket.setOperateContent(operateTicket.getOperateContent());
            typicalOperateTicketMapper.insert(typicalOperateTicket);
            //设置操作项
            OperateItemExample operateItemExample = new OperateItemExample();
            operateItemExample.createCriteria().andTicketIdEqualTo(ticketId);
            List<OperateItem> operateItemList = operateItemMapper.selectByExample(operateItemExample);
            if (CollectionUtils.isNotEmpty(operateItemList)) {
                operateItemList.forEach(operateItem -> {
                    OperateItem typicalOperateItem = new OperateItem();
                    typicalOperateItem.setItemId(UUIdUtil.getUUID());
                    typicalOperateItem.setTypicalTicketId(typicalOperateTicket.getTypicalTicketId());
                    typicalOperateItem.setItemNumber(operateItem.getItemNumber());
                    typicalOperateItem.setItemContent(operateItem.getItemContent());
                    operateItemMapper.insert(typicalOperateItem);
                });
            }
            resultEntity.setData(typicalOperateTicket.getTypicalTicketId());
        }

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("生成成功");
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

    private void insertTab(OperateTicketVo operateTicketVo) {
        //添加操作项
        List<OperateItem> operateItemList = operateTicketVo.getOperateItemList();
        if (CollectionUtils.isNotEmpty(operateItemList)) {
            int i = 1;
            for (OperateItem operateItem:operateItemList) {
                operateItem.setItemId(UUIdUtil.getUUID());
                operateItem.setItemNumber(i++);
                operateItem.setTicketId(operateTicketVo.getTicketId());
                operateItemMapper.insert(operateItem);
            }
        }
    }

    private void updateTab(OperateTicketVo operateTicketVo) {
        //删除原来的操作项
        OperateItemExample operateItemExample = new OperateItemExample();
        operateItemExample.createCriteria().andTicketIdEqualTo(operateTicketVo.getTicketId());
        operateItemMapper.deleteByExample(operateItemExample);

        //重新插入
        this.insertTab(operateTicketVo);
    }

    private void deleteTab(List<String> ticketIds) {
        operateItemMapper.batchDeleteByTicketIds(ticketIds);
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
}
