package com.qz.zframe.tickets.service;

import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.tickets.entity.WorkTicket;
import com.qz.zframe.tickets.vo.WorkTicketVo;

import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

public interface WorkTicketService {

    /**
     * 添加工作票
     */
    ResultEntity addWorkTicket(WorkTicketVo workTicketVo) throws ParseException;

    /**
     * 修改工作票
     */
    ResultEntity updateWorkTicket(WorkTicketVo workTicketVo);

    /**
     * 提交工作票
     */
    ResultEntity submitWorkTicket(WorkTicketVo workTicketVo) throws Exception;

    /**
     * 删除工作票
     */
    ResultEntity deleteWorkTicket(String[] ticketIds);

    /**
     * 查询工作票详情
     */
    ResultEntity getWorkTicketDetail(String ticketId);

    /**
     * 工作票打印
     */
    ResultEntity printWorkTicket(String ticketId);

    /**
     * 工作票列表分页+条件查询
     */
    PageResultEntity getWorkTicketList(Map<String, String> pageAndCondition) throws Exception;

    /**
     * 查询工单所需的工作票查询(处理中的工作票)
     */
    PageResultEntity getWorkTicketListForWorkorder(Map<String, String> pageAndCondition) throws Exception;

    /**
     * 解除工作票和工单的联系
     */
    ResultEntity removeWorkTicketForWorkorder(String ticketId);

    /**
     * 工作票统计
     */
    ResultEntity getWorkTicketStatistics(String startDate,String endDate,String startWindCode,String endWindCode);

    /**
     * 工作票统计导出
     */
    void exportToExcel(String startDate, String endDate, String startWindCode,String endWindCode, HttpServletResponse response);

    /**
     * 审批-同意
     */
    ResultEntity agreeWorkTicket(WorkTicketVo workTicketVo);

    /**
     * 审批-退回
     */
    ResultEntity backWorkTicket(WorkTicketVo workTicketVo);

    /**
     * 流程状态列表查询
     */
    ResultEntity getFlowStatusList(String ticketId);

    /**
     * 生成标准工作票
     */
    ResultEntity createStandardWorkTicket(WorkTicketVo workTicketVo) throws ParseException;

    List<String> findRoleByUserName(String userName);

    List<String> findFlowStatusQf();

}
