package com.qz.zframe.tickets.controller;

import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.tickets.service.WorkTicketTypeService;
import com.qz.zframe.tickets.vo.WorkTicketTypeVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tickets/workTicketType")
@Api(tags = { "api-tickets-workTicketType" }, description = "两票--工作票类型")
public class WorkTicketTypeController {

    @Autowired
    private WorkTicketTypeService workTicketTypeService;

    @ApiOperation(value = "工作票类型列表查询", notes = "工作票类型列表查询")
    @RequestMapping(value = "getWorkTicketTypeList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity getWorkTicketTypeList() {
        return workTicketTypeService.getWorkTicketTypeList();
    }

    @ApiOperation(value = "新建工作票类型", notes = "后台生成id,流水号,维护人,维护日期给前端为添加工作票类型做准备")
    @RequestMapping(value = "createWorkTicketType", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity createWorkTicketType() {
        return workTicketTypeService.createWorkTicketType();
    }

    @ApiOperation(value = "添加工作票类型", notes = "添加工作票类型")
    @RequestMapping(value = "addWorkTicketType", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity addWorkTicketType(@RequestBody WorkTicketTypeVo workTicketTypeVo) {
        return workTicketTypeService.addWorkTicketType(workTicketTypeVo);
    }

    @ApiOperation(value = "删除工作票类型", notes = "删除工作票类型")
    @RequestMapping(value = "deleteWorkTicketType", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity deleteWorkTicketType(@RequestParam(required = true)@ApiParam(name="ticketTypeIds",value="工作票类型ids,逗号分隔",required=true) String ticketTypeIds) {
        return workTicketTypeService.deleteWorkTicketType(ticketTypeIds);
    }

    @ApiOperation(value = "修改工作票类型", notes = "修改工作票类型")
    @RequestMapping(value = "updateWorkTicketType", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity updateWorkTicketType(@RequestBody WorkTicketTypeVo workTicketTypeVo) {
        return workTicketTypeService.updateWorkTicketType(workTicketTypeVo);
    }

    @ApiOperation(value = "工作票类型详情查询", notes = "工作票类型详情查询")
    @RequestMapping(value = "getWorkTicketTypeDetail", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity getWorkTicketTypeDetail(@RequestParam(required = true)@ApiParam(name="ticketTypeId",value="工作票类型id",required=true) String ticketTypeId) {
        return workTicketTypeService.getWorkTicketTypeDetail(ticketTypeId);
    }
}
