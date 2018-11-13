package com.qz.zframe.tickets.controller;

import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.tickets.service.WorkTicketTypeService;
import com.qz.zframe.tickets.vo.WorkTicketTypeVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/tickets/workTicketType")
@Api(tags = { "api-tickets-workTicketType" }, description = "两票--工作票类型")
public class WorkTicketTypeController {

    @Autowired
    private WorkTicketTypeService workTicketTypeService;

    @ApiOperation(value = "添加工作票类型", notes = "添加工作票类型")
    @RequestMapping(value = "addWorkTicketType", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity addWorkTicketType(@RequestBody WorkTicketTypeVo workTicketTypeVo) {
        return workTicketTypeService.addWorkTicketType(workTicketTypeVo);
    }

    @ApiOperation(value = "删除工作票类型", notes = "删除工作票类型")
    @RequestMapping(value = "deleteWorkTicketType", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity deleteWorkTicketType(@RequestParam(required = true)
                                                 @ApiParam(name="workTicketTypeIds",value="工作票类型ids,逗号分隔",required=true) String workTicketTypeIds) {
        return workTicketTypeService.deleteWorkTicketType(workTicketTypeIds);
    }

    @ApiOperation(value = "修改工作票类型", notes = "修改工作票类型")
    @RequestMapping(value = "updateWorkTicketType", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity updateWorkTicketType(@RequestBody WorkTicketTypeVo workTicketTypeVo) {
        return workTicketTypeService.updateWorkTicketType(workTicketTypeVo);
    }

    @ApiOperation(value = "工作票类型详情查询", notes = "工作票类型详情查询")
    @RequestMapping(value = "getWorkTicketTypeDetail", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity getWorkTicketTypeDetail(@RequestParam(required = true)@ApiParam(name="workTicketTypeId",value="工作票类型id",required=true) String workTicketTypeId) {
        return workTicketTypeService.getWorkTicketTypeDetail(workTicketTypeId);
    }

    @ApiOperation(value = "工作票类型列表查询", notes = "工作票类型列表查询")
    @RequestMapping(value = "getWorkTicketTypeList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public PageResultEntity getWorkTicketTypeList(@RequestParam(defaultValue = "1")@ApiParam(name="pageNum",value="当前页",required=false)String pageNum,
                                                  @RequestParam(defaultValue = "10")@ApiParam(name="pageSize",value="一页记录数",required=false)String pageSize) {
        Map<String,String> pageAndCondition = new HashMap();
        pageAndCondition.put("pageNum",pageNum);
        pageAndCondition.put("pageSize",pageSize);
        return workTicketTypeService.getWorkTicketTypeList(pageAndCondition);
    }
}
