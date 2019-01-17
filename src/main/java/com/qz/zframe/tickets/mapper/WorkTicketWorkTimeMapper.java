package com.qz.zframe.tickets.mapper;

import com.qz.zframe.tickets.entity.WorkTicketWorkTime;
import com.qz.zframe.tickets.entity.WorkTicketWorkTimeExample;
import com.qz.zframe.tickets.vo.WorkTicketWorkTimeVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface WorkTicketWorkTimeMapper {
    int countByExample(WorkTicketWorkTimeExample example);

    int deleteByExample(WorkTicketWorkTimeExample example);

    int deleteByPrimaryKey(String workTimeId);

    int insert(WorkTicketWorkTime record);

    int insertSelective(WorkTicketWorkTime record);

    //根据工作票id删除危险因素控制措施
    int batchDeleteByTicketIds(@Param("list") List<String> ticketIdList);

    //根据工作票id查询每日开工和收工时间
    List<WorkTicketWorkTimeVo> getWorkTicketWorkTimeList(@Param("ticketId") String ticketId);

    List<WorkTicketWorkTime> selectByExample(WorkTicketWorkTimeExample example);

    WorkTicketWorkTime selectByPrimaryKey(String workTimeId);

    int updateByExampleSelective(@Param("record") WorkTicketWorkTime record, @Param("example") WorkTicketWorkTimeExample example);

    int updateByExample(@Param("record") WorkTicketWorkTime record, @Param("example") WorkTicketWorkTimeExample example);

    int updateByPrimaryKeySelective(WorkTicketWorkTime record);

    int updateByPrimaryKey(WorkTicketWorkTime record);
}