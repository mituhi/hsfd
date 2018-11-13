package com.qz.zframe.run.service.impl;

import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.run.dao.MainEquipmentInfoMapper;
import com.qz.zframe.run.entity.MainEquipmentInfo;
import com.qz.zframe.run.service.MainEquipmentInfoService;


/**
 * <p>Title: MainEquipmentInfoServiceImpl</p>
 * <p>@Description:  </p>
 * @author 陈汇奇
 * @date 2018年11月9日 上午11:47:23
 * @version:V1.0
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class MainEquipmentInfoServiceImpl implements MainEquipmentInfoService {

	
	@Autowired
	private MainEquipmentInfoMapper mainEquipmentInfoMapper;
	
	
	/**
	 * 保存
	 */
	@Override
	public ResultEntity saveMainEquipmentInfo(MainEquipmentInfo equipmentInfo) {
		
		ResultEntity resultEntity = new ResultEntity();
		
		//如果没有id设置
		if(StringUtils.isEmpty(equipmentInfo.getMainEquipmentInfoId())){
			equipmentInfo.setMainEquipmentInfoId(UUID.randomUUID().toString());
		}
		
		//执行插入操作
		mainEquipmentInfoMapper.insert(equipmentInfo);
		
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("执行成功");
		return resultEntity;
	}

}
