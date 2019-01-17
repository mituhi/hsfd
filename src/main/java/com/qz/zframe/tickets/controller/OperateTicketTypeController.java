package com.qz.zframe.tickets.controller;

import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.tickets.service.OperateTicketTypeService;
import com.qz.zframe.tickets.vo.OperateTicketTypeVo;
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
@RequestMapping("/api/tickets/operateTicketType")
@Api(tags = { "api-tickets-operateTicketType" }, description = "两票--操作票类型")
public class OperateTicketTypeController {

    private static Logger logger = LoggerFactory.getLogger(OperateTicketTypeController.class);

    @Autowired
    private OperateTicketTypeService operateTicketTypeService;

    @ApiOperation(value = "操作票类型--添加", notes = "操作票类型--添加")
    @RequestMapping(value = "addOperateTicketType", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity addOperateTicketType(@RequestBody OperateTicketTypeVo operateTicketTypeVo) {
        logger.info("===== 操作票类型--添加 =====");
        return operateTicketTypeService.addOperateTicketType(operateTicketTypeVo);
    }

    @ApiOperation(value = "操作票类型--修改", notes = "操作票类型--修改")
    @RequestMapping(value = "updateOperateTicketType", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity updateOperateTicketType(@RequestBody OperateTicketTypeVo operateTicketTypeVo) {
        logger.info("===== 操作票类型--修改 =====");
        return operateTicketTypeService.updateOperateTicketType(operateTicketTypeVo);
    }

    @ApiOperation(value = "操作票类型--删除", notes = "操作票类型--删除")
    @RequestMapping(value = "deleteOperateTicketType", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity deleteOperateTicketType(@RequestParam(required = false)@ApiParam(name="ticketTypeIds",value="操作票类型id数组",required=true) String[] ticketTypeIds) {
        logger.info("===== 操作票类型--删除 =====");
        return operateTicketTypeService.deleteOperateTicketType(ticketTypeIds);
    }

    @ApiOperation(value = "操作票类型--详情查询", notes = "操作票类型--详情查询")
    @RequestMapping(value = "getOperateTicketTypeDetail", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity getOperateTicketTypeDetail(@RequestParam(required = false)
                                                   @ApiParam(name="ticketTypeId",value="操作票类型id",required=true) String ticketTypeId) {
        logger.info("===== 操作票类型--详情查询 =====");
        return operateTicketTypeService.getOperateTicketTypeDetail(ticketTypeId);
    }

    //操作票类型列表查询
    @ApiOperation(value = "操作票类型--列表查询", notes = "操作票类型--列表查询")
    @RequestMapping(value = "getOperateTicketTypeList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public PageResultEntity getOperateTicketTypeList(
            @RequestParam(required = false)
            @ApiParam(name="startArchitectureCode",value="起始风电场编号",required=false) String startArchitectureCode,
            @RequestParam(required = false)
            @ApiParam(name="endArchitectureCode",value="结束风电场编号",required=false) String endArchitectureCode,
            @RequestParam(defaultValue = "1")@ApiParam(name="pageNum",value="当前页",required=false)String pageNum,
                                             @RequestParam(defaultValue = "10")@ApiParam(name="pageSize",value="一页记录数",required=false)String pageSize) {
        logger.info("===== 操作票类型--列表查询 =====");
        Map<String,String> pageAndCondition = new HashMap();
        pageAndCondition.put("pageNum",pageNum);
        pageAndCondition.put("pageSize",pageSize);
        pageAndCondition.put("startArchitectureCode",startArchitectureCode);
        pageAndCondition.put("endArchitectureCode",endArchitectureCode);
        return operateTicketTypeService.getOperateTicketTypeList(pageAndCondition);
    }

    //操作票类型列表查询
    @ApiOperation(value = "下拉框--操作票类型", notes = "下拉框--操作票类型")
    @RequestMapping(value = "getAllperateTicketType", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity getAllperateTicketType() {
        logger.info("===== 下拉框--操作票类型 =====");
        return operateTicketTypeService.getAllperateTicketType();
    }

    @ApiOperation(value = "下拉框--操作人", notes = "下拉框--操作人")
    @RequestMapping(value = "getExecuterList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity getExecuterList(@RequestParam(required = false)
                                        @ApiParam(name="ticketTypeId",value="操作票类型id",required=true) String ticketTypeId) {
        logger.info("===== 下拉框--操作人 =====");
        return operateTicketTypeService.getExecuterList(ticketTypeId);
    }

    @ApiOperation(value = "下拉框--监护人", notes = "下拉框--监护人")
    @RequestMapping(value = "getSupervisiorList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity getSupervisiorList(@RequestParam(required = false)
                                           @ApiParam(name="ticketTypeId",value="操作票类型id",required=true) String ticketTypeId) {
        logger.info("===== 下拉框--监护人 =====");
        return operateTicketTypeService.getSupervisiorList(ticketTypeId);
    }

}
