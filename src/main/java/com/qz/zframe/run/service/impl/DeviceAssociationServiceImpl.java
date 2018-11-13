package com.qz.zframe.run.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.run.dao.DeviceAssociationMapper;
import com.qz.zframe.run.dao.DeviceTypeMapper;
import com.qz.zframe.run.dao.LogTypeMapper;
import com.qz.zframe.run.dao.MainEquipmentInfoMapper;
import com.qz.zframe.run.dao.MainEquipmentMapper;
import com.qz.zframe.run.entity.DeviceAssociation;
import com.qz.zframe.run.entity.DeviceAssociationExample;
import com.qz.zframe.run.entity.LogType;
import com.qz.zframe.run.entity.LogTypeExample;
import com.qz.zframe.run.entity.MainEquipment;
import com.qz.zframe.run.entity.result.DeviceAssociationResult;
import com.qz.zframe.run.service.DeviceAssociationService;


/**
 * <p>Title: DeviceAssociationServiceImpl</p>
 * <p>@Description: 设备关联表接口实现 </p>
 * @author 陈汇奇
 * @date 2018年11月9日 下午1:08:55
 * @version:V1.0
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class DeviceAssociationServiceImpl implements DeviceAssociationService {

	@Autowired
	private DeviceAssociationMapper deviceAssociationMapper;
	
	@Autowired
	private MainEquipmentMapper mainEquipmentMapper;
	
	@Autowired
	private MainEquipmentInfoMapper mainEquipmentInfoMapper;
	
	@Autowired
	private LogTypeMapper logTypeMapper;
	
	@Override
	public ResultEntity saveDeviceAssociation(DeviceAssociation deviceAssociation) {
		
		ResultEntity resultEntity = new ResultEntity();
		
		//设置id
		deviceAssociation.setDeviceAssociationId(UUID.randomUUID().toString());
		
		//执行插入
		deviceAssociationMapper.insert(deviceAssociation);
		
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("执行成功");
		return resultEntity;
	}

	@Override
	public ResultEntity deleteDeviceAssociationById(String deviceAssociationId) {
		
		ResultEntity resultEntity = new ResultEntity();
		
		//先查询出其他id
		DeviceAssociation deviceAssociation = deviceAssociationMapper.selectByPrimaryKey(deviceAssociationId);
		
		//获取主设备表id
		String mainEquipmentId = deviceAssociation.getMainEquipmentId();
		//删除
		mainEquipmentMapper.deleteByPrimaryKey(mainEquipmentId);
		
		//获取主设备信息表id
		String mainEquipmentInfoId = deviceAssociation.getMainEquipmentInfoId();
		//删除
		mainEquipmentInfoMapper.deleteByPrimaryKey(mainEquipmentInfoId);
		
		//执行删除
		deviceAssociationMapper.deleteByPrimaryKey(deviceAssociationId);
		
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("执行成功");
		return resultEntity;
	}

	
	/**
	 * 批量查询
	 */
	@Override
	public PageResultEntity listDeviceAssociation(MainEquipment mainEquipment, int pageNo, int pageSize) {
		
		//创建返回对象
		PageResultEntity pageResultEntity = new PageResultEntity();
		//返回对象数据
		List<DeviceAssociationResult> result = new ArrayList<DeviceAssociationResult>();

		if(pageNo != 0 && pageSize!= 0){
			PageHelper.startPage(pageNo, pageSize);
			//查询
			List<DeviceAssociationResult> list = deviceAssociationMapper.listDeviceAssociationResult(mainEquipment);
			//进行封装：封装的依据是如果主设备id一致，则设备累计
			for (DeviceAssociationResult deviceAssociationResult : list) {
				
				//返回结果中不为空就进行比较主设备id
				if(CollectionUtils.isNotEmpty(result)){
					//设置一个flag=true，表示默认result集合中没有该元素
					boolean flag = true;
					//循环比较主设备id
					for (DeviceAssociationResult deviceAssociationResultTemp : result) {
						//如果主设备id相同
						if(deviceAssociationResult.getMainEquipmentId().equals(deviceAssociationResultTemp.getMainEquipmentId())){
							flag = false;
							//数量+1	//java.lang.NullPointerException: null at com.qz.zframe.run.service.impl.DeviceAssociationServiceImpl.listDeviceAssociation(DeviceAssociationServiceImpl.java:119)
							deviceAssociationResultTemp.setCount(deviceAssociationResultTemp.getCount()+1);
							break;
						}
						//执行到这里:
						if(flag){
							//如果为false假，说明找到了一样的，如果为真，说明没有找到：没有找到就添加到集合中
							//初始化数量
							deviceAssociationResult.setCount(1);
							result.add(deviceAssociationResult);
							break;
						}
					}
					
				}else{
					//为空，添加到集合中
					//初始化数量
					deviceAssociationResult.setCount(1);
					result.add(deviceAssociationResult);
				}
				
			}
			
		}
		pageResultEntity.setCode(ErrorCode.SUCCESS);
		pageResultEntity.setRows(result);
		pageResultEntity.setTotal(result.size());
		pageResultEntity.setMsg("执行成功");
		return pageResultEntity;
	}

	@Override
	public ResultEntity getDeviceAssociationResultById(String deviceAssociationId) {
		
		ResultEntity resultEntity = new ResultEntity();
		//声明返回对象
		DeviceAssociationResult deviceAssociationResult = new DeviceAssociationResult();
		
		//获取关联表对象
		DeviceAssociation deviceAssociation = deviceAssociationMapper.selectByPrimaryKey(deviceAssociationId);
		
		//获取主设备id
		String mainEquipmentId = deviceAssociation.getMainEquipmentId();
		//通过主设备id查询对象
		MainEquipment mainEquipment = mainEquipmentMapper.selectByPrimaryKey(mainEquipmentId);
		
		//查找设备数量
		DeviceAssociationExample example = new DeviceAssociationExample();
		example.createCriteria().andMainEquipmentIdEqualTo(mainEquipmentId);
		
		//执行查询
		List<DeviceAssociation> list = deviceAssociationMapper.selectByExample(example);

		
		//设置id
		deviceAssociationResult.setDeviceAssociationId(deviceAssociationId);
		deviceAssociationResult.setMainEquipmentId(mainEquipmentId);
		//设置部门
		deviceAssociationResult.setDepartment(mainEquipment.getDepartment());
		//设置日志类型
		deviceAssociationResult.setLogType(mainEquipment.getLogType());
		//设置日志名称
		deviceAssociationResult.setLogName(mainEquipment.getLogName());
		//设置数量
		deviceAssociationResult.setCount(list.size());

		
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("执行成功");
		resultEntity.setData(deviceAssociationResult);
		return resultEntity;
	}

	
	/**
	 * 更新
	 */
	@Override
	public ResultEntity editDeviceAssociation(DeviceAssociationResult deviceAssociationResult) {
		
		ResultEntity resultEntity = new ResultEntity();
		
		LogTypeExample example = new LogTypeExample();
		example.createCriteria().andLogTypeEqualTo(deviceAssociationResult.getLogType());
		
		//查询是否存在改日志类型
		List<LogType> list = logTypeMapper.selectByExample(example);
		if(list!=null && list.size()>=0){
			//允许修改改日志
			
			MainEquipment mainEquipment = new MainEquipment();
			mainEquipment.setMainEquipmentId(deviceAssociationResult.getMainEquipmentId());
			mainEquipment.setDepartment(deviceAssociationResult.getDepartment());
			mainEquipment.setLogType(deviceAssociationResult.getLogType());
			mainEquipment.setLogName(deviceAssociationResult.getLogName());
			
			mainEquipmentMapper.updateByPrimaryKeySelective(mainEquipment);
			resultEntity.setCode(ErrorCode.SUCCESS);
			resultEntity.setMsg("执行成功");
			return resultEntity;
		}else{
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("没有该类型的日志");
			return resultEntity;
		}
		
		
	}

}
