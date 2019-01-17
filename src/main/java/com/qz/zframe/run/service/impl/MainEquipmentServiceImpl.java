package com.qz.zframe.run.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.device.entity.CrewInformation;
import com.qz.zframe.run.dao.DeviceAssociationMapper;
import com.qz.zframe.run.dao.MainEquipmentInfoMapper;
import com.qz.zframe.run.dao.MainEquipmentMapper;
import com.qz.zframe.run.entity.DeviceAssociation;
import com.qz.zframe.run.entity.LogType;
import com.qz.zframe.run.entity.LogTypeExample;
import com.qz.zframe.run.entity.MainEquipment;
import com.qz.zframe.run.entity.MainEquipmentExample;
import com.qz.zframe.run.entity.MainEquipmentInfo;
import com.qz.zframe.run.entity.submit.MainEquipmentSubmit;
import com.qz.zframe.run.service.LogTypeService;
import com.qz.zframe.run.service.MainEquipmentService;

@Service
@Transactional(rollbackFor=Exception.class)
public class MainEquipmentServiceImpl implements MainEquipmentService {

	@Autowired
	private MainEquipmentMapper mainEquipmentMapper;
	@Autowired
	private  MainEquipmentInfoMapper  mainEquipmentInfoMapper;
	@Autowired
	private DeviceAssociationMapper deviceAssociationMapper;
	@Autowired
	private LogTypeService logTypeService;
	/**
	 * 保存操作
	 */
	@Override
	public ResultEntity saveMainEquipment(MainEquipment mainEquipment) {
		
		ResultEntity resultEntity = new ResultEntity();
		if(mainEquipment!=null) {
			String mainEquipmentId=UUID.randomUUID().toString();
			mainEquipment.setMainEquipmentId(mainEquipmentId);
			LogTypeExample example = new LogTypeExample();
			example.createCriteria().andLogTypeIdEqualTo(mainEquipment.getLogTypeId());
			//根据日志id获取日志的编码和code
			List<LogType> logType = logTypeService.listLogType(example);
			if(logType!=null && !logType.isEmpty()) {
			mainEquipment.setLogType(logType.get(0).getLogCode());
			mainEquipment.setLogName(logType.get(0).getLogName());
			}else {
			  mainEquipment.setLogTypeId(null);
			  mainEquipment.setLogType(null);
			  mainEquipment.setLogName(null);
			}
		 int save=mainEquipmentMapper.insert(mainEquipment);
		 if(save==0) {
			 resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("添加失败");
				return resultEntity; 
		 }
		 //主设备信息
		 List<MainEquipmentInfo> mainEquipmentInfo=new ArrayList<MainEquipmentInfo>();
		 mainEquipmentInfo= mainEquipment.getMainEquipmentInfo();
		 DeviceAssociation  deviceAssociation=new DeviceAssociation();
		 if(mainEquipmentInfo!=null) {
			 for(MainEquipmentInfo info:mainEquipmentInfo) {
				 //添加主设备信息
				 String mainEquipmentInfoId=UUID.randomUUID().toString();
				 info.setMainEquipmentInfoId(mainEquipmentInfoId);
				 mainEquipmentInfoMapper.insert(info) ;
				 //添加关联表
				 deviceAssociation=new DeviceAssociation();
				 deviceAssociation.setDeviceAssociationId(UUID.randomUUID().toString());
				 deviceAssociation.setDeviceTypeId(info.getDeviceType());
				 deviceAssociation.setMainEquipmentInfoId(mainEquipmentInfoId);
				 deviceAssociation.setMainEquipmentId(mainEquipmentId);
				 deviceAssociationMapper.insert(deviceAssociation);
			 } 
		 }
		}else {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("添加失败,没有数据进行添加");
			return resultEntity;
		}
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("执行成功");
		return resultEntity;
	}


	/**
	 * 批量获取主设备
	 */
	@Override
	public PageResultEntity listMainEquipments(MainEquipmentExample equipmentExample) {
		PageResultEntity resultEntity=new PageResultEntity();
		int  count=mainEquipmentMapper.countByExample(equipmentExample);
		resultEntity.setTotal(count);
		List<MainEquipment> list;	
		if (count == 0) {
			list = Collections.emptyList();
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("查询结果为空");
			resultEntity.setRows(list);
			return resultEntity;
		} else {
			list =mainEquipmentMapper.selectByExample(equipmentExample);
			if(list!=null && !list.isEmpty()) {
				for(MainEquipment m:list) {
				List<DeviceAssociation>	 deviceAssociation=deviceAssociationMapper.selectByMainEquipmentId(m.getMainEquipmentId());	
				if(deviceAssociation!=null && !deviceAssociation.isEmpty()) {
					m.setCount(deviceAssociation.size());
				}else {
					m.setCount(0);
				}
				}
			}
			resultEntity.setCode(ErrorCode.SUCCESS);
			resultEntity.setRows(list);
			resultEntity.setMsg("查询成功!");
		}
		return resultEntity;

	}


