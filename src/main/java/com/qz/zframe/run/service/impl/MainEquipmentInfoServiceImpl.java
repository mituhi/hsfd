package com.qz.zframe.run.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qz.zframe.common.util.BaseResultEntity;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.device.dao.EquipmentAssetLedgerMapper;
import com.qz.zframe.device.entity.EquipmentAssetLedger;
import com.qz.zframe.device.entity.EquipmentAssetLedgerExample;
import com.qz.zframe.run.dao.MainEquipmentInfoMapper;
import com.qz.zframe.run.entity.DeviceAssociationExample;
import com.qz.zframe.run.entity.MainEquipmentInfo;
import com.qz.zframe.run.entity.MainEquipmentInfoExample;
import com.qz.zframe.run.service.MainEquipmentInfoService;


/**
 * <p>Title: MainEquipmentInfoServiceImpl</p>
 * <p>@Description:  </p>
 * @author 
 * @date 2018年11月9日 上午11:47:23
 * @version:V1.0
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class MainEquipmentInfoServiceImpl implements MainEquipmentInfoService {

	
	@Autowired
	private MainEquipmentInfoMapper mainEquipmentInfoMapper;
	@Autowired
	private EquipmentAssetLedgerMapper assetLedgerMapper;
	
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
		
		//插入之前先查找是否存在相同的编号
		MainEquipmentInfoExample example = new MainEquipmentInfoExample();
		example.createCriteria().andDeviceCodeEqualTo(equipmentInfo.getDeviceCode());
		
		List<MainEquipmentInfo> list = mainEquipmentInfoMapper.selectByExample(example);
		//没有允许插入
		if(list.size() == 0){
			//执行插入操作
			mainEquipmentInfoMapper.insert(equipmentInfo);
		}else{
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("物资编码"+equipmentInfo.getDeviceCode()+"重复");
		}
		
		
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("执行成功");
		return resultEntity;
	}


	/**
	 * 通过id获取信息
	 */
	@Override
	public MainEquipmentInfo getMainEquipmentInfoById(String mainEquipmentInfoId) {
		return mainEquipmentInfoMapper.selectByPrimaryKey(mainEquipmentInfoId);
	}


	/**
	 * 更新
	 */
	@Override
	public ResultEntity updateMainEquipmentInfo(MainEquipmentInfo mainEquipmentInfo) {
		
		ResultEntity resultEntity = new ResultEntity();
		
		mainEquipmentInfoMapper.updateByPrimaryKeySelective(mainEquipmentInfo);
		
		resultEntity .setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("执行成功");
		return resultEntity;
	}


	@Override
	public void deleteByExample(MainEquipmentInfoExample example) {
		/**
		 * 通过example删除
		 */
		mainEquipmentInfoMapper.deleteByExample(example);
		}
		
	}


/*	@Override
	public PageResultEntity selectByWindId(EquipmentAssetLedgerExample assetLedgerExample) {
		PageResultEntity resultEntity = new PageResultEntity();
		int count = assetLedgerMapper.countByExample(assetLedgerExample);
		resultEntity.setTotal(count);
		List<EquipmentAssetLedger> list;
		if (count == 0) {
			list = Collections.emptyList();
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("查询结果为空");
			resultEntity.setRows(list);
			return resultEntity;
		} else {
			list = assetLedgerMapper.selectByExample(assetLedgerExample);
		}
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("设备资产台账信息查询成功");
		resultEntity.setRows(list);
		return resultEntity;
	}*/


