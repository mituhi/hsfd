package com.qz.zframe.common.service.impl;

import com.qz.zframe.authentication.CurrentUserService;
import com.qz.zframe.common.controller.DeployController;
import com.qz.zframe.common.dao.DoListDao;
import com.qz.zframe.common.entity.DoList;
import com.qz.zframe.common.entity.DoRoleRela;
import com.qz.zframe.common.entity.Role;
import com.qz.zframe.common.service.DoListService;
import com.qz.zframe.common.service.RoleService;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.ResultEntity;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class DoListServiceImpl implements DoListService {

    private static Logger logger = LoggerFactory.getLogger(DeployController.class);

    @Autowired
    private DoListDao doListDao;

    @Autowired
    private CurrentUserService currentUserService;

    @Autowired
    private RoleService roleService;

    /**
     * 新增待办信息
     * @param doList
     * @return
     */
    @Override
    @Transactional
    public ResultEntity addDoList(DoList doList) {
        ResultEntity resultEntity = new ResultEntity();
        if (doList == null) {
            logger.info("===== 传入对象不能为空 ===== ");
            resultEntity.setCode(ErrorCode.ERROR);
            resultEntity.setMsg("传入对象不能为空!");
            return resultEntity;
        }
        if (StringUtils.isBlank(doList.getTaskId())) {
            logger.info("===== 任务id不能为空 ===== ");
            resultEntity.setCode(ErrorCode.ERROR);
            resultEntity.setMsg("任务id不能为空!");
            return resultEntity;
        }
        if (StringUtils.isBlank(doList.getTaskDescribe())) {
            logger.info("===== 任务描述不能为空 ===== ");
            resultEntity.setCode(ErrorCode.ERROR);
            resultEntity.setMsg("任务描述不能为空!");
            return resultEntity;
        }
        if (StringUtils.isBlank(doList.getTaskType())) {
            logger.info("===== 任务类型不能为空 ===== ");
            resultEntity.setCode(ErrorCode.ERROR);
            resultEntity.setMsg("任务类型不能为空!");
            return resultEntity;
        }
        if (doList.getDoRoleRelas() == null || doList.getDoRoleRelas().isEmpty()) {
            logger.info("===== 角色id不能为空 ===== ");
            resultEntity.setCode(ErrorCode.ERROR);
            resultEntity.setMsg("角色id不能为空!");
            return resultEntity;
        }
        doList.setDoId(UUID.randomUUID().toString().replaceAll("-",""));
        doList.setCreateTime(new Date());
        doListDao.addDoList(doList);

        List<DoRoleRela> doRoleRelas = doList.getDoRoleRelas();
        for (DoRoleRela d : doRoleRelas) {
            d.setDoId(doList.getDoId());
            d.setRelaId(UUID.randomUUID().toString().replaceAll("-",""));
        }
        doListDao.addDoRoleRelas(doRoleRelas);

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("保存成功");
        return resultEntity;
    }

    /**
     * 根据任务id修改关联角色
     * @param taskId
     * @param doRoleRelas
     * @return
     */
    @Override
    public ResultEntity updateDoList(String taskId, List<DoRoleRela> doRoleRelas) {
        ResultEntity resultEntity = new ResultEntity();
        if (StringUtils.isBlank(taskId)) {
            logger.info("===== 任务id不能为空 ===== ");
            resultEntity.setCode(ErrorCode.ERROR);
            resultEntity.setMsg("任务id不能为空!");
            return resultEntity;
        }
        DoList doList = doListDao.findDoListByTaskId(taskId);
        if (doList != null) {
            List<DoRoleRela> oldDoRoleRelas = doListDao.findDoRoleRelaByRelaId(doList.getDoId());
            if (oldDoRoleRelas != null && !oldDoRoleRelas.isEmpty()) {
                doListDao.deleteDoRoleRelas(oldDoRoleRelas);
            }
            if (doRoleRelas!=null && !doRoleRelas.isEmpty()) {
                System.out.println("添加角色"+doRoleRelas.size());
                doListDao.addDoRoleRelas(doRoleRelas);
            }
            resultEntity.setCode(ErrorCode.SUCCESS);
            resultEntity.setMsg("修改关联角色成功!");
            return resultEntity;
        }
        resultEntity.setCode(ErrorCode.ERROR);
        resultEntity.setMsg("待办信息不存在!");
        return resultEntity;
    }

    /**
     * 获取待办信息
     * @return
     */
    @Override
    public ResultEntity findDoList() {
        ResultEntity resultEntity = new ResultEntity();
        //获取当前登录人id
        String userId = currentUserService.getId();
        //获取当前登录人角色
        List<Role> roles = roleService.findUserRoleList(userId);
        //获取待办信息
        List<DoList> doLists = doListDao.findDoListByRole(roles);
        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setData(doLists);
        return resultEntity;
    }

    /**
     * 根据任务id获取代办信息
     * @return
     */
    @Override
    public ResultEntity findDoListByTaskId(String taskId) {

        ResultEntity resultEntity = new ResultEntity();
        DoList doList = doListDao.findDoListByTaskId(taskId);

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("查询成功");
        resultEntity.setData(doList);
        return resultEntity;
    }
}
