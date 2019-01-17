package com.qz.zframe.tickets.mapper;

import com.qz.zframe.tickets.entity.TicketsOperateRecord;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TicketsOperateRecordMapper {

    int deleteByPrimaryKey(String id);

    int insert(TicketsOperateRecord record);

    int insertSelective(TicketsOperateRecord record);

    TicketsOperateRecord selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TicketsOperateRecord record);

    int updateByPrimaryKey(TicketsOperateRecord record);
}