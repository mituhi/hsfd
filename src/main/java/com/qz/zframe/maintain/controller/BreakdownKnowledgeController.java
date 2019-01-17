package com.qz.zframe.maintain.controller;

import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.maintain.service.BreakdownKnowledgeService;
import com.qz.zframe.maintain.vo.KnowledgeVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/maintain/knowledge")
@Api(tags = { "api-maintain-knowledge" }, description = "维护--故障知识库")
public class BreakdownKnowledgeController {

    private static Logger logger = LoggerFactory.getLogger(BreakdownKnowledgeController.class);

    @Autowired
    private BreakdownKnowledgeService breakdownKnowledgeService;

    @ApiOperation(value = "故障知识--添加", notes = "故障知识--添加")
    @RequestMapping(value = "addBreakdownKnowledge", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity addBreakdownKnowledge(@RequestBody KnowledgeVo knowledgeVo) {
        logger.info("===== 故障知识--添加 =====");
        ResultEntity resultEntity = new ResultEntity();

        try {
            resultEntity = breakdownKnowledgeService.addBreakdownKnowledge(knowledgeVo);
        } catch (ParseException e) {
            e.printStackTrace();
            resultEntity.setMsg("系统出错");
        }
        return resultEntity;
    }

    @ApiOperation(value = "故障知识--修改", notes = "故障知识--修改")
    @RequestMapping(value = "updateBreakdownKnowledge", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity updateBreakdownKnowledge(@RequestBody KnowledgeVo knowledgeVo) {
        logger.info("===== 故障知识--修改 =====");
        return breakdownKnowledgeService.updateBreakdownKnowledge(knowledgeVo);
    }

    @ApiOperation(value = "故障知识--提交", notes = "故障知识--提交")
    @RequestMapping(value = "submitBreakdownKnowledge", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity submitBreakdownKnowledge(@RequestBody KnowledgeVo knowledgeVo) {
        logger.info("===== 故障知识--提交 =====");
        ResultEntity resultEntity = null;
        try {
            resultEntity = breakdownKnowledgeService.submitBreakdownKnowledge(knowledgeVo);
        } catch (Exception e) {
            e.printStackTrace();
            resultEntity.setMsg("系统出错");
        }
        return resultEntity;
    }

    @ApiOperation(value = "故障知识--删除", notes = "故障知识--删除")
    @RequestMapping(value = "deleteBreakdownKnowledge", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity deleteBreakdownKnowledge(String[] knowledgeIds) {
        logger.info("===== 故障知识--删除 =====");
        return breakdownKnowledgeService.deleteBreakdownKnowledge(knowledgeIds);
    }

    @ApiOperation(value = "故障知识--详情查询", notes = "故障知识--详情查询")
    @RequestMapping(value = "getBreakdownKnowledgeDetail", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity getBreakdownKnowledgeDetail(@RequestParam(required = false)
                                                    @ApiParam(name="knowledgeId",value="故障知识id",required=true)String knowledgeId) {
        logger.info("===== 故障知识--详情查询 =====");
        return breakdownKnowledgeService.getBreakdownKnowledgeDetail(knowledgeId);
    }

    //分页+条件
    @ApiOperation(value = "故障知识--列表查询", notes = "故障知识--列表查询")
    @RequestMapping(value = "getBreakdownKnowledgeList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public PageResultEntity getBreakdownKnowledgeList(@RequestParam(defaultValue = "1")@ApiParam(name="pageNum",value="当前页",required=false)String pageNum,
                              @RequestParam(defaultValue = "10")@ApiParam(name="pageSize",value="一页记录数",required=false)String pageSize,
                              @RequestParam(required = false)@ApiParam(name="startWindId",value="风电场code",required=false)String startWindId,
                              @RequestParam(required = false)@ApiParam(name="endWindId",value="风电场code",required=false)String endWindId,
                              @RequestParam(required = false)@ApiParam(name="breakdownLocation",value="故障位置id",required=false)String breakdownLocation,
                              @RequestParam(required = false)@ApiParam(name="breakdownAttribute",value="故障属性id",required=false)String breakdownAttribute,
                              @RequestParam(required = false)@ApiParam(name="breakdownDesc",value="故障描述",required=false)String breakdownDesc,
                              @RequestParam(required = false)@ApiParam(name="breakdownCode",value="故障代码",required=false)String breakdownCode) {
        logger.info("===== 故障知识--列表查询 =====");
        Map<String,String> pageAndCondition = new HashMap();
        pageAndCondition.put("pageNum",pageNum);
        pageAndCondition.put("pageSize",pageSize);
        pageAndCondition.put("startWindId",startWindId);
        pageAndCondition.put("endWindId",endWindId);
        pageAndCondition.put("breakdownLocation",breakdownLocation);
        pageAndCondition.put("breakdownAttribute",breakdownAttribute);
        pageAndCondition.put("breakdownDesc",breakdownDesc);
        pageAndCondition.put("breakdownCode",breakdownCode);
        return breakdownKnowledgeService.getBreakdownKnowledgeList(pageAndCondition);
    }

    @ApiOperation(value = "故障知识--同意", notes = "故障知识--同意")
    @RequestMapping(value = "agreeBreakdownKnowledge", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity agreeBreakdownKnowledge(@RequestBody KnowledgeVo knowledgeVo) {
        logger.info("===== 故障知识--同意 =====");
        return breakdownKnowledgeService.agreeBreakdownKnowledge(knowledgeVo);
    }

    @ApiOperation(value = "故障知识--退回", notes = "故障知识--退回")
    @RequestMapping(value = "backBreakdownKnowledge", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity backBreakdownKnowledge(@RequestBody KnowledgeVo knowledgeVo) {
        logger.info("===== 故障知识--退回 =====");
        return breakdownKnowledgeService.backBreakdownKnowledge(knowledgeVo);
    }

    @ApiOperation(value = "流程状态--列表查询", notes = "流程状态--列表查询")
    @RequestMapping(value = "getFlowStatusList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity getFlowStatusList(@RequestParam(required = false)@ApiParam(name="knowledgeId",value="故障知识id",required=true) String knowledgeId) {
        logger.info("===== 流程状态--列表查询 =====");
        return breakdownKnowledgeService.getFlowStatusList(knowledgeId);
    }
}
