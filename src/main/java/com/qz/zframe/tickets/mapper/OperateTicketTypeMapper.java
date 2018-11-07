package com.qz.zframe.tickets.mapper;

import com.qz.zframe.tickets.entity.OperateTicketType;
import com.qz.zframe.tickets.entity.OperateTicketTypeExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OperateTicketTypeMapper {
    int countByExample(OperateTicketTypeExample example);

    int deleteByExample(OperateTicketTypeExample example);

    int deleteByPrimaryKey(String ticketTypeId);

    int insert(OperateTicketType record);

    int insertSelective(OperateTicketType record);

    int batchDelete(@Param("array") String[] ids);

    List<OperateTicketType> selectByExample(OperateTicketTypeExample example);

    OperateTicketType selectByPrimaryKey(String ticketTypeId);

    int updateByExampleSelective(@Param("record") OperateTicketType record, @Param("example") OperateTicketTypeExample example);

    int updateByExample(@Param("record") OperateTicketType record, @Param("example") OperateTicketTypeExample example);

    int updateByPrimaryKeySelective(OperateTicketType record);

    int updateByPrimaryKey(OperateTicketType record);
}