package com.qz.zframe.tickets.service;

import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.tickets.vo.OperateTicketVo;

import java.util.Map;

public interface OperateTicketService {

    /**
     * 分页查询操作票列表
     * @return
     */
    public PageResultEntity getOperateTicketList(Map<String, String> pageAndCondition);

    /**
     * 新建操作票
     */
    public ResultEntity createOperateTicket();

    /**
     * 添加操作票
     */
    public ResultEntity addOperateTicket(OperateTicketVo operateTicketVo);

    /**
     * 删除操作票
     */
    public ResultEntity deleteOperateTicket(String ticketIds);

    /**
     * 修改操作票
     */
    public ResultEntity updateOperateTicket(OperateTicketVo operateTicketVo);

    /**
     * 查询操作票详情
     */
    public ResultEntity getOperateTicketDetail(String ticketId);

    /**
     * 操作票统计
     */
    public ResultEntity getOperateTicketStatistics(String startDate,String endDate);
}
