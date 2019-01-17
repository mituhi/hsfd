package com.qz.zframe.production.dao;

import com.qz.zframe.common.util.BaseMapper;
import com.qz.zframe.production.entity.MonthStatistics;
import com.qz.zframe.production.entity.ProductionMonth;
import com.qz.zframe.production.entity.ProductionMonthExample;
import com.qz.zframe.production.entity.ProductionWeekly;
import com.qz.zframe.production.entity.ProductionWeeklyExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface ProductionMonthMapper  extends BaseMapper<ProductionMonth, ProductionMonthExample, Long>{
	int countByExample(ProductionMonthExample example);

    int deleteByExample(ProductionMonthExample example);

    int deleteByPrimaryKeyList(List<String> monthIds);
    
    int insert(ProductionMonth record);

    int insertSelective(ProductionMonth record);
    
    int updateByPrimaryKey(ProductionMonth record);
    
    List<ProductionMonth> selectByExample(ProductionMonthExample example);
    
    ProductionMonth  selectByPrimaryKey(String monthId);
    
    MonthStatistics   selectByYearAndWindId(String year,String windId);
    
    int updateByExampleSelective(@Param("record") ProductionMonth record, @Param("example") ProductionMonthExample example);

    int updateByExample(@Param("record") ProductionMonth record, @Param("example") ProductionMonthExample example);
}