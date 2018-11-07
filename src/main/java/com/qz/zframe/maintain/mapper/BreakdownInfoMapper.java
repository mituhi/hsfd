package com.qz.zframe.maintain.mapper;

import com.qz.zframe.maintain.entity.BreakdownInfo;
import com.qz.zframe.maintain.entity.BreakdownInfoExample;
import com.qz.zframe.maintain.vo.BreakdownVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface BreakdownInfoMapper {
    int countByExample(BreakdownInfoExample example);

    int deleteByExample(BreakdownInfoExample example);

    int deleteByPrimaryKey(String breakdownId);

    int insert(BreakdownInfo record);

    int insertSelective(BreakdownInfo record);

    //批量删除
    int batchDelete(@Param("array") String[] ids);
    //详情查询
    BreakdownVo getBreakdownDetail(@Param("breakdownId")String breakdownId);
    //分页+条件列表查询
    List<BreakdownVo> getBreakdownListByPageAndCondition(@Param("map")Map<String,String> pageAndCondition);
    //根据条件查询总记录数
    int getTotalCount(@Param("map")Map<String,String> pageAndCondition);

    List<BreakdownInfo> selectByExample(BreakdownInfoExample example);

    BreakdownInfo selectByPrimaryKey(String breakdownId);

    int updateByExampleSelective(@Param("record") BreakdownInfo record, @Param("example") BreakdownInfoExample example);

    int updateByExample(@Param("record") BreakdownInfo record, @Param("example") BreakdownInfoExample example);

    int updateByPrimaryKeySelective(BreakdownInfo record);

    int updateByPrimaryKey(BreakdownInfo record);
}