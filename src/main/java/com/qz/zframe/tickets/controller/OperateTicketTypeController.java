package com.qz.zframe.tickets.controller;

import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.tickets.entity.OperateTicketType;
import com.qz.zframe.tickets.service.OperateTicketTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tickets/operateTicketType")
@Api(tags = { "api-tickets-operateTicketType" }, description = "两票--操作票类型")
public class OperateTicketTypeController {

    @Autowired
    private OperateTicketTypeService operateTicketTypeService;

    //操作票类型列表查询
    @ApiOperation(value = "操作票类型列表查询", notes = "操作票类型列表查询")
    @RequestMapping(value = "getOperateTicketTypeList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity getOperateTicketTypeList() {
        return operateTicketTypeService.getOperateTicketTypeList();
    }

    @ApiOperation(value = "新建操作票类型", notes = "后台生成id,流水号,维护人,维护日期给前端为添加操作票类型做准备")
    @RequestMapping(value = "createOperateTicketType", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity createOperateTicketType() {
        return operateTicketTypeService.createOperateTicketType();
    }

    @ApiOperation(value = "添加操作票类型", notes = "添加操作票类型")
    @RequestMapping(value = "addOperateTicketType", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity addOperateTicketType(@RequestBody OperateTicketType operateTicketType) {
        return operateTicketTypeService.addOperateTicketType(operateTicketType);
    }

    @ApiOperation(value = "删除操作票类型", notes = "删除操作票类型")
    @RequestMapping(value = "deleteOperateTicketType", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity deleteOperateTicketType(@RequestParam(required = true)@ApiParam(name="ticketTypeIds",value="操作票类型ids字符串,逗号分隔",required=true) String ticketTypeIds) {
        return operateTicketTypeService.deleteOperateTicketType(ticketTypeIds);
    }

    @ApiOperation(value = "修改操作票类型", notes = "修改操作票类型")
    @RequestMapping(value = "updateOperateTicketType", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity updateOperateTicketType(@RequestBody OperateTicketType operateTicketType) {
        return operateTicketTypeService.updateOperateTicketType(operateTicketType);
    }

    @ApiOperation(value = "操作票类型详情查询", notes = "操作票类型详情查询")
    @RequestMapping(value = "selectOperateTicketType", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity selectOperateTicketType(@RequestParam(required = true)@ApiParam(name="ticketTypeId",value="操作票类型id",required=true) String ticketTypeId) {
        return operateTicketTypeService.selectOperateTicketType(ticketTypeId);
    }
}
