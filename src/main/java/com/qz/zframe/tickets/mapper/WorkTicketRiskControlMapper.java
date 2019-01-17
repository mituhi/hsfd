package com.qz.zframe.tickets.mapper;

import com.qz.zframe.tickets.entity.WorkTicketRiskControl;
import com.qz.zframe.tickets.entity.WorkTicketRiskControlExample;
import com.qz.zframe.tickets.vo.WorkTicketRiskControlVo;
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

    //根据工作票id删除危险因素控制措施
    int batchDeleteByTicketIds(@Param("list") List<String> ticketIdList);

    //根据标准工作票id删除危险因素控制措施
    int batchDeleteByStandardTicketIds(@Param("array") String[] ids);

    //根据工作票id查询危险因素控制措施
    List<WorkTicketRiskControlVo> getWorkTicketRiskControlList(@Param("ticketId") String ticketId);

    //根据标准工作票id查询危险因素控制措施
    List<WorkTicketRiskControlVo> getStandardWorkTicketRiskControlList(@Param("standardTicketId") String standardTicketId);

    List<WorkTicketRiskControl> selectByExample(WorkTicketRiskControlExample example);

    WorkTicketRiskControl selectByPrimaryKey(String measureId);

    int updateByExampleSelective(@Param("record") WorkTicketRiskControl record, @Param("example") WorkTicketRiskControlExample example);

    int updateByExample(@Param("record") WorkTicketRiskControl record, @Param("example") WorkTicketRiskControlExample example);

    int updateByPrimaryKeySelective(WorkTicketRiskControl record);

    int updateByPrimaryKey(WorkTicketRiskControl record);
}