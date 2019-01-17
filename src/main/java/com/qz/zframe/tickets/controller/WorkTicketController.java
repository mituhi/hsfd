package com.qz.zframe.tickets.controller;

import com.qz.zframe.authentication.CurrentUserService;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.tickets.vo.WorkTicketVo;
import com.qz.zframe.tickets.service.WorkTicketService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/api/tickets/workTicket")
@Api(tags = { "api-tickets-workTicket" }, description = "两票--工作票")
public class WorkTicketController {

    private static Logger logger = LoggerFactory.getLogger(WorkTicketController.class);

    @Autowired
    private WorkTicketService workTicketService;

    @ApiOperation(value = "工作票--添加", notes = "工作票--添加")
    @RequestMapping(value = "addWorkTicket", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity addWorkTicket(@RequestBody WorkTicketVo workTicketVo) {
        logger.info("===== 工作票--添加 =====");
        ResultEntity resultEntity = new ResultEntity();

        try {
            resultEntity = workTicketService.addWorkTicket(workTicketVo);
        } catch (ParseException e) {
            e.printStackTrace();
            resultEntity.setMsg("系统出错");
        }
        return resultEntity;
    }

    @ApiOperation(value = "工作票--编辑", notes = "工作票--编辑")
    @RequestMapping(value = "updateWorkTicket", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity updateWorkTicket(@RequestBody WorkTicketVo workTicketVo) {
        logger.info("===== 工作票--编辑 =====");
        return workTicketService.updateWorkTicket(workTicketVo);
    }

    @ApiOperation(value = "工作票--提交", notes = "工作票--提交")
    @RequestMapping(value = "submitWorkTicket", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity submitWorkTicket(@RequestBody WorkTicketVo workTicketVo) {
        logger.info("===== 工作票--提交 =====");
        ResultEntity resultEntity = new ResultEntity();
        try {
            resultEntity = workTicketService.submitWorkTicket(workTicketVo);
        }catch (Exception e) {
            e.printStackTrace();
            resultEntity.setMsg("系统出错");
        }
        return resultEntity;
    }

    @ApiOperation(value = "工作票--删除", notes = "工作票--删除")
    @RequestMapping(value = "deleteWorkTicket", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity deleteWorkTicket(@RequestParam(required = false)@ApiParam(name="ticketIds",value="工作票ids数组",required=false) String[] ticketIds) {
        logger.info("===== 工作票--删除 =====");
        return workTicketService.deleteWorkTicket(ticketIds);
    }

    @ApiOperation(value = "工作票--详情查询", notes = "工作票--详情查询")
    @RequestMapping(value = "getWorkTicketDetail", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity getWorkTicketDetail(@RequestParam(required = false)@ApiParam(name="ticketId",value="工作票id",required=true) String ticketId) {
        logger.info("===== 工作票--详情查询 =====");
        return workTicketService.getWorkTicketDetail(ticketId);
    }

    @ApiOperation(value = "工作票--工作票打印", notes = "工作票--工作票打印")
    @RequestMapping(value = "printWorkTicket", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity printWorkTicket(@RequestParam(required = false)@ApiParam(name="ticketId",value="工作票id",required=true) String ticketId) {
        logger.info("===== 工作票--工作票打印 =====");
        return workTicketService.printWorkTicket(ticketId);
    }

    //工作票列表分页+条件查询
    @ApiOperation(value = "工作票--列表查询", notes = "工作票--列表查询")
    @RequestMapping(value = "getWorkTicketList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public PageResultEntity getWorkTicketList(@RequestParam(defaultValue = "1")@ApiParam(name="pageNum",value="当前页",required=false)String pageNum,
                          @RequestParam(defaultValue = "10")@ApiParam(name="pageSize",value="一页记录数",required=false)String pageSize,
                          @RequestParam(required = false)@ApiParam(name="workTicketTypeId",value="工作票类型id",required=false)String workTicketTypeId,
                          @RequestParam(required = false)@ApiParam(name="startWindId",value="风电场code",required=false)String startWindId,
                          @RequestParam(required = false)@ApiParam(name="endWindId",value="风电场code",required=false)String endWindId,
                          @RequestParam(required = false)@ApiParam(name="status",value="状态 01:处理中  02:完成 03未提交 04:审批未通过",required=false)String status,
                          @RequestParam(required = false)@ApiParam(name="approveUser",value="审批人",required=false)String approveUser,
                          @RequestParam(required = false)@ApiParam(name="crewId",value="机组",required=false)String crewId,
                          @RequestParam(required = false)@ApiParam(name="workContent",value="工作内容",required=false)String workContent,
                          @RequestParam(required = false)@ApiParam(name="startTime",value="申请时间",required=false)String startTime,
                          @RequestParam(required = false)@ApiParam(name="endTime",value="申请时间",required=false)String endTime) {
        logger.info("===== 工作票--列表查询 =====");
        PageResultEntity pageResultEntity = new PageResultEntity();

        Map<String,String> pageAndCondition = new HashMap();
        pageAndCondition.put("pageNum",pageNum);
        pageAndCondition.put("pageSize",pageSize);
        pageAndCondition.put("workTicketTypeId",workTicketTypeId);
        pageAndCondition.put("startWindId",startWindId);
        pageAndCondition.put("endWindId",endWindId);
        pageAndCondition.put("status",status);
        pageAndCondition.put("approveUser",approveUser);
        pageAndCondition.put("machineSet",crewId);
        pageAndCondition.put("workContent",workContent);
        //pageAndCondition.put("flowStatus",flowStatus);
        pageAndCondition.put("startTime",startTime);
        pageAndCondition.put("crewId",crewId);
        try {
            pageResultEntity = workTicketService.getWorkTicketList(pageAndCondition);
        } catch (Exception e) {
            e.printStackTrace();
            pageResultEntity.setMsg("系统出错");
        }
        return pageResultEntity;
    }

    //查询处理中的工作票
    @ApiOperation(value = "工单关联工作票--列表查询", notes = "工单关联工作票--列表查询")
    @RequestMapping(value = "getWorkTicketListForWorkorder", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public PageResultEntity getWorkTicketListForWorkorder(@RequestParam(defaultValue = "1")@ApiParam(name="pageNum",value="当前页",required=false)String pageNum,
                          @RequestParam(defaultValue = "10")@ApiParam(name="pageSize",value="一页记录数",required=false)String pageSize,
                          @RequestParam(required = false)@ApiParam(name="workTicketTypeId",value="工作票类型id",required=false)String workTicketTypeId,
                          @RequestParam(required = false)@ApiParam(name="startWindId",value="风电场id1",required=false)String startWindId,
                          @RequestParam(required = false)@ApiParam(name="endWindId",value="风电场id2",required=false)String endWindId,
                          @RequestParam(required = false)@ApiParam(name="crewId",value="机组",required=false)String crewId,
                          @RequestParam(required = false)@ApiParam(name="workContent",value="工作内容",required=false)String workContent,
                          @RequestParam(required = false)@ApiParam(name="startTime",value="申请时间",required=false)String startTime,
                          @RequestParam(required = false)@ApiParam(name="endTime",value="申请时间",required=false)String endTime) {
        logger.info("===== 工单关联工作票--列表查询 =====");
        PageResultEntity pageResultEntity = new PageResultEntity();

        Map<String,String> pageAndCondition = new HashMap();
        pageAndCondition.put("pageNum",pageNum);
        pageAndCondition.put("pageSize",pageSize);
        pageAndCondition.put("workTicketTypeId",workTicketTypeId);
        pageAndCondition.put("startWindId",startWindId);
        pageAndCondition.put("endWindId",endWindId);
        pageAndCondition.put("machineSet",crewId);
        pageAndCondition.put("workContent",workContent);
        pageAndCondition.put("startTime",startTime);
        pageAndCondition.put("crewId",crewId);
        try {
            pageResultEntity = workTicketService.getWorkTicketListForWorkorder(pageAndCondition);
        } catch (Exception e) {
            e.printStackTrace();
            pageResultEntity.setMsg("系统出错");
        }
        return pageResultEntity;
    }

    @ApiOperation(value = "工单关联工作票--删除", notes = "工单关联工作票--删除")
    @RequestMapping(value = "removeWorkTicketForWorkorder", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity removeWorkTicketForWorkorder(String ticketId) {
        logger.info("===== 工单关联工作票--删除 =====");
        return workTicketService.removeWorkTicketForWorkorder(ticketId);
    }


    @ApiOperation(value = "工作票--统计", notes = "工作票--统计")
    @RequestMapping(value = "getWorkTicketStatistics", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity getWorkTicketStatistics(@RequestParam(required = false)@ApiParam(name="startDate",value="申请日期",required=false)String startDate,
                                                @RequestParam(required = false)@ApiParam(name="endDate",value="申请日期",required=false)String endDate,
                                                @RequestParam(required = false)@ApiParam(name="startWindCode",value="风电场code",required=false)String startWindCode,
                                                @RequestParam(required = false)@ApiParam(name="endWindCode",value="风电场code",required=false)String endWindCode) {
        logger.info("===== 工作票--统计 =====");
        return workTicketService.getWorkTicketStatistics(startDate,endDate,startWindCode,endWindCode);
    }

    @ApiOperation(value = "工作票--统计导出", notes = "工作票--统计导出")
    @RequestMapping(value = "exportToExcel", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void exportToExcel(@RequestParam(required = false)@ApiParam(name="startDate",value="申请日期",required=false)String startDate,
                              @RequestParam(required = false)@ApiParam(name="endDate",value="申请日期",required=false)String endDate,
                              @RequestParam(required = false)@ApiParam(name="startWindCode",value="风电场code",required=false)String startWindCode,
                              @RequestParam(required = false)@ApiParam(name="endWindCode",value="风电场code",required=false)String endWindCode,
                              HttpServletResponse response) {
        logger.info("===== 工作票--统计导出 =====");
        workTicketService.exportToExcel(startDate,endDate,startWindCode,endWindCode,response);
    }

    @ApiOperation(value = "工作票--同意", notes = "工作票--同意")
    @RequestMapping(value = "agreeWorkTicket", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity agreeWorkTicket(@RequestBody WorkTicketVo workTicketVo) {
        logger.info("===== 工作票--同意 =====");
        return workTicketService.agreeWorkTicket(workTicketVo);
    }

    @ApiOperation(value = "工作票--退回", notes = "工作票--退回")
    @RequestMapping(value = "backWorkTicket", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity backWorkTicket(@RequestBody WorkTicketVo workTicketVo) {
        logger.info("===== 工作票--退回 =====");
        return workTicketService.backWorkTicket(workTicketVo);
    }

    @ApiOperation(value = "流程状态--列表查询", notes = "流程状态--列表查询")
    @RequestMapping(value = "getFlowStatusList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity getFlowStatusList(@RequestParam(required = false)@ApiParam(name="ticketId",value="工作票id",required=true) String ticketId) {
        logger.info("===== 流程状态--列表查询 =====");
        return workTicketService.getFlowStatusList(ticketId);
    }

    @ApiOperation(value = "工作票--生成标准工作票", notes = "工作票--生成标准工作票")
    @RequestMapping(value = "createStandardWorkTicket", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity createStandardWorkTicket(@RequestBody WorkTicketVo workTicketVo) {
        logger.info("===== 工作票--生成标准工作票 =====");
        ResultEntity resultEntity = new ResultEntity();

        try {
            resultEntity = workTicketService.createStandardWorkTicket(workTicketVo);
        } catch (ParseException e) {
            e.printStackTrace();
            resultEntity.setMsg("系统出错");
        }
        return resultEntity;
    }
}
