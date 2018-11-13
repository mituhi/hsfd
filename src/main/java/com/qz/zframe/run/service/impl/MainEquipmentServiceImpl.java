package com.qz.zframe.run.service.impl;

import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.run.dao.MainEquipmentMapper;
import com.qz.zframe.run.entity.MainEquipment;
import com.qz.zframe.run.entity.MainEquipmentExample;
import com.qz.zframe.run.service.MainEquipmentService;

@Service
@Transactional(rollbackFor=Exception.class)
public class MainEquipmentServiceImpl implements MainEquipmentService {

	@Autowired
	private MainEquipmentMapper mainEquipmentMapper;
	
	
	/**
	 * 保存操作
	 */
	@Override
	public ResultEntity saveMainEquipment(MainEquipment mainEquipment) {
		
		ResultEntity resultEntity = new ResultEntity();
		
		//如果id为空，设置
		if(StringUtils.isBlank(mainEquipment.getMainEquipmentId())){
			mainEquipment.setMainEquipmentId(UUID.randomUUID().toString());
		}
		
		//执行插入操作
		mainEquipmentMapper.insert(mainEquipment);
		
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("执行成功");
		return resultEntity;
	}


	/**
	 * 批量获取
	 */
	@Override
	public List<MainEquipment> listMainEquipments(MainEquipmentExample equipmentExample) {
		return mainEquipmentMapper.selectByExample(equipmentExample);
	}

}
