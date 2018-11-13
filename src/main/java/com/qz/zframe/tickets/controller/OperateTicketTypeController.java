package com.qz.zframe.tickets.controller;

import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.tickets.service.OperateTicketTypeService;
import com.qz.zframe.tickets.vo.OperateTicketTypeVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/tickets/operateTicketType")
@Api(tags = { "api-tickets-operateTicketType" }, description = "两票--操作票类型")
public class OperateTicketTypeController {

    @Autowired
    private OperateTicketTypeService operateTicketTypeService;

    @ApiOperation(value = "添加操作票类型", notes = "添加操作票类型")
    @RequestMapping(value = "addOperateTicketType", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity addOperateTicketType(@RequestBody OperateTicketTypeVo operateTicketTypeVo) {
        return operateTicketTypeService.addOperateTicketType(operateTicketTypeVo);
    }

    @ApiOperation(value = "删除操作票类型", notes = "删除操作票类型")
    @RequestMapping(value = "deleteOperateTicketType", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity deleteOperateTicketType(@RequestParam(required = true)@ApiParam(name="ticketTypeIds",value="操作票类型ids字符串,逗号分隔",required=true) String ticketTypeIds) {
        return operateTicketTypeService.deleteOperateTicketType(ticketTypeIds);
    }

    @ApiOperation(value = "修改操作票类型", notes = "修改操作票类型")
    @RequestMapping(value = "updateOperateTicketType", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity updateOperateTicketType(@RequestBody OperateTicketTypeVo operateTicketTypeVo) {
        return operateTicketTypeService.updateOperateTicketType(operateTicketTypeVo);
    }

    @ApiOperation(value = "操作票类型详情查询", notes = "操作票类型详情查询")
    @RequestMapping(value = "getOperateTicketTypeDetail", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity getOperateTicketTypeDetail(@RequestParam(required = true)@ApiParam(name="ticketTypeId",value="操作票类型id",required=true) String ticketTypeId) {
        return operateTicketTypeService.getOperateTicketTypeDetail(ticketTypeId);
    }

    //操作票类型列表查询
    @ApiOperation(value = "操作票类型列表查询", notes = "操作票类型列表查询")
    @RequestMapping(value = "getOperateTicketTypeList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public PageResultEntity getOperateTicketTypeList(@RequestParam(defaultValue = "1")@ApiParam(name="pageNum",value="当前页",required=false)String pageNum,
                                                     @RequestParam(defaultValue = "10")@ApiParam(name="pageSize",value="一页记录数",required=false)String pageSize) {
        Map<String,String> pageAndCondition = new HashMap();
        pageAndCondition.put("pageNum",pageNum);
        pageAndCondition.put("pageSize",pageSize);
        return operateTicketTypeService.getOperateTicketTypeList(pageAndCondition);
    }

}
