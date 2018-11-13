package com.qz.zframe.tickets.mapper;

import com.qz.zframe.tickets.entity.WorkTicketType;
import com.qz.zframe.tickets.entity.WorkTicketTypeExample;
import com.qz.zframe.tickets.vo.WorkTicketTypeVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface WorkTicketTypeMapper {
    int countByExample(WorkTicketTypeExample example);

    int deleteByExample(WorkTicketTypeExample example);

    int deleteByPrimaryKey(String workTicketTypeId);

    int insert(WorkTicketType record);

    int insertSelective(WorkTicketType record);
    //批量删除
    int batchDelete(@Param("array") String[] ids);
    //详情查询
    WorkTicketTypeVo getWorkTicketTypeDetail(@Param("workTicketTypeId")String workTicketTypeId);
    //列表查询
    List<WorkTicketTypeVo> getWorkTicketTypeList(@Param("map")Map<String,String> pageAndCondition);
    //查询总记录数
    int getTotal();

    List<WorkTicketType> selectByExample(WorkTicketTypeExample example);

    WorkTicketType selectByPrimaryKey(String workTicketTypeId);

    int updateByExampleSelective(@Param("record") WorkTicketType record, @Param("example") WorkTicketTypeExample example);

    int updateByExample(@Param("record") WorkTicketType record, @Param("example") WorkTicketTypeExample example);

    int updateByPrimaryKeySelective(WorkTicketType record);

    int updateByPrimaryKey(WorkTicketType record);
}