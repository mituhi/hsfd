package com.qz.zframe.run.dao;

import com.qz.zframe.run.entity.HandoverGoodsRelation;
import com.qz.zframe.run.entity.HandoverGoodsRelationExample;
import com.qz.zframe.run.entity.result.HandoverResult;
import com.qz.zframe.run.entity.submit.HandoverSearchSubmit;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface HandoverGoodsRelationMapper {
    int countByExample(HandoverGoodsRelationExample example);

    int deleteByExample(HandoverGoodsRelationExample example);

    int deleteByPrimaryKey(String handoverGoodsRelationId);

    int insert(HandoverGoodsRelation record);

    int insertSelective(HandoverGoodsRelation record);

    List<HandoverGoodsRelation> selectByExample(HandoverGoodsRelationExample example);

    HandoverGoodsRelation selectByPrimaryKey(String handoverGoodsRelationId);

    int updateByExampleSelective(@Param("record") HandoverGoodsRelation record, @Param("example") HandoverGoodsRelationExample example);

    int updateByExample(@Param("record") HandoverGoodsRelation record, @Param("example") HandoverGoodsRelationExample example);

    int updateByPrimaryKeySelective(HandoverGoodsRelation record);

    int updateByPrimaryKey(HandoverGoodsRelation record);
    
    List<HandoverResult> searchHandoverList(HandoverSearchSubmit searchSubmit);
}