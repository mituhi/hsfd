package com.qz.zframe.production.dao;

import com.qz.zframe.common.util.BaseMapper;
import com.qz.zframe.production.entity.ProductionWeekly;
import com.qz.zframe.production.entity.ProductionWeeklyExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface ProductionWeeklyMapper extends BaseMapper<ProductionWeekly, ProductionWeeklyExample, Long>{
    int countByExample(ProductionWeeklyExample example);

    int deleteByExample(ProductionWeeklyExample example);

    int deleteByPrimaryKeyList(List<String> weekId);
    
    int insert(ProductionWeekly record);

    int insertSelective(ProductionWeekly record);

    int updateByKey(ProductionWeekly record);
    
    List<ProductionWeekly> selectByExample(ProductionWeeklyExample example);

    ProductionWeekly    selectByKey(String weekId);
    
    int updateByExampleSelective(@Param("record") ProductionWeekly record, @Param("example") ProductionWeeklyExample example);

    int updateByExample(@Param("record") ProductionWeekly record, @Param("example") ProductionWeeklyExample example);
}