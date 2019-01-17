package com.qz.zframe.common.dao;

import com.qz.zframe.common.entity.ApproveRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ApproveRecordMapper {

    int deleteByPrimaryKey(String approveId);

    int insert(ApproveRecord record);

    int insertSelective(ApproveRecord record);

    ApproveRecord selectByPrimaryKey(String approveId);

    List<ApproveRecord> getApproveRecordListByOrderId(@Param("orderId") String orderId);

    int updateByPrimaryKeySelective(ApproveRecord record);

    int updateByPrimaryKey(ApproveRecord record);
}