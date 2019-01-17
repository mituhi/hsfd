package com.qz.zframe.maintain.service.Impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.qz.zframe.authentication.CurrentUserService;
import com.qz.zframe.common.dao.CommonDao;
import com.qz.zframe.common.dao.UserDao;
import com.qz.zframe.common.entity.*;
import com.qz.zframe.common.entity.Process;
import com.qz.zframe.common.service.*;
import com.qz.zframe.common.util.*;
import com.qz.zframe.file.FileException;
import com.qz.zframe.maintain.entity.*;
import com.qz.zframe.maintain.mapper.*;
import com.qz.zframe.maintain.service.DefectWorkorderService;
import com.qz.zframe.maintain.vo.*;
import com.qz.zframe.material.dao.InventoryMapper;
import com.qz.zframe.material.entity.Inventory;
import com.qz.zframe.material.entity.InventoryExample;
import com.qz.zframe.material.enums.EnableStatusEnum;
import com.qz.zframe.material.enums.IsDeleteEnum;
import com.qz.zframe.material.enums.StockMaterialStatusEnum;
import com.qz.zframe.tickets.entity.OperateTicket;
import com.qz.zframe.tickets.entity.WorkTicket;
import com.qz.zframe.tickets.mapper.OperateTicketMapper;
import com.qz.zframe.tickets.mapper.WorkTicketMapper;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.misc.BASE64Encoder;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

@Service
@Transactional(rollbackFor = Exception.class)
public class DefectWorkorderServiceImpl implements DefectWorkorderService {

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

    @Autowired
    private WorkTicketMapper workTicketMapper;

    @Autowired
    private OperateTicketMapper operateTicketMapper;

    @Autowired
    private BreakdownInfoMapper breakdownInfoMapper;

    @Autowired
    private InventoryMapper inventoryMapper;

    @Autowired
    private WorkorderTypeMapper workorderTypeMapper;

    @Autowired
    private MaintainFileMapper maintainFileMapper;

    @Autowired
    private CommonDao commonDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private WorkorderInfoMapper workorderInfoMapper;

    @Autowired
    private CurrentUserService currentUserService;

    @Autowired
    private DeployService deployService;

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
    public ResultEntity addDefectWorkorder(DefectWorkorderVo defectWorkorderVo) {
        ResultEntity resultEntity = new ResultEntity();

        if (StringUtils.isNoneBlank(defectWorkorderVo.getPlanWorkHour())) {
            if (!Pattern.matches("^\\d+(\\.\\d+)?$",defectWorkorderVo.getPlanWorkHour())) {
                resultEntity.setMsg("计划工时格式不正确");
                return resultEntity;
            }
        }
        if (StringUtils.isNoneBlank(defectWorkorderVo.getPlanMaterialFee())) {
            if (!Pattern.matches("^\\d+(\\.\\d+})?$",defectWorkorderVo.getPlanMaterialFee())) {
                resultEntity.setMsg("计划材料费格式不正确");
                return resultEntity;
            }
        }
        if (StringUtils.isNoneBlank(defectWorkorderVo.getPlanServiceFee())) {
            if (!Pattern.matches("^\\d+(\\.\\d+)?$",defectWorkorderVo.getPlanServiceFee())) {
                resultEntity.setMsg("计划服务费格式不正确");
                return resultEntity;
            }
        }

        //设置id
        defectWorkorderVo.setWorkorderId(UUIdUtil.getUUID());
        //设置缺陷工单状态为未提交
        defectWorkorderVo.setStatus("03");
        //添加维护人
        defectWorkorderVo.setMaintainer(currentUserService.getId());
        //添加维护日期
        defectWorkorderVo.setMaintainDate(new Date());
        //存入本单位工作人员id字符串
        this.setUnitMember(defectWorkorderVo);

        //添加图片
        this.addMaintainPic(defectWorkorderVo.getPictureList(),defectWorkorderVo.getWorkorderId(),"01");
        //添加基本信息附件
        this.addMaintainFile(defectWorkorderVo.getAttachmentList(),defectWorkorderVo.getWorkorderId(),"02");

        //添加物资服务等tab页
        resultEntity = this.insertTab(defectWorkorderVo, resultEntity);
        if (resultEntity.getMsg()!=null) {
            return resultEntity;
        }
        //插入数据库
        defectWorkorderMapper.insertSelective(defectWorkorderVo);

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("信息已保存");
        return resultEntity;
    }

