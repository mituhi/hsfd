package com.qz.zframe.tickets.mapper;

import com.qz.zframe.tickets.entity.OperateItems;
import com.qz.zframe.tickets.entity.OperateItemsExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OperateItemsMapper {
    int countByExample(OperateItemsExample example);

    int deleteByExample(OperateItemsExample example);

    int deleteByPrimaryKey(String itemId);

    int insert(OperateItems record);

    int insertSelective(OperateItems record);

    List<OperateItems> selectByExample(OperateItemsExample example);

    OperateItems selectByPrimaryKey(String itemId);

    int updateByExampleSelective(@Param("record") OperateItems record, @Param("example") OperateItemsExample example);

    int updateByExample(@Param("record") OperateItems record, @Param("example") OperateItemsExample example);

    int updateByPrimaryKeySelective(OperateItems record);

    int updateByPrimaryKey(OperateItems record);
}