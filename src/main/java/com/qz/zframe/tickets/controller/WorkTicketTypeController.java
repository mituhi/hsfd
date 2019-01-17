package com.qz.zframe.tickets.controller;

import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.tickets.entity.OperateTicketType;
import com.qz.zframe.tickets.service.WorkTicketTypeService;
import com.qz.zframe.tickets.vo.WorkTicketTypeVo;
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
@RequestMapping("/api/tickets/workTicketType")
@Api(tags = { "api-tickets-workTicketType" }, description = "两票--工作票类型")
public class WorkTicketTypeController {

    private static Logger logger = LoggerFactory.getLogger(WorkTicketTypeController.class);

    @Autowired
    private WorkTicketTypeService workTicketTypeService;

    @ApiOperation(value = "工作票类型--添加", notes = "工作票类型--添加")
    @RequestMapping(value = "addWorkTicketType", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity addWorkTicketType(@RequestBody WorkTicketTypeVo workTicketTypeVo) {
        logger.info("===== 工作票类型--添加 =====");
        return workTicketTypeService.addWorkTicketType(workTicketTypeVo);
    }

    @ApiOperation(value = "工作票类型--修改", notes = "工作票类型--修改")
    @RequestMapping(value = "updateWorkTicketType", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity updateWorkTicketType(@RequestBody WorkTicketTypeVo workTicketTypeVo) {
        logger.info("===== 工作票类型--修改 =====");
        return workTicketTypeService.updateWorkTicketType(workTicketTypeVo);
    }

    @ApiOperation(value = "工作票类型--删除", notes = "工作票类型--删除")
    @RequestMapping(value = "deleteWorkTicketType", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity deleteWorkTicketType(@RequestParam(required = false)
                                             @ApiParam(name="workTicketTypeIds",value="工作票类型ids数组",required=true) String[] workTicketTypeIds) {
        logger.info("===== 工作票类型--删除 =====");
        return workTicketTypeService.deleteWorkTicketType(workTicketTypeIds);
    }

    @ApiOperation(value = "工作票类型--详情查询", notes = "工作票类型--详情查询")
    @RequestMapping(value = "getWorkTicketTypeDetail", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity getWorkTicketTypeDetail(@RequestParam(required = false)
                                                @ApiParam(name="workTicketTypeId",value="工作票类型id",required=true) String workTicketTypeId) {
        logger.info("===== 工作票类型--详情查询 =====");
        return workTicketTypeService.getWorkTicketTypeDetail(workTicketTypeId);
    }

    @ApiOperation(value = "工作票类型--列表查询", notes = "工作票类型--列表查询")
    @RequestMapping(value = "getWorkTicketTypeList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public PageResultEntity getWorkTicketTypeList(@RequestParam(required = false)
            @ApiParam(name="startArchitectureCode",value="起始风电场编号",required=false) String startArchitectureCode,
            @RequestParam(required = false)
            @ApiParam(name="endArchitectureCode",value="结束风电场编号",required=false) String endArchitectureCode,
            @RequestParam(defaultValue = "1")@ApiParam(name="pageNum",value="当前页",required=false)String pageNum,
                                                  @RequestParam(defaultValue = "10")@ApiParam(name="pageSize",value="一页记录数",required=false)String pageSize) {
        logger.info("===== 工作票类型--列表查询 =====");
        Map<String,String> pageAndCondition = new HashMap();
        pageAndCondition.put("pageNum",pageNum);
        pageAndCondition.put("pageSize",pageSize);
        pageAndCondition.put("startArchitectureCode",startArchitectureCode);
        pageAndCondition.put("endArchitectureCode",endArchitectureCode);
        return workTicketTypeService.getWorkTicketTypeList(pageAndCondition, startArchitectureCode, endArchitectureCode);
    }

    @ApiOperation(value = "下拉框--工作票类型", notes = "下拉框--工作票类型")
    @RequestMapping(value = "getAllWorkTicketType", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity getAllWorkTicketType() {
        logger.info("===== 下拉框--工作票类型 =====");
        return workTicketTypeService.getAllWorkTicketType();
    }

    @ApiOperation(value = "下拉框--工作负责人", notes = "下拉框--工作负责人")
    @RequestMapping(value = "getWorkHeadList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity getWorkHeadList(@RequestParam(required = false)
                                        @ApiParam(name="workTicketTypeId",value="工作票类型id",required=true) String workTicketTypeId) {
        logger.info("===== 下拉框--工作负责人 =====");
        return workTicketTypeService.getWorkHeadList(workTicketTypeId);
    }

    @ApiOperation(value = "下拉框--签发人", notes = "下拉框--签发人")
    @RequestMapping(value = "getSignerList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity getSignerList(@RequestParam(required = false)
                                      @ApiParam(name="workTicketTypeId",value="工作票类型id",required=true) String workTicketTypeId) {
        logger.info("===== 下拉框--签发人 =====");
        return workTicketTypeService.getSignerList(workTicketTypeId);
    }

    @ApiOperation(value = "下拉框--许可人", notes = "下拉框--许可人")
    @RequestMapping(value = "getLicensorList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity getLicensorList(@RequestParam(required = false)
                                        @ApiParam(name="workTicketTypeId",value="工作票类型id",required=true) String workTicketTypeId) {
        logger.info("===== 下拉框--许可人 =====");
        return workTicketTypeService.getLicensorList(workTicketTypeId);
    }
}
