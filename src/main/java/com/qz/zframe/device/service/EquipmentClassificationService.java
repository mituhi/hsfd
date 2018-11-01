package com.qz.zframe.device.service;

import java.util.List;

import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.device.entity.EquipmentClassification;
import com.qz.zframe.device.entity.EquipmentClassificationExample;



public interface EquipmentClassificationService {
//查询设备分类
 public	PageResultEntity findEquipment(EquipmentClassificationExample equipment);

//新增设备分类
 public  ResultEntity  addEquipment(EquipmentClassification equipmentClassification);
 //修改设备分类
 public   ResultEntity  updateEquipment(EquipmentClassification equipmentClassification);
  //删除设备分类
 public   ResultEntity  deleteEquipment(String equipmentId);
 //查询设备分类详情
 public  PageResultEntity  findByEquipmentId(String equipmentId);
 //批量删除设备分类
 public   ResultEntity  deleteEquipments(List<String> equipmentIds);
 // 查询设备分类结构顶层
 public   PageResultEntity  findStructure();
//查询设备分类结构底层
public   PageResultEntity  findStructureList(String superiorEquipment);
}
