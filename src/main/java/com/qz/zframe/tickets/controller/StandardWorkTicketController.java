package com.qz.zframe.tickets.controller;

import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.tickets.entity.StandardWorkTicket;
import com.qz.zframe.tickets.service.StandardWorkTicketService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tickets/standardWorkTicket")
@Api(tags = { "api-tickets-standardWorkTicket" }, description = "两票--标准工作票")
public class StandardWorkTicketController {

    @Autowired
    private StandardWorkTicketService standardWorkTicketService;

    @ApiOperation(value = "标准工作票列表查询", notes = "标准工作票列表查询")
    @RequestMapping(value = "getStandardWorkTicketList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity getStandardWorkTicketList() {
        return standardWorkTicketService.getStandardWorkTicketList();
    }

    @ApiOperation(value = "新建标准工作票", notes = "后台生成id,流水号,维护人,维护时间给前端为添加工作票类型做准备")
    @RequestMapping(value = "createStandardWorkTicket", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity createStandardWorkTicket() {
        return standardWorkTicketService.createStandardWorkTicket();
    }

    @ApiOperation(value = "添加标准工作票", notes = "添加标准工作票")
    @RequestMapping(value = "addStandardWorkTicket", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity addStandardWorkTicket(@RequestBody StandardWorkTicket standardWorkTicket) {
        return standardWorkTicketService.addStandardWorkTicket(standardWorkTicket);
    }

    @ApiOperation(value = "删除标准工作票", notes = "删除标准工作票")
    @RequestMapping(value = "deleteStandardWorkTicket", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity deleteStandardWorkTicket(@RequestParam(required = true)@ApiParam(name="standardTicketIds",value="标准工作票ids字符串,逗号分隔",required=true) String standardTicketIds) {
        return standardWorkTicketService.deleteStandardWorkTicket(standardTicketIds);
    }

    @ApiOperation(value = "修改标准工作票", notes = "修改标准工作票")
    @RequestMapping(value = "updateStandardWorkTicket", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity updateStandardWorkTicket(@RequestBody StandardWorkTicket standardWorkTicket) {
        return standardWorkTicketService.updateStandardWorkTicket(standardWorkTicket);
    }

    @ApiOperation(value = "标准工作票详情查询", notes = "标准工作票详情查询")
    @RequestMapping(value = "getStandardWorkTicketDetail", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity getStandardWorkTicketDetail(@RequestParam(required = true)@ApiParam(name="standardTicketId",value="标准工作票id",required=true) String standardTicketId) {
        return standardWorkTicketService.getStandardWorkTicketDetail(standardTicketId);
    }
}
