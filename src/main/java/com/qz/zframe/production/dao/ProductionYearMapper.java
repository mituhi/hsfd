package com.qz.zframe.production.dao;

import com.qz.zframe.common.util.BaseMapper;
import com.qz.zframe.production.entity.ProductionYear;
import com.qz.zframe.production.entity.ProductionYearExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface ProductionYearMapper extends BaseMapper<ProductionYear, ProductionYearExample, Long>{
    int countByExample(ProductionYearExample example);

    int deleteByExample(ProductionYearExample example);

    List<ProductionYear> insert(ProductionYear record);

    int insertSelective(ProductionYear record);

    List<ProductionYear> selectByExample(ProductionYearExample example);

    int updateByExampleSelective(@Param("record") ProductionYear record, @Param("example") ProductionYearExample example);

    int updateByExample(@Param("record") ProductionYear record, @Param("example") ProductionYearExample example);
}