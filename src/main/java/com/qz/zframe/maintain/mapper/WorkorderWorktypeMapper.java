package com.qz.zframe.maintain.mapper;

import com.qz.zframe.maintain.entity.WorkorderWorktype;
import com.qz.zframe.maintain.entity.WorkorderWorktypeExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface WorkorderWorktypeMapper {
    int countByExample(WorkorderWorktypeExample example);

    int deleteByExample(WorkorderWorktypeExample example);

    int deleteByPrimaryKey(String worktypeId);

    int insert(WorkorderWorktype record);

    int insertSelective(WorkorderWorktype record);

    List<WorkorderWorktype> selectByExample(WorkorderWorktypeExample example);

    WorkorderWorktype selectByPrimaryKey(String worktypeId);

    int updateByExampleSelective(@Param("record") WorkorderWorktype record, @Param("example") WorkorderWorktypeExample example);

    int updateByExample(@Param("record") WorkorderWorktype record, @Param("example") WorkorderWorktypeExample example);

    int updateByPrimaryKeySelective(WorkorderWorktype record);

    int updateByPrimaryKey(WorkorderWorktype record);
}