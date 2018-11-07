package com.qz.zframe.tickets.mapper;

import com.qz.zframe.tickets.entity.TypicalOperateTicket;
import com.qz.zframe.tickets.entity.TypicalOperateTicketExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface TypicalOperateTicketMapper {
    int countByExample(TypicalOperateTicketExample example);

    int deleteByExample(TypicalOperateTicketExample example);

    int deleteByPrimaryKey(String typicalTicketId);

    int insert(TypicalOperateTicket record);

    int insertSelective(TypicalOperateTicket record);

    int batchDelete(@Param("array") String[] ids);

    List<TypicalOperateTicket> getTypicalOperateTicketListByPC(@Param("map") Map<String, String> pageAndCondition);

    int getTotalCount(@Param("map") Map<String, String> pageAndCondition);

    List<TypicalOperateTicket> selectByExample(TypicalOperateTicketExample example);

    TypicalOperateTicket selectByPrimaryKey(String typicalTicketId);

    int updateByExampleSelective(@Param("record") TypicalOperateTicket record, @Param("example") TypicalOperateTicketExample example);

    int updateByExample(@Param("record") TypicalOperateTicket record, @Param("example") TypicalOperateTicketExample example);

    int updateByPrimaryKeySelective(TypicalOperateTicket record);

    int updateByPrimaryKey(TypicalOperateTicket record);
}