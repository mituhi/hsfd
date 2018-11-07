package com.qz.zframe.tickets.mapper;

import com.qz.zframe.tickets.entity.WorkTicketTypeUser;
import com.qz.zframe.tickets.entity.WorkTicketTypeUserExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface WorkTicketTypeUserMapper {
    int countByExample(WorkTicketTypeUserExample example);

    int deleteByExample(WorkTicketTypeUserExample example);

    int deleteByPrimaryKey(String id);

    int insert(WorkTicketTypeUser record);

    int insertSelective(WorkTicketTypeUser record);

    List<WorkTicketTypeUser> selectByExample(WorkTicketTypeUserExample example);

    WorkTicketTypeUser selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") WorkTicketTypeUser record, @Param("example") WorkTicketTypeUserExample example);

    int updateByExample(@Param("record") WorkTicketTypeUser record, @Param("example") WorkTicketTypeUserExample example);

    int updateByPrimaryKeySelective(WorkTicketTypeUser record);

    int updateByPrimaryKey(WorkTicketTypeUser record);
}