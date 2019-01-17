package com.qz.zframe.common.dao;

import com.qz.zframe.common.entity.Process;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ProcessMapper {

    int deleteByPrimaryKey(String processId);

    int insert(Process record);

    int insertSelective(Process record);

    Process selectByPrimaryKey(String processId);

    Process getProcessByOrderIdAndType(@Param("orderId") String orderId, @Param("processType") String processType);

    int updateByPrimaryKeySelective(Process record);

    int updateByPrimaryKey(Process record);
}