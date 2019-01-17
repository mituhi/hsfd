package com.qz.zframe.maintain.controller;

import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.maintain.service.MaintainWeekPlanService;
import com.qz.zframe.maintain.vo.MaintainWeekPlanVo;
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
@RequestMapping("/api/maintain/maintainWeekPlan")
@Api(tags = { "api-maintain-maintainWeekPlan" }, description = "维护--周计划")
public class MaintainWeekPlanController {

    private static Logger logger = LoggerFactory.getLogger(MaintainWeekPlanController.class);

    @Autowired
    private MaintainWeekPlanService maintainWeekPlanService;

    @ApiOperation(value = "维护周计划--添加", notes = "维护周计划--添加")
    @RequestMapping(value = "addMaintainWeekPlan", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity addMaintainWeekPlan(@RequestBody MaintainWeekPlanVo maintainWeekPlanVo) {
        logger.info("===== 维护周计划--添加 =====");
        return maintainWeekPlanService.addMaintainWeekPlan(maintainWeekPlanVo);
    }

    @ApiOperation(value = "维护周计划--修改", notes = "维护周计划--修改")
    @RequestMapping(value = "updateMaintainWeekPlan", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity updateMaintainWeekPlan(@RequestBody MaintainWeekPlanVo maintainWeekPlanVo) {
        logger.info("===== 维护周计划--修改 =====");
        return maintainWeekPlanService.updateMaintainWeekPlan(maintainWeekPlanVo);
    }

    @ApiOperation(value = "维护周计划--删除", notes = "维护周计划--删除")
    @RequestMapping(value = "deleteMaintainWeekPlan", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity deleteMaintainWeekPlan(String[] weekIds) {
        logger.info("===== 维护周计划--删除 =====");
        return maintainWeekPlanService.deleteMaintainWeekPlan(weekIds);
    }

    @ApiOperation(value = "维护周计划--详情查询", notes = "维护周计划--详情查询")
    @RequestMapping(value = "getMaintainWeekPlanDetail", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity getMaintainWeekPlanDetail(@RequestParam(required = false)
                                                  @ApiParam(name="weekId",value="周计划id",required=true) String weekId) {
        logger.info("===== 维护周计划--详情查询 =====");
        return maintainWeekPlanService.getMaintainWeekPlanDetail(weekId);
    }

    //分页+条件
    @ApiOperation(value = "维护周计划--列表查询", notes = "维护周计划--列表查询")
    @RequestMapping(value = "getMaintainWeekPlanList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public PageResultEntity getMaintainWeekPlanList(@RequestParam(defaultValue = "1")@ApiParam(name="pageNum",value="当前页",required=false)String pageNum,
                                                    @RequestParam(defaultValue = "10")@ApiParam(name="pageSize",value="一页记录数",required=false)String pageSize,
                                                    @RequestParam(required = false)@ApiParam(name="startWindId",value="风电场code",required=false)String startWindId,
                                                    @RequestParam(required = false)@ApiParam(name="endWindId",value="风电场code",required=false)String endWindId,
                                                    @RequestParam(required = false)@ApiParam(name="startDate",value="维护日期",required=false)String satrtDate,
                                                    @RequestParam(required = false)@ApiParam(name="endDate",value="维护日期",required=false)String endDate) {
        logger.info("===== 维护周计划--列表查询 =====");
        Map<String,String> pageAndCondition = new HashMap();
        pageAndCondition.put("pageNum",pageNum);
        pageAndCondition.put("pageSize",pageSize);
        pageAndCondition.put("startWindId",startWindId);
        pageAndCondition.put("endWindId",endWindId);
        pageAndCondition.put("satrtDate",satrtDate);
        pageAndCondition.put("endDate",endDate);
        return maintainWeekPlanService.getMaintainWeekPlanList(pageAndCondition);
    }
}
