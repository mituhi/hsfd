package com.qz.zframe.tally.controller;

import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.tally.entity.TallyAlarm;
import com.qz.zframe.tally.service.TallyAlarmService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@Controller
@RequestMapping("api/support/tallyAlarm")
@Api(
        tags = {"api-support-tallyAlarm"},
        description = "巡检-巡检告警记录"
)
@Transactional(rollbackFor = Exception.class)
public class AlarmController {

    @Autowired
    TallyAlarmService tallyAlarmService;


    @ApiOperation(value="巡检告警分页查询", notes="巡检告警分页查询" ,httpMethod="GET")
    @RequestMapping("alarmPage")
    @ResponseBody
    public PageResultEntity alarmPage(
            @RequestParam(required = false)
            @ApiParam(name="companyId",value="公司id",required=false) String companyId,
            @RequestParam(required = false)
            @ApiParam(name="startArchitectureCode",value="起始风电场编号",required=false) String startArchitectureCode,
            @RequestParam(required = false)
            @ApiParam(name="endArchitectureCode",value="结束风电场编号",required=false) String endArchitectureCode,
            @RequestParam(required = false)
            @ApiParam(name="startTime",value="起始时间",required=false) String startTime,
            @RequestParam(required = false)
            @ApiParam(name="endTime",value="结束时间",required=false) String endTime,
            @RequestParam(required = false)
            @ApiParam(name="processingStatus",value="处理状态",required=false) String processingStatus,
            @RequestParam(value = "pageNum",defaultValue = "1")int pageNum,
            @RequestParam(value = "pageSize",defaultValue = "10")  int pageSize) throws Exception {
        return tallyAlarmService.alarmPage(companyId, startArchitectureCode, endArchitectureCode, startTime, endTime, processingStatus,
                pageNum, pageSize);
    }

    @ApiOperation(value = "无需处理", notes = "无需处理")
    @RequestMapping(value = "unHandle", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public PageResultEntity unHandle(@RequestParam(required = true) List<String> alarmIds) {
        return tallyAlarmService.unHandle(alarmIds);
    }

    @ApiOperation(value = "新增巡检告警信息", notes = "新增巡检告警信息")
    @RequestMapping(value = "addTallyAlarm", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResultEntity addTallyAlarm(@RequestBody TallyAlarm tallyAlarm) {
        return tallyAlarmService.addTallyAlarm(tallyAlarm);
    }

    @ApiOperation(value = "批量新增巡检告警信息", notes = "批量新增巡检告警信息")
    @RequestMapping(value = "addTallyAlarmBatch", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResultEntity addTallyAlarmBatch(@RequestBody List<TallyAlarm> tallyAlarms) {
        return tallyAlarmService.addTallyAlarmBatch(tallyAlarms);
    }

    @ApiOperation(value = "生成缺陷工单", notes = "生成缺陷工单")
    @RequestMapping(value = "addDefectWorkorder", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResultEntity addDefectWorkorder(@RequestBody String alarmId) {
        ResultEntity resultEntity = null;
        try {
            resultEntity = tallyAlarmService.addDefectWorkorder(alarmId);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return resultEntity;
    }
}
