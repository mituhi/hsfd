package com.qz.zframe.tickets.service;

import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.tickets.entity.StandardWorkTicket;

public interface StandardWorkTicketService {

    /**
     * 标准工作票列表查询
     */
    public ResultEntity getStandardWorkTicketList();

    /**
     * 新建标准这个票
     */
    public ResultEntity createStandardWorkTicket();

    /**
     * 添加标准工作票
     */
    public ResultEntity addStandardWorkTicket(StandardWorkTicket standardWorkTicket);

    /**
     * 删除标准工作票
     */
    public ResultEntity deleteStandardWorkTicket(String standardTicketId);

    /**
     * 修改标准工作票
     */
    public ResultEntity updateStandardWorkTicket(StandardWorkTicket standardWorkTickets);

    /**
     * 标准工作票详情查询
     */
    public ResultEntity getStandardWorkTicketDetail(String standardTicketId);
}
