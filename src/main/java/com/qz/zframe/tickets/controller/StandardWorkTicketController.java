package com.qz.zframe.tickets.controller;

import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.tickets.entity.StandardWorkTicket;
import com.qz.zframe.tickets.service.StandardWorkTicketService;
import com.qz.zframe.tickets.vo.StandardWorkTicketVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/tickets/standardWorkTicket")
@Api(tags = { "api-tickets-standardWorkTicket" }, description = "两票--标准工作票")
public class StandardWorkTicketController {

    @Autowired
    private StandardWorkTicketService standardWorkTicketService;

    @ApiOperation(value = "添加标准工作票", notes = "添加标准工作票")
    @RequestMapping(value = "addStandardWorkTicket", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity addStandardWorkTicket(@RequestBody StandardWorkTicketVo standardWorkTicketVo) {
        return standardWorkTicketService.addStandardWorkTicket(standardWorkTicketVo);
    }

    @ApiOperation(value = "删除标准工作票", notes = "删除标准工作票")
    @RequestMapping(value = "deleteStandardWorkTicket", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity deleteStandardWorkTicket(@RequestParam(required = true)@ApiParam(name="standardTicketIds",value="标准工作票ids字符串,逗号分隔",required=true) String standardTicketIds) {
        return standardWorkTicketService.deleteStandardWorkTicket(standardTicketIds);
    }

    @ApiOperation(value = "修改标准工作票", notes = "修改标准工作票")
    @RequestMapping(value = "updateStandardWorkTicket", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity updateStandardWorkTicket(@RequestBody StandardWorkTicketVo standardWorkTicketVo) {
        return standardWorkTicketService.updateStandardWorkTicket(standardWorkTicketVo);
    }

    @ApiOperation(value = "标准工作票详情查询", notes = "标准工作票详情查询")
    @RequestMapping(value = "getStandardWorkTicketDetail", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity getStandardWorkTicketDetail(@RequestParam(required = true)@ApiParam(name="standardTicketId",value="标准工作票id",required=true) String standardTicketId) {
        return standardWorkTicketService.getStandardWorkTicketDetail(standardTicketId);
    }

    @ApiOperation(value = "标准工作票列表查询", notes = "标准工作票列表查询")
    @RequestMapping(value = "getStandardWorkTicketList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public PageResultEntity getStandardWorkTicketList(@RequestParam(defaultValue = "1")@ApiParam(name="pageNum",value="当前页",required=false)String pageNum,
                                                      @RequestParam(defaultValue = "10")@ApiParam(name="pageSize",value="一页记录数",required=false)String pageSize,
                                                      @RequestParam(required = false)@ApiParam(name="ticketTypeId",value="工作票类型id",required=false)String ticketTypeId,
                                                      @RequestParam(required =false)@ApiParam(name="windId",value="风电场id",required=false)String windId,
                                                      @RequestParam(required = false)@ApiParam(name="status",value="状态",required=false)String status,
                                                      @RequestParam(required = false)@ApiParam(name="workTeam",value="工作班组",required=false)String workTeam,
                                                      @RequestParam(required = false)@ApiParam(name="workContent",value="工作内容",required=false)String workContent) {
        Map<String,String> pageAndCondition = new HashMap();
        pageAndCondition.put("pageNum",pageNum);
        pageAndCondition.put("pageSize",pageSize);
        pageAndCondition.put("ticketTypeId",ticketTypeId);
        pageAndCondition.put("windId",windId);
        pageAndCondition.put("pageSize",pageSize);
        pageAndCondition.put("status",status);
        pageAndCondition.put("workContent",workContent);
        return standardWorkTicketService.getStandardWorkTicketList(pageAndCondition);
    }
}
