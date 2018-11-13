package com.qz.zframe.tickets.service;

import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.tickets.entity.StandardWorkTicket;
import com.qz.zframe.tickets.vo.StandardWorkTicketVo;

import java.util.Map;

public interface StandardWorkTicketService {

    /**
     * 添加标准工作票
     */
    public ResultEntity addStandardWorkTicket(StandardWorkTicketVo standardWorkTicketVo);

    /**
     * 删除标准工作票
     */
    public ResultEntity deleteStandardWorkTicket(String standardTicketId);

    /**
     * 修改标准工作票
     */
    public ResultEntity updateStandardWorkTicket(StandardWorkTicketVo standardWorkTicketVo);

    /**
     * 标准工作票详情查询
     */
    public ResultEntity getStandardWorkTicketDetail(String standardTicketId);

    /**
     * 标准工作票列表查询
     */
    public PageResultEntity getStandardWorkTicketList(Map<String,String> pageAndCondition);
}
