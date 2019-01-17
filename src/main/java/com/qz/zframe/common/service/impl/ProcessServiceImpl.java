package com.qz.zframe.common.service.impl;

import com.qz.zframe.authentication.CurrentUserService;
import com.qz.zframe.common.controller.DeployController;
import com.qz.zframe.common.dao.ProcessDetailMapper;
import com.qz.zframe.common.dao.ProcessDetailRoleRelaMapper;
import com.qz.zframe.common.dao.ProcessMapper;
import com.qz.zframe.common.entity.Process;
import com.qz.zframe.common.entity.ProcessDetail;
import com.qz.zframe.common.entity.ProcessDetailRoleRela;
import com.qz.zframe.common.entity.Role;
import com.qz.zframe.common.service.ProcessService;
import com.qz.zframe.common.service.RoleService;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.common.util.UUIdUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProcessServiceImpl implements ProcessService {

    private static Logger logger = LoggerFactory.getLogger(DeployController.class);

    @Autowired
    private ProcessMapper processMapper;

    @Autowired
    private ProcessDetailMapper processDetailMapper;

    @Autowired
    private ProcessDetailRoleRelaMapper processDetailRoleRelaMapper;

    @Autowired
    private RoleService roleService;

    @Autowired
    private CurrentUserService currentUserService;

    @Override
    public ResultEntity addProcess(Process process) {
        ResultEntity resultEntity = new ResultEntity();

        if (StringUtils.isBlank(process.getProcessId())) {
            logger.info("===== 流程主表id不能为空 ===== ");
            resultEntity.setMsg("流程主表id不能为空");
            return resultEntity;
        }
        if (StringUtils.isBlank(process.getOrderId())) {
            logger.info("===== 关联id不能为空 ===== ");
            resultEntity.setMsg("关联id不能为空");
            return resultEntity;
        }
        if (process.getProcessSort()==null) {
            logger.info("===== 流程步骤不能为空 ===== ");
            resultEntity.setMsg("流程步骤不能为空");
            return resultEntity;
        }
        if (StringUtils.isBlank(process.getProcessType())) {
            logger.info("===== 流程类型不能为空 ===== ");
            resultEntity.setMsg("流程类型不能为空");
            return resultEntity;
        }
        if (StringUtils.isBlank(process.getProcessStatus())) {
            logger.info("===== 流程状态不能为空 ===== ");
            resultEntity.setMsg("流程状态不能为空");
            return resultEntity;
        }
        if (process.getCreateTime()==null) {
            logger.info("===== 创建时间不能为空 ===== ");
            resultEntity.setMsg("创建时间不能为空");
            return resultEntity;
        }
        //获取流程详情列表
        List<ProcessDetail> processDetails = process.getProcessDetails();
        if (CollectionUtils.isEmpty(processDetails)) {
            logger.info("===== 流程详情不能为空 ===== ");
            resultEntity.setMsg("流程详情不能为空");
            return resultEntity;
        }
        for (ProcessDetail processDetail:processDetails) {
            if (StringUtils.isBlank(processDetail.getProcessDetailId())) {
                logger.info("===== 流程详情id不能为空 ===== ");
                resultEntity.setMsg("流程详情id不能为空");
                return resultEntity;
            }
            if (StringUtils.isBlank(processDetail.getProcessId())) {
                logger.info("===== 流程主表id不能为空 ===== ");
                resultEntity.setMsg("流程主表id不能为空");
                return resultEntity;
            }
            if (processDetail.getSort()==null) {
                logger.info("===== 流程步骤不能为空 ===== ");
                resultEntity.setMsg("流程步骤不能为空");
                return resultEntity;
            }
            if (StringUtils.isBlank(processDetail.getStatus())) {
                logger.info("===== 流程状态不能为空 ===== ");
                resultEntity.setMsg("流程状态不能为空");
                return resultEntity;
            }
            //获取流程详情关联角色列表
            List<ProcessDetailRoleRela> processDetailRoleRelas = processDetail.getProcessDetailRoleRelas();
            if (CollectionUtils.isEmpty(processDetailRoleRelas)) {
                logger.info("===== 流程详情关联角色列表不能为空 ===== ");
                resultEntity.setMsg("流程详情关联角色列表不能为空");
                return resultEntity;
            }
            for (ProcessDetailRoleRela processDetailRoleRela:processDetailRoleRelas) {
                if (StringUtils.isBlank(processDetailRoleRela.getProcessDetailId())) {
                    logger.info("===== 流程详情id不能为空 ===== ");
                    resultEntity.setMsg("流程详情id不能为空");
                    return resultEntity;
                }
                if (StringUtils.isBlank(processDetailRoleRela.getRoleId())) {
                    logger.info("===== 角色id不能为空 ===== ");
                    resultEntity.setMsg("角色id不能为空");
                    return resultEntity;
                }
            }
            //流程详情与角色关联列表插入数据库
            processDetailRoleRelaMapper.insertList(processDetailRoleRelas);
        }
        //流程主表信息插入数据库
        processMapper.insertSelective(process);
        //流程详情列表插入数据库
        processDetailMapper.insertList(processDetails);

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("新增成功");
        return resultEntity;
    }

    @Override
    public ResultEntity updateProcess(Process process) {
        ResultEntity resultEntity = new ResultEntity();

        if (StringUtils.isBlank(process.getProcessId())) {
            logger.info("===== 流程主表id不能为空 ===== ");
            resultEntity.setMsg("流程主表id不能为空");
            return resultEntity;
        }
        if (StringUtils.isBlank(process.getOrderId())) {
            logger.info("===== 关联id不能为空 ===== ");
            resultEntity.setMsg("关联id不能为空");
            return resultEntity;
        }
        if (process.getProcessSort()==null) {
            logger.info("===== 流程步骤不能为空 ===== ");
            resultEntity.setMsg("流程步骤不能为空");
            return resultEntity;
        }
        if (StringUtils.isBlank(process.getProcessType())) {
            logger.info("===== 流程类型不能为空 ===== ");
            resultEntity.setMsg("流程类型不能为空");
            return resultEntity;
        }
        if (StringUtils.isBlank(process.getProcessStatus())) {
            logger.info("===== 流程状态不能为空 ===== ");
            resultEntity.setMsg("流程状态不能为空");
            return resultEntity;
        }
        if (process.getCreateTime()==null) {
            logger.info("===== 创建时间不饿能为空 ===== ");
            resultEntity.setMsg("创建时间不饿能为空");
            return resultEntity;
        }

        //修改数据库
        processMapper.updateByPrimaryKey(process);

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("修改成功");
        return resultEntity;
    }

    @Override
    public ResultEntity updateProcessDetail(ProcessDetail processDetail) {
        ResultEntity resultEntity = new ResultEntity();

        if (StringUtils.isBlank(processDetail.getProcessDetailId())) {
            logger.info("===== 流程详情id不能为空 ===== ");
            resultEntity.setMsg("流程详情id不能为空");
            return resultEntity;
        }
        if (StringUtils.isBlank(processDetail.getProcessId())) {
            logger.info("===== 流程主表id不能为空 ===== ");
            resultEntity.setMsg("流程主表id不能为空");
            return resultEntity;
        }
        if (processDetail.getSort()==null) {
            logger.info("===== 流程步骤不能为空 ===== ");
            resultEntity.setMsg("流程步骤不能为空");
            return resultEntity;
        }
        if (StringUtils.isBlank(processDetail.getStatus())) {
            logger.info("===== 流程状态不能为空 ===== ");
            resultEntity.setMsg("流程状态不能为空");
            return resultEntity;
        }

        //修改数据库
        processDetailMapper.updateByPrimaryKey(processDetail);

        resultEntity.setMsg("修改成功");
        resultEntity.setCode(ErrorCode.SUCCESS);
        return resultEntity;
    }

    @Override
    public ResultEntity getProcessByOrderIdAndType(String orderId, String processType) {
        ResultEntity resultEntity = new ResultEntity();

        if (StringUtils.isBlank(orderId)) {
            logger.info("===== 关联id不能为空 ===== ");
            resultEntity.setMsg("关联id不能为空");
            return resultEntity;
        }
        /*if (StringUtils.isBlank(processType)) {
            logger.info("===== 流程类型不能为空 ===== ");
            resultEntity.setMsg("流程类型不能为空");
            return resultEntity;
        }*/

        Process process = processMapper.getProcessByOrderIdAndType(orderId, processType);
        if (process!=null) {
            List<ProcessDetail> processDetails = processDetailMapper.getProcessDetailByProcessId(process.getProcessId());
            if (CollectionUtils.isNotEmpty(processDetails)) {
                process.setProcessDetails(processDetails);
                for (ProcessDetail processDetail:processDetails) {
                    List<ProcessDetailRoleRela> processDetailRoleRelas = processDetailRoleRelaMapper.getProcessDetailRoleRelaByprocessDetailId(processDetail.getProcessDetailId());
                    if (CollectionUtils.isNotEmpty(processDetailRoleRelas)) {
                        processDetail.setProcessDetailRoleRelas(processDetailRoleRelas);
                    }
                }
            }
        }

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("查询成功");
        resultEntity.setData(process);
        return resultEntity;
    }

    @Override
    public ResultEntity getProcessDetailByProcessIdAndsort(String processId, String sort) {
        ResultEntity resultEntity = new ResultEntity();

        if (StringUtils.isBlank(processId)) {
            logger.info("===== 流程主表id不能为空 ===== ");
            resultEntity.setMsg("流程主表id不能为空");
            return resultEntity;
        }
        if (StringUtils.isBlank(sort)) {
            logger.info("===== 流程步骤不能为空 ===== ");
            resultEntity.setMsg("流程步骤不能为空");
            return resultEntity;
        }

        ProcessDetail processDetail = processDetailMapper.getProcessDetailByProcessIdAndsort(processId, sort);
        List<ProcessDetailRoleRela> processDetailRoleRelas = processDetailRoleRelaMapper.getProcessDetailRoleRelaByprocessDetailId(processDetail.getProcessDetailId());
        if (CollectionUtils.isNotEmpty(processDetailRoleRelas)) {
            processDetail.setProcessDetailRoleRelas(processDetailRoleRelas);
        }

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("查询成功");
        resultEntity.setData(processDetail);
        return resultEntity;
    }

    @Override
    public ResultEntity getTotalSort(String processId) {
        ResultEntity resultEntity = new ResultEntity();

        if (StringUtils.isBlank(processId)) {
            logger.info("===== 流程主表id不能为空 ===== ");
            resultEntity.setMsg("流程主表id不能为空");
            return resultEntity;
        }

        int totalSort = processDetailMapper.getTotalSort(processId);

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("查询成功");
        resultEntity.setData(totalSort);
        return resultEntity;
    }

    @Override
    public ResultEntity isPermissions(String id) {
        ResultEntity resultEntity = new ResultEntity();

        if (StringUtils.isBlank(id)) {
            resultEntity.setMsg("id不能为空");
            return resultEntity;
        }

        //获取流程主表
        ResultEntity processResultEntity = this.getProcessByOrderIdAndType(id, null);
        Process process = (Process)processResultEntity.getData();

        if (process==null) {
            resultEntity.setMsg("请先提交");
            return resultEntity;
        }

        if (process!=null) {
            if ("02".equals(process.getProcessStatus())) {
                resultEntity.setMsg("审批已结束,无法再操作");
                return resultEntity;
            }
            if ("03".equals(process.getProcessStatus())) {
                resultEntity.setMsg("审批被拒绝,无法再操作");
                return resultEntity;
            }
            //获取流程详情
            ResultEntity processDetailResultEntity = this.getProcessDetailByProcessIdAndsort(process.getProcessId(), String.valueOf(process.getProcessSort() + 1));
            ProcessDetail processDetail = (ProcessDetail) processDetailResultEntity.getData();
            if (processDetail != null) {
                //判断权限
                boolean flag = true;
                List<ProcessDetailRoleRela> processDetailRoleRelas = processDetail.getProcessDetailRoleRelas();
                if (CollectionUtils.isNotEmpty(processDetailRoleRelas)) {
                    for (ProcessDetailRoleRela processDetailRoleRela : processDetailRoleRelas) {
                        try {
                            List<Role> userRoleList = roleService.findUserRoleList(currentUserService.getId());
                            for (Role role : userRoleList) {
                                if (processDetailRoleRela.getRoleId().equals(role.getRoleId())) {
                                    flag = false;
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    if (flag) {
                        resultEntity.setMsg("您无此权限");
                        resultEntity.setData("02");
                        return resultEntity;
                    }
                }
            }
        }
        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("可以审批");
        resultEntity.setData("01");
        return resultEntity;
    }
}
