package com.qz.zframe.device.service;

import java.util.List;

import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.device.entity.EquipmentLog;

public interface EquipmentLogService {
    //查看维护信息
	 public	PageResultEntity findEquipmentLog(Integer pagenum,Integer PageSize);
	 public  ResultEntity  addEquipmentLog(EquipmentLog equipmentLog);
	 //修改设备分类
	 public   ResultEntity  updateEquipmentLog(EquipmentLog equipmentLog);
	  //删除设备分类
	 public   ResultEntity  deleteEquipmentLog(List<String> logIds);
	 //查询设备分类详情
	 public  PageResultEntity  findById(String logId);
}
