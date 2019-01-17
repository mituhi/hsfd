package com.qz.zframe.material.dao;

import com.qz.zframe.common.util.BaseMapper;
import com.qz.zframe.material.entity.GuestOffer;
import com.qz.zframe.material.entity.GuestOfferExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface GuestOfferMapper extends BaseMapper<GuestOffer, GuestOfferExample, Long>{
   
}