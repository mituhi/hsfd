package com.qz.zframe.common.util;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public abstract interface BaseMapper<T, E, PK> {

	/**
	 * 根据条件查询总条数
	 */
	public abstract int countByExample(E paramE);

	/**
	 * 插入数据
	 */
	public abstract int insertSelective(T paramT);

	/**
	 * 通过条件查询集合
	 */
	public abstract List<T> selectByExample(E paramE);

	/**
	 * 根据主键查询信息
	 */
	public abstract T selectByPrimaryKey(String materialId);

	/**
	 * 根据条件修改数据
	 */
	public abstract int updateByExampleSelective(@Param("record") T paramT, @Param("example") E paramE);

	/**
	 * 根据主键修改数据
	 */
	public abstract int updateByPrimaryKeySelective(T paramT);
}
