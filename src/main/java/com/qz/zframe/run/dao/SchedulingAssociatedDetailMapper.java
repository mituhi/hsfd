package com.qz.zframe.run.dao;

import com.qz.zframe.run.entity.SchedulingAssociatedDetail;
import com.qz.zframe.run.entity.SchedulingAssociatedDetailExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface SchedulingAssociatedDetailMapper {
    int countByExample(SchedulingAssociatedDetailExample example);

    int deleteByExample(SchedulingAssociatedDetailExample example);

    int deleteByPrimaryKey(String associatedDetailId);

    int insert(SchedulingAssociatedDetail record);

    int insertSelective(SchedulingAssociatedDetail record);

    List<SchedulingAssociatedDetail> selectByExample(SchedulingAssociatedDetailExample example);

    SchedulingAssociatedDetail selectByPrimaryKey(String associatedDetailId);

    int updateByExampleSelective(@Param("record") SchedulingAssociatedDetail record, @Param("example") SchedulingAssociatedDetailExample example);

    int updateByExample(@Param("record") SchedulingAssociatedDetail record, @Param("example") SchedulingAssociatedDetailExample example);

    int updateByPrimaryKeySelective(SchedulingAssociatedDetail record);

    int updateByPrimaryKey(SchedulingAssociatedDetail record);

	/**
	 * 批量插入
	 * 
	 * @param @param details    参数
	 * @return void    返回类型
	 * @throws
	 */
	void insertList(List<SchedulingAssociatedDetail> details);

	/**
	 * 批量删除排班管理详情
	 * 
	 * @param @param associatedDetailIds
	 * @param @return    参数
	 * @return int    返回类型
	 * @throws
	 */
	int deleteDetails(List<String> associatedDetailIds);
}