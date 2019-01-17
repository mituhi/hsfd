package com.qz.zframe.maintain.mapper;

import com.qz.zframe.maintain.entity.MaintainFile;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MaintainFileMapper {

    int deleteByPrimaryKey(String id);

    int insert(MaintainFile record);

    int insertSelective(MaintainFile record);

    MaintainFile selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(MaintainFile record);

    int updateByPrimaryKey(MaintainFile record);

    //批量新增
    int insertList(@Param("list") List<MaintainFile> attachmentList);

    //根据关联表id查询
    List<String> getMaintainFileListByAssoId(@Param("assoId") String assoId);

    //根据关联表id查询
    List<String> getMaintainFileList(@Param("assoId") String assoId,@Param("type") String type);

    //根据关联表id批量删除
    int batchDeleteByAssoId(@Param("assoId") String assoId,@Param("type") String type);

    //根据关联表id批量删除
    int deleteByFileId(@Param("fileId") String fileId);
}