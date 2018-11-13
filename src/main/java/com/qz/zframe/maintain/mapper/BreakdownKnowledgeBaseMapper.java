package com.qz.zframe.maintain.mapper;

import com.qz.zframe.maintain.entity.BreakdownKnowledgeBase;
import com.qz.zframe.maintain.entity.BreakdownKnowledgeBaseExample;
import com.qz.zframe.maintain.vo.KnowledgeVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface BreakdownKnowledgeBaseMapper {
    int countByExample(BreakdownKnowledgeBaseExample example);

    int deleteByExample(BreakdownKnowledgeBaseExample example);

    int deleteByPrimaryKey(String knowledgeId);

    int insert(BreakdownKnowledgeBase record);

    int insertSelective(BreakdownKnowledgeBase record);
    //批量删除
    int batchDelete(@Param("array") String[] ids);
    //详情查询
    KnowledgeVo getBreakdownKnowledgeDetail(@Param("knowledgeId") String knowledgeId);
    //分页+条件列表查询
    List<KnowledgeVo> getBreakdownKnowledgeListByPageAndCondition(@Param("map") Map<String, String> pageAndCondition);
    //根据条件查询总记录数
    int getTotal(@Param("map") Map<String, String> pageAndCondition);

    List<BreakdownKnowledgeBase> selectByExample(BreakdownKnowledgeBaseExample example);

    BreakdownKnowledgeBase selectByPrimaryKey(String knowledgeId);

    int updateByExampleSelective(@Param("record") BreakdownKnowledgeBase record, @Param("example") BreakdownKnowledgeBaseExample example);

    int updateByExample(@Param("record") BreakdownKnowledgeBase record, @Param("example") BreakdownKnowledgeBaseExample example);

    int updateByPrimaryKeySelective(BreakdownKnowledgeBase record);

    int updateByPrimaryKey(BreakdownKnowledgeBase record);
}