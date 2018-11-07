package com.qz.zframe.maintain.mapper;

import com.qz.zframe.maintain.entity.WorkorderType;
import com.qz.zframe.maintain.entity.WorkorderTypeExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface WorkorderTypeMapper {
    int countByExample(WorkorderTypeExample example);

    int deleteByExample(WorkorderTypeExample example);

    int deleteByPrimaryKey(String workorderTypeId);

    int insert(WorkorderType record);

    int insertSelective(WorkorderType record);
    //批量删除
    int batchDelete(@Param("array") String[] ids);

    List<WorkorderType> selectByExample(WorkorderTypeExample example);

    WorkorderType selectByPrimaryKey(String workorderTypeId);

    int updateByExampleSelective(@Param("record") WorkorderType record, @Param("example") WorkorderTypeExample example);

    int updateByExample(@Param("record") WorkorderType record, @Param("example") WorkorderTypeExample example);

    int updateByPrimaryKeySelective(WorkorderType record);

    int updateByPrimaryKey(WorkorderType record);
}