package com.qz.zframe.tickets.controller;

import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.tickets.service.StandardWorkTicketService;
import com.qz.zframe.tickets.vo.StandardWorkTicketVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/tickets/standardWorkTicket")
@Api(tags = { "api-tickets-standardWorkTicket" }, description = "两票--标准工作票")
public class StandardWorkTicketController {

    private static Logger logger = LoggerFactory.getLogger(StandardWorkTicketController.class);

    @Autowired
    private StandardWorkTicketService standardWorkTicketService;

    @ApiOperation(value = "标准工作票--添加", notes = "标准工作票--添加")
    @RequestMapping(value = "addStandardWorkTicket", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity addStandardWorkTicket(@RequestBody StandardWorkTicketVo standardWorkTicketVo) {
        logger.info("===== 标准工作票--添加 =====");
        return standardWorkTicketService.addStandardWorkTicket(standardWorkTicketVo);
    }

    @ApiOperation(value = "标准工作票--修改", notes = "标准工作票--修改")
    @RequestMapping(value = "updateStandardWorkTicket", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity updateStandardWorkTicket(@RequestBody StandardWorkTicketVo standardWorkTicketVo) {
        logger.info("===== 标准工作票--修改 =====");
        return standardWorkTicketService.updateStandardWorkTicket(standardWorkTicketVo);
    }

    @ApiOperation(value = "标准工作票--删除", notes = "标准工作票--删除")
    @RequestMapping(value = "deleteStandardWorkTicket", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity deleteStandardWorkTicket(@RequestParam(required = false)@ApiParam(name="standardTicketIds",value="标准工作票ids数组",required=true) String[] standardTicketIds) {
        logger.info("===== 标准工作票--删除 =====");
        return standardWorkTicketService.deleteStandardWorkTicket(standardTicketIds);
    }

    @ApiOperation(value = "标准工作票--详情查询", notes = "标准工作票--详情查询")
    @RequestMapping(value = "getStandardWorkTicketDetail", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity getStandardWorkTicketDetail(@RequestParam(required = false)@ApiParam(name="standardTicketId",value="标准工作票id",required=true) String standardTicketId) {
        logger.info("===== 标准工作票--详情查询 =====");
        return standardWorkTicketService.getStandardWorkTicketDetail(standardTicketId);
    }

    @ApiOperation(value = "标准工作票--列表查询", notes = "标准工作票--列表查询")
    @RequestMapping(value = "getStandardWorkTicketList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public PageResultEntity getStandardWorkTicketList(@RequestParam(defaultValue = "1")@ApiParam(name="pageNum",value="当前页",required=false)String pageNum,
                                                      @RequestParam(defaultValue = "10")@ApiParam(name="pageSize",value="一页记录数",required=false)String pageSize,
                                                      @RequestParam(required = false)@ApiParam(name="ticketTypeId",value="工作票类型id",required=false)String ticketTypeId,
                                                      @RequestParam(required = false)@ApiParam(name="startWindId",value="风电场code",required=false)String startWindId,
                                                      @RequestParam(required = false)@ApiParam(name="endWindId",value="风电场code",required=false)String endWindId,
                                                      @RequestParam(required = false)@ApiParam(name="status",value="状态 01:启用 02:停用",required=false)String status,
                                                      @RequestParam(required = false)@ApiParam(name="workTeam",value="工作班组",required=false)String workTeam,
                                                      @RequestParam(required = false)@ApiParam(name="workContent",value="工作内容",required=false)String workContent) {
        logger.info("===== 标准工作票--列表查询 =====");
        Map<String,String> pageAndCondition = new HashMap();
        pageAndCondition.put("pageNum",pageNum);
        pageAndCondition.put("pageSize",pageSize);
        pageAndCondition.put("ticketTypeId",ticketTypeId);
        pageAndCondition.put("startWindId",startWindId);
        pageAndCondition.put("endWindId",endWindId);
        pageAndCondition.put("pageSize",pageSize);
        pageAndCondition.put("status",status);
        pageAndCondition.put("workContent",workContent);
        return standardWorkTicketService.getStandardWorkTicketList(pageAndCondition);
    }

    @ApiOperation(value = "下拉框--查询启用的标准工作票列表", notes = "下拉框--查询启用的标准工作票列表")
    @RequestMapping(value = "getEnableStandardWorkTicketList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity getEnableStandardWorkTicketList() {
        logger.info("===== 下拉框--查询启用的标准工作票列表 =====");
        return standardWorkTicketService.getEnableStandardWorkTicketList();
    }

    @ApiOperation(value = "标准工作票--生成工作票", notes = "标准工作票--生成工作票")
    @RequestMapping(value = "createWorkTicket", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity createWorkTicket(@RequestBody StandardWorkTicketVo standardWorkTicketVo) {
        logger.info("===== 标准工作票--生成工作票 =====");
        return standardWorkTicketService.createWorkTicket(standardWorkTicketVo);
    }
}
