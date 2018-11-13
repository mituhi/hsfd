package com.qz.zframe.tickets.mapper;

import com.qz.zframe.tickets.entity.UserAssoInfo;
import com.qz.zframe.tickets.entity.UserAssoInfoExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserAssoInfoMapper {
    int countByExample(UserAssoInfoExample example);

    int deleteByExample(UserAssoInfoExample example);

    int deleteByPrimaryKey(String assoId);

    int insert(UserAssoInfo record);

    int insertSelective(UserAssoInfo record);

    List<UserAssoInfo> selectByExample(UserAssoInfoExample example);

    UserAssoInfo selectByPrimaryKey(String assoId);

    int updateByExampleSelective(@Param("record") UserAssoInfo record, @Param("example") UserAssoInfoExample example);

    int updateByExample(@Param("record") UserAssoInfo record, @Param("example") UserAssoInfoExample example);

    int updateByPrimaryKeySelective(UserAssoInfo record);

    int updateByPrimaryKey(UserAssoInfo record);
}