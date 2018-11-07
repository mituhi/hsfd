package com.qz.zframe.device.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.qz.zframe.common.util.BaseMapper;
import com.qz.zframe.device.entity.OutputParameters;
import com.qz.zframe.device.entity.OutputParametersExample;
@Mapper
public interface OutputParametersMapper extends BaseMapper<OutputParameters, OutputParametersExample, Long>{
    int countByExample(OutputParametersExample example);

    int deleteByExample(OutputParametersExample example);

    int deleteByPrimaryKey(String outputId);

    int deleteByPrimaryKeyList(List<String> outputds);
    
    int insert(OutputParameters record);

    int insertSelective(OutputParameters record);

    List<OutputParameters> selectByExample(OutputParametersExample example);

    OutputParameters selectByPrimaryKey(String outputId);

    int updateByExampleSelective(@Param("record") OutputParameters record, @Param("example") OutputParametersExample example);

    int updateByExample(@Param("record") OutputParameters record, @Param("example") OutputParametersExample example);

    int updateByPrimaryKeySelective(OutputParameters record);

    int updateByPrimaryKey(OutputParameters record);
}