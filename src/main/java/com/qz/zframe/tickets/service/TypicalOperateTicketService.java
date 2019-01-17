package com.qz.zframe.tickets.service;

import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.tickets.entity.TypicalOperateTicket;
import com.qz.zframe.tickets.vo.TypicalOperateTicketVo;

import java.util.Map;

public interface TypicalOperateTicketService {

    /**
     * 添加典型操作票
     */
    ResultEntity addTypicalOperateTicket(TypicalOperateTicketVo typicalOperateTicketVo);

    /**
     * 修改典型操作票
     */
    ResultEntity updateTypicalOperateTicket(TypicalOperateTicketVo typicalOperateTicketVo);

    /**
     * 删除典型操作票
     */
    ResultEntity deleteTypicalOperateTicket(String[] typicalTicketIds);

    /**
     * 查询典型操作票详情
     */
    ResultEntity getTypicalOperateTicketDetail(String typicalTicketId);

    /**
     * 典型操作票列表分页+条件查询
     */
    PageResultEntity getTypicalOperateTicketList(Map<String, String> pageAndCondition);

    /**
     * 查询启用的典型操作票列表
     */
    ResultEntity getEnableTypicalOperateTicketList();

    /**
     * 生成操作票
     */
    ResultEntity createOperateTicket(TypicalOperateTicketVo typicalOperateTicketVo);
}
