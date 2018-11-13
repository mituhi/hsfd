package com.qz.zframe.tickets.mapper;

import com.qz.zframe.tickets.entity.TypicalOperateTicket;
import com.qz.zframe.tickets.entity.TypicalOperateTicketExample;
import com.qz.zframe.tickets.vo.TypicalOperateTicketVo;
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
    //批量删除
    int batchDelete(@Param("array") String[] ids);
    //详情查询
    TypicalOperateTicketVo getTypicalOperateTicketDetail(@Param("typicalTicketId") String typicalTicketId);
    //列表查询
    List<TypicalOperateTicketVo> getTypicalOperateTicketList(@Param("map") Map<String, String> pageAndCondition);
    //查询总记录数
    int getTotal(@Param("map") Map<String, String> pageAndCondition);

    List<TypicalOperateTicket> selectByExample(TypicalOperateTicketExample example);

    TypicalOperateTicket selectByPrimaryKey(String typicalTicketId);

    int updateByExampleSelective(@Param("record") TypicalOperateTicket record, @Param("example") TypicalOperateTicketExample example);

    int updateByExample(@Param("record") TypicalOperateTicket record, @Param("example") TypicalOperateTicketExample example);

    int updateByPrimaryKeySelective(TypicalOperateTicket record);

    int updateByPrimaryKey(TypicalOperateTicket record);
}