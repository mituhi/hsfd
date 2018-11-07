package com.qz.zframe.tickets.mapper;

import com.qz.zframe.tickets.entity.WorkTicketRiskControl;
import com.qz.zframe.tickets.entity.WorkTicketRiskControlExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface WorkTicketRiskControlMapper {
    int countByExample(WorkTicketRiskControlExample example);

    int deleteByExample(WorkTicketRiskControlExample example);

    int deleteByPrimaryKey(String measureId);

    int insert(WorkTicketRiskControl record);

    int insertSelective(WorkTicketRiskControl record);

    List<WorkTicketRiskControl> selectByExample(WorkTicketRiskControlExample example);

    WorkTicketRiskControl selectByPrimaryKey(String measureId);

    int updateByExampleSelective(@Param("record") WorkTicketRiskControl record, @Param("example") WorkTicketRiskControlExample example);

    int updateByExample(@Param("record") WorkTicketRiskControl record, @Param("example") WorkTicketRiskControlExample example);

    int updateByPrimaryKeySelective(WorkTicketRiskControl record);

    int updateByPrimaryKey(WorkTicketRiskControl record);
}