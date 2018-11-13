package com.qz.zframe.tickets.controller;

import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.tickets.entity.StandardWorkTicket;
import com.qz.zframe.tickets.service.StandardWorkTicketService;
import com.qz.zframe.tickets.service.WorkTicketTypeService;
import com.qz.zframe.tickets.vo.WorkTicketTypeVo;
import com.qz.zframe.tickets.vo.WorkTicketVo;
import com.qz.zframe.tickets.service.WorkTicketService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/tickets/workTicket")
@Api(tags = { "api-tickets-workTicket" }, description = "两票--工作票")
public class WorkTicketController {

    @Autowired
    private WorkTicketService workTicketService;

    @ApiOperation(value = "添加工作票", notes = "添加工作票")
    @RequestMapping(value = "addWorkTicket", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity addWorkTicket(@RequestBody WorkTicketVo workTicketVo) {
        return workTicketService.addWorkTicket(workTicketVo);
    }

    @ApiOperation(value = "删除工作票", notes = "删除工作票")
    @RequestMapping(value = "deleteWorkTicket", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity deleteWorkTicket(@RequestParam(required = false)@ApiParam(name="ticketIds",value="工作票ids字符串,逗号分隔",required=false) String ticketIds) {
        return workTicketService.deleteWorkTicket(ticketIds);
    }

    @ApiOperation(value = "编辑工作票", notes = "编辑工作票")
    @RequestMapping(value = "updateWorkTicket", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity updateWorkTicket(@RequestBody WorkTicketVo workTicketVo) {
        return workTicketService.updateWorkTicket(workTicketVo);
    }

    @ApiOperation(value = "工作票详情查询", notes = "工作票详情查询")
    @RequestMapping(value = "getWorkTicketDetail", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity getWorkTicketDetail(@RequestParam(required = false)@ApiParam(name="ticketId",value="工作票id",required=true) String ticketId) {
        return workTicketService.getWorkTicketDetail(ticketId);
    }

    //工作票列表分页+条件查询
    @ApiOperation(value = "工作票列表查询", notes = "工作票列表查询")
    @RequestMapping(value = "getWorkTicketList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public PageResultEntity getWorkTicketList(@RequestParam(defaultValue = "1")@ApiParam(name="pageNum",value="当前页",required=false)String pageNum,
                          @RequestParam(defaultValue = "10")@ApiParam(name="pageSize",value="一页记录数",required=false)String pageSize,
                          @RequestParam(required = false)@ApiParam(name="workTicketTypeId",value="工作票类型id",required=false)String workTicketTypeId,
                          @RequestParam(required = false)@ApiParam(name="windId",value="风电场id",required=false)String windId,
                          @RequestParam(required = false)@ApiParam(name="status",value="状态 1:处理中  2:完成  0:作废",required=false)String status,
                          @RequestParam(required = false)@ApiParam(name="crew_id",value="机组",required=false)String crewId,
                          @RequestParam(required = false)@ApiParam(name="workContent",value="工作内容",required=false)String workContent,
                          @RequestParam(required = false)@ApiParam(name="startTime",value="申请时间",required=false)String startTime,
                          @RequestParam(required = false)@ApiParam(name="endTime",value="申请时间",required=false)String endTime) {
        Map<String,String> pageAndCondition = new HashMap();
        pageAndCondition.put("pageNum",pageNum);
        pageAndCondition.put("pageSize",pageSize);
        pageAndCondition.put("workTicketTypeId",workTicketTypeId);
        pageAndCondition.put("windId",windId);
        pageAndCondition.put("status",status);
        pageAndCondition.put("machineSet",crewId);
        pageAndCondition.put("workContent",workContent);
        pageAndCondition.put("startTime",startTime);
        pageAndCondition.put("endTime",endTime);
        return workTicketService.getWorkTicketList(pageAndCondition);
    }

    @ApiOperation(value = "工作票统计", notes = "工作票统计")
    @RequestMapping(value = "getWorkTicketStatistics", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity getWorkTicketStatistics(@RequestParam(required = false)@ApiParam(name="startDate",value="申请日期",required=false)String startDate,
                                                @RequestParam(required = false)@ApiParam(name="startDate",value="申请日期",required=false)String endDate) {
        return workTicketService.getWorkTicketStatistics(startDate,endDate);
    }
}
