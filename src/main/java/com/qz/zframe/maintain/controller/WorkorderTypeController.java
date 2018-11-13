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
@Api(tags = { "api-maintain-workorderType" }, description = "维护--工单类型")
public class WorkorderTypeController {

    @Autowired
    private WorkorderTypeService workorderTypeService;

    @ApiOperation(value = "添加工单类型", notes = "添加工单类型")
    @RequestMapping(value = "addWorkorderType", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity addWorkorderType(@RequestBody WorkorderType workorderType) {
        return workorderTypeService.addWorkorderType(workorderType);
    }

    @ApiOperation(value = "批量删除工单类型", notes = "批量删除工单类型")
    @RequestMapping(value = "deleteWorkorderType", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity deleteWorkorderType(@RequestParam(required = false)@ApiParam(name="workorderTypeIds",value="工单类型ids",required=true)String workorderTypeIds) {
        return workorderTypeService.deleteWorkorderType(workorderTypeIds);
    }

    @ApiOperation(value = "修改工单类型", notes = "修改工单类型")
    @RequestMapping(value = "updateWorkorderType", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity updateWorkorderType(@RequestBody WorkorderType workorderType) {
        return workorderTypeService.updateWorkorderType(workorderType);
    }

    @ApiOperation(value = "浏览工单类型", notes = "浏览工单类型")
    @RequestMapping(value = "getWorkorderType", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity getWorkorderType(@RequestParam(required = false)@ApiParam(name="workorderTypeId",value="工单类型id",required=true)String workorderTypeId) {
        return workorderTypeService.getWorkorderType(workorderTypeId);
    }

    @ApiOperation(value = "工单分类列表查询", notes = "工单分类列表查询")
    @RequestMapping(value = "getWorkorderTypeList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity getWorkorderTypeList() {
        return workorderTypeService.getWorkorderTypeList();
    }


}
