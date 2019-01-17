package com.qz.zframe.common.service;

import com.qz.zframe.common.entity.DoList;
import com.qz.zframe.common.entity.DoRoleRela;
import com.qz.zframe.common.util.ResultEntity;

import java.util.List;

public interface DoListService {

    /**
     * 新增待办信息
     * @param doList
     * @return
     */
    ResultEntity addDoList(DoList doList);

    /**
     * 根据任务id修改关联角色
     * @param taskId
     * @return
     */
    ResultEntity updateDoList(String taskId, List<DoRoleRela> doRoleRelas);

    /**
     * 获取待办信息
     * @return
     */
    ResultEntity findDoList();

    /**
     * 根据任务id获取代办信息
     * @return
     */
    ResultEntity findDoListByTaskId(String taskId);

}
