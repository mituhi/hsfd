package com.qz.zframe.maintain.mapper;

import com.qz.zframe.maintain.entity.MaintainOperateRecord;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MaintainOperateRecordMapper {

    int deleteByPrimaryKey(String id);

    int insert(MaintainOperateRecord record);

    int insertSelective(MaintainOperateRecord record);

    MaintainOperateRecord selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(MaintainOperateRecord record);

    int updateByPrimaryKey(MaintainOperateRecord record);
}