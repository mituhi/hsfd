package com.qz.zframe.tickets.service;

import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.tickets.vo.WorkTicketVo;

import java.util.Map;

public interface WorkTicketService {

    /**
     * 添加工作票
     */
    public ResultEntity addWorkTicket(WorkTicketVo workTicketVo);

    /**
     * 删除工作票
     */
    public ResultEntity deleteWorkTicket(String ticketIds);

    /**
     * 修改工作票
     */
    public ResultEntity updateWorkTicket(WorkTicketVo workTicketVo);

    /**
     * 查询工作票详情
     */
    public ResultEntity getWorkTicketDetail(String ticketId);

    /**
     * 工作票列表分页+条件查询
     * @return
     */
    public PageResultEntity getWorkTicketList(Map<String, String> pageAndCondition);

    /**
     * 工作票统计
     */
    public ResultEntity getWorkTicketStatistics(String startDate,String endDate);
}
