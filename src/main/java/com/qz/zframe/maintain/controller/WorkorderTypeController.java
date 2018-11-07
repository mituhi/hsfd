package com.qz.zframe.maintain.controller;

import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.maintain.entity.WorkorderType;
import com.qz.zframe.maintain.service.WorkorderTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/maintain/workorderType")
@Api(tags = { "api-maintain-workorderType" }, description = "维护--工单分类")
public class WorkorderTypeController {

    @Autowired
    private WorkorderTypeService workorderTypeService;

    @ApiOperation(value = "工单分类列表查询", notes = "工单分类列表查询")
    @RequestMapping(value = "getWorkorderTypeList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity getWorkorderTypeList() {
        return workorderTypeService.getWorkorderTypeList();
    }

    @ApiOperation(value = "新建工单分类", notes = "新建工单分类")
    @RequestMapping(value = "createWorkorderType", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity createWorkorderType() {
        return workorderTypeService.createWorkorderType();
    }

    @ApiOperation(value = "添加工单分类", notes = "添加工单分类列表")
    @RequestMapping(value = "addWorkorderType", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity addWorkorderType(@RequestBody WorkorderType workorderType) {
        return workorderTypeService.addWorkorderType(workorderType);
    }

    @ApiOperation(value = "批量删除工单分类", notes = "批量删除工单分类")
    @RequestMapping(value = "deleteWorkorderType", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity deleteWorkorderType(@RequestParam(required = true)@ApiParam(name="workorderTypeIds",value="工单类型ids",required=true)String workorderTypeIds) {
        return workorderTypeService.deleteWorkorderType(workorderTypeIds);
    }

    @ApiOperation(value = "修改工单分类", notes = "修改工单分类")
    @RequestMapping(value = "updateWorkorderType", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity updateWorkorderType(@RequestBody WorkorderType workorderType) {
        return workorderTypeService.updateWorkorderType(workorderType);
    }

    @ApiOperation(value = "浏览工单分类", notes = "浏览工单分类")
    @RequestMapping(value = "selectWorkorderType", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity selectWorkorderType(@RequestParam(required = true)@ApiParam(name="workorderTypeId",value="工单类型ids",required=true)String workorderTypeId) {
        return workorderTypeService.selectWorkorderType(workorderTypeId);
    }



}
