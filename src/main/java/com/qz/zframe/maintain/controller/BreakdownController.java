package com.qz.zframe.maintain.controller;

import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.maintain.service.BreakdownService;
import com.qz.zframe.maintain.vo.BreakdownVo;
import com.qz.zframe.maintain.vo.ChooseDealModeVo;
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
@RequestMapping("/api/maintain/breakdown")
@Api(tags = { "api-maintain-breakdown" }, description = "维护--缺陷填报与查询")
public class BreakdownController {

    private static Logger logger = LoggerFactory.getLogger(BreakdownController.class);

    @Autowired
    private BreakdownService breakdownService;

    @ApiOperation(value = "故障信息--添加", notes = "故障信息--添加")
    @RequestMapping(value = "addBreakdown", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity addBreakdown(@RequestBody BreakdownVo breakdownVo) {
        logger.info("===== 故障信息--添加 =====");
        return breakdownService.addBreakdown(breakdownVo);
    }

    /*@ApiOperation(value = "故障信息--修改", notes = "故障信息--修改")
    @RequestMapping(value = "updateBreakdown", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)*/
    public ResultEntity updateBreakdown(@RequestBody BreakdownVo breakdownVo) {
        logger.info("===== 故障信息--修改 =====");
        return breakdownService.updateBreakdown(breakdownVo);
    }

    @ApiOperation(value = "故障信息--选择故障处理方式", notes = "故障信息--选择故障处理方式")
    @RequestMapping(value = "chooseDealMode", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity chooseDealMode(@RequestBody ChooseDealModeVo chooseDealModeVo) {
        logger.info("===== 故障信息--选择故障处理方式 =====");
        return breakdownService.chooseDealMode(chooseDealModeVo);
    }

    @ApiOperation(value = "故障信息--删除", notes = "故障信息--删除")
    @RequestMapping(value = "deleteBreakdown", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity deleteBreakdown(String[] breakdownIds){
        logger.info("===== 故障信息--删除 =====");
        return breakdownService.deleteBreakdown(breakdownIds);
    }

    @ApiOperation(value = "故障信息--详情查询", notes = "故障信息--详情查询")
    @RequestMapping(value = "getBreakdownDetail", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity getBreakdownDetail(@RequestParam(required = false)@ApiParam(name="breakdownId",value="故障id",required=true) String breakdownId) {
        logger.info("===== 故障信息--详情查询 =====");
        return  breakdownService.getBreakdownDetail(breakdownId);
    }

    //分页+条件
    @ApiOperation(value = "故障信息--列表查询", notes = "故障信息--列表查询")
    @RequestMapping(value = "getBreakdownList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public PageResultEntity getBreakdownList(@RequestParam(defaultValue = "1")@ApiParam(name="pageNum",value="当前页",required=false)String pageNum,
                                             @RequestParam(defaultValue = "10")@ApiParam(name="pageSize",value="一页记录数",required=false)String pageSize,
                                             @RequestParam(required = false)@ApiParam(name="startWindId",value="风电场code",required=false)String startWindId,
                                             @RequestParam(required = false)@ApiParam(name="endWindId",value="风电场code",required=false)String endWindId,
                                             @RequestParam(required = false)@ApiParam(name="crewId",value="机组id",required=false)String crewId,
                                             @RequestParam(required = false)@ApiParam(name="breakdownDesc",value="故障描述",required=false)String breakdownDesc,
                                             @RequestParam(required = false)@ApiParam(name="breakdownCode",value="故障代码",required=false)String breakdownCode,
                                             @RequestParam(required = false)@ApiParam(name="dealwithMode",value="处理方式",required=false)String dealwithMode,
                                             @RequestParam(required = false)@ApiParam(name="breakdownSource",value="故障来源",required=false)String breakdownSource,
                                             @RequestParam(required = false)@ApiParam(name="breakdownLocation",value="故障位置",required=false)String breakdownLocation,
                                             @RequestParam(required = false)@ApiParam(name="breakdownAttribute",value="故障属性",required=false)String breakdownAttribute,
                                             @RequestParam(required = false)@ApiParam(name="startTime",value="故障发生时间",required=false)String startTime,
                                             @RequestParam(required = false)@ApiParam(name="endTime",value="故障发生时间",required=false)String endTime) {
        logger.info("===== 故障信息--列表查询 =====");
        Map<String,String> pageAndCondition = new HashMap<>();
        pageAndCondition.put("pageNum",pageNum);
        pageAndCondition.put("pageSize",pageSize);
        pageAndCondition.put("startWindId",startWindId);
        pageAndCondition.put("endWindId",endWindId);
        pageAndCondition.put("crewId",crewId);
        pageAndCondition.put("breakdownDesc",breakdownDesc);
        pageAndCondition.put("breakdownCode",breakdownCode);
        pageAndCondition.put("dealwithMode",dealwithMode);
        pageAndCondition.put("breakdownSource",breakdownSource);
        pageAndCondition.put("breakdownLocation",breakdownLocation);
        pageAndCondition.put("breakdownAttribute",breakdownAttribute);
        pageAndCondition.put("startTime",startTime);
        pageAndCondition.put("endTime",endTime);
        return breakdownService.getBreakdownList(pageAndCondition);
    }
}
