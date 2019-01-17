package com.qz.zframe.material.dao;

import com.qz.zframe.common.util.BaseMapper;
import com.qz.zframe.material.entity.ScrapDetail;
import com.qz.zframe.material.entity.ScrapDetailExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ScrapDetailMapper extends BaseMapper<ScrapDetail, ScrapDetailExample, Long> {
  
}