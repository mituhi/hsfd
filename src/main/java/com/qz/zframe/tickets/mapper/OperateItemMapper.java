package com.qz.zframe.tickets.mapper;

import com.qz.zframe.tickets.entity.OperateItem;
import com.qz.zframe.tickets.entity.OperateItemExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OperateItemMapper {
    int countByExample(OperateItemExample example);

    int deleteByExample(OperateItemExample example);

    int deleteByPrimaryKey(String itemId);

    int insert(OperateItem record);

    int insertSelective(OperateItem record);

    //根据操作票ids删除操作项
    int batchDeleteByTicketIds(@Param("list") List<String> ticketIdList);

    //根据典型操作票ids删除操作项
    int batchDeleteByTypicalTicketIds(@Param("array") String[] ids);

    List<OperateItem> selectByExample(OperateItemExample example);

    OperateItem selectByPrimaryKey(String itemId);

    int updateByExampleSelective(@Param("record") OperateItem record, @Param("example") OperateItemExample example);

    int updateByExample(@Param("record") OperateItem record, @Param("example") OperateItemExample example);

    int updateByPrimaryKeySelective(OperateItem record);

    int updateByPrimaryKey(OperateItem record);
}