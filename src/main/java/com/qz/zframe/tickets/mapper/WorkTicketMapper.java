package com.qz.zframe.tickets.mapper;

import com.qz.zframe.tickets.entity.WorkTicket;
import com.qz.zframe.tickets.entity.WorkTicketExample;
import com.qz.zframe.tickets.vo.TicketStatisticsRes;
import com.qz.zframe.tickets.vo.WorkTicketVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface WorkTicketMapper {
    int countByExample(WorkTicketExample example);

    int deleteByExample(WorkTicketExample example);

    int deleteByPrimaryKey(String ticketId);

    int insert(WorkTicket record);

    int insertSelective(WorkTicket record);
    //批量删除
    int batchDelete(@Param("array") String[] ids);
    //详情查询
    WorkTicketVo getWorkTicketDetail(@Param("ticketId") String ticketId);
    //列表查询
    List<WorkTicketVo> getWorkTicketList(@Param("map") Map<String, String> pageAndCondition);
    //查询总记录数
    int getTotal(@Param("map") Map<String, String> pageAndCondition);
    //工作票统计
    List<TicketStatisticsRes> getWorkTicketStatisticsList(@Param("startTime") String startTime, @Param("endTime") String endTime);

    List<WorkTicket> selectByExample(WorkTicketExample example);

    WorkTicket selectByPrimaryKey(String ticketId);

    int updateByExampleSelective(@Param("record") WorkTicket record, @Param("example") WorkTicketExample example);

    int updateByExample(@Param("record") WorkTicket record, @Param("example") WorkTicketExample example);

    int updateByPrimaryKeySelective(WorkTicket record);

    int updateByPrimaryKey(WorkTicket record);
}