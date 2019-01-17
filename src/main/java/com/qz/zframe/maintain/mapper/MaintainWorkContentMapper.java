package com.qz.zframe.maintain.mapper;

import com.qz.zframe.maintain.entity.MaintainWorkContent;
import com.qz.zframe.maintain.entity.MaintainWorkContentExample;
import com.qz.zframe.maintain.vo.MaintainWorkContentVo;
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
    //获取当日工作
    List<MaintainWorkContentVo> getToDayWorkContent(@Param("dayId") String dayId);
    //获取昨日工作
    List<MaintainWorkContentVo> getYesterDayWorkContent(@Param("dayId") String dayId);
    //获取本周工作
    List<MaintainWorkContentVo> getThisWeekWorkContent(@Param("weekId") String weekId);
    //获取上周工作
    List<MaintainWorkContentVo> getLastWeekWorkContent(@Param("wekkId") String wekkId);

    List<MaintainWorkContent> selectByExample(MaintainWorkContentExample example);

    MaintainWorkContent selectByPrimaryKey(String workContentId);

    int updateByExampleSelective(@Param("record") MaintainWorkContent record, @Param("example") MaintainWorkContentExample example);

    int updateByExample(@Param("record") MaintainWorkContent record, @Param("example") MaintainWorkContentExample example);

    int updateByPrimaryKeySelective(MaintainWorkContent record);

    int updateByPrimaryKey(MaintainWorkContent record);
}