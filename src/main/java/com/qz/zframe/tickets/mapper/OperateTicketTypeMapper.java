package com.qz.zframe.tickets.mapper;

import com.qz.zframe.tickets.entity.OperateTicketType;
import com.qz.zframe.tickets.entity.OperateTicketTypeExample;
import com.qz.zframe.tickets.vo.OperateTicketTypeVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface OperateTicketTypeMapper {
    int countByExample(OperateTicketTypeExample example);

    int deleteByExample(OperateTicketTypeExample example);

    int deleteByPrimaryKey(String operTicketTypeId);

    int insert(OperateTicketType record);

    int insertSelective(OperateTicketType record);
    //批量删除
    int batchDelete(@Param("array") String[] ids);
    //详情查询
    OperateTicketTypeVo getOperateTicketTypeDetail(@Param("ticketTypeId") String ticketTypeId);
    //列表查询
    List<OperateTicketTypeVo> getOperateTicketTypeList(@Param("map") Map<String,String> pageAndCondition);
    //查询总记录数
    int getTotal();

    List<OperateTicketType> selectByExample(OperateTicketTypeExample example);

    OperateTicketType selectByPrimaryKey(String operTicketTypeId);

    int updateByExampleSelective(@Param("record") OperateTicketType record, @Param("example") OperateTicketTypeExample example);

    int updateByExample(@Param("record") OperateTicketType record, @Param("example") OperateTicketTypeExample example);

    int updateByPrimaryKeySelective(OperateTicketType record);

    int updateByPrimaryKey(OperateTicketType record);
}