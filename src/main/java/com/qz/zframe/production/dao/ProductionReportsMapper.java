package com.qz.zframe.production.dao;

import com.qz.zframe.common.util.BaseMapper;
import com.qz.zframe.production.entity.ProductionReports;
import com.qz.zframe.production.entity.ProductionReportsExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface ProductionReportsMapper extends BaseMapper<ProductionReports, ProductionReportsExample, Long>{
    int countByExample(ProductionReportsExample example);

    int deleteByExample(ProductionReportsExample example);

    int insert(ProductionReports record);

    int insertSelective(ProductionReports record);

    List<ProductionReports> selectByExample(ProductionReportsExample example);

    int updateByExampleSelective(@Param("record") ProductionReports record, @Param("example") ProductionReportsExample example);

    int updateByExample(@Param("record") ProductionReports record, @Param("example") ProductionReportsExample example);
}