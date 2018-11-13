package com.qz.zframe.maintain.mapper;

import com.qz.zframe.device.entity.vo.Breakdown;
import com.qz.zframe.device.entity.vo.BreakdownDetail;
import com.qz.zframe.maintain.entity.BreakdownInfo;
import com.qz.zframe.maintain.entity.BreakdownInfoExample;
import com.qz.zframe.maintain.vo.BreakdownRes;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
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
    BreakdownRes getBreakdownDetail(@Param("breakdownId") String breakdownId);
    //分页+条件列表查询
    List<BreakdownRes> getBreakdownListByPageAndCondition(@Param("map") Map<String, String> pageAndCondition);
    //根据条件查询总记录数
    int getTotal(@Param("map") Map<String, String> pageAndCondition);

    List<BreakdownInfo> selectByExample(BreakdownInfoExample example);

    BreakdownInfo selectByPrimaryKey(String breakdownId);

    int updateByExampleSelective(@Param("record") BreakdownInfo record, @Param("example") BreakdownInfoExample example);

    int updateByExample(@Param("record") BreakdownInfo record, @Param("example") BreakdownInfoExample example);

    int updateByPrimaryKeySelective(BreakdownInfo record);

    int updateByPrimaryKey(BreakdownInfo record);
    //按故障位置发生次数统计
    List<Breakdown> numberTroubleSite(Date activeTime,Date activeTime2);
    //按故障属性发生次数统计
    List<Breakdown> numberTrouble(Date activeTime,Date activeTime2);
    // 按完成率统计
    List<Breakdown> completeTrouble(Date activeTime,Date activeTime2);
    //单个风电场统计
    List<BreakdownDetail> numberTroubleDetail(Date activeTime,Date activeTime2,String windId);
    //统计故障位置发生次数故障的总数
    int countNumber(Date activeTime,Date activeTime2);
    //统计故障属性发生次数故障的总数
    int countNumbers(Date activeTime,Date activeTime2);
}