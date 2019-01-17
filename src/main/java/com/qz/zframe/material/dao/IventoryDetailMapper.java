package com.qz.zframe.material.dao;

import com.qz.zframe.common.util.BaseMapper;
import com.qz.zframe.material.entity.IventoryDetail;
import com.qz.zframe.material.entity.IventoryDetailExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface IventoryDetailMapper extends BaseMapper<IventoryDetail, IventoryDetailExample, Long>{
   
}