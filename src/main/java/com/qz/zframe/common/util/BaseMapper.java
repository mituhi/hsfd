package com.qz.zframe.common.util;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public abstract interface BaseMapper<T, E, PK>
{
  public abstract int countByExample(E paramE);
  
  public abstract int insertSelective(T paramT);
  
  public abstract List<T> selectByExample(E paramE);
  
  public abstract T selectByPrimaryKey(String materialId);
  
  public abstract int updateByExampleSelective(@Param("record") T paramT, @Param("example") E paramE);
  
  public abstract int updateByPrimaryKeySelective(T paramT);
}