	/**
	 * 通过id获取信息
	 */
	@Override
	public PageResultEntity getMainEquipmentById(String mainEquipmentId) {
		PageResultEntity  resultEntity =new PageResultEntity ();
		List<MainEquipment> list=new ArrayList<MainEquipment>();
		if(StringUtils.isNotBlank(mainEquipmentId)) {
			MainEquipment mainEquipment	=mainEquipmentMapper.selectByPrimaryKey(mainEquipmentId);
			if(mainEquipment!=null) {
			List<DeviceAssociation>	 deviceAssociation=deviceAssociationMapper.selectByMainEquipmentId(mainEquipmentId);
			if(deviceAssociation!=null && !deviceAssociation.isEmpty()) {
				mainEquipment.setCount(deviceAssociation.size());
				List<MainEquipmentInfo> mainEquipmentInfo=new ArrayList<MainEquipmentInfo>();
				MainEquipmentInfo	mainEquipmentInfos=new MainEquipmentInfo();
				for(DeviceAssociation device:deviceAssociation) {
					mainEquipmentInfos=new MainEquipmentInfo();
					mainEquipmentInfos=	mainEquipmentInfoMapper.selectByPrimaryKey(device.getMainEquipmentInfoId());
					mainEquipmentInfo.add(mainEquipmentInfos);
				}
				mainEquipment.setMainEquipmentInfo(mainEquipmentInfo);
			}else {
				mainEquipment.setCount(0);
			}
				list.add(mainEquipment);
			}else {
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("查询数据为空");
				return resultEntity;
			}
			
		}else {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("根据id查询数据,id为空");
			return resultEntity;
		}
		
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("查询成功");
		resultEntity.setRows(list);
		return resultEntity;
	}


	/**
	 * 更新主设备
	 */
	@Override
	public ResultEntity updateMainEquipment(MainEquipment mainEquipment) {
		ResultEntity resultEntity = new ResultEntity();
		if(mainEquipment!=null && StringUtils.isNotBlank(mainEquipment.getMainEquipmentId())) {
			MainEquipment  main=mainEquipmentMapper.selectByPrimaryKey(mainEquipment.getMainEquipmentId());
			if(main!=null) {
			List<DeviceAssociation>	 device=deviceAssociationMapper.selectByMainEquipmentId(mainEquipment.getMainEquipmentId());
			List<String> deviceId=new ArrayList<String>();
			List<String> mainEquipmentInfoIds=new ArrayList<String>();
			if(device!=null && !device.isEmpty()) {
				for(DeviceAssociation d:device) {
					deviceId.add(d.getDeviceAssociationId());
					mainEquipmentInfoIds.add(d.getMainEquipmentInfoId());
				}
				mainEquipmentInfoMapper.deleteByPrimaryKey(mainEquipmentInfoIds);
				deviceAssociationMapper.deleteByPrimaryKey(deviceId);
			}
			LogTypeExample example = new LogTypeExample();
			example.createCriteria().andLogTypeIdEqualTo(mainEquipment.getLogTypeId());
			//执行查询
			List<LogType> logType = logTypeService.listLogType(example);
			if(logType!=null && !logType.isEmpty()) {
			mainEquipment.setLogType(logType.get(0).getLogCode());
			mainEquipment.setLogName(logType.get(0).getLogName());
			}else {
			  mainEquipment.setLogTypeId(null);
			  mainEquipment.setLogType(null);
			  mainEquipment.setLogName(null);
			}
			//主设备信息
			 List<MainEquipmentInfo> mainEquipmentInfo=new ArrayList<MainEquipmentInfo>();
			 mainEquipmentInfo= mainEquipment.getMainEquipmentInfo();
			 DeviceAssociation  deviceAssociation=new DeviceAssociation();
			 if(mainEquipmentInfo!=null) {
				 for(MainEquipmentInfo info:mainEquipmentInfo) {
					 String mainEquipmentInfoId=UUID.randomUUID().toString();
					 info.setMainEquipmentInfoId(mainEquipmentInfoId);
					 mainEquipmentInfoMapper.insert(info) ;
					 deviceAssociation=new DeviceAssociation();
					 deviceAssociation.setDeviceAssociationId(UUID.randomUUID().toString());
					 deviceAssociation.setDeviceTypeId(info.getDeviceType());
					 deviceAssociation.setMainEquipmentInfoId(mainEquipmentInfoId);
					 deviceAssociation.setMainEquipmentId(mainEquipment.getMainEquipmentId());
					 deviceAssociationMapper.insert(deviceAssociation);
				 } 
			 }
			
			}else {
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("数据源中没有这条数据");
				return resultEntity;	
			}
			int save=	mainEquipmentMapper.updateByPrimaryKeySelective(mainEquipment);
			if(save==0) {
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("修改失败");
				return resultEntity;
			}else {
				resultEntity.setCode(ErrorCode.SUCCESS);
				resultEntity.setMsg("修改成功");
			}
			
		}else {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("编辑数据为空或者编辑数据id为空");
			return resultEntity;
		}
		
	
		return resultEntity;
		
		
	}


	@Override
	@Transactional
	public ResultEntity delete(List<String> mainEquipmentIds) {
		ResultEntity resultEntity=new ResultEntity();
		if(mainEquipmentIds!=null && !mainEquipmentIds.isEmpty()) {
			for(String ids:mainEquipmentIds) {
			//关联表
			List<DeviceAssociation> device=	deviceAssociationMapper.selectByMainEquipmentId(ids);
			List<String> deviceId=new ArrayList<String>();
			List<String> mainEquipmentInfoIds=new ArrayList<String>();
			if(device!=null && !device.isEmpty()) {
				for(DeviceAssociation d:device) {
					deviceId.add(d.getDeviceAssociationId());
					mainEquipmentInfoIds.add(d.getMainEquipmentInfoId());
				}
				mainEquipmentInfoMapper.deleteByPrimaryKey(mainEquipmentInfoIds);
				deviceAssociationMapper.deleteByPrimaryKey(deviceId);
			}
				
			}
			int delete=mainEquipmentMapper.deleteByPrimaryKey(mainEquipmentIds);
			if(delete<=0) {
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("删除失败");
				return resultEntity;
			}else {
				resultEntity.setCode(ErrorCode.SUCCESS);
				resultEntity.setMsg("删除成功");
			}
			
		}else {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("id为空，没有选中删除的数据");
			return resultEntity;
		}
		return resultEntity;
	}

}
