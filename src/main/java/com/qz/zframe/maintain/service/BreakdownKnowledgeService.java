package com.qz.zframe.maintain.service;

import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.maintain.vo.KnowledgeVo;

import java.text.ParseException;
import java.util.Map;

public interface BreakdownKnowledgeService {

    /**
     * 添加故障知识
     */
    ResultEntity addBreakdownKnowledge(KnowledgeVo knowledgeVo) throws ParseException;

    /**
     * 修改故障知识
     */
    ResultEntity updateBreakdownKnowledge(KnowledgeVo knowledgeVo);

    /**
     * 提交故障知识
     */
    ResultEntity submitBreakdownKnowledge(KnowledgeVo knowledgeVo) throws Exception;

    /**
     * 批量删除故障知识
     */
    ResultEntity deleteBreakdownKnowledge(String[] knowledgeIds);

    /**
     * 浏览故障知识
     */
    ResultEntity getBreakdownKnowledgeDetail(String knowledgeId);

    /**
     * 故障知识分页+条件查询
     */
    PageResultEntity getBreakdownKnowledgeList(Map<String,String> pageAndCondition);

    /**
     * 审批-同意
     */
    ResultEntity agreeBreakdownKnowledge(KnowledgeVo knowledgeVo);

    /**
     * 审批-退回
     */
    ResultEntity backBreakdownKnowledge(KnowledgeVo knowledgeVo);

    /**
     * 流程状态列表查询
     */
    ResultEntity getFlowStatusList(String knowledgeId);
}
