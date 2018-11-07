package com.qz.zframe.device.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.device.dao.EquipmentClassificationMapper;
import com.qz.zframe.device.entity.EquipmentClassification;
import com.qz.zframe.device.entity.EquipmentClassificationExample;
import com.qz.zframe.device.service.EquipmentClassificationService;
@Service
@Transactional(rollbackFor = Exception.class)
public class EquipmentClassificationServiceImpl implements EquipmentClassificationService {
	@Autowired
	private EquipmentClassificationMapper  equipmentMapper;

	@Override
	public PageResultEntity findEquipment(EquipmentClassificationExample equipment) {
		PageResultEntity resultEntity = new PageResultEntity();
		int count = equipmentMapper.countByExample(equipment);
		resultEntity.setTotal(count);
		List<EquipmentClassification> list;
		if (count == 0) {
			list = Collections.emptyList();
		} else {
			list = equipmentMapper.selectByExample(equipment);
		}
		resultEntity.setCode(0);
		resultEntity.setRows(list);     
		return resultEntity;
	}

	@Override
	public ResultEntity addEquipment(EquipmentClassification equipmentClassification) {
		ResultEntity resultEntity = new ResultEntity();
		String  equipmentId=UUID.randomUUID().toString();
		equipmentClassification.setEquipmentId(equipmentId);
		int save = equipmentMapper.insertSelective(equipmentClassification);
		if(save==0){
			resultEntity.setCode(-1);
			resultEntity.setMsg("新增失败");
		}else{
			resultEntity.setCode(0);
			resultEntity.setMsg("新增成功");
		}
		return resultEntity;
	}

	@Override
	public ResultEntity updateEquipment(EquipmentClassification equipmentClassification) {
		ResultEntity resultEntity = new ResultEntity();
		EquipmentClassification equipment=equipmentMapper.selectByPrimaryKey(equipmentClassification.getEquipmentId());
		if (equipment==null) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("数据源中没有这条数据");
		}else {
			int save=equipmentMapper.updateByPrimaryKey(equipmentClassification);
			if(save==0){
				resultEntity.setCode(-1);
				resultEntity.setMsg("修改失败");
			}else{
				resultEntity.setCode(0);
				resultEntity.setMsg("修改成功");
			}
		}
		return resultEntity;
	}

	@Override
	public ResultEntity deleteEquipment(String equipmentId) {
		ResultEntity resultEntity = new ResultEntity();
		int delete=equipmentMapper.deleteByPrimaryKey(equipmentId);
		if(delete<0){
			resultEntity.setCode(-1);
			resultEntity.setMsg("删除失败");
		}else{
			resultEntity.setCode(0);
			resultEntity.setMsg("删除成功");
		}
		return resultEntity;
	}

	@Override
	public PageResultEntity findByEquipmentId(String equipmentId) {
		PageResultEntity resultEntity=new PageResultEntity();
		//ResultEntity resultEntity = new ResultEntity();
		List<EquipmentClassification> list=new ArrayList<EquipmentClassification>();
		EquipmentClassification equipmentClassification = equipmentMapper.selectByPrimaryKey(equipmentId);
		if (equipmentClassification == null) {
			resultEntity.setCode(-1);
			resultEntity.setMsg("查询结果有误");
		} else {
			list.add(equipmentClassification);
			resultEntity.setCode(0);
			resultEntity.setRows(list); 
		}
		return resultEntity;
	}

	public ResultEntity deleteEquipments(List<String> equipmentIds) {
		ResultEntity resultEntity = new ResultEntity();
			int delete=equipmentMapper.deleteByPrimaryKeyList(equipmentIds);
			if(delete<0){
				resultEntity.setCode(-1);
				resultEntity.setMsg("删除失败");
			}else{
				resultEntity.setCode(0);
				resultEntity.setMsg("删除成功");
			}
		return resultEntity;
	}

	@Override
	public PageResultEntity findStructure() {
		PageResultEntity  resultEntity=new PageResultEntity();
		
		List<EquipmentClassification> top=equipmentMapper.selectStructure();
		if (top==null) {
			resultEntity.setCode(-1);
			resultEntity.setMsg("还未创建顶层设备分类");
		}else {
			resultEntity.setCode(0);
			resultEntity.setRows(top);    
		}
		return resultEntity;
	}

	@Override
	public PageResultEntity findStructureList(String superiorEquipment) {
		PageResultEntity  resultEntity=new PageResultEntity();
		
		List<EquipmentClassification> list=equipmentMapper.selectStructureList(superiorEquipment);
		if (list!=null) {
			resultEntity.setCode(0);
			resultEntity.setRows(list);     
		}else {
			resultEntity.setCode(-1);
			resultEntity.setMsg("还未创建设备分类");
		}
		return resultEntity;
	}

}
	
	
