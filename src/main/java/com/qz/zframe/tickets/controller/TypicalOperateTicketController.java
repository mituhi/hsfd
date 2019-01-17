package com.qz.zframe.tickets.controller;

import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.tickets.service.TypicalOperateTicketService;
import com.qz.zframe.tickets.vo.TypicalOperateTicketVo;
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
@RequestMapping("/api/tickets/typicalOperateTicket")
@Api(tags = { "api-tickets-typicalOperateTicket" }, description = "两票--典型操作票")
public class TypicalOperateTicketController {

    private static Logger logger = LoggerFactory.getLogger(TypicalOperateTicketController.class);

    @Autowired
    private TypicalOperateTicketService typicalOperateTicketService;

    @ApiOperation(value = "典型操作票--添加", notes = "典型操作票--添加")
    @RequestMapping(value = "addTypicalOperateTicket", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity addTypicalOperateTicket(@RequestBody TypicalOperateTicketVo typicalOperateTicketVo) {
        logger.info("===== 典型操作票--添加 =====");
        return typicalOperateTicketService.addTypicalOperateTicket(typicalOperateTicketVo);
    }

    @ApiOperation(value = "典型操作票--修改", notes = "典型操作票--修改")
    @RequestMapping(value = "updateTypicalOperateTicket", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity updateTypicalOperateTicket(@RequestBody TypicalOperateTicketVo typicalOperateTicketVo) {
        logger.info("===== 典型操作票--修改 =====");
        return typicalOperateTicketService.updateTypicalOperateTicket(typicalOperateTicketVo);
    }

    @ApiOperation(value = "典型操作票--删除", notes = "典型操作票--删除")
    @RequestMapping(value = "deleteTypicalOperateTicket", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity deleteTypicalOperateTicket(@RequestParam(required = false)@ApiParam(name="typicalTicketIds",value="典型操作票ids数组",required=true) String[] typicalTicketIds) {
        logger.info("===== 典型操作票--删除 =====");
        return typicalOperateTicketService.deleteTypicalOperateTicket(typicalTicketIds);
    }

    @ApiOperation(value = "典型操作票--详情查询", notes = "典型操作票--详情查询")
    @RequestMapping(value = "getTypicalOperateTicketDetail", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity getTypicalOperateTicketDetail(@RequestParam(required = false)@ApiParam(name="typicalTicketId",value="典型操作票id",required=true) String typicalTicketId) {
        logger.info("===== 典型操作票--详情查询 =====");
        return typicalOperateTicketService.getTypicalOperateTicketDetail(typicalTicketId);
    }

    //典型操作票列表分页+条件查询
    @ApiOperation(value = "典型操作票--列表查询", notes = "典型操作票--列表查询")
    @RequestMapping(value = "getTypicalOperateTicket", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public PageResultEntity getTypicalOperateTicketList(@RequestParam(defaultValue = "1")@ApiParam(name="pageNum",value="当前页",required=false)String pageNum,
                                                        @RequestParam(defaultValue = "10")@ApiParam(name="pageSize",value="一页记录数",required=false)String pageSize,
                                                        @RequestParam(required = false)@ApiParam(name="operTicketTypeId",value="操作票类型id",required=false)String operTicketTypeId,
                                                        @RequestParam(required = false)@ApiParam(name="startWindId",value="风电场code",required=false)String startWindId,
                                                        @RequestParam(required = false)@ApiParam(name="endWindId",value="风电场code",required=false)String endWindId,
                                                        @RequestParam(required = false)@ApiParam(name="status",value="状态 01:启用 02:停用",required=false)String status,
                                                        @RequestParam(required = false)@ApiParam(name="operateContent",value="操作内容",required=false)String operateContent) {
        logger.info("===== 典型操作票--列表查询 =====");
        Map<String,String> pageAndCondition = new HashMap<>();
        pageAndCondition.put("pageNum",pageNum);
        pageAndCondition.put("pageSize",pageSize);
        pageAndCondition.put("operTicketTypeId",operTicketTypeId);
        pageAndCondition.put("startWindId",startWindId);
        pageAndCondition.put("endWindId",endWindId);
        pageAndCondition.put("status",status);
        pageAndCondition.put("operateContent",operateContent);
        return typicalOperateTicketService.getTypicalOperateTicketList(pageAndCondition);
    }

    @ApiOperation(value = "下拉框--查询启用的典型操作票列表", notes = "下拉框--查询启用的典型操作票列表")
    @RequestMapping(value = "getEnableTypicalOperateTicketList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity getEnableTypicalOperateTicketList() {
        logger.info("===== 下拉框--查询启用的典型操作票列表 =====");
        return typicalOperateTicketService.getEnableTypicalOperateTicketList();
    }

    @ApiOperation(value = "典型操作票--生成操作票", notes = "典型操作票--生成操作票")
    @RequestMapping(value = "createOperateTicket", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity createOperateTicket(@RequestBody TypicalOperateTicketVo typicalOperateTicketVo) {
        logger.info("===== 典型操作票--生成操作票 =====");
        return typicalOperateTicketService.createOperateTicket(typicalOperateTicketVo);
    }


}
