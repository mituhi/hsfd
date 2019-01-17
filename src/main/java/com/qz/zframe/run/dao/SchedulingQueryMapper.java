package com.qz.zframe.run.dao;

import com.qz.zframe.run.entity.SchedulingQuery;
import com.qz.zframe.run.entity.SchedulingQueryExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface SchedulingQueryMapper {
    int countByExample(SchedulingQueryExample example);

    int deleteByExample(SchedulingQueryExample example);

    int insert(SchedulingQuery record);

    int insertSelective(SchedulingQuery record);

    List<SchedulingQuery> selectByExample(SchedulingQueryExample example);

    int updateByExampleSelective(@Param("record") SchedulingQuery record, @Param("example") SchedulingQueryExample example);

    int updateByExample(@Param("record") SchedulingQuery record, @Param("example") SchedulingQueryExample example);

	List<SchedulingQuery> selectSchedulingQuery(SchedulingQuery schedulingQuery);
	
	List<SchedulingQuery> queryOperator(SchedulingQuery schedulingQuery);
	
	int updateOperator(SchedulingQuery schedulingQuery);
	
	List<SchedulingQuery> selectSchedulingQueryWithUserName(SchedulingQuery schedulingQuery);
	
}