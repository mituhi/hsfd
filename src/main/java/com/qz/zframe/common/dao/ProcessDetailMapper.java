package com.qz.zframe.common.dao;

import com.qz.zframe.common.entity.ProcessDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProcessDetailMapper {

    int deleteByPrimaryKey(String processDetailId);

    int insert(ProcessDetail record);

    int insertSelective(ProcessDetail record);

    int insertList(@Param("list") List<ProcessDetail> processDetails);

    ProcessDetail selectByPrimaryKey(String processDetailId);

    ProcessDetail getProcessDetailByProcessIdAndsort(@Param("processId") String processId,@Param("sort") String sort);

    List<ProcessDetail> getProcessDetailByProcessId(@Param("processId") String processId);

    //获取流程详情总步数
    int getTotalSort(@Param("processId") String processId);

    int updateByPrimaryKeySelective(ProcessDetail record);

    int updateByPrimaryKey(ProcessDetail record);
}