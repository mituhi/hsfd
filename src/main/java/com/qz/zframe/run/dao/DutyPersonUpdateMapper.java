package com.qz.zframe.run.dao;

import com.qz.zframe.run.entity.DutyPersonUpdate;
import com.qz.zframe.run.entity.DutyPersonUpdateExample;
import com.qz.zframe.run.entity.result.SchedulingQueryResult;
import com.qz.zframe.run.entity.submit.DutyPersonUpdateSubmit;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface DutyPersonUpdateMapper {
    int countByExample(DutyPersonUpdateExample example);

    int deleteByExample(DutyPersonUpdateExample example);

    int deleteByPrimaryKey(String dutyPersonUpdateId);

    int insert(DutyPersonUpdate record);

    int insertSelective(DutyPersonUpdate record);

    List<DutyPersonUpdate> selectByExample(DutyPersonUpdateExample example);

    DutyPersonUpdate selectByPrimaryKey(String dutyPersonUpdateId);

    int updateByExampleSelective(@Param("record") DutyPersonUpdate record, @Param("example") DutyPersonUpdateExample example);

    int updateByExample(@Param("record") DutyPersonUpdate record, @Param("example") DutyPersonUpdateExample example);

    int updateByPrimaryKeySelective(DutyPersonUpdate record);

    int updateByPrimaryKey(DutyPersonUpdate record);
    
    //搞不清楚为什么报错！！！！
    //int addDutyPersonUpdate(List<DutyPersonUpdate> dutyPersonUpdates);
    
    List<SchedulingQueryResult> listDutyPersonUpdate(DutyPersonUpdateSubmit dutyPersonUpdateSubmit);

    List<SchedulingQueryResult> listSchedulingQuery(DutyPersonUpdateSubmit dutyPersonUpdateSubmit);
    
    int addDutyPersonUpdateList(List<DutyPersonUpdate> dutyPersonUpdates);
    
    
}