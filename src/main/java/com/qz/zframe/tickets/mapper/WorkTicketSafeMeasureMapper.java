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

    //根据工作票类型id删除安全措施
    int batchDeleteByWorkTicketTypeIds(@Param("array") String[] ids);

    //根据标准工作票id删除安全措施
    int batchDeleteByStandardTicketIds(@Param("array") String[] ids);

    //根据工作票id删除安全措施
    int batchDeleteByTicketIds(@Param("list") List<String> ticketIdList);

    List<WorkTicketSafeMeasure> selectByExample(WorkTicketSafeMeasureExample example);

    WorkTicketSafeMeasure selectByPrimaryKey(String safeId);

    int updateByExampleSelective(@Param("record") WorkTicketSafeMeasure record, @Param("example") WorkTicketSafeMeasureExample example);

    int updateByExample(@Param("record") WorkTicketSafeMeasure record, @Param("example") WorkTicketSafeMeasureExample example);

    int updateByPrimaryKeySelective(WorkTicketSafeMeasure record);

    int updateByPrimaryKey(WorkTicketSafeMeasure record);
}