package com.qz.zframe.maintain.service;

import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.maintain.vo.KnowledgeVo;

import java.util.Map;

public interface BreakdownKnowledgeService {

    /**
     * 自动生成流水号
     */
    public ResultEntity createBreakdownKnowledge();

    /**
     * 添加故障知识
     */
    public ResultEntity addBreakdownKnowledge(KnowledgeVo knowledgeVo);

    /**
     * 批量删除故障知识
     */
    public ResultEntity deleteBreakdownKnowledge(String knowledgeIds);

    /**
     * 修改故障知识
     */
    public ResultEntity updateBreakdownKnowledge(KnowledgeVo knowledgeVo);

    /**
     * 浏览故障知识
     */
    public ResultEntity getBreakdownKnowledgeDetail(String knowledgeId);

    /**
     * 故障知识分页+条件查询
     */
    public PageResultEntity getBreakdownKnowledgeList(Map<String,String> pageAndCondition);
}
