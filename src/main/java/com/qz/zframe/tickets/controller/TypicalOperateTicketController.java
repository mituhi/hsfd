package com.qz.zframe.tickets.controller;


import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.tickets.service.TypicalOperateTicketService;
import com.qz.zframe.tickets.vo.TypicalOperateTicketVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/tickets/typicalOperateTicket")
@Api(tags = { "api-tickets-typicalOperateTicket" }, description = "两票--典型操作票")
public class TypicalOperateTicketController {

    @Autowired
    private TypicalOperateTicketService typicalOperateTicketService;

    @ApiOperation(value = "添加典型操作票", notes = "添加典型操作票")
    @RequestMapping(value = "addTypicalOperateTicket", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity addTypicalOperateTicket(@RequestBody TypicalOperateTicketVo typicalOperateTicketVo) {
        return typicalOperateTicketService.addTypicalOperateTicket(typicalOperateTicketVo);
    }

    @ApiOperation(value = "删除典型操作票", notes = "删除典型操作票")
    @RequestMapping(value = "deleteTypicalOperateTicket", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity deleteTypicalOperateTicket(@RequestParam(required = true)@ApiParam(name="typicalTicketIds",value="典型操作票ids字符串,逗号分隔",required=true) String typicalTicketIds) {
        return typicalOperateTicketService.deleteTypicalOperateTicket(typicalTicketIds);
    }

    @ApiOperation(value = "修改典型操作票", notes = "修改典型操作票")
    @RequestMapping(value = "updateTypicalOperateTicket", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity updateTypicalOperateTicket(@RequestBody TypicalOperateTicketVo typicalOperateTicketVo) {
        return typicalOperateTicketService.updateTypicalOperateTicket(typicalOperateTicketVo);
    }

    @ApiOperation(value = "典型操作票详情查询", notes = "典型操作票详情查询")
    @RequestMapping(value = "getTypicalOperateTicketDetail", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity getTypicalOperateTicketDetail(@RequestParam(required = true)@ApiParam(name="typicalTicketId",value="典型操作票id",required=true) String typicalTicketId) {
        return typicalOperateTicketService.getTypicalOperateTicketDetail(typicalTicketId);
    }

    //典型操作票列表分页+条件查询
    @ApiOperation(value = "典型操作票列表查询", notes = "典型操作票列表查询")
    @RequestMapping(value = "getTypicalOperateTicket", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public PageResultEntity getTypicalOperateTicketList(@RequestParam(defaultValue = "1")@ApiParam(name="pageNum",value="当前页",required=false)String pageNum,
                                                        @RequestParam(defaultValue = "10")@ApiParam(name="pageSize",value="一页记录数",required=false)String pageSize,
                                                        @RequestParam(required = false)@ApiParam(name="operTicketTypeId",value="操作票类型id",required=false)String operTicketTypeId,
                                                        @RequestParam(required = false)@ApiParam(name="windId",value="风电场",required=false)String windId,
                                                        @RequestParam(required = false)@ApiParam(name="status",value="状态",required=false)String status,
                                                        @RequestParam(required = false)@ApiParam(name="operateContent",value="操作内容",required=false)String operateContent) {
        Map<String,String> pageAndCondition = new HashMap<>();
        pageAndCondition.put("pageNum",pageNum);
        pageAndCondition.put("pageSize",pageSize);
        pageAndCondition.put("operTicketTypeId",operTicketTypeId);
        pageAndCondition.put("windId",windId);
        pageAndCondition.put("status",status);
        pageAndCondition.put("operateContent",operateContent);
        return typicalOperateTicketService.getTypicalOperateTicketList(pageAndCondition);
    }

}
