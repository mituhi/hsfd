package com.qz.zframe.run.dao;

import com.qz.zframe.run.entity.NewSchedulingAssociated;
import com.qz.zframe.run.entity.NewSchedulingAssociatedExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface NewSchedulingAssociatedMapper {
    int countByExample(NewSchedulingAssociatedExample example);

    int deleteByExample(NewSchedulingAssociatedExample example);

    int deleteByPrimaryKey(String associatedId);

    int insert(NewSchedulingAssociated record);

    int insertSelective(NewSchedulingAssociated record);

    List<NewSchedulingAssociated> selectByExample(NewSchedulingAssociatedExample example);

    NewSchedulingAssociated selectByPrimaryKey(String associatedId);

    int updateByExampleSelective(@Param("record") NewSchedulingAssociated record, @Param("example") NewSchedulingAssociatedExample example);

    int updateByExample(@Param("record") NewSchedulingAssociated record, @Param("example") NewSchedulingAssociatedExample example);

    int updateByPrimaryKeySelective(NewSchedulingAssociated record);

    int updateByPrimaryKey(NewSchedulingAssociated record);

	/**
	 * 获取最大编码
	 * 
	 * @param @return    参数
	 * @return String    返回类型
	 * @throws
	 */
	String selectMaxCoder();

	/**
	 * 将状态设为删除状态
	 * 
	 * @param @param associatedIds    参数
	 * @return void    返回类型
	 * @throws
	 */
	void updateIsDelete(List<String> associatedIds);
}