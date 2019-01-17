package com.qz.zframe.common.dao;

import com.qz.zframe.common.entity.ProcessDetailRoleRela;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProcessDetailRoleRelaMapper {

    int deleteByPrimaryKey(String relaId);

    int insert(ProcessDetailRoleRela record);

    int insertSelective(ProcessDetailRoleRela record);

    //批量添加
    int insertList(@Param("list") List<ProcessDetailRoleRela> processDetailRoleRelas);

    ProcessDetailRoleRela selectByPrimaryKey(String relaId);

    List<ProcessDetailRoleRela> getProcessDetailRoleRelaByprocessDetailId(@Param("processDetailId") String processDetailId);

    int updateByPrimaryKeySelective(ProcessDetailRoleRela record);

    int updateByPrimaryKey(ProcessDetailRoleRela record);
}