package com.qz.zframe.tickets.service;

import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.tickets.entity.TypicalOperateTicket;

import java.util.Map;

public interface TypicalOperateTicketService {

    /**
     * 典型操作票列表分页+条件查询
     */
    public PageResultEntity getTypicalOperateTicketList(Map<String, String> pageAndCondition);

    /**
     * 新增典型操作票
     */
    public ResultEntity createTypicalOperateTicket();

    /**
     * 添加典型操作票
     */
    public ResultEntity addTypicalOperateTicket(TypicalOperateTicket typicalOperateTicket);

    /**
     * 删除典型操作票
     */
    public ResultEntity deleteTypicalOperateTicket(String typicalTicketIds);

    /**
     * 修改典型操作票
     */
    public ResultEntity updateTypicalOperateTicket(TypicalOperateTicket typicalOperateTicket);

    /**
     * 查询典型操作票详情
     */
    public ResultEntity selectTypicalOperateTicket(String typicalTicketId);
}
