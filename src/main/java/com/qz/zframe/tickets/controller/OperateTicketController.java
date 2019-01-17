package com.qz.zframe.tickets.controller;

import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.tickets.service.OperateTicketService;
import com.qz.zframe.tickets.vo.OperateTicketVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/tickets/operateTicket")
@Api(tags = { "api-tickets-operateTicket" }, description = "两票--操作票")
public class OperateTicketController {

    private static Logger logger = LoggerFactory.getLogger(OperateTicketController.class);

    @Autowired
    private OperateTicketService operateTicketService;

    @ApiOperation(value = "操作票--添加", notes = "操作票--添加")
    @RequestMapping(value = "addOperateTicket", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity addOperateTicket(@RequestBody OperateTicketVo operateTicketVo) {
        logger.info("===== 操作票--添加 =====");
        ResultEntity resultEntity = new ResultEntity();
        try {
            resultEntity = operateTicketService.addOperateTicket(operateTicketVo);
        } catch (ParseException e) {
            e.printStackTrace();
            resultEntity.setMsg("系统出错");
        }
        return resultEntity;
    }

    @ApiOperation(value = "操作票--编辑", notes = "操作票--编辑")
    @RequestMapping(value = "updateOperateTicket", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity updateOperateTicket(@RequestBody OperateTicketVo operateTicketVo) {
        logger.info("===== 操作票--编辑 =====");
        return operateTicketService.updateOperateTicket(operateTicketVo);
    }

    @ApiOperation(value = "操作票--提交", notes = "操作票--提交")
    @RequestMapping(value = "submitOperateTicket", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity submitOperateTicket(@RequestBody OperateTicketVo operateTicketVo) {
        logger.info("===== 操作票--提交 =====");
        ResultEntity resultEntity = new ResultEntity();
        try {
            resultEntity = operateTicketService.submitOperateTicket(operateTicketVo);
        }catch (Exception e) {
            e.printStackTrace();
            resultEntity.setMsg("系统出错");
        }
        return resultEntity;
    }

    @ApiOperation(value = "操作票--删除", notes = "操作票--删除")
    @RequestMapping(value = "deleteOperateTicket", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity deleteOperateTicket(@RequestParam(required = false)@ApiParam(name="ticketIds",value="操作票ids数组",required=true) String[] ticketIds) {
        logger.info("===== 操作票--删除 =====");
        return operateTicketService.deleteOperateTicket(ticketIds);
    }

    @ApiOperation(value = "操作票--详情查询", notes = "操作票--详情查询")
    @RequestMapping(value = "getOperateTicketDetail", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity getOperateTicketDetail(@RequestParam(required = false)@ApiParam(name="ticketId",value="操作票id",required=true) String ticketId) {
        logger.info("===== 操作票--详情查询 =====");
        return operateTicketService.getOperateTicketDetail(ticketId);
    }

    @ApiOperation(value = "操作票--打印详情", notes = "操作票--打印详情")
    @RequestMapping(value = "pringtOperateTicket", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity printOperateTicket(@RequestParam(required = false)@ApiParam(name="ticketId",value="操作票id",required=true) String ticketId) {
        logger.info("===== 操作票--打印详情 =====");
        return operateTicketService.pringtOperateTicket(ticketId);
    }

    //操作票列表分页+条件查询
    @ApiOperation(value = "操作票--列表查询", notes = "操作票--列表查询")
    @RequestMapping(value = "getOperateTicketList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public PageResultEntity getOperateTicketList(@RequestParam(defaultValue = "1")@ApiParam(name="pageNum",value="当前页",required=false)String pageNum,
                                 @RequestParam(defaultValue = "10")@ApiParam(name="pageSize",value="一页记录数",required=false)String pageSize,
                                 @RequestParam(required = false)@ApiParam(name="operTicketTypeId",value="操作票类型id",required=false)String operTicketTypeId,
                                 @RequestParam(required = false)@ApiParam(name="startWindId",value="风电场code",required=false)String startWindId,
                                 @RequestParam(required = false)@ApiParam(name="endWindId",value="风电场code",required=false)String endWindId,
                                 @RequestParam(required = false)@ApiParam(name="status",value="状态  01:处理中  02:完成 03:未提交 04:审批未通过",required=false)String status,
                                 @RequestParam(required = false)@ApiParam(name="flowStatus",value="审核状态  01:待审批  02:完成 03:未通过",required=false)String flowStatus,
                                 @RequestParam(required = false)@ApiParam(name="approveUser",value="审批人",required=false)String approveUser,
                                 @RequestParam(required = false)@ApiParam(name="operateContent",value="操作内容",required=false)String operateContent,
                                 @RequestParam(required = false)@ApiParam(name="startTime",value="申请时间",required=false)String startTime,
                                 @RequestParam(required = false)@ApiParam(name="endTime",value="申请时间",required=false)String endTime) {
        logger.info("===== 操作票--列表查询 =====");
        PageResultEntity pageResultEntity = new PageResultEntity();

        Map<String,String> pageAndCondition = new HashMap();
        pageAndCondition.put("pageNum",pageNum);
        pageAndCondition.put("pageSize",pageSize);
        pageAndCondition.put("operTicketTypeId",operTicketTypeId);
        pageAndCondition.put("startWindId",startWindId);
        pageAndCondition.put("endWindId",endWindId);
        pageAndCondition.put("status",status);
        pageAndCondition.put("flowStatus",flowStatus);
        pageAndCondition.put("approveUser",approveUser);
        pageAndCondition.put("operateContent",operateContent);
        pageAndCondition.put("startTime",startTime);
        pageAndCondition.put("endTime",endTime);
        try {
            pageResultEntity = operateTicketService.getOperateTicketList(pageAndCondition);
        } catch (ParseException e) {
            e.printStackTrace();
            pageResultEntity.setMsg("系统出错");
        }
        return pageResultEntity;
    }

    //查询工单所需的操作票
    @ApiOperation(value = "工单关联操作票--列表查询", notes = "工单关联操作票--列表查询")
    @RequestMapping(value = "getOperateTicketListForWorkorder", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public PageResultEntity getOperateTicketListForWorkorder(@RequestParam(defaultValue = "1")@ApiParam(name="pageNum",value="当前页",required=false)String pageNum,
                                 @RequestParam(defaultValue = "10")@ApiParam(name="pageSize",value="一页记录数",required=false)String pageSize,
                                 @RequestParam(required = false)@ApiParam(name="operTicketTypeId",value="操作票类型id",required=false)String operTicketTypeId,
                                 @RequestParam(required = false)@ApiParam(name="startWindId",value="风电场id",required=false)String startWindId,
                                 @RequestParam(required = false)@ApiParam(name="endWindId",value="风电场id",required=false)String endWindId,
                                 @RequestParam(required = false)@ApiParam(name="operateContent",value="操作内容",required=false)String operateContent,
                                 @RequestParam(required = false)@ApiParam(name="startTime",value="申请时间",required=false)String startTime,
                                 @RequestParam(required = false)@ApiParam(name="endTime",value="申请时间",required=false)String endTime) {
        logger.info("===== 工单关联操作票--列表查询 =====");
        PageResultEntity pageResultEntity = new PageResultEntity();

        Map<String,String> pageAndCondition = new HashMap();
        pageAndCondition.put("pageNum",pageNum);
        pageAndCondition.put("pageSize",pageSize);
        pageAndCondition.put("operTicketTypeId",operTicketTypeId);
        pageAndCondition.put("startWindId",startWindId);
        pageAndCondition.put("endWindId",endWindId);
        pageAndCondition.put("operateContent",operateContent);
        pageAndCondition.put("startTime",startTime);
        pageAndCondition.put("endTime",endTime);
        try {
            pageResultEntity = operateTicketService.getOperateTicketListForWorkorder(pageAndCondition);
        } catch (ParseException e) {
            e.printStackTrace();
            pageResultEntity.setMsg("系统出错");
        }
        return pageResultEntity;
    }

    @ApiOperation(value = "工单关联操作票--删除", notes = "工单关联操作票--删除")
    @RequestMapping(value = "removeOperateTicketForWorkorder", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity removeOperateTicketForWorkorder(String ticketId) {
        logger.info("===== 工单关联操作票--删除 =====");
        return operateTicketService.removeOperateTicketForWorkorder(ticketId);
    }

    @ApiOperation(value = "操作票--统计", notes = "操作票--统计")
    @RequestMapping(value = "getOperateTicketStatistics", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity getOperateTicketStatistics(@RequestParam(required = false)@ApiParam(name="startDate",value="申请日期",required=false)String startDate,
                                                   @RequestParam(required = false)@ApiParam(name="endDate",value="申请日期",required=false)String endDate,
                                                   @RequestParam(required = false)@ApiParam(name="startWindCode",value="风电场code",required=false)String startWindCode,
                                                   @RequestParam(required = false)@ApiParam(name="endWindCode",value="风电场code",required=false)String endWindCode) {
        logger.info("===== 操作票--统计 =====");
        ResultEntity resultEntity = new ResultEntity();

        try {
            resultEntity = operateTicketService.getOperateTicketStatistics(startDate, endDate, startWindCode, endWindCode);
        } catch (ParseException e) {
            e.printStackTrace();
            resultEntity.setMsg("系统出错");
        }
        return resultEntity;
    }

    @ApiOperation(value = "操作票--统计导出", notes = "操作票--统计导出")
    @RequestMapping(value = "exportToExcel", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void exportToExcel(@RequestParam(required = false)@ApiParam(name="startDate",value="申请日期",required=false)String startDate,
                              @RequestParam(required = false)@ApiParam(name="endDate",value="申请日期",required=false)String endDate,
                              @RequestParam(required = false)@ApiParam(name="startWindCode",value="风电场code",required=false)String startWindCode,
                              @RequestParam(required = false)@ApiParam(name="endWindCode",value="风电场code",required=false)String endWindCode,
                              HttpServletResponse response) {
        logger.info("===== 操作票--统计导出 =====");
        try {
            operateTicketService.exportToExcel(startDate,endDate,startWindCode,endWindCode,response);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @ApiOperation(value = "操作票--同意", notes = "操作票--同意")
    @RequestMapping(value = "agreeOperateticket", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity agreeOperateticket(@RequestBody OperateTicketVo operateTicketVo) {
        logger.info("===== 操作票--同意 =====");
        return operateTicketService.agreeOperateticket(operateTicketVo);
    }

    @ApiOperation(value = "操作票--退回", notes = "操作票--退回")
    @RequestMapping(value = "backOperateTicket", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity backOperateTicket(@RequestBody OperateTicketVo operateTicketVo) {
        logger.info("===== 操作票--退回 =====");
        return operateTicketService.backOperateTicket(operateTicketVo);
    }

    @ApiOperation(value = "流程状态--列表查询", notes = "流程状态--列表查询")
    @RequestMapping(value = "getFlowStatusList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity getFlowStatusList(@RequestParam(required = false)@ApiParam(name="ticketId",value="操作票id",required=true) String ticketId) {
        logger.info("===== 流程状态--列表查询 =====");
        return operateTicketService.getFlowStatusList(ticketId);
    }

    @ApiOperation(value = "操作票--生成典型操作票", notes = "操作票--生成典型操作票")
    @RequestMapping(value = "createTypicalOperateTicket", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity createTypicalOperateTicket(@RequestBody OperateTicketVo operateTicketVo) {
        logger.info("===== 操作票--生成典型操作票 =====");
        ResultEntity resultEntity = new ResultEntity();

        try {
            resultEntity = operateTicketService.createTypicalOperateTicket(operateTicketVo);
        } catch (ParseException e) {
            e.printStackTrace();
            resultEntity.setMsg("系统出错");
        }
        return resultEntity;
    }
}
