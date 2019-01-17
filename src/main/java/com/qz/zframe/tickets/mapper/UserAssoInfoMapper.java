package com.qz.zframe.tickets.mapper;

import com.qz.zframe.tickets.entity.UserAssoInfo;
import com.qz.zframe.tickets.entity.UserAssoInfoExample;
import com.qz.zframe.tickets.vo.UserAssoVo;
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

    //根据工作票类型id删除工作负责人,签发人.许可人
    int batchDelete1(@Param("array") String[] ids);

    //根据操作票类型id删除操作人,监护人
    int batchDelete2(@Param("array") String[] ids);

    //根据工作票类型id列表查询
    List<UserAssoVo> getUserAssoVoListByWorkTicketType(@Param("workTicketTypeId") String workTicketTypeId,@Param("userType") String userType);

    //根据操作票类型id列表查询
    List<UserAssoVo> getUserAssoVoListByOperTicketType(@Param("operTicketTypeId") String operTicketTypeId,@Param("userType") String userType);

    List<UserAssoInfo> selectByExample(UserAssoInfoExample example);

    UserAssoInfo selectByPrimaryKey(String assoId);

    int updateByExampleSelective(@Param("record") UserAssoInfo record, @Param("example") UserAssoInfoExample example);

    int updateByExample(@Param("record") UserAssoInfo record, @Param("example") UserAssoInfoExample example);

    int updateByPrimaryKeySelective(UserAssoInfo record);

    int updateByPrimaryKey(UserAssoInfo record);
}