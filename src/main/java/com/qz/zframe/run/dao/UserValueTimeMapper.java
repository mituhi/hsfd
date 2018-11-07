package com.qz.zframe.run.dao;

import com.qz.zframe.run.entity.UserValueTime;
import com.qz.zframe.run.entity.UserValueTimeExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserValueTimeMapper {
    int countByExample(UserValueTimeExample example);

    int deleteByExample(UserValueTimeExample example);

    int deleteByPrimaryKey(String id);

    int insert(UserValueTime record);

    int insertSelective(UserValueTime record);

    List<UserValueTime> selectByExample(UserValueTimeExample example);

    UserValueTime selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") UserValueTime record, @Param("example") UserValueTimeExample example);

    int updateByExample(@Param("record") UserValueTime record, @Param("example") UserValueTimeExample example);

    int updateByPrimaryKeySelective(UserValueTime record);

    int updateByPrimaryKey(UserValueTime record);

	void deleteUserValueTimeByValueId(List<String> ids);
}