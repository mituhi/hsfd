package com.qz.zframe.tickets.mapper;

import com.qz.zframe.common.entity.Role;
import com.qz.zframe.maintain.vo.OperateTicketForWorkorderVo;
import com.qz.zframe.tickets.entity.OperateTicket;
import com.qz.zframe.tickets.entity.OperateTicketExample;
import com.qz.zframe.tickets.vo.OperateTicketVo;
import com.qz.zframe.tickets.vo.TicketStatisticsRes;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface OperateTicketMapper {
    int countByExample(OperateTicketExample example);

    int deleteByExample(OperateTicketExample example);

    int deleteByPrimaryKey(String ticketId);

    int insert(OperateTicket record);

    int insertSelective(OperateTicket record);

    //批量解除缺陷工单与操作票的关联
    int batchDeleteFalseByWorkorderIds(@Param("list") List<String> workorderIdList);

    //批量解除工单与操作票的关联
    int batchDeleteFalseByOrderIds(@Param("list") List<String> orderIdList);

    //批量删除
    int batchDeleteTrue(@Param("list") List<String> ticketIdList);
    //批量删除
    int batchDeleteFalse(@Param("list") List<String> ticketIdList);
    //详情查询
    OperateTicketVo getOperateTicketDetail(@Param("ticketId") String ticketId);
    //列表查询
    List<OperateTicketVo> getOperateTicketList(@Param("map") Map<String, String> pageAndCondition,
                                               @Param("userId") String userId,
                                               @Param("list") List<Role> userRoleList);
    //查询总记录数
    int getTotal(@Param("map") Map<String, String> pageAndCondition,
                 @Param("userId") String userId,
                 @Param("list") List<Role> userRoleList);
    //列表查询
    List<OperateTicketVo> getOperateTicketListForWorkorder(@Param("map") Map<String, String> pageAndCondition);
    //查询总记录数
    int getTotalForWorkorder(@Param("map") Map<String, String> pageAndCondition);
    //操作票统计
    List<TicketStatisticsRes> getOperateTicketStatisticsList(@Param("startTime") String startTime, @Param("endTime") String endTime,
                                                             @Param("startWindCode") String startWindCode,@Param("endWindCode") String endWindCode);
    //获取缺陷工单关联的工作票
    List<OperateTicketForWorkorderVo> getDefectOperTicketList(@Param("workorderId") String workorderId);
    //获取工单关联的工作票
    List<OperateTicketForWorkorderVo> getOrderOperTicketList(@Param("orderId") String orderId);

    List<OperateTicket> selectByExample(OperateTicketExample example);

    OperateTicket selectByPrimaryKey(String ticketId);

    int updateByExampleSelective(@Param("record") OperateTicket record, @Param("example") OperateTicketExample example);

    int updateByExample(@Param("record") OperateTicket record, @Param("example") OperateTicketExample example);

    int updateByPrimaryKeySelective(OperateTicket record);

    int updateByPrimaryKey(OperateTicket record);
}