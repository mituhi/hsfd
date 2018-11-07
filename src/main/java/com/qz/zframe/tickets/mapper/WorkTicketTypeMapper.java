package com.qz.zframe.tickets.mapper;

import com.qz.zframe.tickets.entity.WorkTicketType;
import com.qz.zframe.tickets.entity.WorkTicketTypeExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface WorkTicketTypeMapper {
    int countByExample(WorkTicketTypeExample example);

    int deleteByExample(WorkTicketTypeExample example);

    int deleteByPrimaryKey(String ticketTypeId);

    int insert(WorkTicketType record);

    int insertSelective(WorkTicketType record);

    int batchDelete(@Param("array") String[] ids);

    List<WorkTicketType> selectByExample(WorkTicketTypeExample example);

    WorkTicketType selectByPrimaryKey(String ticketTypeId);

    int updateByExampleSelective(@Param("record") WorkTicketType record, @Param("example") WorkTicketTypeExample example);

    int updateByExample(@Param("record") WorkTicketType record, @Param("example") WorkTicketTypeExample example);

    int updateByPrimaryKeySelective(WorkTicketType record);

    int updateByPrimaryKey(WorkTicketType record);
}