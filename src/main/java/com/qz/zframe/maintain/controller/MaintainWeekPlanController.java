package com.qz.zframe.maintain.controller;

import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.maintain.service.MaintainWeekPlanService;
import com.qz.zframe.maintain.vo.MaintainWeekPlanVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/maintain/maintainWeekPlan")
@Api(tags = { "api-maintain-maintainWeekPlan" }, description = "维护--周计划")
public class MaintainWeekPlanController {

    @Autowired
    private MaintainWeekPlanService maintainWeekPlanService;

    @ApiOperation(value = "添加维护周计划", notes = "添加维护周计划")
    @RequestMapping(value = "addMaintainWeekPlan", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity addMaintainWeekPlan(@RequestBody MaintainWeekPlanVo maintainWeekPlanVo) {
        return maintainWeekPlanService.addMaintainWeekPlan(maintainWeekPlanVo);
    }

    @ApiOperation(value = "批量删除维护周计划", notes = "批量删除维护周计划")
    @RequestMapping(value = "deleteMaintainWeekPlan", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity deleteMaintainWeekPlan(@RequestParam(required = false)@ApiParam(name="weekIds",value="周计划ids,逗号分隔",required=true) String weekIds) {
        return maintainWeekPlanService.deleteMaintainWeekPlan(weekIds);
    }

    @ApiOperation(value = "修改维护周计划", notes = "修改维护周计划")
    @RequestMapping(value = "updateMaintainWeekPlan", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity updateMaintainWeekPlan(@RequestBody MaintainWeekPlanVo maintainWeekPlanVo) {
        return maintainWeekPlanService.updateMaintainWeekPlan(maintainWeekPlanVo);
    }

    @ApiOperation(value = "浏览维护周计划", notes = "浏览维护周计划")
    @RequestMapping(value = "getMaintainWeekPlanDetail", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity getMaintainWeekPlanDetail(@RequestParam(required = false)
                                                      @ApiParam(name="weekId",value="周计划id",required=true) String weekId) {
        return maintainWeekPlanService.getMaintainWeekPlanDetail(weekId);
    }

    //分页+条件
    @ApiOperation(value = "维护周计划列表查询", notes = "维护周计划列表查询")
    @RequestMapping(value = "getMaintainWeekPlanList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public PageResultEntity getMaintainWeekPlanList(@RequestParam(defaultValue = "1")@ApiParam(name="pageNum",value="当前页",required=false)String pageNum,
                                                    @RequestParam(defaultValue = "10")@ApiParam(name="pageSize",value="一页记录数",required=false)String pageSize,
                                                    @RequestParam(required = false)@ApiParam(name="windId",value="风电场id",required=false)String windId,
                                                    @RequestParam(required = false)@ApiParam(name="startDate",value="维护日期",required=false)String satrtDate,
                                                    @RequestParam(required = false)@ApiParam(name="endDate",value="维护日期",required=false)String endDate) {
        Map<String,String> pageAndCondition = new HashMap();
        pageAndCondition.put("pageNum",pageNum);
        pageAndCondition.put("pageSize",pageSize);
        pageAndCondition.put("windId",windId);
        pageAndCondition.put("satrtDate",satrtDate);
        pageAndCondition.put("endDate",endDate);
        return maintainWeekPlanService.getMaintainWeekPlanList(pageAndCondition);
    }
}
