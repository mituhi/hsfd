package com.qz.zframe.run.service.impl;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.run.dao.DeviceTypeMapper;
import com.qz.zframe.run.entity.DeviceType;
import com.qz.zframe.run.entity.DeviceTypeExample;
import com.qz.zframe.run.service.DeviceTypeService;

/**
 * <p>Title: DeviceTypeServiceImpl</p>
 * <p>@Description: 设备类型状态表接口实现 </p>
 * @author 
 * @date 2018年11月6日 下午4:30:26
 * @version:V1.0
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class DeviceTypeServiceImpl implements DeviceTypeService {

	@Autowired
	private DeviceTypeMapper deviceTypeMapper;
	
	
	/**
	 * 添加操作
	 */
	@Override
	public ResultEntity saveDeviceType(DeviceType deviceType) {
		ResultEntity resultEntity = new ResultEntity();
		
		//通过类型和状态查询：（不能存在类型和状态相同）
		DeviceTypeExample example = new DeviceTypeExample();
		example.createCriteria().andDeviceTypeEqualTo(deviceType.getDeviceType())
								.andDeviceStatusEqualTo(deviceType.getDeviceStatus());
		List<DeviceType> list = deviceTypeMapper.selectByExample(example);
		
		if(list!=null && list.size()>0){
			//如果在表中存在有改   类型和状态   返回错误
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("该设备类型已存在，请重新添加");
			return resultEntity;
		}
		
		
		
		//生成id
		deviceType.setTypeId(UUID.randomUUID().toString());
		//添加时间字段
		deviceType.setUpdateTime(new Date());
		//执行插入操作
		deviceTypeMapper.insertSelective(deviceType);
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("信息已保存");
		return resultEntity;
		
	}


	@Override
	public ResultEntity getMaxSort() {
		ResultEntity resultEntity = new ResultEntity();
		//设置初始值为0
		int sort = 0 ;
		try {
			 DeviceType deviceType = deviceTypeMapper.selectMaxSort();
			 sort = deviceType.getSort();
		} catch (Exception e) {
			//捕获异常：则为系统第一次录入返回1
		}
		resultEntity.setMsg((sort+1)+"");
		resultEntity.setCode(ErrorCode.SUCCESS);
		return resultEntity;
	}


	/**
	 * 根据主键删除
	 */
	@Override
	public void removeDeviceTypeById(List<String> typeIds) {
		DeviceTypeExample deviceTypeExample = new DeviceTypeExample();
		deviceTypeExample.createCriteria().andTypeIdIn(typeIds);
		deviceTypeMapper.deleteByExample(deviceTypeExample);
	}


	/**
	 * 批量获取
	 */
	@Override
	public List<DeviceType> listDeviceType(DeviceTypeExample example, int pageNo, int pageSize) {

		List<DeviceType> deviceTypes = Collections.emptyList();

		if (pageNo != 0 && pageSize != 0) {
			PageHelper.startPage(pageNo, pageSize);
			// 查出记录
			deviceTypes = deviceTypeMapper.selectByExample(example);
		}else{
			deviceTypes = deviceTypeMapper.selectByExample(example);
		}
		return deviceTypes;
	}

	@Override
	public List<DeviceType> distinctListDeviceType() {

		List<DeviceType> deviceTypes = deviceTypeMapper.getDistinctDeviceTypeList();

		return deviceTypes;
	}

	/**
	 * 根据主键进行修改
	 */
	@Override
	public void editDeviceTypeById(DeviceType deviceType) {
		
		deviceType.setUpdateTime(new Date());
		//设置sort不允许修改
		deviceType.setSort(null);
		//执行修改操作
		deviceTypeMapper.updateByPrimaryKeySelective(deviceType);
	
	}

}
