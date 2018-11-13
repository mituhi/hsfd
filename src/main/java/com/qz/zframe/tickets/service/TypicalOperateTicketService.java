package com.qz.zframe.tickets.service;

import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.tickets.vo.TypicalOperateTicketVo;
import com.qz.zframe.tickets.vo.WorkTicketTypeVo;

import java.util.Map;

public interface TypicalOperateTicketService {

    /**
     * 添加典型操作票
     */
    public ResultEntity addTypicalOperateTicket(TypicalOperateTicketVo typicalOperateTicketVo);

    /**
     * 删除典型操作票
     */
    public ResultEntity deleteTypicalOperateTicket(String typicalTicketIds);

    /**
     * 修改典型操作票
     */
    public ResultEntity updateTypicalOperateTicket(TypicalOperateTicketVo typicalOperateTicketVo);

    /**
     * 查询典型操作票详情
     */
    public ResultEntity getTypicalOperateTicketDetail(String typicalTicketId);

    /**
     * 典型操作票列表分页+条件查询
     */
    public PageResultEntity getTypicalOperateTicketList(Map<String, String> pageAndCondition);
}
