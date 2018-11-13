package com.qz.zframe.maintain.mapper;

import com.qz.zframe.maintain.entity.MaintainWorkContent;
import com.qz.zframe.maintain.entity.MaintainWorkContentExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MaintainWorkContentMapper {
    int countByExample(MaintainWorkContentExample example);

    int deleteByExample(MaintainWorkContentExample example);

    int deleteByPrimaryKey(String workContentId);

    int insert(MaintainWorkContent record);

    int insertSelective(MaintainWorkContent record);

    List<MaintainWorkContent> selectByExample(MaintainWorkContentExample example);

    MaintainWorkContent selectByPrimaryKey(String workContentId);

    int updateByExampleSelective(@Param("record") MaintainWorkContent record, @Param("example") MaintainWorkContentExample example);

    int updateByExample(@Param("record") MaintainWorkContent record, @Param("example") MaintainWorkContentExample example);

    int updateByPrimaryKeySelective(MaintainWorkContent record);

    int updateByPrimaryKey(MaintainWorkContent record);
}