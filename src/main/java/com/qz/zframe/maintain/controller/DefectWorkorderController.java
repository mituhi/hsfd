package com.qz.zframe.maintain.controller;

import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.maintain.service.DefectWorkorderService;
import com.qz.zframe.maintain.vo.DefectWorkorderVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/maintain/defectWorkorder")
@Api(tags = { "api-maintain-defectWorkorder" }, description = "维护--缺陷工单")
public class DefectWorkorderController {

    @Autowired
    private DefectWorkorderService defectWorkorderService;

    @ApiOperation(value = "添加缺陷工单", notes = "添加缺陷工单")
    @RequestMapping(value = "addDefectWorkorder", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity addDefectWorkorder(@RequestBody DefectWorkorderVo defectWorkorderVo) {
        return defectWorkorderService.addDefectWorkorder(defectWorkorderVo);
    }

    @ApiOperation(value = "批量删除缺陷工单", notes = "批量删除缺陷工单")
    @RequestMapping(value = "deleteDefectWorkorder", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity deleteDefectWorkorder(@RequestParam(required = false)@ApiParam(name="workorderIds",value="缺陷工单ids字符串,以逗号分隔",required=true)
                                                          String workorderIds) {
        System.out.println(workorderIds);
        return defectWorkorderService.deleteDefectWorkorder(workorderIds);
    }

    @ApiOperation(value = "修改缺陷工单", notes = "修改缺陷工单")
    @RequestMapping(value = "updateDefectWorkorder", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity updateDefectWorkorder(@RequestBody DefectWorkorderVo defectWorkorderVo) {
        return defectWorkorderService.updateDefectWorkorder(defectWorkorderVo);
    }

    @ApiOperation(value = "浏览缺陷工单", notes = "浏览缺陷工单")
    @RequestMapping(value = "getDefectWorkorderDetail", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity getDefectWorkorderDetail(@RequestParam(required = false)@ApiParam(name="workorderId",value="缺陷工单id",required=true)String workorderId) {
        return defectWorkorderService.getDefectWorkorderDetail(workorderId);
    }

    //分页+条件
    @ApiOperation(value = "缺陷工单列表查询", notes = "缺陷工单列表查询")
    @RequestMapping(value = "getDefectWorkorderList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public PageResultEntity getDefectWorkorderList(@RequestParam(defaultValue = "1")@ApiParam(name="pageNum",value="当前页",required=false)String pageNum,
                                                   @RequestParam(defaultValue = "10")@ApiParam(name="pageSize",value="一页记录数",required=false)String pageSize,
                                                   @RequestParam(required = false)@ApiParam(name="windId",value="风电场id",required=false)String windId,
                                                   @RequestParam(required = false)@ApiParam(name="crewId",value="机组id",required=false)String crewId,
                                                   @RequestParam(required = false)@ApiParam(name="dealMode",value="处理方式",required=false)String dealMode,
                                                   @RequestParam(required = false)@ApiParam(name="dutyTeam",value="负责班组",required=false)String dutyTeam,
                                                   @RequestParam(required = false)@ApiParam(name="status",value="状态",required=false)String status,
                                                   @RequestParam(required = false)@ApiParam(name="workorderDesc",value="工单描述",required=false)String workorderDesc,
                                                   @RequestParam(required = false)@ApiParam(name="startTime",value="填报时间",required=false)String startTime,
                                                   @RequestParam(required = false)@ApiParam(name="endTime",value="填报时间",required=false)String endTime) {
        Map<String,String> pageAndCondition = new HashMap();
        pageAndCondition.put("pageNum",pageNum);
        pageAndCondition.put("pageSize",pageSize);
        pageAndCondition.put("windId",windId);
        pageAndCondition.put("crewId",crewId);
        pageAndCondition.put("dealMode",dealMode);
        pageAndCondition.put("dutyTeam",dutyTeam);
        pageAndCondition.put("status",status);
        pageAndCondition.put("workorderDesc",workorderDesc);
        pageAndCondition.put("startTime",startTime);
        pageAndCondition.put("endTime",endTime);
        return defectWorkorderService.getDefectWorkorderList(pageAndCondition);
    }


}
