package com.qz.zframe.device.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.qz.zframe.common.util.BaseMapper;
import com.qz.zframe.device.entity.RunParameters;
import com.qz.zframe.device.entity.RunParametersExample;
@Mapper
public interface RunParametersMapper extends BaseMapper<RunParameters, RunParametersExample, Long>{
    int countByExample(RunParametersExample example);

    int deleteByExample(RunParametersExample example);

    int deleteByPrimaryKey(String runId);

    int deleteByPrimaryKeyList(List<String> runIds);
    
    int insert(RunParameters record);

    int insertSelective(RunParameters record);

    List<RunParameters> selectByExample(RunParametersExample example);

    RunParameters selectByPrimaryKey(String runId);

    int updateByExampleSelective(@Param("record") RunParameters record, @Param("example") RunParametersExample example);

    int updateByExample(@Param("record") RunParameters record, @Param("example") RunParametersExample example);

    int updateByPrimaryKeySelective(RunParameters record);

    int updateByPrimaryKey(RunParameters record);
}