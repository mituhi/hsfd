package com.qz.zframe.tickets.mapper;

import com.qz.zframe.tickets.entity.StandardWorkTicket;
import com.qz.zframe.tickets.entity.StandardWorkTicketExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StandardWorkTicketMapper {
    int countByExample(StandardWorkTicketExample example);

    int deleteByExample(StandardWorkTicketExample example);

    int deleteByPrimaryKey(String standardTicketId);

    int insert(StandardWorkTicket record);

    int insertSelective(StandardWorkTicket record);

    int batchDelete(@Param("array") String[] ids);

    List<StandardWorkTicket> selectByExample(StandardWorkTicketExample example);

    StandardWorkTicket selectByPrimaryKey(String standardTicketId);

    int updateByExampleSelective(@Param("record") StandardWorkTicket record, @Param("example") StandardWorkTicketExample example);

    int updateByExample(@Param("record") StandardWorkTicket record, @Param("example") StandardWorkTicketExample example);

    int updateByPrimaryKeySelective(StandardWorkTicket record);

    int updateByPrimaryKey(StandardWorkTicket record);
}