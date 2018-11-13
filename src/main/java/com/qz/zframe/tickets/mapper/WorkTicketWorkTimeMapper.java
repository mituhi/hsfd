package com.qz.zframe.tickets.mapper;

import com.qz.zframe.tickets.entity.WorkTicketWorkTime;
import com.qz.zframe.tickets.entity.WorkTicketWorkTimeExample;
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

    List<WorkTicketWorkTime> selectByExample(WorkTicketWorkTimeExample example);

    WorkTicketWorkTime selectByPrimaryKey(String workTimeId);

    int updateByExampleSelective(@Param("record") WorkTicketWorkTime record, @Param("example") WorkTicketWorkTimeExample example);

    int updateByExample(@Param("record") WorkTicketWorkTime record, @Param("example") WorkTicketWorkTimeExample example);

    int updateByPrimaryKeySelective(WorkTicketWorkTime record);

    int updateByPrimaryKey(WorkTicketWorkTime record);
}