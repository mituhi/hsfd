package com.qz.zframe.maintain.controller;

import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.maintain.service.BreakdownKnowledgeService;
import com.qz.zframe.maintain.vo.KnowledgeVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/maintain/knowledge")
@Api(tags = { "api-maintain-knowledge" }, description = "维护--故障知识库")
public class BreakdownKnowledgeController {

    @Autowired
    private BreakdownKnowledgeService breakdownKnowledgeService;

    @ApiOperation(value = "自动生成流水号", notes = "自动生成流水号")
    @RequestMapping(value = "createBreakdownKnowledge", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity createBreakdownKnowledge() {
        return breakdownKnowledgeService.createBreakdownKnowledge();
    }

    @ApiOperation(value = "添加故障知识", notes = "添加故障知识")
    @RequestMapping(value = "addBreakdownKnowledge", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity addBreakdownKnowledge(@RequestBody KnowledgeVo knowledgeVo) {
        return breakdownKnowledgeService.addBreakdownKnowledge(knowledgeVo);
    }

    @ApiOperation(value = "批量删除故障知识", notes = "批量删除故障知识")
    @RequestMapping(value = "deleteBreakdownKnowledge", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity deleteBreakdownKnowledge(@RequestParam(required = false)
                                                     @ApiParam(name="knowledgeIds",value="故障知识ids字符串,以逗号分隔",required=true)String knowledgeIds) {
        return breakdownKnowledgeService.deleteBreakdownKnowledge(knowledgeIds);
    }

    @ApiOperation(value = "修改故障知识", notes = "修改故障知识")
    @RequestMapping(value = "updateBreakdownKnowledge", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity updateBreakdownKnowledge(@RequestBody KnowledgeVo knowledgeVo) {
        return breakdownKnowledgeService.updateBreakdownKnowledge(knowledgeVo);
    }

    @ApiOperation(value = "浏览故障知识", notes = "浏览故障知识")
    @RequestMapping(value = "getBreakdownKnowledgeDetail", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity getBreakdownKnowledgeDetail(@RequestParam(required = false)
                                                        @ApiParam(name="knowledgeId",value="故障知识ids字符串",required=true)String knowledgeId) {
        return breakdownKnowledgeService.getBreakdownKnowledgeDetail(knowledgeId);
    }

    //分页+条件
    @ApiOperation(value = "故障知识列表查询", notes = "故障知识列表查询")
    @RequestMapping(value = "getBreakdownKnowledgeList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public PageResultEntity getBreakdownKnowledgeList(@RequestParam(defaultValue = "1")@ApiParam(name="pageNum",value="当前页",required=false)String pageNum,
                              @RequestParam(defaultValue = "10")@ApiParam(name="pageSize",value="一页记录数",required=false)String pageSize,
                              @RequestParam(required = false)@ApiParam(name="windId",value="风电场id",required=false)String windId,
                              @RequestParam(required = false)@ApiParam(name="breakdownLocation",value="故障位置id",required=false)String breakdownLocation,
                              @RequestParam(required = false)@ApiParam(name="breakdownAttribute",value="故障属性id",required=false)String breakdownAttribute,
                              @RequestParam(required = false)@ApiParam(name="breakdownDesc",value="故障描述",required=false)String breakdownDesc,
                              @RequestParam(required = false)@ApiParam(name="breakdownCode",value="故障代码",required=false)String breakdownCode) {
        Map<String,String> pageAndCondition = new HashMap();
        pageAndCondition.put("pageNum",pageNum);
        pageAndCondition.put("pageSize",pageSize);
        pageAndCondition.put("windId",windId);
        pageAndCondition.put("breakdownLocation",breakdownLocation);
        pageAndCondition.put("breakdownAttribute",breakdownAttribute);
        pageAndCondition.put("breakdownDesc",breakdownDesc);
        pageAndCondition.put("breakdownCode",breakdownCode);
        return breakdownKnowledgeService.getBreakdownKnowledgeList(pageAndCondition);
    }

}
