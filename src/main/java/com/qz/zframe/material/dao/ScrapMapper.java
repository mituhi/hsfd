package com.qz.zframe.material.dao;

import com.qz.zframe.common.util.BaseMapper;
import com.qz.zframe.material.entity.Scrap;
import com.qz.zframe.material.entity.ScrapExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ScrapMapper extends BaseMapper<Scrap, ScrapExample, Long>{
   
}