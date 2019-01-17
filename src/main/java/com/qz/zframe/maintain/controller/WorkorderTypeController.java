package com.qz.zframe.maintain.controller;

import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.maintain.service.WorkorderTypeService;
import com.qz.zframe.maintain.vo.WorkorderTypeVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/maintain/workorderType")
@Api(tags = { "api-maintain-workorderType" }, description = "维护--工单类型")
public class WorkorderTypeController {

    private static Logger logger = LoggerFactory.getLogger(WorkorderTypeController.class);

    @Autowired
    private WorkorderTypeService workorderTypeService;

    @ApiOperation(value = "工单类型--添加", notes = "工单类型--添加")
    @RequestMapping(value = "addWorkorderType", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity addWorkorderType(@RequestBody WorkorderTypeVo workorderTypeVo) {
        logger.info("===== 工单类型--添加 =====");
        return workorderTypeService.addWorkorderType(workorderTypeVo);
    }

    @ApiOperation(value = "工单类型--修改", notes = "修改工单类型")
    @RequestMapping(value = "updateWorkorderType", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity updateWorkorderType(@RequestBody WorkorderTypeVo workorderTypeVo) {
        logger.info("===== 修改工单类型 =====");
        return workorderTypeService.updateWorkorderType(workorderTypeVo);
    }

    @ApiOperation(value = "工单类型--删除", notes = "工单类型--删除")
    @RequestMapping(value = "deleteWorkorderType", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity deleteWorkorderType(@RequestParam(required = false)@ApiParam(name="workorderTypeIds",value="工单类型ids数组",required=true)String[] workorderTypeIds) {
        logger.info("===== 工单类型--删除 =====");
        return workorderTypeService.deleteWorkorderType(workorderTypeIds);
    }

    @ApiOperation(value = "工单类型--详情查询", notes = "工单类型--详情查询")
    @RequestMapping(value = "getWorkorderTypeDetail", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity getWorkorderTypeDetail(@RequestParam(required = false)@ApiParam(name="workorderTypeId",value="工单类型id",required=true)String workorderTypeId) {
        logger.info("===== 工单类型--详情查询 =====");
        return workorderTypeService.getWorkorderTypeDetail(workorderTypeId);
    }

    @ApiOperation(value = "工单分类--列表查询", notes = "工单分类--列表查询")
    @RequestMapping(value = "getWorkorderTypeList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public PageResultEntity getWorkorderTypeList(
            @RequestParam(required = false)
            @ApiParam(name="workorderTypeCode",value="工单类型编码",required=false) String workorderTypeCode,
            @RequestParam(required = false)
            @ApiParam(name="workorderTypeName",value="工单类型名称",required=false) String workorderTypeName,
            @RequestParam(defaultValue = "1")@ApiParam(name="pageNum",value="当前页",required=false)String pageNum,
            @RequestParam(defaultValue = "10")@ApiParam(name="pageSize",value="一页记录数",required=false)String pageSize) {
        logger.info("===== 工单分类--列表查询 =====");
        Map<String,String> pageAndCondition = new HashMap();
        pageAndCondition.put("pageNum",pageNum);
        pageAndCondition.put("pageSize",pageSize);
        if (StringUtils.isNotBlank(workorderTypeCode)) {
            pageAndCondition.put("workorderTypeCode",'%'+workorderTypeCode+"%");
        }
        if (StringUtils.isNotBlank(workorderTypeName)) {
            pageAndCondition.put("workorderTypeName",'%'+workorderTypeName+"%");
        }
        return workorderTypeService.getWorkorderTypeList(pageAndCondition);
    }

    @ApiOperation(value = "工单分类--列表导出", notes = "工单分类--列表导出")
    @RequestMapping(value = "exportToExcel", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void exportToExcel(HttpServletResponse response) {
        logger.info("===== 工单分类--列表导出 =====");
        workorderTypeService.exportToExcel(response);
    }

    @ApiOperation(value = "下拉框--获取所有可用工单类型", notes = "下拉框--获取所有可用工单类型")
    @RequestMapping(value = "getAllWorkorderTypeList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public PageResultEntity getAllWorkorderTypeList() {
        logger.info("===== 下拉框--获取所有可用工单类型 =====");
        return workorderTypeService.getAllWorkorderTypeList();
    }

}
