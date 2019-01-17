package com.qz.zframe.maintain.mapper;

import com.qz.zframe.device.entity.vo.Breakdown;
import com.qz.zframe.device.entity.vo.BreakdownDetail;
import com.qz.zframe.device.entity.vo.Breakdowns;
import com.qz.zframe.device.entity.vo.Breakdownss;
import com.qz.zframe.maintain.entity.BreakdownInfo;
import com.qz.zframe.maintain.entity.BreakdownInfoExample;
import com.qz.zframe.maintain.vo.BreakdownVo;
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

    //批量添加
    int insertList(@Param("list") List<BreakdownVo> breakdownVoList);

    //修改故障处理方式
    int chooseDealMode(@Param("array") String[] ids, @Param("dealwithMode") String dealwithMode);

    //批量删除
    int batchDelete(@Param("array") String[] ids);

    //根据缺陷工单id批量将故障状态改回处理中
    int batchUpdate(@Param("list") List<String> workorderIdList);

    //详情查询
    BreakdownVo getBreakdownDetail(@Param("breakdownId") String breakdownId);

    //分页+条件列表查询
    List<BreakdownVo> getBreakdownList(@Param("map") Map<String, String> pageAndCondition);

    //根据条件查询总记录数
    int getTotal(@Param("map") Map<String, String> pageAndCondition);

    List<BreakdownInfo> selectByExample(BreakdownInfoExample example);

    BreakdownInfo selectByPrimaryKey(String breakdownId);

    int updateByExampleSelective(@Param("record") BreakdownInfo record, @Param("example") BreakdownInfoExample example);

    int updateByExample(@Param("record") BreakdownInfo record, @Param("example") BreakdownInfoExample example);

    int updateByPrimaryKeySelective(BreakdownInfo record);

    int updateByPrimaryKey(BreakdownInfo record);

    //按故障位置发生次数统计
    List<Breakdown> numberTroubleSite(Date activeTime, Date activeTime2);
    //按故障属性发生次数统计
    List<Breakdowns> numberTrouble(Date activeTime, Date activeTime2);
    // 按完成率统计
    List<Breakdownss> completeTrouble(Date activeTime, Date activeTime2);
    //单个风电场统计
    List<BreakdownDetail> numberTroubleDetail(Date activeTime, Date activeTime2, String windId);
    //统计故障位置发生次数故障的总数
    int countNumber(Date activeTime, Date activeTime2);
    //统计故障属性发生次数故障的总数
    int countNumbers(Date activeTime, Date activeTime2);
    // 按完成率统计
    int countNumberlist(Date activeTime, Date activeTime2);
    //单个风电场的故障总数
    int countNumberss(Date activeTime, Date activeTime2, String windId);
}