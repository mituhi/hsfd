package com.qz.zframe.device.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.qz.zframe.common.util.BaseMapper;
import com.qz.zframe.device.entity.Parameters;
import com.qz.zframe.device.entity.ParametersExample;
@Mapper
public interface ParametersMapper extends BaseMapper<Parameters, ParametersExample, Long>{
    int countByExample(ParametersExample example);
    int countByExample2(ParametersExample example);
    int countByExample3(ParametersExample example);
    
    int deleteByExample(ParametersExample example);

    int deleteByPrimaryKey(String parameterId);

    int deleteByPrimaryKeyList(List<String> parameterIds);
    
    int insert(Parameters record);

    int insertSelective(Parameters record);
    
    Parameters   selectByParameterCode(String parameterCode);

    List<Parameters> selectByExample(ParametersExample example);
    List<Parameters> selectByExample2(ParametersExample example);
    List<Parameters> selectByExample3(ParametersExample example);

    Parameters selectByPrimaryKey(String parameterId);

    int updateByExampleSelective(@Param("record") Parameters record, @Param("example") ParametersExample example);

    int updateByExample(@Param("record") Parameters record, @Param("example") ParametersExample example);

    int updateByPrimaryKeySelective(Parameters record);

    int updateByPrimaryKey(Parameters record);
}