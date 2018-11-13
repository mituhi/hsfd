package com.qz.zframe.run.dao;

import com.qz.zframe.run.entity.ImportantMatter;
import com.qz.zframe.run.entity.ImportantMatterExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ImportantMatterMapper {
    int countByExample(ImportantMatterExample example);

    int deleteByExample(ImportantMatterExample example);

    int deleteByPrimaryKey(String matterId);

    int insert(ImportantMatter record);

    int insertSelective(ImportantMatter record);

    List<ImportantMatter> selectByExample(ImportantMatterExample example);

    ImportantMatter selectByPrimaryKey(String matterId);

    int updateByExampleSelective(@Param("record") ImportantMatter record, @Param("example") ImportantMatterExample example);

    int updateByExample(@Param("record") ImportantMatter record, @Param("example") ImportantMatterExample example);

    int updateByPrimaryKeySelective(ImportantMatter record);

    int updateByPrimaryKey(ImportantMatter record);
}