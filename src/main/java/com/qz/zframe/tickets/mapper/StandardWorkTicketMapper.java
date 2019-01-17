package com.qz.zframe.tickets.mapper;

import com.qz.zframe.tickets.entity.StandardWorkTicket;
import com.qz.zframe.tickets.entity.StandardWorkTicketExample;
import com.qz.zframe.tickets.vo.StandardWorkTicketVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface StandardWorkTicketMapper {
    int countByExample(StandardWorkTicketExample example);

    int deleteByExample(StandardWorkTicketExample example);

    int deleteByPrimaryKey(String standardTicketId);

    int insert(StandardWorkTicket record);

    int insertSelective(StandardWorkTicket record);
    //批量删除
    int batchDelete(@Param("array") String[] ids);
    //详情查询
    StandardWorkTicketVo getStandardWorkTicketDetail(@Param("standardTicketId") String standardTicketId);
    //列表查询
    List<StandardWorkTicketVo> getStandardWorkTicketList(@Param("map") Map<String,String> pageAndCondition,@Param("userId") String userId);
    //查询总记录数
    int getTotal(@Param("map") Map<String,String> pageAndCondition,@Param("userId") String userId);

    List<StandardWorkTicket> selectByExample(StandardWorkTicketExample example);

    StandardWorkTicket selectByPrimaryKey(String standardTicketId);

    int updateByExampleSelective(@Param("record") StandardWorkTicket record, @Param("example") StandardWorkTicketExample example);

    int updateByExample(@Param("record") StandardWorkTicket record, @Param("example") StandardWorkTicketExample example);

    int updateByPrimaryKeySelective(StandardWorkTicket record);

    int updateByPrimaryKey(StandardWorkTicket record);
}