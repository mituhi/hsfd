package com.qz.zframe.tickets.service;

import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.tickets.vo.OperateTicketVo;

import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.util.Map;

public interface OperateTicketService {

    /**
     * 添加操作票
     */
    ResultEntity addOperateTicket(OperateTicketVo operateTicketVo) throws ParseException;

    /**
     * 修改操作票
     */
    ResultEntity updateOperateTicket(OperateTicketVo operateTicketVo);

    /**
     * 提交操作票
     */
    ResultEntity submitOperateTicket(OperateTicketVo operateTicketVo) throws Exception;

    /**
     * 删除操作票
     */
    ResultEntity deleteOperateTicket(String[] ticketIds);

    /**
     * 浏览操作票
     */
    ResultEntity getOperateTicketDetail(String ticketId);

    /**
     * 打印操作票
     */
    ResultEntity pringtOperateTicket(String ticketId);

    /**
     * 操作票统计
     */
    ResultEntity getOperateTicketStatistics(String startDate,String endDate,String startWindCode,String endWindCode) throws ParseException;

    /**
     * 操作票统计导出
     */
    void exportToExcel(String startDate, String endDate, String startWindCode,String endWindCode, HttpServletResponse response) throws ParseException;

    /**
     * 分页查询操作票列表
     */
    PageResultEntity getOperateTicketList(Map<String, String> pageAndCondition) throws ParseException;

    /**
     * 查询处理中的操作票
     */
    PageResultEntity getOperateTicketListForWorkorder(Map<String, String> pageAndCondition) throws ParseException;

    /**
     * 修改操作票
     */
    ResultEntity removeOperateTicketForWorkorder(String ticketId);

    /**
     * 进入下一流程节点
     */
    ResultEntity agreeOperateticket(OperateTicketVo operateTicketVo);

    /**
     * 退回上一流程节点
     */
    ResultEntity backOperateTicket(OperateTicketVo operateTicketVo);

    /**
     * 流程状态列表查询
     */
    ResultEntity getFlowStatusList(String ticketId);

    /**
     * 生成典型操作票
     */
    ResultEntity createTypicalOperateTicket(OperateTicketVo operateTicketVo) throws ParseException;
}
