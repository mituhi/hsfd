package com.qz.zframe.tickets.controller;

import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.tickets.service.OperateTicketService;
import com.qz.zframe.tickets.vo.OperateTicketVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/tickets/operateTicket")
@Api(tags = { "api-tickets-operateTicket" }, description = "两票--操作票")
public class OperateTicketController {

    @Autowired
    private OperateTicketService operateTicketService;

    //操作票列表分页+条件查询
    @ApiOperation(value = "操作票列表查询", notes = "操作票列表查询")
    @RequestMapping(value = "getOperateTicketList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public PageResultEntity getOperateTicketList(@RequestParam(defaultValue = "1")@ApiParam(name="pageNum",value="当前页",required=false)String pageNum,
                                                 @RequestParam(defaultValue = "10")@ApiParam(name="pageSize",value="一页记录数",required=false)String pageSize,
                                                 @RequestParam(required = false)@ApiParam(name="ticketTypeId",value="操作票类型id",required=false)String ticketTypeId,
                                                 @RequestParam(required = false)@ApiParam(name="crewId",value="一页记录数",required=false)String crewId,
                                                 @RequestParam(required = false)@ApiParam(name="status",value="状态  1:处理中  2:完成  0:作废",required=false)String status,
                                                 @RequestParam(required = false)@ApiParam(name="operateContent",value="操作内容",required=false)String operateContent,
                                                 @RequestParam(required = false)@ApiParam(name="startTime",value="申请时间",required=false)String startTime,
                                                 @RequestParam(required = false)@ApiParam(name="endTime",value="申请时间",required=false)String endTime) {
        Map<String,String> pageAndCondition = new HashMap();
        pageAndCondition.put("pageNum",pageNum);
        pageAndCondition.put("pageSize",pageSize);
        pageAndCondition.put("ticketTypeId",ticketTypeId);
        pageAndCondition.put("machineSet",crewId);
        pageAndCondition.put("status",status);
        pageAndCondition.put("operateContent",operateContent);
        pageAndCondition.put("applyStartTimr",startTime);
        pageAndCondition.put("applyEndTime",endTime);
        return operateTicketService.getOperateTicketList(pageAndCondition);
    }

    @ApiOperation(value = "新建操作票", notes = "后台生成id,流水号,申请人,操作票号给前端为添加工作票类型做准备")
    @RequestMapping(value = "createOperateTicket", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity createOperateTicket() {
        return operateTicketService.createOperateTicket();
    }

    @ApiOperation(value = "添加操作票", notes = "添加操作票")
    @RequestMapping(value = "addOperateTicket", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity addOperateTicket(@RequestBody OperateTicketVo operateTicketVo) {
        return operateTicketService.addOperateTicket(operateTicketVo);
    }

    @ApiOperation(value = "删除操作票", notes = "删除操作票")
    @RequestMapping(value = "deleteOperateTicket", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity deleteOperateTicket(@RequestParam(required = true)@ApiParam(name="ticketIds",value="操作票ids字符串,以逗号分隔",required=true) String ticketIds) {
        return operateTicketService.deleteOperateTicket(ticketIds);
    }

    @ApiOperation(value = "编辑操作票", notes = "编辑操作票")
    @RequestMapping(value = "updateOperateTicket", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity updateOperateTicket(@RequestBody OperateTicketVo operateTicketVo) {
        return operateTicketService.updateOperateTicket(operateTicketVo);
    }

    @ApiOperation(value = "操作票详情查询", notes = "操作票详情查询")
    @RequestMapping(value = "getOperateTicketDetail", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity getOperateTicketDetail(@RequestParam(required = true)@ApiParam(name="ticketId",value="操作票id",required=true) String ticketId) {
        return operateTicketService.getOperateTicketDetail(ticketId);
    }

    @ApiOperation(value = "操作票统计", notes = "操作票统计")
    @RequestMapping(value = "getOperateTicketStatistics", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity getOperateTicketStatistics(@RequestParam(required = false)@ApiParam(name="startDate",value="申请日期",required=false)String startDate,
                                                   @RequestParam(required = false)@ApiParam(name="endDate",value="申请日期",required=false)String endDate) {
        return operateTicketService.getOperateTicketStatistics(startDate,endDate);
    }
}