    @Override
    public ResultEntity updateDefectWorkorder(DefectWorkorderVo defectWorkorderVo) {
        ResultEntity resultEntity = new ResultEntity();

        if (!StringUtils.isNoneBlank(defectWorkorderVo.getWorkorderId())) {
            resultEntity.setMsg("id不能为空");
            return resultEntity;
        }

        if (StringUtils.isNoneBlank(defectWorkorderVo.getPlanWorkHour())) {
            if (!Pattern.matches("^\\d+(\\.\\d+)?$",defectWorkorderVo.getPlanWorkHour())) {
                resultEntity.setMsg("计划工时格式不正确");
                return resultEntity;
            }
        }
        if (StringUtils.isNoneBlank(defectWorkorderVo.getPlanMaterialFee())) {
            if (!Pattern.matches("^\\d+(\\.\\d+})?$",defectWorkorderVo.getPlanMaterialFee())) {
                resultEntity.setMsg("计划材料费格式不正确");
                return resultEntity;
            }
        }
        if (StringUtils.isNoneBlank(defectWorkorderVo.getPlanServiceFee())) {
            if (!Pattern.matches("^\\d+(\\.\\d+)?$",defectWorkorderVo.getPlanServiceFee())) {
                resultEntity.setMsg("计划服务费格式不正确");
                return resultEntity;
            }
        }

        //存入本单位工作人员id字符串
        this.setUnitMember(defectWorkorderVo);
        //修改维护日期
        defectWorkorderVo.setMaintainDate(new Date());

        //修改关联表图片信息
        this.updateMaintainFileAndRemovePic(defectWorkorderVo.getPictureList(),defectWorkorderVo.getWorkorderId(),"01");
        //修改关联表附件信息
        this.updateMaintainFileAndRemoveFile(defectWorkorderVo.getAttachmentList(),defectWorkorderVo.getWorkorderId(),"02");

        //修改物资服务等tab页
        resultEntity = this.updateTab(defectWorkorderVo, resultEntity);
        if (resultEntity.getMsg()!=null) {
            return resultEntity;
        }
        //修改缺陷工单
        DefectWorkorder defectWorkorder = defectWorkorderMapper.selectByPrimaryKey(defectWorkorderVo.getWorkorderId());
        if (defectWorkorder!=null) {
            if ("03".equals(defectWorkorder.getStatus())) {
                BeanUtil.copyProperties(defectWorkorderVo,defectWorkorder,true, CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true));
                defectWorkorderMapper.updateByPrimaryKeySelective(defectWorkorder);
            }else {
                resultEntity.setMsg("此缺陷工单审已提交");
                return resultEntity;
            }
        }else {
            resultEntity.setMsg("此缺陷工单不存在");
            return resultEntity;
        }

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("修改成功");
        return resultEntity;
    }

    @Override
    public ResultEntity submitDefectWorkorder(DefectWorkorderVo defectWorkorderVo) throws Exception {
        ResultEntity resultEntity = new ResultEntity();

        if (!StringUtils.isNoneBlank(defectWorkorderVo.getWorkorderDesc())) {
            resultEntity.setMsg("缺陷工单描述不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(defectWorkorderVo.getWorkorderTypeId())) {
            resultEntity.setMsg("工单类型不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(defectWorkorderVo.getWindId())) {
            resultEntity.setMsg("风电场不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(defectWorkorderVo.getDealMode())) {
            resultEntity.setMsg("处理方式不能为空");
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
            resultEntity.setMsg("位置不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(defectWorkorderVo.getBreakdownDesc())) {
            resultEntity.setMsg("故障描述不能为空");
            return resultEntity;
        }
        if (defectWorkorderVo.getActiveTime()==null) {
            resultEntity.setMsg("故障激活时间不能为空");
            return resultEntity;
        }else {
            if (defectWorkorderVo.getRecoverTime()!=null) {
                if (!defectWorkorderVo.getActiveTime().before(defectWorkorderVo.getRecoverTime())) {
                    resultEntity.setMsg("故障恢复时间不能早于故障激活时间");
                    return resultEntity;
                }
            }
        }
        if (defectWorkorderVo.getPlanStartTime()!=null) {
            if (defectWorkorderVo.getPlanEndTime()!=null) {
                if (defectWorkorderVo.getPlanStartTime().after(defectWorkorderVo.getPlanEndTime())) {
                    resultEntity.setMsg("计划完成时间不能早于计划开始时间");
                    return resultEntity;
                }
            }
            if (defectWorkorderVo.getActualCompleteTime()!=null) {
                if (defectWorkorderVo.getPlanStartTime().after(defectWorkorderVo.getActualCompleteTime())) {
                    resultEntity.setMsg("实际完成时间不能早于计划开始时间");
                    return resultEntity;
                }
            }
        }
        if (StringUtils.isNoneBlank(defectWorkorderVo.getPlanWorkHour())) {
            if (!Pattern.matches("^\\d+(\\.\\d+)?$",defectWorkorderVo.getPlanWorkHour())) {
                resultEntity.setMsg("计划工时格式不正确");
                return resultEntity;
            }
        }
        if (StringUtils.isNoneBlank(defectWorkorderVo.getPlanMaterialFee())) {
            if (!Pattern.matches("^\\d+(\\.\\d+})?$",defectWorkorderVo.getPlanMaterialFee())) {
                resultEntity.setMsg("计划材料费格式不正确");
                return resultEntity;
            }
        }
        if (StringUtils.isNoneBlank(defectWorkorderVo.getPlanServiceFee())) {
            if (!Pattern.matches("^\\d+(\\.\\d+)?$",defectWorkorderVo.getPlanServiceFee())) {
                resultEntity.setMsg("计划服务费格式不正确");
                return resultEntity;
            }
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
        if (!StringUtils.isNoneBlank(defectWorkorderVo.getDefectAnalysis())) {
            resultEntity.setMsg("缺陷分析不能为空");
            return resultEntity;
        }

        if (!StringUtils.isNoneBlank(defectWorkorderVo.getWorkorderId())) {

            //填写故障记录中的缺陷工单信息
            BreakdownInfo breakdownInfo = breakdownInfoMapper.selectByPrimaryKey(defectWorkorderVo.getBreakdownId());
            if (breakdownInfo!=null) {
                if (breakdownInfo.getWorkorderNumber()==null) {
                    breakdownInfo.setWorkorderNumber(defectWorkorderVo.getSerialNumber());
                }
                breakdownInfo.setWorkorderDesc(defectWorkorderVo.getWorkorderDesc());
                breakdownInfo.setWorkorderStatus(defectWorkorderVo.getStatus());
                breakdownInfo.setWorkorderType(defectWorkorderVo.getWorkorderTypeId());
            }
            //设置id
            defectWorkorderVo.setWorkorderId(UUIdUtil.getUUID());
            //生成流水号
            DefectWorkorderExample defectWorkorderExample1 = new DefectWorkorderExample();
            defectWorkorderExample1.createCriteria().andSerialNumberIsNotNull();
            String prefix = "QXGD";
            String tail = String.valueOf(1000000+defectWorkorderMapper.countByExample(defectWorkorderExample1)+1).substring(1);
            defectWorkorderVo.setSerialNumber(prefix+tail);
            //设置缺陷工单状态为处理中
            defectWorkorderVo.setStatus("01");
            //设置填报时间
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            defectWorkorderVo.setFillTime(simpleDateFormat.parse(simpleDateFormat.format(new Date())));
            //添加维护人
            defectWorkorderVo.setMaintainer(currentUserService.getId());
            //添加维护日期
            defectWorkorderVo.setMaintainDate(new Date());
            //存入本单位工作人员id字符串
            this.setUnitMember(defectWorkorderVo);

            //添加图片
            this.addMaintainPic(defectWorkorderVo.getPictureList(),defectWorkorderVo.getWorkorderId(),"01");
            //添加基本信息附件
            this.addMaintainFile(defectWorkorderVo.getAttachmentList(),defectWorkorderVo.getWorkorderId(),"02");

            //添加物资服务等tab页
            resultEntity = this.insertTab(defectWorkorderVo, resultEntity);
            if (resultEntity.getMsg()!=null) {
                return resultEntity;
            }
            //插入数据库
            defectWorkorderMapper.insertSelective(defectWorkorderVo);
        }else {
            DefectWorkorder defectWorkorder = defectWorkorderMapper.selectByPrimaryKey(defectWorkorderVo.getWorkorderId());
            if (!"03".equals(defectWorkorder.getStatus())) {
                resultEntity.setMsg("此缺陷工单审已提交");
                return resultEntity;
            }
            //填写故障记录中的缺陷工单信息
            BreakdownInfo breakdownInfo = breakdownInfoMapper.selectByPrimaryKey(defectWorkorderVo.getBreakdownId());
            if (breakdownInfo!=null) {
                if (breakdownInfo.getWorkorderNumber()==null) {
                    breakdownInfo.setWorkorderNumber(defectWorkorderVo.getSerialNumber());
                }
                breakdownInfo.setWorkorderDesc(defectWorkorderVo.getWorkorderDesc());
                breakdownInfo.setWorkorderStatus(defectWorkorderVo.getStatus());
                breakdownInfo.setWorkorderType(defectWorkorderVo.getWorkorderTypeId());
            }
            //生成流水号
            if (StringUtils.isBlank(defectWorkorderVo.getSerialNumber())) {
                DefectWorkorderExample defectWorkorderExample1 = new DefectWorkorderExample();
                defectWorkorderExample1.createCriteria().andSerialNumberIsNotNull();
                String prefix = "QXGD";
                String tail = String.valueOf(1000000+defectWorkorderMapper.countByExample(defectWorkorderExample1)+1).substring(1);
                defectWorkorderVo.setSerialNumber(prefix+tail);
            }
            //设置填报时间
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            defectWorkorderVo.setFillTime(simpleDateFormat.parse(simpleDateFormat.format(new Date())));
            //设置状态为处理中
            defectWorkorderVo.setStatus("01");
            //存入本单位工作人员id字符串
            this.setUnitMember(defectWorkorderVo);
            //修改维护日期
            defectWorkorderVo.setMaintainDate(new Date());

            //修改关联表图片信息
            this.updateMaintainFileAndRemovePic(defectWorkorderVo.getPictureList(),defectWorkorderVo.getWorkorderId(),"01");
            //修改关联表附件信息
            this.updateMaintainFileAndRemoveFile(defectWorkorderVo.getAttachmentList(),defectWorkorderVo.getWorkorderId(),"02");

            //修改物资服务等tab页信息
            resultEntity = this.updateTab(defectWorkorderVo,resultEntity);
            if (resultEntity.getMsg()!=null) {
                return resultEntity;
            }
            //修改数据库
            BeanUtil.copyProperties(defectWorkorderVo,defectWorkorder,true, CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true));
            defectWorkorderMapper.updateByPrimaryKeySelective(defectWorkorder);
        }

        //获取流程主表
        ResultEntity processResultEntity = processService.getProcessByOrderIdAndType(defectWorkorderVo.getWorkorderId(), "09");
        Process process = (Process)processResultEntity.getData();
        if (process!=null) {
            resultEntity = this.agreeDefectWorkorder(defectWorkorderVo);
            if (resultEntity.getMsg()!=null) {
                return resultEntity;
            }
        }else {
            //获取流程配置
            DeployMain deployMain = null;
            if ("101301".equals(defectWorkorderVo.getDealMode())) {
                deployMain = deployService.queryDeployMainById("6");
            }
            if ("101302".equals(defectWorkorderVo.getDealMode())) {
                deployMain = deployService.queryDeployMainById("7");
            }
            if ("101303".equals(defectWorkorderVo.getDealMode())) {
                deployMain = deployService.queryDeployMainById("8");
            }
            if (deployMain!=null) {
                //生成流程主表,流程详情,流程角色配置
                process = new Process();
                process.setProcessId(UUIdUtil.getUUID());
                process.setOrderId(defectWorkorderVo.getWorkorderId());
                process.setProcessSort(1);
                process.setProcessType("09");
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
                    approveRecord.setOrderId(defectWorkorderVo.getWorkorderId());
                    approveRecord.setProcessDetailId(processDetail.getProcessDetailId());
                    approveRecord.setApproveResult("提交成功");
                    approveRecord.setApproveUser(currentUserService.getId());
                    approveRecord.setApproveTime(new Date());
                    approveRecord.setApproveOpinion(defectWorkorderVo.getExamAndApprOpinion());
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
                    doList.setTaskId(defectWorkorderVo.getWorkorderId());
                    doList.setTaskCode(defectWorkorderVo.getSerialNumber());
                    doList.setTaskDescribe(workorderTypeMapper.getNameById(defectWorkorderVo.getWorkorderTypeId()));
                    doList.setTaskType("09");
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

                    //修改缺陷工单中的流程状态
                    DefectWorkorder defectWorkorder = defectWorkorderMapper.selectByPrimaryKey(defectWorkorderVo.getWorkorderId());
                    defectWorkorder.setFlowStatus(process.getProcessStatus());
                    defectWorkorderMapper.updateByPrimaryKeySelective(defectWorkorder);
                }
            }
        }

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("提交成功");
        return resultEntity;
    }

    @Override
    public ResultEntity deleteDefectWorkorder(String[] workorderIds) {
        ResultEntity resultEntity = new ResultEntity();

        if (!ArrayUtils.isNotEmpty(workorderIds)) {
            resultEntity.setMsg("ids不能为空");
            return resultEntity;
        }
        List<String> workorderIdList1 = new ArrayList<>();
        List<String> workorderIdList2 = new ArrayList<>();
        List<String> workorderIdList3 = new ArrayList<>();
        for (String workorderId:workorderIds) {
            DefectWorkorder defectWorkorder = defectWorkorderMapper.selectByPrimaryKey(workorderId);
            if (defectWorkorder!=null) {
                if ("03".equals(defectWorkorder.getStatus())) {
                    if (defectWorkorder.getSerialNumber()==null) {
                        workorderIdList1.add(workorderId);
                    }else {
                        workorderIdList2.add(workorderId);
                    }
                    if (defectWorkorder.getBreakdownId()!=null) {
                        workorderIdList3.add(workorderId);
                    }
                }else {
                    resultEntity.setMsg("此缺陷工单已提交");
                    return resultEntity;
                }
            }
        }
        if (CollectionUtils.isNotEmpty(workorderIdList1)) {
            //删除操作票
            defectWorkorderMapper.batchDeleteTrue(workorderIdList1);
            //删除操作项
            this.deleteTab(workorderIdList1);
        }
        if (CollectionUtils.isNotEmpty(workorderIdList2)) {
            //删除操作票
            defectWorkorderMapper.batchDeleteFalse(workorderIdList2);
        }
        if (CollectionUtils.isNotEmpty(workorderIdList3)) {
            //将故障状态改回处理中
            breakdownInfoMapper.batchUpdate(workorderIdList3);
        }

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("删除成功");
        return resultEntity;
    }

    @Override
    public ResultEntity getDefectWorkorderDetail(String workorderId) throws Exception {
        ResultEntity resultEntity = new ResultEntity();

        if (!StringUtils.isNoneBlank(workorderId)) {
            resultEntity.setMsg("id不能为空");
            return resultEntity;
        }

        //获取缺陷工单主数据
        DefectWorkorderVo defectWorkorderVo = defectWorkorderMapper.getDefectWorkorderDetail(workorderId);
        if (defectWorkorderVo!=null) {
            defectWorkorderVo.setStatusName(this.getStatusName(defectWorkorderVo.getStatus()));
            //获取本单位工作人员姓名  并给人员id数组赋值
            this.setUnitMemberNamesAndUnitMemberArray(defectWorkorderVo);
            //查询图片
            defectWorkorderVo.setPictureList(this.getPic(defectWorkorderVo,"01"));
            //查询附件
            defectWorkorderVo.setAttachmentList(this.getFile(defectWorkorderVo.getWorkorderId(),"02"));
            //查询工单总结附件
            if (defectWorkorderVo.getWorkorderSummary()!=null) {
                defectWorkorderVo.getWorkorderSummary().setSummaryAttachmentList(this.getFile(defectWorkorderVo.getWorkorderId(),"03"));
            }

            //获取工序list
            WorkorderProcessExample workorderProcessExample = new WorkorderProcessExample();
            workorderProcessExample.setOrderByClause("process_number");
            workorderProcessExample.createCriteria().andWorkorderIdEqualTo(defectWorkorderVo.getWorkorderId());
            List<WorkorderProcess> processeList = workorderProcessMapper.selectByExample(workorderProcessExample);
            if (CollectionUtils.isNotEmpty(processeList)) {
                processeList.forEach(workorderProcess -> {
                    defectWorkorderVo.getWorkorderProcessList().add(workorderProcess);
                });
            }
            //获取物资list
            List<WorkorderMaterialVo> materialList = workorderMaterialMapper.
                    getWorkorderMaterialVoByworkorderId(defectWorkorderVo.getWorkorderId(),null);
            if (CollectionUtils.isNotEmpty(materialList)) {
                materialList.forEach(workorderMaterialVo -> {
                    workorderMaterialVo.setCost(this.getCost(workorderMaterialVo));
                    defectWorkorderVo.getWorkorderMaterialList().add(workorderMaterialVo);
                });
            }
            //获取服务list
            WorkorderServiceExample workorderServiceExample = new WorkorderServiceExample();
            workorderServiceExample.setOrderByClause("service_number");
            workorderServiceExample.createCriteria().andWorkorderIdEqualTo(defectWorkorderVo.getWorkorderId());
            List<WorkorderService> serviceList = workorderServiceMapper.selectByExample(workorderServiceExample);
            if (CollectionUtils.isNotEmpty(serviceList)) {
                serviceList.forEach(workorderService -> {
                    defectWorkorderVo.getWorkorderServiceList().add(workorderService);
                });
            }
            //获取工器具list
            WorkorderToolExample workorderToolExample = new WorkorderToolExample();
            workorderToolExample.setOrderByClause("tool_number");
            workorderToolExample.createCriteria().andWorkorderIdEqualTo(defectWorkorderVo.getWorkorderId());
            List<WorkorderTool> toolList = workorderToolMapper.selectByExample(workorderToolExample);
            if (CollectionUtils.isNotEmpty(toolList)) {
                toolList.forEach(workorderTool -> {
                    defectWorkorderVo.getWorkorderToolList().add(workorderTool);
                });
            }
            //获取工种list
            WorkorderWorktypeExample workorderWorktypeExample = new WorkorderWorktypeExample();
            workorderWorktypeExample.setOrderByClause("worktype_number");
            workorderWorktypeExample.createCriteria().andWorkorderIdEqualTo(defectWorkorderVo.getWorkorderId());
            List<WorkorderWorktype> worktypeList = workorderWorktypeMapper.selectByExample(workorderWorktypeExample);
            if (CollectionUtils.isNotEmpty(worktypeList)) {
                worktypeList.forEach(workorderWorktype -> {
                    defectWorkorderVo.getWorkorderWorktypeList().add(workorderWorktype);
                });
            }
            //获取危险点list
            WorkorderDangerPointExample workorderDangerPointExample = new WorkorderDangerPointExample();
            workorderDangerPointExample.setOrderByClause("danger_number");
            workorderDangerPointExample.createCriteria().andWorkorderIdEqualTo(defectWorkorderVo.getWorkorderId());
            List<WorkorderDangerPoint> dangerPointList = workorderDangerPointMapper.selectByExample(workorderDangerPointExample);
            if (CollectionUtils.isNotEmpty(dangerPointList)) {
                dangerPointList.forEach(workorderDangerPoint -> {
                    defectWorkorderVo.getWorkorderDangerPointList().add(workorderDangerPoint);
                });
            }
            //获取关联工作票
            List<WorkTicketForWorkorederVo> workTicketForWorkorederVoList = workTicketMapper.
                    getDefectWorkTicketList(defectWorkorderVo.getWorkorderId());
            if (CollectionUtils.isNotEmpty(workTicketForWorkorederVoList)) {
                workTicketForWorkorederVoList.forEach(workTicketForWorkorederVo -> {
                    workTicketForWorkorederVo.setStatusName(this.getStatusName(workTicketForWorkorederVo.getStatus()));
                    defectWorkorderVo.getWorkTicketForWorkorederVoList().add(workTicketForWorkorederVo);
                });
            }
            //获取关联缺陷工单
            List<OperateTicketForWorkorderVo> operateTicketForWorkorderVoList = operateTicketMapper.
                    getDefectOperTicketList(defectWorkorderVo.getWorkorderId());
            if (CollectionUtils.isNotEmpty(operateTicketForWorkorderVoList)) {
                operateTicketForWorkorderVoList.forEach(operateTicketForWorkorderVo -> {
                    operateTicketForWorkorderVo.setStatusName(this.getStatusName(operateTicketForWorkorderVo.getStatus()));
                    defectWorkorderVo.getOperateTicketForWorkorderVoList().add(operateTicketForWorkorderVo);
                });
            }
        }

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("查询成功");
        resultEntity.setData(defectWorkorderVo);
        return resultEntity;
    }

    @Override
    public PageResultEntity getDefectWorkorderList(Map<String, String> pageAndCondition) throws Exception {
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
        String userId = currentUserService.getId();
        if (CollectionUtils.isEmpty(userRoleList)) {
            pageResultEntity.setMsg("该审批人未配置权限");
            return pageResultEntity;
        }
        //获取缺陷工单主数据列表
        List<DefectWorkorderVo> defectWorkorderVoList = defectWorkorderMapper.getDefectWorkorderList(pageAndCondition,userId,userRoleList);
        if (CollectionUtils.isNotEmpty(defectWorkorderVoList)) {
            for (DefectWorkorderVo defectWorkorderVo:defectWorkorderVoList) {
                defectWorkorderVo.setStatusName(this.getStatusName(defectWorkorderVo.getStatus()));
                //获取本单位工作人员姓名  并给人员id数组赋值
                this.setUnitMemberNamesAndUnitMemberArray(defectWorkorderVo);
            }
        }
        int total = defectWorkorderMapper.getTotal(pageAndCondition,userId,userRoleList);

        pageResultEntity.setCode(ErrorCode.SUCCESS);
        pageResultEntity.setMsg("查询成功");
        pageResultEntity.setRows(defectWorkorderVoList);
        pageResultEntity.setTotal(total);
        return pageResultEntity;
    }

    @Override
    public ResultEntity agreeDefectWorkorder(DefectWorkorderVo defectWorkorderVo) {
        ResultEntity resultEntity = new ResultEntity();

        if (!StringUtils.isNoneBlank(defectWorkorderVo.getSerialNumber())) {
            resultEntity.setMsg("此缺陷工单未提交");
            return resultEntity;
        }
        //获取流程主表
        ResultEntity processResultEntity = processService.getProcessByOrderIdAndType(defectWorkorderVo.getWorkorderId(), "09");
        Process process = (Process)processResultEntity.getData();

        //获取流程步数
        ResultEntity totalSortResultEntity = processService.getTotalSort(process.getProcessId());
        int totalSort = (Integer) totalSortResultEntity.getData();

        if (process!=null && totalSort!=0) {
            //若审核未通过,无法再操作
            if ("03".equals(process.getProcessStatus())) {
                resultEntity.setMsg("此缺陷工单审核已结束");
                return resultEntity;
            }
            //判断流程是否已经结束
            if (process.getProcessSort()==totalSort) {
                resultEntity.setMsg("此缺陷工单审核已结束");
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

                if ("101301".equals(defectWorkorderVo.getDealMode()) && "2".equals(String.valueOf(process.getProcessSort()))) {
                    //保存工单质量验收
                    WorkorderQualityAcceptance workorderQualityAcceptance = defectWorkorderVo.getWorkorderQualityAcceptance();
                    if (workorderQualityAcceptance!=null) {
                        workorderQualityAcceptance.setQualityAcceptanceId(UUIdUtil.getUUID());
                        workorderQualityAcceptance.setWorkorderId(defectWorkorderVo.getWorkorderId());
                        workorderQualityAcceptanceMapper.insert(workorderQualityAcceptance);
                    }
                }
                if ("101302".equals(defectWorkorderVo.getDealMode())) {
                    if ("3".equals(String.valueOf(process.getProcessSort()))) {
                        resultEntity = this.insertTab(defectWorkorderVo, resultEntity);
                        if (resultEntity.getMsg()!=null) {
                            return resultEntity;
                        }
                        defectWorkorderMapper.updateByPrimaryKeySelective(defectWorkorderVo);
                    }
                    if ("4".equals(String.valueOf(process.getProcessStatus()))) {
                        //保存工单质量验收
                        WorkorderQualityAcceptance workorderQualityAcceptance = defectWorkorderVo.getWorkorderQualityAcceptance();
                        if (workorderQualityAcceptance!=null) {
                            workorderQualityAcceptance.setQualityAcceptanceId(UUIdUtil.getUUID());
                            workorderQualityAcceptance.setWorkorderId(defectWorkorderVo.getWorkorderId());
                            workorderQualityAcceptanceMapper.insert(workorderQualityAcceptance);
                        }
                    }
                }
                if ("101303".equals(defectWorkorderVo.getDealMode())) {
                    if ("3".equals(String.valueOf(process.getProcessSort()))) {
                        resultEntity = this.insertTab(defectWorkorderVo, resultEntity);
                        if (resultEntity.getMsg()!=null) {
                            return resultEntity;
                        }
                        defectWorkorderMapper.updateByPrimaryKeySelective(defectWorkorderVo);
                    }
                    if ("4".equals(String.valueOf(process.getProcessSort()))) {
                        //保存工单质量验收
                        WorkorderQualityAcceptance workorderQualityAcceptance = defectWorkorderVo.getWorkorderQualityAcceptance();
                        if (workorderQualityAcceptance!=null) {
                            workorderQualityAcceptance.setQualityAcceptanceId(UUIdUtil.getUUID());
                            workorderQualityAcceptance.setWorkorderId(defectWorkorderVo.getWorkorderId());
                            workorderQualityAcceptanceMapper.insert(workorderQualityAcceptance);
                        }
                    }
                    if ("5".equals(String.valueOf(process.getProcessSort()))) {
                        //保存工单总结
                        WorkorderSummary workorderSummary = defectWorkorderVo.getWorkorderSummary();
                        if (workorderSummary!=null) {
                            workorderSummary.setSummaryId(UUIdUtil.getUUID());
                            workorderSummary.setWorkorderId(defectWorkorderVo.getWorkorderId());
                            workorderSummaryMapper.insert(workorderSummary);
                            this.addMaintainFile(workorderSummary.getSummaryAttachmentList(),defectWorkorderVo.getWorkorderId(),"03");
                        }
                    }
                }

                //生成流程审批记录
                ApproveRecord approveRecord = new ApproveRecord();
                approveRecord.setApproveId(UUIdUtil.getUUID());
                approveRecord.setOrderId(defectWorkorderVo.getWorkorderId());
                approveRecord.setProcessDetailId(processDetail.getProcessDetailId());
                if (process.getProcessSort()==0  && approveRecordService.getApproveRecordListByOrderId(defectWorkorderVo.getWorkorderId()).getData()!=null) {
                    approveRecord.setApproveResult("再次提交");
                }else {
                    approveRecord.setApproveResult("通过");
                }
                approveRecord.setApproveUser(currentUserService.getId());
                approveRecord.setApproveTime(new Date());
                approveRecord.setApproveOpinion(defectWorkorderVo.getExamAndApprOpinion());
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
                        ResultEntity doListResultEntity = doListService.findDoListByTaskId(defectWorkorderVo.getWorkorderId());
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
                            doListService.updateDoList(defectWorkorderVo.getWorkorderId(), doRoleRelas);
                        }
                    }
                }
            }

            //如果当前是最后一步修改流程主表,流程结束
            if (totalSort-process.getProcessSort()==1) {
                //获取代办信息
                ResultEntity doListResultEntity = doListService.findDoListByTaskId(defectWorkorderVo.getWorkorderId());
                DoList doList = (DoList) doListResultEntity.getData();
                if (doList != null) {
                    //修改代办角色关联列表
                    List<DoRoleRela> doRoleRelas = new ArrayList<>();
                    doListService.updateDoList(defectWorkorderVo.getWorkorderId(), doRoleRelas);
                }

                //修改流程主表中的状态为完成
                process.setProcessStatus("02");
                DefectWorkorder defectWorkorder = defectWorkorderMapper.selectByPrimaryKey(defectWorkorderVo.getWorkorderId());
                //设置缺陷工单流程状态跟流程主表同步
                defectWorkorder.setFlowStatus(process.getProcessStatus());
                //设置缺陷工单状态为完成
                defectWorkorder.setStatus("02");
                defectWorkorderMapper.updateByPrimaryKeySelective(defectWorkorder);
            }
            process.setProcessSort(process.getProcessSort()+1);
            processService.updateProcess(process);
        }

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("审批通过");
        return resultEntity;
    }

    @Override
    public ResultEntity backDefectWorkorder(DefectWorkorderVo defectWorkorderVo) {
        ResultEntity resultEntity = new ResultEntity();

        if (!StringUtils.isNoneBlank(defectWorkorderVo.getSerialNumber())) {
            resultEntity.setMsg("此缺陷工单未提交");
            return resultEntity;
        }

        //获取流程主表
        ResultEntity processResultEntity = processService.getProcessByOrderIdAndType(defectWorkorderVo.getWorkorderId(), "07");
        Process process = (Process)processResultEntity.getData();

        //获取流程步数
        ResultEntity totalSortResultEntity = processService.getTotalSort(process.getProcessId());
        int totalSort = (Integer) totalSortResultEntity.getData();

        if (process!=null && totalSort!=0) {
            //若审核未通过,无法再操作
            if ("03".equals(process.getProcessStatus())) {
                resultEntity.setMsg("此缺陷工单审核已结束");
                return resultEntity;
            }
            //若流程步骤为0,则无法退回
            if (process.getProcessSort()==0) {
                resultEntity.setMsg("当前步骤无法退回");
                return resultEntity;
            }
            //判断流程是否已经结束
            if (process.getProcessSort()==totalSort) {
                resultEntity.setMsg("此缺陷工单审核已结束");
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
                approveRecord.setOrderId(defectWorkorderVo.getWorkorderId());
                approveRecord.setProcessDetailId(processDetail.getProcessDetailId());
                approveRecord.setApproveResult("退回");
                approveRecord.setApproveUser(currentUserService.getId());
                approveRecord.setApproveTime(new Date());
                approveRecord.setApproveOpinion(defectWorkorderVo.getExamAndApprOpinion());
                //将流程审批记录插入数据库
                approveRecordService.addApproveRecord(approveRecord);
            }

            //获取上一步流程详情
            processDetailResultEntity = processService.getProcessDetailByProcessIdAndsort(process.getProcessId(), String.valueOf(process.getProcessSort()));
            processDetail = (ProcessDetail) processDetailResultEntity.getData();
            if (processDetail!=null) {
                //流程主表状态往后退一步
                process.setProcessSort(process.getProcessSort()-1);
                DefectWorkorder defectWorkorder = defectWorkorderMapper.selectByPrimaryKey(defectWorkorderVo.getWorkorderId());
                if (process.getProcessSort()==0) {
                    //设置缺陷工单状态为未提交
                    defectWorkorder.setStatus("03");
                }
                //修改流程主表中的状态未审核未通过
                //process.setProcessStatus("03");
                processService.updateProcess(process);

                //设置缺陷工单流程状态跟流程主表同步
                defectWorkorder.setFlowStatus(process.getProcessStatus());
                //设置缺陷工单状态为审核未通过
                //defectWorkorder.setStatus("04");
                defectWorkorderMapper.updateByPrimaryKeySelective(defectWorkorder);

                //修改上一步流程详情为待办
                processDetail.setStatus("01");
                processService.updateProcessDetail(processDetail);

                List<ProcessDetailRoleRela> processDetailRoleRelas = processDetail.getProcessDetailRoleRelas();
                if (CollectionUtils.isNotEmpty(processDetailRoleRelas)) {
                    //获取代办信息
                    ResultEntity doListResultEntity = doListService.findDoListByTaskId(defectWorkorder.getWorkorderId());
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
                        doListService.updateDoList(defectWorkorder.getWorkorderId(),doRoleRelas);
                    }
                }
            }
        }

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("退回成功");
        return resultEntity;
    }

    @Override
    public ResultEntity getFlowStatusList(String workorderId) {
        ResultEntity resultEntity = new ResultEntity();

        if (StringUtils.isBlank(workorderId)) {
            resultEntity.setMsg("id不能为空");
            return resultEntity;
        }

        ResultEntity approveRecordListResultEntity = approveRecordService.getApproveRecordListByOrderId(workorderId);

        return approveRecordListResultEntity;
    }

    @Override
    public ResultEntity getDefectWorkorderBySerialNumber(String serialNumber) {
        ResultEntity resultEntity = new ResultEntity();

        if (!StringUtils.isNoneBlank(serialNumber)) {
            resultEntity.setMsg("缺陷工单号不能为空");
            return resultEntity;
        }
        WorkorderVoForMaterial workorderVoForMaterial = defectWorkorderMapper.getDefectWorkorderBySerialNumber(serialNumber);
        if (workorderVoForMaterial!=null) {
            workorderVoForMaterial.setValue(serialNumber);
        }else {
            workorderVoForMaterial = workorderInfoMapper.getWorkorderBySerialNumber(serialNumber);
            if (workorderVoForMaterial!=null) {
                workorderVoForMaterial.setValue(serialNumber);
            }
        }

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("查询成功");
        resultEntity.setData(workorderVoForMaterial);
        return resultEntity;
    }

    @Override
    public ResultEntity getWorkorderMaterialList(String serialNumber,String stockAddId) {
        ResultEntity resultEntity = new ResultEntity();

        if (!StringUtils.isNoneBlank(serialNumber)) {
            resultEntity.setMsg("缺陷工单号不能为空");
            return resultEntity;
        }

        List<WorkorderMaterialVo> workorderMaterialVoList = null;
        String workorderId = defectWorkorderMapper.getIdBySerialNumber(serialNumber);
        if (workorderId!=null) {
            workorderMaterialVoList = workorderMaterialMapper.getWorkorderMaterialVoByworkorderId(workorderId,stockAddId);
            if (CollectionUtils.isNotEmpty(workorderMaterialVoList)) {
                workorderMaterialVoList.forEach(workorderMaterialVo -> {
                    workorderMaterialVo.setCost(this.getCost(workorderMaterialVo));
                });
            }else {
                String orderId = workorderInfoMapper.getIdBySerialNumber(serialNumber);
                if (orderId!=null) {
                    workorderMaterialVoList = workorderMaterialMapper.getWorkorderMaterialVoByorderId(orderId,stockAddId);
                    if (CollectionUtils.isNotEmpty(workorderMaterialVoList)) {
                        workorderMaterialVoList.forEach(workorderMaterialVo -> {
                            workorderMaterialVo.setCost(this.getCost(workorderMaterialVo));
                        });
                    }
                }
            }
        }else {
            String orderId = workorderInfoMapper.getIdBySerialNumber(serialNumber);
            if (orderId!=null) {
                workorderMaterialVoList = workorderMaterialMapper.getWorkorderMaterialVoByorderId(orderId,stockAddId);
                if (CollectionUtils.isNotEmpty(workorderMaterialVoList)) {
                    workorderMaterialVoList.forEach(workorderMaterialVo -> {
                        workorderMaterialVo.setCost(this.getCost(workorderMaterialVo));
                    });
                }
            }
        }


        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("查询成功");
        resultEntity.setData(workorderMaterialVoList);
        return resultEntity;
    }

    private ResultEntity insertTab(DefectWorkorderVo defectWorkorderVo,ResultEntity resultEntity) {
        //保存工序列表
        List<WorkorderProcess> processList = defectWorkorderVo.getWorkorderProcessList();
        if ("01".equals(defectWorkorderVo.getStatus())) {
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
                workorderProcess.setWorkorderId(defectWorkorderVo.getWorkorderId());
                workorderProcessMapper.insert(workorderProcess);
            }
        }
        //保存工单物资
        List<WorkorderMaterialVo> materialList = defectWorkorderVo.getWorkorderMaterialList();
        if (CollectionUtils.isNotEmpty(materialList)) {
            materialList.forEach(workorderMaterial -> {
                workorderMaterial.setWorkorderMaterialId(UUIdUtil.getUUID());
                workorderMaterial.setWorkorderId(defectWorkorderVo.getWorkorderId());
                workorderMaterialMapper.insert(workorderMaterial);
            });
        }
        //保存工单服务
        List<WorkorderService> serviceList = defectWorkorderVo.getWorkorderServiceList();
        if (CollectionUtils.isNotEmpty(serviceList)) {
            int i = 1;
            for (WorkorderService workorderService:serviceList) {
                if (!StringUtils.isNoneBlank(workorderService.getServiceDesc())) {
                    resultEntity.setMsg("服务描述不能为空");
                    return resultEntity;
                }
                workorderService.setServiceId(UUIdUtil.getUUID());
                workorderService.setServiceNumber(String.valueOf(i++));
                workorderService.setWorkorderId(defectWorkorderVo.getWorkorderId());
                workorderServiceMapper.insert(workorderService);
            }
        }
        //保存工单工器具
        List<WorkorderTool> toolList = defectWorkorderVo.getWorkorderToolList();
        if (CollectionUtils.isNotEmpty(toolList)) {
            int i = 1;
            for (WorkorderTool workorderTool:toolList) {
                if (!StringUtils.isNoneBlank(workorderTool.getToolDesc())) {
                    resultEntity.setMsg("工器具描述不能为空");
                    return resultEntity;
                }
                workorderTool.setToolId(UUIdUtil.getUUID());
                workorderTool.setToolNumber(String.valueOf(i++));
                workorderTool.setWorkorderId(defectWorkorderVo.getWorkorderId());
                workorderToolMapper.insert(workorderTool);
            }
        }
        //保存工单工种
        List<WorkorderWorktype> worktypeList = defectWorkorderVo.getWorkorderWorktypeList();
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
                workorderWorktype.setWorkorderId(defectWorkorderVo.getWorkorderId());
                workorderWorktypeMapper.insert(workorderWorktype);
            }
        }
        //保存工单危险点控制
        List<WorkorderDangerPoint> dangerPointList = defectWorkorderVo.getWorkorderDangerPointList();
        if (CollectionUtils.isNotEmpty(dangerPointList)) {
            int i = 1;
            for (WorkorderDangerPoint workorderDangerPoint:dangerPointList) {
                if (!StringUtils.isNoneBlank(workorderDangerPoint.getDangerDangerSource())) {
                    resultEntity.setMsg("危险源不能为空");
                    return resultEntity;
                }
                workorderDangerPoint.setDangerPointId(UUIdUtil.getUUID());
                workorderDangerPoint.setDangerNumber(String.valueOf(i++));
                workorderDangerPoint.setWorkorderId(defectWorkorderVo.getWorkorderId());
                workorderDangerPointMapper.insert(workorderDangerPoint);
            }
        }
        //关联工作票
        List<WorkTicketForWorkorederVo> workTicketForWorkorederVoList = defectWorkorderVo.getWorkTicketForWorkorederVoList();
        if (CollectionUtils.isNotEmpty(workTicketForWorkorederVoList)) {
            for (WorkTicketForWorkorederVo workTicketForWorkorederVo:workTicketForWorkorederVoList) {
                WorkTicket workTicket = workTicketMapper.selectByPrimaryKey(workTicketForWorkorederVo.getTicketId());
                if (workTicket!=null) {
                    workTicket.setWorkorderId(defectWorkorderVo.getWorkorderId());
                    workTicketMapper.updateByPrimaryKey(workTicket);
                }
            }
        }
        //关联缺陷工单
        List<OperateTicketForWorkorderVo> operateTicketForWorkorderVoList = defectWorkorderVo.getOperateTicketForWorkorderVoList();
        if (CollectionUtils.isNotEmpty(operateTicketForWorkorderVoList)) {
            for (OperateTicketForWorkorderVo operateTicketForWorkorderVo:operateTicketForWorkorderVoList) {
                OperateTicket operateTicket = operateTicketMapper.selectByPrimaryKey(operateTicketForWorkorderVo.getTicketId());
                if (operateTicket!=null){
                    operateTicket.setWorkorderId(defectWorkorderVo.getWorkorderId());
                    operateTicketMapper.updateByPrimaryKey(operateTicket);
                }
            }
        }
        return resultEntity;
    }

    private ResultEntity updateTab(DefectWorkorderVo defectWorkorderVo,ResultEntity resultEntity) {
        //删除原来的工序
        WorkorderProcessExample workorderProcessExample = new WorkorderProcessExample();
        workorderProcessExample.createCriteria().andWorkorderIdEqualTo(defectWorkorderVo.getWorkorderId());
        workorderProcessMapper.deleteByExample(workorderProcessExample);
        //删除原来的物资
        WorkorderMaterialExample workorderMaterialExample = new WorkorderMaterialExample();
        workorderMaterialExample.createCriteria().andWorkorderIdEqualTo(defectWorkorderVo.getWorkorderId());
        workorderMaterialMapper.deleteByExample(workorderMaterialExample);
        //删除原来的服务
        WorkorderServiceExample workorderServiceExample = new WorkorderServiceExample();
        workorderServiceExample.createCriteria().andWorkorderIdEqualTo(defectWorkorderVo.getWorkorderId());
        workorderServiceMapper.deleteByExample(workorderServiceExample);
        //删除原来的工器具
        WorkorderToolExample workorderToolExample = new WorkorderToolExample();
        workorderToolExample.createCriteria().andWorkorderIdEqualTo(defectWorkorderVo.getWorkorderId());
        workorderToolMapper.deleteByExample(workorderToolExample);
        //删除原来的工种
        WorkorderWorktypeExample workorderWorktypeExample = new WorkorderWorktypeExample();
        workorderWorktypeExample.createCriteria().andWorkorderIdEqualTo(defectWorkorderVo.getWorkorderId());
        workorderWorktypeMapper.deleteByExample(workorderWorktypeExample);
        //删除原来的危险点控制
        WorkorderDangerPointExample workorderDangerPointExample = new WorkorderDangerPointExample();
        workorderDangerPointExample.createCriteria().andWorkorderIdEqualTo(defectWorkorderVo.getWorkorderId());
        workorderDangerPointMapper.deleteByExample(workorderDangerPointExample);

        //重新添加
        resultEntity = this.insertTab(defectWorkorderVo,resultEntity);
        return resultEntity;
    }

    private void deleteTab(List<String> workorderIdList) {
        //根据缺陷工单ids批量删除工序
        workorderProcessMapper.batchDeleteByWorkOrderIds(workorderIdList);
        //根据缺陷工单ids批量删除物资
        workorderMaterialMapper.batchDeleteByWorkOrderIds(workorderIdList);
        //根据缺陷工单ids删除服务
        workorderServiceMapper.batchDeleteByWorkOrderIds(workorderIdList);
        //根据缺陷工单ids删除工器具
        workorderToolMapper.batchDeleteByWorkOrderIds(workorderIdList);
        //根据缺陷工单ids删除工种
        workorderWorktypeMapper.batchDeleteByWorkOrderIds(workorderIdList);
        //根据缺陷工单ids删除危险点控制
        workorderDangerPointMapper.batchDeleteByWorkOrderIds(workorderIdList);
        //批量解除缺陷工单与工作票的关联
        workTicketMapper.batchDeleteFalseByWorkorderIds(workorderIdList);
        //批量解除缺陷工单与操作票的关联
        operateTicketMapper.batchDeleteFalseByWorkorderIds(workorderIdList);
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

    //获取移动平均价
    private BigDecimal getCost(WorkorderMaterialVo workorderMaterialVo) {
        InventoryExample averagePriceExample = new InventoryExample();
        averagePriceExample.createCriteria().andMaterialIdEqualTo(workorderMaterialVo.getMaterialId()).andWindIdEqualTo(workorderMaterialVo.getWindId()).andStatusEqualTo(StockMaterialStatusEnum.STATUS_NORMAL.getCode()).andMaterialStatusTo(EnableStatusEnum.ENABLE_START.getCode()).andMaterialIsDeleteTo(IsDeleteEnum.DELETE_NO.getCode());;
        Inventory inventory2=inventoryMapper.selectAveragePriceExample(averagePriceExample);
        if (inventory2!=null && inventory2.getAveragePrice()!=null) {
            return inventory2.getAveragePrice();
        }
        return null;
    }

    //将文件id数组转成字符串,逗号隔开  save
    private void setPicture(DefectWorkorderVo defectWorkorderVo) {
        String[] fileIds = defectWorkorderVo.getFileIds();
        if (ArrayUtils.isNotEmpty(fileIds)) {
            StringBuffer sb = new StringBuffer();
            for (String fileId:fileIds) {
                sb.append(fileId).append(",");
            }
            if (sb.length()>1) {
                defectWorkorderVo.setPicture(sb.deleteCharAt(sb.length()-1).toString());
            }
        }
    }



    //将人员id字符串转成姓名字符串,给unitMemberNames和setUnitMemberArray赋值  select
    private void setUnitMemberNamesAndUnitMemberArray(DefectWorkorderVo defectWorkorderVo) throws Exception {
        String unitMember = defectWorkorderVo.getUnitMember();
        if (unitMember!=null) {
            String[] ids = unitMember.split(",");
            if (ArrayUtils.isNotEmpty(ids)) {
                //
                defectWorkorderVo.setUnitMemberArray(ids);
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
                    defectWorkorderVo.setUnitMemberNames(sb.deleteCharAt(sb.length() - 1).toString());
                }
            }
        }
    }

    //设置本单位工作人员字符串,逗号隔开  save
    private void setUnitMember(DefectWorkorderVo defectWorkorderVo) {
        String[] unitMemberArray = defectWorkorderVo.getUnitMemberArray();
        if (ArrayUtils.isNotEmpty(unitMemberArray)) {
            StringBuffer sb = new StringBuffer();
            for (String id:unitMemberArray) {
                sb.append(id).append(",");
            }
            if (sb.length()>1) {
                defectWorkorderVo.setUnitMember(sb.deleteCharAt(sb.length()-1).toString());
            }
        }
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

    private void addMaintainFile(List<FileInfo> fileList,String workorderId,String type) {
        List<MaintainFile> maintainFiles = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(fileList)) {
            for (FileInfo fileInfo:fileList) {
                MaintainFile maintainFile = new MaintainFile();
                maintainFile.setId(UUIdUtil.getUUID());
                maintainFile.setAssoId(workorderId);
                maintainFile.setFileId(fileInfo.getFileId());
                maintainFile.setType(type);
                maintainFiles.add(maintainFile);
            }
            maintainFileMapper.insertList(maintainFiles);
        }
    }
    private void addMaintainPic(List<FileInfo> fileList, String workorderId, String type) {
        List<MaintainFile> maintainFiles = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(fileList)) {
            for (FileInfo fileInfo:fileList) {
                MaintainFile maintainFile = new MaintainFile();
                maintainFile.setId(UUIdUtil.getUUID());
                maintainFile.setAssoId(workorderId);
                maintainFile.setFileId(fileInfo.getFileId());
                maintainFile.setType(type);
                maintainFiles.add(maintainFile);
            }
            maintainFileMapper.insertList(maintainFiles);
        }
    }

    private void updateMaintainFileAndRemoveFile(List<FileInfo> fileList,String workorderId,String type) {
        List<String> attachmentFileIds = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(fileList)) {
            for (FileInfo fileInfo:fileList) {
                attachmentFileIds.add(fileInfo.getFileId());
            }

            List<String> fileIdList = maintainFileMapper.getMaintainFileList(workorderId,type);
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
                        maintainFile.setAssoId(workorderId);
                        maintainFile.setFileId(fileId);
                        maintainFile.setType(type);
                        maintainFiles.add(maintainFile);
                    }
                }
                maintainFileMapper.insertList(maintainFiles);
            }else {
                this.addMaintainFile(fileList,workorderId,type);
            }
        }else {
            maintainFileMapper.batchDeleteByAssoId(workorderId,type);
        }
    }

    private void updateMaintainFileAndRemovePic(List<FileInfo> fileList, String workorderId, String type) {
        List<String> attachmentFileIds = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(fileList)) {
            for (FileInfo fileInfo:fileList) {
                attachmentFileIds.add(fileInfo.getFileId());
            }

            List<String> fileIdList = maintainFileMapper.getMaintainFileList(workorderId,type);
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
                        maintainFile.setAssoId(workorderId);
                        maintainFile.setFileId(fileId);
                        maintainFile.setType(type);
                        maintainFiles.add(maintainFile);
                    }
                }
                if (CollectionUtils.isNotEmpty(maintainFiles)) {
                    maintainFileMapper.insertList(maintainFiles);
                }
            }else {
                this.addMaintainPic(fileList,workorderId,type);
            }
        }else {
            maintainFileMapper.batchDeleteByAssoId(workorderId,type);
        }
    }

    @Override
    public ResultEntity cancelChangeDefectFile(CancelFileVo cancelFileVo) {
        ResultEntity resultEntity = new ResultEntity();

        String workorderId = cancelFileVo.getWorkorderId();
        List<String> fileIds = cancelFileVo.getFileIds();
        String type = cancelFileVo.getType();
        if (StringUtils.isNoneBlank(workorderId) &&
                CollectionUtils.isNotEmpty(fileIds) &&
                    StringUtils.isNoneBlank(type)) {
            List<String> fileIdList = maintainFileMapper.getMaintainFileList(workorderId,type);
            for (String fileId:fileIds) {
                if(!fileIdList.contains(fileId)) {
                    try {
                        commonService.removeFile(fileId);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("操作成功");
        return resultEntity;
    }

    private List<FileInfo> getFile(String workorderId,String type) {
        List<FileInfo> fileInfos = new ArrayList<>();
        List<String> fileIdList = maintainFileMapper.getMaintainFileList(workorderId, type);
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

    public List<FileInfo> getPic(DefectWorkorderVo defectWorkorderVo, String type) throws FileException {
        List<FileInfo> fileInfos = new ArrayList<>();
        List<String> fileIdList = maintainFileMapper.getMaintainFileList(defectWorkorderVo.getWorkorderId(), type);

        String pic = "data:image/png;base64,";
        BASE64Encoder base64Encoder = new BASE64Encoder();
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
                }

                byte[] download = commonService.download(fileId);
                String encode = base64Encoder.encode(download);
                pic += encode;
                fileInfo.setPicDate(pic);
                fileInfo.setUrl(pic);

                fileInfos.add(fileInfo);
            }
        }
        return fileInfos;
    }
}
