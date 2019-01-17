package com.qz.zframe.tickets.service;

import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.tickets.vo.StandardWorkTicketVo;

import java.util.Map;

public interface StandardWorkTicketService {

    /**
     * 添加标准工作票
     */
    ResultEntity addStandardWorkTicket(StandardWorkTicketVo standardWorkTicketVo);

    /**
     * 修改标准工作票
     */
    ResultEntity updateStandardWorkTicket(StandardWorkTicketVo standardWorkTicketVo);

    /**
     * 删除标准工作票
     */
    ResultEntity deleteStandardWorkTicket(String[] standardTicketId);

    /**
     * 标准工作票详情查询
     */
    ResultEntity getStandardWorkTicketDetail(String standardTicketId);

    /**
     * 标准工作票列表查询
     */
    PageResultEntity getStandardWorkTicketList(Map<String,String> pageAndCondition);

    /**
     * 查询启用的标准工作票
     */
    ResultEntity getEnableStandardWorkTicketList();

    /**
     * 生成工作票
     */
    ResultEntity createWorkTicket(StandardWorkTicketVo standardWorkTicketVo);
}
