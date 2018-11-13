package com.qz.zframe.maintain.controller;

import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.maintain.service.WorkorderService;
import com.qz.zframe.maintain.vo.WorkorderVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/maintain/workorder")
@Api(tags = { "api-maintain-workorder" }, description = "维护--工单管理")
public class WorkorderController {

    @Autowired
    private WorkorderService workorderService;

    @ApiOperation(value = "工单策划", notes = "工单策划")
    @RequestMapping(value = "addWorkorder", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity addWorkorder(@RequestBody WorkorderVo workorderVo) {
        return workorderService.addWorkorder(workorderVo);
    }

    @ApiOperation(value = "删除工单", notes = "删除工单")
    @RequestMapping(value = "deleteWorkorder", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity deleteWorkorder(@RequestParam(required = false)@ApiParam(name="orderIds",value="工单ids字符串,以逗号分隔",required=true)
                                                    String orderIds) {
        return workorderService.deleteWorkorder(orderIds);
    }

    @ApiOperation(value = "修改工单", notes = "修改工单")
    @RequestMapping(value = "updateWorkorder", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity updateWorkorder(@RequestBody WorkorderVo workorderVo) {
        return workorderService.updateWorkorder(workorderVo);
    }

    @ApiOperation(value = "浏览工单", notes = "浏览工单")
    @RequestMapping(value = "getWorkorderDetail", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity getWorkorderDetail(@RequestParam(required = false)@ApiParam(name="orderId",value="工单id",required=true) String orderId) {
        return workorderService.getWorkorderDetail(orderId);
    }

    //分页+条件
    @ApiOperation(value = "工单列表查询", notes = "工单列表查询")
    @RequestMapping(value = "getWorkorderList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public PageResultEntity getWorkorderList(@RequestParam(defaultValue = "1")@ApiParam(name="pageNum",value="当前页",required=false)String pageNum,
                                 @RequestParam(defaultValue = "10")@ApiParam(name="pageSize",value="一页记录数",required=false)String pageSize,
                                 @RequestParam(required = false)@ApiParam(name="windId",value="风电场id",required=false)String windId,
                                 @RequestParam(required = false)@ApiParam(name="crewId",value="机组id",required=false)String crewId,
                                 @RequestParam(required = false)@ApiParam(name="workorderTypeId",value="工单类型id",required=false)String workorderTypeId,
                                 @RequestParam(required = false)@ApiParam(name="status",value="状态",required=false)String status,
                                 @RequestParam(required = false)@ApiParam(name="workorderDesc",value="工单描述",required=false)String workorderDesc) {
        Map<String,String> pageAndCondition = new HashMap();
        pageAndCondition.put("pageNum",pageNum);
        pageAndCondition.put("pageSize",pageSize);
        pageAndCondition.put("windId",windId);
        pageAndCondition.put("crewId",crewId);
        pageAndCondition.put("workorderTypeId",workorderTypeId);
        pageAndCondition.put("status",status);
        pageAndCondition.put("workorderDesc",workorderDesc);
        return workorderService.getWorkorderList(pageAndCondition);
    }

}
