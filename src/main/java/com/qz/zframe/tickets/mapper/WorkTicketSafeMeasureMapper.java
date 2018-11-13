package com.qz.zframe.tickets.mapper;

import com.qz.zframe.tickets.entity.WorkTicketSafeMeasure;
import com.qz.zframe.tickets.entity.WorkTicketSafeMeasureExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface WorkTicketSafeMeasureMapper {
    int countByExample(WorkTicketSafeMeasureExample example);

    int deleteByExample(WorkTicketSafeMeasureExample example);

    int deleteByPrimaryKey(String safeId);

    int insert(WorkTicketSafeMeasure record);

    int insertSelective(WorkTicketSafeMeasure record);

    List<WorkTicketSafeMeasure> selectByExample(WorkTicketSafeMeasureExample example);

    WorkTicketSafeMeasure selectByPrimaryKey(String safeId);

    int updateByExampleSelective(@Param("record") WorkTicketSafeMeasure record, @Param("example") WorkTicketSafeMeasureExample example);

    int updateByExample(@Param("record") WorkTicketSafeMeasure record, @Param("example") WorkTicketSafeMeasureExample example);

    int updateByPrimaryKeySelective(WorkTicketSafeMeasure record);

    int updateByPrimaryKey(WorkTicketSafeMeasure record);
}