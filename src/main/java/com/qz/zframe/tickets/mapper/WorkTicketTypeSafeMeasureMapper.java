package com.qz.zframe.tickets.mapper;

import com.qz.zframe.tickets.entity.WorkTicketTypeSafeMeasure;
import com.qz.zframe.tickets.entity.WorkTicketTypeSafeMeasureExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface WorkTicketTypeSafeMeasureMapper {
    int countByExample(WorkTicketTypeSafeMeasureExample example);

    int deleteByExample(WorkTicketTypeSafeMeasureExample example);

    int deleteByPrimaryKey(String measureId);

    int insert(WorkTicketTypeSafeMeasure record);

    int insertSelective(WorkTicketTypeSafeMeasure record);

    List<WorkTicketTypeSafeMeasure> selectByExample(WorkTicketTypeSafeMeasureExample example);

    WorkTicketTypeSafeMeasure selectByPrimaryKey(String measureId);

    int updateByExampleSelective(@Param("record") WorkTicketTypeSafeMeasure record, @Param("example") WorkTicketTypeSafeMeasureExample example);

    int updateByExample(@Param("record") WorkTicketTypeSafeMeasure record, @Param("example") WorkTicketTypeSafeMeasureExample example);

    int updateByPrimaryKeySelective(WorkTicketTypeSafeMeasure record);

    int updateByPrimaryKey(WorkTicketTypeSafeMeasure record);
}