package com.qz.zframe.maintain.mapper;

import com.qz.zframe.maintain.entity.MaintainLogInfo;
import com.qz.zframe.maintain.entity.MaintainLogInfoExample;
import com.qz.zframe.maintain.vo.MaintainLogVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface MaintainLogInfoMapper {
    int countByExample(MaintainLogInfoExample example);

    int deleteByExample(MaintainLogInfoExample example);

    int deleteByPrimaryKey(String dayId);

    int insert(MaintainLogInfo record);

    int insertSelective(MaintainLogInfo record);
    //批量删除
    int batchDelete(@Param("array") String[] ids);
    //详情查询
    MaintainLogVo getMaintainLogDetail(@Param("dayId") String dayId);
    //分页+条件列表查询
    List<MaintainLogVo> getMaintainLogList(@Param("map") Map<String, String> pageAndCondition);
    //根据条件查询总记录数
    int getTotal(@Param("map") Map<String, String> pageAndCondition);

    List<MaintainLogInfo> selectByExample(MaintainLogInfoExample example);

    MaintainLogInfo selectByPrimaryKey(String dayId);

    int updateByExampleSelective(@Param("record") MaintainLogInfo record, @Param("example") MaintainLogInfoExample example);

    int updateByExample(@Param("record") MaintainLogInfo record, @Param("example") MaintainLogInfoExample example);

    int updateByPrimaryKeySelective(MaintainLogInfo record);

    int updateByPrimaryKey(MaintainLogInfo record);
}