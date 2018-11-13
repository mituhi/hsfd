package com.qz.zframe.maintain.controller;

import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.maintain.entity.BreakdownInfo;
import com.qz.zframe.maintain.service.BreakdownService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/maintain/breakdown")
@Api(tags = { "api-maintain-breakdown" }, description = "维护--故障处理")
public class BreakdownController {

    @Autowired
    private BreakdownService breakdownService;

    @ApiOperation(value = "添加故障信息", notes = "添加故障信息")
    @RequestMapping(value = "addBreakdown", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity addBreakdown(@RequestBody BreakdownInfo breakdownInfo) {
        return breakdownService.addBreakdown(breakdownInfo);
    }

    @ApiOperation(value = "批量删除故障信息", notes = "批量删除故障信息")
    @RequestMapping(value = "deleteBreakdown", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity deleteBreakdown(@RequestParam(required = false)@ApiParam(name="breakdownIds",value="故障ids字符串,以逗号分隔",required=true) String breakdownIds){
        return breakdownService.deleteBreakdown(breakdownIds);
    }

    @ApiOperation(value = "修改故障信息", notes = "修改故障信息")
    @RequestMapping(value = "updateBreakdown", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity updateBreakdown(@RequestBody BreakdownInfo breakdownInfo) {
        return breakdownService.updateBreakdown(breakdownInfo);
    }

    @ApiOperation(value = "浏览故障信息", notes = "浏览故障信息")
    @RequestMapping(value = "getBreakdownDetail", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity getBreakdownDetail(@RequestParam(required = false)@ApiParam(name="breakdownId",value="故障id",required=true) String breakdownId) {
        return  breakdownService.getBreakdownDetail(breakdownId);
    }

    //分页+条件
    @ApiOperation(value = "故障信息列表查询", notes = "故障信息列表查询")
    @RequestMapping(value = "getBreakdownList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public PageResultEntity getBreakdownList(@RequestParam(defaultValue = "1")@ApiParam(name="pageNum",value="当前页",required=false)String pageNum,
                                             @RequestParam(defaultValue = "10")@ApiParam(name="pageSize",value="一页记录数",required=false)String pageSize,
                                             @RequestParam(required = false)@ApiParam(name="windId",value="风电场id",required=false)String windId,
                                             @RequestParam(required = false)@ApiParam(name="crewId",value="机组id",required=false)String crewId,
                                             @RequestParam(required = false)@ApiParam(name="breakdownDesc",value="故障描述",required=false)String breakdownDesc,
                                             @RequestParam(required = false)@ApiParam(name="breakdownCode",value="故障代码",required=false)String breakdownCode,
                                             @RequestParam(required = false)@ApiParam(name="dealwithMode",value="处理方式",required=false)String dealwithMode,
                                             @RequestParam(required = false)@ApiParam(name="breakdownLocation",value="故障位置",required=false)String breakdownLocation,
                                             @RequestParam(required = false)@ApiParam(name="breakdownAttribute",value="故障属性",required=false)String breakdownAttribute,
                                             @RequestParam(required = false)@ApiParam(name="startTime",value="故障发生时间",required=false)String startTime,
                                             @RequestParam(required = false)@ApiParam(name="endTime",value="故障发生时间",required=false)String endTime) {
        Map<String,String> pageAndCondition = new HashMap();
        pageAndCondition.put("pageNum",pageNum);
        pageAndCondition.put("pageSize",pageSize);
        pageAndCondition.put("windId",windId);
        pageAndCondition.put("crewId",crewId);
        pageAndCondition.put("breakdownDesc",breakdownDesc);
        pageAndCondition.put("breakdownCode",breakdownCode);
        pageAndCondition.put("dealwithMode",dealwithMode);
        pageAndCondition.put("breakdownLocation",breakdownLocation);
        pageAndCondition.put("breakdownAttribute",breakdownAttribute);
        pageAndCondition.put("startTime",startTime);
        pageAndCondition.put("endTime",endTime);
        return breakdownService.getBreakdownList(pageAndCondition);
    }
    @ApiOperation(value = "故障处理方式列表查询", notes = "故障处理方式列表查询")
    @RequestMapping(value = "getDealwithModeList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity getDealwithModeList() {
        return breakdownService.getDealwithModeList();
    }
    @ApiOperation(value = "故障位置列表查询", notes = "故障位置列表查询")
    @RequestMapping(value = "getBreakdownLocationList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity getBreakdownLocationList() {
        return breakdownService.getBreakdownLocationList();
    }
    @ApiOperation(value = "故障属性列表查询", notes = "故障属性列表查询")
    @RequestMapping(value = "getBreakdownAttributeList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity getBreakdownAttributeList() {
        return breakdownService.getBreakdownAttributeList();
    }
}
