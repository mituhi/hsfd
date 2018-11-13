package com.qz.zframe.maintain.controller;

import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.maintain.service.MaintainLogInfoService;
import com.qz.zframe.maintain.vo.MaintainLogVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/maintain/maintainLogInfo")
@Api(tags = { "api-maintain-maintainLogInfo" }, description = "维护--维护日志")
public class MaintainLogInfoController {

    @Autowired
    private MaintainLogInfoService maintainLogInfoService;

    @ApiOperation(value = "添加维护日志", notes = "添加维护日志")
    @RequestMapping(value = "addMaintainLog", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity addMaintainLog(@RequestBody MaintainLogVo maintainLogVo) {
        return maintainLogInfoService.addMaintainLog(maintainLogVo);
    }

    @ApiOperation(value = "批量删除维护日志", notes = "批量删除维护日志")
    @RequestMapping(value = "deleteMaintainLog", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity deleteMaintainLog(@RequestParam(required = false)@ApiParam(name="dayIds",value="日志ids,逗号分隔",required=true) String dayIds) {
        return maintainLogInfoService.deleteMaintainLog(dayIds);
    }

    @ApiOperation(value = "修改维护日志", notes = "修改维护日志")
    @RequestMapping(value = "updateMaintainLog", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity updateMaintainLog(@RequestBody MaintainLogVo maintainLogVo) {
        return maintainLogInfoService.updateMaintainLog(maintainLogVo);
    }

    @ApiOperation(value = "浏览维护日志", notes = "浏览维护日志")
    @RequestMapping(value = "getMaintainLogDetail", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity getMaintainLogDetail(@RequestParam(required = false)@ApiParam(name="dayId",value="日志id",required=true) String dayId) {
        return maintainLogInfoService.getMaintainLogDetail(dayId);
    }

    @ApiOperation(value = "维护日志列表查询", notes = "维护日志列表查询")
    @RequestMapping(value = "getMaintainLogList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public PageResultEntity getMaintainLogList(@RequestParam(defaultValue = "1")@ApiParam(name="pageNum",value="当前页",required=false)String pageNum,
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
        return maintainLogInfoService.getMaintainLogList(pageAndCondition);
    }
}
