package com.qz.zframe.device.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.qz.zframe.device.entity.EquipmentLog;

@Mapper
public interface EquipmentLogMapper{

	void insertAdd(EquipmentLog equipmentLog);
	
	int  update(EquipmentLog equipmentLog);
	
	int delete (List<String> logIds);
	
	EquipmentLog  select(String logId);
	
	List<EquipmentLog> selectList(Integer pageNum,Integer pageSize);
}
