package com.qz.zframe.tickets.mapper;

import com.qz.zframe.common.entity.Role;
import com.qz.zframe.common.entity.UserDto;
import com.qz.zframe.maintain.vo.WorkTicketForWorkorederVo;
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

    //批量解除缺陷工单与工作票的关联
    int batchDeleteFalseByWorkorderIds(@Param("list") List<String> workorderIdList);

    //批量解除工单与工作票的关联
    int batchDeleteFalseByOrderIds(@Param("list") List<String> orderIdList);

    //批量真删除
    int batchDeleteTrue(@Param("list") List<String> ticketIdList);

    //批量假删除
    int batchDeleteFalse(@Param("list") List<String> ticketIdList);

    //详情查询
    WorkTicketVo getWorkTicketDetail(@Param("ticketId") String ticketId);

    //列表查询
    List<WorkTicketVo> getWorkTicketList(@Param("map") Map<String, String> pageAndCondition,
                                         @Param("userId") String userId,
                                         @Param("list") List<Role> userRoleList);

    //查询总记录数
    int getTotal(@Param("map") Map<String, String> pageAndCondition,
                 @Param("userId") String userId,
                 @Param("list") List<Role> userRoleList);

    //查询处理中的工作票
    List<WorkTicketVo> getWorkTicketListForWorkorder(@Param("map") Map<String, String> pageAndCondition);

    //查询处理中的工作票记录数
    int getTotalForWorkorder(@Param("map") Map<String, String> pageAndCondition);

    //工作票统计
    List<TicketStatisticsRes> getWorkTicketStatisticsList(@Param("startTime") String startTime, @Param("endTime") String endTime,
                                                          @Param("startWindCode") String startWindCode,@Param("endWindCode") String endWindCode);
    //获取缺陷工单关联的工作票
    List<WorkTicketForWorkorederVo> getDefectWorkTicketList(@Param("workorderId") String workorderId);

    //获取缺陷工单关联的工作票
    List<WorkTicketForWorkorederVo> getOrderWorkTicketList(@Param("orderId") String orderId);

    //根据用户姓名查询用户id
    List<String> getIdByName(@Param("userName") String userName);

    List<WorkTicket> selectByExample(WorkTicketExample example);

    WorkTicket selectByPrimaryKey(String ticketId);

    int updateByExampleSelective(@Param("record") WorkTicket record, @Param("example") WorkTicketExample example);

    int updateByExample(@Param("record") WorkTicket record, @Param("example") WorkTicketExample example);

    int updateByPrimaryKeySelective(WorkTicket record);

    int updateByPrimaryKey(WorkTicket record);

    List<String> findRoleByUserName(String userName);

    List<String> findFlowStatusQf();
}